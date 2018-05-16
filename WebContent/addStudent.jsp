<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>addStudent.jsp</title>
</head>
<body>
	<h4>请输入学生信息</h4>
	<form action="addStudent" method="post">
		<table>
			<tr>
				<td>stuId</td>
			</tr>
			<tr>
				<td><input type="text" name="stuId"/></td>
			</tr>
			<tr>
				<td>stuName</td>
			</tr>
			<tr>
				<td><input type="text" name="stuName"/></td>
			</tr>
			<tr>
				<td>stuSex</td>
			</tr>
			<tr>
				<td><input type="text" name="stuSex"/></td>
			</tr>
			<tr>
				<td>stuAge</td>
			</tr>
			<tr>
				<td><input type="text" name="stuAge"/></td>
			</tr>
			<tr>
				<td>stuPhone</td>
			</tr>
			<tr>
				<td><input type="text" name="stuPhone"/></td>
			</tr>
		</table>
		<input type="submit" value="提交">
	</form>
</body>
</html>