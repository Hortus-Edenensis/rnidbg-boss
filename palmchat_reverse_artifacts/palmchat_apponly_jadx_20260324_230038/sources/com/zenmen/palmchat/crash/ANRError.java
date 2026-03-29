package com.zenmen.palmchat.crash;

import android.os.Looper;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ANRError extends Error {
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f13871a;
        public final StackTraceElement[] b;

        /* JADX INFO: renamed from: com.zenmen.palmchat.crash.ANRError$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1044a extends Throwable {
            @Override // java.lang.Throwable
            public Throwable fillInStackTrace() {
                setStackTrace(a.this.b);
                return this;
            }

            public C1044a(C1044a c1044a) {
                super(a.this.f13871a, c1044a);
            }
        }

        public a(String str, StackTraceElement[] stackTraceElementArr) {
            this.f13871a = str;
            this.b = stackTraceElementArr;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Comparator<Thread> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Thread f13873a;

        public b(Thread thread) {
            this.f13873a = thread;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Thread thread, Thread thread2) {
            if (thread == thread2) {
                return 0;
            }
            Thread thread3 = this.f13873a;
            if (thread == thread3) {
                return 1;
            }
            if (thread2 == thread3) {
                return -1;
            }
            return thread2.getName().compareTo(thread.getName());
        }
    }

    private ANRError(a.C1044a c1044a) {
        super("Application Not Responding", c1044a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ANRError New(String str, boolean z) {
        Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new b(thread));
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            if (entry.getKey() == thread || (entry.getKey().getName().startsWith(str) && (z || entry.getValue().length > 0))) {
                treeMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (!treeMap.containsKey(thread)) {
            treeMap.put(thread, thread.getStackTrace());
        }
        Object[] objArr = 0;
        a.C1044a c1044a = null;
        for (Map.Entry entry2 : treeMap.entrySet()) {
            c1044a = new a.C1044a(c1044a);
        }
        return new ANRError(c1044a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ANRError NewMainOnly() {
        Thread thread = Looper.getMainLooper().getThread();
        return new ANRError(new a.C1044a(0 == true ? 1 : 0));
    }

    private static String getThreadTitle(Thread thread) {
        return thread.getName() + " (state = " + thread.getState() + ")";
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
