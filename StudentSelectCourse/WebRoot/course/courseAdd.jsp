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

		<title>My JSP 'courseAdd.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<SCRIPT language=JavaScript>
function checkform(frm){
	var flag=true;
		if(frm.cid.value=="")
		{
		  alert("编号不能为空！");
		
		  flag=false;		  
		}
	return flag;
}
function keyPress() {    
     var keyCode = event.keyCode;    
     if ((keyCode >= 48 && keyCode <= 57))    
    {    
         event.returnValue = true;    
     } else {    
           event.returnValue = false;    
    }    
 }    
</SCRIPT>
		<body style="background-color: #e4e9f1">

			<center>
				<form action="Course_courseadd" method="post"
					onsubmit="return checkform(this)">
					<table border=1>
						<cenetr>
						<font size="6" color=black>添加课程</font>
						</center>
						<br>
						<br>
						<br>
						<tr>
							<td>
								课程编号：
							</td>
							<td>
								<input type=text name="cid" size=25 style="ime-mode:disabled;" onpaste="return false;"  onkeypress="keyPress()">
							</td>
						</tr>
						<tr>
							<td>
								教师姓名：
							</td>
							<td>
								<select name="teacher.tid" style="width: 182px">
									<s:iterator var="teacher" value="#session.listtea">
										<option value="${tid}">
											教师名：${tname}&nbsp;&nbsp;教师号：${tid}
										</option>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								课程名称：
							</td>
							<td>
								<input type=text name="cname" size=25>
							</td>
						</tr>
						<tr>
							<td>
								课程时间：
							</td>
							<td>
								<input type=text name="classTime" size=25>
							</td>
						</tr>
						<tr>
							<td>
								课程学分：
							</td>
							<td>
								<input type=text name="credit" size=25 style="ime-mode:disabled;" onpaste="return false;"  onkeypress="keyPress()">
							</td>
						</tr>
						<tr>
							<td>
								课时：
							</td>
							<td>
								<input type=text name="classHour" size=25 style="ime-mode:disabled;" onpaste="return false;"  onkeypress="keyPress()">
							</td>
						</tr>

						<tr>
							<td>
								课程类型：
							</td>
							<td>
								<select name="classType" style="width: 182px">
									<option value="1">
										选修
									</option>
									<option value="2" selected>
										必选
									</option>
						</tr>
						<tr>
							<td>
								上课地址：
							</td>
							<td>
								<input type=text name="classAddr" size=25>
							</td>
						</tr>

						<tr>
							<td>
								考试类型：
							</td>
							<td>
								<select name="classProperty" style="width: 182px">
									<option value="1">
										考查
									</option>
									<option value="2" selected>
										考试
									</option>
						</tr>
						<tr align=center>
							<td colspan=2>
								<input type="submit" name=submit value="提交" />
								&nbsp;
								<input type=reset name=reset value="重置" />
							</td>
						</tr>
					</table>

				</form>
			</center>

			<center>
				<tr>
					<td>
						<font size=4 color="blue">${message}</font>
					</td>
				</tr>
			</center>
		</body>

	</body>
</html>
