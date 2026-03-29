package com.oplus.tblplayer.logger;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    @NonNull
    private static LoggerPrinter printer = new LoggerPrinter();

    private Logger() {
    }

    public static void addLoggerAdapter(@NonNull ILoggerAdapter iLoggerAdapter) {
        printer.addAdapter((ILoggerAdapter) Utils.checkNotNull(iLoggerAdapter));
    }

    public static void addLoggerAdapters(@NonNull List<ILoggerAdapter> list) {
        printer.addAdapters((List) Utils.checkNotNull(list));
    }

    public static void clearLoggerAdapters() {
        printer.clearAdapters();
    }

    public static int d(String str, String str2) {
        return println(3, str, str2);
    }

    public static int e(String str, String str2) {
        return println(6, str, str2);
    }

    public static int i(String str, String str2) {
        return println(4, str, str2);
    }

    private static int println(int i, String str, String str2) {
        return println(i, str, str2, null);
    }

    public static int v(String str, String str2) {
        return println(2, str, str2);
    }

    public static int w(String str, String str2) {
        return println(5, str, str2);
    }

    public static int d(String str, String str2, Throwable th) {
        return println(3, str, str2, th);
    }

    public static int e(String str, String str2, Throwable th) {
        return println(6, str, str2, th);
    }

    public static int i(String str, String str2, Throwable th) {
        return println(4, str, str2, th);
    }

    private static int println(int i, String str, String str2, Throwable th) {
        return ((LoggerPrinter) Utils.checkNotNull(printer)).println(i, str, str2, th);
    }

    public static int v(String str, String str2, Throwable th) {
        return println(2, str, str2, th);
    }

    public static int w(String str, String str2, Throwable th) {
        return println(5, str, str2, th);
    }

    public static int w(String str, Throwable th) {
        return println(5, str, null, th);
    }
}
