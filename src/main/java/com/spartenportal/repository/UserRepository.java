package com.spartenportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spartenportal.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUserNameAndPassword(String userName, String password);
}
