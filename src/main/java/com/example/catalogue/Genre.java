package com.example.catalogue;



public class Genre {
	
	 
   
    public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String name;

	public Genre(String name) {
		super();
		this.name = name;
	}

  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

	@Override
	public String toString() {
		return "Genre [name=" + name + "]";
	}
    

}

