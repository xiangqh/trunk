package com.zzuli.oj.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

/**
 * @author xiangqh
 *
 */
public class JsonResult implements Result {

	private static final long serialVersionUID = 1184281500576715168L;

	private String	json;
	public JsonResult() {
	}
	public JsonResult(String json) {

		this.json = json;
	}
	public void execute(ActionInvocation invocation) throws Exception {

		HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(this);
		out.flush();
	}
	@Override
	public String toString() {

		return  this.json;
	}

}