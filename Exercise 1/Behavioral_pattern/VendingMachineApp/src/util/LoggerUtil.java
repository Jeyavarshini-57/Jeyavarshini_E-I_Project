package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {
    public static void info(String message) {
        System.out.println("[INFO " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME) + "] " + message);
    }

    public static void error(String message) {
        System.err.println("[ERROR " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME) + "] " + message);
    }
}
