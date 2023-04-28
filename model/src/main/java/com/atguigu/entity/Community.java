package com.atguigu.entity;


public class Community extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//小区名称
	private String name;
	//描述
	private String description;
	//省id：（字典id）
	private Long provinceId;
	//城市id：（字典id）
	private Long cityId;
	//区域id：（字典id）
	private Long areaId;
	//板块id：（字典id）
	private Long plateId;
	//详细地址
	private String address;
	//经度
	private String longitude;
	//纬度
	private String latitude;
	//建筑年代
	private String buildYears;
	//物业价格
	private String propertyPrice;
	//物业公司
	private String propertyCompany;
	//开发商
	private String developer;
	//楼栋数
	private Integer buildNum;
	//房屋数
	private Integer houseNum;
	//均价
	private String averagePrice;

	//区域id：（字典id）
	private String areaName;
	//板块id：（字典id）
	private String plateName;
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setProvinceId(Long value) {
		this.provinceId = value;
	}
	
	public Long getProvinceId() {
		return this.provinceId;
	}
	
	public void setCityId(Long value) {
		this.cityId = value;
	}
	
	public Long getCityId() {
		return this.cityId;
	}
	
	public void setAreaId(Long value) {
		this.areaId = value;
	}
	
	public Long getAreaId() {
		return this.areaId;
	}
	
	public void setPlateId(Long value) {
		this.plateId = value;
	}
	
	public Long getPlateId() {
		return this.plateId;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setLongitude(String value) {
		this.longitude = value;
	}
	
	public String getLongitude() {
		return this.longitude;
	}
	
	public void setLatitude(String value) {
		this.latitude = value;
	}
	
	public String getLatitude() {
		return this.latitude;
	}
	
	public void setBuildYears(String value) {
		this.buildYears = value;
	}
	
	public String getBuildYears() {
		return this.buildYears;
	}
	
	public void setPropertyPrice(String value) {
		this.propertyPrice = value;
	}
	
	public String getPropertyPrice() {
		return this.propertyPrice;
	}
	
	public void setPropertyCompany(String value) {
		this.propertyCompany = value;
	}
	
	public String getPropertyCompany() {
		return this.propertyCompany;
	}
	
	public void setDeveloper(String value) {
		this.developer = value;
	}
	
	public String getDeveloper() {
		return this.developer;
	}
	
	public void setBuildNum(Integer value) {
		this.buildNum = value;
	}
	
	public Integer getBuildNum() {
		return this.buildNum;
	}
	
	public void setHouseNum(Integer value) {
		this.houseNum = value;
	}
	
	public Integer getHouseNum() {
		return this.houseNum;
	}
	
	public void setAveragePrice(String value) {
		this.averagePrice = value;
	}
	
	public String getAveragePrice() {
		return this.averagePrice;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPlateName() {
		return plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
}

