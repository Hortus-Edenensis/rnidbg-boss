package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import defpackage.lx1;
import defpackage.mx1;
import defpackage.v45;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class kx1 implements os1 {
    public static final ys1 o = new ys1() { // from class: hx1
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return kx1.i();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f18846a;
    public final gc4 b;
    public final boolean c;
    public final lx1.a d;
    public qs1 e;
    public c06 f;
    public int g;

    @Nullable
    public Metadata h;
    public px1 i;
    public int j;
    public int k;
    public gx1 l;
    public int m;
    public long n;

    public kx1() {
        this(0);
    }

    public static /* synthetic */ os1[] i() {
        return new os1[]{new kx1()};
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.e = qs1Var;
        this.f = qs1Var.track(0, 1);
        qs1Var.endTracks();
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        int i = this.g;
        if (i == 0) {
            l(ps1Var);
            return 0;
        }
        if (i == 1) {
            h(ps1Var);
            return 0;
        }
        if (i == 2) {
            n(ps1Var);
            return 0;
        }
        if (i == 3) {
            m(ps1Var);
            return 0;
        }
        if (i == 4) {
            f(ps1Var);
            return 0;
        }
        if (i == 5) {
            return k(ps1Var, vk4Var);
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        mx1.c(ps1Var, false);
        return mx1.a(ps1Var);
    }

    public final long e(gc4 gc4Var, boolean z) {
        boolean zD;
        vh.e(this.i);
        int iF = gc4Var.f();
        while (iF <= gc4Var.g() - 16) {
            gc4Var.U(iF);
            if (lx1.d(gc4Var, this.i, this.k, this.d)) {
                gc4Var.U(iF);
                return this.d.f19094a;
            }
            iF++;
        }
        if (!z) {
            gc4Var.U(iF);
            return -1L;
        }
        while (iF <= gc4Var.g() - this.j) {
            gc4Var.U(iF);
            try {
                zD = lx1.d(gc4Var, this.i, this.k, this.d);
            } catch (IndexOutOfBoundsException unused) {
                zD = false;
            }
            if (gc4Var.f() <= gc4Var.g() ? zD : false) {
                gc4Var.U(iF);
                return this.d.f19094a;
            }
            iF++;
        }
        gc4Var.U(gc4Var.g());
        return -1L;
    }

    public final void f(ps1 ps1Var) throws IOException {
        this.k = mx1.b(ps1Var);
        ((qs1) g86.j(this.e)).d(g(ps1Var.getPosition(), ps1Var.getLength()));
        this.g = 5;
    }

    public final v45 g(long j, long j2) {
        vh.e(this.i);
        px1 px1Var = this.i;
        if (px1Var.k != null) {
            return new ox1(px1Var, j);
        }
        if (j2 == -1 || px1Var.j <= 0) {
            return new v45.b(px1Var.f());
        }
        gx1 gx1Var = new gx1(px1Var, this.k, j, j2);
        this.l = gx1Var;
        return gx1Var.b();
    }

    public final void h(ps1 ps1Var) throws IOException {
        byte[] bArr = this.f18846a;
        ps1Var.peekFully(bArr, 0, bArr.length);
        ps1Var.resetPeekPosition();
        this.g = 2;
    }

    public final void j() {
        ((c06) g86.j(this.f)).e((this.n * 1000000) / ((long) ((px1) g86.j(this.i)).e), 1, this.m, 0, null);
    }

    public final int k(ps1 ps1Var, vk4 vk4Var) throws IOException {
        boolean z;
        vh.e(this.f);
        vh.e(this.i);
        gx1 gx1Var = this.l;
        if (gx1Var != null && gx1Var.d()) {
            return this.l.c(ps1Var, vk4Var);
        }
        if (this.n == -1) {
            this.n = lx1.i(ps1Var, this.i);
            return 0;
        }
        int iG = this.b.g();
        if (iG < 32768) {
            int i = ps1Var.read(this.b.e(), iG, 32768 - iG);
            z = i == -1;
            if (!z) {
                this.b.T(iG + i);
            } else if (this.b.a() == 0) {
                j();
                return -1;
            }
        } else {
            z = false;
        }
        int iF = this.b.f();
        int i2 = this.m;
        int i3 = this.j;
        if (i2 < i3) {
            gc4 gc4Var = this.b;
            gc4Var.V(Math.min(i3 - i2, gc4Var.a()));
        }
        long jE = e(this.b, z);
        int iF2 = this.b.f() - iF;
        this.b.U(iF);
        this.f.d(this.b, iF2);
        this.m += iF2;
        if (jE != -1) {
            j();
            this.m = 0;
            this.n = jE;
        }
        if (this.b.a() < 16) {
            int iA = this.b.a();
            System.arraycopy(this.b.e(), this.b.f(), this.b.e(), 0, iA);
            this.b.U(0);
            this.b.T(iA);
        }
        return 0;
    }

    public final void l(ps1 ps1Var) throws IOException {
        this.h = mx1.d(ps1Var, !this.c);
        this.g = 1;
    }

    public final void m(ps1 ps1Var) throws IOException {
        mx1.a aVar = new mx1.a(this.i);
        boolean zE = false;
        while (!zE) {
            zE = mx1.e(ps1Var, aVar);
            this.i = (px1) g86.j(aVar.f19384a);
        }
        vh.e(this.i);
        this.j = Math.max(this.i.c, 6);
        ((c06) g86.j(this.f)).b(this.i.g(this.f18846a, this.h));
        this.g = 4;
    }

    public final void n(ps1 ps1Var) throws IOException {
        mx1.i(ps1Var);
        this.g = 3;
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        if (j == 0) {
            this.g = 0;
        } else {
            gx1 gx1Var = this.l;
            if (gx1Var != null) {
                gx1Var.h(j2);
            }
        }
        this.n = j2 != 0 ? -1L : 0L;
        this.m = 0;
        this.b.Q(0);
    }

    public kx1(int i) {
        this.f18846a = new byte[42];
        this.b = new gc4(new byte[32768], 0);
        this.c = (i & 1) != 0;
        this.d = new lx1.a();
        this.g = 0;
    }

    @Override // defpackage.os1
    public void release() {
    }
}
