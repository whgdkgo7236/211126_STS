package com.icia.member.controller;

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
	
	
	@RequestMapping(value="/login")
	public String loginpage() {
		return "login";
	}
}
