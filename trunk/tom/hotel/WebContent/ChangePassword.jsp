<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table {
	margin-top: 5%;
	margin-left: 30%;
}
</style>
</head>
<body>
	<form action="changePassword@UserAction" method="post">
		<table style="border: 1px solid #000">
		<tr>
			<td>名称：</td>
			<td><input type="text" name="username"  value="${user.username}"readonly="readonly"></td>
		</tr>
			<tr>
				<td>旧密码：</td>
				<td><input type="text" name="oldpassword"></td>
			</tr>
			<tr>
				<td>新密码：</td>
				<td><input type="text" name="newpassword"></td>
			</tr>
			<tr style="text-align: center;">
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"><font style="color:red">${info }</font></td>
			</tr>
		</table>
	</form>
</body>
</html>