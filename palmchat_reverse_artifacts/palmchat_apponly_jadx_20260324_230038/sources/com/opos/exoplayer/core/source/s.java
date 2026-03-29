package com.opos.exoplayer.core.source;

import com.opos.exoplayer.core.source.g;
import com.opos.exoplayer.core.u;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class s implements g, g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g[] f8312a;
    private final IdentityHashMap<l, Integer> b = new IdentityHashMap<>();
    private final c c;
    private g.a d;
    private int e;
    private p f;
    private g[] g;
    private m h;

    public s(c cVar, g... gVarArr) {
        this.c = cVar;
        this.f8312a = gVarArr;
    }

    @Override // com.opos.exoplayer.core.source.g
    public long a(long j, u uVar) {
        return this.g[0].a(j, uVar);
    }

    @Override // com.opos.exoplayer.core.source.g
    public long b(long j) {
        long jB = this.g[0].b(j);
        int i = 1;
        while (true) {
            g[] gVarArr = this.g;
            if (i >= gVarArr.length) {
                return jB;
            }
            if (gVarArr[i].b(jB) != jB) {
                throw new IllegalStateException("Children seeked to different positions");
            }
            i++;
        }
    }

    @Override // com.opos.exoplayer.core.source.g
    public long c() {
        long jC = this.f8312a[0].c();
        int i = 1;
        while (true) {
            g[] gVarArr = this.f8312a;
            if (i >= gVarArr.length) {
                if (jC != -9223372036854775807L) {
                    for (g gVar : this.g) {
                        if (gVar != this.f8312a[0] && gVar.b(jC) != jC) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return jC;
            }
            if (gVarArr[i].c() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
            i++;
        }
    }

    @Override // com.opos.exoplayer.core.source.g
    public void c_() {
        for (g gVar : this.f8312a) {
            gVar.c_();
        }
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public long d() {
        return this.h.d();
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public long e() {
        return this.h.e();
    }

    @Override // com.opos.exoplayer.core.source.g
    public long a(com.opos.exoplayer.core.c.f[] fVarArr, boolean[] zArr, l[] lVarArr, boolean[] zArr2, long j) {
        l[] lVarArr2 = lVarArr;
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        for (int i = 0; i < fVarArr.length; i++) {
            l lVar = lVarArr2[i];
            iArr[i] = lVar == null ? -1 : this.b.get(lVar).intValue();
            iArr2[i] = -1;
            com.opos.exoplayer.core.c.f fVar = fVarArr[i];
            if (fVar != null) {
                o oVarD = fVar.d();
                int i2 = 0;
                while (true) {
                    g[] gVarArr = this.f8312a;
                    if (i2 >= gVarArr.length) {
                        break;
                    }
                    if (gVarArr[i2].b().a(oVarD) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.b.clear();
        int length = fVarArr.length;
        l[] lVarArr3 = new l[length];
        l[] lVarArr4 = new l[fVarArr.length];
        com.opos.exoplayer.core.c.f[] fVarArr2 = new com.opos.exoplayer.core.c.f[fVarArr.length];
        ArrayList arrayList = new ArrayList(this.f8312a.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.f8312a.length) {
            for (int i4 = 0; i4 < fVarArr.length; i4++) {
                com.opos.exoplayer.core.c.f fVar2 = null;
                lVarArr4[i4] = iArr[i4] == i3 ? lVarArr2[i4] : null;
                if (iArr2[i4] == i3) {
                    fVar2 = fVarArr[i4];
                }
                fVarArr2[i4] = fVar2;
            }
            int i5 = i3;
            com.opos.exoplayer.core.c.f[] fVarArr3 = fVarArr2;
            ArrayList arrayList2 = arrayList;
            long jA = this.f8312a[i3].a(fVarArr2, zArr, lVarArr4, zArr2, j2);
            if (i5 == 0) {
                j2 = jA;
            } else if (jA != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < fVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    com.opos.exoplayer.core.util.a.b(lVarArr4[i6] != null);
                    lVarArr3[i6] = lVarArr4[i6];
                    this.b.put(lVarArr4[i6], Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    com.opos.exoplayer.core.util.a.b(lVarArr4[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(this.f8312a[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            fVarArr2 = fVarArr3;
            lVarArr2 = lVarArr;
        }
        l[] lVarArr5 = lVarArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(lVarArr3, 0, lVarArr5, 0, length);
        g[] gVarArr2 = new g[arrayList3.size()];
        this.g = gVarArr2;
        arrayList3.toArray(gVarArr2);
        this.h = this.c.a(this.g);
        return j2;
    }

    @Override // com.opos.exoplayer.core.source.g
    public p b() {
        return this.f;
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public boolean c(long j) {
        return this.h.c(j);
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public void a(long j) {
        this.h.a(j);
    }

    @Override // com.opos.exoplayer.core.source.m.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(g gVar) {
        if (this.f == null) {
            return;
        }
        this.d.a(this);
    }

    @Override // com.opos.exoplayer.core.source.g
    public void a(long j, boolean z) {
        for (g gVar : this.g) {
            gVar.a(j, z);
        }
    }

    @Override // com.opos.exoplayer.core.source.g
    public void a(g.a aVar, long j) {
        this.d = aVar;
        g[] gVarArr = this.f8312a;
        this.e = gVarArr.length;
        for (g gVar : gVarArr) {
            gVar.a(this, j);
        }
    }

    @Override // com.opos.exoplayer.core.source.g.a
    public void a(g gVar) {
        int i = this.e - 1;
        this.e = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (g gVar2 : this.f8312a) {
            i2 += gVar2.b().b;
        }
        o[] oVarArr = new o[i2];
        int i3 = 0;
        for (g gVar3 : this.f8312a) {
            p pVarB = gVar3.b();
            int i4 = pVarB.b;
            int i5 = 0;
            while (i5 < i4) {
                oVarArr[i3] = pVarB.a(i5);
                i5++;
                i3++;
            }
        }
        this.f = new p(oVarArr);
        this.d.a((g) this);
    }
}
