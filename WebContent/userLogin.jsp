<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="form1" method="post" action="login">
  <table width="100" border="0" align="center">
    <tr>
      <td><div align="center">UserName:</div></td>
      <td><label for="username"></label>
      <input type="text" name="username" id="username"></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><label for="password"></label>
      <input type="password" name="password" id="password"></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td><input type="submit" name="Login" id="Login" value="Submit">     <input name="button" type="reset" id="button" value="Cancel"></td>
    </tr>
  </table>
</form>
</body>
</html>