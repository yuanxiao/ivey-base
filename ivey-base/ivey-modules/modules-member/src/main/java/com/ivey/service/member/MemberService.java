package com.ivey.service.member;

import com.ivey.module.member.dto.MemberDto;
import com.ivey.module.member.dto.UserDto;

public interface MemberService{

	/**
	 * 根據前段傳遞過來的用戶信息，去查詢ＤＢ中的Ｕｓｅｒ
	 * 
	 * @param user
	 * @return
	 */
	public UserDto getLoginMember(UserDto user);

	/**
	 * 用戶昵稱查詢
	 * 
	 * @param nick
	 * @return
	 */
	public MemberDto getMemberInfo(String nick);

	/**
	 * 用戶ID查詢
	 * 
	 * @param memberId
	 * @return
	 */
	public MemberDto getMemberInfo(Long memberId);
}
