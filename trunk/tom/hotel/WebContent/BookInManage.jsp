<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>无标题页</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<br>
	<form action="findByRoomNo@OrderFormAction" method="post">
		<table width=800 border=0 cellpadding=0 cellspacing=0 align="center">
			<tr style="color: blue; font-size: 14px;">
				<td style="height: 14px; width: 600px;"><img
					src="images/list.gif" width=14px height=14px />客房信息管理--&gt;客房预订管理</td>
			</tr>
			<tr>
				<td>客房编号: <select name="bean.roomno" style="width:153px;">
						<c:forEach items="${rooms }" var="room">
							<option value="${room.roomno}">${room.roomno }</option>
						</c:forEach>
				</select> &nbsp;&nbsp; <input type="submit" value="查询" />
				</td>
			</tr>
			<tr>
				<td style="width: 600px;" valign=top>
					<div>
						<table cellspacing="2" cellpadding="3" rules="all" border="1"
							id="GridView1"
							style="background-color: #DEBA84; border-color: #DEBA84; border-width: 1px; border-style: None; width: 594px;">
							<tr
								style="color: White; background-color: #A55129; font-weight: bold;">
								<th scope="col">预订编号</th>
								<th scope="col">顾客姓名</th>
								<th scope="col">身份证号</th>
								<th scope="col">房间编号</th>
								<th scope="col">入住时间</th>
								<th scope="col">详情</th>
								<th scope="col">删除</th>
							</tr>
							<c:forEach items="${orders}" var="order">
								<tr style="color: #8C4510; background-color: #FFF7E7;">
									<td>${order.id }</td>
									<td>${order.customname }</td>
									<td>${order.customid }</td>
									<td>${order.roomno }</td>
									<td>${order.indate }</td>
									<td><a
										href="singleOrder@OrderFormAction?bean.id=${order.id}">进入</a></td>
									<td><a href="delete@OrderFormAction?bean.id=${order.id}">删除</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
			</tr>
		</table>
	</form>
</body>
</html>
