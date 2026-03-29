package com.xiaomi.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile dg f11505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private df f264a;

    public static dg a() {
        if (f11505a == null) {
            synchronized (dg.class) {
                if (f11505a == null) {
                    f11505a = new dg();
                }
            }
        }
        return f11505a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public df m293a() {
        return this.f264a;
    }

    public void a(df dfVar) {
        this.f264a = dfVar;
    }
}
