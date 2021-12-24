package com.spartenportal.entity;

import java.util.Objects;

/* Bean class for UserRoles
 * author : Mahesh
 * Date : 24/11/2021
 * version : 1.0
 */

public class User_Roles {

	// data members for User_Roles

	private int urId;
	private int userId_Fk;
	private int roleId_Fk;
	private boolean isActive;

	// getters and setters
	public int getUrId() {
		return urId;
	}

	public void setUrId(int urId) {
		this.urId = urId;
	}

	public int getUserId_Fk() {
		return userId_Fk;
	}

	public void setUserId_Fk(int userId_Fk) {
		this.userId_Fk = userId_Fk;
	}

	public int getRoleId_Fk() {
		return roleId_Fk;
	}

	public void setRoleId_Fk(int roleId_Fk) {
		this.roleId_Fk = roleId_Fk;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isActive, roleId_Fk, urId, userId_Fk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User_Roles other = (User_Roles) obj;
		return isActive == other.isActive && roleId_Fk == other.roleId_Fk && urId == other.urId
				&& userId_Fk == other.userId_Fk;
	}

	@Override
	public String toString() {
		return "User_Roles [urId=" + urId + ", userId_Fk=" + userId_Fk + ", roleId_Fk=" + roleId_Fk + ", isActive="
				+ isActive + "]";
	}

	// parameterize constructor
	public User_Roles(int urId, int userId_Fk, int roleId_Fk, boolean isActive) {
		super();
		this.urId = urId;
		this.userId_Fk = userId_Fk;
		this.roleId_Fk = roleId_Fk;
		this.isActive = isActive;
	}

	// default constructor 
	public User_Roles() {

	}

}
