package com.test.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;

/**
 * @author xiangqh
 *
 */
public class LogBackTest {

	static final Logger logger = LoggerFactory.getLogger("com.sssss");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		Logger rootLogger = loggerContext.getLogger(Logger.ROOT_LOGGER_NAME);
		loggerContext.reset();
//		logger.info("1234556");
//		logger.warn("test", "qqqqqqqqq");
	}

}
