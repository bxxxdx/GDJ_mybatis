<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.web.common.AESEncrypt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/views/common/header.jsp"/>
<section id="content">
	
	<h2 align="center" style="margin-top:200px;">안녕하세요, MVC입니다. ${loginMember}</h2>
	
	<table>
		<tr>
			<td>번호</td>
			<td>${board.no}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${board.title}</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${board.writer}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${board.content}</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><fmt:formatDate value="${board.date}" type="date" pattern="yyyy/MM/dd"/></td>
		</tr>
	
	</table>
	
	
</section>
<jsp:include page="/views/common/footer.jsp"/>
		
		
		
		
		
		
