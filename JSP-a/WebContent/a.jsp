<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>��¼</title>
<style type="text/css">
	h1{
		width:800px;
		height:70px;
		background-color:#CCCCCC;
	}
	body{
		width:800px;
		height:400px;
		margin:100px auto;
		text-align:center;
		box-shadow:10px 10px 15px black;
	}
	form{
		width:400px;
		height:100px;
		margin:auto;
		border:100px solid white;
		text-align:center;
	}
</style>
</head>
<body>
	<h1 align="center"><b>��¼</b></h1>
	<form name=login action=pre.jsp method="post">
		�û���<input type="text" name="username" ><br>
		�� &nbsp;   ��<input type="password" name="password"><br><br>
		<input class=button type="submit" value="ȷ��" name=submit >
		<input class=button type="reset" value="ȡ��" name=reset >
	</form>
</body>
</html>