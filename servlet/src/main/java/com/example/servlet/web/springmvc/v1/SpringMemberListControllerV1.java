package com.example.servlet.web.springmvc.v1;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberReponsitory;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberListControllerV1 {

	private MemberReponsitory memberReponsitory = MemberReponsitory.getInstance();

	@RequestMapping("/springmvc/v1/members")
	public ModelAndView process() {
		List<Member> members = memberReponsitory.findAll();

		ModelAndView mv = new ModelAndView("members");
		mv.addObject("members", members);
		return mv;
	}

}
