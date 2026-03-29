package defpackage;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.flv.a;
import com.google.android.exoplayer2.extractor.flv.b;
import defpackage.v45;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class o02 implements os1 {
    public static final ys1 q = new ys1() { // from class: l02
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return o02.g();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };
    public qs1 f;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public int l;
    public long m;
    public boolean n;
    public a o;
    public b p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f19650a = new gc4(4);
    public final gc4 b = new gc4(9);
    public final gc4 c = new gc4(11);
    public final gc4 d = new gc4();
    public final w35 e = new w35();
    public int g = 1;

    public static /* synthetic */ os1[] g() {
        return new os1[]{new o02()};
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.f = qs1Var;
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        vh.i(this.f);
        while (true) {
            int i = this.g;
            if (i != 1) {
                if (i == 2) {
                    l(ps1Var);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException();
                    }
                    if (j(ps1Var)) {
                        return 0;
                    }
                } else if (!k(ps1Var)) {
                    return -1;
                }
            } else if (!i(ps1Var)) {
                return -1;
            }
        }
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        ps1Var.peekFully(this.f19650a.e(), 0, 3);
        this.f19650a.U(0);
        if (this.f19650a.K() != 4607062) {
            return false;
        }
        ps1Var.peekFully(this.f19650a.e(), 0, 2);
        this.f19650a.U(0);
        if ((this.f19650a.N() & 250) != 0) {
            return false;
        }
        ps1Var.peekFully(this.f19650a.e(), 0, 4);
        this.f19650a.U(0);
        int iQ = this.f19650a.q();
        ps1Var.resetPeekPosition();
        ps1Var.advancePeekPosition(iQ);
        ps1Var.peekFully(this.f19650a.e(), 0, 4);
        this.f19650a.U(0);
        return this.f19650a.q() == 0;
    }

    public final void e() {
        if (this.n) {
            return;
        }
        this.f.d(new v45.b(-9223372036854775807L));
        this.n = true;
    }

    public final long f() {
        if (this.h) {
            return this.i + this.m;
        }
        if (this.e.d() == -9223372036854775807L) {
            return 0L;
        }
        return this.m;
    }

    public final gc4 h(ps1 ps1Var) throws IOException {
        if (this.l > this.d.b()) {
            gc4 gc4Var = this.d;
            gc4Var.S(new byte[Math.max(gc4Var.b() * 2, this.l)], 0);
        } else {
            this.d.U(0);
        }
        this.d.T(this.l);
        ps1Var.readFully(this.d.e(), 0, this.l);
        return this.d;
    }

    public final boolean i(ps1 ps1Var) throws IOException {
        if (!ps1Var.readFully(this.b.e(), 0, 9, true)) {
            return false;
        }
        this.b.U(0);
        this.b.V(4);
        int iH = this.b.H();
        boolean z = (iH & 4) != 0;
        boolean z2 = (iH & 1) != 0;
        if (z && this.o == null) {
            this.o = new a(this.f.track(8, 1));
        }
        if (z2 && this.p == null) {
            this.p = new b(this.f.track(9, 2));
        }
        this.f.endTracks();
        this.j = (this.b.q() - 9) + 4;
        this.g = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j(ps1 ps1Var) throws IOException {
        boolean zA;
        boolean z;
        long jF = f();
        int i = this.k;
        if (i == 8 && this.o != null) {
            e();
            zA = this.o.a(h(ps1Var), jF);
        } else if (i == 9 && this.p != null) {
            e();
            zA = this.p.a(h(ps1Var), jF);
        } else {
            if (i != 18 || this.n) {
                ps1Var.skipFully(this.l);
                zA = false;
                z = false;
                if (!this.h && zA) {
                    this.h = true;
                    this.i = this.e.d() != -9223372036854775807L ? -this.m : 0L;
                }
                this.j = 4;
                this.g = 2;
                return z;
            }
            zA = this.e.a(h(ps1Var), jF);
            long jD = this.e.d();
            if (jD != -9223372036854775807L) {
                this.f.d(new ns2(this.e.e(), this.e.f(), jD));
                this.n = true;
            }
        }
        z = true;
        if (!this.h) {
            this.h = true;
            this.i = this.e.d() != -9223372036854775807L ? -this.m : 0L;
        }
        this.j = 4;
        this.g = 2;
        return z;
    }

    public final boolean k(ps1 ps1Var) throws IOException {
        if (!ps1Var.readFully(this.c.e(), 0, 11, true)) {
            return false;
        }
        this.c.U(0);
        this.k = this.c.H();
        this.l = this.c.K();
        this.m = this.c.K();
        this.m = (((long) (this.c.H() << 24)) | this.m) * 1000;
        this.c.V(3);
        this.g = 4;
        return true;
    }

    public final void l(ps1 ps1Var) throws IOException {
        ps1Var.skipFully(this.j);
        this.j = 0;
        this.g = 3;
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        if (j == 0) {
            this.g = 1;
            this.h = false;
        } else {
            this.g = 3;
        }
        this.j = 0;
    }

    @Override // defpackage.os1
    public void release() {
    }
}
