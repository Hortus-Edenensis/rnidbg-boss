package com.igexin.c.a.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b implements com.igexin.c.a.d.a.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f7055a;
    private long b;
    protected String y = getClass().getName();

    @Override // com.igexin.c.a.d.a.e
    public final void a(boolean z) {
        this.f7055a = !z;
    }

    @Override // com.igexin.c.a.d.a.e
    public final void b(long j) {
        this.b = j;
    }

    @Override // com.igexin.c.a.d.a.e
    public final boolean j() {
        return this.f7055a;
    }

    @Override // com.igexin.c.a.d.a.e
    public final long k() {
        return this.b;
    }
}
