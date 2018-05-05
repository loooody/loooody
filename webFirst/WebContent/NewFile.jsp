<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%/*ÕâÊÇÎÒÃÇµÄ´úÂë*/%>
<%
String title = "¹ØÓÚÎÒÃÇ";
String body = "µÚÒ»¸öweb¡£<br/>·ÃÎÊÍøÕ¾ÁË½â¸ü¶àÄÚÈÝ </br>jdk+tomcat+eclipse";
Date now = new Date();
String day = String.format("%tYÄê%tmÔÂ%tdÈÕ", now, now,now);
out.println("ÕâÊÇÖ±½Ó´Ó·½·¨ÖÐÊä³ö");
%>

<h2><%=title %></h2>
<%=body  %>
<p class=date><%= day  %>

</body>
</html>