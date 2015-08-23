<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<title>无标题页</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<form method="post" action="addOrder@OrderFormAction">
		<table width=300 border=0 cellpadding=0 cellspacing=0 align="center">
			<tr style="color: blue; font-size: 14px;">
				<td style="height: 14px; width: 502px;"><img
					src="images/ADD.gif" width=14px height=14px>客房信息管理--&gt;登记客房信息</td>
			</tr>
			<tr>
				<td>房间编号:				
					<select name="bean.roomno" style="width:153px;">
						<c:forEach items="${rooms }" var="room"> 
							<option value="${room.roomno}">${room.roomno }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>顾客姓名:<input type="text" name="bean.customname"
					required="required" autocomplete="on" /></td>
			</tr>
			<tr>
				<td>身份证号:<input type="text" name="bean.customid"
					required="required" autocomplete="on" /></td>
			</tr>
			<tr>
				<td>入住时间:<input type="text" name="bean.indate"
					required="required" placeholder="2013-01-01" pattern="\d{4}-\d{2}-\d{2}" autocomplete="on" /></td>
			</tr>
			<tr>
				<td>附加信息:<textarea rows="5" cols="22" name="bean.memo"></textarea></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="提交" /><s:fielderror></s:fielderror></td>
			</tr>
		</table>
	</form>
</body>
</html>
