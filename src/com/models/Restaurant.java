package com.models;

public class Restaurant {

	private int restaurantID;
	private String restaurantName;
	private String description;
	private String type;
	private String logo;
	private int hotline;
	private double rating;

	public Restaurant(int restaurantID, String restaurantName, String description, String type, String logo,
			int hotline, double rating) {
		this.restaurantID = restaurantID;
		this.restaurantName = restaurantName;
		this.description = description;
		this.type = type;
		this.logo = logo;
		this.hotline = hotline;
		this.rating = rating;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public int getHotline() {
		return hotline;
	}

	public void setHotline(int hotline) {
		this.hotline = hotline;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
