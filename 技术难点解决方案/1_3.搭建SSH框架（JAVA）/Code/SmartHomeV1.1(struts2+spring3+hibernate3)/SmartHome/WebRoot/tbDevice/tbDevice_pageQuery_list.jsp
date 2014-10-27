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
	<form name="pageQueryForm" action="${root}/tbDeviceAction!pageQuery.action" method="post">
	<table border="1">
		<tr>
			<td>deviceId：</td>
			<td><input type="text" id="tbDevice_deviceId" name="tbDevice.deviceId" value="${tbDevice.deviceId}" /></td>
		</tr>
		<tr>
			<td>deviceName：</td>
			<td><input type="text" id="tbDevice_deviceName" name="tbDevice.deviceName" value="${tbDevice.deviceName}" /></td>
		</tr>
		<tr>
			<td>userId：</td>
			<td><input type="text" id="tbDevice_userId" name="tbDevice.userId" value="${tbDevice.userId}" /></td>
		</tr>
		<tr>
			<td>deviceKey：</td>
			<td><input type="text" id="tbDevice_deviceKey" name="tbDevice.deviceKey" value="${tbDevice.deviceKey}" /></td>
		</tr>
		<tr>
			<td>isOnline：</td>
			<td><input type="text" id="tbDevice_isOnline" name="tbDevice.isOnline" value="${tbDevice.isOnline}" /></td>
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
			<td>deviceId</td>
			<td>deviceName</td>
			<td>userId</td>
			<td>deviceKey</td>
			<td>isOnline</td>
		</tr>
		<c:forEach var="tbDevice" items="${pageModel.list}" varStatus="i">
		<tr>
			<td>${pageModel.start + i.index}</td>
			<td>${tbDevice.deviceId}</td>
			<td>${tbDevice.deviceName}</td>
			<td>${tbDevice.userId}</td>
			<td>${tbDevice.deviceKey}</td>
			<td>${tbDevice.isOnline}</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	<jsp:include page="/pageView.jsp"></jsp:include>
	</form>
	</body>
</html>