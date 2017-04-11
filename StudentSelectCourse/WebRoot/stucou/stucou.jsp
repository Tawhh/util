<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'stucou.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<SCRIPT language=JavaScript>
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
document.testForm.action="Stucou_findcou"; //testForm为form表单的name
document.testForm.submit();
} 
  function act2() 
{ 
document.testForm.action="Stucou_findtea"; //testForm为form表单的name
document.testForm.submit();
} 
</SCRIPT>

	</head>
	<body style="background-color: #e4e9f1">
		&nbsp;&nbsp;&nbsp;
		<table style="width: 700px;" align=center border=1 bgcolor=#EEE9BF>
			<tr>
				<tr>
					<td align=center>
						<form method=post action="Stucou_findcou"
							onsubmit="return checkform(this)">
							请输入要查询的内容：
							<input type="text" name="findone" size=25>
							<input type="submit" name="submit1" value="查询" onClick="act1();">
						</form>
					</td>

				</tr>
		</table>
		<br>
		<center>
			${message}
		</center>
		<!--<form method="post">-->
		<table style="width: 700px;" align="center" border=1 bgcolor=#CDCDB4>
			<tr>
				<td>
					课程编号
				</td>
				<td>
					课程名称
				</td>
				<td>
					教师姓名
				</td>
				<td>
					课程时间
				</td>
				<td>
					课程学分
				</td>
				<td>
					报名人数
				</td>
				<td>
					操作
				</td>
				<td>
					操作
				</td>
			</tr>

			<s:iterator var="stu" value="#session.list">
				<tr>
					<td>
						<s:property value="id" />
					</td>
					<td>
						<s:property value="name" />
					</td>
					<td>
						<s:property value="tname" />
					</td>
					<td>
						<s:property value="time" />
					</td>
					<td>
						<s:property value="credit" />
					</td>
					<td>
						<s:property value="sum" />
					</td>
					<td>
						<s:if test="sum==0">无操作</s:if>
						<s:else>
							<a href="Stucou_delete?name=${id}"
								onclick="return confirm('确认退选？')">退课</a>
						</s:else>

					</td>
					<td>
						<s:if test="sum==0">无操作</s:if>
						<s:else>
							<a href="Stucou_find?name=${id}">查看</a>
						</s:else>
						
					</td>
				</tr>
			</s:iterator>
		</table>
		<center>
			<table border=1 style="width: 700px;" bgcolor=#EEE9BF>
				<tr>
					<td>
						<a href="Stucou_stucouall?page=1">首页</a>
						<a href="Stucou_stucouall?page=${curPage-1}">上一页</a>
						<a href="Stucou_stucouall?page=${curPage+1}">下一页</a>
						<a href="Stucou_stucouall?page=${pageCount}">尾页</a>
						第${curPage}页/共${pageCount}页/共${count}条信息
					</td>
					<td>
						<form action="Stucou_stucouall" onsubmit="return checkpage()">
							跳转到
							<input type="text" style="width: 30px" name="page">
							<input type="submit" value="GO">
							页
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
							onchange="location.href='Stucou_stucouall?page='+this.value">
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
	</body>
</html>
