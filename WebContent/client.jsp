<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String cName=(String) session.getAttribute("cName"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>client.jsp</title>
</head>
<body>
	<p>欢迎<%=cName %></p>
	<a href="repairInfor.jsp">
		<input type="button" value="设备报修">
	</a>
	<a href="myOrder.jsp">
		<input type="button" value="我的订单"/>
	</a>
</body>
</html>