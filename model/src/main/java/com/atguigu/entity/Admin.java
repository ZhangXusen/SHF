package com.atguigu.entity;

import java.util.List;

public class Admin extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//用户名   
	private String username;
	//密码   
	private String password;
	//姓名   
	private String name;
	//手机   
	private String phone;
	//头像地址   
	private String headUrl;
	//描述   
	private String description;

	private List<Role> roleList;

	public void setUsername(String value) {
		this.username = value;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setHeadUrl(String value) {
		this.headUrl = value;
	}
	
	public String getHeadUrl() {
		return this.headUrl;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}

