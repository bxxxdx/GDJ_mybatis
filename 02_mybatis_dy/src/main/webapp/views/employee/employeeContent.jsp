<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보 출력하기</title>
</head>
<style>
	table#employeeTable th, td{
		border:1px solid black;
		border-collapse:collapse;
	}
</style>
<body>
	<h1>사원조회결과</h1>
	<form action="${pageContext.request.contextPath}/searchEmp.do">
		<table>
			<tr>
				<td>
					<select name="type">
						<option value="EMP_ID">사원번호</option>
						<option value="EMP_NAME">사원명</option>
						<option value="EMAIL">이메일</option>
						<option value="PHONE">전화번호</option>
					</select>
				</td>
				<td>
					<input type="text" name="keyword"/>
				</td>
			</tr>
			<tr>
				<td>
					성별조회
				</td>
				<td>
					<input type="radio" name="gender" value="M">남
					<input type="radio" name="gender" value="F">여
				</td>
			</tr>
			<tr>
				<td>
					급여
				</td>
				<td>
					<input type="number" name="salary" step="50000" min="1200000">
					<label><input type="radio" name="salFlag" value="ge">이상</label>
					<label><input type="radio" name="salFlag" value="le">이하</label>
				</td>
			</tr>
			<tr>
				<td>
					입사일
				</td>
				<td>
					<input type="date" name="hireDate">
					<label><input type="radio" name="hireFlag" value="ge">이상</label>
					<label><input type="radio" name="hireFlag" value="le">이하</label>
				</td>
			</tr>
			<tr>
				<td>
					직책조회
				</td>
				<td>
					<label><input type="checkbox" name="job" value="J1">대표</label>
					<label><input type="checkbox" name="job" value="J2">부사장</label>
					<label><input type="checkbox" name="job" value="J3">부장</label>
					<label><input type="checkbox" name="job" value="J4">차장</label>
					<label><input type="checkbox" name="job" value="J5">과장</label>
					<label><input type="checkbox" name="job" value="J6">대리</label>
					<label><input type="checkbox" name="job" value="J7">사원</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="조회">
				</td>
			</tr>
		</table>
	</form>
	<table id="employeeTable">
		<tr>
			<th>사원번호</th>
			<th>직원명</th>
			<th>주민등록번호</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서코드</th>
			<th>직급코드</th>
			<th>급여등급</th>
			<th>급여</th>
			<th>보너스율</th>
			<th>관리자사번</th>
			<th>입사일</th>
			<th>퇴사일</th>
			<th>재직여부</th>
			<th>성별</th>
		</tr>
		<c:choose>
			<c:when test="${empty employees}">
				<tr>
					<td colspan="14">조회된 사원이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="employee" items="${employees }">
					<tr>
						<td>${employee.empId}</td>
						<td>${employee.empName}</td>
						<td>${employee.empNo}</td>
						<td>${employee.email}</td>
						<td>${employee.phone}</td>
						<td>${employee.dept.deptId} ${employee.dept.deptTitle} ${employee.dept.locationId }</td>
						<td>${employee.jobCode}</td>
						<td>${employee.salLevel}</td>
						<td><fmt:formatNumber value="${employee.salary}" type="currency"/></td>
						<td><fmt:formatNumber value="${employee.bonus}" type="percent"/></td>
						<td>${employee.managerId}</td>
						<td><fmt:formatDate value="${employee.hireDate}" type="both" pattern="yyyy/MM/dd E HH:mm"/></td>
						<td><fmt:formatDate value="${employee.entDate}" type="both" pattern="yyyy/MM/dd E HH:mm"/></td>
						<td>${employee.entYn}</td>
						<td><c:out value="${employee.gender=='M'?'남':'여'}"/></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		
		<%-- <c:if test="${empty employees}">
			<tr>
				<td colspan="14">조회된 직원이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${not empty employees}">
			<c:forEach var="employee" items="${employees }">
				<tr>
					<td>${employee.empId}</td>
					<td>${employee.empName}</td>
					<td>${employee.empNo}</td>
					<td>${employee.email}</td>
					<td>${employee.phone}</td>
					<td>${employee.deptCode}</td>
					<td>${employee.jobCode}</td>
					<td>${employee.salLevel}</td>
					<td>${employee.salary}</td>
					<td>${employee.bonus}</td>
					<td>${employee.managerId}</td>
					<td>${employee.hireDate}</td>
					<td>${employee.entDate}</td>
					<td>${employee.entYn}</td>
				</tr>
			</c:forEach>
		</c:if>	 --%>
	</table>
	${pageBar}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>