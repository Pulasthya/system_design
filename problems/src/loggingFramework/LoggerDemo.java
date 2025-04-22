package loggingFramework;

import loggingFramework.LogAppender.FileAppender;

public class LoggerDemo {
    public static void run() {
        Logger logger = Logger.getInstance();

        logger.info("Hello World! I am an Amazonian");
        logger.debug("Something is fishy");
        logger.info("Nope, it is as expected. You're an Amazonian");

        LogConfig logConfig = new LogConfig(new FileAppender("logTest.log"));
        logger.setConfig(logConfig);

        logger.info("Setting the new Config");
        logger.debug("Checking for it's working");
        logger.info("Working as expected");
    }
}
