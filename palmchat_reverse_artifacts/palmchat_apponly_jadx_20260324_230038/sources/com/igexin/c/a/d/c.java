package com.igexin.c.a.d;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c implements com.igexin.c.a.d.a.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f7056a = true;

    @Override // com.igexin.c.a.d.a.g
    public final boolean a(long j, f fVar) {
        return TimeUnit.SECONDS.toMillis((long) fVar.B) < j - fVar.z;
    }

    @Override // com.igexin.c.a.d.a.g
    public final long b(long j, f fVar) {
        return (TimeUnit.SECONDS.toMillis(fVar.B) + fVar.z) - j;
    }

    @Override // com.igexin.c.a.d.a.g
    public final boolean d() {
        return this.f7056a;
    }

    @Override // com.igexin.c.a.d.a.g
    public void b() {
        this.f7056a = false;
    }
}
