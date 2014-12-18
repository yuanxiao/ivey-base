package com.ivey.member.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivey.base.service.impl.BaseServiceImpl;
import com.ivey.member.dao.MemberDao;
import com.ivey.member.entity.dto.MemberDto;
import com.ivey.member.entity.dto.UserDto;
import com.ivey.member.service.MemberService;

@Service
public class MemberServiceImpl extends BaseServiceImpl  implements MemberService{

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
