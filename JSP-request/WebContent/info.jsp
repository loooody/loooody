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
	<h2>����ע����Ϣ���£�</h2>
	<%request.setCharacterEncoding("gb2312"); %>
	<p>
		�û�����<%=request.getParameter("username") %><br />
		���룺<%=request.getParameter("userpwd") %><br />
		�Ա�<%=request.getParameter("sex") %><br />
		����У����<%=request.getParameter("area") %><br />
		��ѧ������<%
		 	String[] subject = request.getParameterValues("subject");
			for(int i=0;i<subject.length;i++){
				
		%>
		<%=subject[i] %>
		<%} %>
</body>
</html>