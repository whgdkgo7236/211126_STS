package com.icia.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.member.dto.MemberDTO;
import com.icia.member.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository mr;
	
	public int insert(MemberDTO member) {
		
		int result = mr.insert(member);
		return result;
	}
}
