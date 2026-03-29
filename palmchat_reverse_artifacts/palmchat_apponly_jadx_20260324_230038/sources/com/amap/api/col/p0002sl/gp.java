package com.amap.api.col.p0002sl;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class gp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static gp f2838a;
    private final Context b;
    private final String c = gw.a(ge.c("RYW1hcF9kZXZpY2VfYWRpdQ"));

    private gp(Context context) {
        this.b = context.getApplicationContext();
    }

    public static gp a(Context context) {
        if (f2838a == null) {
            synchronized (gp.class) {
                if (f2838a == null) {
                    f2838a = new gp(context);
                }
            }
        }
        return f2838a;
    }

    public final synchronized void a() {
        try {
            if (fv.c() == null) {
                fv.a(gt.a());
            }
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        gq.a(this.b).a(this.c);
        gq.a(this.b).b(str);
    }
}
