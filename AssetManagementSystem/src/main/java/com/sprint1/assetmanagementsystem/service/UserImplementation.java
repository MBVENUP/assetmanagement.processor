package com.sprint1.assetmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.User;
import com.sprint1.assetmanagementsystem.repository.UserRepository;

@Service
public class UserImplementation implements UserService {

	Logger logger = org.slf4j.LoggerFactory.getLogger(UserImplementation.class);
	@Autowired
	UserRepository userRepository;

	@Override
	public String createUser(User user) throws NotFoundException {
		if (user != null) {
			userRepository.save(user);
			return "user Added Successfully";
		} else {
			throw new NotFoundException("Invalid user");
		}

	}

	public List<User> viewUser() throws NotFoundException {

		List<User> user = userRepository.findAll();
		if (!user.isEmpty()) {
			return user;
		} else {
			throw new NotFoundException("Add users");
		}

	}

	public String logOutService() {

		return "Logged Out Successfully";
	}

	public String loginService(int userId, String userPassword) throws NotFoundException {

		if (userRepository.existsById(userId)) {
			String password = userRepository.getPassword(userId);
			if (password.equals(userPassword)) {
				User user = userRepository.getById(userId);

				if (user.getRole().equalsIgnoreCase("user")) {

					logger.info("Logged in as User");
					return user.getRole();

				} else if (user.getRole().equalsIgnoreCase("Administrator")) {

					logger.info("Logged in as Administrator");
					return user.getRole();

				} else if (user.getRole().equalsIgnoreCase("Warehouse Manager")) {

					logger.info("Logged in as Warehouse Manager");
					return user.getRole();

				}

			} else {
				throw new NotFoundException("Incorrect UserId or User Password");
			}

		} else {
			throw new NotFoundException("You are not a registered user, please sign-in to continue");
		}
		return null;

	}

	@Override
	public User updateUser(User user) {
		if (userRepository.existsById(user.getUserId())) {
			return userRepository.save(user);
		} else {
			return null;
		}

	}

	@Override
	public Optional<User> findUserById(int userId) throws NotFoundException {
		if (userRepository.existsById(userId)) {
			return userRepository.findById(userId);
		} else {
			throw new NotFoundException("Invalid userId");
		}

	}

	@Override
	public String delete(int userId) throws NotFoundException {
		if (userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
			return "user deleted";
		} else {
			throw new NotFoundException("Invalid userId");
		}
	}
}
