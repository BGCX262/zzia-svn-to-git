<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>�ޱ���ҳ</title>
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
					src="images/ADD.gif" width=14px height=14px>�ͷ���Ϣ����--&gt;�鿴�ͷ���Ϣ</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">�����ţ�</td>
				<td style="height: 42px">
				<input name="bean.roomno" type="text" id="roomNo" size="20" value="${room.roomno}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">�����׼��</td>
				<td style="height: 42px" width="80px">
				<input name="bean.roomno" type="text" id="roomNo" size="20" value="${room.roomtype.typeName}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">����λ�ã�</td>
				<td style="height: 42px">
					<input name="bean.roomposition" type="text" id="RoomPosition" value="${room.roomposition}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">���䵥�ۣ�</td>
				<td style="height: 42px">
					<input name="bean.roomprice" type="text" id="RoomPrice" value="${room.roomprice}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="80px">������Ϣ��</td>
				<td style="height: 42px">
					<input name="bean.roommemo" type="text" id="RoomMemo" value="${room.roommemo}" readonly="readonly">
				</td>
			</tr>
		</table>
</body>
</html>
