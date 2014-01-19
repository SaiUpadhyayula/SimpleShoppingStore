package com.dota2.store.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dota2.store.beans.Items;
import com.dota2.store.model.StoreController;

/**
 * Servlet implementation class ItemDetailsServlet
 */
public class ItemDetailsServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	HttpSession					hs;

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

		hs = request.getSession();
		
		int setID = Integer.parseInt(request.getParameter("setID"));

		try {

			List<Items> itemDetailsList = StoreController.getItemDetailsList(setID);

			hs.setAttribute("itemDetailsList", itemDetailsList);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/store.jsp?page=itemDetails");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
