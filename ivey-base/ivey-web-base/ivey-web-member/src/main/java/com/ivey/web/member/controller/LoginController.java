package com.ivey.web.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ivey.module.member.dto.MemberDto;
import com.ivey.web.base.annotation.Login;
import com.ivey.web.base.annotation.Login.Authrity;
import com.ivey.web.controller.BaseController;

@Controller
@RequestMapping(value = "/member")
public class LoginController extends BaseController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, MemberDto member,HttpServletRequest request) {
		String userName = member.getUserName();
		String userPwd = member.getUserPwd();
		if (userName.equals("1") && userPwd.equals("1")) {
			HttpSession session = request.getSession();
			if(session==null  ||  session.isNew()) {
			}
			
			return "redirect:/member/welcome";
		} else {
			return "index";
		}
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
