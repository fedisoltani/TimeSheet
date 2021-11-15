package com.tp.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.entities.User;
import com.tp.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<User> retrieveAllUsers() {
		try {
			List<User> users = (List<User>) userRepository.findAll();
			l.info(users);
			return users;
		} catch (Exception e) {
			l.error(e);
		}
		return null;
	}

	@Override
	public User addUser(User u) {
		l.info("Saving user object");
		return userRepository.save(u);
	}

	@Override
	public User updateUser(User u) {
		l.info("Updating user object");
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(Long id) {
		l.info("Deleting user object");
		userRepository.deleteById(id);
	}

	@Override
	public User retrieveUser(Long id) {
		l.info("Retreiving user object");
		try {
			Optional<User> u = userRepository.findById(id);
			if (u.isPresent()) {
				return u.get();
			}
		} catch (Exception e) {
			l.error(e);
		}
		return null;
	}
}
