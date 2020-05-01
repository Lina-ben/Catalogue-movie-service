package com.example.catalogue;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController 
@CrossOrigin(origins = "http://localhost:4200")
public class CatalogueService {
	
	
	@Autowired
	RestTemplate restTemplate ;
	
	@Autowired
	private RatingService ratingService;



	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Error")  
  	@ExceptionHandler(Exception.class)
  	public void error() {
  	}
	
	UserRepo userRepo;

	@Autowired
	public CatalogueService(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
		}
	
	
	@RequestMapping({ "/" })
	@ResponseStatus( HttpStatus.OK )
	public String validateLogin() {
		return "Authenticated" ;
	}
	
	
        @RequestMapping(value = "/register",method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.OK) 
	    public String Register(@RequestBody User user) throws DataIntegrityViolationException {
        	try {
        	
            if(user.getPassword().equals(user.getConfirm())) {
		 
	         userRepo.save(user);
	         restTemplate.postForEntity("http://rating-service/add/user" , user.getId(), void.class); 
	         return "You've been registerd" ;
        	}
        	else
        		return "Wrong password confirmation" ;
            
        	}
        	
        	catch(DataIntegrityViolationException e)
        	{
        		return "Username already exists";
        	}
			    
	    }
        	
        		
	   @RequestMapping(value = "/list", method = RequestMethod.GET)
	   @HystrixCommand(fallbackMethod = "getFallbackCatalogItems")
	   public ResponseEntity<?>  getMoviesRating(@RequestParam(value="userId", required=true) Integer userId){
	        
			
		 ViewRating userRatings = ratingService.getUserRating(userId) ;
		 Set<Rating> list = userRatings.getRatings() ;
		 
		 return ResponseEntity.status(HttpStatus.OK)
			        .body( list.stream().map(Rating->{ 
						
						Movie movie = restTemplate.getForObject("http://movie-service/" + Rating.getMovieId(), Movie.class);
						
						return new RatingCatalogue(movie.getTitle(), 
								movie.getDesc(), Rating.getRating()) ;
					})
				    .collect(Collectors.toSet())); 
		
}
	

	@RequestMapping(value ="/add", method = RequestMethod.POST)
	@ResponseBody
	public String addrating(@RequestBody Rating rating, @RequestParam(value="userId", required=true) Integer userId) throws Exception   {
		
	
		restTemplate.postForEntity("http://rating-service/add/rating?userid=" + userId, rating, Rating.class);	
		return "Success" ;
		

	}
	
	
	 
		public ResponseEntity<?> getFallbackCatalogItems(Integer userId) {
			return ResponseEntity.status(HttpStatus.OK)
			        .body(Stream.of(new RatingCatalogue("Fallback movie", 
					"Fallback movie Description", 0)).collect(Collectors.toSet()));
					}
		
	
	
	
	
	

	
	

}
	
	
	

