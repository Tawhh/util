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

		<title>My JSP 'stuAdd.jsp' starting page</title>

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
				<form action="Stu_stuadd" method="post"
					onsubmit="return checkform(this)">
					<table border=1>
						<center>
						<font size="6" color=black>添加学生</font>
						</center>
						<br>
						<br>
						<br>
						<tr>
							<td>
								学生ID：
							</td>
							<td>
								<input type=text name="sid" size=25 style="ime-mode: disabled;"
									onpaste="return false;" onkeypress="keyPress()">
							</td>
						</tr>
						<tr>
							<td>
								姓名：
							</td>
							<td>
								<input type=text name="sname" size=25>
							</td>
						</tr>
						<tr>
							<td>
								性别：
							</td>
							<td>
								<select name="sex" style="width: 182px">
									<option value="1">
										男
									</option>
									<option value="0" selected>
										女
									</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								院校：
							</td>
							<td>
								<input type=text name="sc" size=25>
							</td>
						</tr>
						<tr>
							<td>
								专业：
							</td>
							<td>
								<input type=text name="major" size=25>
							</td>
						</tr>
						<tr>
							<td>
								课时：
							</td>
							<td>
								<input type=text name="sumClassHour" size=25
									style="ime-mode: disabled;" onpaste="return false;"
									onkeypress="keyPress()">
							</td>
						</tr>

						<tr>
							<td>
								学分：
							</td>
							<td>
							<input type=text name="sumCredit" size=25
									style="ime-mode: disabled;" onpaste="return false;"
									onkeypress="keyPress()">
									</td>
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
				<font size=4 color="blue">${message}</font>
			</center>
		</body>
</html>
