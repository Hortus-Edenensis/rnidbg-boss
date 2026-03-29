package defpackage;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class nz5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v71 f19645a;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;
    public boolean l;

    @Nullable
    public mz5 n;
    public boolean p;
    public long q;
    public boolean r;
    public long[] g = new long[0];
    public int[] h = new int[0];
    public int[] i = new int[0];
    public long[] j = new long[0];
    public boolean[] k = new boolean[0];
    public boolean[] m = new boolean[0];
    public final gc4 o = new gc4();

    public void a(ps1 ps1Var) throws IOException {
        ps1Var.readFully(this.o.e(), 0, this.o.g());
        this.o.U(0);
        this.p = false;
    }

    public void b(gc4 gc4Var) {
        gc4Var.l(this.o.e(), 0, this.o.g());
        this.o.U(0);
        this.p = false;
    }

    public long c(int i) {
        return this.j[i];
    }

    public void d(int i) {
        this.o.Q(i);
        this.l = true;
        this.p = true;
    }

    public void e(int i, int i2) {
        this.e = i;
        this.f = i2;
        if (this.h.length < i) {
            this.g = new long[i];
            this.h = new int[i];
        }
        if (this.i.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.i = new int[i3];
            this.j = new long[i3];
            this.k = new boolean[i3];
            this.m = new boolean[i3];
        }
    }

    public void f() {
        this.e = 0;
        this.q = 0L;
        this.r = false;
        this.l = false;
        this.p = false;
        this.n = null;
    }

    public boolean g(int i) {
        return this.l && this.m[i];
    }
}
