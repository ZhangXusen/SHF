package com.atguigu.entity;

public class RolePermission extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//roleId   
	private Long roleId;
	//permissionId   
	private Long permissionId;

	public void setRoleId(Long value) {
		this.roleId = value;
	}
	
	public Long getRoleId() {
		return this.roleId;
	}
	
	public void setPermissionId(Long value) {
		this.permissionId = value;
	}
	
	public Long getPermissionId() {
		return this.permissionId;
	}
}

