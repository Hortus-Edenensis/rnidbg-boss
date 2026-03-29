package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import defpackage.j26;
import defpackage.ot3;
import java.util.Collections;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class mf2 implements gl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d55 f19205a;
    public String b;
    public c06 c;
    public a d;
    public boolean e;
    public long l;
    public final boolean[] f = new boolean[3];
    public final nt3 g = new nt3(32, 128);
    public final nt3 h = new nt3(33, 128);
    public final nt3 i = new nt3(34, 128);
    public final nt3 j = new nt3(39, 128);
    public final nt3 k = new nt3(40, 128);
    public long m = -9223372036854775807L;
    public final gc4 n = new gc4();

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c06 f19206a;
        public long b;
        public boolean c;
        public int d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public a(c06 c06Var) {
            this.f19206a = c06Var;
        }

        public static boolean b(int i) {
            return (32 <= i && i <= 35) || i == 39;
        }

        public static boolean c(int i) {
            return i < 32 || i == 40;
        }

        public void a(long j, int i, boolean z) {
            if (this.j && this.g) {
                this.m = this.c;
                this.j = false;
            } else if (this.h || this.g) {
                if (z && this.i) {
                    d(i + ((int) (j - this.b)));
                }
                this.k = this.b;
                this.l = this.e;
                this.m = this.c;
                this.i = true;
            }
        }

        public final void d(int i) {
            long j = this.l;
            if (j == -9223372036854775807L) {
                return;
            }
            boolean z = this.m;
            this.f19206a.e(j, z ? 1 : 0, (int) (this.b - this.k), i, null);
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.f) {
                int i3 = this.d;
                int i4 = (i + 2) - i3;
                if (i4 >= i2) {
                    this.d = i3 + (i2 - i);
                } else {
                    this.g = (bArr[i4] & ByteCompanionObject.MIN_VALUE) != 0;
                    this.f = false;
                }
            }
        }

        public void f() {
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public void g(long j, int i, int i2, long j2, boolean z) {
            this.g = false;
            this.h = false;
            this.e = j2;
            this.d = 0;
            this.b = j;
            if (!c(i2)) {
                if (this.i && !this.j) {
                    if (z) {
                        d(i);
                    }
                    this.i = false;
                }
                if (b(i2)) {
                    this.h = !this.j;
                    this.j = true;
                }
            }
            boolean z2 = i2 >= 16 && i2 <= 21;
            this.c = z2;
            this.f = z2 || i2 <= 9;
        }
    }

    public mf2(d55 d55Var) {
        this.f19205a = d55Var;
    }

    public static m f(@Nullable String str, nt3 nt3Var, nt3 nt3Var2, nt3 nt3Var3) {
        int i = nt3Var.e;
        byte[] bArr = new byte[nt3Var2.e + i + nt3Var3.e];
        System.arraycopy(nt3Var.d, 0, bArr, 0, i);
        System.arraycopy(nt3Var2.d, 0, bArr, nt3Var.e, nt3Var2.e);
        System.arraycopy(nt3Var3.d, 0, bArr, nt3Var.e + nt3Var2.e, nt3Var3.e);
        ot3.a aVarH = ot3.h(nt3Var2.d, 3, nt3Var2.e);
        return new m.b().U(str).g0("video/hevc").K(ee0.c(aVarH.f19870a, aVarH.b, aVarH.c, aVarH.d, aVarH.h, aVarH.i)).n0(aVarH.k).S(aVarH.l).c0(aVarH.m).V(Collections.singletonList(bArr)).G();
    }

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) {
        c();
        while (gc4Var.a() > 0) {
            int iF = gc4Var.f();
            int iG = gc4Var.g();
            byte[] bArrE = gc4Var.e();
            this.l += (long) gc4Var.a();
            this.c.d(gc4Var, gc4Var.a());
            while (iF < iG) {
                int iC = ot3.c(bArrE, iF, iG, this.f);
                if (iC == iG) {
                    e(bArrE, iF, iG);
                    return;
                }
                int iE = ot3.e(bArrE, iC);
                int i = iC - iF;
                if (i > 0) {
                    e(bArrE, iF, iC);
                }
                int i2 = iG - iC;
                long j = this.l - ((long) i2);
                d(j, i2, i < 0 ? -i : 0, this.m);
                g(j, i2, iE, this.m);
                iF = iC + 3;
            }
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        this.b = dVar.b();
        c06 c06VarTrack = qs1Var.track(dVar.c(), 2);
        this.c = c06VarTrack;
        this.d = new a(c06VarTrack);
        this.f19205a.b(qs1Var, dVar);
    }

    public final void c() {
        vh.i(this.c);
        g86.j(this.d);
    }

    public final void d(long j, int i, int i2, long j2) {
        this.d.a(j, i, this.e);
        if (!this.e) {
            this.g.b(i2);
            this.h.b(i2);
            this.i.b(i2);
            if (this.g.c() && this.h.c() && this.i.c()) {
                this.c.b(f(this.b, this.g, this.h, this.i));
                this.e = true;
            }
        }
        if (this.j.b(i2)) {
            nt3 nt3Var = this.j;
            this.n.S(this.j.d, ot3.q(nt3Var.d, nt3Var.e));
            this.n.V(5);
            this.f19205a.a(j2, this.n);
        }
        if (this.k.b(i2)) {
            nt3 nt3Var2 = this.k;
            this.n.S(this.k.d, ot3.q(nt3Var2.d, nt3Var2.e));
            this.n.V(5);
            this.f19205a.a(j2, this.n);
        }
    }

    public final void e(byte[] bArr, int i, int i2) {
        this.d.e(bArr, i, i2);
        if (!this.e) {
            this.g.a(bArr, i, i2);
            this.h.a(bArr, i, i2);
            this.i.a(bArr, i, i2);
        }
        this.j.a(bArr, i, i2);
        this.k.a(bArr, i, i2);
    }

    public final void g(long j, int i, int i2, long j2) {
        this.d.g(j, i, i2, j2, this.e);
        if (!this.e) {
            this.g.e(i2);
            this.h.e(i2);
            this.i.e(i2);
        }
        this.j.e(i2);
        this.k.e(i2);
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
    }

    @Override // defpackage.gl1
    public void seek() {
        this.l = 0L;
        this.m = -9223372036854775807L;
        ot3.a(this.f);
        this.g.d();
        this.h.d();
        this.i.d();
        this.j.d();
        this.k.d();
        a aVar = this.d;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
