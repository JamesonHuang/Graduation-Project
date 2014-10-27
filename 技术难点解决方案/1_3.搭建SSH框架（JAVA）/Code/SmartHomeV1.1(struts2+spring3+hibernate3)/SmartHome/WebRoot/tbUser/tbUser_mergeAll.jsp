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
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_userId' name='list[" + listIndex + "].userId' readonly='readonly' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_userName' name='list[" + listIndex + "].userName' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_userPwd' name='list[" + listIndex + "].userPwd' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_weiboKey' name='list[" + listIndex + "].weiboKey' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_qqKey' name='list[" + listIndex + "].qqKey' index='"+ listIndex +"' />"));
			newRow.append($("<td></td>").append("<input type='text' id='list_"+ listIndex +"_userImg' name='list[" + listIndex + "].userImg' index='"+ listIndex +"' />"));
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
	<form action="${root}/tbUserAction!mergeAll.action" method="post" onsubmit="return checkForm()">
	<input type="button" value="添加行" onclick="addRow()" />
	<input type="submit" value="提交" />
	<table id="tab" border="1">
	<tr>
		<td>userId</td>
		<td>userName</td>
		<td>userPwd</td>
		<td>weiboKey</td>
		<td>qqKey</td>
		<td>userImg</td>
		<td>删除行</td>
	</tr>
	<c:forEach var="tbUser" items="${list}" varStatus="i">
	<tr>
		<td><input type="text" id="list_${i.index}_userId" name="list[${i.index}].userId" value="${tbUser.userId}" readonly="readonly" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_userName" name="list[${i.index}].userName" value="${tbUser.userName}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_userPwd" name="list[${i.index}].userPwd" value="${tbUser.userPwd}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_weiboKey" name="list[${i.index}].weiboKey" value="${tbUser.weiboKey}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_qqKey" name="list[${i.index}].qqKey" value="${tbUser.qqKey}" index="${i.index}" /></td>
		<td><input type="text" id="list_${i.index}_userImg" name="list[${i.index}].userImg" value="${tbUser.userImg}" index="${i.index}" /></td>
		<td><input type="button" value="删除" disabled="disabled" /></td>
	</tr>
	</c:forEach>
	</table>
	</form>
	</body>
</html>