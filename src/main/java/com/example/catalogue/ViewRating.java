package com.example.catalogue;

import java.util.Set;

public class ViewRating {
	
	public ViewRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ViewRating(Integer userId, Set<Rating> ratings) {
		super();
		UserId = userId;
		this.ratings = ratings;
	}
	Integer UserId ;
	Set<Rating> ratings ;
	
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	
	public Set<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
	
	@Override
	public String toString() {
		return "ViewRating [UserId=" + UserId + ", ratings=" + ratings + "]";
	}

	
	

}
