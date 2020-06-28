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
	function getName(ename) {
		$.post("${pageContext.request.contextPath }/findByName.action",{ename:ename},
				function (data) {
					if (data=="1") {
						$("#spanid").text("姓名不可重复");
						
					}else {
						$("#spanid").text("√");
						
					}
				})
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/update.action" method="post">
<input type="hidden" name="eid" value="${e.eid }">
姓名:<input type="text" name="ename" value="${e.ename }" onblur="getName(this.value)">
<span id="spanid"></span><br>
生日:<input type="date" name="birthday" value="<fmt:formatDate value="${e.birthday }" pattern="yyyy-MM-dd"/>"><br>
部门:<select name="deid">
		<c:forEach var="d" items="${dlist }">
			<option value="${d.deid }" ${d.deid==e.deid?'selected':'' }>${d.dname }</option>
		</c:forEach>
	</select><br>
爱好:<input type="checkbox" name="hobby" value="篮球"  ${e.hobby=='篮球'?'checked':'' }>篮球
	<input type="checkbox" name="hobby" value="足球" ${e.hobby=='足球'?'checked':'' }>足球
	<input type="checkbox" name="hobby" value="排球" ${e.hobby=='排球'?'checked':'' }>排球<br>
<input type="submit" value="修改">
</form>
</body>
</html>