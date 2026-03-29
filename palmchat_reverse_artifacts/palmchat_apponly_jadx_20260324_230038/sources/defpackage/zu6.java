package defpackage;

import com.apm.lite.CrashType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class zu6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile zu6 f22518a;

    public static zu6 a() {
        if (f22518a == null) {
            synchronized (zu6.class) {
                if (f22518a == null) {
                    f22518a = new zu6();
                }
            }
        }
        return f22518a;
    }

    public void d() {
    }

    public void c(String str) {
    }

    public void b(CrashType crashType, long j, String str) {
    }
}
