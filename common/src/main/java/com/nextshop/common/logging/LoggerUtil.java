package com.nextshop.common.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: Srinivas Velishetti
 */
public class LoggerUtil {
    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
