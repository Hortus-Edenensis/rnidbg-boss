package com.bytedance.sdk.openadsdk.core.component.splash.fx.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5261a;
    private com.bytedance.sdk.openadsdk.core.kj.u b;
    private long iz;
    private long n;
    private boolean pn;
    private long x;

    public iz(com.bytedance.sdk.openadsdk.core.kj.u uVar, boolean z) {
        this.b = uVar;
        if (uVar != null && uVar.nr() != null && !this.b.nr().isEmpty()) {
            this.nr = this.b.nr().get(0);
        }
        this.pn = z;
    }

    public long a() {
        return this.f5261a;
    }

    public com.bytedance.sdk.openadsdk.core.kj.u b() {
        return this.b;
    }

    public void fx(long j) {
        this.x = j;
    }

    public long iz() {
        return this.iz;
    }

    public long n() {
        return this.n;
    }

    public void nr(long j) {
        this.iz = j;
    }

    public boolean pn() {
        return this.pn;
    }

    public long x() {
        return this.x;
    }

    public void b(long j) {
        this.n = j;
    }

    public void pn(long j) {
        this.f5261a = j;
    }
}
