package com.spartenportal.service;

import java.io.IOException;
import java.util.List;

import com.spartenportal.entity.User_Roles;





/*
 * Service class for userRoles
 * author Mahesh
 * date 22/11/2021
 */

public interface User_RolesService {
	
	public int addUser_Roles(User_Roles userRoles) throws Exception;

	public int updateUser_Roles(User_Roles userRoles) throws NumberFormatException, IOException;

	public int deleteUser_RolesById(int id) throws IOException;

	public List<User_Roles> getAllUser_Roles();

	public User_Roles getUser_RolesById(int id);
}
