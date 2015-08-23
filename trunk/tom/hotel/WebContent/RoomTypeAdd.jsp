<%@ page contentType="text/html; charset=UTF-8" language="java"%>

<html>
<head>
<title>无标题页</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script>
	function verifyPrice(obj) //验证输入的房间价格
	{
		pta = /[^0123456789.]{1,}/;
		if (pta.exec(obj))
			Form1.price.value = obj.substr(0, obj.length - 1);
	}
	function checkForm(form) {
		if (form.typeName.value == "") {
			alert("请输入房间标准名称!");
			form.typeName.focus();
			return false;
		}
		if (form.area.value == "") {
			alert("请输入房间面积!");
			form.area.focus();
			return false;
		}
		if (form.price.value == "") {
			alert("请输入房间单价!");
			form.price.focus();
			return false;
		}
		if (form.bednum.value == "") {
			alert("请输入床位数量");
			form.bednum.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<%
		String result = request.getParameter("result");
		if (null != result) {
			out.println("<script>alert('房间类型信息添加成功!');</script>");
		}
	%>
	<form method="post" action="add@RoomTypeAction">
		<table width=600 border=0 cellpadding=0 cellspacing=0 align="center">
			<tr style="color: blue; font-size: 14px;">
				<td colspan="2"><img
					src="images/ADD.gif" width=14px height=14px>客房信息管理--&gt;添加客房标准</td>
			</tr>
			<tr>
				<td style="height: 42px" width="90px">房间标准名称：</td>
				<td>
					<input name="bean.typeName" type="text" id="typeName" size="20">
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="90px">房间标准面积：</td>
				<td>
					<input name="bean.area" type="text" id="area" >平方米
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="90px">房间床位数量：</td>
				<td>
					<input name="bean.bednum" type="text" id="bednum" 
					onkeyup="value=value.replace(/[^\d]/g,'') "
					onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">个
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="90px">房间条件：</td>
				<td>
					<input type=checkbox name="bean.haircontion" value="是" />是否有空调&nbsp;
					<input type=checkbox name="bean.htelephone" value="是" />是否有电话&nbsp; 
					<input type=checkbox name="bean.htelevion" value="是" />是否有电视&nbsp; 
					<input type=checkbox name="bean.htoilet" value="是" />是否有卫生间
				</td>
			</tr>
			<tr>
				<td style="height: 42px" width="90px">房间单价：</td>
				<td>
					<input type="text" name="bean.price" onpropertyChange="verifyPrice(this.value)">元
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type=submit value="添加" onclick="return checkForm(Form1);">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
