package com.opos.exoplayer.core.source;

import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.source.g;
import com.opos.exoplayer.core.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements g, g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f8284a;
    long b;
    long c;
    private g.a d;
    private C0696a[] e = new C0696a[0];
    private long f;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.source.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public final class C0696a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f8285a;
        private boolean c;

        public C0696a(l lVar) {
            this.f8285a = lVar;
        }

        @Override // com.opos.exoplayer.core.source.l
        public int a(long j) {
            if (a.this.f()) {
                return -3;
            }
            return this.f8285a.a(a.this.b + j);
        }

        @Override // com.opos.exoplayer.core.source.l
        public boolean b() {
            return !a.this.f() && this.f8285a.b();
        }

        @Override // com.opos.exoplayer.core.source.l
        public void c() {
            this.f8285a.c();
        }

        @Override // com.opos.exoplayer.core.source.l
        public int a(com.opos.exoplayer.core.j jVar, DecoderInputBuffer decoderInputBuffer, boolean z) {
            if (a.this.f()) {
                return -3;
            }
            if (this.c) {
                decoderInputBuffer.a_(4);
                return -4;
            }
            int iA = this.f8285a.a(jVar, decoderInputBuffer, z);
            if (iA == -5) {
                Format format = jVar.f8252a;
                int i = format.u;
                if (i != -1 || format.v != -1) {
                    a aVar = a.this;
                    if (aVar.b != 0) {
                        i = 0;
                    }
                    jVar.f8252a = format.a(i, aVar.c == Long.MIN_VALUE ? format.v : 0);
                }
                return -5;
            }
            a aVar2 = a.this;
            long j = aVar2.c;
            if (j == Long.MIN_VALUE || ((iA != -4 || decoderInputBuffer.c < j) && !(iA == -3 && aVar2.d() == Long.MIN_VALUE))) {
                if (iA == -4 && !decoderInputBuffer.c()) {
                    decoderInputBuffer.c -= a.this.b;
                }
                return iA;
            }
            decoderInputBuffer.a();
            decoderInputBuffer.a_(4);
            this.c = true;
            return -4;
        }

        public void a() {
            this.c = false;
        }
    }

    public a(g gVar, boolean z) {
        this.f8284a = gVar;
        this.f = z ? 0L : -9223372036854775807L;
        this.b = -9223372036854775807L;
        this.c = -9223372036854775807L;
    }

    @Override // com.opos.exoplayer.core.source.g
    public long a(long j, u uVar) {
        long j2 = this.b;
        if (j == j2) {
            return 0L;
        }
        long j3 = j + j2;
        return this.f8284a.a(j3, b(j3, uVar)) - this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037  */
    @Override // com.opos.exoplayer.core.source.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(long j) {
        this.f = -9223372036854775807L;
        boolean z = false;
        for (C0696a c0696a : this.e) {
            if (c0696a != null) {
                c0696a.a();
            }
        }
        long j2 = j + this.b;
        long jB = this.f8284a.b(j2);
        if (jB == j2) {
            z = true;
        } else if (jB >= this.b) {
            long j3 = this.c;
            if (j3 == Long.MIN_VALUE || jB <= j3) {
            }
        }
        com.opos.exoplayer.core.util.a.b(z);
        return jB - this.b;
    }

    @Override // com.opos.exoplayer.core.source.g
    public long c() {
        if (f()) {
            long j = this.f;
            this.f = -9223372036854775807L;
            long jC = c();
            return jC != -9223372036854775807L ? jC : j;
        }
        long jC2 = this.f8284a.c();
        if (jC2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        com.opos.exoplayer.core.util.a.b(jC2 >= this.b);
        long j2 = this.c;
        if (j2 != Long.MIN_VALUE && jC2 > j2) {
            z = false;
        }
        com.opos.exoplayer.core.util.a.b(z);
        return jC2 - this.b;
    }

    @Override // com.opos.exoplayer.core.source.g
    public void c_() {
        this.f8284a.c_();
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public long d() {
        long jD = this.f8284a.d();
        if (jD != Long.MIN_VALUE) {
            long j = this.c;
            if (j == Long.MIN_VALUE || jD < j) {
                return Math.max(0L, jD - this.b);
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public long e() {
        long jE = this.f8284a.e();
        if (jE != Long.MIN_VALUE) {
            long j = this.c;
            if (j == Long.MIN_VALUE || jE < j) {
                return jE - this.b;
            }
        }
        return Long.MIN_VALUE;
    }

    public boolean f() {
        return this.f != -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    @Override // com.opos.exoplayer.core.source.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(com.opos.exoplayer.core.c.f[] fVarArr, boolean[] zArr, l[] lVarArr, boolean[] zArr2, long j) {
        boolean z;
        this.e = new C0696a[lVarArr.length];
        l[] lVarArr2 = new l[lVarArr.length];
        int i = 0;
        while (true) {
            l lVar = null;
            if (i >= lVarArr.length) {
                break;
            }
            C0696a[] c0696aArr = this.e;
            C0696a c0696a = (C0696a) lVarArr[i];
            c0696aArr[i] = c0696a;
            if (c0696a != null) {
                lVar = c0696a.f8285a;
            }
            lVarArr2[i] = lVar;
            i++;
        }
        long jA = this.f8284a.a(fVarArr, zArr, lVarArr2, zArr2, j + this.b) - this.b;
        this.f = (f() && j == 0 && a(this.b, fVarArr)) ? jA : -9223372036854775807L;
        if (jA == j) {
            z = true;
        } else {
            if (jA >= 0) {
                long j2 = this.c;
                if (j2 == Long.MIN_VALUE || this.b + jA <= j2) {
                }
            }
            z = false;
        }
        com.opos.exoplayer.core.util.a.b(z);
        for (int i2 = 0; i2 < lVarArr.length; i2++) {
            l lVar2 = lVarArr2[i2];
            if (lVar2 == null) {
                this.e[i2] = null;
            } else if (lVarArr[i2] == null || this.e[i2].f8285a != lVar2) {
                this.e[i2] = new C0696a(lVar2);
            }
            lVarArr[i2] = this.e[i2];
        }
        return jA;
    }

    @Override // com.opos.exoplayer.core.source.g
    public p b() {
        return this.f8284a.b();
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public boolean c(long j) {
        return this.f8284a.c(j + this.b);
    }

    private u b(long j, u uVar) {
        long jMin = Math.min(j - this.b, uVar.f);
        long j2 = this.c;
        long jMin2 = j2 == Long.MIN_VALUE ? uVar.g : Math.min(j2 - j, uVar.g);
        return (jMin == uVar.f && jMin2 == uVar.g) ? uVar : new u(jMin, jMin2);
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public void a(long j) {
        this.f8284a.a(j + this.b);
    }

    public void a(long j, long j2) {
        this.b = j;
        this.c = j2;
    }

    @Override // com.opos.exoplayer.core.source.m.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(g gVar) {
        this.d.a(this);
    }

    @Override // com.opos.exoplayer.core.source.g
    public void a(long j, boolean z) {
        this.f8284a.a(j + this.b, z);
    }

    @Override // com.opos.exoplayer.core.source.g
    public void a(g.a aVar, long j) {
        this.d = aVar;
        this.f8284a.a(this, this.b + j);
    }

    @Override // com.opos.exoplayer.core.source.g.a
    public void a(g gVar) {
        com.opos.exoplayer.core.util.a.b((this.b == -9223372036854775807L || this.c == -9223372036854775807L) ? false : true);
        this.d.a((g) this);
    }

    private static boolean a(long j, com.opos.exoplayer.core.c.f[] fVarArr) {
        if (j != 0) {
            for (com.opos.exoplayer.core.c.f fVar : fVarArr) {
                if (fVar != null && !com.opos.exoplayer.core.util.m.a(fVar.f().f)) {
                    return true;
                }
            }
        }
        return false;
    }
}
