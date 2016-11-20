package com.models;

import java.sql.Timestamp;
import java.util.Date;

public class Review {

	private int reviewID;
	private int eaterID;
	private String userName;
	private String reviewBody;
	private int rating;
	private Timestamp reviewDate;

	public Review() {
		this.reviewID = 0;
		this.eaterID = 0;
		this.userName = "";
		this.reviewBody = "";
		this.rating = 0;
		this.reviewDate = new Timestamp(0);
	}

	public Review(int reviewID, int eaterID, String reviewBody, int rating) {
		this();
		this.reviewID = reviewID;
		this.eaterID = eaterID;
		this.reviewBody = reviewBody;
		this.rating = rating;
		Date date = new Date();
		this.reviewDate = new Timestamp(date.getTime());
	}

	public Review(int reviewID, int eaterID, String userName, String reviewBody, int rating, Timestamp reviewDate) {
		this();
		this.reviewID = reviewID;
		this.eaterID = eaterID;
		this.userName = userName;
		this.reviewBody = reviewBody;
		this.rating = rating;
		this.reviewDate = reviewDate;
	}

	public int getEaterID() {
		return eaterID;
	}

	public void setEaterID(int eaterID) {
		this.eaterID = eaterID;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getReviewID() {
		return reviewID;
	}

	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
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

	public Timestamp getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

}
