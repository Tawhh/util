<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'stuall.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<SCRIPT language=JavaScript>
 function checkform(frm){
     var flag=true;
     if(frm.findone.value==""){
     alert("请输入要查询的内容");
     flag=false;
     }
     return flag;
 }
  function act1() 
{ 
document.testForm.action="Stucou_findcou"; //testForm为form表单的name
document.testForm.submit();
} 
  function act2() 
{ 
document.testForm.action="Stucou_findtea"; //testForm为form表单的name
document.testForm.submit();
} 
</SCRIPT>

	</head>
	<body style="background-color: #e4e9f1">
		&nbsp;&nbsp;&nbsp;
		
		<br>
		<center>
			${message}
		</center>
		<!--<form method="post">-->
		<table style="width: 700px;" align="center" border=1 bgcolor=#CDCDB4>
			<tr>
				<td>
					选课编号
				</td>
				<td>
					课程名称
				</td>
				<td>
					学生学号
				</td>
				<td>
					学生姓名
				</td>
				<td>
					操作
				</td>
			</tr>

			<s:iterator var="stucou" value="#session.list">
				<tr>
					<td>
						<s:property value="id" />
					</td>
					<td>
						<s:property value="course.cname" />
					</td>
					<td>
						<s:property value="student.sid" />
					</td>
					<td>
						<s:property value="student.sname" />
					</td>
					<td>
						<a href="Stucou_delete?name=${id}"
							onclick="return confirm('确认退选？')">退课</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
