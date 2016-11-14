package com.models;

import java.util.List;

public class Category {
	private int categoryID;
	private String categoryName;
	private List<Item> items;
	private int branchID;

	public Category(int categoryID, String categoryName, List<Item> items, int branchID) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.items = items;
		this.branchID = branchID;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getBranchID() {
		return branchID;
	}

	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

}
