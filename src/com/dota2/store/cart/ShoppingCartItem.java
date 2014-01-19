package com.dota2.store.cart;

public class ShoppingCartItem {

	Object	items;
	int		quantity;

	public ShoppingCartItem(Object items2) {
		items = items2;
		quantity = 1;
	}

	public void incrementQuantity() {
		quantity++;
	}

	public void decrementQuantity() {
		quantity--;
	}

	public Object getItems() {
		return items;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
