<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<%@ page import="java.util.*" %>
<%@ page import="com.po.Student" %>
<%	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//从request对象中提取action传递的值
	List <Student> list=(List<Student>)request.getAttribute("studentList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>strutsInfor.jsp</title>
<script type="text/javascript">
	function showConfirm(){
		var variable=confirm("确认要进行删除？");
		return variable;
	}
</script>

</head>
<body>
	<a href="<%=path%>/query.action">
		<input type="button" value="查询"/>
	</a>
	
	<a href="<%=path%>/addStudent.jsp">
		<input type="button" value="添加学生信息">
	</a>
	
	<table border="1">
	<caption>学生信息</caption>
	<tr>
	  <td>stuId</td>
	  <td>stuName</td>
	  <td>stuSex</td>
	  <td>stuAge</td>
	  <td>stuPhone</td>
	  <td>operation</td>
	</tr>
	<!--这块需要使用request对象才能获得值栈中的action传递的值-->
	<s:iterator value="#request.studentList" var="stu">
	<tr>
	  <td><s:property value="#stu.stuId"/> </td>
	  <td>
	  	<a href="<%=path%>/StudentAction/modify.action?stuId=<s:property value="#stu.stuId"/>">
	  		<s:property value="#stu.stuName"/>
	  	</a>
	  </td>
	  <td><s:property value="#stu.stuSex"/>  </td>
	  <td><s:property value="#stu.stuAge"/>  </td>
	  <td><s:property value="#stu.stuPhone"/></td>
	  <!--删除的路径-->
	  <td>
	  		<a href="<%=path%>/deleteStudent.action?stuId=<s:property value="#stu.stuId"/>" 
	  		   onclick="return showConfirm()">
	  		   delete
	  		</a>
	  </td>
	</tr>
	</s:iterator>
	</table>
</body>
</html>