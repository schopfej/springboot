package com.youtube.jwt.entity;


import jakarta.persistence.Id;
import jakarta.persistence.Entity;


/*
 * This class represents a Role entity.
 * Entity for the DB 
 * the Id is the primary key
 */

@Entity
public class Role {
	
	@Id
	private String roleName; 
	private String roleDescription;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	} 
	
	
	
	

}
