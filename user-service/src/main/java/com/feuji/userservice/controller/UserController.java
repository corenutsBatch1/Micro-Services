package com.feuji.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.commonmodel.Role;
import com.feuji.commonmodel.User;
import com.feuji.userservice.dto.User2;
import com.feuji.userservice.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registerUser")
	public User registerUser(@RequestBody User2 user2) {
		user2.setUser(user2);
		var user = user2.getUser();

		if (user.getRole() == null) {
			user.setRole(Role.USER);
		}
		return userService.createUser(user);
	}

	@PostMapping(value = "/loginUser")
	public User loginUser(@RequestBody User2 user2) {
		user2.setUser(user2);
		var user = user2.getUser();

		return userService.userLogin(user);
	}

	@PutMapping(value = "/forgotpassword")
	public void forgotPassword(@RequestBody User2 user2) {
		user2.setUser(user2);
		var user = user2.getUser();
		userService.editUser(user);
	}

	@GetMapping(value = "/getUserById/{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}

	@PostMapping(value = "/getUserById")
	public User getUserById(@RequestBody User2 user2) {
		user2.setUser(user2);
		var user = user2.getUser();
		return userService.getUser(user);
	}

	@PostMapping(value = "/updateUser")
	public User updateUser(@RequestBody User2 user2) {
		user2.setUser(user2);
		var user = user2.getUser();
		return userService.updateUser(user);
	}

	@GetMapping(value = "/getallusers")
	public List<User> fetchAllUsers() {
		return userService.fetchAllUsers();
	}

}
