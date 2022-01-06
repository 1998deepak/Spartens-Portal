package com.spartenportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spartenportal.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * FROM  user WHERE userName= :userName AND password=:password", nativeQuery = true)
	public User findByUserNameAndPassword (@Param("userName") String userName,@Param("password") String password);
	
	@Query(value = "SELECT * FROM  userRole WHERE usersId= :usersId AND roleId= :roleId", nativeQuery = true)
	public Optional<Integer> checkAuthority(@Param("usersId") Integer usersId,@Param("roleId") Integer roleId);
	
	@Query(value="SELECT * FROM  user WHERE email= :email ", nativeQuery = true)
	public User getUserByUserEmail(@Param("email") String email);
}
