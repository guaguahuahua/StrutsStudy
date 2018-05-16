<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="com.service.StudentService"%>
<%@ page import="com.po.Student" %>
<%@ page import="java.util.*" %>

<%	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"
			+request.getServerName()+":"+request.getServerPort()
			+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>stuInfor.jsp</title>
</head>
<body>	
	<h1>学生信息查看处</h1>
	<%
		StudentService ss=new StudentService();
		List<Student> list=ss.queryAll();
	%>
	<table border="1">
	<caption>学生信息</caption>
	<tr>
	  <td>stuId</td>
	  <td>stuName</td>
	  <td>stuSex</td>
	  <td>stuAge</td>
	  <td>stuPhone</td>
	</tr>
	<%
		for(int i=0; i<list.size(); i++){
			Student s=list.get(i);
		
	%>
	<tr>
	  <td><%=s.getStuId() %></td>
	  <td><%=s.getStuName()%></td>
	  <td><%=s.getStuSex()%></td>
	  <td><%=s.getStuAge()%></td>
	  <td><%=s.getStuPhone()%></td>
	</tr>
	<%
		}
	%>
	</table>
</body>
</html>