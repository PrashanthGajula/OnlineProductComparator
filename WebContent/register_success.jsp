<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Successful</title>
</head>
<body bgcolor="#F5F5F5">
<center>
<form name="register_success" method="post" action="regServlet">
<input type="hidden" name="pagename" value="register_success"/>
<h3>Welcome User !!!</h3><br>

<br>
<h3>Registration Successful, Please login !!!</h3>
<table>
<tr>
<td>Username(email)</td>
<td><input type="text" name="txtUsername"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="txtPassword"></td>
</tr>
<tr><td></td><td></td></tr>
<tr>
<td><button type="submit" >Login</button></td>
</tr>
</table>
</form>
</center>
</body>
</html>