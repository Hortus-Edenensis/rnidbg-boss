package defpackage;

import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class um1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static um1 f21243a;

    public static um1 b() {
        if (f21243a == null) {
            synchronized (bo0.class) {
                if (f21243a == null) {
                    f21243a = new um1();
                }
            }
        }
        return f21243a;
    }

    public static String e() {
        return new SimpleDateFormat("yyyyMMdd").format(Long.valueOf(System.currentTimeMillis()));
    }

    public String a() {
        return e();
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }
}
