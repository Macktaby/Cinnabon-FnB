package com.models;

import java.util.ArrayList;

public class OrderItem {
	private int orderItemID;
	private Item item;
	private Size size;
	private ArrayList<Ingredient> ingredients;
	private int quantity;

	public OrderItem() {
		this.orderItemID = 0;
		this.item = new Item();
		this.size = new Size();
		this.ingredients = new ArrayList<>();
		this.quantity = 0;
	}

	public OrderItem(int orderItemID, int itemID, int sizeID, ArrayList<Ingredient> ingredients, int quantity) {
		this.orderItemID = orderItemID;
		this.item = new Item(itemID, "", "", 0, 0, 0, 0, 0, null, null);
		this.size = new Size(sizeID, "", 0);
		this.ingredients = ingredients;
		this.quantity = quantity;
	}

	public OrderItem(int orderItemID, Item item, Size size, ArrayList<Ingredient> ingredients, int quantity) {
		this.orderItemID = orderItemID;
		this.item = item;
		this.size = size;
		this.ingredients = ingredients;
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

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		String res = 
				"ID "+orderItemID + "\n" + 
				"Quan " + quantity + "\n" +
				"ItemID " + item.getItemID() + "\n" +
				"sizeID " + size.getSizeID()+ "\n";
		
		for(Ingredient ingredient : ingredients)
			res += ingredient.getIngredientID() + " ";

		res += "\n";
		return res;
	}
}
