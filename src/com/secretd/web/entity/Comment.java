package com.secretd.web.entity;

import java.util.Date;

public class Comment {
	private int number;
	private String nickname;
	private String content;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int number, String nickname, String content) {
		super();
		this.number = number;
		this.nickname = nickname;
		this.content = content;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
	
}
