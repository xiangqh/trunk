package com.zzuli.oj.common.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

/**
 * @author xiangqh
 *
 */
public class FilterDispatcher extends org.zz.qstruts2.dispatcher.ng.filter.FilterDispatcher{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;

		request.setAttribute("imageDomain", PropertyUtil.readValue("/addrconfig.properties", "imageDomain"));
		request.setAttribute("cssDomain", PropertyUtil.readValue("/addrconfig.properties", "cssDomain"));
		request.setAttribute("jsDomain", PropertyUtil.readValue("/addrconfig.properties", "jsDomain"));

		super.doFilter(request, resp, chain);
	}
}
