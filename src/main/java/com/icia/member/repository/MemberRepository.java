package com.icia.member.repository;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.MemberDTO;

@Repository
public class MemberRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public int insert(MemberDTO member) {
		
		return sql.insert("Member.insertMember", member);
	}

}
