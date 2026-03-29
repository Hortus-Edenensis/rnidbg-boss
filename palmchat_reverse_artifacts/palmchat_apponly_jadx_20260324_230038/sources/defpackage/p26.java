package defpackage;

import android.text.Layout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class p26 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public String f19924a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public float k;

    @Nullable
    public String l;

    @Nullable
    public Layout.Alignment o;

    @Nullable
    public Layout.Alignment p;

    @Nullable
    public qu5 r;
    public int f = -1;
    public int g = -1;
    public int h = -1;
    public int i = -1;
    public int j = -1;
    public int m = -1;
    public int n = -1;
    public int q = -1;
    public float s = Float.MAX_VALUE;

    public p26 A(@Nullable String str) {
        this.l = str;
        return this;
    }

    public p26 B(boolean z) {
        this.i = z ? 1 : 0;
        return this;
    }

    public p26 C(boolean z) {
        this.f = z ? 1 : 0;
        return this;
    }

    public p26 D(@Nullable Layout.Alignment alignment) {
        this.p = alignment;
        return this;
    }

    public p26 E(int i) {
        this.n = i;
        return this;
    }

    public p26 F(int i) {
        this.m = i;
        return this;
    }

    public p26 G(float f) {
        this.s = f;
        return this;
    }

    public p26 H(@Nullable Layout.Alignment alignment) {
        this.o = alignment;
        return this;
    }

    public p26 I(boolean z) {
        this.q = z ? 1 : 0;
        return this;
    }

    public p26 J(@Nullable qu5 qu5Var) {
        this.r = qu5Var;
        return this;
    }

    public p26 K(boolean z) {
        this.g = z ? 1 : 0;
        return this;
    }

    public p26 a(@Nullable p26 p26Var) {
        return r(p26Var, true);
    }

    public int b() {
        if (this.e) {
            return this.d;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public int c() {
        if (this.c) {
            return this.b;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    @Nullable
    public String d() {
        return this.f19924a;
    }

    public float e() {
        return this.k;
    }

    public int f() {
        return this.j;
    }

    @Nullable
    public String g() {
        return this.l;
    }

    @Nullable
    public Layout.Alignment h() {
        return this.p;
    }

    public int i() {
        return this.n;
    }

    public int j() {
        return this.m;
    }

    public float k() {
        return this.s;
    }

    public int l() {
        int i = this.h;
        if (i == -1 && this.i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.i == 1 ? 2 : 0);
    }

    @Nullable
    public Layout.Alignment m() {
        return this.o;
    }

    public boolean n() {
        return this.q == 1;
    }

    @Nullable
    public qu5 o() {
        return this.r;
    }

    public boolean p() {
        return this.e;
    }

    public boolean q() {
        return this.c;
    }

    public final p26 r(@Nullable p26 p26Var, boolean z) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (p26Var != null) {
            if (!this.c && p26Var.c) {
                w(p26Var.b);
            }
            if (this.h == -1) {
                this.h = p26Var.h;
            }
            if (this.i == -1) {
                this.i = p26Var.i;
            }
            if (this.f19924a == null && (str = p26Var.f19924a) != null) {
                this.f19924a = str;
            }
            if (this.f == -1) {
                this.f = p26Var.f;
            }
            if (this.g == -1) {
                this.g = p26Var.g;
            }
            if (this.n == -1) {
                this.n = p26Var.n;
            }
            if (this.o == null && (alignment2 = p26Var.o) != null) {
                this.o = alignment2;
            }
            if (this.p == null && (alignment = p26Var.p) != null) {
                this.p = alignment;
            }
            if (this.q == -1) {
                this.q = p26Var.q;
            }
            if (this.j == -1) {
                this.j = p26Var.j;
                this.k = p26Var.k;
            }
            if (this.r == null) {
                this.r = p26Var.r;
            }
            if (this.s == Float.MAX_VALUE) {
                this.s = p26Var.s;
            }
            if (z && !this.e && p26Var.e) {
                u(p26Var.d);
            }
            if (z && this.m == -1 && (i = p26Var.m) != -1) {
                this.m = i;
            }
        }
        return this;
    }

    public boolean s() {
        return this.f == 1;
    }

    public boolean t() {
        return this.g == 1;
    }

    public p26 u(int i) {
        this.d = i;
        this.e = true;
        return this;
    }

    public p26 v(boolean z) {
        this.h = z ? 1 : 0;
        return this;
    }

    public p26 w(int i) {
        this.b = i;
        this.c = true;
        return this;
    }

    public p26 x(@Nullable String str) {
        this.f19924a = str;
        return this;
    }

    public p26 y(float f) {
        this.k = f;
        return this;
    }

    public p26 z(int i) {
        this.j = i;
        return this;
    }
}
