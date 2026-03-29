package com.opos.exoplayer.core;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.exoplayer.core.source.g f8441a;
    public final Object b;
    public final com.opos.exoplayer.core.source.l[] c;
    public final boolean[] d;
    public long e;
    public boolean f;
    public boolean g;
    public aa h;
    public z i;
    public com.opos.exoplayer.core.c.i j;
    private final r[] k;
    private final com.opos.exoplayer.core.c.h l;
    private final com.opos.exoplayer.core.source.h m;
    private com.opos.exoplayer.core.c.i n;

    public z(r[] rVarArr, long j, com.opos.exoplayer.core.c.h hVar, com.opos.exoplayer.core.upstream.b bVar, com.opos.exoplayer.core.source.h hVar2, Object obj, aa aaVar) {
        this.k = rVarArr;
        this.e = j - aaVar.b;
        this.l = hVar;
        this.m = hVar2;
        this.b = com.opos.exoplayer.core.util.a.a(obj);
        this.h = aaVar;
        this.c = new com.opos.exoplayer.core.source.l[rVarArr.length];
        this.d = new boolean[rVarArr.length];
        com.opos.exoplayer.core.source.g gVarA = hVar2.a(aaVar.f8108a, bVar);
        if (aaVar.c != Long.MIN_VALUE) {
            com.opos.exoplayer.core.source.a aVar = new com.opos.exoplayer.core.source.a(gVarA, true);
            aVar.a(0L, aaVar.c);
            gVarA = aVar;
        }
        this.f8441a = gVarA;
    }

    public long a() {
        return this.e;
    }

    public long b(long j) {
        return j - a();
    }

    public long c() {
        if (this.f) {
            return this.f8441a.e();
        }
        return 0L;
    }

    public void d() {
        com.opos.exoplayer.core.source.h hVar;
        com.opos.exoplayer.core.source.g gVar;
        a((com.opos.exoplayer.core.c.i) null);
        try {
            if (this.h.c != Long.MIN_VALUE) {
                hVar = this.m;
                gVar = ((com.opos.exoplayer.core.source.a) this.f8441a).f8284a;
            } else {
                hVar = this.m;
                gVar = this.f8441a;
            }
            hVar.a(gVar);
        } catch (RuntimeException e) {
            com.opos.cmn.an.f.a.d("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    private void b(com.opos.exoplayer.core.c.i iVar) {
        int i = 0;
        while (true) {
            boolean[] zArr = iVar.b;
            if (i >= zArr.length) {
                return;
            }
            boolean z = zArr[i];
            com.opos.exoplayer.core.c.f fVarA = iVar.c.a(i);
            if (z && fVarA != null) {
                fVarA.a();
            }
            i++;
        }
    }

    public long a(long j) {
        return j + a();
    }

    public void c(long j) {
        if (this.f) {
            this.f8441a.a(b(j));
        }
    }

    public void d(long j) {
        this.f8441a.c(b(j));
    }

    private void b(com.opos.exoplayer.core.source.l[] lVarArr) {
        int i = 0;
        while (true) {
            r[] rVarArr = this.k;
            if (i >= rVarArr.length) {
                return;
            }
            if (rVarArr[i].a() == 5 && this.j.b[i]) {
                lVarArr[i] = new com.opos.exoplayer.core.source.d();
            }
            i++;
        }
    }

    private void c(com.opos.exoplayer.core.c.i iVar) {
        int i = 0;
        while (true) {
            boolean[] zArr = iVar.b;
            if (i >= zArr.length) {
                return;
            }
            boolean z = zArr[i];
            com.opos.exoplayer.core.c.f fVarA = iVar.c.a(i);
            if (z && fVarA != null) {
                fVarA.c();
            }
            i++;
        }
    }

    public long a(long j, boolean z) {
        return a(j, z, new boolean[this.k.length]);
    }

    public long a(long j, boolean z, boolean[] zArr) {
        com.opos.exoplayer.core.c.g gVar = this.j.c;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= gVar.f8127a) {
                break;
            }
            boolean[] zArr2 = this.d;
            if (z || !this.j.a(this.n, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        a(this.c);
        a(this.j);
        long jA = this.f8441a.a(gVar.a(), this.d, this.c, zArr, j);
        b(this.c);
        this.g = false;
        int i2 = 0;
        while (true) {
            com.opos.exoplayer.core.source.l[] lVarArr = this.c;
            if (i2 >= lVarArr.length) {
                return jA;
            }
            if (lVarArr[i2] != null) {
                com.opos.exoplayer.core.util.a.b(this.j.b[i2]);
                if (this.k[i2].a() != 5) {
                    this.g = true;
                }
            } else {
                com.opos.exoplayer.core.util.a.b(gVar.a(i2) == null);
            }
            i2++;
        }
    }

    public boolean b() {
        return this.f && (!this.g || this.f8441a.d() == Long.MIN_VALUE);
    }

    public long a(boolean z) {
        if (!this.f) {
            return this.h.b;
        }
        long jD = this.f8441a.d();
        return (jD == Long.MIN_VALUE && z) ? this.h.e : jD;
    }

    public boolean b(float f) {
        com.opos.exoplayer.core.c.i iVarA = this.l.a(this.k, this.f8441a.b());
        if (iVarA.a(this.n)) {
            return false;
        }
        this.j = iVarA;
        for (com.opos.exoplayer.core.c.f fVar : iVarA.c.a()) {
            if (fVar != null) {
                fVar.a(f);
            }
        }
        return true;
    }

    public com.opos.exoplayer.core.c.i a(float f) {
        this.f = true;
        b(f);
        long jA = a(this.h.b, false);
        long j = this.e;
        aa aaVar = this.h;
        this.e = j + (aaVar.b - jA);
        this.h = aaVar.a(jA);
        return this.j;
    }

    private void a(com.opos.exoplayer.core.c.i iVar) {
        com.opos.exoplayer.core.c.i iVar2 = this.n;
        if (iVar2 != null) {
            c(iVar2);
        }
        this.n = iVar;
        if (iVar != null) {
            b(iVar);
        }
    }

    private void a(com.opos.exoplayer.core.source.l[] lVarArr) {
        int i = 0;
        while (true) {
            r[] rVarArr = this.k;
            if (i >= rVarArr.length) {
                return;
            }
            if (rVarArr[i].a() == 5) {
                lVarArr[i] = null;
            }
            i++;
        }
    }
}
