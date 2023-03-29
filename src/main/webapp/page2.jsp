<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username =(String)session.getAttribute("username");
	%>
	
	
	Xin chao: <%=username %>
	page2
	<a href="page1.jsp">page1</a>
</body>
</html>