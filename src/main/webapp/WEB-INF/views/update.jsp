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
<script>
/*
 * 비밀번호 입력창에서 비밃전홓를 입력받고 DB에서 가져온 비밀번호와 비교해서 일치하면 update처리
   일치하지 않으면 비밀번호가 일치하지 않습니다. alert 출력 
 */
	function update(){
		//확인하려면 consolo.log(); 를써야함리니지
		/*   이렇게하면안됨
		if(update_from.m_nuber == ${member.m_password}){
			update_form.submit();
		}
		else{
			
		}*/
		
		const pw = document.getElementById("m_password").value;
		console.log(pw);
		const pwDB= "${member.m_password}"
			console.log(pwDB);
		if(pw==pwDB){
			update_form.submit();	
		}
		else{
			alert("비밀번호가 틀립니다.");
		}
	}

</script>

</head>

<body>
	<form action="member_update" method="POST" name="update_form">
		아이디 : <input type="text" name="m_number" value=${member.m_id} readonly>
		비밀번호 : <input type="text" name="m_number" id="m_password">
		이름 : <input type="text" name="m_number" value=${member.m_name} readonly>
		이메일 : <input type="text" name="m_number" value=${member.m_email}>
		전화번호 : <input type="text" name="m_number" value=${member.m_phone}>
		<input type="button" value="회원가입" Onclick="update()">
	</form>
</body>
</html>