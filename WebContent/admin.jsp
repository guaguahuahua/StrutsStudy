<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>admin.jsp</title>
<script type="text/javascript">
	function checkValid(){
		var adName=document.getElementById("adName");
 		var password=document.getElementById("password");
 		if(adName.value==""){
			alert("用户名不能为空");
			return false;
		} 
		if(password.value==""){
			alert("密码不能为空");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="login"  method="post">
		adminName:<br>
		<input type="text" id="adName" name="adName"> <br>
		password:<br>
		<input type="password" id="password" name="password"> <br>
		<input type="submit" value="login now" onclick="return checkValid()">
	</form>
</body>
</html>