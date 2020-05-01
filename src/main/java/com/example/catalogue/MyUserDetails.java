package com.example.catalogue;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

   
	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String userName;
    private String password;
   private List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.userName = user.getName();
        this.password = user.getPassword();
        this.id = user.getId() ;
    }

   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
