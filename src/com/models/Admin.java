package com.models;

public class Admin {
	private int adminID;
	private String admin_name;
	private String email;
	private String password;
	private int branchID;

	public Admin(int adminID, String admin_name, String email, String password, int branchID) {
		this.adminID = adminID;
		this.admin_name = admin_name;
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

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
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
