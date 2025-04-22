package loggingFramework.LogAppender;

import loggingFramework.LogMessage;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender {
    private String filePath;

    public FileAppender(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void append(LogMessage message){
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(message.toString() + "\n");
            System.out.println("Content successfully added to log file");
        }
        catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
