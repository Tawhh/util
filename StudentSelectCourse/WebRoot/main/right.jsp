<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'right.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color:#e4e9f1">
    <br><br>
<table style="width:700px;height:400px;"border=2 align=center><td>
<center>目的</center>
《学生成绩管理系统》是Web教学阶段的基础项目之一，它是对javaSe、数据库和Web阶段学习内容的综合应用，避免只知道孤立的知识点，而无法灵活合理利用的情况发生。
《学生成绩管理系统》是接近实战的项目，从需求分析开始到所有功能的实现，可以完整的锻炼学生的编程能力，使学生对java程序编写有一个整体的认识，并且提高学生解决实际问题的能力，为以后找工作打好基础。
    <center>1.1 角色分配</center>
《学生成绩管理系统》的使用人员主要有4类：系统管理员，教务管理员、教师、学生。因角色不同，拥有不同的权限。<br>
    <center>1.2 用户权限</center>
  1.2.1系统管理员能使用系统的所有功能:
 基础数据管理(班级信息管理、学生信息管理、教师信息管理、课程信息管理)、教务管理模块(教师授课信息管理、学生成绩分析、学生成绩封存)、学生成绩录入、学生成绩查询、系统管理模块(自动生成系统用户、手工生成系统用户、修改当前用户登录密码)。<br>
  1.2.2教务管理员能使用的功能有：
基础数据管理（包括：班级信息管理、学生信息管理、教师信息管理、课程信息管理）；;
教务管理（包括：教师授课信息管理、学生成绩分析、学生成绩封存）；
学生成绩录入；
学生成绩查询；
修改自己登录密码。<br>
  1.2.3 教师能使用的功能有： 
学生成绩录入、学生成绩查询、修改自己登陆密码。<br>
  1.2.4 学生能使用的功能有：
学生成绩查询、修改自己登录密码。
</td>
</table>
  </body>
</html>
