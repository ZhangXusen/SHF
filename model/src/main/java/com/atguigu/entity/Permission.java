package com.atguigu.entity;

import java.util.List;

public class Permission extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//所属上级   
	private Long parentId;
	//权限名称   
	private String name;
	//菜单路径   
	private String url;
	//权限标识   
	private String code;
	//类型(1:菜单,2:按钮)   
	private Integer type;
	//排序
	private Integer sort;

	// 层级
	private Integer level;
	// 下级列表
	private List<Permission> children;
	//所属上级
	private String parentName;

	public void setParentId(Long value) {
		this.parentId = value;
	}
	
	public Long getParentId() {
		return this.parentId;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setCode(String value) {
		this.code = value;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<Permission> getChildren() {
		return children;
	}

	public void setChildren(List<Permission> children) {
		this.children = children;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}

