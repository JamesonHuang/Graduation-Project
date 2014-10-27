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
			form.attr("action", "${root}/tbUserAction!conditionSelectAll.action");
			form.submit();
		}

		function deleteAll() {
			if($("input[name^=list][name$=userId]:checked").length == 0) {
				alert("请选择要删除的数据！");
			} else {
				var form = $("#queryForm");
				form.attr("action", "${root}/tbUserAction!deleteAll.action");
				form.submit();
			}
		}

		function selectAll(obj) {
			$("input[name^=list][name$=userId]").attr("checked", obj.checked);
		}
		</script>
	</head>
	<body>
	<form id="queryForm" action="" method="post">
	<table border="1">
		<tr>
			<td>userId：</td>
			<td><input type="text" id="tbUser_userId" name="tbUser.userId" value="${tbUser.userId}" /></td>
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
			<td>userId</td>
			<td>userName</td>
			<td>userPwd</td>
			<td>weiboKey</td>
			<td>qqKey</td>
			<td>userImg</td>
			<td>删除</td>
			<td>修改</td>
		</tr>
		<c:forEach var="tbUser" items="${list}" varStatus="i">
		<tr>
			<td><input type="checkbox" name="list[${i.index}].userId" value="${tbUser.userId}" /></td>
			<td>${i.index + 1}</td>
			<td>${tbUser.userId}</td>
			<td>${tbUser.userName}</td>
			<td>${tbUser.userPwd}</td>
			<td>${tbUser.weiboKey}</td>
			<td>${tbUser.qqKey}</td>
			<td>${tbUser.userImg}</td>
			<td><a href="${root}/tbUserAction!delete.action?tbUser.userId=${tbUser.userId}">删除</a></td>
			<td><a href="${root}/tbUserAction!initUpdate.action?tbUser.userId=${tbUser.userId}">修改</a></td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	</form>
	</body>
</html>