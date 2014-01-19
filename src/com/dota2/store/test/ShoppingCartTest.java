package com.dota2.store.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dota2.store.beans.SetDetails;
import com.dota2.store.cart.ShoppingCart;

public class ShoppingCartTest {

	private ShoppingCart	shoppingCart;
	private SetDetails				setItem;
	private List<SetDetails>		listOfSets;
	private String			itemID;
	private int				numberOfItems;

	@Before
	public void setUp() throws Exception {

		shoppingCart = new ShoppingCart();
		setItem = new SetDetails();
		listOfSets = new ArrayList<SetDetails>();

		setItem.setSetID("1000");
		setItem.setSetName("AntiMage Set");
		setItem.setSetPrice(9.99);
		setItem.setSetQuality("Rare");

		listOfSets.add(setItem);

		itemID = setItem.getSetID();

	}

	@Test
	public void checkingAddItemsIncart() {
		shoppingCart.add(itemID, setItem);

		numberOfItems = shoppingCart.getNumberOfItems();

		assertEquals(1, numberOfItems);
	}

	@Test
	public void checkingRemoveItemsFromCart() {
		shoppingCart.remove(itemID);

		numberOfItems = shoppingCart.getNumberOfItems();

		assertEquals(0, numberOfItems);
	}

}
