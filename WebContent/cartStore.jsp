<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/shop.css">
	<title>Dota Shopping Store</title> <script type="text/javascript">
		function getItems() {
			location = document.form1.category.options[document.form1.category.selectedIndex].value
		}
	</script>
</head>

<body>
	<p><jsp:include page="header.jsp" /></p>

	<div align="justify" id="body">
		<table width="1160" height="557" align="center" border="0">
			<tr>
				<td height="452"><table width="1148" height="392" border="0">
						<tr>
							<td><p><jsp:include page="${param.page}.jsp" /></p>
								<p>&nbsp;</p>
								<p>
									<br />
								</p></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>

	<p><jsp:include page="footer.jsp" /></p>
</body>
</html>
