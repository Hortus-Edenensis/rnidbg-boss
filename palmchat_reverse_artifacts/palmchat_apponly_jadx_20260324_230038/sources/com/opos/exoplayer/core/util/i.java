package com.opos.exoplayer.core.util;

import androidx.media3.muxer.MuxerUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8394a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final long h;

    public i(byte[] bArr, int i) {
        o oVar = new o(bArr);
        oVar.a(i * 8);
        this.f8394a = oVar.c(16);
        this.b = oVar.c(16);
        this.c = oVar.c(24);
        this.d = oVar.c(24);
        this.e = oVar.c(20);
        this.f = oVar.c(3) + 1;
        this.g = oVar.c(5) + 1;
        this.h = ((((long) oVar.c(4)) & 15) << 32) | (((long) oVar.c(32)) & MuxerUtil.UNSIGNED_INT_MAX_VALUE);
    }

    public int a() {
        return this.g * this.e;
    }

    public long b() {
        return (this.h * 1000000) / ((long) this.e);
    }
}
