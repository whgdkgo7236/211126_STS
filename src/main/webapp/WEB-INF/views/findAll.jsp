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
	<h2>findAll</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>상세조회</th>
			<th>삭제</th>
			<th>수정</th>
			
		</tr>
		<c:forEach items="${member}" var="member">
		<tr>
			<th>${member.m_number}</th>
			<th>${member.m_id}</th>
			<th>${member.m_password}</th>
			<th>${member.m_name}</th>
			<th>${member.m_email}</th>
			<th>${member.m_number}</th>
			<!--  detail 이라는 주소요청을 통해 회원 상세조회를 해봅시다. 상세조회는 데이터는 detail.jsp에 출력합니다. -->
			<th><a href="detail?m_number=${member.m_number}">상세조회</a></th>
			<th><a href=""></a>삭제</th>
			<th>수정</th>
			
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>