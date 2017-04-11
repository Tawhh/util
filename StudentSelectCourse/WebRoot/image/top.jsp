<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="background-color: #CDCDB4">
    <center><font size="8">欢迎登陆</font></center>
     <tr><font style="margin-left:20px;" size="5">您好:</font><td><font size="5">${user.getUsername()}</font></td></tr>
      <div style="position:absolute;left:1000PX;top:70px;width:100px;height:14px;"><table><tr><td><a onclick='parent.left.location="left.jsp";parent.right.location="right.jsp";'><input type=button value=返回首页 style="background: rgb(205, 179, 139) none repeat scroll 0% 0%; width: 70px; height: 30px;"></a>
    </td><td><input type="button"  onclick="aaa()" value="退出" style="background: rgb(205, 179, 139) none repeat scroll 0% 0%; margin-left: px; width: 70px; height: 30px;"></td></tr><table></div>
  <script type="text/javascript">
  
	function aaa(){
	window.parent.frames.location.href="<%=basePath%>index.jsp" ;
	}
</script>
  
  </body>
</html>
