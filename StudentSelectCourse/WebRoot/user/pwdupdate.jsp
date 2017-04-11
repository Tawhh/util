<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pwdupdate.jsp' starting page</title>
    
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
		if(frm.password1.value==""||frm.password2.value==""||frm.password3.value=="")
		{
		  alert("请确认输入不为空！");
		 return onclick;
		  flag=false;		  
		}
	return flag;
}
</SCRIPT>
  </head>
  
  <body style="background-color:#e4e9f1">
   <center><font size="6" color=black>用户信息修改</font></center>
  <br><br>
    <form action="User_pwdupdate" onsubmit="return checkform(this)"><table style="width:550px;height=100px" align=center border=1 bgcolor=#CDCDB4>
  <tr>
  <td style=padding-left:110px;>
  用&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:&nbsp;&nbsp;  ${user.username}
  <input type="hidden" name=username value="${user.username}">
  </td>
  </tr>
 
  <tr>
  <td style=padding-left:110px;>请输入原密码：<input type="password" name="password1" size=25></td>
  <input type="hidden" name="password" value="${user.password}">
  </tr>
  <tr>
  <td style=padding-left:110px;>请输入新密码：<input type="password" name="password2" size=25></td>
  </tr>
  <tr>
  <td style=padding-left:110px;>请确认新密码：<input type="password" name="password3" size=25></td>
  </tr>
  <tr>
  <td align=center onclick="return confirm('确定修改？')"><input type=submit name=submit value="确认">
  <input type=reset name=reset value="重置">
  
  </tr>
  
  </table>
  <center><td align=center>${message}</td></center>
  </form>
  </body>
</html>
