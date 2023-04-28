package com.atguigu.entity;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class House extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//小区id
	private Long communityId;
	//房源名称
	private String name;
	//描述
	private String description;
	//总价：万元
	private String totalPrice;
	//单位价格
	private String unitPrice;
	//建筑面积
	private String buildArea;
	//套内面积
	private String insideArea;
	//户型：（字典id）
	private Long houseTypeId;
	//楼层（字典id）
	private Long floorId;
	//建筑结构：（字典id）
	private Long buildStructureId;
	//朝向：（字典id）
	private Long directionId;
	//装修情况：（字典id）
	private Long decorationId;
	//房屋用途：（字典id）
	private Long houseUseId;
	//电梯比例
	private String elevatorRatio;
	//挂牌日期
	private Date listingDate;
	//上次交易日期
	private Date lastTradeDate;
	//状态
	private Integer status;

	//户型：（字典id）
	private String houseTypeName;
	//楼层（字典id）
	private String floorName;
	//建筑结构：（字典id）
	private String buildStructureName;
	//朝向：（字典id）
	private String directionName;
	//装修情况：（字典id）
	private String decorationName;
	//房屋用途：（字典id）
	private String houseUseName;
	
	public void setCommunityId(Long value) {
		this.communityId = value;
	}
	
	public Long getCommunityId() {
		return this.communityId;
	}
	
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
	
	public void setTotalPrice(String value) {
		this.totalPrice = value;
	}
	
	public String getTotalPrice() {
		return this.totalPrice;
	}
	
	public void setUnitPrice(String value) {
		this.unitPrice = value;
	}
	
	public String getUnitPrice() {
		return this.unitPrice;
	}
	
	public void setBuildArea(String value) {
		this.buildArea = value;
	}
	
	public String getBuildArea() {
		return this.buildArea;
	}
	
	public void setInsideArea(String value) {
		this.insideArea = value;
	}
	
	public String getInsideArea() {
		return this.insideArea;
	}
	
	public void setHouseTypeId(Long value) {
		this.houseTypeId = value;
	}
	
	public Long getHouseTypeId() {
		return this.houseTypeId;
	}
	
	public void setFloorId(Long value) {
		this.floorId = value;
	}
	
	public Long getFloorId() {
		return this.floorId;
	}
	
	public void setBuildStructureId(Long value) {
		this.buildStructureId = value;
	}
	
	public Long getBuildStructureId() {
		return this.buildStructureId;
	}
	
	public void setDirectionId(Long value) {
		this.directionId = value;
	}
	
	public Long getDirectionId() {
		return this.directionId;
	}
	
	public void setDecorationId(Long value) {
		this.decorationId = value;
	}
	
	public Long getDecorationId() {
		return this.decorationId;
	}
	
	public void setHouseUseId(Long value) {
		this.houseUseId = value;
	}
	
	public Long getHouseUseId() {
		return this.houseUseId;
	}
	
	public void setElevatorRatio(String value) {
		this.elevatorRatio = value;
	}
	
	public String getElevatorRatio() {
		return this.elevatorRatio;
	}

	public void setListingDate(Date value) {
		this.listingDate = value;
	}
	
	public Date getListingDate() {
		return this.listingDate;
	}

	public String getListingDateString() {
		Date date = this.getListingDate();
		if(null == date) return "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		return dateString;
	}
	public void setListingDateString(String value) {
		try {
			if(null == value || "".equals(value)) return;
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(value);
			this.setListingDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setLastTradeDate(Date value) {
		this.lastTradeDate = value;
	}

	public Date getLastTradeDate() {
		return this.lastTradeDate;
	}
	public String getLastTradeDateString() {
		Date date = this.getLastTradeDate();
		if(null == date) return "";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = df.format(date);
		return dateString;
	}
	public void setLastTradeDateString(String value) {
		try {
			if(null == value || "".equals(value)) return;
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(value);
			this.setLastTradeDate(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	public Integer getStatus() {
		return this.status;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public String getBuildStructureName() {
		return buildStructureName;
	}

	public void setBuildStructureName(String buildStructureName) {
		this.buildStructureName = buildStructureName;
	}

	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	public String getDecorationName() {
		return decorationName;
	}

	public void setDecorationName(String decorationName) {
		this.decorationName = decorationName;
	}

	public String getHouseUseName() {
		return houseUseName;
	}

	public void setHouseUseName(String houseUseName) {
		this.houseUseName = houseUseName;
	}
}

