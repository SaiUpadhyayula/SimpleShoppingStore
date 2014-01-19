<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="0">
			<tr>
				<td>HeroName</td>
				<td>Hero NickName</td>
			</tr>
			<c:forEach var="list" items="${herosList}">
				<tr>
					<c:set var="heroId" value="${list.heroID}" />
					<!--  Invokes the set Details page-->
					<c:url var="url" value="/setDetails">
						<c:param name="heroId" value="${heroId}" />
					</c:url>
					<td ><a href="${url}"><strong>${list.heroName}</strong></a></td>
					<td >${list.heroDescription}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>