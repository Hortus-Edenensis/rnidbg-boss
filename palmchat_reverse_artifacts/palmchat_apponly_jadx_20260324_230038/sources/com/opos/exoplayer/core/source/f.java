package com.opos.exoplayer.core.source;

import com.opos.exoplayer.core.w;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class f extends w {
    protected final w b;

    public f(w wVar) {
        this.b = wVar;
    }

    @Override // com.opos.exoplayer.core.w
    public int a(int i, int i2, boolean z) {
        return this.b.a(i, i2, z);
    }

    @Override // com.opos.exoplayer.core.w
    public int b() {
        return this.b.b();
    }

    @Override // com.opos.exoplayer.core.w
    public int c() {
        return this.b.c();
    }

    @Override // com.opos.exoplayer.core.w
    public int a(Object obj) {
        return this.b.a(obj);
    }

    @Override // com.opos.exoplayer.core.w
    public int b(int i, int i2, boolean z) {
        return this.b.b(i, i2, z);
    }

    @Override // com.opos.exoplayer.core.w
    public int a(boolean z) {
        return this.b.a(z);
    }

    @Override // com.opos.exoplayer.core.w
    public int b(boolean z) {
        return this.b.b(z);
    }

    @Override // com.opos.exoplayer.core.w
    public w.a a(int i, w.a aVar, boolean z) {
        return this.b.a(i, aVar, z);
    }

    @Override // com.opos.exoplayer.core.w
    public w.b a(int i, w.b bVar, boolean z, long j) {
        return this.b.a(i, bVar, z, j);
    }
}
