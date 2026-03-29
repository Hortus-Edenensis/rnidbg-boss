package com.opos.exoplayer.core;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.exoplayer.core.upstream.i f8154a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final int f;
    private final boolean g;
    private final com.opos.exoplayer.core.util.s h;
    private int i;
    private boolean j;

    public e() {
        this(new com.opos.exoplayer.core.upstream.i(true, 65536));
    }

    public int a(q[] qVarArr, com.opos.exoplayer.core.c.g gVar) {
        int iE = 0;
        for (int i = 0; i < qVarArr.length; i++) {
            if (gVar.a(i) != null) {
                iE += com.opos.exoplayer.core.util.y.e(qVarArr[i].a());
            }
        }
        return iE;
    }

    @Override // com.opos.exoplayer.core.l
    public void b() {
        a(true);
    }

    @Override // com.opos.exoplayer.core.l
    public void c() {
        a(true);
    }

    @Override // com.opos.exoplayer.core.l
    public com.opos.exoplayer.core.upstream.b d() {
        return this.f8154a;
    }

    @Override // com.opos.exoplayer.core.l
    public long e() {
        return 0L;
    }

    @Override // com.opos.exoplayer.core.l
    public boolean f() {
        return false;
    }

    public e(com.opos.exoplayer.core.upstream.i iVar) {
        this(iVar, 15000, 30000, 2500, 5000, -1, true);
    }

    @Override // com.opos.exoplayer.core.l
    public void a() {
        a(false);
    }

    public e(com.opos.exoplayer.core.upstream.i iVar, int i, int i2, int i3, int i4, int i5, boolean z) {
        this(iVar, i, i2, i3, i4, i5, z, null);
    }

    private void a(boolean z) {
        this.i = 0;
        com.opos.exoplayer.core.util.s sVar = this.h;
        if (sVar != null && this.j) {
            sVar.b(0);
        }
        this.j = false;
        if (z) {
            this.f8154a.d();
        }
    }

    public e(com.opos.exoplayer.core.upstream.i iVar, int i, int i2, int i3, int i4, int i5, boolean z, com.opos.exoplayer.core.util.s sVar) {
        this.f8154a = iVar;
        this.b = ((long) i) * 1000;
        this.c = ((long) i2) * 1000;
        this.d = ((long) i3) * 1000;
        this.e = ((long) i4) * 1000;
        this.f = i5;
        this.g = z;
        this.h = sVar;
    }

    @Override // com.opos.exoplayer.core.l
    public void a(q[] qVarArr, com.opos.exoplayer.core.source.p pVar, com.opos.exoplayer.core.c.g gVar) {
        int iA = this.f;
        if (iA == -1) {
            iA = a(qVarArr, gVar);
        }
        this.i = iA;
        this.f8154a.a(iA);
    }

    @Override // com.opos.exoplayer.core.l
    public boolean a(long j, float f) {
        boolean z;
        boolean z2 = true;
        boolean z3 = this.f8154a.e() >= this.i;
        boolean z4 = this.j;
        if (!this.g ? z3 || (j >= this.b && (j > this.c || !z4)) : j >= this.b && (j > this.c || !z4 || z3)) {
            z2 = false;
        }
        this.j = z2;
        com.opos.exoplayer.core.util.s sVar = this.h;
        if (sVar != null && (z = this.j) != z4) {
            if (z) {
                sVar.a(0);
            } else {
                sVar.b(0);
            }
        }
        return this.j;
    }

    @Override // com.opos.exoplayer.core.l
    public boolean a(long j, float f, boolean z) {
        long jB = com.opos.exoplayer.core.util.y.b(j, f);
        long j2 = z ? this.e : this.d;
        return j2 <= 0 || jB >= j2 || (!this.g && this.f8154a.e() >= this.i);
    }
}
