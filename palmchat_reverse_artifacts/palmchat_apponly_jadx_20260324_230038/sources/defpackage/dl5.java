package defpackage;

import com.google.android.exoplayer2.m;
import defpackage.v45;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class dl5 {
    public c06 b;
    public qs1 c;
    public k64 d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;
    public long k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i64 f17071a = new i64();
    public b j = new b();

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f17072a;
        public k64 b;
    }

    public final void a() {
        vh.i(this.b);
        g86.j(this.c);
    }

    public long b(long j) {
        return (j * 1000000) / ((long) this.i);
    }

    public long c(long j) {
        return (((long) this.i) * j) / 1000000;
    }

    public void d(qs1 qs1Var, c06 c06Var) {
        this.c = qs1Var;
        this.b = c06Var;
        l(true);
    }

    public void e(long j) {
        this.g = j;
    }

    public abstract long f(gc4 gc4Var);

    public final int g(ps1 ps1Var, vk4 vk4Var) throws IOException {
        a();
        int i = this.h;
        if (i == 0) {
            return j(ps1Var);
        }
        if (i == 1) {
            ps1Var.skipFully((int) this.f);
            this.h = 2;
            return 0;
        }
        if (i == 2) {
            g86.j(this.d);
            return k(ps1Var, vk4Var);
        }
        if (i == 3) {
            return -1;
        }
        throw new IllegalStateException();
    }

    public final boolean h(ps1 ps1Var) throws IOException {
        while (this.f17071a.d(ps1Var)) {
            this.k = ps1Var.getPosition() - this.f;
            if (!i(this.f17071a.c(), this.f, this.j)) {
                return true;
            }
            this.f = ps1Var.getPosition();
        }
        this.h = 3;
        return false;
    }

    public abstract boolean i(gc4 gc4Var, long j, b bVar) throws IOException;

    public final int j(ps1 ps1Var) throws IOException {
        if (!h(ps1Var)) {
            return -1;
        }
        m mVar = this.j.f17072a;
        this.i = mVar.z;
        if (!this.m) {
            this.b.b(mVar);
            this.m = true;
        }
        k64 k64Var = this.j.b;
        if (k64Var != null) {
            this.d = k64Var;
        } else if (ps1Var.getLength() == -1) {
            this.d = new c();
        } else {
            j64 j64VarB = this.f17071a.b();
            this.d = new o61(this, this.f, ps1Var.getLength(), j64VarB.h + j64VarB.i, j64VarB.c, (j64VarB.b & 4) != 0);
        }
        this.h = 2;
        this.f17071a.f();
        return 0;
    }

    public final int k(ps1 ps1Var, vk4 vk4Var) throws IOException {
        long jA = this.d.a(ps1Var);
        if (jA >= 0) {
            vk4Var.f21468a = jA;
            return 1;
        }
        if (jA < -1) {
            e(-(jA + 2));
        }
        if (!this.l) {
            this.c.d((v45) vh.i(this.d.createSeekMap()));
            this.l = true;
        }
        if (this.k <= 0 && !this.f17071a.d(ps1Var)) {
            this.h = 3;
            return -1;
        }
        this.k = 0L;
        gc4 gc4VarC = this.f17071a.c();
        long jF = f(gc4VarC);
        if (jF >= 0) {
            long j = this.g;
            if (j + jF >= this.e) {
                long jB = b(j);
                this.b.d(gc4VarC, gc4VarC.g());
                this.b.e(jB, 1, gc4VarC.g(), 0, null);
                this.e = -1L;
            }
        }
        this.g += jF;
        return 0;
    }

    public void l(boolean z) {
        if (z) {
            this.j = new b();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }

    public final void m(long j, long j2) {
        this.f17071a.e();
        if (j == 0) {
            l(!this.l);
        } else if (this.h != 0) {
            this.e = c(j2);
            ((k64) g86.j(this.d)).startSeek(this.e);
            this.h = 2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c implements k64 {
        public c() {
        }

        @Override // defpackage.k64
        public long a(ps1 ps1Var) {
            return -1L;
        }

        @Override // defpackage.k64
        public v45 createSeekMap() {
            return new v45.b(-9223372036854775807L);
        }

        @Override // defpackage.k64
        public void startSeek(long j) {
        }
    }
}
