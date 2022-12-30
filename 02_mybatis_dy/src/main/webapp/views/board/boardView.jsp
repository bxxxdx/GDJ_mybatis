<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board 출력</title>
</head>
<body>
	<h2>게시물 정보</h2>
	<table>
		<tr>
			<td>게시글번호</td>
			<td>${board.boardNo}</td>
		</tr>
		<tr>
			<td>게시글제목</td>
			<td>${board.boardTitle}</td>
		</tr>
		<tr>
			<td>게시글작성자 아이디</td>
			<td>${board.boardWriter}</td>
		</tr>
		<tr>
			<td>게시글내용</td>
			<td>${board.boardContent}</td>
		</tr>
		<tr>
			<td>첨부파일원래이름</td>
			<td>${board.boardOriginalFilename}</td>
		</tr>
		<tr>
			<td>첨부파일변경이름</td>
			<td>${board.boardRenamedFilename}</td>
		</tr>
		<tr>
			<td>게시글올린날짜</td>
			<td>${board.boardDate}</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${board.boardReadcount}</td>
		</tr>
	</table>
	
	<h3>댓글</h3>
	<table>
		<c:if test="${not empty board.boardComments}">
			<c:forEach var="bc" items="${board.boardComments}" varStatus="vs">
				<tr>
					<td>${vs.count}</td>
					<td>작성자 : ${bc.boardCommentWriter}</td>
					<td>내용 : ${bc.boardCommentContent }</td>
					<td>작성일 : ${bc.boardCommentDate }</td>
				</tr>
			</c:forEach>
		</c:if> 
	</table>
</body>
</html>