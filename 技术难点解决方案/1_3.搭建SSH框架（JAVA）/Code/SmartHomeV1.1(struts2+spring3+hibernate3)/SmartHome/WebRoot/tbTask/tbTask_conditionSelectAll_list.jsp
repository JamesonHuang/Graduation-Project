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
		<script type="text/javascript" src="${root}/js/jquery.js"></script>
		<script type="text/javascript">
		function query() {
			var form = $("#queryForm");
			form.attr("action", "${root}/tbTaskAction!conditionSelectAll.action");
			form.submit();
		}

		function deleteAll() {
			if($("input[name^=list][name$=taskId]:checked").length == 0) {
				alert("请选择要删除的数据！");
			} else {
				var form = $("#queryForm");
				form.attr("action", "${root}/tbTaskAction!deleteAll.action");
				form.submit();
			}
		}

		function selectAll(obj) {
			$("input[name^=list][name$=taskId]").attr("checked", obj.checked);
		}
		</script>
	</head>
	<body>
	<form id="queryForm" action="" method="post">
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
  			<td colspan="2">
  				<input type="button" value="查询" onclick="query()" />
  				<input type="button" value="批量删除" onclick="deleteAll()" />
  			</td>
  		</tr>
	</table>

	<c:if test="${list == null}">
	请点击查询按钮进行查询。
	</c:if>

	<c:if test="${list != null && fn:length(list) == 0}">
	没有复合条件的数据。
	</c:if>

	<c:if test="${list != null && fn:length(list) > 0}">
	<table border="1">
		<tr>
			<td>全选<input type="checkbox" onclick="selectAll(this)" /></td>
			<td>序号</td>
			<td>taskId</td>
			<td>taskName</td>
			<td>taskType</td>
			<td>taskFromPro</td>
			<td>taskFromTask</td>
			<td>taskDate</td>
			<td>taskTomatoesCount</td>
			<td>删除</td>
			<td>修改</td>
		</tr>
		<c:forEach var="tbTask" items="${list}" varStatus="i">
		<tr>
			<td><input type="checkbox" name="list[${i.index}].taskId" value="${tbTask.taskId}" /></td>
			<td>${i.index + 1}</td>
			<td>${tbTask.taskId}</td>
			<td>${tbTask.taskName}</td>
			<td>${tbTask.taskType}</td>
			<td>${tbTask.taskFromPro}</td>
			<td>${tbTask.taskFromTask}</td>
			<td>${tbTask.taskDate}</td>
			<td>${tbTask.taskTomatoesCount}</td>
			<td><a href="${root}/tbTaskAction!delete.action?tbTask.taskId=${tbTask.taskId}">删除</a></td>
			<td><a href="${root}/tbTaskAction!initUpdate.action?tbTask.taskId=${tbTask.taskId}">修改</a></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	</form>
	</body>
</html>