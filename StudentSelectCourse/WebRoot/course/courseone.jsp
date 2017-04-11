<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'courseone.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 	<SCRIPT language=JavaScript>
 
function checkform(frm){
     var flag=true;
     if(frm.findcourse.value==""){
     alert("请输入要查询的内容");
     flag=false;
     }
     return flag;
 }
 function act1() 
{ 
document.testForm.action="Course_coursefindid"; //testForm为form表单的name
document.testForm.submit();
} 
function act2() 
{ 
document.testForm.action="Course_coursefindtype"; 
document.testForm.submit();
} 
</SCRIPT>

	</head>
	<body style="background-color: #e4e9f1">
		&nbsp;&nbsp;&nbsp;
		<a href="Course_courseaddq">添加课程信息 </a>
		<table style="width: 700px;" align=center border=1 bgcolor=#EEE9BF>
			<tr>
					<td align=center>
						<form method=post action="" name=testForm
							onsubmit="return checkform(this)">
							请输入要查询的内容：
							<input type=text name="findcourse" size=25>
							<input type="submit" name="submit" value="按ID查询"
								onClick="act1();">
							<input type="submit" name="submit" value="按考试类型查询"
								onClick="act2();">
						</form>
					</td>

				</tr>
		</table>
		<br>
		<center>
			${message}
		</center>
		<!--<form method="post">-->
		<table style="width: 700px;" align="center" border=1 bgcolor=#CDCDB4>
			<tr>
				<td>
					课程ID
				</td>
				<td>
					教师
				</td>
				<td>
					名称
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
					操作
				</td>
				<td>
					操作
				</td>
			</tr>

			<s:iterator var="course" value="#session.listone">
				<tr>
					<td>
						<s:property value="cid" />
					</td>
					<td>
						<s:property value="teacher.tname" />
					</td>
					<td>
						<s:property value="cname" />
					</td>
					<td>
						<s:property value="classTime" />
					</td>
					<td>
						<s:property value="credit" />
					</td>
					<td>
						<s:property value="classHour" />
					</td>
					<td>
						<s:if test="classType==1">选修</s:if><s:else>必选</s:else>
					</td>
					<td>
						<s:property value="classAddr" />
					</td>
					<td>
						<s:if test="classProperty==1">考查</s:if><s:else>考试</s:else>
					</td>
					<td>
						<a href="Course_coursedelete?cid=${cid}"
							onclick="return confirm('确认删除？')">删除</a>
					</td>
					<td>
						<a
							href="Course_courseupdate?cid=${cid}">修改</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>
