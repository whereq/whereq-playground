package com.whereq.demo.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
//    private static final Logger consoleLogger = LogManager.getLogger("consoleLogger");
//    private static final Logger fileLogger = LogManager.getLogger("fileLogger");
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
//        consoleLogger.debug("This is a debug message logged to the console.");
//        consoleLogger.info("This is an info message logged to the console.");

//        fileLogger.debug("This is a debug message logged to the file.");
//        fileLogger.info("This is an info message logged to the file.");

        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");
        logger.warn("Warn log message");
        logger.fatal("Fatal log message");
        logger.trace("Trace log message");
    }
}
