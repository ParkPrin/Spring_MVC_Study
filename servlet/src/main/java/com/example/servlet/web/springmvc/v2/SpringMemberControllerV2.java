package com.example.servlet.web.springmvc.v2;

import com.example.servlet.domain.member.Member;
import com.example.servlet.domain.member.MemberReponsitory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

	private MemberReponsitory memberReponsitory = MemberReponsitory.getInstance();

	@RequestMapping("/new-form")
	public ModelAndView newForm() {
		return new ModelAndView("new-form");
	}

	@RequestMapping("/save")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = new Member(username, age);
		System.out.println("member = " + member);
		memberReponsitory.save(member);

		ModelAndView mav = new ModelAndView("save-result");
		mav.addObject("member", member);
		return mav;
	}

	@RequestMapping()
	public ModelAndView members() {
		List<Member> members = memberReponsitory.findAll();

		ModelAndView mav = new ModelAndView("members");
		mav.addObject("members", members);
		return mav;
	}

}
