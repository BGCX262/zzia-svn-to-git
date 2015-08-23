<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.bd {
	border: 1px solid #000
}

table,td {
	border: 1px solid #000;
	border-collapse: collapse;
}

td {
	text-align: center;
}

.wd {
	width: 70%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 5%
}
</style>
</head>
<body>
	<div>
		<form action="add@UserAction" method="post">
			<table class="wd">
				<tr>
					<td>名称</td>
					<td>密码</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${userList }" var="user">
					<tr>
						<td>${user.username }</td>
						<td>${user.password}</td>
						<td><a href="delete@UserAction?bean.id=${user.id}">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td><input type="text" placeholder="输入名称" name="bean.username"
						required="required" /></td>
					<td><input type="password" placeholder="输入密码"
						name="bean.password" required="required" /></td>
					<td><input type="submit" value="添加" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>