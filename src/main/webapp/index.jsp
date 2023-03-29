<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	String e_soLuong = request.getAttribute("e_soLuong") + "";
	String e_phonenumber = request.getAttribute("e_phonenumber") + "";
	String e_email = request.getAttribute("e_email") + "";

	String soLuong = request.getAttribute("soLuong") + "";
	String phonenumber = request.getAttribute("soDienThoai") + "";
	String email = request.getAttribute("email") + "";

	e_soLuong = e_soLuong.equalsIgnoreCase("null") ? "" : e_soLuong;
	e_phonenumber = e_phonenumber.equalsIgnoreCase("null") ? "" : e_phonenumber;
	e_email = e_email.equalsIgnoreCase("null") ? "" : e_email;

	soLuong = soLuong.equalsIgnoreCase("null") ? "" : soLuong;
	phonenumber = phonenumber.equalsIgnoreCase("null") ? "" : phonenumber;
	email = email.equalsIgnoreCase("null") ? "" : email;
	%>

	<div class="container mt-8">
		<form class="form-control" action="mua-hang" method="get">
			Số lượng cần mua: <input class="form-control" type="text"
				required="required" name="soLuong" value="<%=soLuong%>">
				<span class="rq"><%=e_soLuong %></span>
				 <br />
			Số điện thoại: <input class="form-control" type="text"
				required="required" name="soDienThoai" value="<%=phonenumber%>">
				<span class="rq"><%=e_phonenumber %></span>
			<br /> Email: <input class="form-control" type="email"
				required="required" name="email" value="<%=email%>">
				<span class="rq"><%=e_email %></span>
				 <br />
			<input class="btn btn-primary" type="submit" value="Mua hàng">
		</form>
	</div>
</body>
</html>