package com.dota2.store.beans;

import java.io.Serializable;

public class SetDetails implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private String					setID;
	private String				setName;
	private double				setPrice;
	private String				setQuality;

	public SetDetails() {
		super();
	}

	public SetDetails(String int1, String string, double string2, String string3) {

		this.setID = int1;
		this.setName = string;
		this.setPrice = string2;
		this.setQuality = string3;
	}

	public String getSetID() {
		return setID;
	}

	public void setSetID(String setID2) {
		this.setID = setID2;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public double getSetPrice() {
		return setPrice;
	}

	public void setSetPrice(double string) {
		this.setPrice = string;
	}

	public String getSetQuality() {
		return setQuality;
	}

	public void setSetQuality(String setQuality) {
		this.setQuality = setQuality;
	}

}
