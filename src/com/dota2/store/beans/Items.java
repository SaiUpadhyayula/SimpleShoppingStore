package com.dota2.store.beans;

import java.io.Serializable;

public class Items implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private int					itemID;
	private String				itemName;
	private double				itemPrice;
	private String				itemQuality;
	private static int			referenceID;

	public Items() {

	}

	public Items(int int1, String string, double double1, String string2) {
		super();
		this.itemID = int1;
		this.itemName = string;
		this.itemPrice = double1;
		this.itemQuality = string2;
	}

	public Items(String string, double double1, String string2) {
		this.itemName = string;
		this.itemPrice = double1;
		this.itemQuality = string2;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemQuality() {
		return itemQuality;
	}

	public void setItemQuality(String itemQuality) {
		this.itemQuality = itemQuality;
	}

	public static int getReferenceID() {
		return referenceID;
	}

	public static void setReferenceID(int referenceID) {
		Items.referenceID = referenceID;
	}

}
