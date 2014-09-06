package com.ivey.web.base.service.member.impl;

import org.springframework.stereotype.Service;

import com.ivey.web.base.service.impl.BaseServiceImpl;
import com.ivey.web.base.service.member.LoginService;

@Service
public class CommonLoginServiceImpl extends BaseServiceImpl implements LoginService {

	@Override
	public boolean login() {
		return false;
	}

}
