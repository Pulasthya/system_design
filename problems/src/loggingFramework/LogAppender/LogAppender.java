package loggingFramework.LogAppender;

import loggingFramework.LogMessage;

public interface LogAppender {
    public void append(LogMessage message);
}
