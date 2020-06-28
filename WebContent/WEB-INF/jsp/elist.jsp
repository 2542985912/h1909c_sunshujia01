<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/jQuery/jq.js"></script>
<script type="text/javascript">
	function jump(obj) {
		var pages='${page.pages}';
		if (obj>=1 && obj<=pages) {
			$("#pn").val(obj);
			$("#fm").submit();
		}
	}
</script>
</head>
<body>
<a href="${pageContext.request.contextPath }/toadd.action">添加</a>
<form action="${pageContext.request.contextPath }/findAll.action" method="post" id="fm">
<input type="hidden" name="pageNum" value="${page.pageNum }" id="pn">
姓名:<input type="text" name="ename" value="${employee.ename }">
<input type="button" value="搜索"><br>
	<table border="1" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>姓名</td>
			<td>部门</td>
			<td>生日</td>
			<td>爱好</td>
			<td>操作</td>
		</tr>
		<c:forEach var="e" items="${page.list }">
			<tr>
				<td>${e.eid }</td>
				<td>${e.ename }</td>
				<td>${e.dname }</td>
				<td><fmt:formatDate value="${e.birthday }" pattern="yyyy-MM-dd"/></td>
				<td>${e.hobby }</td>
				<td>
					<a href="${pageContext.request.contextPath }/findById.action?eid=${e.eid }">修改</a>
					<a href="${pageContext.request.contextPath }/deleteById.action?eid=${e.eid }" onclick="return confirm('确认删除此条数据')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
<input type="button" value="首页" onclick="jump(${page.firstPage})">
<input type="button" value="上一页" onclick="jump(${page.prePage})">
<input type="button" value="下一页" onclick="jump(${page.nextPage})">
<input type="button" value="尾页" onclick="jump(${page.lastPage})">
第${page.pageNum }页/共${page.pages }页
跳转到<input name="pageNum"><input type="submit" value="GO">
</form>
</body>
</html>