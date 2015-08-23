<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div style="float: left">
		<form method="post" action="findAccounts@OrderFormAction">
			<table width=250 border=0 cellpadding=0 cellspacing=0 align="center">
				<tr style="color: blue; font-size: 14px;">
					<td style="height: 14px; width: 502px;"><img
						src="images/ADD.gif" width=14px height=14px>客房信息管理--&gt;登记客房信息</td>
				</tr>
				<tr>
					<td>房间编号: 
						<select name="bean.roomno" style="width: 153px;">
							<c:forEach items="${rooms }" var="room">
								<option value="${room.roomno}">${room.roomno }</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>顾客姓名:<input type="text" readonly="readonly"
						name="bean.customname" value="${order.customname }" /></td>
				</tr>
				<tr>
					<td>身份证号:<input type="text" readonly="readonly"
						name="bean.customid" value="${order.customid }" /></td>
				</tr>
				<tr>
					<td>入住时间:<input type="text" readonly="readonly"
						name=“bean.indate” value="${order.indate}"
						pattern="\d{4}\-\d{2}-\d{2}" placeholder="2013-01-01" /></td>
				</tr>
				<tr>
					<td>离开时间:<input type="text" name="bean.checkdate"
						value="${order.checkdate }" pattern="\d{4}\-\d{2}-\d{2}"
						placeholder="2013-01-01" /></td>
				</tr>
				<tr>
					<td>打折优惠:<input type="text" name="bean.discount"
						value="${order.discount }" /></td>
				</tr>
				<tr>
					<td>附加信息:<textarea rows="2" cols="22" name="bean.memo"
							readonly="readonly">${order.memo }</textarea></td>
				</tr>
				<tr>
					<td><input type="submit" value="查询信息"></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="float: left">
		<form action="settleAccounts@OrderFormAction" method="post">
			<table width=250 border=0 cellpadding=0 cellspacing=0 align="center">
				<tr style="color: blue; font-size: 14px;">
					<td style="height: 14px; width: 502px;"><img
						src="images/ADD.gif" width=14px height=14px>客房信息管理--&gt;登记结算信息</td>
				</tr>
				<tr>
					<td>应付金额:<input type="text" readonly="readonly"
						name="bean.totalMoney" value="${order.totalMoney }" /></td>
				</tr>
				<tr>
					<td>优惠金额:<input type="text" readonly="readonly"
						name="bean.reduceMoney" value="${order.reduceMoney}" /></td>
				</tr>
				<tr>
					<td>实付金额:<input type="text" readonly="readonly"
						name="bean.realMoney" value="${order.realMoney }" /></td>
				</tr>
				<tr>
					<td><input type="hidden" name="bean.roomno"
						value="${order.roomno }" /><br> <input type="hidden"
						name="bean.checkdate" value="${order.checkdate }" /> <br> <input
						type="hidden" name="bean.discount" value="${order.discount }" />
						${resinfo}</td>
				</tr>
				<tr>
					<td><input type="submit" value="结算"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>