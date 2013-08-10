package com.zzuli.oj.common.action;

import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.InternalContextAdapter;
import org.springframework.stereotype.Controller;

import com.zzuli.oj.common.Action;
import com.zzuli.oj.common.ModuleAction;

/**
 * @author xiangqh
 *
 */
@Controller
public class CommonAction extends Action implements ModuleAction {

	@Override
	public void head(InternalContextAdapter icad, Map param, VelocityContext context) {

	}

	@Override
	public void foot(InternalContextAdapter icad, Map param, VelocityContext context) {

	}


}
