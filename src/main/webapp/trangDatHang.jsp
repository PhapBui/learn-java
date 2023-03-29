<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>dat hang</h1>
	<% 
	String username = request.getParameter("username");
	String quatity = request.getParameter("quantity");
	
	
	%>
	<h3><%=username%></h3>
	<p>Da dat <%=quatity+"<h3>Cac</h3>" %> hang</p>
</body>
</html>