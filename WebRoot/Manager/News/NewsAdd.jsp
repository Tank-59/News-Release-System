<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=gb18030" />
<meta http-equiv="Content-Language" content="zh-CN" />

<title>添加新闻</title>
<link href="Manager/Style/Css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="KindEditor/themes/default/default.css" />
<link rel="stylesheet" href="KindEditor/plugins/code/prettify.css" />
<script language="javascript">
  String.prototype.Trim  =  function()
  {
		return  this.replace(/(^\s*)|(\s*$)/g,"");  
	}
	
	function goto1()
	{
		if(check()){
	    	document.form1.submit();
		}
	}

	function check()
	{
		if(document.all.form1.title.value.Trim()==""){
			alert("请填写标题!");
			return false;
		 }

		 return true;
	}
	
	function back()
	{
		document.all.form1.action="NewsList.jsp";
		document.form1.submit();
	}
</script>
<script charset="utf-8" src="KindEditor/kindeditor.js"></script>
	<script charset="utf-8" src="KindEditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="KindEditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : 'KindEditor/plugins/code/prettify.css',
				uploadJson : 'KindEditor/jsp/upload_json.jsp',
				fileManagerJson : 'KindEditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>

</head>
<body>
<h3 class="subTitle">添加新闻</h3>
<%=htmlData%>
<form id="form1" name="form1" action="Back_News_Add"  onsubmit="check();">
		<table width="90%" border="0" align="center" cellpadding="0" class="table2" cellspacing="0">
		    <tr>
          <th width="15%" align="right">新闻类别</th>
          <td>
          	<select name="column">
          	    <c:forEach items="${list}" var="type" >
					<option value="${type.tid}">${type.tname}</option>		
				</c:forEach>
			</select>
					</td>
      	</tr>
		    <tr>
		        <th align="right">文章标题</th>
		        <td><input name="header" type="text" class="input1" id="header"/></td>
		    </tr>
		    <tr>
		        <th align="right" valign="top">文章内容</th>
		        <td>
		          <textarea name="content1" cols="100" rows="8" style="width:700px;height:500px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		        </td>
		    </tr>
		</table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
            	<input type="submit" name="Submit" value="添加"  style="height: 26px; "/>
            	<input type="reset" name="Submit2" value="重置" style="height: 26px; "/>
            	<input type="button" name="Submit" value="取消" onclick="back()" style="height: 27px; "/> 
           	</td>
        </tr>
    </table>
</form>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>