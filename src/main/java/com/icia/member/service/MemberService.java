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
	public MemberDTO findById(long m_number) {
		MemberDTO member =mr.findById(m_number);
		return member;
	}
	public void DeleteById(long m_number) {
		mr.DeleteById(m_number);
		
	}
	public MemberDTO UpdateFindId(long m_number) {
		return mr.UpdateFindId(m_number);
		
	}
	public void Update(MemberDTO member) {
		mr.Update(member);
		
	}
	public String idDuplicate(String m_id) {
		String result = mr.idDuplicate(m_id);
		System.out.println("service : "+result);
		if(result == null) {
			return "ok";// 조회결과가 없기 떄문에 ㅎ매당 아이디는 사용 가능
		}else {
			return "no";//조회 결과가 있기 때문에 해당 아이디는 사용불가능
		}
		
	}
}
