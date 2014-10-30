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
			form.attr("action", "${root}/tbProjectAction!conditionSelectAll.action");
			form.submit();
		}

		function deleteAll() {
			if($("input[name^=list][name$=proId]:checked").length == 0) {
				alert("请选择要删除的数据！");
			} else {
				var form = $("#queryForm");
				form.attr("action", "${root}/tbProjectAction!deleteAll.action");
				form.submit();
			}
		}

		function selectAll(obj) {
			$("input[name^=list][name$=proId]").attr("checked", obj.checked);
		}
		</script>
	</head>
	<body>
	<form id="queryForm" action="" method="post">
	<table border="1">
		<tr>
			<td>proId：</td>
			<td><input type="text" id="tbProject_proId" name="tbProject.proId" value="${tbProject.proId}" /></td>
		</tr>
		<tr>
			<td>proName：</td>
			<td><input type="text" id="tbProject_proName" name="tbProject.proName" value="${tbProject.proName}" /></td>
		</tr>
		<tr>
			<td>proIntro：</td>
			<td><input type="text" id="tbProject_proIntro" name="tbProject.proIntro" value="${tbProject.proIntro}" /></td>
		</tr>
		<tr>
			<td>userId：</td>
			<td><input type="text" id="tbProject_userId" name="tbProject.userId" value="${tbProject.userId}" /></td>
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
			<td>proId</td>
			<td>proName</td>
			<td>proIntro</td>
			<td>userId</td>
			<td>删除</td>
			<td>修改</td>
		</tr>
		<c:forEach var="tbProject" items="${list}" varStatus="i">
		<tr>
			<td><input type="checkbox" name="list[${i.index}].proId" value="${tbProject.proId}" /></td>
			<td>${i.index + 1}</td>
			<td>${tbProject.proId}</td>
			<td>${tbProject.proName}</td>
			<td>${tbProject.proIntro}</td>
			<td>${tbProject.userId}</td>
			<td><a href="${root}/tbProjectAction!delete.action?tbProject.proId=${tbProject.proId}">删除</a></td>
			<td><a href="${root}/tbProjectAction!initUpdate.action?tbProject.proId=${tbProject.proId}">修改</a></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	</form>
	</body>
</html>