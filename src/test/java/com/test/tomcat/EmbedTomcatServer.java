package com.test.tomcat;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.Context;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiangqh
 *
 */
public class EmbedTomcatServer {

	private static final Logger logger = LoggerFactory.getLogger(EmbedTomcatServer.class);
	/**
	 * @param args
	 * @throws ServletException
	 */
	public static void main(String[] args) throws Exception {
		String application  = "new_oj";
		int httpPort = 9997;
		if(args.length == 2) {
			httpPort = Integer.valueOf(args[1]);
		}

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(httpPort);

		 // Add AprLifecycleListener
        AprLifecycleListener aprLifecycleListener = new AprLifecycleListener();
        StandardServer server = (StandardServer) tomcat.getServer();
        server.addLifecycleListener(aprLifecycleListener);

        Context context = tomcat.addWebapp("/" + application, new File("web").getAbsolutePath());
        context.setReloadable(true);
        logger.info("Starting tomcat for " + application + "......");
        tomcat.start();
        server.await();

	}

}
