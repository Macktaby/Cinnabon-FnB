package com.models;

import java.sql.Timestamp;

public class Reservation {
	private int reservationID;
	private int eaterID;
	private Branch branch;
	private int nPersons;
	private Timestamp startTime;
	private Timestamp endTime;

	public Reservation() {
		this.reservationID = 0;
		this.eaterID = 0;
		this.branch = new Branch();
		this.nPersons = 0;
		this.startTime = new Timestamp(0);
		this.endTime = new Timestamp(0);
	}

	public Reservation(int reservationID, int eaterID, int nPersons, Timestamp startTime, Timestamp endTime) {
		this.reservationID = reservationID;
		this.eaterID = eaterID;
		this.branch = new Branch();
		this.nPersons = nPersons;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Reservation(int reservationID, int eaterID, Branch branch, int nPersons, Timestamp startTime,
			Timestamp endTime) {
		this.reservationID = reservationID;
		this.eaterID = eaterID;
		this.branch = branch;
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

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
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
