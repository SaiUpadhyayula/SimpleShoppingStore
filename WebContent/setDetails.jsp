<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DotaStore</title>
</head>
<body>
	<!--  Invoked when the use adds any item to the cart-->
	<c:if test="${!empty param.Add}">
		<c:set var="id" value="${param.Add}" />
		<c:set var="setName" value="${param.name}" />
		<p>
			You added <font color="red" size="+2"> <strong>${setName}</strong>
			</font>to your shopping cart.
		</p>
	</c:if>

	<!-- Invoked if an item is added to the cart and the number of items are greater than 0 -->
	<c:if test="${sessionScope.cart.numberOfItems > 0}">
		<p>
			<c:url var="url" value="/showcart">
				<c:param name="Clear" value="0" />
				<c:param name="Remove" value="0" />
			</c:url>
			<a href="${url}">Show Cart</a>&nbsp;&nbsp;&nbsp;
			<c:url var="url" value="/buyItems"/>
			<a href="${url}">Buy Items</a>
		</p>
		<p>&nbsp;</p>
	</c:if>
	<c:forEach var="setList" items="${setDetailsList}">
		<div align="center">

			<table width="541" height="201" border="1">
				<tr>
					<td width="335" height="33"><c:url var="url"
							value="/itemDetails">
							<c:param name="setID" value="${setList.setID}" />
						</c:url> <a href="${url}">${setList.setName}</a></td>
					<td width="355" rowspan="4"><img src="images/Anointed_Armor_of_Ruination_Set.png" width="256" height="171" alt="abaddon.png" longdesc="images/Anointed_Armor_of_Ruination_Set.png"></td>
				</tr>
				<tr>
					<td height="42">Price: ${setList.setPrice}</td>
				</tr>
				<tr>
					<td height="70">Quality: ${setList.setQuality}</td>
				</tr>
				<tr>
					<td height="42"><div align="center">
						<!--  Adds the specific item to the cart.-->
							<c:url var="url2" value="/itemcatalog">
								<c:param name="Add" value="${setList.setID}" />
								<c:param name="name" value="${setList.setName}" />
							</c:url>
							<a href="${url2}">Add to Cart</a>
						</div></td>
				</tr>
			</table>
		</div>

	</c:forEach>
	<p>&nbsp;</p>
</body>
</html>