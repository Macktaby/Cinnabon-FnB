package com.models;

import java.sql.Timestamp;

public class Review {

	private int reviewID;
	private String eaterID;
	private String userName;
	private String reviewBody;
	private int rating;
	private Timestamp reviewDate;

	public Review(int reviewID, String eaterID, String userName, String reviewBody, int rating, Timestamp reviewDate) {
		this.reviewID = reviewID;
		this.eaterID = eaterID;
		this.userName = userName;
		this.reviewBody = reviewBody;
		this.rating = rating;
		this.reviewDate = reviewDate;
	}

	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}

	public String getEaterID() {
		return eaterID;
	}

	public void setEaterID(String eaterID) {
		this.eaterID = eaterID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReviewBody() {
		return reviewBody;
	}

	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Timestamp getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

}
