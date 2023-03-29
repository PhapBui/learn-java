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
	
		if(username!=null){
	%>
	
		<jsp:forward page="success.jsp"></jsp:forward>
	<%} %>
	
	Xin chao: <%=username %>

		<form action="login" method="POST">
			<h1>Login</h1>
			<div>
				<label for="user">User</label>
				<input type="text" name="username" id="user">
			</div>
			<div>
				<label for="pw">Password</label>
				<input type="password" name="pw" id="pw">
			</div>
			<button type="submit">Login</button>
		</form>
</body>
</html>