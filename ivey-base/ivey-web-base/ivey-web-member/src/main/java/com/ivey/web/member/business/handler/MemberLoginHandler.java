package com.ivey.web.member.business.handler;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivey.commons.utils.Validator.Validator;
import com.ivey.module.member.dto.UserDto;
import com.ivey.web.base.app.context.AppUser;
import com.ivey.web.base.service.member.UserService;
import com.ivey.web.base.service.platform.RegionService;

@Component
public class MemberLoginHandler {

	@Autowired
	private UserService userService;

	@Autowired
	private RegionService regionService;

	public boolean doLogin(UserDto user, HttpServletRequest request, HttpServletResponse response) {

		UserDto appUser = userService.getUser(user);
		boolean loginResult = false;
		if (Validator.isNotNullOrEmpty(appUser)) {
			loginResult = true;
			AppUser.setUserDto(appUser);
			String uid = UUID.randomUUID().toString().replaceAll("-", "");
			AppUser.setUid(uid);
			HttpSession session = request.getSession();
			session.setAttribute("uid", uid);
		}
		return loginResult;
	}

}
