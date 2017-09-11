package com.secretd.web.entity;

public class Disease {
	private String number;
	private String highClass;
	private String subClass;
	private String name;
	
	public Disease() {
	}
	
	public Disease(String number, String highClass, String subClass, String name) {
		this.number = number;
		this.highClass = highClass;
		this.subClass = subClass;
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getHighClass() {
		return highClass;
	}
	public void setHighClass(String highClass) {
		this.highClass = highClass;
	}
	public String getSubClass() {
		return subClass;
	}
	public void setSubClass(String subClass) {
		this.subClass = subClass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}