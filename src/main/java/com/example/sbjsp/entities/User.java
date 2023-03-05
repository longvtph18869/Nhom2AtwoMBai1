package com.example.sbjsp.entities;

import java.util.Date;

public class User {

	private Long id;
	private String fullName;
	private int gender;
	private Date birthDay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public User(Long id, String fullName, int gender, Date birthDay) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.birthDay = birthDay;
	}

	public User() {
		super();
	}

}
