package com.ivey.web.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ivey.commons.utils.Validator.Validator;
import com.ivey.module.member.dto.UserDto;
import com.ivey.web.base.annotation.Login;
import com.ivey.web.base.annotation.Login.Authrity;
import com.ivey.web.base.handler.LoginHandler;
import com.ivey.web.base.session.MemberDetail;
import com.ivey.web.controller.BaseController;
import com.ivey.web.member.utils.LoginHandlerFactory;

@Controller
@RequestMapping(value = "/member")
public class LoginController extends BaseController{

	@Autowired
	private LoginHandlerFactory	loginHandlerFactory;

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(
			@RequestParam(value = "fromUrl",required = false) String fromUrl,
			@RequestParam(value = "loginType",required = false,defaultValue = "normalLogin") String loginType,
			Model model,
			UserDto user){
		LoginHandler loginHandler = loginHandlerFactory.getLoginHandler(loginType);
		System.err.println(loginHandler);
		MemberDetail memberDetail = loginHandler.doLogin(user);
		boolean loginResult = false;
		if (memberDetail == null){
			model.addAttribute("loginError", "Login error ,please try again ");
		}else{
			super.setMemberDetail(memberDetail);
		}
		return !loginResult ? "redirect:index" : "redirect:" + fromUrl;
	}

	@RequestMapping(value = "index")
	public String index(@RequestParam(value = "fromUrl",required = false) String fromUrl,Model model){
		if (Validator.isNotNullOrEmpty(fromUrl)){
			model.addAttribute("fromUrl", fromUrl);
		}
		return "index";
	}

	@Login(level = Authrity.MEMBER)
	@RequestMapping(value = "member")
	public String welcome(Model model){
		MemberDetail memberDetail = super.getMemberDetail();
		System.err.println(memberDetail);
		return "welcome";
	}

	@Login(level = Authrity.SELLER)
	@RequestMapping(value = "seller")
	public String seller(Model model){
		return "welcome";
	}

	@Login(level = Authrity.OPERATIOR)
	@RequestMapping(value = "admin")
	public String admin(Model model){
		return "welcome";
	}
}
