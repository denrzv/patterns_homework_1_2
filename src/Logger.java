import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    protected int num = 1;
    private static Logger logger;
    private final DateTimeFormatter dtf;

    private Logger() {
        dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("[" + dtf.format(now) + " " + num++ + "] " + msg);
    }
}