package com.ivey.web.mainsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ivey.web.base.session.MemberDetail;
import com.ivey.web.controller.BaseController;

@Controller
@RequestMapping("/mainsite")
public class MainsiteBaseController extends BaseController {

	@RequestMapping("/index")
	public String mainSite(Model model) {

		MemberDetail memberDetail = super.getMemberDetail();
		System.err.println(memberDetail);
		return "index";
	}
}
