package com.igexin.push.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class b {
    private static final String c = "ExtensionTask";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f7336a = 0;
    protected long b = 0;

    private void a(long j) {
        this.f7336a = j;
    }

    private boolean b() {
        System.currentTimeMillis();
        return System.currentTimeMillis() - this.f7336a > this.b;
    }

    public abstract void a();
}
