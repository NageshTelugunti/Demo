package com.example.purpletask;

import java.io.Serializable;

public class NewUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fstName;
	private String lastName;
	private String qulification;
	private String height;
	public String getFstName() {
		return fstName;
	}
	public void setFstName(String fstName) {
		this.fstName = fstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getQulification() {
		return qulification;
	}
	public void setQulification(String qulification) {
		this.qulification = qulification;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	

}
