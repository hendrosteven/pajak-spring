package com.brainmatic.repository;

import org.springframework.data.repository.CrudRepository;

import com.brainmatic.model.User;

public interface UserRepo extends CrudRepository<User, Long>{
	public User findByEmail(String email);
	public User findByEmailAndPassword(String email, String password);
}
