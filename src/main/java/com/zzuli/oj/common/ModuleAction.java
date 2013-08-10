package com.zzuli.oj.common;

import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.InternalContextAdapter;

/**
 * @author xiangqh
 *
 */
public interface ModuleAction {

	@SuppressWarnings("unchecked")
	public abstract void head(InternalContextAdapter icad, Map params, VelocityContext context);

	@SuppressWarnings("unchecked")
	public abstract void foot(InternalContextAdapter icad, Map params, VelocityContext context);

}
