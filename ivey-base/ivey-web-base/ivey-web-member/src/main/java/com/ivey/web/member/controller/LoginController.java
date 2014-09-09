package com.ivey.web.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ivey.commons.utils.Validator.Validator;
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
	public String login(@RequestParam(value = "fromUrl", required = false) String fromUrl, RedirectAttributes model,
			UserDto user, HttpServletRequest request, HttpServletResponse response) {
		boolean loginResult = memberLoginHandler.doLogin(user, request, response);
		if (!loginResult) {
			model.addFlashAttribute("loginError", "Login error ,please try again ");
		} else {
			model.addFlashAttribute("loginResult", Boolean.TRUE);
			model.addFlashAttribute("userName", user.getUserName());
			if(Validator.isNullOrEmpty(fromUrl)) {
					fromUrl = "/member/member";
			}
		}
		return !loginResult ? "redirect:index" : "redirect:" + fromUrl;
	}

	@RequestMapping(value = "index")
	public String index(@RequestParam(value = "fromUrl", required = false) String fromUrl, Model model) {
		if (Validator.isNotNullOrEmpty(fromUrl)) {
			model.addAttribute("fromUrl", fromUrl);
		}
		return "index";
	}

	@Login(level = Authrity.MEMBER)
	@RequestMapping(value = "member")
	public String welcome(Model model) {
		return "welcome";
	}

	@Login(level = Authrity.SELLER)
	@RequestMapping(value = "seller")
	public String seller(Model model) {
		return "welcome";
	}

	@Login(level = Authrity.OPERATIOR)
	@RequestMapping(value = "admin")
	public String admin(Model model) {
		return "welcome";
	}
}
