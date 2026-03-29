package com.opos.mobad.model.a;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9048a;
    private String b;
    private long c = SystemClock.elapsedRealtime();
    private boolean d;

    public g(String str, String str2, boolean z) {
        this.b = str;
        this.f9048a = str2;
        this.d = z;
    }

    public void a(com.opos.mobad.b bVar) {
        com.opos.mobad.cmn.func.b.e.a(bVar, this.b, this.f9048a, "6", g(), SystemClock.elapsedRealtime() - this.c, f(), this.d);
    }

    public void b(com.opos.mobad.b bVar) {
        com.opos.mobad.cmn.func.b.e.a(bVar, this.b, this.f9048a, "1", g(), SystemClock.elapsedRealtime() - this.c, f(), this.d);
    }

    public void c(com.opos.mobad.b bVar) {
        com.opos.mobad.cmn.func.b.e.a(bVar, this.b, this.f9048a, "1", g(), SystemClock.elapsedRealtime() - this.c, f(), this.d, true);
    }

    public void a(com.opos.mobad.b bVar, int i) {
        com.opos.mobad.cmn.func.b.e.a(bVar, this.b, this.f9048a, i, g(), SystemClock.elapsedRealtime() - this.c, f(), this.d);
    }

    public void b(com.opos.mobad.b bVar, int i) {
        com.opos.mobad.cmn.func.b.e.a(bVar, this.b, this.f9048a, i, g(), SystemClock.elapsedRealtime() - this.c, f(), this.d, true);
    }
}
