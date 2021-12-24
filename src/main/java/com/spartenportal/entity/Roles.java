package com.spartenportal.entity;

import java.util.Objects;

/* Bean class for Roles
 * author : vidya
 * Date : 24/11/2021
 * version : 1.0
 */

public class Roles {

	// roles class variables
	
	private int roleId;
	private String roleName;

	// getters and setters
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleId, roleName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		return roleId == other.roleId && Objects.equals(roleName, other.roleName);
	}

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	// parameterize constructor
	public Roles(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	// default constructor
	public Roles() {

	}

}
