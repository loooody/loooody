<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
<style type="text/css">
	body{
		width:800px;
		text-align:center;
		margin:100px auto;
		box-shadow:10px 10px 15px black;
	}
</style>
</head>
<body>
	<h2>您的注册信息如下：</h2>
	<%request.setCharacterEncoding("gb2312"); %>
	<p>
		用户名：<%=request.getParameter("username") %><br />
		密码：<%=request.getParameter("userpwd") %><br />
		性别：<%=request.getParameter("sex") %><br />
		所在校区：<%=request.getParameter("area") %><br />
		所学技术：<%
		 	String[] subject = request.getParameterValues("subject");
			for(int i=0;i<subject.length;i++){
				
		%>
		<%=subject[i] %>
		<%} %>
</body>
</html>