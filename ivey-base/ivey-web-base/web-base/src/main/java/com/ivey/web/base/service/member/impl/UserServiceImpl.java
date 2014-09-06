package com.ivey.web.base.service.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivey.module.member.dao.UserDao;
import com.ivey.module.member.dto.UserDto;
import com.ivey.web.base.service.impl.BaseServiceImpl;
import com.ivey.web.base.service.member.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDto getUser(UserDto user) {
			return userDao.getUser(user);
	}

}
