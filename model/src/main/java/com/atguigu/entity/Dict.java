package com.atguigu.entity;


public class Dict extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	//上级id
	private Long parentId;
	//名称
	private String name;
	//编码
	private String dictCode;

	
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
	
	public void setDictCode(String value) {
		this.dictCode = value;
	}
	
	public String getDictCode() {
		return this.dictCode;
	}

}

