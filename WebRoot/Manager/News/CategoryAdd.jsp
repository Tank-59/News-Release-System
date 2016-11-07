<%@page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Language" content="zh-CN" />
<title>添加新闻类别</title>
<link href="Manager/Style/Css.css" rel="stylesheet" type="text/css" />
<script language="javascript">
  String.prototype.Trim  =  function()
  {
		return  this.replace(/(^\s*)|(\s*$)/g,"");  
	}
	function back()
	{
		document.all.form1.action="CategoryList.jsp";
		document.form1.submit();
	}
</script>
</head>

<body>
<h3 class="subTitle">新闻类别</h3>

<form id="form1" name="form1" action="Back_Type_Add">	
	<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="table2">
			
  		<tr>
          <th width="15%" align="right">类别名称</th>
          <td><input name="type" type="text" class="input1" /></td>
      </tr>
    </table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0" class="yesno">
        <tr>
            <td height="50" align="center">
            	<input type="submit" name="Submit1" value="添加" style="height: 27px; "/> 
           		<input type="reset" name="Submit2" value="重置" style="height: 27px; "/>
           		<input type="button" name="Submit3" value="取消" onclick="back()" style="height: 28px; "/>
           	</td>
        </tr>
    </table>
</form>
</body>
</html>
