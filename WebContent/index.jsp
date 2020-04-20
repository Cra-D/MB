<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="js_jquery/index.js" charset="UTF-8"></script>
<link rel="stylesheet" href="css/index.css">
<title>DB Manager</title>
</head>
<body bgColor=#ffffff>
 <%--
	<tr align="center" valign="middle">
		<td>
		<table style="height: 300; width: 492" cellSpacing=0 cellPadding=0
			border=0 align="center">
			<tbody>
				<tr valign="middle">
					<td colSpan=2
						style="background-image: url(./images/login_Page/loginPage_01.jpg)"
						height=44><font face="黑体" size="4px" color="#196ed1"
						style="padding-left: 20px; vertical-align: middle">Demo</font></td>
				</tr>
				<tr>
					<td width="203"><IMG height=200 alt=""
						src="./images/login_Page/HSBCLOGO.jpg" width=202></td>
					<td
						style="background-image: url(./images/login_Page/DBLoginPage_03.jpg)"
						height=200 width=497>
					
					</td>
				</tr>
				<tr>
					<td colSpan=2
						style="background-image: url(./images/login_Page/loginPage_04.jpg)"
						G height=56 align="center" class="login_td">版权所有</td>
				</tr>
			</tbody>
		</table>
		</td>
	</tr>
	--%>
	 <div style="text-align: center;width:60%;">
	<div style="background-image: url(./images/login_Page/DBLoginPage_03.jpg)">
 <form method="POST" name="Regsiter" action="LoginServlet">
					<table>
						<tr>
							<td width="66" height="20" class="login_td">DB Type：</td>
							<td width="115" height="20" class="login_td">
							
						<select id="dbtype" name="dbtype" style="WIDTH: 110px">
						<option value="AS400/DB2">AS400/DB2</option>
							<option value="MySQL">MySQL</option>
							
						</select>
							
							 </td>
							<td></td>
						</tr>
					
					<tr>
							<td width="66" height="20" class="login_td">URL：</td>
							<td width="115" height="20" class="login_td">
							<input type="text" name="url" value="" style="WIDTH: 110px"></td>
							<td></td>
						</tr>
						<tr>
							<td width="66" height="20" class="login_td">UserName：</td>
							<td width="115" height="20" class="login_td"><input
								type="text" name="username" value="" style="WIDTH: 110px"></td>
							<td></td>
						</tr>
						<tr>
							<td height="20" class="login_td">Password：</td>
							<td height="20" class="login_td"><input type="password"
								name="password" value="" style="WIDTH: 110px"></td>
							<td></td>
						</tr>
						<tr>
							<td height="20"></td>
							<td></td>
							<td></td>
						</tr>
						
						<tr>
							<td height="20" colspan="2" align="center">
							<button class="login_button" onClick="res()">重置</button>
							&nbsp;
							<button class="login_button" onClick="loginClick()">登录</button>
							&nbsp;</td>
							<td ></td>
						</tr>
					</table>
					</form>
</div>
 </div>
</body>
</html>