package com.opos.mobad;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f8742a;
    private j b;

    public static final d a() {
        d dVar;
        d dVar2 = f8742a;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            dVar = f8742a;
            if (dVar == null) {
                dVar = new d();
                f8742a = dVar;
            }
        }
        return dVar;
    }

    public b b(Context context) {
        com.opos.mobad.c.f fVarJ = com.opos.mobad.c.b.j();
        if (fVarJ == null || !fVarJ.a()) {
            com.opos.cmn.an.f.a.b("", "ad creator no init");
            return null;
        }
        if (this.b != null) {
            return new c(context, fVarJ.b(), fVarJ.c(), fVarJ.d(), fVarJ.e(), fVarJ.g(), this.b);
        }
        com.opos.cmn.an.f.a.b("", "context service no init");
        return null;
    }

    public void a(Context context) {
        this.b = new com.opos.mobad.e.b(context);
    }
}
