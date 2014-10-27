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
	<form action="${root}/tbTaskAction!update.action" method="post">
	<table>
  		<tr>
  			<td>taskId：</td>
  			<td><input type="text" id="tbTask_taskId" name="tbTask.taskId" value="${tbTask.taskId}" readonly="readonly" /></td>
  		</tr>
  		<tr>
  			<td>taskName：</td>
  			<td><input type="text" id="tbTask_taskName" name="tbTask.taskName" value="${tbTask.taskName}" /></td>
  		</tr>
  		<tr>
  			<td>taskType：</td>
  			<td><input type="text" id="tbTask_taskType" name="tbTask.taskType" value="${tbTask.taskType}" /></td>
  		</tr>
  		<tr>
  			<td>taskFromPro：</td>
  			<td><input type="text" id="tbTask_taskFromPro" name="tbTask.taskFromPro" value="${tbTask.taskFromPro}" /></td>
  		</tr>
  		<tr>
  			<td>taskFromTask：</td>
  			<td><input type="text" id="tbTask_taskFromTask" name="tbTask.taskFromTask" value="${tbTask.taskFromTask}" /></td>
  		</tr>
  		<tr>
  			<td>taskDate：</td>
  			<td><input type="text" id="tbTask_taskDate" name="tbTask.taskDate" value="${tbTask.taskDate}" /></td>
  		</tr>
  		<tr>
  			<td>taskTomatoesCount：</td>
  			<td><input type="text" id="tbTask_taskTomatoesCount" name="tbTask.taskTomatoesCount" value="${tbTask.taskTomatoesCount}" /></td>
  		</tr>
	</table>
	<input type="submit" value="提交" />
	</form>
	</body>
</html>