package com.ivey.web.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ivey.module.base.dao.MemberBaseDao;
import com.ivey.module.base.dao.PlatformBaseDao;

@Repository
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	ApplicationContext context;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		MemberBaseDao dao = (MemberBaseDao) context.getBean("memberBaseDao");
		dao.save();
		PlatformBaseDao pdao = (PlatformBaseDao) context.getBean("platformBaseDao");
		pdao.save();

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
