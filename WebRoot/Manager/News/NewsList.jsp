<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<meta http-equiv="Content-Language" content="zh-CN" />

<title>新闻列表</title>
<link href="Manager/Style/Css.css" rel="stylesheet" type="text/css" />
</head>

<body>
<h3 class="subTitle">新闻发布</h3>
<ul class="button">
	<li><a href="Manager/News/NewsAdd.jsp">添加新闻</a></li>
</ul>

<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table">
	<tr>
	    <th width="8%" nowrap="nowrap">序号</th>
	    <th nowrap="nowrap">标题</th>
	    <th width="15%" nowrap="nowrap">时间</th>
	    <th width="12%">修改</th>
	    <th width="12%">删除</th>
	</tr>
	<c:forEach items="${list }" var="news" varStatus="i">
	<tr>
	    <td align="center">${i.count }</td>
	    <td align="center">${news.ntitle }</td>
	    <td align="center">${news.npublishTime }</td>
	    <td align="center"><a href="Manager/News/NewsModify.jsp?id=${news.nid }">修改</a></td>
	    <td align="center"><a href="Back_News_Delete?id=${news.nid }">删除</a></td>
	</tr>
	</c:forEach>
	
</table>

 <div align="center">
	<c:choose>
		<c:when test="${page.hasPrePage}">
			<a href="Manager/News/NewsList.jsp?currentPage=1">首页</a> | 
	<a href="Manager/News/NewsList.jsp?currentPage=${page.currentPage -1 }">上一页</a>
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="Manager/News/NewsList.jsp?currentPage=${page.currentPage + 1 }">下一页</a> | 
	<a href="Manager/News/NewsList.jsp?currentPage=${page.totalPage }">尾页</a>
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
	当前为第${page.currentPage}页,共${page.totalPage}页
  </div>

</body>
</html>
