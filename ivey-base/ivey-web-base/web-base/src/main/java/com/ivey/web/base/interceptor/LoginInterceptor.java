package com.ivey.web.base.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.CookieGenerator;

import com.ivey.commons.utils.Validator.Validator;
import com.ivey.web.base.annotation.Login;
import com.ivey.web.base.constants.WebConstants;
import com.ivey.web.base.session.MemberDetail;

@Repository
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			Login login = method.getMethodAnnotation(Login.class);
			String fromUrl = request.getRequestURL().toString();
			if (login != null) {
				if (!validateLogin(request, response, login)) {
					response.sendRedirect("/member/index?fromUrl=" + fromUrl);
				}
			}
		}
		return true;
	}

	private boolean validateLogin(HttpServletRequest request, HttpServletResponse response, Login login)
			throws IOException {

		HttpSession session = request.getSession();
		Object obj = session.getAttribute(WebConstants.MEMBER_SESSION_KEY);
		if (Validator.isNotNullOrEmpty(obj)) {
			MemberDetail memberDetail = (MemberDetail) obj;
			Login.Authrity level = login.level();
			if (level.compareTo(memberDetail.getLevel()) > 0) {
				response.sendRedirect("/noPromission");
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Boolean loginResult = (Boolean) modelAndView.getModel().get("loginResult");
		if (loginResult != null && loginResult) {
			CookieGenerator generator = new CookieGenerator();
			generator.setCookiePath("/");
			generator.setCookieHttpOnly(true);
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
