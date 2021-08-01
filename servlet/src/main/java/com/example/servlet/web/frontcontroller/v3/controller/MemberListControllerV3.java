package com.example.servlet.web.frontcontroller.v3.controller;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberReponsitory;
import com.example.servlet.web.frontcontroller.ModelView;
import com.example.servlet.web.frontcontroller.v3.ControllerV3;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

	private MemberReponsitory memberReponsitory = MemberReponsitory.getInstance();

	@Override public ModelView process(Map<String, String> paramMap) {
		List<Member> members = memberReponsitory.findAll();

		ModelView mv = new ModelView("members");
		mv.getModel().put("members", members);

		return mv;
	}
}
