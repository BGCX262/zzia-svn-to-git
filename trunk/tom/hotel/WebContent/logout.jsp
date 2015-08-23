<%@ page contentType="text/html; charset=gb2312" language="java"%>
<%
	session.invalidate();
	out.print("<script>top.location.href='login.jsp';</script>"); 
%>
