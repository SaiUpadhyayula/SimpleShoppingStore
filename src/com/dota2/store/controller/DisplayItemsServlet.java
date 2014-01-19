package com.dota2.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dota2.store.beans.Hero;
import com.dota2.store.cart.ShoppingCart;
import com.dota2.store.model.StoreController;

/**
 * Servlet implementation class ItemCatalogServlet
 */
public class DisplayItemsServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	HttpSession					hs;
	ShoppingCart				cart;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// request the present active Session.
		hs = request.getSession();

		StoreController ic = new StoreController();
		// returns the List of heros
		List<Hero> hero = ic.getHerosList();

		// set the list of heros to the session.
		hs.setAttribute("herosList", hero);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/store.jsp?page=herosList");
		rd.forward(request, response);

	}

}
