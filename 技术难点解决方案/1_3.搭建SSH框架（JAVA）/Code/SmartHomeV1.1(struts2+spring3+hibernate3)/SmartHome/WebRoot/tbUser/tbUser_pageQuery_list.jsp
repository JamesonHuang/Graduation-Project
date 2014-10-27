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
	<form name="pageQueryForm" action="${root}/tbUserAction!pageQuery.action" method="post">
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
			<td>userId</td>
			<td>userName</td>
			<td>userPwd</td>
			<td>weiboKey</td>
			<td>qqKey</td>
			<td>userImg</td>
		</tr>
		<c:forEach var="tbUser" items="${pageModel.list}" varStatus="i">
		<tr>
			<td>${pageModel.start + i.index}</td>
			<td>${tbUser.userId}</td>
			<td>${tbUser.userName}</td>
			<td>${tbUser.userPwd}</td>
			<td>${tbUser.weiboKey}</td>
			<td>${tbUser.qqKey}</td>
			<td>${tbUser.userImg}</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	<jsp:include page="/pageView.jsp"></jsp:include>
	</form>
	</body>
</html>