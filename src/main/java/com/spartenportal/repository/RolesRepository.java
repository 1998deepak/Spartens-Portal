package com.spartenportal.repository;


/**
 * 
 * @author Ashwini 
 * @date 25/12/2021
 *
 */
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.spartenportal.entity.Roles;


@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
	
	
	public Roles findByRoleName(String roleName);
	
	@Query(value = "SELECT * FROM roles WHERE roleName = ?", nativeQuery = true)
	public Optional<Roles> fetchRoleByName(String roleName);
	
	@Query(value = "SELECT * FROM  roles WHERE roleName = ?", nativeQuery = true)
	public List<Roles> findByName(String roleName);

}
