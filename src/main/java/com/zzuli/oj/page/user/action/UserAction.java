package com.zzuli.oj.page.user.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zzuli.oj.common.BaseResult;
import com.zzuli.oj.common.JsonResult;
import com.zzuli.oj.common.util.CookieUtil;
import com.zzuli.oj.common.util.JsonBinder;
import com.zzuli.oj.common.util.ValueCheck;
import com.zzuli.oj.hibernate.entry.User;
import com.zzuli.oj.user.service.IUserService;

/**
 * @author xiangqh
 *
 */
@Controller
@ActionController
public class UserAction extends QAction {


	@Autowired
	private IUserService userService;

	@RequestMapping("modifyuserpage")
	public Result modifyUserPage(){

		String user_id = CookieUtil.getUserId(getHttpServletRequest());
		if(StringUtils.isEmpty(user_id)) {
			return new BaseResult("/system/default/page/login.vm");
		}
		User user = userService.getUserById(user_id);
		user.setPassword("");
		setHttpAttribute("user", user);
		return new BaseResult("/system/default/page/register.vm");
	}

	@RequestMapping("modifyUser")
	public Result modifyUser(){
		String user_id = getHttpParameter("user_id");
		String nick = getHttpParameter("nick");
		String password = getHttpParameter("password");
		String rptPassword = getHttpParameter("rptPassword");
		String school = getHttpParameter("school");
		String email = getHttpParameter("email");

		List<String> errors = new ArrayList<String>();
		if ((school == null) || (school.trim().equals("")))
			school = "";
		if (!ValueCheck.checkId(user_id, errors))
			return new BaseResult("error.vm");
		if ((user_id.toUpperCase()).startsWith("TEAM"))
		{
			errors.add("You cann't register this ID!");
			return new BaseResult("error.vm");
		}
		if (!ValueCheck.checkPassword(password, errors))
			return new BaseResult("error.vm");;
		if (!password.equals(rptPassword))
		{
			errors.add("Passwords are not match");
			return new BaseResult("error.vm");
		}
		if ((nick == null) || (nick.trim().equals("")))
			nick = user_id;
		if (!ValueCheck.checkNick(nick, errors))
			return new BaseResult("error.vm");
		if (nick.length() > 100)
			nick = nick.substring(0, 98);

		User user = userService.getUserById(user_id);

		Map<String, Object> map = new HashMap<String, Object>();
		user = new User();
		user.setUser_id(user_id);
		user.setPassword(password);
		user.setNick(nick);
		user.setEmail(email);
		user.setSchool(school);
		user.setDefunct('N');
		user.setIp("");
		try {
			userService.updateUser(user);
			map.put("status", "200");
		} catch (Exception e) {
			errors.add("update user error");
		}
		return new JsonResult(JsonBinder.buildNonNullBinder().toJson(map));
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}



}
