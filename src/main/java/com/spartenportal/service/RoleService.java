package com.spartenportal.service;

/**
 * Interface for provide services to Roles
 * 
 * @author Ashwini
 * @date 25/12/2021
 * 
 */

import java.util.List;


import com.spartenportal.bean.RolesBean;
import com.spartenportal.entity.Roles;

public interface RoleService {

	
	public RolesBean fetchRolebyName(String roleName);

	public List<RolesBean> fetchRoleList();
	
	public Roles findByRoleName(String roleName);
}
