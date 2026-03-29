package com.opos.exoplayer.core;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.source.h;
import com.opos.exoplayer.core.w;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w.a f8109a = new w.a();
    private final w.b b = new w.b();
    private long c;
    private w d;
    private int e;
    private boolean f;
    private z g;
    private z h;
    private z i;
    private int j;

    private aa a(int i, int i2, int i3, long j, long j2) {
        h.b bVar = new h.b(i, i2, i3, j2);
        boolean zB = b(bVar, Long.MIN_VALUE);
        boolean zA = a(bVar, zB);
        return new aa(bVar, i3 == this.f8109a.b(i2) ? this.f8109a.e() : 0L, Long.MIN_VALUE, j, this.d.a(bVar.f8292a, this.f8109a).c(bVar.b, bVar.c), zB, zA);
    }

    private long b(int i) {
        Object obj = this.d.a(i, this.f8109a, true).b;
        for (z zVarE = e(); zVarE != null; zVarE = zVarE.i) {
            if (zVarE.b.equals(obj)) {
                return zVarE.h.f8108a.d;
            }
        }
        int i2 = this.f8109a.c;
        for (z zVarE2 = e(); zVarE2 != null; zVarE2 = zVarE2.i) {
            int iA = this.d.a(zVarE2.b);
            if (iA != -1 && this.d.a(iA, this.f8109a).c == i2) {
                return zVarE2.h.f8108a.d;
            }
        }
        long j = this.c;
        this.c = 1 + j;
        return j;
    }

    private boolean j() {
        z zVar;
        z zVarE = e();
        if (zVarE == null) {
            return true;
        }
        while (true) {
            int iA = this.d.a(zVarE.h.f8108a.f8292a, this.f8109a, this.b, this.e, this.f);
            while (true) {
                zVar = zVarE.i;
                if (zVar == null || zVarE.h.f) {
                    break;
                }
                zVarE = zVar;
            }
            if (iA == -1 || zVar == null || zVar.h.f8108a.f8292a != iA) {
                break;
            }
            zVarE = zVar;
        }
        boolean zA = a(zVarE);
        aa aaVar = zVarE.h;
        zVarE.h = a(aaVar, aaVar.f8108a);
        return (zA && f()) ? false : true;
    }

    public z c() {
        return this.g;
    }

    public z d() {
        return this.h;
    }

    public z e() {
        return f() ? this.g : this.i;
    }

    public boolean f() {
        return this.g != null;
    }

    public z g() {
        z zVar = this.h;
        com.opos.exoplayer.core.util.a.b((zVar == null || zVar.i == null) ? false : true);
        z zVar2 = this.h.i;
        this.h = zVar2;
        return zVar2;
    }

    public z h() {
        z zVar = this.g;
        if (zVar != null) {
            if (zVar == this.h) {
                this.h = zVar.i;
            }
            zVar.d();
            this.g = this.g.i;
            int i = this.j - 1;
            this.j = i;
            if (i == 0) {
                this.i = null;
            }
        } else {
            z zVar2 = this.i;
            this.g = zVar2;
            this.h = zVar2;
        }
        return this.g;
    }

    public void i() {
        z zVarE = e();
        if (zVarE != null) {
            zVarE.d();
            a(zVarE);
        }
        this.g = null;
        this.i = null;
        this.h = null;
        this.j = 0;
    }

    private aa b(int i, long j, long j2) {
        h.b bVar = new h.b(i, j2);
        this.d.a(bVar.f8292a, this.f8109a);
        int iB = this.f8109a.b(j);
        long jA = iB == -1 ? Long.MIN_VALUE : this.f8109a.a(iB);
        boolean zB = b(bVar, jA);
        return new aa(bVar, j, jA, -9223372036854775807L, jA == Long.MIN_VALUE ? this.f8109a.a() : jA, zB, a(bVar, zB));
    }

    @Nullable
    public aa a(long j, ac acVar) {
        z zVar = this.i;
        return zVar == null ? a(acVar) : a(zVar, j);
    }

    public aa a(aa aaVar, int i) {
        return a(aaVar, aaVar.f8108a.a(i));
    }

    public z b() {
        return this.i;
    }

    private aa a(aa aaVar, h.b bVar) {
        long j;
        long jA;
        long j2 = aaVar.b;
        long j3 = aaVar.c;
        boolean zB = b(bVar, j3);
        boolean zA = a(bVar, zB);
        this.d.a(bVar.f8292a, this.f8109a);
        if (bVar.a()) {
            jA = this.f8109a.c(bVar.b, bVar.c);
        } else {
            if (j3 != Long.MIN_VALUE) {
                j = j3;
                return new aa(bVar, j2, j3, aaVar.d, j, zB, zA);
            }
            jA = this.f8109a.a();
        }
        j = jA;
        return new aa(bVar, j2, j3, aaVar.d, j, zB, zA);
    }

    private boolean b(h.b bVar, long j) {
        int iD = this.d.a(bVar.f8292a, this.f8109a).d();
        if (iD == 0) {
            return true;
        }
        int i = iD - 1;
        boolean zA = bVar.a();
        if (this.f8109a.a(i) != Long.MIN_VALUE) {
            return !zA && j == Long.MIN_VALUE;
        }
        int iD2 = this.f8109a.d(i);
        if (iD2 == -1) {
            return false;
        }
        if (zA && bVar.b == i && bVar.c == iD2 + (-1)) {
            return true;
        }
        return !zA && this.f8109a.b(i) == iD2;
    }

    private aa a(ac acVar) {
        return a(acVar.c, acVar.e, acVar.d);
    }

    private aa a(h.b bVar, long j, long j2) {
        this.d.a(bVar.f8292a, this.f8109a);
        if (!bVar.a()) {
            return b(bVar.f8292a, j2, bVar.d);
        }
        if (this.f8109a.b(bVar.b, bVar.c)) {
            return a(bVar.f8292a, bVar.b, bVar.c, j, bVar.d);
        }
        return null;
    }

    @Nullable
    private aa a(z zVar, long j) {
        int i;
        long j2;
        long j3;
        aa aaVar = zVar.h;
        if (aaVar.f) {
            int iA = this.d.a(aaVar.f8108a.f8292a, this.f8109a, this.b, this.e, this.f);
            if (iA == -1) {
                return null;
            }
            int i2 = this.d.a(iA, this.f8109a, true).c;
            Object obj = this.f8109a.b;
            long j4 = aaVar.f8108a.d;
            long j5 = 0;
            if (this.d.a(i2, this.b).f == iA) {
                Pair<Integer, Long> pairA = this.d.a(this.b, this.f8109a, i2, -9223372036854775807L, Math.max(0L, (zVar.a() + aaVar.e) - j));
                if (pairA == null) {
                    return null;
                }
                int iIntValue = ((Integer) pairA.first).intValue();
                long jLongValue = ((Long) pairA.second).longValue();
                z zVar2 = zVar.i;
                if (zVar2 == null || !zVar2.b.equals(obj)) {
                    j3 = this.c;
                    this.c = 1 + j3;
                } else {
                    j3 = zVar.i.h.f8108a.d;
                }
                j5 = jLongValue;
                j2 = j3;
                i = iIntValue;
            } else {
                i = iA;
                j2 = j4;
            }
            long j6 = j5;
            return a(a(i, j6, j2), j6, j5);
        }
        h.b bVar = aaVar.f8108a;
        this.d.a(bVar.f8292a, this.f8109a);
        if (bVar.a()) {
            int i3 = bVar.b;
            int iD = this.f8109a.d(i3);
            if (iD == -1) {
                return null;
            }
            int iA2 = this.f8109a.a(i3, bVar.c);
            if (iA2 >= iD) {
                return b(bVar.f8292a, aaVar.d, bVar.d);
            }
            if (this.f8109a.b(i3, iA2)) {
                return a(bVar.f8292a, i3, iA2, aaVar.d, bVar.d);
            }
            return null;
        }
        long j7 = aaVar.c;
        if (j7 != Long.MIN_VALUE) {
            int iA3 = this.f8109a.a(j7);
            if (iA3 == -1) {
                return b(bVar.f8292a, aaVar.c, bVar.d);
            }
            int iB = this.f8109a.b(iA3);
            if (this.f8109a.b(iA3, iB)) {
                return a(bVar.f8292a, iA3, iB, aaVar.c, bVar.d);
            }
            return null;
        }
        int iD2 = this.f8109a.d();
        if (iD2 == 0) {
            return null;
        }
        int i4 = iD2 - 1;
        if (this.f8109a.a(i4) != Long.MIN_VALUE || this.f8109a.c(i4)) {
            return null;
        }
        int iB2 = this.f8109a.b(i4);
        if (!this.f8109a.b(i4, iB2)) {
            return null;
        }
        return a(bVar.f8292a, i4, iB2, this.f8109a.a(), bVar.d);
    }

    public com.opos.exoplayer.core.c.i a(float f) {
        return this.i.a(f);
    }

    public com.opos.exoplayer.core.source.g a(r[] rVarArr, long j, com.opos.exoplayer.core.c.h hVar, com.opos.exoplayer.core.upstream.b bVar, com.opos.exoplayer.core.source.h hVar2, Object obj, aa aaVar) {
        z zVar = this.i;
        z zVar2 = new z(rVarArr, zVar == null ? aaVar.b + j : zVar.a() + this.i.h.e, hVar, bVar, hVar2, obj, aaVar);
        if (this.i != null) {
            com.opos.exoplayer.core.util.a.b(f());
            this.i.i = zVar2;
        }
        this.i = zVar2;
        this.j++;
        return zVar2.f8441a;
    }

    public h.b a(int i, long j) {
        return a(i, j, b(i));
    }

    private h.b a(int i, long j, long j2) {
        this.d.a(i, this.f8109a);
        int iA = this.f8109a.a(j);
        return iA == -1 ? new h.b(i, j2) : new h.b(i, iA, this.f8109a.b(iA), j2);
    }

    public void a(long j) {
        z zVar = this.i;
        if (zVar != null) {
            zVar.c(j);
        }
    }

    public void a(w wVar) {
        this.d = wVar;
    }

    public boolean a() {
        z zVar = this.i;
        return zVar == null || (!zVar.h.g && zVar.b() && this.i.h.e != -9223372036854775807L && this.j < 100);
    }

    public boolean a(int i) {
        this.e = i;
        return j();
    }

    public boolean a(com.opos.exoplayer.core.source.g gVar) {
        z zVar = this.i;
        return zVar != null && zVar.f8441a == gVar;
    }

    public boolean a(h.b bVar, long j) {
        aa aaVarA;
        int i = bVar.f8292a;
        z zVar = null;
        int iA = i;
        for (z zVarE = e(); zVarE != null; zVarE = zVarE.i) {
            if (zVar != null) {
                if (iA != -1 && zVarE.b.equals(this.d.a(iA, this.f8109a, true).b) && (aaVarA = a(zVar, j)) != null) {
                    zVarE.h = a(zVarE.h, iA);
                    if (!a(zVarE, aaVarA)) {
                    }
                }
                return true ^ a(zVar);
            }
            zVarE.h = a(zVarE.h, iA);
            if (zVarE.h.f) {
                iA = this.d.a(iA, this.f8109a, this.b, this.e, this.f);
            }
            zVar = zVarE;
        }
        return true;
    }

    private boolean a(h.b bVar, boolean z) {
        return !this.d.a(this.d.a(bVar.f8292a, this.f8109a).c, this.b).e && this.d.b(bVar.f8292a, this.f8109a, this.b, this.e, this.f) && z;
    }

    public boolean a(z zVar) {
        boolean z = false;
        com.opos.exoplayer.core.util.a.b(zVar != null);
        this.i = zVar;
        while (true) {
            zVar = zVar.i;
            if (zVar == null) {
                this.i.i = null;
                return z;
            }
            if (zVar == this.h) {
                this.h = this.g;
                z = true;
            }
            zVar.d();
            this.j--;
        }
    }

    private boolean a(z zVar, aa aaVar) {
        aa aaVar2 = zVar.h;
        return aaVar2.b == aaVar.b && aaVar2.c == aaVar.c && aaVar2.f8108a.equals(aaVar.f8108a);
    }

    public boolean a(boolean z) {
        this.f = z;
        return j();
    }
}
