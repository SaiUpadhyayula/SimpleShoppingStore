package com.dota2.store.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dota2.store.beans.SetDetails;
import com.dota2.store.cart.ShoppingCart;
import com.dota2.store.model.StoreController;

/**
 * Servlet implementation class Dispatcher
 */
public class ItemCatalogServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	HttpSession					hs;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request the present active Session.
		hs = request.getSession();
		ShoppingCart cart = (ShoppingCart) hs.getAttribute("cart");

		// Creates a shopping cart.
		if (cart == null) {
			cart = new ShoppingCart();
			hs.setAttribute("cart", cart);
		}

		String servletName = request.getServletPath();

		if (servletName.equals("/itemcatalog")) {

			String itemID = request.getParameter("Add");

			SetDetails sets = null;
			try {
				// Returns the Set Details based on the Set ID
				sets = StoreController.getSetDetailsByID(itemID);

				if (!(itemID == null)) {
					// If the set ID is not null then add the Set Details to the Shopping cart
					cart.add(itemID, sets);
				}

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/store.jsp?page=setDetails");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if (servletName.equals("/showcart")) {

			String removeParam = request.getParameter("Remove");

			if (removeParam != null) {
				// Removes the items from the Shopping Cart
				cart.remove(removeParam);
			}

			String clear = request.getParameter("Clear");

			if ((clear != null) && clear.equals("clear")) {
				// Clears the items from the Shopping Cart
				cart.clear();
			}

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/cartStore.jsp?page=showcart");
			rd.forward(request, response);
		}

	}

}
