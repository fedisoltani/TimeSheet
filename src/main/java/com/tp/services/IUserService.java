package com.tp.services;

import java.util.List;

import com.tp.entities.User;

public interface IUserService { 
	 
	List<User> retrieveAllUsers(); 
	User addUser(User u);
	void deleteUser(Long id);
	User updateUser(User u);
	User retrieveUser(Long id);

} 
 