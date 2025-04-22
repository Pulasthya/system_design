package loggingFramework;

import loggingFramework.LogAppender.ConsoleAppender;

public class Logger {
    private static final Logger logger = new Logger();
    private LogConfig logConfig;

    private Logger() {
        logConfig = new LogConfig(new ConsoleAppender());
    }

    public static Logger getInstance() {
        return logger;
    }

    public void setConfig(LogConfig logConfig){
        this.logConfig = logConfig;
    }

    public void log(LogLevel level, String message) {
        LogMessage logMessage = new LogMessage(level, message);
        logConfig.getLogAppender().append(logMessage);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        log(LogLevel.FATAL, message);
    }
}
