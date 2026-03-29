package com.lantern.daemon.doubleprocess;

import android.content.Context;
import android.os.Build;
import defpackage.qt0;
import defpackage.rt0;
import defpackage.st0;
import defpackage.tt0;
import defpackage.ut0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface c {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static c f7536a;

        public static c a() {
            c cVar = f7536a;
            if (cVar != null) {
                return cVar;
            }
            switch (Build.VERSION.SDK_INT) {
                case 21:
                    if (!"MX4 Pro".equalsIgnoreCase(Build.MODEL)) {
                        f7536a = new qt0();
                    } else {
                        f7536a = new tt0();
                    }
                    break;
                case 22:
                    f7536a = new rt0();
                    break;
                case 23:
                    f7536a = new st0();
                    break;
                default:
                    String str = Build.MODEL;
                    if (str != null) {
                        if (str.toLowerCase().startsWith("mi")) {
                            f7536a = new ut0();
                        } else if (!str.toLowerCase().startsWith("a31")) {
                            f7536a = new tt0();
                        } else {
                            f7536a = new qt0();
                        }
                    }
                    break;
            }
            return f7536a;
        }
    }

    void a(Context context, b bVar);

    void b(Context context, b bVar);

    boolean c(Context context);

    void d();
}
