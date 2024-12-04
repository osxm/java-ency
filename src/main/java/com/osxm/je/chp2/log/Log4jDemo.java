/**
 * Copyright (C)  Oscar Chen(XM):
 * 
 * Date: 2024-12-04
 * Author: XM
 */
package com.osxm.je.chp2.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
    private static Logger logger = LogManager.getLogger(Log4jDemo.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        logger.debug("调试信息");
        logger.info("一般信息");
        logger.error("错误信息");
    }
}
