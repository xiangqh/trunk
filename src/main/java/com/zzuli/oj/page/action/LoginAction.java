package com.zzuli.oj.page.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zzuli.oj.common.Action;
import com.zzuli.oj.common.BaseResult;
import com.zzuli.oj.common.JsonResult;
import com.zzuli.oj.common.util.CookieUtil;
import com.zzuli.oj.common.util.JsonBinder;
import com.zzuli.oj.hibernate.entry.User;
import com.zzuli.oj.user.service.IUserService;

/**
 * @author xiangqh
 *
 */
@Controller
@ActionController
public class LoginAction extends QAction {

	@Autowired
	private IUserService userService;

	@RequestMapping(value="login")
	public Result login(){
		String user_id = getHttpParameter("user_id1");
		String password = getHttpParameter("password1");

		Map<String, Object> map = new HashMap<String, Object>();
		User user = userService.getUser(user_id, password);
		if(user == null) {
			return new BaseResult("/system/default/page/index.vm");
		}

		map.put("status", "200");
		CookieUtil.writeCookie(getHttpServletResponse(), "user_id", user.getUser_id());
		CookieUtil.writeCookie(getHttpServletResponse(), "nick", user.getNick());

		return new JsonResult(JsonBinder.buildNonNullBinder().toJson(map));
	}

	@Required
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
