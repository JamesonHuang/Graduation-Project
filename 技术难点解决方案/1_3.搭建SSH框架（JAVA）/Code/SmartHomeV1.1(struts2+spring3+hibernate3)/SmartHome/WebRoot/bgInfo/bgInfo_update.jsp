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
	<form action="${root}/bgInfoAction!update.action" method="post">
	<table>
  		<tr>
  			<td>infoId：</td>
  			<td><input type="text" id="bgInfo_infoId" name="bgInfo.infoId" value="${bgInfo.infoId}" readonly="readonly" /></td>
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
  			<td><input type="text" id="bgInfo_infoDate" name="bgInfo.infoDate" value="<fmt:formatDate value="${bgInfo.infoDate}" pattern="yyyy-MM-dd HH:mm:ss" />" /></td>
  		</tr>
  		<tr>
  			<td>infoHits：</td>
  			<td><input type="text" id="bgInfo_infoHits" name="bgInfo.infoHits" value="${bgInfo.infoHits}" /></td>
  		</tr>
	</table>
	<input type="submit" value="提交" />
	</form>
	</body>
</html>