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
	<form name="pageQueryForm" action="${root}/bgInfoimgAction!pageQuery.action" method="post">
	<table border="1">
		<tr>
			<td>infoImgId：</td>
			<td><input type="text" id="bgInfoimg_infoImgId" name="bgInfoimg.infoImgId" value="${bgInfoimg.infoImgId}" /></td>
		</tr>
		<tr>
			<td>infoId：</td>
			<td><input type="text" id="bgInfoimg_infoId" name="bgInfoimg.infoId" value="${bgInfoimg.infoId}" /></td>
		</tr>
		<tr>
			<td>infoImgName：</td>
			<td><input type="text" id="bgInfoimg_infoImgName" name="bgInfoimg.infoImgName" value="${bgInfoimg.infoImgName}" /></td>
		</tr>
		<tr>
			<td>infoImgPath：</td>
			<td><input type="text" id="bgInfoimg_infoImgPath" name="bgInfoimg.infoImgPath" value="${bgInfoimg.infoImgPath}" /></td>
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
			<td>infoImgId</td>
			<td>infoId</td>
			<td>infoImgName</td>
			<td>infoImgPath</td>
		</tr>
		<c:forEach var="bgInfoimg" items="${pageModel.list}" varStatus="i">
		<tr>
			<td>${pageModel.start + i.index}</td>
			<td>${bgInfoimg.infoImgId}</td>
			<td>${bgInfoimg.infoId}</td>
			<td>${bgInfoimg.infoImgName}</td>
			<td>${bgInfoimg.infoImgPath}</td>
		</tr>
		</c:forEach>
	</table>
	</c:if>
	<jsp:include page="/pageView.jsp"></jsp:include>
	</form>
	</body>
</html>