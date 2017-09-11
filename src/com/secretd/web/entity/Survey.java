package com.secretd.web.entity;

public class Survey {
	private String num;
	private String content;
	
	public Survey() {
		// TODO Auto-generated constructor stub
	}
	public Survey(String num, String content) {
		super();
		this.num = num;
		this.content = content;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
