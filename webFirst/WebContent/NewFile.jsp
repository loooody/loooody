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
<%/*这是我们的代码*/%>
<%
String title = "关于我们";
String body = "第一个web。<br/>访问网站了解更多内容 </br>jdk+tomcat+eclipse";
Date now = new Date();
String day = String.format("%tY年%tm月%td日", now, now,now);
out.println("这是直接从方法中输出");
%>

<h2><%=title %></h2>
<%=body  %>
<p class=date><%= day  %>

</body>
</html>