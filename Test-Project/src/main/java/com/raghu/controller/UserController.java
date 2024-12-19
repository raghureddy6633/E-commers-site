package com.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.entity.User;
import com.raghu.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public User createUser(@RequestBody User user) {
		log.info("user request obj " + user.getEmail());
		return userService.createUser(user);

	}

	@GetMapping("{userId}")
	public User fetchUser(@PathVariable long userId) {
		var result = userService.findUser(userId);
		log.info("result :" + result.getEmail());
		return result;
	}

	@PutMapping("{userId}")
	public User updateUser(@PathVariable long userId, @RequestBody User user) {

		var result = userService.updateUser(userId, user);
		log.info("result :" + result);
		return result;

	}

	@DeleteMapping("{userId}")
	public void deleteUser(@PathVariable long userId) {
		userService.deleteUser(userId);
	}
}
