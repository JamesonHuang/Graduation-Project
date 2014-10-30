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
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_taskId' name='list[" + listIndex + "].taskId' readonly='readonly' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_taskName' name='list[" + listIndex + "].taskName' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_taskType' name='list[" + listIndex + "].taskType' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_taskFromPro' name='list[" + listIndex + "].taskFromPro' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_taskFromTask' name='list[" + listIndex + "].taskFromTask' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_taskDate' name='list[" + listIndex + "].taskDate' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_taskTomatoesCount' name='list[" + listIndex + "].taskTomatoesCount' index='"+ listIndex +"' />"));
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
	<form action="${root}/tbTaskAction!mergeAll.action" method="post" onsubmit="return checkForm()">
	<input type="button" value="添加行" onclick="addRow()" />
	<input type="submit" value="提交" />
	<table id="tab" border="1">
	<tr>
		<td>taskId</td>
		<td>taskName</td>
		<td>taskType</td>
		<td>taskFromPro</td>
		<td>taskFromTask</td>
		<td>taskDate</td>
		<td>taskTomatoesCount</td>
		<td>删除行</td>
	</tr>
	<c:forEach var="tbTask" items="${list}" varStatus="i">
	<tr>
		<td><input type="text" id="list_${i.index}_taskId" name="list[${i.index}].taskId" value="${tbTask.taskId}" readonly="readonly" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_taskName" name="list[${i.index}].taskName" value="${tbTask.taskName}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_taskType" name="list[${i.index}].taskType" value="${tbTask.taskType}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_taskFromPro" name="list[${i.index}].taskFromPro" value="${tbTask.taskFromPro}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_taskFromTask" name="list[${i.index}].taskFromTask" value="${tbTask.taskFromTask}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_taskDate" name="list[${i.index}].taskDate" value="${tbTask.taskDate}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_taskTomatoesCount" name="list[${i.index}].taskTomatoesCount" value="${tbTask.taskTomatoesCount}" index="${i.index}" /></td>
		<td><input type="button" value="删除" disabled="disabled" /></td>
	</tr>
	</c:forEach>
	</table>
	</form>
	</body>
</html>