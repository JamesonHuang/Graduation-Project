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
		var listIndex = ${fn:length(list) - 1};
		function addRow() {
			listIndex = listIndex + 1;
			var tab = $("#tab");
			var newRow = $("<tr></tr>");
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoId' name='list[" + listIndex + "].infoId' readonly='readonly' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_adminId' name='list[" + listIndex + "].adminId' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoTypeId' name='list[" + listIndex + "].infoTypeId' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoCon' name='list[" + listIndex + "].infoCon' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoTitle' name='list[" + listIndex + "].infoTitle' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoDate' name='list[" + listIndex + "].infoDate' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoHits' name='list[" + listIndex + "].infoHits' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='button' value='删除' onclick='deleteRow(this)' />"));
			tab.append(newRow);
		}

		function deleteRow(obj) {
			if($("#tab tr").length == 2) {
				alert("最少保留一行！");
			} else {
				$(obj).parent().parent().remove();
			}
		}
		</script>
	</head>
	<body>
	<form action="${root}/bgInfoAction!mergeAll.action" method="post" onsubmit="return checkForm()">
	<input type="button" value="添加行" onclick="addRow()" />
	<input type="submit" value="提交" />
	<table id="tab" border="1">
	<tr>
		<td>infoId</td>
		<td>adminId</td>
		<td>infoTypeId</td>
		<td>infoCon</td>
		<td>infoTitle</td>
		<td>infoDate</td>
		<td>infoHits</td>
		<td>删除行</td>
	</tr>
	<c:forEach var="bgInfo" items="${list}" varStatus="i">
	<tr>
		<td><input type="text" id="list_${i.index}_infoId" name="list[${i.index}].infoId" value="${bgInfo.infoId}" readonly="readonly" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_adminId" name="list[${i.index}].adminId" value="${bgInfo.adminId}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_infoTypeId" name="list[${i.index}].infoTypeId" value="${bgInfo.infoTypeId}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_infoCon" name="list[${i.index}].infoCon" value="${bgInfo.infoCon}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_infoTitle" name="list[${i.index}].infoTitle" value="${bgInfo.infoTitle}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_infoDate" name="list[${i.index}].infoDate" value="<fmt:formatDate value="${bgInfo.infoDate}" pattern="yyyy-MM-dd HH:mm:ss" />" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_infoHits" name="list[${i.index}].infoHits" value="${bgInfo.infoHits}" index="${i.index}" /></td>
		<td><input type="button" value="删除" disabled="disabled" /></td>
	</tr>
	</c:forEach>
	</table>
	</form>
	</body>
</html>