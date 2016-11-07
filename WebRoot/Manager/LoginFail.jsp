<%@page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="Keywords" content="关键词" />
<meta name="Description" content="你网页的简述" />
<meta name="Robots" content="All" />
<meta name="Generator" content="Dreamweaver" />
<meta name="Author" content="FifthMouse，email" />
<meta name="Copyright" content="Strong Software All Rights Reserved" />
<title>新闻发布后台管理系统</title>
<link href="Manager/Style/Login.css" rel="stylesheet" type="text/css" />
</head>
<body >
<div id="wrapper">
	<form id="form1" name="form1" action="Login_Servlet">
		<div class="login">
			<div align="center">
				<label for="username" >登录信息有误！</br>请重试！</label>
			</div>

			<div class="button">
				 <a href="Manager/Login.jsp">返回</a>
				
			</div>
		</div>
	</form>
</div>
</body>
</html>
