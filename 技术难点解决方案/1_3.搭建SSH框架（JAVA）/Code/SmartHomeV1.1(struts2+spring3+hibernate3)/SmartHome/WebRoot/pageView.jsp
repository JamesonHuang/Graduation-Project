<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String root = request.getContextPath();
	pageContext.setAttribute("root", root);
%>
<input type="hidden" name="pageModel.currentPage" id="currentPage" />
<c:if test="${pageModel.list != null && fn:length(pageModel.list) > 0}">
当前页${pageModel.currentPage}/${pageModel.totalPages}
<c:if test="${pageModel.hasPreviousPage}">
<a href="#" onclick="return goPage(1)">首页</a>  
<a href="#" onclick="return goPage(${pageModel.previousPage})">上一页</a>
</c:if>
<c:if test="${!pageModel.hasPreviousPage}">
首页  上一页
</c:if>

<c:if test="${pageModel.hasNextPage}">
<a href="#" onclick="return goPage(${pageModel.nextPage})">下一页</a>  
<a href="#" onclick="return goPage(${pageModel.totalPages})">尾页</a>  
</c:if>
<c:if test="${!pageModel.hasNextPage}">
下一页  尾页  
</c:if>
每页${pageModel.pageSize}条  
共${pageModel.totalRows}条  
转到<input type="text" id="gotoPageNum" style="width: 30px;" />页  
<input type="button" value="GO" onclick="gotoPage()" />
<script language="JavaScript">
// 分页跳转
function goPage(pageNum) {
	var page = document.getElementById("currentPage");
	page.value = pageNum;
	if(page.value.length > 0) {
		var form = document.pageQueryForm;
		form.submit();
	}
	return false;
}
// 跳转到
function gotoPage() {
	var page = document.getElementById("gotoPageNum").value;
	var gotoPageNum = parseInt(page);
	var totalPagesNum = parseInt("${pageModel.totalPages}");
	var currentPage = parseInt("${pageModel.currentPage}");
	if(gotoPageNum > 0) {
		if(gotoPageNum > totalPagesNum) {
			alert("跳转的页数不能大于总页数！");
		} else if(gotoPageNum == currentPage) {
			alert("当前就是第" + gotoPageNum + "页！");
		} else {
			goPage(gotoPageNum);
		}
	} else {
		alert("页数值不正确！");
	}
}
</script>
</c:if>