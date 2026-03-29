package com.igexin.c.a.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a implements com.igexin.c.a.d.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7053a;

    @Override // com.igexin.c.a.d.a.c
    public final void a(long j) {
        if (this.f7053a != 0) {
            this.f7053a = j;
        }
    }

    @Override // com.igexin.c.a.d.a.c
    public final long g() {
        return this.f7053a;
    }
}
