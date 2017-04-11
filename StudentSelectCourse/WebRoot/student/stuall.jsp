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
    
    <title>My JSP 'stuall.jsp' starting page</title>
    
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
document.testForm.action="Course_coursefindid"; //testForm为form表单的name
document.testForm.submit();
} 
</SCRIPT>

	</head>
	<body style="background-color: #e4e9f1">
		&nbsp;&nbsp;&nbsp;
		<a href="student/stuAdd.jsp">添加学生信息 </a>
		<table style="width: 700px;" align=center border=1 bgcolor=#EEE9BF>
			<tr>
				<tr>
					<td align=center>
						<form method=post action="Stu_findid"
							onsubmit="return checkform(this)">
							请输入要查询的内容：
							<input type="text" name="findone" size=25>
							<input type="submit" name="submit1" value="按ID查询"
								onClick="act1();">
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
					学生ID
				</td>
				<td>
					姓名
				</td>
				<td>
					性别
				</td>
				<td>
					院校
				</td>
				<td>
					专业
				</td>
				<td>
					课时
				</td>
				<td>
					学分
				</td>
				<td>
					操作
				</td>
				<td>
					操作
				</td>
			</tr>

			<s:iterator var="student" value="#session.liststu">
				<tr>
					<td>
						<s:property value="sid" />
					</td>
					<td>
						<s:property value="sname" />
					</td>
					<td>
						<s:if test="sex==1">男</s:if>
						<s:else>女</s:else>
					</td>
					<td>
						<s:property value="sc" />
					</td>
					<td>
						<s:property value="major" />
					</td>
					<td>
						<s:property value="sumClassHour" />
					</td>
					<td>
						<s:property value="sumCredit" />
					</td>
					<td>
						<a href="Stu_delete?sid=${sid}" onclick="return confirm('确认删除？')">删除</a>
					</td>
					<td>
						<a
							href="Stu_update1?sid=${sid}">修改</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<center>
			<table border=1 style="width: 700px;" bgcolor=#EEE9BF>
				<tr>
					<td>
						<a href="Stu_stuAll?page=1">首页</a>
						<a href="Stu_stuAll?page=${curPage-1}">上一页</a>
						<a href="Stu_stuAll?page=${curPage+1}">下一页</a>
						<a href="Stu_stuAll?page=${pageCount}">尾页</a>
						第${curPage}页/共${pageCount}页/共${count}名学生
					</td>
					<td>
						<form action="Stu_stuAll" onsubmit="return checkpage()">
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
							onchange="location.href='Stu_stuAll?page='+this.value">
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
