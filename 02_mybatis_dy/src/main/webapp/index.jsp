<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>직원 출력하기</h3>
	<h4><a href="${path}/employee/selectEmployeeAll.do">전체 직원 조회하기</a></h4>
	
	<h2>
		<a href="${path}/selectDept.do?deptId=D5">부서조회</a>
	</h2>
	
	<h2>
		<a href="${path}/boardView.do?boardNo=21">게시글 조회</a>
	</h2>
</body>
</html>