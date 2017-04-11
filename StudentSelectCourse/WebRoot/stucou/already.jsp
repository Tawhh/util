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

		<title>My JSP 'already.jsp' starting page</title>

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
		<center><font size=5 color=blue>已选课程</font></center>&nbsp;
		<table style="width:750px;height=400px" align=center border=1 bgcolor=#EEE9BF>
<tr>
<tr>
<td align=center>
<form method=post action="" name=testForm onsubmit="return checkform(this)">请输入要查询的内容：
<input type=text name="findone" size=25 >
<input type="submit" name="submit1" value="按课程查询" onClick="act1();">
<input type="submit" name="submit2" value="按教师查询" onClick="act2();">
</form>
</td>
</tr>
</table>
		<br>
		<center>
			${message}
		</center>
		<!--<form method="post">-->
		<table style="width: 750px;" align="center" border=1 bgcolor=#CDCDB4>
			<tr>
				<td>
					选课ID
				</td>
				<td>
					名称
				</td>
				<td>
				   教师
				</td>
				<td>
					时间
				</td>
				<td>
					学分
				</td>
				<td>
					课时
				</td>
				<td>
					类型
				</td>
				<td>
					地址
				</td>
				<td>
					属性
				</td>
				<td>
					状态
				</td>
				<td>
					操作
				</td>
			</tr>

			<s:iterator var="stuCou" value="listone">
				<tr>
					<td>
						<s:property value="id" />
					</td>

					<td>
						<s:property value="course.cname" />
					</td>
					<td>
						<s:property value="course.teacher.tname" />
					</td>
					<td>
						<s:property value="course.classTime" />
					</td>
					<td>
						<s:property value="course.credit" />
					</td>
					<td>
						<s:property value="course.classHour" />
					</td>
					<td>
						<s:if test="course.classType==1">选修</s:if>
						<s:else>必选</s:else>
					</td>
					<td>
						<s:property value="course.classAddr" />
					</td>
					<td>
						<s:if test="course.classProperty==1">考查</s:if>
						<s:else>考试</s:else>
					</td>
					<td>
						已选
					</td>
					<td>
						<a href="Stucou_deleteone?id=<s:property value="id" />&student.sid=<s:property value="student.sid" />">退选<s:property value="student.sid" /></a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
