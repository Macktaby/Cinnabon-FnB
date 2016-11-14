package com.models;

import java.sql.Timestamp;

public class Reservation {
	private int reservationID;
	private int eaterID;
	private Branch branchID;
	private int nPersons;
	private Timestamp startTime;
	private Timestamp endTime;

	public Reservation(int reservationID, int eaterID, Branch branchID, int nPersons, Timestamp startTime,
			Timestamp endTime) {
		this.reservationID = reservationID;
		this.eaterID = eaterID;
		this.branchID = branchID;
		this.nPersons = nPersons;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getReservationID() {
		return reservationID;
	}

	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}

	public int getEaterID() {
		return eaterID;
	}

	public void setEaterID(int eaterID) {
		this.eaterID = eaterID;
	}

	public Branch getBranchID() {
		return branchID;
	}

	public void setBranchID(Branch branchID) {
		this.branchID = branchID;
	}

	public int getnPersons() {
		return nPersons;
	}

	public void setnPersons(int nPersons) {
		this.nPersons = nPersons;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}
