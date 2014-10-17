package com.ivey.web.member.business.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ivey.commons.utils.Validator.Validator;
import com.ivey.module.member.dto.UserDto;
import com.ivey.service.member.UserService;
import com.ivey.service.platform.RegionService;
import com.ivey.web.base.annotation.Login.Authrity;
import com.ivey.web.base.session.MemberDetail;

@Component
public class MemberLoginHandler {

	@Autowired
	private UserService userService;

	@Autowired
	private RegionService regionService;

	public MemberDetail doLogin(UserDto user, HttpServletRequest request,
			HttpServletResponse response) {

		UserDto appUser = userService.getUser(user);
		MemberDetail memberDetail = null;
		if (Validator.isNotNullOrEmpty(appUser)) {
			memberDetail = convertMemberDetail(appUser);
		}
		return memberDetail;
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
