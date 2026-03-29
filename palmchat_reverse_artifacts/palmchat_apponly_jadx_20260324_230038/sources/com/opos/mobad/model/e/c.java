package com.opos.mobad.model.e;

import android.content.Context;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f9096a;
    private com.opos.mobad.model.b.a b = new com.opos.mobad.model.a.d();
    private com.opos.mobad.model.c.d c;

    private c() {
    }

    public synchronized com.opos.mobad.model.c.d a(Context context) {
        if (this.c != null) {
            return this.c;
        }
        try {
            byte[] bArrA = com.opos.mobad.o.b.a(context, "oposCache.txt");
            if (bArrA == null) {
                return null;
            }
            this.c = new com.opos.mobad.model.c.d(com.opos.mobad.b.a.d.c.a(com.opos.cmn.an.b.b.d(bArrA)));
        } catch (IOException e) {
            com.opos.cmn.an.f.a.d("FallBackAdManager", "getCacheAd fail ", e);
        }
        return this.c;
    }

    public static final c a() {
        if (f9096a == null) {
            synchronized (c.class) {
                if (f9096a == null) {
                    f9096a = new c();
                }
            }
        }
        return f9096a;
    }

    public void a(final com.opos.mobad.b bVar, final com.opos.mobad.model.c.d dVar, final List<com.opos.mobad.b.a.b> list, final int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("cache list num:");
        sb.append(list != null ? list.size() : 0);
        com.opos.cmn.an.f.a.b("FallBackAdManager", sb.toString());
        if (list == null || list.size() <= 0) {
            return;
        }
        this.c = dVar;
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.e.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.opos.mobad.o.b.a(bVar.b(), "oposCache.txt", com.opos.cmn.an.b.b.c(c.this.b.a(list, dVar, i).f9161a));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("FallBackAdManager", "cache fail", e);
                }
            }
        });
    }
}
