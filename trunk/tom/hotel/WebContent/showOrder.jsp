<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table width=300 border=0 cellpadding=0 cellspacing=0 align="center">
		<tr style="color: blue; font-size: 14px;">
			<td style="height: 14px; width: 502px;"><img
				src="images/ADD.gif" width=14px height=14px>客房信息管理--&gt;登记客房信息</td>
		</tr>
		<tr>
			<td>房间编号:<input type="text" name="bean.roomno"
				value="${order.roomno }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>顾客姓名:<input type="text" name="bean.customname"
				value="${order.customname }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>身份证号:<input type="text" name="bean.customid"
				value="${order.customid }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>入住时间:<input type="text" name="bean.indate"
				value="${order.indate }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>附加信息:<textarea rows="5" cols="22" name="bean.memo"
					readonly="readonly">${order.memo }</textarea></td>
		</tr>
	</table>
</body>
</html>
