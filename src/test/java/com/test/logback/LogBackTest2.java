package com.test.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiangqh
 *
 */
public class LogBackTest2 {

	static final Logger logger = LoggerFactory.getLogger(LogBackTest2.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.info("234234234");
		logger.warn("test", "eeeeeee");
	}
}
