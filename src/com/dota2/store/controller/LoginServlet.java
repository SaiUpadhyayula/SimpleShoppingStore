package com.dota2.store.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dota2.store.beans.User;
import com.dota2.store.model.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	private Connection	conn;
	String				forwardUrl;
	User				user	= null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// helper function to check the credentials to the request.
		user = checkCredentials(request);

		if (user == null) {
			forwardUrl = "/index.jsp";
		} else {

			// checking whether the user is active i.e. Checking whether the
			// User Registration is confirmed or not.
			if (user.getActive() == 1) {
				startSession(request, response);
				forwardUrl = "/home.jsp";
			} else {
				// the user registration is not yet confirmed.
				forwardUrl = "/error.jsp";
			}
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}

	// Function to start the Session and create Shopping Cart
	private void startSession(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();

		// Adding the username and user id to the session.
		session.setAttribute("username", user.getUserName());
		session.setAttribute("id", user.getUserId());
	}

	/* Function to check user credentials. */
	private User checkCredentials(HttpServletRequest request) {

		try {
			conn = DBConnection.connect();

			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			String selectStatement = "select * from userdetails where username='" + userName + "' AND password='" + password + "'";
			PreparedStatement ps = conn.prepareStatement(selectStatement);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
