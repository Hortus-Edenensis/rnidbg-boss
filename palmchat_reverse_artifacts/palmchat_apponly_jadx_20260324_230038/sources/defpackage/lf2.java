package defpackage;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import defpackage.j26;
import defpackage.ot3;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class lf2 implements gl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d55 f18968a;
    public final boolean b;
    public final boolean c;
    public long g;
    public String i;
    public c06 j;
    public b k;
    public boolean l;
    public boolean n;
    public final boolean[] h = new boolean[3];
    public final nt3 d = new nt3(7, 128);
    public final nt3 e = new nt3(8, 128);
    public final nt3 f = new nt3(6, 128);
    public long m = -9223372036854775807L;
    public final gc4 o = new gc4();

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c06 f18969a;
        public final boolean b;
        public final boolean c;
        public final SparseArray<ot3.c> d = new SparseArray<>();
        public final SparseArray<ot3.b> e = new SparseArray<>();
        public final hc4 f;
        public byte[] g;
        public int h;
        public int i;
        public long j;
        public boolean k;
        public long l;
        public a m;
        public a n;
        public boolean o;
        public long p;
        public long q;
        public boolean r;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f18970a;
            public boolean b;

            @Nullable
            public ot3.c c;
            public int d;
            public int e;
            public int f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public a() {
            }

            public void b() {
                this.b = false;
                this.f18970a = false;
            }

            public final boolean c(a aVar) {
                int i;
                int i2;
                int i3;
                boolean z;
                if (!this.f18970a) {
                    return false;
                }
                if (!aVar.f18970a) {
                    return true;
                }
                ot3.c cVar = (ot3.c) vh.i(this.c);
                ot3.c cVar2 = (ot3.c) vh.i(aVar.c);
                return (this.f == aVar.f && this.g == aVar.g && this.h == aVar.h && (!this.i || !aVar.i || this.j == aVar.j) && (((i = this.d) == (i2 = aVar.d) || (i != 0 && i2 != 0)) && (((i3 = cVar.l) != 0 || cVar2.l != 0 || (this.m == aVar.m && this.n == aVar.n)) && ((i3 != 1 || cVar2.l != 1 || (this.o == aVar.o && this.p == aVar.p)) && (z = this.k) == aVar.k && (!z || this.l == aVar.l))))) ? false : true;
            }

            public boolean d() {
                int i;
                return this.b && ((i = this.e) == 7 || i == 2);
            }

            public void e(ot3.c cVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.c = cVar;
                this.d = i;
                this.e = i2;
                this.f = i3;
                this.g = i4;
                this.h = z;
                this.i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i5;
                this.m = i6;
                this.n = i7;
                this.o = i8;
                this.p = i9;
                this.f18970a = true;
                this.b = true;
            }

            public void f(int i) {
                this.e = i;
                this.b = true;
            }
        }

        public b(c06 c06Var, boolean z, boolean z2) {
            this.f18969a = c06Var;
            this.b = z;
            this.c = z2;
            this.m = new a();
            this.n = new a();
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new hc4(bArr, 0, 0);
            g();
        }

        /* JADX WARN: Removed duplicated region for block: B:53:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0118  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x014e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(byte[] bArr, int i, int i2) {
            boolean z;
            boolean z2;
            boolean zD;
            boolean z3;
            int iH;
            int i3;
            int i4;
            int i5;
            int iG;
            int iG2;
            if (this.k) {
                int i6 = i2 - i;
                byte[] bArr2 = this.g;
                int length = bArr2.length;
                int i7 = this.h;
                if (length < i7 + i6) {
                    this.g = Arrays.copyOf(bArr2, (i7 + i6) * 2);
                }
                System.arraycopy(bArr, i, this.g, this.h, i6);
                int i8 = this.h + i6;
                this.h = i8;
                this.f.i(this.g, 0, i8);
                if (this.f.b(8)) {
                    this.f.k();
                    int iE = this.f.e(2);
                    this.f.l(5);
                    if (this.f.c()) {
                        this.f.h();
                        if (this.f.c()) {
                            int iH2 = this.f.h();
                            if (!this.c) {
                                this.k = false;
                                this.n.f(iH2);
                                return;
                            }
                            if (this.f.c()) {
                                int iH3 = this.f.h();
                                if (this.e.indexOfKey(iH3) < 0) {
                                    this.k = false;
                                    return;
                                }
                                ot3.b bVar = this.e.get(iH3);
                                ot3.c cVar = this.d.get(bVar.b);
                                if (cVar.i) {
                                    if (!this.f.b(2)) {
                                        return;
                                    } else {
                                        this.f.l(2);
                                    }
                                }
                                if (this.f.b(cVar.k)) {
                                    int iE2 = this.f.e(cVar.k);
                                    if (cVar.j) {
                                        z = false;
                                    } else {
                                        if (!this.f.b(1)) {
                                            return;
                                        }
                                        boolean zD2 = this.f.d();
                                        if (zD2) {
                                            if (this.f.b(1)) {
                                                z = zD2;
                                                zD = this.f.d();
                                                z2 = true;
                                                z3 = this.i != 5;
                                                if (z3) {
                                                    iH = 0;
                                                } else if (!this.f.c()) {
                                                    return;
                                                } else {
                                                    iH = this.f.h();
                                                }
                                                i3 = cVar.l;
                                                if (i3 != 0) {
                                                    if (!this.f.b(cVar.m)) {
                                                        return;
                                                    }
                                                    int iE3 = this.f.e(cVar.m);
                                                    if (bVar.c && !z) {
                                                        if (this.f.c()) {
                                                            iG = this.f.g();
                                                            i4 = iE3;
                                                            i5 = 0;
                                                            iG2 = 0;
                                                            this.n.e(cVar, iE, iH2, iE2, iH3, z, z2, zD, z3, iH, i4, iG, i5, iG2);
                                                            this.k = false;
                                                        }
                                                        return;
                                                    }
                                                    i4 = iE3;
                                                } else {
                                                    if (i3 == 1 && !cVar.n) {
                                                        if (this.f.c()) {
                                                            int iG3 = this.f.g();
                                                            if (!bVar.c || z) {
                                                                i5 = iG3;
                                                                i4 = 0;
                                                                iG = 0;
                                                                iG2 = 0;
                                                                this.n.e(cVar, iE, iH2, iE2, iH3, z, z2, zD, z3, iH, i4, iG, i5, iG2);
                                                                this.k = false;
                                                            }
                                                            if (this.f.c()) {
                                                                iG2 = this.f.g();
                                                                i5 = iG3;
                                                                i4 = 0;
                                                                iG = 0;
                                                                this.n.e(cVar, iE, iH2, iE2, iH3, z, z2, zD, z3, iH, i4, iG, i5, iG2);
                                                                this.k = false;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    i4 = 0;
                                                }
                                                iG = 0;
                                                i5 = 0;
                                                iG2 = 0;
                                                this.n.e(cVar, iE, iH2, iE2, iH3, z, z2, zD, z3, iH, i4, iG, i5, iG2);
                                                this.k = false;
                                            }
                                            return;
                                        }
                                        z = zD2;
                                    }
                                    z2 = false;
                                    zD = false;
                                    if (this.i != 5) {
                                    }
                                    if (z3) {
                                    }
                                    i3 = cVar.l;
                                    if (i3 != 0) {
                                    }
                                    iG = 0;
                                    i5 = 0;
                                    iG2 = 0;
                                    this.n.e(cVar, iE, iH2, iE2, iH3, z, z2, zD, z3, iH, i4, iG, i5, iG2);
                                    this.k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean b(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.i == 9 || (this.c && this.n.c(this.m))) {
                if (z && this.o) {
                    d(i + ((int) (j - this.j)));
                }
                this.p = this.j;
                this.q = this.l;
                this.r = false;
                this.o = true;
            }
            if (this.b) {
                z2 = this.n.d();
            }
            boolean z4 = this.r;
            int i2 = this.i;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.r = z5;
            return z5;
        }

        public boolean c() {
            return this.c;
        }

        public final void d(int i) {
            long j = this.q;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.r;
            this.f18969a.e(j, z ? 1 : 0, (int) (this.j - this.p), i, null);
        }

        public void e(ot3.b bVar) {
            this.e.append(bVar.f19871a, bVar);
        }

        public void f(ot3.c cVar) {
            this.d.append(cVar.d, cVar);
        }

        public void g() {
            this.k = false;
            this.o = false;
            this.n.b();
        }

        public void h(long j, int i, long j2) {
            this.i = i;
            this.l = j2;
            this.j = j;
            if (!this.b || i != 1) {
                if (!this.c) {
                    return;
                }
                if (i != 5 && i != 1 && i != 2) {
                    return;
                }
            }
            a aVar = this.m;
            this.m = this.n;
            this.n = aVar;
            aVar.b();
            this.h = 0;
            this.k = true;
        }
    }

    public lf2(d55 d55Var, boolean z, boolean z2) {
        this.f18968a = d55Var;
        this.b = z;
        this.c = z2;
    }

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) {
        c();
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        byte[] bArrE = gc4Var.e();
        this.g += (long) gc4Var.a();
        this.j.d(gc4Var, gc4Var.a());
        while (true) {
            int iC = ot3.c(bArrE, iF, iG, this.h);
            if (iC == iG) {
                e(bArrE, iF, iG);
                return;
            }
            int iF2 = ot3.f(bArrE, iC);
            int i = iC - iF;
            if (i > 0) {
                e(bArrE, iF, iC);
            }
            int i2 = iG - iC;
            long j = this.g - ((long) i2);
            d(j, i2, i < 0 ? -i : 0, this.m);
            f(j, iF2, this.m);
            iF = iC + 3;
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        this.i = dVar.b();
        c06 c06VarTrack = qs1Var.track(dVar.c(), 2);
        this.j = c06VarTrack;
        this.k = new b(c06VarTrack, this.b, this.c);
        this.f18968a.b(qs1Var, dVar);
    }

    public final void c() {
        vh.i(this.j);
        g86.j(this.k);
    }

    public final void d(long j, int i, int i2, long j2) {
        if (!this.l || this.k.c()) {
            this.d.b(i2);
            this.e.b(i2);
            if (this.l) {
                if (this.d.c()) {
                    nt3 nt3Var = this.d;
                    this.k.f(ot3.l(nt3Var.d, 3, nt3Var.e));
                    this.d.d();
                } else if (this.e.c()) {
                    nt3 nt3Var2 = this.e;
                    this.k.e(ot3.j(nt3Var2.d, 3, nt3Var2.e));
                    this.e.d();
                }
            } else if (this.d.c() && this.e.c()) {
                ArrayList arrayList = new ArrayList();
                nt3 nt3Var3 = this.d;
                arrayList.add(Arrays.copyOf(nt3Var3.d, nt3Var3.e));
                nt3 nt3Var4 = this.e;
                arrayList.add(Arrays.copyOf(nt3Var4.d, nt3Var4.e));
                nt3 nt3Var5 = this.d;
                ot3.c cVarL = ot3.l(nt3Var5.d, 3, nt3Var5.e);
                nt3 nt3Var6 = this.e;
                ot3.b bVarJ = ot3.j(nt3Var6.d, 3, nt3Var6.e);
                this.j.b(new m.b().U(this.i).g0("video/avc").K(ee0.a(cVarL.f19872a, cVarL.b, cVarL.c)).n0(cVarL.f).S(cVarL.g).c0(cVarL.h).V(arrayList).G());
                this.l = true;
                this.k.f(cVarL);
                this.k.e(bVarJ);
                this.d.d();
                this.e.d();
            }
        }
        if (this.f.b(i2)) {
            nt3 nt3Var7 = this.f;
            this.o.S(this.f.d, ot3.q(nt3Var7.d, nt3Var7.e));
            this.o.U(4);
            this.f18968a.a(j2, this.o);
        }
        if (this.k.b(j, i, this.l, this.n)) {
            this.n = false;
        }
    }

    public final void e(byte[] bArr, int i, int i2) {
        if (!this.l || this.k.c()) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    public final void f(long j, int i, long j2) {
        if (!this.l || this.k.c()) {
            this.d.e(i);
            this.e.e(i);
        }
        this.f.e(i);
        this.k.h(j, i, j2);
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
        this.n |= (i & 2) != 0;
    }

    @Override // defpackage.gl1
    public void seek() {
        this.g = 0L;
        this.n = false;
        this.m = -9223372036854775807L;
        ot3.a(this.h);
        this.d.d();
        this.e.d();
        this.f.d();
        b bVar = this.k;
        if (bVar != null) {
            bVar.g();
        }
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
