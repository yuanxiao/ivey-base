package com.ivey.web.member.business.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivey.web.base.service.member.LoginService;
import com.ivey.web.base.service.platform.RegionService;

@Component
public class MemberLoginHandler {

	@Autowired
	private LoginService loginService;

	@Autowired
	private RegionService regionService;

}
