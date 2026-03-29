package com.igexin.push.core.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f7140a;

    private void d() {
        if (this.f7140a) {
            return;
        }
        this.f7140a = true;
    }

    private boolean e() {
        return this.f7140a;
    }

    public abstract void a();

    public boolean a(Object obj) {
        return true;
    }

    public abstract void b();

    public boolean c() {
        return true;
    }
}
