package defpackage;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class im7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile HandlerThread f18204a;
    public static volatile Handler b;

    public static Handler a() {
        if (b == null) {
            b();
        }
        return b;
    }

    public static HandlerThread b() {
        if (f18204a == null) {
            synchronized (im7.class) {
                if (f18204a == null) {
                    HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                    f18204a = handlerThread;
                    handlerThread.start();
                    b = new Handler(f18204a.getLooper());
                }
            }
        }
        return f18204a;
    }
}
