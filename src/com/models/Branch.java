package com.models;

import java.util.List;

public class Branch {
	private int branch_id;
	private String phone;
	private String location;
	private String address;
	private String lng;
	private String lat;
	private List<BranchImage> images;

	public Branch(int branch_id, String phone, String location, String address, String lng, String lat,
			List<BranchImage> images) {
		this.branch_id = branch_id;
		this.phone = phone;
		this.location = location;
		this.address = address;
		this.lng = lng;
		this.lat = lat;
		this.images = images;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public List<BranchImage> getImages() {
		return images;
	}

	public void setImages(List<BranchImage> images) {
		this.images = images;
	}

}
