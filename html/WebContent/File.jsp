<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
<h3>��ѧ��������</h3>
<form method="post" action="">
<fieldset>
	<legend>���˼��γ�����</legend>
		<ol>
			<li>��Ŀ���ƣ�<input type="text" name="name" value="" autofocus/></li></br>
			<li>��ѡ��ϵ��:
				<select size="1">
					<option>Ӣ��ϵ</option>
					<option>����ϵ</option>
					<option>��Ϣ����ϵ</option>
					<option>���ӹ���ϵ</option>
					<option>��Ϣ����ϵ</option>
				</select></li></br>
			<li>��ʦ��<input type="text" name="teacher" /></li><br>
			<li>�Ա�<input type="radio" name="gender" value="��" checked/>����
					<input type="radio" name="gender" value="Ů" />Ů��
					</li></br>
			<li>�������ڣ�<input type="date" name="selectdate" /></li></br>
			
		</ol>
		
		</fieldset>
</br>
<fieldset>
	<legend>�������</legend>
	<ol>
		<li>���ſ���ĳ�ϯ����ǣ�<input type="radio" name="class" />û��ȱ��
					   <input type="radio" name="class" />ȱ��1-3��
					   <input type="radio" name="class" />ȱ��4-6��
					   <input type="radio" name="class" />ȱ��6������
		</li></br>
		<li>������ſε�ѧϰ̬��:<input type="radio" name="attitude" />������
						   <input type="radio" name="attitude" />��������
						   <input type="radio" name="attitude" />�ܲ�����
		</li></br>
		<li>��ϰ���ſε�ԭ�򣨿ɶ�ѡ����<input type="checkbox" name="reason" />����
							   <input type="checkbox" name="reason" />��ѧ��
							   <input type="checkbox" name="reason" />������Ȥ
		</li></br>
		<li>�����������ſε����������:</br>
			<textarea rows="3" cols="50"></textarea></li>
	</ol>
</fieldset>

<input type="submit" value="�ύ" />
<input type="reset" value="��д" />
</form>
</body>
</html>