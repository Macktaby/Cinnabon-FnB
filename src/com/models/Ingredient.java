package com.models;

public class Ingredient {
	private int ingredientID;
	private String ingredientName;

	public Ingredient() {
		this.ingredientID = 0;
		this.ingredientName = "";
	}

	public Ingredient(int ingredientID, String ingredientName) {
		this.ingredientID = ingredientID;
		this.ingredientName = ingredientName;
	}

	public int getIngredientID() {
		return ingredientID;
	}

	public void setIngredientID(int ingredientID) {
		this.ingredientID = ingredientID;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

}
