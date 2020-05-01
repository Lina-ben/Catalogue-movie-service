package com.example.catalogue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   
    @Column(unique = true)
    @NotNull
    private String name;
 
    @NotNull
    private String password;
    
    @NotNull
	private String  confirm ;
    

    
   
    
  
    public User() {
     super();
    }


	public User(Integer id, String name, String password, String passwordConfirm, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.confirm = passwordConfirm;
	
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	 
    public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", PasswordConfirm=" + confirm
				+ "]";
	}







	
}