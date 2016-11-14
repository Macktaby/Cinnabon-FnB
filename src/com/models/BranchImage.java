package com.models;

public class BranchImage {
	private int imageID;
	private String imageName;

	public BranchImage(int imageID, String imageName) {
		this.imageID = imageID;
		this.imageName = imageName;
	}

	public int getImageID() {
		return imageID;
	}

	public void setImageID(int imageID) {
		this.imageID = imageID;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

}
