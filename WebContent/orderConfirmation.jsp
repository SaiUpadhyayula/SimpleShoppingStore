<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="justify">
<p>Thank you for placing the Order for the below items:
<table>
	<c:forEach var="order" items="${sessionScope.cart.items }">
		<c:set var="itemOrdered" value="${order.items}" />
		<tr>
			<td>${itemOrdered.setName}</td>
			<td>${order.quantity}</td>
		</tr>

	</c:forEach>
</table>
</div>