package loggingFramework;

import loggingFramework.LogAppender.LogAppender;

public class LogConfig {
    private LogAppender logAppender;

    public LogConfig(LogAppender logAppender){
        this.logAppender = logAppender;
    }

    public LogAppender getLogAppender() {
        return logAppender;
    }

    public void setLogAppender(LogAppender logAppender){
        this.logAppender = logAppender;
    }
}
