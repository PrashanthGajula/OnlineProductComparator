<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<!-- <body background="pharoBackground.png"> -->
<body bgcolor="#F5F5F5"> 
<!-- <body bgcolor="#F0F8FF"> -->

<center>
<H2><font face="Bradley Hand ITC" size="36">Online Product Comparator</font></H2>
<form name="login" method="post" action="regServlet">
<input type="hidden" name="pagename" value="login"/>
<h3 >Please Login here </h3>


  
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
	<td><a href="register.jsp">Register</a></td>
	</tr>
  </table>
<br><br>


 
<table>

    <tr>
    <td>
    <OBJECT id="VIDEO" CLASSID="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6" type="application/x-oleobject" 
width="420" height="340">

<PARAM NAME="URL" VALUE="images/video1.mp4">

<PARAM NAME="enabled" VALUE="True">

<PARAM NAME="AutoStart" VALUE="False">

<PARAM name="PlayCount" VALUE="3">

<PARAM name="Volume" VALUE="50">

<PARAM NAME="balance" VALUE="0">

<PARAM NAME="Rate" VALUE="1.0">

<PARAM NAME="Mute" VALUE="False">

<PARAM NAME="fullScreen" VALUE="False">

<PARAM name="uiMode" VALUE="full">

</OBJECT>
     </td>
     
    </tr>
  </table>
 
 

<!-- <table> -->
<!-- <tr> -->
<!-- <td>Username(email)</td> -->
<!-- <td><input type="text" name="txtUsername"/></td> -->
<!-- </tr> -->
<!-- <tr> -->
<!-- <td>Password</td> -->
<!-- <td><input type="password" name="txtPassword"></td> -->
<!-- </tr> -->
<!-- <tr><td></td> -->
<!-- <td></td> -->
<!-- </tr> -->
<!-- <tr> -->
<!-- <td><button type="submit" >Login</button></td> -->
<!-- <td><a href="register.jsp">Register</a></td> -->
<!-- </tr> -->
<!-- </table> -->
<br><br>

</form>
</center>

</body>
</html>