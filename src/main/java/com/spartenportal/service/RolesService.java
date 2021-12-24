package com.spartenportal.service;

import java.io.IOException;
import java.util.List;

import com.spartenportal.entity.Roles;

/*
 * Service class for Roles
 * author Vidya
 * date 22/11/2021
 */
public interface RolesService {
	public int addRoles(Roles roles) throws Exception;

	public int updateRoles(Roles roles) throws NumberFormatException, IOException;

	public int deleteRolesById(int id) throws IOException;

	public List<Roles> getAllRoles();

	public Roles getRolesById(int id);
}
