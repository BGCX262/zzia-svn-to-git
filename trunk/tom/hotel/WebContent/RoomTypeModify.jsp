<%@ page contentType="text/html; charset=gb2312" language="java"%>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>�ޱ���ҳ</title>
    <link href="style.css" rel="stylesheet" type="text/css" />
        <script>   
  function verifyPrice(obj)    //��֤����ķ���۸�
  {   
  	pta=/[^0123456789.]{1,}/;   
  	if(pta.exec(obj))
  	  Form1.price.value=obj.substr(0,obj.length-1);  
  }
function checkForm(form){
	if(form.typeName.value==""){
		alert("�����뷿���׼����!");form.typeName.focus();return false;
	}
	if(form.area.value==""){
		alert("�����뷿�����!");form.area.focus();return false;
	}
	if(form.price.value==""){
		alert("�����뷿�䵥��!");form.price.focus();return false;
	}
	if(form.bednum.value=="") {
		alert("�����봲λ����");form.bednum.focus();return false;
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
          <img src="images/edit.gif" width=14px height=14px>�ͷ���Ϣ����--&gt;�޸Ŀͷ���׼</td>
        </tr>
        <tr>
        <td style="height: 42px">
            <br />
            �����׼���ƣ�
            <input name="typeName" type="text" id="typeName" size="20" value="asdf">
            <br /><br/>
            �����׼�����
           <input name="area" type="text" id="area" size="12" value=20>ƽ����<br />
            <br />
            ���䴲λ������
            <input name="bednum" type="text" id="bednum" size="10" value=10 onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))">��<br />
            <br />
            ����������
            <input type=checkbox name="haircontion" checked value="��"/>�Ƿ��пյ�&nbsp;
            <input type=checkbox name="htelephone" checked value="��" />�Ƿ��е绰&nbsp;
            <input type=checkbox name="htelevion" checked value="��" />�Ƿ��е���&nbsp;
            <input type=checkbox name="htoilet" checked value="��" />�Ƿ���������
            <br /><br/>
            ���䵥�ۣ�
            <input type=text name=price value="1000" size=8 onpropertyChange="verifyPrice(this.value)">Ԫ<br />
            <br /> 
            &nbsp;
            <input type=submit value="�޸�" onclick="return checkForm(Form1);"></td>
       </tr>
     </table> 
         &nbsp;&nbsp;
         
    </form>
</body>
</html>
