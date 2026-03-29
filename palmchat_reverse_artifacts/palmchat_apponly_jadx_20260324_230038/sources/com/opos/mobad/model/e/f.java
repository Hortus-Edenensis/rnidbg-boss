package com.opos.mobad.model.e;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9101a;
    private String b;
    private long c = SystemClock.elapsedRealtime();
    private l d = new l();

    public f(String str, String str2) {
        this.b = str;
        this.f9101a = str2;
    }

    public void a(int i) {
        this.d.a("2", i);
    }

    public void b(int i) {
        this.d.a("3", i);
    }

    public void c(int i) {
        this.d.a("4", i);
    }

    public void d(int i) {
        this.d.a("5", i);
    }

    public void a(com.opos.mobad.b bVar, int i, String str, boolean z, String str2, String str3, String str4) {
        com.opos.mobad.cmn.func.b.e.a(bVar, this.b, this.f9101a, i, SystemClock.elapsedRealtime() - this.c, z, com.opos.cmn.i.o.a(this.d.a()), str2, str3, str4);
    }

    public void a(com.opos.mobad.b bVar, String str, boolean z, String str2, int i, String str3, String str4) {
        com.opos.mobad.cmn.func.b.e.a(bVar, this.b, str, this.f9101a, SystemClock.elapsedRealtime() - this.c, z, com.opos.cmn.i.o.a(this.d.a()), str2, i, str3, str4);
    }
}
