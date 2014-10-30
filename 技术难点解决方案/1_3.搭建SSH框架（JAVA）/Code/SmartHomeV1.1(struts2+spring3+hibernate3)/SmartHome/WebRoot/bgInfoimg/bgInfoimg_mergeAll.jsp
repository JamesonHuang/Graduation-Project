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
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoImgId' name='list[" + listIndex + "].infoImgId' readonly='readonly' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoId' name='list[" + listIndex + "].infoId' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoImgName' name='list[" + listIndex + "].infoImgName' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_infoImgPath' name='list[" + listIndex + "].infoImgPath' index='"+ listIndex +"' />"));
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
	<form action="${root}/bgInfoimgAction!mergeAll.action" method="post" onsubmit="return checkForm()">
	<input type="button" value="添加行" onclick="addRow()" />
	<input type="submit" value="提交" />
	<table id="tab" border="1">
	<tr>
		<td>infoImgId</td>
		<td>infoId</td>
		<td>infoImgName</td>
		<td>infoImgPath</td>
		<td>删除行</td>
	</tr>
	<c:forEach var="bgInfoimg" items="${list}" varStatus="i">
	<tr>
		<td><input type="text" id="list_${i.index}_infoImgId" name="list[${i.index}].infoImgId" value="${bgInfoimg.infoImgId}" readonly="readonly" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_infoId" name="list[${i.index}].infoId" value="${bgInfoimg.infoId}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_infoImgName" name="list[${i.index}].infoImgName" value="${bgInfoimg.infoImgName}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_infoImgPath" name="list[${i.index}].infoImgPath" value="${bgInfoimg.infoImgPath}" index="${i.index}" /></td>
		<td><input type="button" value="删除" disabled="disabled" /></td>
	</tr>
	</c:forEach>
	</table>
	</form>
	</body>
</html>