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
	<h2>���ע�ᴰ��</h2>
	<form action="info.jsp" method="post">
		��&nbsp; ¼  ����<input type="text" name="username" /><br />
		��¼���룺<input type="password" name="userpwd" /><br />
		ѡ���Ա�<input type="radio" name="sex" value="��"/>��
			   <input type="radio" name="sex" value="Ů"/>Ů<br />
		����У����<select name="area">
					<option>java������</option>
					<option>c#������</option>
					<option>�������Ϣ����</option>
					<option>���ݽṹ</option>
		       </select><br />
		��ѧ������<input type="checkbox" value="java������" name="subject">java������
			   <input type="checkbox" value="c#������" name="subject">c#������
			   <input type="checkbox" value="�������Ϣ����" name="subject">�������Ϣ����<br />
		<br />
		<input type="submit" value="ע��"/>
	</form>
</body>
</html>