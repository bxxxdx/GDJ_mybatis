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
	<h2>학생 이름만 입력받아 저장하기</h2>
	<form action="${path}/insertStudentName.do">
		<input type="text" name="name">
		<input type="submit" value="저장">
	</form>
	
	<h2>학생정보를 입력받아 추가하는 기능</h2>
	<form action="${path}/insertStudentInput.do" method="post">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="phone" placeholder="전화번호"><br>
		<input type="email" name="email" placeholder="이메일"><br>
		<input type="text" name="address" placeholder="주소"><br>
		<input type="submit" value="제출">
	</form>
	
</body>
</html>