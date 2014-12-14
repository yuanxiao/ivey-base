package com.ivey.web.mainsite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ivey.web.base.session.MemberDetail;
import com.ivey.web.controller.BaseController;

@Controller
@RequestMapping("/main")
public class MainsiteBaseController extends BaseController {

	@RequestMapping("/index")
	public String mainSite(Model model,HttpSession session) {

		MemberDetail memberDetail = super.getMemberDetail();
		
		if(memberDetail==null) {
			memberDetail = (MemberDetail)defaultCache.getCache("defaultCache").get("memberDetail").get();
		}
		System.err.println(memberDetail);
		return "index";
	}
}
