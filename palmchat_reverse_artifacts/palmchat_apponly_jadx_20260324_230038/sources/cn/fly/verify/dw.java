package cn.fly.verify;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class dw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static dw f2208a;
    private final HashMap<String, Integer> b = new HashMap<>();

    private dw() {
    }

    public static synchronized dw a() {
        if (f2208a == null) {
            f2208a = new dw();
        }
        return f2208a;
    }

    public void a(String str, int i) {
        synchronized (this.b) {
            this.b.put(str, Integer.valueOf(i));
        }
    }
}
