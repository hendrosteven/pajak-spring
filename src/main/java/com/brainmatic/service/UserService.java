package com.brainmatic.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.brainmatic.model.User;
import com.brainmatic.repository.UserRepo;

@Service("userService")
@Transactional
public class UserService {

	@Autowired
	private UserRepo repo;
	
	public User register(User user) {
		if(repo.findByEmail(user.getEmail())==null) {
			String hash = DigestUtils
				.md5DigestAsHex(user.getPassword().getBytes());
			user.setPassword(hash);
			return repo.save(user);
		}else {
			return null;
		}
	}
	
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public void removeUser(User user) {
		repo.delete(user);
	}
	
	public User login(String email, String password) {
		String hash = DigestUtils
				.md5DigestAsHex(password.getBytes());
		return repo.findByEmailAndPassword(email, hash);
	}
}
