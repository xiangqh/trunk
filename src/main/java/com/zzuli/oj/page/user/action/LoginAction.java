package com.zzuli.oj.page.user.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.zzuli.oj.user.service.IUserService;

public class LoginAction {

	@Autowired
	private IUserService userService;

	public String login() {
		return "success";
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
