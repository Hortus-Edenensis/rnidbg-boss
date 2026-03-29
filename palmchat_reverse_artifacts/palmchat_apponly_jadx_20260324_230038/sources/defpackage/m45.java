package defpackage;

import defpackage.j26;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class m45 implements j26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l45 f19137a;
    public final gc4 b = new gc4(32);
    public int c;
    public int d;
    public boolean e;
    public boolean f;

    public m45(l45 l45Var) {
        this.f19137a = l45Var;
    }

    @Override // defpackage.j26
    public void a(gc4 gc4Var, int i) {
        boolean z = (i & 1) != 0;
        int iF = z ? gc4Var.f() + gc4Var.H() : -1;
        if (this.f) {
            if (!z) {
                return;
            }
            this.f = false;
            gc4Var.U(iF);
            this.d = 0;
        }
        while (gc4Var.a() > 0) {
            int i2 = this.d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int iH = gc4Var.H();
                    gc4Var.U(gc4Var.f() - 1);
                    if (iH == 255) {
                        this.f = true;
                        return;
                    }
                }
                int iMin = Math.min(gc4Var.a(), 3 - this.d);
                gc4Var.l(this.b.e(), this.d, iMin);
                int i3 = this.d + iMin;
                this.d = i3;
                if (i3 == 3) {
                    this.b.U(0);
                    this.b.T(3);
                    this.b.V(1);
                    int iH2 = this.b.H();
                    int iH3 = this.b.H();
                    this.e = (iH2 & 128) != 0;
                    this.c = (((iH2 & 15) << 8) | iH3) + 3;
                    int iB = this.b.b();
                    int i4 = this.c;
                    if (iB < i4) {
                        this.b.c(Math.min(4098, Math.max(i4, this.b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(gc4Var.a(), this.c - this.d);
                gc4Var.l(this.b.e(), this.d, iMin2);
                int i5 = this.d + iMin2;
                this.d = i5;
                int i6 = this.c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (!this.e) {
                        this.b.T(i6);
                    } else {
                        if (g86.t(this.b.e(), 0, this.c, -1) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.T(this.c - 4);
                    }
                    this.b.U(0);
                    this.f19137a.a(this.b);
                    this.d = 0;
                }
            }
        }
    }

    @Override // defpackage.j26
    public void b(jy5 jy5Var, qs1 qs1Var, j26.d dVar) {
        this.f19137a.b(jy5Var, qs1Var, dVar);
        this.f = true;
    }

    @Override // defpackage.j26
    public void seek() {
        this.f = true;
    }
}
