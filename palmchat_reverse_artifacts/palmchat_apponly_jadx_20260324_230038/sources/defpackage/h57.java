package defpackage;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class h57 {
    public static h57 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<Runnable> f17875a = new LinkedBlockingQueue<>();

    public static synchronized h57 a() {
        try {
        } catch (Exception e) {
            g57.a(e);
        }
        if (b == null) {
            b = new h57();
        }
        return b;
    }

    public void b(Runnable runnable) {
        try {
            this.f17875a.put(runnable);
        } catch (Exception e) {
            g57.a(e);
        }
    }
}
