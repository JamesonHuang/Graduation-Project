<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<table style="font-size: 12px;">
		<tr><td>bgInfo</td><td></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>bgInfoimg</td><td></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoimgAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoimgAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoimgAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoimgAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoimgAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfoimgAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>bgInfotype</td><td></td></tr>
		<tr><td></td><td><a href="${root}/bgInfotypeAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/bgInfotypeAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfotypeAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfotypeAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfotypeAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/bgInfotypeAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>tbDevice</td><td></td></tr>
		<tr><td></td><td><a href="${root}/tbDeviceAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/tbDeviceAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/tbDeviceAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/tbDeviceAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbDeviceAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbDeviceAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>tbMessage</td><td></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>tbMessageType</td><td></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageTypeAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageTypeAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageTypeAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageTypeAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageTypeAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbMessageTypeAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>tbProDetail</td><td></td></tr>
		<tr><td></td><td><a href="${root}/tbProDetailAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/tbProDetailAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/tbProDetailAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/tbProDetailAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbProDetailAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbProDetailAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>tbProject</td><td></td></tr>
		<tr><td></td><td><a href="${root}/tbProjectAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/tbProjectAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/tbProjectAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/tbProjectAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbProjectAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbProjectAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>tbTask</td><td></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>tbTaskDetail</td><td></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskDetailAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskDetailAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskDetailAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskDetailAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskDetailAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbTaskDetailAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>tbUser</td><td></td></tr>
		<tr><td></td><td><a href="${root}/tbUserAction!initAdd.action" target="main">创建</a><br></td></tr>
		<tr><td></td><td><a href="${root}/tbUserAction!initAddAll.action" target="main">批量创建</a></td></tr>
		<tr><td></td><td><a href="${root}/tbUserAction!initMergeAll.action" target="main">批量修改</a></td></tr>
		<tr><td></td><td><a href="${root}/tbUserAction!selectAll.action" target="main">查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbUserAction!initConditionSelectAll.action" target="main">条件查询</a></td></tr>
		<tr><td></td><td><a href="${root}/tbUserAction!initPageQuery.action" target="main">分页查询</a></td></tr>
		<tr><td></td><td></td></tr>
		<tr><td></td><td></td></tr>
	</table>
	</body>
</html>