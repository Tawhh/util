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
    
    <title>My JSP 'userall.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<SCRIPT language=JavaScript>
 function checkpage(){
     var flag=true;
     if(xx>pag){
     alert("页数输入错误");
     flag=false;
     }
     return flag;
 }
 
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
document.testForm.action="User_findid"; //testForm为form表单的name
document.testForm.submit();
} 
function act2() 
{ 
document.testForm.action="User_findname"; 
document.testForm.submit();
} 
function act3() 
{ 
document.testForm.action="User_findrole"; 
document.testForm.submit();
} 
</SCRIPT>

  </head>
  <body style="background-color:#e4e9f1">
  &nbsp;&nbsp;&nbsp;<a href="user/useradd.jsp">添加用户信息 </a>
<table style="width:700px;height=400px" align=center border=1 bgcolor=#EEE9BF>
<tr>
<tr>
<td align=center>
<form method=post action="" name=testForm onsubmit="return checkform(this)">请输入要查询的内容：
<input type=text name="findone" size=25 >
<input type="submit" name="submit1" value="按ID查询" onClick="act1();">
<input type="submit" name="submit2" value="按用户名查询" onClick="act2();">
<input type="submit" name="submit3" value="按角色查询" onClick="act3();">

</form>
</td>

</tr>
</table>
<br>
<center>${message}</center>
<!--<form method="post">-->
<table style="width:700px;height=400px" align="center" border=1 bgcolor=#CDCDB4>
<tr>
   <td>用户ID</td>
   <td>用户角色</td>
   <td>用户名</td>
   <td>用户密码</td>
   <td>操作</td>
   <td>操作</td>
</tr>

<s:iterator var="user" value="#session.list">
<tr>
<td ><s:property value="uid"/></td>
<td ><s:property value="role.rname"/></td>
<td ><s:property value="username"/></td>
<td ><s:property value="password"/></td>
<td><a href="User_userDelete?username=${username}" onclick="return confirm('确认删除？')">删除</a></td>
<td><a href="user/userUpadte.jsp?uid=${uid}&username=${username}&password=${password}">修改</a></td>
</tr>
</s:iterator>
</table>
<center>
<table border=1 style="width:700px;height=400px" bgcolor=#EEE9BF>
<tr>
<td>
<a href="User_userAll?page=1">首页</a>
		<a href="User_userAll?page=${curPage-1}">上一页</a>
		<a href="User_userAll?page=${curPage+1}">下一页</a>
		<a href="User_userAll?page=${pageCount}">尾页</a>
		第${curPage}页/共${pageCount}页/共${count}名用户
		</td>
		<td>
		<form action="User_userAll" onsubmit="return checkpage()">
			跳转到
			<input type="text" style="width: 30px" name="page">
			<input type="submit" value="GO" >页
		</form>
		<%
			String str = String.valueOf(request.getSession().getAttribute(
					"pageCount"));
		%>
		<%
			int pag = Integer.parseInt(str);
		%>
		<%
			String st = String.valueOf(request.getSession().getAttribute(
					"curPage"));
		%>
		<%
			int pa = Integer.parseInt(st);
		%>
</td>
<td>
		选择
		<SELECT name="Page"
			onchange="location.href='User_userAll?page='+this.value">
			<%
				for (int i = 1; i <= pag; i++) {
					if (i == pa) {
			%>
			<OPTION selected value="<%=i%>"><%=i%>
			</OPTION>
			<%
				} else {
			%>
			<OPTION value="<%=i%>"><%=i%>
			</OPTION>
			<%
				}
				}
			%>
		</SELECT>
		页
		</td>
		</tr>

</table>
</center>
<!-- </form>-->

  </body>
</html>
