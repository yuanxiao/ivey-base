package com.ivey.service.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivey.module.member.dao.MemberDao;
import com.ivey.module.member.dto.MemberDto;
import com.ivey.module.member.dto.UserDto;
import com.ivey.service.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDao	memberDao;

	public UserDto getLoginMember(UserDto user){
		return memberDao.getLoginMember(user);
	}

	public MemberDto getMemberInfo(String nick){
		return memberDao.getMemberInfo(nick);
	}

	public MemberDto getMemberInfo(Long memberId){
		return memberDao.getMemberInfo(memberId);
	}

}
