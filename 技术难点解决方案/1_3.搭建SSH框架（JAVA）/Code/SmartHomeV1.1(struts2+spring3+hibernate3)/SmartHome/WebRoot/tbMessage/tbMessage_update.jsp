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
	<form action="${root}/tbMessageAction!update.action" method="post">
	<table>
  		<tr>
  			<td>messageId：</td>
  			<td><input type="text" id="tbMessage_messageId" name="tbMessage.messageId" value="${tbMessage.messageId}" readonly="readonly" /></td>
  		</tr>
  		<tr>
  			<td>messageTypeId：</td>
  			<td><input type="text" id="tbMessage_messageTypeId" name="tbMessage.messageTypeId" value="${tbMessage.messageTypeId}" /></td>
  		</tr>
  		<tr>
  			<td>messageCon：</td>
  			<td><input type="text" id="tbMessage_messageCon" name="tbMessage.messageCon" value="${tbMessage.messageCon}" /></td>
  		</tr>
	</table>
	<input type="submit" value="提交" />
	</form>
	</body>
</html>