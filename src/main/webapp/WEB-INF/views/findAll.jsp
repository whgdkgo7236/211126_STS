<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	function detailAjax(m_number){
		console.log(m_number);
		$.ajax({
			type: 'post',
			url: 'detailAjax',
			data: {'m_number': m_number},
			dataType: 'json',
			success: function(result){
				console.log(result);
			},
			error: function(){
				console.log('오타찾으세요');
			}
				
			
		});
		
	}

</script>

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
			<th>상세조회(ajax)</th>
			<th>삭제</th>
			<th>수정</th>
			
		</tr>
		<c:forEach items="${member}" var="member">
		<tr>
			<td>${member.m_number}</td>
			<td>${member.m_id}</td>
			<td>${member.m_password}</td>
			<td>${member.m_name}</td>
			<td>${member.m_email}</td>
			<td>${member.m_number}</td>
			<!--  detail 이라는 주소요청을 통해 회원 상세조회를 해봅시다. 상세조회는 데이터는 detail.jsp에 출력합니다. -->
			<td><a href="detail?m_number=${member.m_number}">상세조회</a></td>
			<td><button onclick="detailAjax('${member.m_number}')">조회(ajax)</button></td>
			<!-- 삭제를 처리하고 다시 리스트를 출력함 (당연히 삭제데이터는 보이지 않아야함) -->
			<td><a href="Delete?m_number=${member.m_number}">삭제</a></td>
			<!-- 1.수정 화면 요청 
			\		수정화면을 요청하면 DB로부터 해당 회원의 정보를 가져와서 update.jsp 에 출력함 (form 태그사용)
				2. 수정 처리
					이메일, 전화번호만 수정할수 있음.
					update.jsp에 입력한 내용을 서버로 전당하여 수정을 처리하고 해당 회원의 detail 페이지를 출력할것-->
					
			<td><a href="Update?m_number=${member.m_number} ">수정</a></td>
			
		</tr>
		
		</c:forEach>
	</table>
</body>
</html>