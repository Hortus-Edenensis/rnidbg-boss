package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.e0;
import defpackage.ga5;
import defpackage.vh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class a extends e0 {
    public final int f;
    public final ga5 g;
    public final boolean h;

    public a(boolean z, ga5 ga5Var) {
        this.h = z;
        this.g = ga5Var;
        this.f = ga5Var.getLength();
    }

    public static Object A(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object C(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public static Object z(Object obj) {
        return ((Pair) obj).second;
    }

    public abstract Object B(int i);

    public abstract int D(int i);

    public abstract int E(int i);

    public final int F(int i, boolean z) {
        if (z) {
            return this.g.getNextIndex(i);
        }
        if (i < this.f - 1) {
            return i + 1;
        }
        return -1;
    }

    public final int G(int i, boolean z) {
        if (z) {
            return this.g.getPreviousIndex(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }

    public abstract e0 H(int i);

    @Override // com.google.android.exoplayer2.e0
    public int e(boolean z) {
        if (this.f == 0) {
            return -1;
        }
        if (this.h) {
            z = false;
        }
        int firstIndex = z ? this.g.getFirstIndex() : 0;
        while (H(firstIndex).u()) {
            firstIndex = F(firstIndex, z);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return E(firstIndex) + H(firstIndex).e(z);
    }

    @Override // com.google.android.exoplayer2.e0
    public final int f(Object obj) {
        int iF;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objA = A(obj);
        Object objZ = z(obj);
        int iW = w(objA);
        if (iW == -1 || (iF = H(iW).f(objZ)) == -1) {
            return -1;
        }
        return D(iW) + iF;
    }

    @Override // com.google.android.exoplayer2.e0
    public int g(boolean z) {
        int i = this.f;
        if (i == 0) {
            return -1;
        }
        if (this.h) {
            z = false;
        }
        int lastIndex = z ? this.g.getLastIndex() : i - 1;
        while (H(lastIndex).u()) {
            lastIndex = G(lastIndex, z);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return E(lastIndex) + H(lastIndex).g(z);
    }

    @Override // com.google.android.exoplayer2.e0
    public int i(int i, int i2, boolean z) {
        if (this.h) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int iY = y(i);
        int iE = E(iY);
        int i3 = H(iY).i(i - iE, i2 != 2 ? i2 : 0, z);
        if (i3 != -1) {
            return iE + i3;
        }
        int iF = F(iY, z);
        while (iF != -1 && H(iF).u()) {
            iF = F(iF, z);
        }
        if (iF != -1) {
            return E(iF) + H(iF).e(z);
        }
        if (i2 == 2) {
            return e(z);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.e0
    public final e0.b k(int i, e0.b bVar, boolean z) {
        int iX = x(i);
        int iE = E(iX);
        H(iX).k(i - D(iX), bVar, z);
        bVar.c += iE;
        if (z) {
            bVar.b = C(B(iX), vh.e(bVar.b));
        }
        return bVar;
    }

    @Override // com.google.android.exoplayer2.e0
    public final e0.b l(Object obj, e0.b bVar) {
        Object objA = A(obj);
        Object objZ = z(obj);
        int iW = w(objA);
        int iE = E(iW);
        H(iW).l(objZ, bVar);
        bVar.c += iE;
        bVar.b = obj;
        return bVar;
    }

    @Override // com.google.android.exoplayer2.e0
    public int p(int i, int i2, boolean z) {
        if (this.h) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int iY = y(i);
        int iE = E(iY);
        int iP = H(iY).p(i - iE, i2 != 2 ? i2 : 0, z);
        if (iP != -1) {
            return iE + iP;
        }
        int iG = G(iY, z);
        while (iG != -1 && H(iG).u()) {
            iG = G(iG, z);
        }
        if (iG != -1) {
            return E(iG) + H(iG).g(z);
        }
        if (i2 == 2) {
            return g(z);
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.e0
    public final Object q(int i) {
        int iX = x(i);
        return C(B(iX), H(iX).q(i - D(iX)));
    }

    @Override // com.google.android.exoplayer2.e0
    public final e0.d s(int i, e0.d dVar, long j) {
        int iY = y(i);
        int iE = E(iY);
        int iD = D(iY);
        H(iY).s(i - iE, dVar, j);
        Object objB = B(iY);
        if (!e0.d.r.equals(dVar.f5871a)) {
            objB = C(objB, dVar.f5871a);
        }
        dVar.f5871a = objB;
        dVar.o += iD;
        dVar.p += iD;
        return dVar;
    }

    public abstract int w(Object obj);

    public abstract int x(int i);

    public abstract int y(int i);
}
