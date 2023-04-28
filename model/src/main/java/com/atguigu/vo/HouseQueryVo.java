package com.atguigu.vo;


import java.io.Serializable;

public class HouseQueryVo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	//区域id：（字典id）
	private Long areaId;
	//板块id：（字典id）
	private Long plateId;
	//房源关键字
	private String keyword;
	//总价：万元
	private String totalPrice;
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

	//排序：默认 defaultSort=1按默认排序
	private Integer defaultSort;
	//排序：默认 priceSort=1按价格排序
	private Integer priceSort;
	//排序：默认 timeSort=1按时间排序
	private Integer timeSort;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getPlateId() {
		return plateId;
	}

	public void setPlateId(Long plateId) {
		this.plateId = plateId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(Long houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public Long getFloorId() {
		return floorId;
	}

	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}

	public Long getBuildStructureId() {
		return buildStructureId;
	}

	public void setBuildStructureId(Long buildStructureId) {
		this.buildStructureId = buildStructureId;
	}

	public Long getDirectionId() {
		return directionId;
	}

	public void setDirectionId(Long directionId) {
		this.directionId = directionId;
	}

	public Long getDecorationId() {
		return decorationId;
	}

	public void setDecorationId(Long decorationId) {
		this.decorationId = decorationId;
	}

	public Long getHouseUseId() {
		return houseUseId;
	}

	public void setHouseUseId(Long houseUseId) {
		this.houseUseId = houseUseId;
	}

	public Integer getDefaultSort() {
		return defaultSort;
	}

	public void setDefaultSort(Integer defaultSort) {
		this.defaultSort = defaultSort;
	}

	public Integer getPriceSort() {
		return priceSort;
	}

	public void setPriceSort(Integer priceSort) {
		this.priceSort = priceSort;
	}

	public Integer getTimeSort() {
		return timeSort;
	}

	public void setTimeSort(Integer timeSort) {
		this.timeSort = timeSort;
	}
}

