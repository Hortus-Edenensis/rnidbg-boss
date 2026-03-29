package com.zm.fda.Z2500.Z200O;

import android.app.ActivityManager;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZZ00Z extends Throwable {
    public static final String[] b = {"FinalizerWatchdogDaemon", "HeapTaskDaemon", "FinalizerDaemon", "ReferenceQueueDaemon"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16698a;

    public ZZ00Z(String str) {
        super(str);
    }

    public static ZZ00Z a(ActivityManager.ProcessErrorStateInfo processErrorStateInfo) {
        Thread thread = Looper.getMainLooper().getThread();
        StringBuilder sb = new StringBuilder();
        sb.append(processErrorStateInfo.longMsg);
        sb.append("\n");
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Thread thread2 : allStackTraces.keySet()) {
            if (thread2 != thread && thread2 != Thread.currentThread() && !a(b, thread2.getName())) {
                a(sb, thread2, allStackTraces.get(thread2));
            }
        }
        ZZ00Z zz00z = new ZZ00Z(processErrorStateInfo.shortMsg);
        zz00z.setStackTrace(thread.getStackTrace());
        zz00z.f16698a = sb.toString();
        return null;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return ZZ00Z.class.getName();
    }

    public static void a(StringBuilder sb, Thread thread, StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        sb.append("Trace information for the thread：");
        sb.append(a(thread));
        sb.append("\n");
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append("\n");
        }
    }

    public static String a(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + ")";
    }

    public static boolean a(String[] strArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    public String a() {
        return this.f16698a;
    }
}
