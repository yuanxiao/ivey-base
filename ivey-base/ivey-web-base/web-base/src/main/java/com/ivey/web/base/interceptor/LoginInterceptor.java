package com.ivey.web.base.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.CookieGenerator;

import com.ivey.web.base.annotation.Login;
import com.ivey.web.base.annotation.Login.Authrity;

@Repository
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			Login login = method.getMethodAnnotation(Login.class);
			if (login != null) {
				Authrity authrity = login.level();
				System.err.println(authrity);
				response.sendRedirect("/member/index");
			}

		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Boolean loginResult = (Boolean) modelAndView.getModel().get("loginResult");
		if (loginResult != null && loginResult) {
			CookieGenerator generator = new CookieGenerator();
			generator.setCookiePath("/");
			generator.setCookieHttpOnly(false);
			generator.setCookieDomain("localhost");
			generator.setCookieName("uId");
			generator.addCookie(response, "yxka8");
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
