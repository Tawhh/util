<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
    <body  background="images/5.jpg" height="100%" width="100%">
 
 <form action="User_login" method="post" onsubmit="return checkform(this)">  
<div style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">      
<img src="images/5.jpg" height="100%" width="100%" style="left:0; top:0;">      
</div>
 <center><font size=10>欢迎登陆</font></center>
<br><br><br><br><br>
<center><td align=center><font size=4 color="blue">${message}</font></td></center>
  <form method="post" onsubmit="return checkform(this)">
  <table align="center" heigh="100%" width="100%">
  <tr align="center">
  <td align="center">
  <table>
  <tr align=center>
  </tr>
  <tr><td>
  
  账&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text"  name="username"/></td>
  </tr>
  <tr><td>
  密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"></td></td>
  </tr>
  <tr align=center>
  </tr>
  
  <tr align=center><td>
 <input type=submit name=deng value=登陆>
 <input type=button name=zhu value=注册 onclick="window.location.href('register.jsp')">
  </td></tr>

  </table>
  </td>
  </tr>
  </table>
   </form>
   </form>
   
   <SCRIPT language=JavaScript>
function checkform(frm){
	var flag=true;
		if(frm.username.value==""||frm.password.value=="")
		{
		  alert("用户名或密码不能为空！");
		
		  flag=false;		  
		}
	return flag;
}
function keyPress() {    
     var keyCode = event.keyCode;    
     if ((keyCode >= 48 && keyCode <= 57))    
    {    
         event.returnValue = true;    
     } else {    
           event.returnValue = false;    
    }    
 }    
</SCRIPT>
  </body>
</html>
