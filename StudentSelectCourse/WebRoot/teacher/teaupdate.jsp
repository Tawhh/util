<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'teaupdate.jsp' starting page</title>
    
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
<center><font size=5 color=blue>教师信息修改</font></center>
  <form action="Tea_update" method="post" onsubmit="return checkform(this)"><table style="width:550px;height=100px" align=center border=1 bgcolor=#EEE9BF>
  
  <tr>
  <td style=padding-left:90px;>教师ID&nbsp;：&nbsp;<%=request.getParameter("tid")%>
  <input type="hidden" name="tid"  size="25" value="<%=request.getParameter("tid")%>"/></td>
  </tr>
  
  <tr>
  <td style=padding-left:90px;>姓名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;
  <input type="text"   name="tname" size="25" ></td>
  </tr>
  
  <tr>
  <td style=padding-left:90px;>性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：&nbsp;<select name="sex" style="width:182px">
  <option value="1">男</option>
  <option value="2">女</option>
  </td>
  </tr>
  
  <tr>
  <td style=padding-left:90px;>院校&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：
  <input type="text" name="sc" size="25" ></td>
  </tr>
  
  <tr>
  <td style=padding-left:90px;>院系&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：
  <input type="text" name="major" size="25" ></td>
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
