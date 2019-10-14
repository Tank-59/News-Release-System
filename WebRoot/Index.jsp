<%@page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>新闻综合管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<meta http-equiv="Content-Language" content="zh-CN" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="Keywords" content="关键字" />
<meta name="Description" content="描述" />
<link rel="stylesheet" href="Style/Main.css" type="text/css" media="screen, projection"/>

</head>
<body>
<div id="wrapper">
	<div id="header">   
		<div id="login01"><a href="Manager/Login.jsp"><font size="2" color="#FF9900">登录</font></a></div>
		<div id="logo"><a href="#" title="新闻管理系统">新闻管理系统</a></div>
		<!--[if !IE]>logo 结束<![endif]-->
		<div class="search">
			<form id="form1" method="post" action="News_Search">
				<input type="text" name="textfield" id="textfield" class="iText" />
				<select name="select">
					<option selected="selected">标题</option>
					<option>内容</option>
				</select>
				<input type="submit" name="Submit" class="btn" value="搜索" />
			</form>
		</div>
		<!--[if !IE]>search 结束<![endif]-->
	</div>
	<!--[if !IE]>header 结束<![endif]-->
	<div id="main" class="wrapfix">
		<div id="mostlyCon">
			<div class="newslist">
				<div class="hd"><h3>新闻头条</h3></div>
				<div class="bd">
					<ul class="list">			
					<%-- <c:forEach items="${List }" var="news">
						<li><span class="category">${[news.tname] }</span><a href="/News/News_Select?method=${news.title }&time=${news.time}&nid=${news.nid }" target="_blank">${news.title}</a><span class="date">${news.time }</span></li>
					</c:forEach> --%>
					<c:forEach items="${list1}" var = "i" begin="0" end="5">
						<li><span class="category">[${i.ncontent}]</span><a href="/News/News_Select?nid=${i.nid }"  target="_blank">${i.ntitle }</a><span class="date">${i.npublishTime }</span></li>
					</c:forEach>
					</ul>
				</div>
			</div>
			<!--[if !IE]>newslist 结束<![endif]-->
			<div class="newslist">
				<div class="hd"><h3>热点新闻</h3></div>
				<div class="bd">
					<ul class="list">
						<%-- <c:forEach items="${List }" var="news">
						<li><span class="category">${[news.tname] }</span><a href="/News/News_Select?method=${news.title }&time=${news.time}&nid=${news.nid }" target="_blank">${news.title}</a><span class="date">${news.time }</span></li>
					</c:forEach> --%>
					<c:forEach items="${HotList }" var = "i" begin="0" end = "7">
						<li><span class="category">[${i.tname}]</span><a href="/News/News_Select?nid=${i.nid }" target="_blank">${i.ntitle }</a><span class="date">${i.npublishTime }</span></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<!--[if !IE]>newslist 结束<![endif]-->
		</div>
		<!--[if !IE]>mostlyCon 结束<![endif]-->
		<div id="sideCon">
			<div id="nav">
				<!-- <h3>新闻类别</h3> -->
				</br></br>
				<ul>
				<c:forEach items="${List1 }" var="n">
					<li><a href="/News/NewclassServlet?id=${n.tid }" target="_blank">${n.tname }</a></li>
				</c:forEach>
				
				</ul>
			</div>
		</div>
		<!--[if !IE]>sideCon 结束<![endif]-->
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;<a href="http://www.sdili.edu.cn" target="_blank">QLUTech-tank59 </a></p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
<!-- caoyanqi15@126.com	 -->
</div>
</body>
</html>
