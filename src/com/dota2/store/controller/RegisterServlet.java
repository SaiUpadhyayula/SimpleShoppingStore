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

import com.dota2.store.beans.User;
import com.dota2.store.mails.Mailer;
import com.dota2.store.model.DBConnection;
import com.dota2.store.util.GenerateUUID;

/**
 * Servlet implementation class RegisterServlet
 */
@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {

	private Connection	conn;
	String				forwardUrl;
	User				user	= null;
	StringBuffer emailText = new StringBuffer("Please click the below URL to confirm your registration in Dota2Store." +
			"http://localhost:8181/Dota2Store/activate?key=");
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean flag = registerUser(request);

		if (flag == true) {
			int userID = getUserIDActivation(request);
			String emailID = getUserDetails(userID);
			long uid = GenerateUUID.generateUUID();
			insertActivationDetails(userID, uid);
			sendMessage(emailText,uid,emailID);
			forwardUrl = "/userRegister.jsp";

		} else {
			forwardUrl = "/userLogin.jsp";
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher(forwardUrl);
		rd.forward(request, response);

	}

	private String getUserDetails(int userID) {
		try {
			conn = DBConnection.connect();


			String selectStatement = "select email from userdetails where userid='" + userID +"'";
			PreparedStatement ps = conn.prepareStatement(selectStatement);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private void sendMessage(StringBuffer emailText2, long uid, String emailID) {
			StringBuffer emailMessageLink = emailText2.append(uid);
			String str_emailMessageLink = emailMessageLink.toString();
			Mailer m = new Mailer();
			m.setPropsAndSendEmail(emailID, str_emailMessageLink);
	}

	private boolean insertActivationDetails(int userID, long uid) {
		try {
			conn = DBConnection.connect();

			String insertStatement = "insert into useractivation(emailKey,UserID) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(insertStatement);
			ps.setLong(1, uid);
			ps.setInt(2, userID);

			int result = ps.executeUpdate();

			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	private int getUserIDActivation(HttpServletRequest request) {
		try {
			conn = DBConnection.connect();

			String userName = request.getParameter("username");
			String password = request.getParameter("password");

			String selectStatement = "select userid from userdetails where username='" + userName + "' AND password='" + password + "'";
			PreparedStatement ps = conn.prepareStatement(selectStatement);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	private boolean registerUser(HttpServletRequest request) {
		try {
			conn = DBConnection.connect();
			String insertStatement = "insert into userdetails (UserName,Password,Email,PhoneNumber) values (?,?,?,?)";
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			PreparedStatement pst = conn.prepareStatement(insertStatement);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, phone);

			int result = pst.executeUpdate();

			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
