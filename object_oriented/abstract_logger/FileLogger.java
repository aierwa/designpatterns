import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;

/**
 * @Author xuxiang
 * @Date 2020/3/27
 */
public class FileLogger extends Logger {
    private FileWriter fileWriter;

    public FileLogger(String name, Level minPermittedLevel, String filePath) throws IOException {
        super(name, minPermittedLevel);
        File loggerFile = new File(filePath);
        if (!loggerFile.exists()) {
            loggerFile.createNewFile();
        }
        this.fileWriter = new FileWriter(filePath, true);
    }

    @Override
    protected void doLog(Level level, String message) {
        try {
            fileWriter.write(new Date().toString() + "  " + level.getName() + ": " + message + "\r\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
