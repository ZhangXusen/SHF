package com.atguigu.entity;


public class HouseImage extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//房源id
	private Long houseId;
	//图片名称
	private String imageName;
	//图片地址
	private String imageUrl;
	//1：房源图片 2：房产图片
	private Integer type;

	
	public void setHouseId(Long value) {
		this.houseId = value;
	}
	
	public Long getHouseId() {
		return this.houseId;
	}
	
	public void setImageName(String value) {
		this.imageName = value;
	}
	
	public String getImageName() {
		return this.imageName;
	}
	
	public void setImageUrl(String value) {
		this.imageUrl = value;
	}
	
	public String getImageUrl() {
		return this.imageUrl;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}

}

