<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>无标题页</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<br>
	<form action="query@RoomAction.action" method="post">
	<table width=800 border=0 cellpadding=0 cellspacing=0 align="center">
		<tr style="color: blue; font-size: 14px;">
			<td style="height: 14px; width: 600px;"><img
				src="images/list.gif" width=14px height=14px />客房信息管理--&gt;客房管理</td>
		</tr>
		<tr>
			<td>客房标准名称:<input name="roomTypeName" type="text" />&nbsp;&nbsp;
			客房标准:<select name="roomTypeId" style="min-width: 80px">
					<option value=""></option>
					<c:forEach items="${roomTypeList}" var="roomType">
						<option value="${roomType.id}">${roomType.typeName}</option>
					</c:forEach>
				</select>
			价格:<input name="priceFrom" type="text" style="width:60"/>~<input name="priceTo" type="text" style="width:60"/>
			<input type="submit" value="查询"/>
			</td>
		</tr>
		</table>
		</form>
		<table width=800 border=0 cellpadding=0 cellspacing=0 align="center">
		<tr>
			<td style="width: 600px;" 　valign=top>
				<div>
					<table cellspacing="2" cellpadding="3" rules="all" border="1"
						id="GridView1"
						style="background-color: #DEBA84; border-color: #DEBA84; border-width: 1px; border-style: None; width: 594px;">
						<tr
							style="color: White; background-color: #A55129; font-weight: bold;">
							<th scope="col">标准名称</th>
							<th scope="col">房间编号</th>
							<th scope="col">房间面积</th>
							<th scope="col">床位数目</th>
							<th scope="col">房间单价</th>
							<th scope="col">详细</th>
							<th scope="col">删除</th>
						</tr>
						<c:forEach items="${roomList }" var="room">
						<tr style="color: #8C4510; background-color: #FFF7E7;">
							<td>${room.roomtype.typeName }</td>
							<td>${room.roomno }</td>
							<td>${room.roomtype.area }</td>
							<td>${room.roomtype.bednum }</td>
							<td>${room.roomprice }</td>
							<td><a href="show@RoomAction.action?bean.id=${room.id }">进入</a></td>
							<td><a href="delete@RoomAction.action?bean.id=${room.id }">删除</a></td>
						</tr>
						</c:forEach>
					</table>
				</div>
		</tr>
	</table>
</body>
</html>
