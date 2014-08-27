package com.ivey.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ivey.commons.utils.Validator.Validator;
import com.ivey.module.member.dto.MemberDto;
import com.ivey.web.controller.BaseController;



@Controller
@RequestMapping(value="/member")
public class MemberController extends BaseController {

	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(Model model,MemberDto member){
		
		
		System.err.println(member);
		if (Validator.isNullOrEmpty(member)){
			return "index";
		}
		return "index";
	}
}
