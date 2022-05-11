package com.sprint1.assetmanagementsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.User;
import com.sprint1.assetmanagementsystem.service.UserImplementation;

@RestController(value = "/user")
@CrossOrigin
public class UserController {
	@Autowired
	UserImplementation userImplementaion;

	// Creating User
	@PostMapping(path = "/createUser")
	public String createUser(@RequestBody User user) throws NotFoundException {
		userImplementaion.createUser(user);
		return "User Added Succesfully";
	}

	// View User
	@GetMapping(path = "/viewUser")
	public List<User> viewUser() throws NotFoundException {
		return userImplementaion.viewUser();
	}

	// Signing Up
	@PostMapping(path = "/SignUp")
	public String signUp(@RequestBody User user) throws NotFoundException {
		userImplementaion.createUser(user);
		return (user.getUserId() + " SignedUp successfully");
	}

	// Logging Out
	@GetMapping(path = "/logOut")
	public String logOut() {
		return userImplementaion.logOutService();
	}

	// Login In
	@GetMapping(path = "/login/{userId}/{userpassword}")
	public String loginService(@PathVariable int userId, @PathVariable String userpassword) throws NotFoundException {

		return userImplementaion.loginService(userId, userpassword);

	}

	// update User role
	@PutMapping(path = "/updateUser")
	public String updateUserRole(@RequestBody User user) {

		User u = userImplementaion.updateUser(user);
		if (u == null) {
			return "user Not Updated";
		}
		return "user is updated successfully";

	}

	// find user by id
	@GetMapping(path = "/findUser/{userId}")
	public Optional<User> findUserById(@PathVariable int userId) throws NotFoundException {
		return userImplementaion.findUserById(userId);

	}

	// delete
	@DeleteMapping(path = "/delete/{userId}")
	public String deleteUser(@PathVariable int userId) throws NotFoundException {
		return userImplementaion.delete(userId);
	}

}
