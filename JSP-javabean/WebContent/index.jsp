<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
<!--  -->	
<jsp:useBean id="myBean" scope="application" class="jsp.myBean"/>
	<form action="index.jsp" method="post">
		<ul>
			<p>��Ա��¼</p>
			<li style="padding-top:10px;">�û���:
			<input class="sr type="text" name="userName" />
			</li>
			<li>����:
			<input class="sr" type="pssword" name="userpwd" />
			</li><br />
			<input type="submit" id="submit" value="��¼" />
		</ul>
	</form>
	<%
		request.setCharacterEncoding("gb2312");
		String name=request.getParameter("userName");
	%>
	<%=name %>
	<%=name+"23" %>
	<%if(request.getParameter("userName")!=null){ %>
	<jsp:setProperty property="*" name="myBean"/>
	��ӭ
	<%=name %>
	��¼������
	<jsp:getProperty property="count" name="myBean"/>
	λ��¼���û�
	<%} %>
</body>
</html>