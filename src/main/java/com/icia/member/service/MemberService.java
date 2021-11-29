package com.icia.member.service;

import java.util.List;

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
	public String login(MemberDTO memdto) {
		MemberDTO result = mr.login(memdto);
		System.out.println(result);
		if(result !=null) {
			// 로그인 성공(로그인 정보(아이디)를 세션에 저장)
			session.setAttribute("loginId", memdto.getM_id());
			session.setAttribute("loginNumber", result.getM_number());
			return "main";
		}else {
			//로그인 실패
			return "login";
		}
		
	}
	///////////////////////로그인끝
	public List<MemberDTO> findAll() {
		List<MemberDTO> member =  mr.findAll();
		System.out.println(member);
		return member;
	}
}
