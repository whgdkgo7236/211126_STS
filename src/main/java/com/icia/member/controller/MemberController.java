package com.icia.member.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icia.member.dto.MemberDTO;
import com.icia.member.service.MemberService;



@Controller
public class MemberController {
	//회원가입 페이지출력
	
	@Autowired
	private MemberService ms;
	///////////////////////////////회원가입
	@RequestMapping(value ="/insert", method = RequestMethod.GET)
	public String insert() {
		
		
		return "insert";
	}
	
	@RequestMapping(value = "/insert_member", method=RequestMethod.POST)
	public String insert_member(@ModelAttribute MemberDTO memdto) {
		//model.addAttribute("memdto",model);
		
		int result = ms.insert(memdto);
		System.out.println(memdto);
		return "index";
	}
	///////////////////////////////회원가입 끝
	////////////////////////로그인 하기
	@RequestMapping(value="/login")
	public String loginpage() {
		return "login";
	}
	@RequestMapping(value="/logincheck",method=RequestMethod.POST)
	public String login(@ModelAttribute MemberDTO memdto) {
		//public String login(@RequestParam("m_id") String m_id, @RequestParam("m_password" String m_password))
		String result= ms.login(memdto);
		
		return result;
	}
	////////////////////////////로그인마무리
	////////////////////////////로그아웃
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		//세션 데이터를 지움
		session.invalidate();
		
		return "index";
	}
	//////////////////////////////로그아웃끝
	////////////////////////////회원목록가져오기 
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public String findall(Model model) {
		
		List<MemberDTO> member = ms.findAll();
		model.addAttribute("member", member);
		return "index";
	}
	//////////////////////////////회원목록가져오기
}
