<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>新闻发布系统</title>
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
		<div id="logo"><a href="Index.jsp" title="新闻发布系统">新闻发布系统</a></div>
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
					<c:forEach items="${List2 }" var="news">
						<li><span class="category">${news.tname}</span><a href="/News/News_Select?method=${news.title }&time=${news.time}&nid=${news.nid }" target="_blank">${news.title}</a><span class="date">${news.time }</span></li>
					</c:forEach>
					</ul>
				</div>
			</div>
			<!--[if !IE]>newslist 结束<![endif]-->
			<div class="paging wrapfix">
				<div class="total">当前为第${page.currentPage}页,共${page.totalPage}页</div>
				<div class="pn">
				<c:choose>
					<c:when test="${page.hasPrePage}">
					<a href="/News/NewclassServlet?method=list&currentPage=1&id=${tid}">首页</a> | 
					<a href="/News/NewclassServlet?method=list&currentPage=${page.currentPage -1 }&id=${tid}">上一页</a>
				</c:when>
				<c:otherwise>
					首页 | 上一页
				</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page.hasNextPage}">
					<a href="/News/NewclassServlet?method=list&currentPage=${page.currentPage + 1 }&id=${tid}">下一页</a> | 
					<a href="/News/NewclassServlet?method=list&currentPage=${page.totalPage }&id=${tid}">尾页</a>
				</c:when>
				<c:otherwise>
					下一页 | 尾页
				</c:otherwise>
				</c:choose>				
				</div>
			</div>
			<!--[if !IE]>paging 结束<![endif]-->
		</div>
		<!--[if !IE]>mostlyCon 结束<![endif]-->
		<div id="sideCon">
			<div id="nav">
				<h3>新闻类别</h3>
				<ul>
				<c:forEach items="${List1 }" var="n">
					<li><a href="/News/NewclassServlet?id=${n.tid }">${n.tname }</a></li>
				</c:forEach>
				</ul>
			</div>
		</div>
		<!--[if !IE]>sideCon 结束<![endif]-->
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;<a href="http://www.sdili.edu.cn" target="_blank">齐鲁工业大学-曹艳奇</a></p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>