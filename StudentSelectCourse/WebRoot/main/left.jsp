<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <style type="text/css">
   a{ color:#333; text-decoration:none;}
   a:hover{ color:#30F; text-decoration:underline;}
   a:active{ color:#30F;}  
    body, ul, li{margin: 0;padding: 0;}  
    body { background-color:#e4e9f1; color:#002446; margin: 0; }  
    input, select, textarea, th, td { font-size: 1em; }  
    ol.tree {padding: 0 0 0 30px;width: 300px;}  
    li {position: relative;margin-left: -15px;list-style: none;}  
    li.file{margin-left: -18px !important;}  
    li.file a{background: url(document.png) 0 0 no-repeat;color: #002446;padding-left: 21px;text-decoration:none;display: block;}  
    li input{position: absolute;left: 0;margin-left: 0;opacity: 0;z-index: 2;cursor: pointer;height: 1em;width:1em;top: 0;}  
    input + ol{display: none;}  
    input + ol > li { height: 0; overflow: hidden; margin-left: -14px !important; padding-left: 1px; }  
    li label {cursor: pointer;display: block;padding-left: 17px;background: url(toggle-small-expand.png) no-repeat 0px 1px;}  
    input:checked + ol {background: url(toggle-small.png) 44px 5px no-repeat;margin: -22px 0 0 -44px;padding:27px 0 0 80px;height: auto;display: block;}  
    input:checked + ol > li { height: auto;}  
  
</style>  
  </head>
  
  <body>
  <br>
  <table>
    <ol class="tree">
    <li>
    <lable for="one">数据信息管理</lable><input type="checkbox" id="one"/>
           <ol>
           <li class="file"><a href="User_userAll" target=right>用户信息管理</a></li>
           <li class="file"><a href="Course_courseAll" target=right>课程信息管理</a></li>
           <li class="file"><a href="Tea_teaAll"  target=right>教师信息管理</a></li>
           <li class="file"><a href="Stu_stuAll" target=right>学生信息管理</a></li>
           </ol>
    </li>
    <br><br><br>
    <li>
    <lable for="two"><a href="Score_scoreRefer" target="right">学生成绩查询</a></li>
    <br><br><br>
    <li>
    <lable for="two"><a href="#">学生成绩分析</a></li>
    <br><br><br>
    <li>
    <lable for="two"><a href="#">系统管理</a></li>
    <br><br><br>
    <li>
    <lable for="two"><a href="main/xgmm.jsp" target="right">修改密码</a></li>
    
   
   
     </ol>   
     </table>
  </body>
</html>
