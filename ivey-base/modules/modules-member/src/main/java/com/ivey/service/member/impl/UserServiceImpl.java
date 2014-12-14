package com.ivey.service.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivey.module.member.dao.UserDao;
import com.ivey.module.member.dto.UserDto;
import com.ivey.service.member.UserService;

@Service
public class UserServiceImpl  implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserDto getUser(UserDto user) {
			return userDao.getUser(user);
	}

}   
