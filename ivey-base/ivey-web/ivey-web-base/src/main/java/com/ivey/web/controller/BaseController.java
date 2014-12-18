package com.ivey.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.ivey.module.platform.dto.HeaderMenuDto;
import com.ivey.web.base.constants.WebConstants;
import com.ivey.web.base.handler.HeaderMenuHandler;
import com.ivey.web.base.session.MemberDetail;

public class BaseController{

	@Autowired
	private HeaderMenuHandler	headerMenuHandler;

	@RequestMapping("noPromission")
	public void noPromission(Model model,HttpServletResponse response) throws IOException{
		model.addAttribute("loginResult", Boolean.FALSE);
		PrintWriter out = response.getWriter();
		out.write("Sorry  , you have no promision to visit this page ");
		out.flush();
		out.close();
		response.flushBuffer();
	}

	@RequestMapping("error")
	public String error(Model model) throws IOException{
		model.addAttribute("errorMsg", "System is busy , please contact to administrators ");
		return "error/error";
	}

	protected MemberDetail getMemberDetail(){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Object obj = WebUtils.getSessionAttribute(request, WebConstants.MEMBER_SESSION_KEY);
		System.err.println(request.getSession().getId());
		return obj == null ? null : (MemberDetail) obj;
	}

	public List<HeaderMenuDto> getHeaderMenus(){
		return headerMenuHandler.findAll();
	}

	protected void setMemberDetail(MemberDetail memberDetail){
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		request.getSession(true).setAttribute(WebConstants.MEMBER_SESSION_KEY, memberDetail);
	}
}
