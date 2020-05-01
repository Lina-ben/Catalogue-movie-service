package com.example.catalogue;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	Optional<User> findByName(String name);

	
	
	
}