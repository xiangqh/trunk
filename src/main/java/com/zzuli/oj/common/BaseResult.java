package com.zzuli.oj.common;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.zz.qstruts2.dispatcher.ng.result.VelocityResult;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Inject;

public class BaseResult implements Result{

	private static final long serialVersionUID = 5276993118917346950L;

	private String location;
	private String defaultLocation;
	private Container container;
	private ActionMapping mapping;

	public BaseResult(String location){
		this.location = location;

	}

	public BaseResult(String location,String defaultLocation){
		this(location);
		this.defaultLocation = defaultLocation;
	}

	public BaseResult(ActionMapping mapping){
		this.mapping = mapping;
	}

	@Inject
    public void setContainer(Container cont) {
        this.container = cont;
    }



	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.Result#execute(com.opensymphony.xwork2.ActionInvocation)
	 */
	public void execute(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		if(mapping!=null){

		}else{
			VelocityResult r = new VelocityResult(location);
			container.inject(r);
			r.execute(invocation);
		}
	}

}