package com.secretd.web.entity;

public class Hospital {
	private String id;
	private String subject;
	private String name;
	private String address;
	private String phone_number;
	private String opening_hours;
	private String homepage;
	private String character;
	private String score;
	private String manager_id;
	
	
	
	
	public Hospital() {
		super();
	}




	public Hospital(String subject, String name, String address, String phone_number, String homepage,
			String character) {
		super();
		this.subject = subject;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.homepage = homepage;
		this.character = character;
	}




	public Hospital(String subject, String name, String address, String phone_number) {
		super();
		this.subject = subject;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
	}




	public Hospital(String id,String subject, String name, String address, String phone_number, String opening_hours,
			String homepage, String character, String score, String manager_id) {
		super();
		this.id = id;
		this.subject = subject;
		this.name = name;
		this.address = address;
		this.phone_number = phone_number;
		this.opening_hours = opening_hours;
		this.homepage = homepage;
		this.character = character;
		this.score = score;
		this.manager_id = manager_id;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getSubject() {
		return subject;
	}




	public void setSubject(String subject) {
		this.subject = subject;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getPhone_number() {
		return phone_number;
	}




	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}




	public String getOpening_hours() {
		return opening_hours;
	}




	public void setOpening_hours(String opening_hours) {
		this.opening_hours = opening_hours;
	}




	public String getHomepage() {
		return homepage;
	}




	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}




	public String getCharacter() {
		return character;
	}




	public void setCharacter(String character) {
		this.character = character;
	}




	public String getScore() {
		return score;
	}




	public void setScore(String score) {
		this.score = score;
	}




	public String getManager_id() {
		return manager_id;
	}




	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	

}