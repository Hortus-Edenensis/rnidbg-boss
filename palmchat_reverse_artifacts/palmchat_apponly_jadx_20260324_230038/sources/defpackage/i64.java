package defpackage;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class i64 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j64 f18114a = new j64();
    public final gc4 b = new gc4(new byte[65025], 0);
    public int c = -1;
    public int d;
    public boolean e;

    public final int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            j64 j64Var = this.f18114a;
            if (i5 >= j64Var.g) {
                break;
            }
            int[] iArr = j64Var.j;
            this.d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public j64 b() {
        return this.f18114a;
    }

    public gc4 c() {
        return this.b;
    }

    public boolean d(ps1 ps1Var) throws IOException {
        int i;
        vh.g(ps1Var != null);
        if (this.e) {
            this.e = false;
            this.b.Q(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.f18114a.c(ps1Var) || !this.f18114a.a(ps1Var, true)) {
                    return false;
                }
                j64 j64Var = this.f18114a;
                int iA = j64Var.h;
                if ((j64Var.b & 1) == 1 && this.b.g() == 0) {
                    iA += a(0);
                    i = this.d + 0;
                } else {
                    i = 0;
                }
                if (!rs1.e(ps1Var, iA)) {
                    return false;
                }
                this.c = i;
            }
            int iA2 = a(this.c);
            int i2 = this.c + this.d;
            if (iA2 > 0) {
                gc4 gc4Var = this.b;
                gc4Var.c(gc4Var.g() + iA2);
                if (!rs1.d(ps1Var, this.b.e(), this.b.g(), iA2)) {
                    return false;
                }
                gc4 gc4Var2 = this.b;
                gc4Var2.T(gc4Var2.g() + iA2);
                this.e = this.f18114a.j[i2 + (-1)] != 255;
            }
            if (i2 == this.f18114a.g) {
                i2 = -1;
            }
            this.c = i2;
        }
        return true;
    }

    public void e() {
        this.f18114a.b();
        this.b.Q(0);
        this.c = -1;
        this.e = false;
    }

    public void f() {
        if (this.b.e().length == 65025) {
            return;
        }
        gc4 gc4Var = this.b;
        gc4Var.S(Arrays.copyOf(gc4Var.e(), Math.max(65025, this.b.g())), this.b.g());
    }
}
