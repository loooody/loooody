<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Insert title here</title>
</head>
<body>
<h3>教学意见调查表</h3>
<form method="post" action="">
<fieldset>
	<legend>个人及课程资料</legend>
		<ol>
			<li>科目名称：<input type="text" name="name" value="" autofocus/></li></br>
			<li>请选择系所:
				<select size="1">
					<option>英文系</option>
					<option>法律系</option>
					<option>信息管理系</option>
					<option>电子工程系</option>
					<option>信息工程系</option>
				</select></li></br>
			<li>讲师：<input type="text" name="teacher" /></li><br>
			<li>性别：<input type="radio" name="gender" value="男" checked/>男生
					<input type="radio" name="gender" value="女" />女生
					</li></br>
			<li>开课日期：<input type="date" name="selectdate" /></li></br>
			
		</ol>
		
		</fieldset>
</br>
<fieldset>
	<legend>意见调查</legend>
	<ol>
		<li>这门课你的出席情况是：<input type="radio" name="class" />没有缺课
					   <input type="radio" name="class" />缺课1-3次
					   <input type="radio" name="class" />缺课4-6次
					   <input type="radio" name="class" />缺课6次以上
		</li></br>
		<li>你对这门课的学习态度:<input type="radio" name="attitude" />很认真
						   <input type="radio" name="attitude" />还算认真
						   <input type="radio" name="attitude" />很不认真
		</li></br>
		<li>修习这门课的原因（可多选）：<input type="checkbox" name="reason" />必修
							   <input type="checkbox" name="reason" />凑学分
							   <input type="checkbox" name="reason" />个人兴趣
		</li></br>
		<li>请简述你对这门课的期望或意见:</br>
			<textarea rows="3" cols="50"></textarea></li>
	</ol>
</fieldset>

<input type="submit" value="提交" />
<input type="reset" value="重写" />
</form>
</body>
</html>