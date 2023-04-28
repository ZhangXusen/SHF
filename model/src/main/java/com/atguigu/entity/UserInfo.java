package com.atguigu.entity;


public class UserInfo extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//手机号
	private String phone;
	//用户密码
	private String password;
	//用户昵称
	private String nickName;
	//状态（0：锁定 1：正常）
	private Integer status;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setNickName(String value) {
		this.nickName = value;
	}
	
	public String getNickName() {
		return this.nickName;
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return this.status;
	}

}

