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
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
 <s:iterator var="user" value="#session.list">
 <frameset rows="22%,78%">
   <frame src="main/top.jsp" name="top" frameborder="0" scrolling="no"> 
   <frameset cols="14%,86%">
   <s:if test="role.rid==3"><frame src="main/leftj.jsp" name="left"  frameborder="1" scrolling="no"></s:if>
   <s:if test="role.rid==2"><frame src="main/lefttea.jsp" name="left"  frameborder="1" scrolling="no"></s:if>
   <s:if test="role.rid==1"><frame src="main/leftstu.jsp" name="left"  frameborder="1" scrolling="no"></s:if>
   <frame src="main/right.jsp" name="right" frameborder="1" scrolling="auto"/>
   </frameset>
   </frameset>
 </s:iterator>
  
</html>
