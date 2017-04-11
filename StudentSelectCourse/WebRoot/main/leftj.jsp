<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
ul { padding:0; margin:0;}
#main1,#main2,#main3,#main4,#main5 { width:175px; height:35px; line-height:29px; padding-left:5px; background: #e4e9f1 url(../images/pro_left.png) center right no-repeat; cursor:pointer; border-bottom:1px solid #fff;}
#child1,#child2,#child3,#child4,#child5 { width:170px; background:#f1f1f1 url(../images/pro_down.png) center right no-repeat;}
#child1 ul li,#child2 ul li,#child3 ul li,#child4 ul li,#child5 ul li{ padding-left:5px; border-bottom:1px solid #fff; line-height:180%;}
#child1 ul li a,#child2 ul li a,#child3 ul li a,#child4 ul li a,#child5 ul li a{ color:red;}
</style>
  </head>
<body style= background-color:#e4e9f1;>
<div id="main1" onClick="document.all.child1.style.display=(document.all.child1.style.display =='none')?'':'none'" > <h3>+ 用户管理</h3></div>
<div id="child1" style="display:none">
<ul>
<li><a href="User_userAll" target=right>- 用户信息管理</a></li>
</ul>
</div>
<div id="main2" onClick="document.all.child2.style.display=(document.all.child2.style.display =='none')?'':'none'" > <h3>+ 课程管理</h3></div>
<div id="child2" style="display:none">
<ul>
<li><a href="Course_courseAll" target=right>- 课程信息管理</a></li>
</ul>
</div>
<div id="main3" onClick="document.all.child3.style.display=(document.all.child3.style.display =='none')?'':'none'" > <h3>+ 教师管理</h3></div>
<div id="child3" style="display:none">
<ul>
<li><a href="Tea_teaAll"  target=right>- 教师信息管理</a></li>
</ul>
</div>
<div id="main4" onClick="document.all.child4.style.display=(document.all.child4.style.display =='none')?'':'none'" > <h3>+ 学生管理</h3></div>
<div id="child4" style="display:none">
<ul>

<li><a href="Stu_stuAll" target=right>- 学生信息管理</a></li>
</ul>
</div>
<div id="main5" onClick="document.all.child5.style.display=(document.all.child5.style.display =='none')?'':'none'" > <h3>+ 选课</h3></div>
<div id="child5" style="display:none">
<ul>
<li><a href="Stucou_stucouall" target="right">- 选课信息</a></li>
</ul>
</div>
</body>
</html>