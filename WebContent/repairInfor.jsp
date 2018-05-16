<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>repairInfor.jsp</title>
<script>
	function checkEquipName(){
		var v=repairList.equipName.value;
		var show=document.getElementById("showEquipName");
		if(v.trim().length==0){
			show.innerHTML="设备名称不能为空";
			return false;
		}else{
			show.innerHTML="";
			return true;
		}
	}
	function checkProblem(){
		var v=repairList.problem.value;
		var show=document.getElementById("showProblem");
		if(v.trim().length==""){
			show.innerHTML="问题描述不能为空";	
			return false;
		}else{
			show.innerHTML="";
			return true;
		}		
	}	
	function checkPhone(){
		var v=repairList.phone.value;
		var show=document.getElementById("showPhone");
		if(v.trim().length==""){
			show.innerHTML="联系电话不能为空";	
			return false;
		}else{
			show.innerHTML="";
			return true;
		}
	}
	function checkAddress(){
		var v=repairList.address.value;
		var show=document.getElementById("showAddress");
		if(v.trim().length==""){
			show.innerHTML="通信地址不能为空";	
			return false;
		}else{
			show.innerHTML="";
			return true;
		}		
	}
	
	function giveUp(){
		var v=confirm("确认放弃！");
		return v;
	}
</script>
</head>
<body>

	<p>欢迎<%=session.getAttribute("cName") %></p>
	<form name="repairList" action="repairRequest" method="post">
		设备名称：<br>
		<input type="text" name="equipName" onblur="checkEquipName()"/>
		<p id="showEquipName" style="color:red;font-size:14px"></p>
		问题描述：<br>
		<textarea col="40" row=4 style="OVERFLOW:visiable" name="problem" onblur="return checkProblem()"></textarea>
		<p id="showProblem" style="color:red;font-size:14px"></p>
		联系电话<br>
		<input type="text" name="phone" onblur="return checkPhone()"/>
		<p id="showPhone" style="color:red;font-size:13px"></p>
		地址<br>
		<textarea col="40" row="4" style="OVERFLOW:visiable" name="address" onblur="return checkAddress()"></textarea>
		<p id="showAddress" style="color:red;font-size:14px"></p>
		<input type="submit" value="提交">	
	</form>
	<a href="client.jsp" onclick="return giveUp()">
		<input type="button" value="放弃">
	</a>	
</body>
</html>