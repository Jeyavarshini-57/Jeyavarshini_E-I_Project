package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void info(String msg) {
        System.out.println("[INFO] " + now() + " - " + msg);
    }

    public static void error(String msg) {
        System.err.println("[ERROR] " + now() + " - " + msg);
    }

    private static String now() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
