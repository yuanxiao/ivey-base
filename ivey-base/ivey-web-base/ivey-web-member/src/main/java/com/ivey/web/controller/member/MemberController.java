package com.ivey.web.controller.member;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivey.commons.utils.Validator.Validator;
import com.ivey.module.member.dto.MemberDto;
import com.ivey.web.controller.BaseController;

@Controller
@RequestMapping(value = "/member")
@Component
public class MemberController extends BaseController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String login(Model model, MemberDto member) {
		if (Validator.isNullOrEmpty(member)) {
			return "0";
		} else {
			String userName = member.getUserName();
			String userPwd = member.getUserPwd();

			if (!Validator.isNullOrEmpty(userName) && !Validator.isNullOrEmpty(userPwd)) {
				if (userName.equals("yxka8") && userPwd.equals("magicer900827")) {
					return "1";
				} else {
					model.addAttribute("errorMessage", "User name or password is incorrect");
					return "0";
				}
			}
			return "0";
		}

	}

	@RequestMapping(value = "index")
	public String index(Model model) {
		return "index";
	}
}
