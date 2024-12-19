package com.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghu.entity.User;
import com.raghu.exceptionhandling.ResourceNotFoundException;
import com.raghu.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);

	}

	public User updateUser(long userId, User inputUser) {

		return userRepository.findById(userId).map(user -> {
			user.setEmail(inputUser.getEmail());
			user.setPassword(inputUser.getPassword());
			user.setUsername(inputUser.getUsername());
			return userRepository.save(user);
		}).orElseThrow(() -> new ResourceNotFoundException("User not Found With user id :" + userId));

	}

	public User findUser(long userId) {

		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found with User Id :" + userId));

	}

	public void deleteUser(long userId) {
		userRepository.deleteById(userId);
		log.info("User Deletion is Success");
	}

}
