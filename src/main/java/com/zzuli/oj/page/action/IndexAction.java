package com.zzuli.oj.page.action;

import org.springframework.stereotype.Controller;
import org.zz.qstruts2.action.QAction;
import org.zz.qstruts2.annotations.ActionController;
import org.zz.qstruts2.annotations.RequestMapping;
import org.zz.qstruts2.dispatcher.ng.result.VelocityResult;

import com.opensymphony.xwork2.Result;
import com.zzuli.oj.common.Action;
import com.zzuli.oj.common.BaseResult;

/**
 * @author xiangqh
 *
 */
@Controller
@ActionController
public class IndexAction extends QAction {

	@RequestMapping(value="index")
	public Result show(){
		return new BaseResult("/system/default/page/index.vm");
	}
}
