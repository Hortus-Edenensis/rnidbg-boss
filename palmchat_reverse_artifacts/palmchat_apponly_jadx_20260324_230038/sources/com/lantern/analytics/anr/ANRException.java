package com.lantern.analytics.anr;

import android.app.ActivityManager;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ANRException extends Throwable {
    private static final String[] igores = {"FinalizerWatchdogDaemon", "HeapTaskDaemon", "FinalizerDaemon", "ReferenceQueueDaemon"};
    private String extraStackTrace;

    private ANRException(String str) {
        super(str);
    }

    public static ANRException New(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        Thread thread = Looper.getMainLooper().getThread();
        StringBuilder sb = new StringBuilder();
        sb.append(processErrorStateInfo.longMsg);
        sb.append("\n");
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Thread thread2 : allStackTraces.keySet()) {
            if (thread2 != thread && thread2 != Thread.currentThread() && !contains(igores, thread2.getName())) {
                buildThreadTrace(sb, thread2, allStackTraces.get(thread2));
            }
        }
        ANRException aNRException = new ANRException(processErrorStateInfo.shortMsg);
        aNRException.setStackTrace(thread.getStackTrace());
        aNRException.extraStackTrace = sb.toString();
        return aNRException;
    }

    public static void buildThreadTrace(StringBuilder sb, Thread thread, StackTraceElement[] stackTraceElementArr) {
        sb.append("Trace information for the thread: ");
        sb.append(getThreadTitle(thread));
        sb.append("\n");
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append("\n");
        }
    }

    private static boolean contains(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    private static String getThreadTitle(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + ")";
    }

    public String getExtraStackTrace() {
        return this.extraStackTrace;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName();
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
