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
	<form name="pageQueryForm" action="${root}/bgInfoAction!pageQuery.action" method="post">
	<table border="1">
		<tr>
			<td>infoId：</td>
			<td><input type="text" id="bgInfo_infoId" name="bgInfo.infoId" value="${bgInfo.infoId}" /></td>
		</tr>
		<tr>
			<td>adminId：</td>
			<td><input type="text" id="bgInfo_adminId" name="bgInfo.adminId" value="${bgInfo.adminId}" /></td>
		</tr>
		<tr>
			<td>infoTypeId：</td>
			<td><input type="text" id="bgInfo_infoTypeId" name="bgInfo.infoTypeId" value="${bgInfo.infoTypeId}" /></td>
		</tr>
		<tr>
			<td>infoCon：</td>
			<td><input type="text" id="bgInfo_infoCon" name="bgInfo.infoCon" value="${bgInfo.infoCon}" /></td>
		</tr>
		<tr>
			<td>infoTitle：</td>
			<td><input type="text" id="bgInfo_infoTitle" name="bgInfo.infoTitle" value="${bgInfo.infoTitle}" /></td>
		</tr>
		<tr>
			<td>infoDate：</td>
			<td><input type="text" id="bgInfo_infoDateBegin" name="bgInfo.infoDateBegin" value="<fmt:formatDate value="${bgInfo.infoDateBegin}" pattern="yyyy-MM-dd HH:mm:ss" />" /> <input type="text" id="bgInfo_infoDateEnd" name="bgInfo.infoDateEnd" value="<fmt:formatDate value="${bgInfo.infoDateEnd}" pattern="yyyy-MM-dd HH:mm:ss" />" /></td>
		</tr>
		<tr>
			<td>infoHits：</td>
			<td><input type="text" id="bgInfo_infoHits" name="bgInfo.infoHits" value="${bgInfo.infoHits}" /></td>
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
			<td>infoId</td>
			<td>adminId</td>
			<td>infoTypeId</td>
			<td>infoCon</td>
			<td>infoTitle</td>
			<td>infoDate</td>
			<td>infoHits</td>
		</tr>
		<c:forEach var="bgInfo" items="${pageModel.list}" varStatus="i">
		<tr>
			<td>${pageModel.start + i.index}</td>
			<td>${bgInfo.infoId}</td>
			<td>${bgInfo.adminId}</td>
			<td>${bgInfo.infoTypeId}</td>
			<td>${bgInfo.infoCon}</td>
			<td>${bgInfo.infoTitle}</td>
			<td><fmt:formatDate value="${bgInfo.infoDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<td>${bgInfo.infoHits}</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	<jsp:include page="/pageView.jsp"></jsp:include>
	</form>
	</body>
</html>