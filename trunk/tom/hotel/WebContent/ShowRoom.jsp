<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>无标题页</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function isEmpty() {

	}
</script>
</head>
<body>
		<table width=600 border=0 cellpadding=0 cellspacing=0 align="center">
			<tr style="color: blue; font-size: 14px;"> 
				<td colspan="2"><img
					src="images/ADD.gif" width=14px height=14px>客房信息管理--&gt;查看客房信息</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">房间编号：</td>
				<td style="height: 42px">
				<input name="bean.roomno" type="text" id="roomNo" size="20" value="${room.roomno}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">房间标准：</td>
				<td style="height: 42px" width="80px">
				<input name="bean.roomno" type="text" id="roomNo" size="20" value="${room.roomtype.typeName}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">房间位置：</td>
				<td style="height: 42px">
					<input name="bean.roomposition" type="text" id="RoomPosition" value="${room.roomposition}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">房间单价：</td>
				<td style="height: 42px">
					<input name="bean.roomprice" type="text" id="RoomPrice" value="${room.roomprice}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">附加信息：</td>
				<td style="height: 42px">
					<input name="bean.roommemo" type="text" id="RoomMemo" value="${room.roommemo}" readonly="readonly">
				</td>
			</tr>
		</table>
</body>
</html>
