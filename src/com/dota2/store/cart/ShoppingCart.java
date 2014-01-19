package com.dota2.store.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.dota2.store.beans.SetDetails;

public class ShoppingCart {

	private HashMap<String, ShoppingCartItem>	items			= null;
	int											numberOfItems	= 0;

	public ShoppingCart() {
		items = new HashMap<String, ShoppingCartItem>();
	}

	public synchronized void add(String itemID, SetDetails setItems) {

		if (items.containsKey(itemID)) {
			ShoppingCartItem scitem = (ShoppingCartItem) items.get(itemID);
			scitem.incrementQuantity();
			System.out.println("quantity  " + scitem.getQuantity());
		} else {
			ShoppingCartItem newItem = new ShoppingCartItem(setItems);
			items.put(itemID, newItem);
			System.out.println("quantity is " + newItem.getQuantity());
		}
	}

	public synchronized List<ShoppingCartItem> getItems() {
		List<ShoppingCartItem> results = new ArrayList<ShoppingCartItem>();
		results.addAll(this.items.values());

		return results;
	}

	public synchronized int getNumberOfItems() {
		numberOfItems = 0;

		for (Iterator<ShoppingCartItem> i = getItems().iterator(); i.hasNext();) {
			ShoppingCartItem item = i.next();
			numberOfItems += item.getQuantity();
			//System.out.println("number of items is " + numberOfItems);
		}

		return numberOfItems;
	}

	public synchronized void remove(String itemID) {
		if (items.containsKey(itemID)) {
			ShoppingCartItem scitem = (ShoppingCartItem) items.get(itemID);
			scitem.decrementQuantity();

			if (scitem.getQuantity() <= 0) {
				items.remove(itemID);
			}

			numberOfItems--;
		}
	}

	public synchronized void clear() {
		System.err.println("Clearing cart.");
		items.clear();
		numberOfItems = 0;
	}

	public synchronized double getTotal() {
		
		double amount = 0.0;
		
		for(Iterator<ShoppingCartItem> i = getItems().iterator();i.hasNext();) {
			ShoppingCartItem item = (ShoppingCartItem)i.next();
			SetDetails s = (SetDetails)item.getItems();
			
			amount += (item.getQuantity() * s.getSetPrice());
		}
		return amount;

	}
}
