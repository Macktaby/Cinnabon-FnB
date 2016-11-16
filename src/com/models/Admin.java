package com.models;

public class Admin {
	private int adminID;
	private String adminName;
	private String email;
	private String password;
	private int branchID;

	public Admin() {
		this.adminID = 0;
		this.adminName = "";
		this.email = "";
		this.password = "";
		this.branchID = 0;
	}

	public Admin(int adminID, String adminName, String email, String password, int branchID) {
		this.adminID = adminID;
		this.adminName = adminName;
		this.email = email;
		this.password = password;
		this.branchID = branchID;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

}
