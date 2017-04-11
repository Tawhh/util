<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userUpadte.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body style="background-color: #e4e9f1">
<br><br>
<center><font size=5 color=blue>用户信息修改</font></center>
  <form action="User_userupdate" method="post" onsubmit="return checkform(this)"><table style="width:550px;height=100px" align=center border=1 bgcolor=#EEE9BF>
  
  <tr>
  <td style=padding-left:90px;>用户ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：&nbsp;<%=request.getParameter("uid")%>
  <input type="hidden" name="uid"  size="25" value="<%=request.getParameter("uid")%>"/></td>
  </tr>
  
  <tr>
  <td style=padding-left:90px;>请输入用户名&nbsp;&nbsp;&nbsp;&nbsp;：
  <input type="text"  placeholder="<%=request.getParameter("username")%>" name="username" size="25" ></td>
  </tr>
  
  <tr>
  <td style=padding-left:90px;>请选择用户身份：&nbsp;<select name="role.rid" style="width:182px">
  <option value="1">学生</option>
  <option value="2">教师</option>
  <option value="3">管理员</option>
  </td>
  </tr>
  
  <tr>
  <td style=padding-left:90px;>请输入原密码&nbsp;&nbsp;&nbsp;&nbsp;：
  <input type="password" name="password1" size="25" ></td>
  <input type="hidden" name="password"   value="<%=request.getParameter("password")%>"/></td>
  </tr>
  
  <tr>
  <td style=padding-left:90px;>请输入新密码&nbsp;&nbsp;&nbsp;&nbsp;：
  <input type="password" name="password2" size="25" ></td>
  </tr>
  
  <tr>
  <td style=padding-left:90px;>请确认新密码&nbsp;&nbsp;&nbsp;&nbsp;：
  <input type="password" name="password3" size="25" ></td>
  </tr>
  
  <tr>
  <td align=center><input type="submit" name="submit" value="确认"> 
  <input type="reset" name="reset" value="重置"></td>
  
  </tr>
  
  </table>
  <center><td align=center>${message}</td></center>
  </form>
  
  <SCRIPT language=JavaScript>
function checkform(frm){
	var flag=true;
		if(frm.username.value==""||frm.password1.value==""||frm.password2.value==""||frm.password3.value=="")
		{
		  alert("输入不能为空,请检查！");
		
		  flag=false;		  
		}
	return flag;
}
</SCRIPT>
   
  </body>
</html>
