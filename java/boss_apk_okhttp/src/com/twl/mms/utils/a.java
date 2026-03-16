package com.twl.mms.utils;

public final class a {
    private static int level = 3;
    private static b sink = new DefaultSink();

    private a() {}

    public interface b {
        void flush();

        int getLogLevel();

        void logD(String tag, String message);

        void logE(String tag, String message);

        void logI(String tag, String message);
    }

    private static final class DefaultSink implements b {
        @Override
        public void flush() {}

        @Override
        public int getLogLevel() {
            return level;
        }

        @Override
        public void logD(String tag, String message) {
            System.err.println("[D][" + tag + "] " + message);
        }

        @Override
        public void logE(String tag, String message) {
            System.err.println("[E][" + tag + "] " + message);
        }

        @Override
        public void logI(String tag, String message) {
            System.err.println("[I][" + tag + "] " + message);
        }
    }

    public static void b(String tag, String message) {
        c(tag, message, (Object[]) null);
    }

    public static void c(String tag, String message, Object... args) {
        if (sink == null || h() > 1) {
            return;
        }
        sink.logD("MMSService", format(tag, message, args));
    }

    public static void d(String tag, String message) {
        e(tag, message, (Object[]) null);
    }

    public static void e(String tag, String message, Object... args) {
        if (sink == null || h() > 4) {
            return;
        }
        sink.logE("MMSService", format(tag, message, args));
    }

    public static void f() {
        if (sink != null) {
            sink.flush();
        }
    }

    public static int h() {
        return sink == null ? 6 : sink.getLogLevel();
    }

    public static void i(String tag, String message) {
        j(tag, message, (Object[]) null);
    }

    public static void j(String tag, String message, Object... args) {
        if (sink == null || h() > 2) {
            return;
        }
        sink.logI("MMSService", format(tag, message, args));
    }

    public static void k(String tag, Throwable error, String message, Object... args) {
        if (sink == null || h() > 5) {
            return;
        }
        String suffix = error == null ? "" : " " + error;
        sink.logE("MMSService", format(tag, message, args) + suffix);
    }

    public static void l(b customSink) {
        sink = customSink;
    }

    private static String format(String tag, String message, Object... args) {
        String resolved = message == null ? "" : message;
        if (args != null && args.length > 0) {
            resolved = String.format(resolved, args);
        }
        return "[" + tag + "] " + resolved;
    }
}
