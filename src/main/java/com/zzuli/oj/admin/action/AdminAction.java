package com.zzuli.oj.admin.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zzuli.oj.common.Action;
import com.zzuli.oj.hibernate.entry.Privilege;
import com.zzuli.oj.hibernate.entry.User;
import com.zzuli.oj.user.service.IUserService;

@Controller
public class AdminAction extends Action {

	@Autowired
	private IUserService userService;

	public String show() {
		return SUCCESS;
	}

	public String login() {

		String admin_id = getHttpParameter("admin_id");
		String password = getHttpParameter("password");
		
		/*User user = userService.getUser(admin_id, password);
		if(user == null) {
		//	return ERROR;
		}*/
		
		/*Privilege privilege = userService.getUserPrivilege(admin_id);
		if(privilege == null) {
		//	return ERROR;
		}*/
		
		
		return SUCCESS;
	}

}
