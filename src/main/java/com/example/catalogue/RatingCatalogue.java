package com.example.catalogue;

public class RatingCatalogue {

	
	String name ;
	String desc ;
	float rating ;
	
	

	public RatingCatalogue() {
		super();
		// TODO Auto-generated constructor stub
	}



	public RatingCatalogue(String name, String desc, float rating) {
		super();
		this.name = name;
		this.desc = desc;
		this.rating = rating;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}



	public float getRating() {
		return rating;
	}



	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
	@Override
	public String toString() {
		return "RatingCatalogue [name=" + name + ", desc=" + desc + ", rating=" + rating + "]";
	}



	
	
	
	
}
