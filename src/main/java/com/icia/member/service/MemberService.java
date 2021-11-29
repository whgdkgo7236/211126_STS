package com.icia.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository mr;
	
	@Autowired
	private HttpSession session;
	
	/////////////////////회원가입
	public int insert(MemberDTO member) {
		
		int result = mr.insert(member);
		return result;
	}
	//////////////////////회원가입끝
	//////////////////////로그인
	public void login(MemberDTO memdto) {
		String result = mr.login(memdto);
		System.out.println(result);
		if(result !=null) {
			// 로그인 성공(로그인 정보(아이디)를 세션에 저장)
			session.setAttribute("loginId", memdto.getM_id());
		}else {
			//로그인 실패
			
		}
		
	}
	///////////////////////로그인끝
}
