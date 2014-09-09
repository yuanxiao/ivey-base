package com.ivey.web.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ivey.module.member.dto.UserDto;
import com.ivey.web.base.annotation.Login;
import com.ivey.web.base.annotation.Login.Authrity;
import com.ivey.web.controller.BaseController;
import com.ivey.web.member.business.handler.MemberLoginHandler;

@Controller
@RequestMapping(value = "/member")
public class LoginController extends BaseController {

	@Autowired
	private MemberLoginHandler memberLoginHandler;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(RedirectAttributes model, UserDto user, HttpServletRequest request, HttpServletResponse response) {
		boolean loginResult = memberLoginHandler.doLogin(user, request, response);
		if (!loginResult) {
			model.addFlashAttribute("loginError", "Login error ,please try again ");
		} else {

		}
		model.addFlashAttribute("userName", user.getUserName());
		return !loginResult ? "redirect:index" : "redirect:welcome";
	}

	@RequestMapping(value = "index")
	public String index(Model model) {
		model.addAttribute("name", "yuanxiao");
		return "index";
	}

	@Login(level = Authrity.MEMBER)
	@RequestMapping(value = "welcome")
	public String welcome(Model model) {
		return "welcome";
	}
}
