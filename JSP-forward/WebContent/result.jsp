<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<h2>订阅成功</h2>
	<%
		String result = request.getParameter("result");
		if(result.equals("0")){
	%>
	<p>结果：订阅失败.</p>
	<% }else { %>
	<p>结果：<%=request.getParameter("email") %> 订阅成功。
	</p>
	<% } %>
</body>
</html>