package com.test.veloctiy;

import org.springframework.stereotype.Controller;

import com.zzuli.oj.common.Action;

/**
 * @author xiangqh
 *
 */
@Controller
public class VelocityAction extends Action{

	public String test(){
		setHttpAttribute("aa", "123456");
		return "success";
	}
}
