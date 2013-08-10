package com.zzuli.oj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport {

	private static final long serialVersionUID = -187235989739919273L;

	public HttpServletRequest getHttpServletRequest() {
		return (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	}

	public HttpServletResponse getHttpServletResponse() {
		return (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE);
	}

	public String getHttpParameter(String param) {
		HttpServletRequest req = getHttpServletRequest();
		if(req!=null){
			return req.getParameter(param);
		}
		return null;
	}

	public void setHttpAttribute(String key,Object value) {
		HttpServletRequest req = getHttpServletRequest();
		if(req!=null){
			req.setAttribute(key, value);
		}
	}

	public long getParameterLong(String key){
		String temp = getHttpParameter(key);
		if(temp==null){
			return 0;
		}
		try{
			return Long.parseLong(temp);
		}catch(Exception e){

		}
		return 0;
	}

	public int getParameterInt(String key){
		String temp = getHttpParameter(key);
		if(temp==null){
			return 0;
		}
		try{
			return Integer.parseInt(temp);
		}catch(Exception e){

		}
		return 0;
	}
}
