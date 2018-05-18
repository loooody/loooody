<%@ page language="java" contentType="text/html; import="java.util.*" charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
	<%
		//设置编码格式
		request.setCharacterEncoding("GBK");
		String email=request.getParameter("eamil");
		if(email.equals("")){
	%>
	<jsp:forward page="result.jsp">
		<jsp:param value="0" name="result"/>
	</jsp:forward>
	<%} else {%>
	<jsp:forward page="result.jsp">
		<jsp:param value="1" name="result"/>
		<jsp:param value="<%=email %>" name="email"/>
	</jsp:forward>
	<%} %>
</body>
</html>