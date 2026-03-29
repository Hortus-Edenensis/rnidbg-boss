package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class d26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16965a;
    public boolean d;
    public boolean e;
    public boolean f;
    public final jy5 b = new jy5(0);
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public long i = -9223372036854775807L;
    public final gc4 c = new gc4();

    public d26(int i) {
        this.f16965a = i;
    }

    public final int a(ps1 ps1Var) {
        this.c.R(g86.f);
        this.d = true;
        ps1Var.resetPeekPosition();
        return 0;
    }

    public long b() {
        return this.i;
    }

    public jy5 c() {
        return this.b;
    }

    public boolean d() {
        return this.d;
    }

    public int e(ps1 ps1Var, vk4 vk4Var, int i) throws IOException {
        if (i <= 0) {
            return a(ps1Var);
        }
        if (!this.f) {
            return h(ps1Var, vk4Var, i);
        }
        if (this.h == -9223372036854775807L) {
            return a(ps1Var);
        }
        if (!this.e) {
            return f(ps1Var, vk4Var, i);
        }
        long j = this.g;
        if (j == -9223372036854775807L) {
            return a(ps1Var);
        }
        long jB = this.b.b(this.h) - this.b.b(j);
        this.i = jB;
        if (jB < 0) {
            y53.i("TsDurationReader", "Invalid duration: " + this.i + ". Using TIME_UNSET instead.");
            this.i = -9223372036854775807L;
        }
        return a(ps1Var);
    }

    public final int f(ps1 ps1Var, vk4 vk4Var, int i) throws IOException {
        int iMin = (int) Math.min(this.f16965a, ps1Var.getLength());
        long j = 0;
        if (ps1Var.getPosition() != j) {
            vk4Var.f21468a = j;
            return 1;
        }
        this.c.Q(iMin);
        ps1Var.resetPeekPosition();
        ps1Var.peekFully(this.c.e(), 0, iMin);
        this.g = g(this.c, i);
        this.e = true;
        return 0;
    }

    public final long g(gc4 gc4Var, int i) {
        int iG = gc4Var.g();
        for (int iF = gc4Var.f(); iF < iG; iF++) {
            if (gc4Var.e()[iF] == 71) {
                long jC = k26.c(gc4Var, iF, i);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final int h(ps1 ps1Var, vk4 vk4Var, int i) throws IOException {
        long length = ps1Var.getLength();
        int iMin = (int) Math.min(this.f16965a, length);
        long j = length - ((long) iMin);
        if (ps1Var.getPosition() != j) {
            vk4Var.f21468a = j;
            return 1;
        }
        this.c.Q(iMin);
        ps1Var.resetPeekPosition();
        ps1Var.peekFully(this.c.e(), 0, iMin);
        this.h = i(this.c, i);
        this.f = true;
        return 0;
    }

    public final long i(gc4 gc4Var, int i) {
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        for (int i2 = iG - 188; i2 >= iF; i2--) {
            if (k26.b(gc4Var.e(), iF, iG, i2)) {
                long jC = k26.c(gc4Var, i2, i);
                if (jC != -9223372036854775807L) {
                    return jC;
                }
            }
        }
        return -9223372036854775807L;
    }
}
