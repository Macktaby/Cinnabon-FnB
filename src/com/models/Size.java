package com.models;

public class Size {

	private int sizeID;
	private String sizeName;
	private double sizePrice;

	public Size() {
		this.sizeID = 0;
		this.sizeName = "";
		this.sizePrice = 0.0;
	}

	public Size(int sizeID, String sizeName, double sizePrice) {
		this.sizeID = sizeID;
		this.sizeName = sizeName;
		this.sizePrice = sizePrice;
	}

	public int getSizeID() {
		return sizeID;
	}

	public void setSizeID(int sizeID) {
		this.sizeID = sizeID;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public double getSizePrice() {
		return sizePrice;
	}

	public void setSizePrice(double sizePrice) {
		this.sizePrice = sizePrice;
	}

}
