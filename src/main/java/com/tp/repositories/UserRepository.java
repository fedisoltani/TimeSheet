package com.tp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tp.entities.User;

@Repository
public interface UserRepository extends  CrudRepository<User, Long> {
	
	
}
