package com.secretd.web.entity;

import java.util.Date;

public class Letter {
	private String title;
	private Date date;
	private boolean check;
	private String content;
	
	public Letter() {
		// TODO Auto-generated constructor stub
	}
	
	public Letter(String title, Date date, boolean check, String content) {
		super();
		this.title = title;
		this.date = date;
		this.check = check;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
