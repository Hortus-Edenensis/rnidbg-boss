package defpackage;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class g13 extends Thread {
    public static final String THREAD_PREFIX = "LXT#";
    private static int threadInitNumber;

    public g13() {
        setName(THREAD_PREFIX + getClass().getSimpleName() + "-" + nextThreadNum());
    }

    private static synchronized int nextThreadNum() {
        int i;
        i = threadInitNumber;
        threadInitNumber = i + 1;
        return i;
    }

    public g13(Runnable runnable) {
        super(runnable);
        setName(THREAD_PREFIX + getClass().getSimpleName() + "-" + nextThreadNum());
    }

    public g13(ThreadGroup threadGroup, Runnable runnable) {
        super(threadGroup, runnable);
        setName(THREAD_PREFIX + getClass().getSimpleName() + "-" + nextThreadNum());
    }

    public g13(@NonNull String str) {
        super(str);
        setName(THREAD_PREFIX + str + "-" + nextThreadNum());
    }

    public g13(ThreadGroup threadGroup, @NonNull String str) {
        super(threadGroup, str);
        setName(THREAD_PREFIX + str + "-" + nextThreadNum());
    }

    public g13(Runnable runnable, String str) {
        super(runnable, str);
        setName(THREAD_PREFIX + str + "-" + nextThreadNum());
    }

    public g13(ThreadGroup threadGroup, Runnable runnable, @NonNull String str) {
        super(threadGroup, runnable, str);
        setName(THREAD_PREFIX + str + "-" + nextThreadNum());
    }

    public g13(ThreadGroup threadGroup, Runnable runnable, @NonNull String str, long j) {
        super(threadGroup, runnable, str, j);
        setName(THREAD_PREFIX + str + "-" + nextThreadNum());
    }
}
