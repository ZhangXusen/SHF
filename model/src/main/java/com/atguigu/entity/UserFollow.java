package com.atguigu.entity;


public class UserFollow extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//用户id
	private Long userId;
	//房源id
	private Long houseId;

	public void setUserId(Long value) {
		this.userId = value;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	
	public void setHouseId(Long value) {
		this.houseId = value;
	}
	
	public Long getHouseId() {
		return this.houseId;
	}
	
}

