package com.ivey.web.base.business.session;

import java.io.Serializable;

import com.ivey.web.base.business.annotation.Login;

public class MemberDetail implements Serializable{

	static final long		serialVersionUID	= -8823043172814917928L;

	private String			jsessionId;

	private Login.Authrity	level;

	private String			nick;

	public String getNick(){
		return nick;
	}

	public void setNick(String nick){
		this.nick = nick;
	}

	public Login.Authrity getLevel(){
		return level;
	}

	public void setLevel(Login.Authrity level){
		this.level = level;
	}

	public String getJsessionId(){
		return jsessionId;
	}

	public void setJsessionId(String jsessionId){
		this.jsessionId = jsessionId;
	}

}
