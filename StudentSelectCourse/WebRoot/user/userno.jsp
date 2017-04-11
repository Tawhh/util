<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userno.jsp' starting page</title>
    
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
	<body style="background-color: #e4e9f1">
	&nbsp;&nbsp;&nbsp;<a href="user/useradd.jsp">添加用户信息 </a>
		<table style="width: 700px;" align=center border=1 bgcolor=#EEE9BF>
			<tr>
				<td align=center>
					<form method=post action="" name=testForm
						onsubmit="return checkform(this)">
						请输入要查询的内容：
						<input type=text name="findone" size=25>
						<input type="submit" name="submit1" value="按ID查询"
							onClick="act1();">
						<input type="submit" name="submit2" value="按用户名查询"
							onClick="act2();">
						<input type="submit" name="submit3" value="按角色查询"
							onClick="act3();">
					</form>
				</td>

			</tr>
		</table>
		<br>
		<center>
			${message}
		</center>

	</body>
</html>
