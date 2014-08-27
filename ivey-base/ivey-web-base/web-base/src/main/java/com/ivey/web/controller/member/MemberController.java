package com.ivey.web.controller.member;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ivey.commons.utils.Validator.Validator;
import com.ivey.module.member.dto.MemberDto;
import com.ivey.web.controller.BaseController;



@RequestMapping(value="/member")
public class MemberController extends BaseController {

	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(Model model,MemberDto member){
		if (Validator.isNullOrEmpty(member)){
				
		}
		return "";
	}
}
