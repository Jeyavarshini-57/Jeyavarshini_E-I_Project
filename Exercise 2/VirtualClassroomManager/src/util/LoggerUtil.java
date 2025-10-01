package util;

import java.util.logging.*;

public final class LoggerUtil {
    private static final Logger logger = Logger.getLogger("VirtualClassroomManager");

    static {
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
    }

    private LoggerUtil() {}

    public static void info(String msg) { logger.info(msg); }
    public static void error(String msg) { logger.severe(msg); }
}
