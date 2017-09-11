package com.secretd.web.entity;

public class Doctor extends Member{
	private String license_num;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	
	public Doctor(String license_num) {
		super();
		this.license_num = license_num;
	}

	public String getLicense_num() {
		return license_num;
	}

	public void setLicense_num(String license_num) {
		this.license_num = license_num;
	}  
	
}
