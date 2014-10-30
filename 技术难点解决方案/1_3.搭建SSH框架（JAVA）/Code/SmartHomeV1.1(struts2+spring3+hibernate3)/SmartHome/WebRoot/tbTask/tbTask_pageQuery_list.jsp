<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<form name="pageQueryForm" action="${root}/tbTaskAction!pageQuery.action" method="post">
	<table border="1">
		<tr>
			<td>taskId：</td>
			<td><input type="text" id="tbTask_taskId" name="tbTask.taskId" value="${tbTask.taskId}" /></td>
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
  		<tr>
  			<td colspan="2"><input type="submit" value="查询" /></td>
  		</tr>
	</table>
	
	<c:if test="${pageModel.list == null}">
	请点击查询按钮进行查询。
	</c:if>
	
	<c:if test="${pageModel.list != null && fn:length(pageModel.list) == 0}">
	没有复合条件的数据。
	</c:if>
	
	<c:if test="${pageModel.list != null && fn:length(pageModel.list) > 0}">
	<table border="1">
		<tr>
			<td>序号</td>
			<td>taskId</td>
			<td>taskName</td>
			<td>taskType</td>
			<td>taskFromPro</td>
			<td>taskFromTask</td>
			<td>taskDate</td>
			<td>taskTomatoesCount</td>
		</tr>
		<c:forEach var="tbTask" items="${pageModel.list}" varStatus="i">
		<tr>
			<td>${pageModel.start + i.index}</td>
			<td>${tbTask.taskId}</td>
			<td>${tbTask.taskName}</td>
			<td>${tbTask.taskType}</td>
			<td>${tbTask.taskFromPro}</td>
			<td>${tbTask.taskFromTask}</td>
			<td>${tbTask.taskDate}</td>
			<td>${tbTask.taskTomatoesCount}</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	<jsp:include page="/pageView.jsp"></jsp:include>
	</form>
	</body>
</html>