package com.secretd.web.entity;

import java.util.Date;

public class Question {
	private String title;
	private String question;
	private Date date;
	private String answer;
	
	public Question() {
	}
	
	public Question(String title, String question, Date date, String answer) {
		this.title = title;
		this.question = question;
		this.date = date;
		this.answer = answer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
