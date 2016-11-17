package com.models;

public class BranchImage {
	private int imageID;
	private String url;

	public BranchImage() {
		this.imageID = 0;
		this.url = "";
	}

	public BranchImage(int imageID, String url) {
		this.imageID = imageID;
		this.url = url;
	}

	public int getImageID() {
		return imageID;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

}
