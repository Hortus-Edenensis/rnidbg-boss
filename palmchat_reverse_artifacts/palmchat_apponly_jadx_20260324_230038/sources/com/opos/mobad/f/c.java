package com.opos.mobad.f;

import android.content.Context;
import com.opos.mobad.c.a.d;
import com.opos.mobad.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f8889a;

    private c() {
    }

    private com.opos.mobad.ad.c a(Context context, int i, boolean z) {
        return new m(context, i);
    }

    public static final void b(Context context) {
        synchronized (c.class) {
            if (f8889a == null) {
                return;
            }
            f8889a.d();
            f8889a = null;
        }
    }

    public static c e() {
        c cVar;
        if (f8889a != null) {
            return f8889a;
        }
        synchronized (c.class) {
            if (f8889a == null) {
                f8889a = new c();
            }
            cVar = f8889a;
        }
        return cVar;
    }

    public void a(Context context, String str, int i, boolean z, boolean z2) {
        Context applicationContext = context.getApplicationContext();
        a(applicationContext, Integer.valueOf(d.a.f8585a), a(applicationContext, i, z2));
        a(applicationContext, z);
        com.opos.cmn.an.f.a.b("AdFactory", "init() touristMode=", Boolean.valueOf(z2), "isDebug=", Boolean.valueOf(z));
    }
}
