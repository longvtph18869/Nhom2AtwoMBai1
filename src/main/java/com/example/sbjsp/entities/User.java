package com.example.sbjsp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String fullName;

	@Column
	private int gender;

	@Column
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

	public User(String fullName, int gender, Date birthDay) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.birthDay = birthDay;
	}

	public User() {
		super();
	}

}
