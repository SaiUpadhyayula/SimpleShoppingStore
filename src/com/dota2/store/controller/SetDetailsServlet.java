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

import com.dota2.store.beans.SetDetails;
import com.dota2.store.model.StoreController;

/**
 * Servlet implementation class SetDetailsServlet
 */
public class SetDetailsServlet extends HttpServlet {
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

		// request the present active Session.
		hs = request.getSession();

		int id = Integer.parseInt(request.getParameter("heroId"));

		try {
			// Returns the list of Set Details for the specific hero based on
			// HeroID.
			List<SetDetails> setDetailsList = StoreController.getSetDetailsList(id);

			// Adding the set details to the session.
			hs.setAttribute("setDetailsList", setDetailsList);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/store.jsp?page=setDetails");
			rd.forward(request, response);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
