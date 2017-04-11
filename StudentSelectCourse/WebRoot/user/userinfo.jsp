<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userinfo.jsp' starting page</title>
    
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
  <center><font size="6" color=black>用户信息</font></center>
  <br><br>
  <table style="width:400px;height=100px" align=center border=1 bgcolor=#CDCDB4>
  <tr>
  
  <tr>
  <td style=padding-left:110px;>
     用&nbsp;&nbsp;户&nbsp;&nbsp;ID:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.uid}
  </td>
  </tr>
   
  <tr>
  <td style=padding-left:110px;>
     用&nbsp;&nbsp;户&nbsp;&nbsp;名:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.username}
  </td>
  </tr>
 
  <tr>
  <td style=padding-left:110px;>用户角色：&nbsp;&nbsp;${user.role.rname}
  </tr>
  <tr>
  <td style=padding-left:110px;>用户密码：&nbsp;&nbsp;${user.password}</td>
  </tr>
  
  </tr>
  </table>
  </body>
</html>
