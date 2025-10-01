package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void info(String msg) {
        System.out.println("[INFO " + timestamp() + "] " + msg);
    }

    public static void error(String msg) {
        System.err.println("[ERROR " + timestamp() + "] " + msg);
    }

    private static String timestamp() {
        return LocalDateTime.now().format(formatter);
    }
}
