package com.models;

public class ItemEater {
	private int eaterID;
	private int itemID;
	private boolean isLike;

	public ItemEater(int eaterID, int itemID, boolean isLike) {
		this.eaterID = eaterID;
		this.itemID = itemID;
		this.isLike = isLike;
	}

	public int getEaterID() {
		return eaterID;
	}

	public void setEaterID(int eaterID) {
		this.eaterID = eaterID;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}

}
