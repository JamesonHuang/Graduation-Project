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
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_deviceId' name='list[" + listIndex + "].deviceId' readonly='readonly' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_deviceName' name='list[" + listIndex + "].deviceName' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_userId' name='list[" + listIndex + "].userId' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_deviceKey' name='list[" + listIndex + "].deviceKey' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_isOnline' name='list[" + listIndex + "].isOnline' index='"+ listIndex +"' />"));
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
	<form action="${root}/tbDeviceAction!mergeAll.action" method="post" onsubmit="return checkForm()">
	<input type="button" value="添加行" onclick="addRow()" />
	<input type="submit" value="提交" />
	<table id="tab" border="1">
	<tr>
		<td>deviceId</td>
		<td>deviceName</td>
		<td>userId</td>
		<td>deviceKey</td>
		<td>isOnline</td>
		<td>删除行</td>
	</tr>
	<c:forEach var="tbDevice" items="${list}" varStatus="i">
	<tr>
		<td><input type="text" id="list_${i.index}_deviceId" name="list[${i.index}].deviceId" value="${tbDevice.deviceId}" readonly="readonly" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_deviceName" name="list[${i.index}].deviceName" value="${tbDevice.deviceName}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_userId" name="list[${i.index}].userId" value="${tbDevice.userId}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_deviceKey" name="list[${i.index}].deviceKey" value="${tbDevice.deviceKey}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_isOnline" name="list[${i.index}].isOnline" value="${tbDevice.isOnline}" index="${i.index}" /></td>
		<td><input type="button" value="删除" disabled="disabled" /></td>
	</tr>
	</c:forEach>
	</table>
	</form>
	</body>
</html>