<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String root = request.getContextPath();
	pageContext.setAttribute("root", root);
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + root + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title></title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
	<form action="${root}/bgInfoimgAction!add.action" method="post">
	<table>
  		<tr>
  			<td>infoId：</td>
  			<td><input type="text" id="bgInfoimg_infoId" name="bgInfoimg.infoId" /></td>
  		</tr>
  		<tr>
  			<td>infoImgName：</td>
  			<td><input type="text" id="bgInfoimg_infoImgName" name="bgInfoimg.infoImgName" /></td>
  		</tr>
  		<tr>
  			<td>infoImgPath：</td>
  			<td><input type="text" id="bgInfoimg_infoImgPath" name="bgInfoimg.infoImgPath" /></td>
  		</tr>
	</table>
	<input type="submit" value="提交" />
	</form>
	</body>
</html>