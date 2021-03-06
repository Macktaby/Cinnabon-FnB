package com.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private int orderID;
	private int eaterID;
	private Branch branch;
	private Timestamp timeCreated;
	private Timestamp orderTime;
	private List<OrderItem> items;

	public Order() {
		this.orderID = 0;
		this.eaterID = 0;
		this.branch = new Branch();
		this.timeCreated = new Timestamp(0);
		this.orderTime = new Timestamp(0);
		this.items = new ArrayList<>();
	}

	public Order(int orderID, int eaterID, Timestamp orderTime, List<OrderItem> items) {
		this();
		this.orderID = orderID;
		this.eaterID = eaterID;
		this.orderTime = orderTime;
		this.items = items;
		Date date = new Date();
		this.timeCreated = new Timestamp(date.getTime());
	}

	public Order(int orderID, int eaterID, Branch branch, Timestamp timeCreated, Timestamp orderTime,
			List<OrderItem> items) {
		this();
		this.orderID = orderID;
		this.eaterID = eaterID;
		this.branch = branch;
		this.timeCreated = timeCreated;
		this.orderTime = orderTime;
		this.items = items;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
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

	public Timestamp getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

}
