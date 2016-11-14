package com.models;

public class OrderItem {
	private int orderItemID;
	private Item item;
	private Size size;
	private int quantity;

	public OrderItem(int orderItemID, Item item, Size size, int quantity) {
		this.orderItemID = orderItemID;
		this.item = item;
		this.size = size;
		this.quantity = quantity;
	}

	public int getOrderItemID() {
		return orderItemID;
	}

	public void setOrderItemID(int orderItemID) {
		this.orderItemID = orderItemID;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
