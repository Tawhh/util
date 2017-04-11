<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <SCRIPT language=JavaScript>
function checkform(frm){
	var flag=true;
		if(frm.uid.value==""||frm.password.value==""||frm.uname.value=="")
		{
		  alert("注册信息不能为空！");
		
		  flag=false;		  
		}
	return flag;
}

</SCRIPT>
  <body  background="../images/5.jpg" >
 
<div style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">      
<img src="images/5.jpg" height="100%" width="100%" style="left:0; top:0;">      
</div>
<center>
<form action="User_userRegister" method="post" onsubmit="return checkform(this)">  
  <table border=0>
  <cenetr><font size="8" color=black>欢迎注册</font></center>
  <br><br><br>
 <tr>
<td> 用户名：</td>
<td><input type=text name="username" ></td>
 </tr>
 <tr>
<td> 密码：</td>
<td><input type=password name="password"></td>
 </tr>
   <tr>
  <td> 身份：</td><td><select name="role.rid">
   <option value="1">学生</option>
    <option value="2" selected>教师</option>
     </tr>
     <tr align=center>
     <td colspan=2>
     <input type="submit" name=submit value="提交"/>&nbsp;
     <input type=reset name=reset value="重置"/>
     </td>
     </tr>
     </table>
    
   </form>
   </center>
  
<center><tr><td><font size=4 color="blue">${message}</font></td></tr></center>
  </body>

  </body>
</html>
