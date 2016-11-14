package com.models;

import java.util.List;

public class Item {

	private String itemID;
	private String itemName;
	private String description;
	private double price;
	private int likes;
	private int dislikes;
	private int calories;
	private int nPersons;
	private List<Ingredient> ingredients;
	private List<Size> sizes;

	public Item(String itemID, String itemName, String description, double price, int likes, int dislikes, int calories,
			int nPersons, List<Ingredient> ingredients, List<Size> sizes) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.likes = likes;
		this.dislikes = dislikes;
		this.calories = calories;
		this.nPersons = nPersons;
		this.ingredients = ingredients;
		this.sizes = sizes;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getnPersons() {
		return nPersons;
	}

	public void setnPersons(int nPersons) {
		this.nPersons = nPersons;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Size> getSizes() {
		return sizes;
	}

	public void setSizes(List<Size> sizes) {
		this.sizes = sizes;
	}

}
