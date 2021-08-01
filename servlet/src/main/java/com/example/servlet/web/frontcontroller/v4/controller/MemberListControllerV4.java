package com.example.servlet.web.frontcontroller.v4.controller;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberReponsitory;
import com.example.servlet.web.frontcontroller.v4.ControllerV4;
import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

	private MemberReponsitory memberReponsitory = MemberReponsitory.getInstance();

	@Override public String process(Map<String, String> paramMap, Map<String, Object> model) {
		List<Member> members = memberReponsitory.findAll();
		model.put("members", members);
		return "members";
	}
}
