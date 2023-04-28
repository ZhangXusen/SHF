package com.atguigu.entity;

public class Role extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//角色名称   
	private String roleName;
	//角色编码   
	private String roleCode;
	//描述   
	private String description;

	public void setRoleName(String value) {
		this.roleName = value;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleCode(String value) {
		this.roleCode = value;
	}
	
	public String getRoleCode() {
		return this.roleCode;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}

}

