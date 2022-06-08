/**  
* @Title: Log4jDemo.java
* @Package com.osxm.je.topic.log
* @Description: TODO
* @author XM
* @date 2022年6月8日 下午10:06:51
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.log;

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
