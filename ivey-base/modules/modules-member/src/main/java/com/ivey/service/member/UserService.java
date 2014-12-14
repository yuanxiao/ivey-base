package com.ivey.service.member;

import com.ivey.module.member.dto.UserDto;


public interface UserService {

	
	/**
	 * 根據前段傳遞過來的用戶信息，去查詢ＤＢ中的Ｕｓｅｒ
	 * @param user
	 * @return
	 */
	public UserDto getUser(UserDto user);
}
