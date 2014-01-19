package com.dota2.store.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dota2.store.model.DBConnection;

/**
 * Servlet implementation class MailActivationServlet
 */
public class MailActivationServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;
	private Connection			conn;
	Statement					statement			= null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key");
		String url = "/userLogin.jsp";
		long userKey = Long.parseLong(key);
		boolean flag = getUserDetailsByKey(userKey);

		if (flag == true) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

	private boolean getUserDetailsByKey(long userKey) {
		try {
			conn = DBConnection.connect();

			String sql = "update userdetails u " + "left join useractivation u2" + " on u.userid = u2.userid " + "set active='1' " + "where u2.emailKey = '" + userKey + "';";
			statement = conn.createStatement();
			int result = statement.executeUpdate(sql);

			if (result == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
