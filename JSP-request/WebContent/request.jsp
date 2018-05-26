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
	<h2>免费注册窗口</h2>
	<form action="info.jsp" method="post">
		登&nbsp; 录  名：<input type="text" name="username" /><br />
		登录密码：<input type="password" name="userpwd" /><br />
		选择性别：<input type="radio" name="sex" value="男"/>男
			   <input type="radio" name="sex" value="女"/>女<br />
		所在校区：<select name="area">
					<option>java软件编程</option>
					<option>c#软件编程</option>
					<option>计算机信息管理</option>
					<option>数据结构</option>
		       </select><br />
		所学技术：<input type="checkbox" value="java软件编程" name="subject">java软件编程
			   <input type="checkbox" value="c#软件编程" name="subject">c#软件编程
			   <input type="checkbox" value="计算机信息管理" name="subject">计算机信息管理<br />
		<br />
		<input type="submit" value="注册"/>
	</form>
</body>
</html>