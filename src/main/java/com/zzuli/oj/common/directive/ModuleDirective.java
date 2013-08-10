package com.zzuli.oj.common.directive;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

import com.zzuli.oj.common.ModuleAction;
import com.zzuli.oj.common.util.PropertyUtil;

/**
 * @author xiangqh
 *
 */
public class ModuleDirective extends Directive {

	private static final String MODULE_NAME = "qModuleLoader";

	@Override
	public String getName() {
		return MODULE_NAME;
	}

	@Override
	public int getType() {
		return LINE;
	}

	@Override
	public boolean render(InternalContextAdapter icad, Writer writer, Node node) throws IOException,
			ResourceNotFoundException, ParseErrorException, MethodInvocationException {

		Map<String, String> params = getParameters(icad, node);
		VelocityContext context = new VelocityContext();
		context.put("imageDomain", PropertyUtil.readValue("/addrconfig.properties", "imageDomain"));
		context.put("cssDomain", PropertyUtil.readValue("/addrconfig.properties", "cssDomain"));
		context.put("jsDomain", PropertyUtil.readValue("/addrconfig.properties", "jsDomain"));

		try {
			String moduleAction = getActionName(params.get("moduleName").substring(0,20).trim());
			String method = params.get("moduleName").substring(21).trim();
			ModuleAction frontDirective = (ModuleAction) Class.forName(moduleAction).newInstance();
			// 处理参数
			Object parameters = params.get("parameters");
			if (parameters != null) {
				setParem(params);
			}

			if(method.equals("head")) {
				frontDirective.head(icad, params, context);
			}else if(method.equals("foot")){
				frontDirective.foot(icad, params, context);
			}

			String path = params.get("path").toString();
			icad.pushCurrentTemplateName(path);
			Properties properties = new Properties();
			String basePath = ServletActionContext.getServletContext().getRealPath("/");
			properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, basePath);
			// 设置velocity的编码
			properties.setProperty(Velocity.ENCODING_DEFAULT, "utf-8");
			properties.setProperty(Velocity.INPUT_ENCODING, "utf-8");
			properties.setProperty(Velocity.OUTPUT_ENCODING, "utf-8");
			/* 首先创建一个模板引擎的实例，并予以初始化 */
			VelocityEngine engine = new VelocityEngine();
			engine.init(properties);
			/* 接着，获得一个模板 */
			Template template = engine.getTemplate(icad.getCurrentTemplateName());
			/* 现在，把模板和数据合并，输出到StringWriter */
			StringWriter wri = new StringWriter();
			template.merge(context, wri);
			/* 显示结果 */
			writer.write(wri.toString());

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	protected void setParem(Map<String, String> paraMap) throws ParseErrorException, MethodInvocationException {

		String parameters = paraMap.get("parameters").trim();
		if(!(parameters.startsWith("{") && parameters.endsWith("}"))) {
			throw new IllegalStateException("parameters illegal");
		}
		String[] params = parameters.substring(1, parameters.length() - 1).split(",");
		for (String param : params) {
			paraMap.put(param.split(":")[0].trim(), param.split(":")[1].trim());
		}
	}

	@SuppressWarnings("unchecked")
	protected Map<String, String> getParameters(InternalContextAdapter contextAdapter, Node node)
			throws ParseErrorException, MethodInvocationException {

		Map<String, String> paremMap = null;
		Node fChild = null;
		Object fValue = null;
		int paNum = node.jjtGetNumChildren();
		if (getType() == BLOCK) {
			paNum--;
		}
		if (paNum == 1 && null != (fChild = node.jjtGetChild(0)) && null != (fValue = fChild.value(contextAdapter))
				&& fValue instanceof Map) {
			paremMap = (Map<String, String>) fValue;
		} else {
			paremMap = new HashMap<String, String>();
			for (int index = 0, length = paNum; index < length; index++) {
				setParameter(paremMap, contextAdapter, node.jjtGetChild(index));
			}
		}

		return paremMap;
	}

	protected void setParameter(Map<String, String> propertyMap, InternalContextAdapter contextAdapter, Node node)
			throws ParseErrorException, MethodInvocationException {
		// node.value uses the StrutsValueStack to evaluate the directive's
		// value parameter
		String param = node.value(contextAdapter).toString();
		int index = param.indexOf("=");
		if (index != -1) {
			String key = param.substring(0, index);
			String value = param.substring(index + 1);
			propertyMap.put(key, value);
		}
	}

	private String getActionName(String moduleName){
		StringBuffer buffer = new StringBuffer("com.zzuli.oj.");
		int index = moduleName.lastIndexOf(".");
		buffer.append(moduleName.substring(0,index+1));
		buffer.append(moduleName.substring(index+1,index+2).toUpperCase());
		buffer.append(moduleName.substring(index+2));
		buffer.append("Action");
		return buffer.toString();
	}

}
