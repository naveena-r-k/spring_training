<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login">
<input type="hidden" name="requestAction" value="login"/>

	<table>
		<tr>
			<td>Username:</td>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password"></td>
		</tr>
		<%if(null!=request.getAttribute("errormsg"))
		{%>
			<b style="color: red">Invalid username or password</b>
		<% }
			%>
		<%if(null!=request.getAttribute("logoutmsg"))
		{%>
			<p>You have logged out successfully</p>
		<% }
			%>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
</form>
</body>
</html>