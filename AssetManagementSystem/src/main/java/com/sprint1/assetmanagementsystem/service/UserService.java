package com.sprint1.assetmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.User;

public interface UserService {
	public String createUser(User user) throws NotFoundException;

	public List<User> viewUser() throws NotFoundException;

	public String logOutService();

	public String loginService(int userId, String userPassword) throws NotFoundException;

	public User updateUser(User user);

	public Optional<User> findUserById(int userId) throws NotFoundException;

	public String delete(int userId) throws NotFoundException;

}
