<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<form action="${root}/tbUserAction!update.action" method="post">
	<table>
  		<tr>
  			<td>userId：</td>
  			<td><input type="text" id="tbUser_userId" name="tbUser.userId" value="${tbUser.userId}" readonly="readonly" /></td>
  		</tr>
  		<tr>
  			<td>userName：</td>
  			<td><input type="text" id="tbUser_userName" name="tbUser.userName" value="${tbUser.userName}" /></td>
  		</tr>
  		<tr>
  			<td>userPwd：</td>
  			<td><input type="text" id="tbUser_userPwd" name="tbUser.userPwd" value="${tbUser.userPwd}" /></td>
  		</tr>
  		<tr>
  			<td>weiboKey：</td>
  			<td><input type="text" id="tbUser_weiboKey" name="tbUser.weiboKey" value="${tbUser.weiboKey}" /></td>
  		</tr>
  		<tr>
  			<td>qqKey：</td>
  			<td><input type="text" id="tbUser_qqKey" name="tbUser.qqKey" value="${tbUser.qqKey}" /></td>
  		</tr>
  		<tr>
  			<td>userImg：</td>
  			<td><input type="text" id="tbUser_userImg" name="tbUser.userImg" value="${tbUser.userImg}" /></td>
  		</tr>
	</table>
	<input type="submit" value="提交" />
	</form>
	</body>
</html>