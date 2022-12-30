<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>부서번호 : ${dept.deptId}</p>
	<p>부서이름 : ${dept.deptTitle }</p>
	<ul>
		<c:forEach var="e" items="${dept.employees}">
			<li>${e.empName}</li>
			<li>${e.empNo}</li>
			<li>${e.salary}</li>
			<li>${e.bonus}</li>
		</c:forEach>
	</ul>
</body>
</html>