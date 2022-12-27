<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>마이바티스 활용하기</title>
</head>
<body>
	<h2>mybatis 경험해보자</h2>
	<h3><a href="${path}/insertStudent.do">학생정보등록</a></h3>
</body>
</html>