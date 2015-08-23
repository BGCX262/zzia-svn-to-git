<%@ page contentType="text/html; charset=gb2312" language="java"%>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>无标题页</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
        <script>   
  function verifyPrice(obj)    //验证输入的房间价格
  {   
  	pta=/[^0123456789.]{1,}/;   
  	if(pta.exec(obj))
  	  Form1.price.value=obj.substr(0,obj.length-1);  
  }
function checkForm(form){
	if(form.typeName.value==""){
		alert("请输入房间标准名称!");form.typeName.focus();return false;
	}
	if(form.area.value==""){
		alert("请输入房间面积!");form.area.focus();return false;
	}
	if(form.price.value==""){
		alert("请输入房间单价!");form.price.focus();return false;
	}
	if(form.bednum.value=="") {
		alert("请输入床位数量");form.bednum.focus();return false;
	}
}
</script> 
</head>
<body>

    <form id="Form1" method="post" action="RoomTypeAction.do?action=modify">
	  	<input type=hidden name=typeId value="1234"/>
        <table width=600 border=0 cellpadding=0 cellspacing=0 align="center">
        <tr style="color:blue;font-size:14px;">
	  <td style="height: 14px; width: 502px;">
          <img src="images/edit.gif" width=14px height=14px>客房信息管理--&gt;修改客房标准</td>
        </tr>
        <tr>
        <td style="height: 42px">
            <br />
            房间标准名称：
            <input name="typeName" type="text" id="typeName" size="20" value="asdf">
            <br /><br/>
            房间标准面积：
           <input name="area" type="text" id="area" size="12" value=20>平方米<br />
            <br />
            房间床位数量：
            <input name="bednum" type="text" id="bednum" size="10" value=10 onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">个<br />
            <br />
            房间条件：
            <input type=checkbox name="haircontion" checked value="是"/>是否有空调&nbsp;
            <input type=checkbox name="htelephone" checked value="是" />是否有电话&nbsp;
            <input type=checkbox name="htelevion" checked value="是" />是否有电视&nbsp;
            <input type=checkbox name="htoilet" checked value="是" />是否有卫生间
            <br /><br/>
            房间单价：
            <input type=text name=price value="1000" size=8 onpropertyChange="verifyPrice(this.value)">元<br />
            <br /> 
            &nbsp;
            <input type=submit value="修改" onclick="return checkForm(Form1);"></td>
       </tr>
     </table> 
         &nbsp;&nbsp;
         
    </form>
</body>
</html>
