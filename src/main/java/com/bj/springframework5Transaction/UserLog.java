package com.bj.springframework5Transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserLog {
    private static final Logger logger = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {
        logger.info("hello");
        logger.warn("warn");
    }
}
