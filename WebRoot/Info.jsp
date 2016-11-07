<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div id="main">
		<div class="doc-info-view">
			<div class="hd"><h1>${news.ntitle }</h1></div>
			<hr class="double" />
			<!--[if !IE]>文章属性<![endif]-->
			<div class="doc-parameter">				
				<div>${news.npublishTime }</div>				
			</div>
			<!--[if !IE]>正文<![endif]-->
			<div class="doc-text">
				<p>${news.ncontent }</p>
			</div>
			<!--[if !IE]>评论<![endif]-->
			<hr class="double" />
			<div class="comment">
				<div class="hd"><h3>最新评论</h3></div>
				<!--[if !IE]>评论列表 开始<![endif]-->
				<ol class="com-list">
	              <c:forEach items="${list }" var="rev" varStatus="i">
					<li>
						<p class="title wrapfix"><span class="num">${i.count }</span><span class="name">${rev.ruserName }</span><span class="time">${rev.rrevTime }</span></p>
						<div class="com-body">
							${rev.rcontent }
						</div>
					</li>
				 </c:forEach>
				</ol>
				<!--[if !IE]>评论列表 结束<![endif]-->
				<!--[if !IE]>填写评论 开始<![endif]-->
<div align="center">
	<c:choose>
		<c:when test="${page.hasPrePage}">
	<a href="/News/News_Select?method=${param.method }&time=${param.time}&nid=${news.nid }&currentPage=1">首页</a> | 
	<a href="/News/News_Select?method=${param.method }&time=${param.time}&nid=${news.nid }&currentPage=${page.currentPage -1 }">上一页</a>
		</c:when>
		<c:otherwise>
			首页 | 上一页
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.hasNextPage}">
			<a href="/News/News_Select?method=${param.method }&time=${param.time}&nid=${news.nid }&currentPage=${page.currentPage + 1 }">下一页</a> | 
	<a href="/News/News_Select?method=${param.method }&time=${param.time}&nid=${news.nid }&currentPage=${page.totalPage }">尾页</a>
		</c:when>
		<c:otherwise>
			下一页 | 尾页
		</c:otherwise>
	</c:choose>
	当前为第${page.currentPage}页,共${page.totalPage}页
  </div>
				<div class="com-form">
				<hr class="double" />
					<div class="hd"><h3>发表评论</h3></div>
					<p class="tips">请自觉遵守互联网相关政策法规，评论不得超过250字。</p>
					<form id="form1" method="post" action="News_Select">
						<p><textarea name="textarea" id="textarea" rows="5" class="textarea"></textarea></p>
						<p>
							<label for="username">昵称</label><input type="text" name="username" value="游客"size="10" id="username" class="iText" />
							<input type="submit" name="Submit" class="btn" value="发表评论" />
							<input type="hidden" name="hidden" value="${news.nid }"/>
							<input type="hidden" name="times" value="1"/>
							<input type="hidden" name="nid" value="${news.nid }"/>
						</p>
					</form>
				</div>
				<!--[if !IE]>填写评论 开始<![endif]-->
			</div>
		</div>
		<!--[if !IE]>新闻详情 结束<![endif]-->
	</div>
	<!--[if !IE]>main 结束<![endif]-->
	<div id="footer">
		<p>版权所有 &copy;<a href="http://www.sdili.edu.cn" target="_blank">齐鲁工业大学-曹艳奇 </a></p>
	</div>
	<!--[if !IE]>main 结束<![endif]-->
</div>
</body>
</html>