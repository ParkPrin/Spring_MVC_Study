package com.example.servlet.web.springmvc.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// bean 이름으로 handler mapping이 이루어진다.
@Component("/springmvc/old-controller")
public class OldController implements Controller {

	@Override public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OldController.hadlerReqeust");
		return new ModelAndView("new-form");
	}
}
