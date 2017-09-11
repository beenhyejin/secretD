package com.secretd.web.entity;

import java.util.Date;

public class Counseling{
	private String number;
	private String title;
	private String content;
	private String writer_id;
	private String category;
	private Date date;
	private int hit;
	private int count;
	
	public Counseling() {
		
	}

	public Counseling(String number, String title, String content, String writer_id, String category, Date date,
			int hit, int count) {
		super();
		this.number = number;
		this.title = title;
		this.content = content;
		this.writer_id = writer_id;
		this.category = category;
		this.date = date;
		this.hit = hit;
		this.count = count;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	
	
}
