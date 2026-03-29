package defpackage;

import android.os.HandlerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ih7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile mj7 f18169a;

    public static HandlerThread a() {
        if (f18169a == null) {
            synchronized (ih7.class) {
                if (f18169a == null) {
                    f18169a = new mj7("default_npth_thread");
                    f18169a.i();
                }
            }
        }
        return f18169a.l();
    }

    public static mj7 b() {
        if (f18169a == null) {
            a();
        }
        return f18169a;
    }
}
