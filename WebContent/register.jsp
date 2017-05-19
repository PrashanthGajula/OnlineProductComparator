<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body bgcolor="#F5F5F5">
<center>
<H2><font face="Bradley Hand ITC" size="36">Online Product Comparator</font></H2>
<h3>Please fill the below form to get Registered !!!</h3>
<form name="registration" action="regServlet" method="post">
<input type="hidden" name="pagename" value="register"/>
<table>

<tr>
<td>Name</td>
<td><input type="text" name="txtname"/></td>
</tr>

<tr>
<td>Email</td>
<td><input type="text" name="txtemail"/></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="txtpassword"/></td>
</tr>

<tr>
<td>Gender</td>
<td><input type="radio" name="gender" id="Male" value="Male"><label for="Male">Male</label>
<input type="radio" name="gender" id="female" value="female"><label for="female">female</label></td>
</tr>

<tr>
<td>Age</td>
<td><select name="age">
<option >Select AGE</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
</select></td>
</tr>
<tr>
<td>Contact Number</td>
<td><input type="text" name="txtcontact"/></td>
</tr>
<tr>
<td><button type="submit">Register</button>
</td>
</tr>
</table>
</form>
<br>

</center>
</body>
</html>