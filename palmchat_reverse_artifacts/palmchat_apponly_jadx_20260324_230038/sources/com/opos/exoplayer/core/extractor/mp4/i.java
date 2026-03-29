package com.opos.exoplayer.core.extractor.mp4;

import com.opos.exoplayer.core.util.p;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f8217a;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;
    public long[] g;
    public int[] h;
    public int[] i;
    public int[] j;
    public long[] k;
    public boolean[] l;
    public boolean m;
    public boolean[] n;
    public c o;
    public int p;
    public p q;
    public boolean r;
    public long s;

    public void a() {
        this.e = 0;
        this.s = 0L;
        this.m = false;
        this.r = false;
        this.o = null;
    }

    public long b(int i) {
        return this.k[i] + ((long) this.j[i]);
    }

    public void a(int i) {
        p pVar = this.q;
        if (pVar == null || pVar.c() < i) {
            this.q = new p(i);
        }
        this.p = i;
        this.m = true;
        this.r = true;
    }

    public void a(int i, int i2) {
        this.e = i;
        this.f = i2;
        int[] iArr = this.h;
        if (iArr == null || iArr.length < i) {
            this.g = new long[i];
            this.h = new int[i];
        }
        int[] iArr2 = this.i;
        if (iArr2 == null || iArr2.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.i = new int[i3];
            this.j = new int[i3];
            this.k = new long[i3];
            this.l = new boolean[i3];
            this.n = new boolean[i3];
        }
    }

    public void a(com.opos.exoplayer.core.extractor.f fVar) {
        fVar.b(this.q.f8400a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }

    public void a(p pVar) {
        pVar.a(this.q.f8400a, 0, this.p);
        this.q.c(0);
        this.r = false;
    }
}
