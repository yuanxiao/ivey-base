package com.ivey.web.member.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ivey.module.member.dao.MemberInfoDao;
import com.ivey.module.member.repo.Member;

@Repository
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	ApplicationContext context;

	@Autowired
	private MemberInfoDao memberInfoDao;

	 

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		 List<Member> memberList = memberInfoDao.query(); 
		
		System.err.println(memberList);
		
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("LoginInterceptor  postHandle");
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("LoginInterceptor  afterCompletion");
	}

	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("LoginInterceptor  afterConcurrentHandlingStarted");
	}

}
