<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input{
		display: block;
	}
</style>
</head>
<body>
	<form action="logincheck" method="POST">
		아이디 : <input type="text" name="m_id">
		비밀번호 : <input type="text" name="m_password">
		<input type="submit" value="로그인">
	</form>
</body>
</html>