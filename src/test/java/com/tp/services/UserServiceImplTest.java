package com.tp.services;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tp.entities.Role;
import com.tp.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserServiceImplTest {
	private static final Logger l = LogManager.getLogger(UserServiceImplTest.class);


	@Autowired
	IUserService us;
	
	private static User testCaseUser = new User("Firas", "Soltani", new Date(1996, 9, 22), Role.INGENIEUR);;

	@Test
	@Order(1)
	void isConnectingtoDb() {
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertNotNull(listUsers);

	}

	@Test
	@Order(2)
	void addUser() {
		User user = us.addUser(UserServiceImplTest.testCaseUser);
		Assertions.assertNotNull(user);
		UserServiceImplTest.testCaseUser.setId(user.getId());
	}
	
	@Test
	@Order(3)
	void retrieveUser() {
		l.info(UserServiceImplTest.testCaseUser);
		User user = us.retrieveUser(UserServiceImplTest.testCaseUser.getId());
		Assertions.assertNotNull(user);
	}

	@Test
	@Order(4)
	void modifyUser() {
		User user = us.retrieveUser(UserServiceImplTest.testCaseUser.getId());
		user.setRole(Role.ADMINISTRATEUR);
		UserServiceImplTest.testCaseUser = us.updateUser(user);
		Assertions.assertEquals(Role.ADMINISTRATEUR, UserServiceImplTest.testCaseUser.getRole());
	}
	
	@Test
	@Order(5)
	void deleteUser() {
		us.deleteUser(UserServiceImplTest.testCaseUser.getId());
		User user = us.retrieveUser(10L);
		Assertions.assertNull(user);
	}

}
