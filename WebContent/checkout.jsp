<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="total" value="${sessionScope.cart.total}" />
<div align="justify">
<p>Total Price : ${total} USD
<p>Please provide your Credit/Debit Card Details
</div>
<div align="justify">
<form id="form1" name="form1" method="post" action="cartStore.jsp?page=orderConfirmation">
	<table width="494" height="172" border="0">
		<tr>
			<td>Name on Card</td>
			<td><label for="name"></label> <input type="text" name="name"
				id="name" /></td>
		</tr>
		<tr>
			<td>Card Type</td>
			<td><p>
					<label> <input type="radio" name="CardTypeRadioGroup"
						value="master_card" id="CardTypeRadioGroup_0" /> Master Card
					</label> <label> <input type="radio" name="CardTypeRadioGroup"
						value="visa_card" id="CardTypeRadioGroup_1" /> Visa Card
					</label> <br />
				</p></td>
		</tr>
		<tr>
			<td>Card Number</td>
			<td><label for="cvv"></label> <input type="text" name="cnumber"
				id="cnumber" /></td>
		</tr>
		<tr>
			<td>CVV</td>
			<td><label for="cvv"></label> <input type="password" name="cvv2"
				id="cvv" /></td>
		</tr>
		<tr>
			<td>Expiry Date(mmyyyy)</td>
			<td><label for="expiry_date"></label> <input type="text"
				name="expiry_date" id="expiry_date" /></td>
		</tr>
		<tr>
			<td><p>
					<label> <input type="checkbox" name="RememberCardGroup"
						value="remember" id="RememberCardGroup_0" /> Remember my Card
					</label> <br />
				</p></td>
			<td><input type="submit" name="submit" id="submit"
				value="Submit" />&nbsp; <input type="reset" name="clear" id="clear"
				value="Reset" />&nbsp;</td>
		</tr>
	</table>
</form>
</div>
</p>