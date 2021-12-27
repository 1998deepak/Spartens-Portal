package com.spartenportal.mapper;

/**
 * Roles mapper class to map bean to entities and entities to bean
 * 
 * @author Sejal Shelke
 * @date 23/11/2021
 * @version 1.0
 *
 */

import org.springframework.stereotype.Component;

import com.spartenportal.bean.RolesBean;
import com.spartenportal.entity.Roles;



@Component
public class RolesMapper {

	// Method to map entities to bean properties
	public RolesBean mapToBean(Roles roles) {
		RolesBean rolesBean = new RolesBean();		
		rolesBean.setRoleId(roles.getRoleId());
		rolesBean.setRoleName(roles.getRoleName());
		rolesBean.setUsers(roles.getUsers());		
		return rolesBean;
	}
	
	
	// Method to map bean properties to entity
	public Roles mapToEntity(RolesBean rolesBean) {
		Roles roles = new Roles();		
		roles.setRoleId(rolesBean.getRoleId());
		roles.setRoleName(rolesBean.getRoleName());
		roles.setUsers(rolesBean.getUsers());		
		return roles;
	}
}

