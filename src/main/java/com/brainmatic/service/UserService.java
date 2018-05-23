package com.brainmatic.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmatic.model.User;
import com.brainmatic.repository.UserRepo;

@Service("userService")
@Transactional
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public User register(User user) {
		return repo.save(user);
	}
	
	public User login(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}
}
