package com.nevu.products.back.entities.dto;

public class UserStdOutDTO {


	private long userId;
	private String name;
	private String lastName;
	private String document;
	private String email;
	
	public UserStdOutDTO(long userId, String name, String lastName, String document, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.document = document;
		this.email = email;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
