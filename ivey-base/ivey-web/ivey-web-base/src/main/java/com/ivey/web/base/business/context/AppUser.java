package com.ivey.web.base.business.context;

import com.ivey.member.entity.dto.UserDto;

public class AppUser {

	private static UserDto userDto;

	private static String uid;

	public static String getUid() {
		return uid;
	}

	public static void setUid(String uid) {
		AppUser.uid = uid;
	}

	public static UserDto getUserDto() {
		return userDto;
	}

	public static void setUserDto(UserDto user) {
		AppUser.userDto = user;
	}
}
