package com.ivey.web.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ivey.module.member.repo.Member;
import com.ivey.module.platform.repo.Region;

@Repository
public class LoginInterceptor implements HandlerInterceptor {

	public LoginInterceptor() {

		
		Member me = new Member();
		
		me.setAddress("abc");
		
		Region re = new Region();
		re.setName("cde");
		System.out.println("Constructor  called " + re.getName());
	}

 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		System.out.println("LoginInterceptor  preHandle");
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
