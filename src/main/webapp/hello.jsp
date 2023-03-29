

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web with  Java</title>
</head>
<body>
	<h1>Hello World</h1>
	<p><%=4+5 %></p>
	<%=getServletContext().getRealPath("/") %>
	<form action="trangDatHang.jsp" method="Get">
		<label for="name"> User name
		</label>
		<input id="name" name="username">
		<label for="qty"> Quantity
		</label>
		<input id="qty" name="quantity">
		<label> Submit
		<input type="submit">
		</label>
	</form>
</body>
</html>