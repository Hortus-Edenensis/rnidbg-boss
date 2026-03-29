package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class wz2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f21836a = new AtomicInteger();

    public static String a(long j, int i) {
        StringBuilder sb = new StringBuilder(Long.toString(j));
        if (i <= 9) {
            sb.append("00");
            sb.append(i);
        } else if (i <= 99) {
            sb.append("0");
            sb.append(i);
        } else {
            sb.append(i);
        }
        return sb.toString();
    }

    public static int b() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = f21836a;
            i = atomicInteger.get();
            i2 = i < 999 ? i + 1 : 0;
        } while (!atomicInteger.compareAndSet(i, i2));
        return i2;
    }

    public static String c() {
        return a(d(), b());
    }

    public static long d() {
        return System.currentTimeMillis();
    }
}
