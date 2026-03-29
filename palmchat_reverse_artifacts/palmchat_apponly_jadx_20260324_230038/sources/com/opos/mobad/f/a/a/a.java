package com.opos.mobad.f.a.a;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.service.g.d f8799a = new com.opos.mobad.service.g.d();
    private String b;
    private String c;
    private String d;
    private volatile long e;
    private long f;

    public a(String str, long j) {
        this.b = str;
        this.f = j;
        this.f = j;
    }

    public void a() {
        a("t", 0);
    }

    public abstract void a(String str, long j, String str2, int i, long j2, String str3, String str4);

    public void b() {
        a("t", 2);
    }

    public abstract void b(String str, long j, String str2, int i, long j2, String str3, String str4);

    public void c(int i) {
        if (i != 1035) {
            b(i);
        } else {
            com.opos.mobad.c.b.i().a(this.b);
            this.f8799a = new com.opos.mobad.service.g.d();
        }
    }

    public void a(int i) {
        a(this.b, this.f, this.c, i, SystemClock.elapsedRealtime() - this.e, this.f8799a.b(), this.d);
        this.c = null;
        this.d = null;
        this.f8799a = new com.opos.mobad.service.g.d();
    }

    public void b(int i) {
        b(this.b, this.f, this.c, i, SystemClock.elapsedRealtime() - this.e, this.f8799a.b(), this.d);
        this.c = null;
        this.d = null;
        this.f8799a = new com.opos.mobad.service.g.d();
    }

    public void a(int i, int i2) {
        a(String.valueOf(i), i2);
    }

    public final void a(String str, int i) {
        if (this.f8799a.a() >= 1024) {
            com.opos.cmn.an.f.a.b("", "illegal append report");
        } else {
            this.f8799a.a(str, String.valueOf(i));
        }
    }

    public void a(String str, String str2) {
        this.c = str;
        this.d = str2;
        this.e = SystemClock.elapsedRealtime();
    }
}
