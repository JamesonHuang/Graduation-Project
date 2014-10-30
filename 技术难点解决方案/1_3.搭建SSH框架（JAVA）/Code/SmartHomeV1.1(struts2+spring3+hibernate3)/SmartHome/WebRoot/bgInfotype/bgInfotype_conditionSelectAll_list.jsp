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
			form.attr("action", "${root}/bgInfotypeAction!conditionSelectAll.action");
			form.submit();
		}

		function deleteAll() {
			if($("input[name^=list][name$=infoTypeId]:checked").length == 0) {
				alert("请选择要删除的数据！");
			} else {
				var form = $("#queryForm");
				form.attr("action", "${root}/bgInfotypeAction!deleteAll.action");
				form.submit();
			}
		}

		function selectAll(obj) {
			$("input[name^=list][name$=infoTypeId]").attr("checked", obj.checked);
		}
		</script>
	</head>
	<body>
	<form id="queryForm" action="" method="post">
	<table border="1">
		<tr>
			<td>infoTypeId：</td>
			<td><input type="text" id="bgInfotype_infoTypeId" name="bgInfotype.infoTypeId" value="${bgInfotype.infoTypeId}" /></td>
		</tr>
		<tr>
			<td>infoTypeName：</td>
			<td><input type="text" id="bgInfotype_infoTypeName" name="bgInfotype.infoTypeName" value="${bgInfotype.infoTypeName}" /></td>
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
			<td>infoTypeId</td>
			<td>infoTypeName</td>
			<td>删除</td>
			<td>修改</td>
		</tr>
		<c:forEach var="bgInfotype" items="${list}" varStatus="i">
		<tr>
			<td><input type="checkbox" name="list[${i.index}].infoTypeId" value="${bgInfotype.infoTypeId}" /></td>
			<td>${i.index + 1}</td>
			<td>${bgInfotype.infoTypeId}</td>
			<td>${bgInfotype.infoTypeName}</td>
			<td><a href="${root}/bgInfotypeAction!delete.action?bgInfotype.infoTypeId=${bgInfotype.infoTypeId}">删除</a></td>
			<td><a href="${root}/bgInfotypeAction!initUpdate.action?bgInfotype.infoTypeId=${bgInfotype.infoTypeId}">修改</a></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	</form>
	</body>
</html>