package com.zzuli.oj.page.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zzuli.oj.common.Action;
import com.zzuli.oj.common.BaseResult;
import com.zzuli.oj.common.JsonResult;
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
public class RegisterAction extends Action {

	private static final long serialVersionUID = 546587403893046492L;

	@Autowired
	private IUserService userService;

	@RequestMapping("registerpage")
	public Result show() {
		return new BaseResult("/system/default/page/register.vm");
	}

	@RequestMapping("register")
	public Result register() {
		String user_id = getHttpParameter("user_id");
		String nick = getHttpParameter("nick");
		String password = getHttpParameter("password");
		String rptPassword = getHttpParameter("rptPassword");
		String school = getHttpParameter("school");
		String email = getHttpParameter("email");

		Timestamp localTimestamp = new Timestamp(System.currentTimeMillis());

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
		if(user != null) {
			errors.add("The ID( " + user_id + ") existed");
			return new BaseResult("error.vm");
		}
		user = new User();
		user.setUser_id(user_id);
		user.setPassword(password);
		user.setNick(nick);
		user.setEmail(email);
		user.setSchool(school);
		user.setReg_time(localTimestamp);
		user.setDefunct('N');
		user.setIp("");

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userService.addUser(user);
			map.put("status", "200");
		} catch (Exception e) {
			map.put("status", "400");
		}
		return new JsonResult(JsonBinder.buildNonNullBinder().toJson(map));
	}

	@Required
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}



}
