<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 	String name=(String)session.getAttribute("name");	%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>welcome.jsp</title>
</head>
<body>
	
	<p>欢迎<%=name%></p>
	
	<a href="strutsInfor.jsp">
		<input type="button" value="查看学生信息">
	</a>
	<br>
	
</body>
</html>