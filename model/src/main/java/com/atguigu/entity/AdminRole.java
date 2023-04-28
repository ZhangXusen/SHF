package com.atguigu.entity;

public class AdminRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//角色id   
	private Long roleId;
	//用户id   
	private Long adminId;

	public void setRoleId(Long value) {
		this.roleId = value;
	}
	
	public Long getRoleId() {
		return this.roleId;
	}
	
	public void setAdminId(Long value) {
		this.adminId = value;
	}
	
	public Long getAdminId() {
		return this.adminId;
	}

}

