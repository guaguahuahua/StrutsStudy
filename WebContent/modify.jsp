<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>modify.jsp</title>
<script type="text/javascript">
	function showConfirm(){
		var r=confirm("确认要修改？");
		return r;
	}
</script>
</head>
<body>
	<form action="updateInfor" method="post">
		
		<table>
			<s:iterator value="#request.student" var="stu">
				<tr>
					<td>stuId</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="stuId" value="<s:property value="#stu.stuId"/>"/>
					</td>
				</tr>
				<tr>
					<td>stuName</td>
				</tr>
				<tr>
					<td><input type="text" name="stuName" value="<s:property value="#stu.stuName"/>"/>	</td>
				</tr>
				<tr>
					<td>stuSex</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="stuSex"value="<s:property value="#stu.stuSex"/>"/>
					</td>
				</tr>
				<tr>
					<td>stuAge</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="stuAge" value="<s:property value="#stu.stuAge"/>"/>
					</td>
				</tr>
				<tr>
					<td>stuPhone</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="stuPhone" value="<s:property value="#stu.stuPhone"/>"/>
					</td>
				</tr>
			</s:iterator>
		</table>
		<input type="submit" value="修改" onclick="return showConfirm()"/>
	</form>
</body>
</html>