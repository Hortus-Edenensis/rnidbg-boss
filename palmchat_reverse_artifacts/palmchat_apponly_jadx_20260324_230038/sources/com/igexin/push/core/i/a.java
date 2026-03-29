package com.igexin.push.core.i;

import android.app.Activity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Long f7272a = Long.valueOf(System.currentTimeMillis());
    protected Activity b;
    protected String c;

    private Activity n() {
        return this.b;
    }

    public final Long a() {
        return this.f7272a;
    }

    public final String b() {
        return this.c;
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract boolean j();

    public abstract void k();

    public abstract boolean l();

    public abstract void m();

    public final void a(Activity activity) {
        this.b = activity;
    }

    private void a(Long l) {
        this.f7272a = l;
    }

    private void a(String str) {
        this.c = str;
    }
}
