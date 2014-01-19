package com.dota2.store.beans;

import java.io.Serializable;

public class Hero implements Serializable {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	private int					heroID;
	private String				heroName;
	private String				heroAttribute;
	private String				heroDescription;

	public Hero() {
		// TODO Auto-generated constructor stub
	}

	public Hero(int int1, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
		super();
		this.heroID = int1;
		this.heroName = string;
		this.heroAttribute = string2;
		this.heroDescription = string3;
	}

	public int getHeroID() {
		return heroID;
	}

	public void setHeroID(int heroId) {
		heroID = heroId;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getHeroAttribute() {
		return heroAttribute;
	}

	public void setHeroAttribute(String heroAttribute) {
		this.heroAttribute = heroAttribute;
	}

	public String getHeroDescription() {
		return heroDescription;
	}

	public void setHeroDescription(String heroDescription) {
		this.heroDescription = heroDescription;
	}

}
