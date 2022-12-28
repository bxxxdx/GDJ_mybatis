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
	
	<h2>학생정보를 수정하는 기능 구현하기</h2>
	<form action="${path}/updateStudent.do" method="post">
		<input type="text" name="studentNo" placeholder="수정할 학생번호"><br>
		<input type="text" name="phone" placeholder="전화번호"><br>
		<input type="email" name="email" placeholder="이메일"><br>
		<input type="text" name="address" placeholder="주소"><br>
		<input type="submit" value="학생수정하기">	
	</form>
	
	<h2>학생정보를 삭제하는 기능 구현하기(자습용)</h2>
	
	<h2>DB에 있는 데이터 조회하는 기능 구현하기</h2>
	<p>
		select문을 실행한 결과를 java에서 사용하는 vo객체에 저장<br>
		조회한 결과를 vo에 저장하는 것을 mybatis가 mapping정보를 이용해서 자동으로 대입해준다.
	</p>
	<h3>학생수 조회하기</h3>
	<h4><a href="${path}/student/studentCount.do">학생수 조회하기</a></h4>
	
	<h4><a href="${path}/student/selectStudent.do?no=1">1번학생 조회하기</a></h4>
	
	<h4><a href="${path}/student/selectStudentAll.do">전체 학생 조회하기</a></h4>
	
	
	
	
	
	
	
	
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>