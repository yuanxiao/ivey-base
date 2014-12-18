package com.ivey.web.base.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.CookieGenerator;

import com.ivey.web.base.annotation.Login;
import com.ivey.web.base.constants.WebConstants;
import com.ivey.web.base.session.MemberDetail;

@Repository
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		if (handler instanceof HandlerMethod){
			System.err.println("_____________________________________________________");
			HandlerMethod method = (HandlerMethod) handler;
			Login login = method.getMethodAnnotation(Login.class);
			if (login != null){
				return validateLogin(request, response, login);
			}
		}
		return true;
	}

	private boolean validateLogin(HttpServletRequest request,HttpServletResponse response,Login login) throws IOException,ServletException{
		HttpSession session = request.getSession();
		Object obj = session.getAttribute(WebConstants.MEMBER_SESSION_KEY);
		if (obj!=null){
			MemberDetail memberDetail = (MemberDetail) obj;
			Login.Authrity level = login.level();
			if (level.compareTo(memberDetail.getLevel()) > 0){
				request.getRequestDispatcher("/noPromission").forward(request, response);
				return false;
			}
			return true;
		}else{
			String fromUrl = request.getRequestURL().toString();
			if (StringUtils.isNotEmpty(fromUrl)){
				response.sendRedirect("http://localhost:8082/member/index?fromUrl=" + fromUrl);
			}else{
				response.sendRedirect("http://localhost:8082/member/index");
			}
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView)
			throws Exception{
		if (modelAndView != null){
			Boolean loginResult = (Boolean) modelAndView.getModel().get("loginResult");
			if (loginResult != null && loginResult){
				String userName = modelAndView.getModel().get("userName").toString();
				CookieGenerator generator = new CookieGenerator();
				generator.setCookieDomain(".ivey.com");
				generator.setCookiePath("/");
				generator.setCookieMaxAge(30 * 60 * 1000);
				generator.setCookieName("logged_in");
				generator.addCookie(response, loginResult.toString());

				generator.setCookieDomain(".ivey.com");
				generator.setCookiePath("/");
				generator.setCookieMaxAge(30 * 60 * 1000);
				generator.setCookieName("dotcom_user");
				generator.addCookie(response, userName);
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex) throws Exception{

	}

}
