package com.ivey.web.member.business.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivey.commons.utils.Validator.Validator;
import com.ivey.module.member.dto.UserDto;
import com.ivey.web.base.annotation.Login.Authrity;
import com.ivey.web.base.constants.WebConstants;
import com.ivey.web.base.service.member.UserService;
import com.ivey.web.base.service.platform.RegionService;
import com.ivey.web.base.session.MemberDetail;

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
			HttpSession session = request.getSession();
			MemberDetail memberDetail = convertMemberDetail(appUser);
			session.setAttribute(WebConstants.MEMBER_SESSION_KEY, memberDetail);
		}
		return loginResult;
	}

	private MemberDetail convertMemberDetail(UserDto userDto) {

		MemberDetail memberDetail = new MemberDetail();
		Integer userType = Integer.valueOf(userDto.getUserType());
		switch (userType) {
		case 1:
			memberDetail.setLevel(Authrity.MEMBER);
			break;
		case 2:
			memberDetail.setLevel(Authrity.SELLER);
			break;
		case 3:
			memberDetail.setLevel(Authrity.OPERATIOR);
			break;
		default:
			break;
		}
		return memberDetail;
	}

}
