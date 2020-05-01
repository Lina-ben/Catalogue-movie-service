package com.example.catalogue;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.example.catalogue.Rating;
import com.example.catalogue.ViewRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@Service
public class RatingService {
	
	
	@Autowired
	private RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(RatingService.class);

    @HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public  ViewRating getUserRating(Integer userId) {

		LOGGER.info("User userId " + userId);
		ViewRating viewRating = restTemplate.getForObject("http://rating-service/" + userId, ViewRating.class);
		return viewRating;
	}

	
	public ViewRating getFallbackUserRating(@PathVariable("userId") Integer userId) {
		return new ViewRating(userId, Stream.of(new Rating(0, 0)).collect(Collectors.toSet()));
	}

}
