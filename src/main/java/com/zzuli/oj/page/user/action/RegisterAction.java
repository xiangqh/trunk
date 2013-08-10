package com.zzuli.oj.page.user.action;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zzuli.oj.common.Action;
import com.zzuli.oj.hibernate.entry.User;
import com.zzuli.oj.user.service.IUserService;

@Controller("registerAction")
public class RegisterAction extends Action{

	@Autowired
	private IUserService userService;

	public String show() {
		return "success";
	}

	public String register(User user) {
		
		return "success";
	}
	
	public User convert_Register(){
		User user=new User();
		user.setEmail(getHttpParameter("email"));
		user.setNick(getHttpParameter("nick"));
		user.setPassword(getHttpParameter("password"));
		user.setSchool(getHttpParameter("school"));
		user.setReg_time(new Date());
		return user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
