package com.zzuli.oj.page.action;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;

import com.opensymphony.xwork2.Result;
import com.zzuli.oj.common.BaseResult;
import com.zzuli.oj.common.util.CookieUtil;

/**
 * @author xiangqh
 *
 */
@Controller
@ActionController
public class LogoutAction extends QAction {


	@RequestMapping(value="logout")
	public Result logout(){

		CookieUtil.delCookie(getHttpServletResponse(), "user_id");
		CookieUtil.delCookie(getHttpServletResponse(), "nick");
		try {
			getHttpServletResponse().sendRedirect("index");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
