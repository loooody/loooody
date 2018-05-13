<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>JSP-out</title>
<style type="text/css">
	header{
		width:800px;
		height:300px;
		background-color:#CCCCCC;
		text-align:center;
		margin:100px auto;
		box-shadow:10px 10px 15px black;
	}
</style>
</head>
<body>
	<header>
	<%
		String[] str = {
				"老兔寒蟾泣天色，云楼半开壁斜白。",
				"玉轮轧露湿团光，鸾佩相逢桂香陌。",
				"黄沉清水三山下，更变千年如走马。",
				"遥望齐州九烟点，一泓海水杯中泻。"
		};
	out.println("<h2>梦天</h2>");
	for(int i=0;i<str.length;i++){
		out.print(str[i]);
		out.print("<br/><br/>");
	}
	%>
	</header>
</body>
</html>