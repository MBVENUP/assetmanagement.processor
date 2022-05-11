package com.sprint1.assetmanagementsystem.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.User;
import com.sprint1.assetmanagementsystem.repository.UserRepository;
import com.sprint1.assetmanagementsystem.service.UserService;

@SpringBootTest
class UserServiceTest {

	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepo;

	private User u1;

	@BeforeEach
	void setUp() {
		u1 = new User();
		u1.setUserId(1);
		u1.setUserName("Kishore N");
		u1.setRole("Administrator");
		u1.setUserPassword("Ki21$8848");

	}

	@Test
	void testCreateUser() throws NotFoundException {
		Mockito.when(userRepo.save(u1)).thenReturn(u1);
		assertThat(userService.createUser(u1)).isEqualTo("user Added Successfully");

	}

	@Test
	void testupdateUser() throws Exception {
		Mockito.when(userRepo.existsById(1)).thenReturn(true);
		Mockito.when(userRepo.save(u1)).thenReturn(u1);
		assertThat(userService.updateUser(u1)).isEqualTo(u1);
	}

	@Test
	void testFindUserById() throws NotFoundException {
		Optional<User> u2 = Optional.of(u1);
		Mockito.when(userRepo.findById(1)).thenReturn(u2);
		Mockito.when(userRepo.existsById(u1.getUserId())).thenReturn(true);
		assertThat(userService.findUserById(u1.getUserId())).isEqualTo(u2);
	}

	@Test
	void testDeleteUserById() throws NotFoundException {
		Mockito.when(userRepo.existsById(2)).thenReturn(true);
		assertThat(userService.delete(2)).isEqualTo("user deleted");
	}

	@Test
	void testViewUsers() throws NotFoundException {
		User u2 = new User();
		u2.setUserId(1);
		u2.setUserName("Kishore N");
		u2.setRole("Administrator");
		u2.setUserPassword("Ki21$8848");
		List<User> userList = new ArrayList<>();
		userList.add(u1);
		userList.add(u2);
		Mockito.when(userRepo.findAll()).thenReturn(userList);
		assertThat(userService.viewUser()).isEqualTo(userList);
	}

	@Test
	void testLoginService() throws NotFoundException {
		Mockito.when(userRepo.existsById(u1.getUserId())).thenReturn(true);
		Mockito.when(userRepo.getPassword(u1.getUserId())).thenReturn(u1.getUserPassword());
		Mockito.when(userRepo.getById(u1.getUserId())).thenReturn(u1);
		assertThat(userService.loginService(u1.getUserId(), u1.getUserPassword())).isEqualTo(u1.getRole());
	}

}
