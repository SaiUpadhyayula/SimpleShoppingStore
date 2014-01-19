<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
session.setAttribute("id", null);
session.setAttribute("username", null);	
response.sendRedirect("index.jsp");
%>