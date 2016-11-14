package com.models;

import java.sql.Timestamp;

public class Eater {
	private int eaterID;
	private String userName;
	private String email;
	private String password;
	private String phone;
	private Timestamp date_registered;

	public Eater(int eaterID, String userName, String email, String password, String phone, Timestamp date_registered) {
		this.eaterID = eaterID;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.date_registered = date_registered;
	}

	public int getEaterID() {
		return eaterID;
	}

	public void setEaterID(int eaterID) {
		this.eaterID = eaterID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getDate_registered() {
		return date_registered;
	}

	public void setDate_registered(Timestamp date_registered) {
		this.date_registered = date_registered;
	}

}
