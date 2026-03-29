package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import defpackage.as3;
import defpackage.j26;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class zr3 implements gl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f22500a;
    public final as3.a b;

    @Nullable
    public final String c;
    public c06 d;
    public String e;
    public int f;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public long l;

    public zr3() {
        this(null);
    }

    @Override // defpackage.gl1
    public void a(gc4 gc4Var) {
        vh.i(this.d);
        while (gc4Var.a() > 0) {
            int i = this.f;
            if (i == 0) {
                c(gc4Var);
            } else if (i == 1) {
                e(gc4Var);
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                d(gc4Var);
            }
        }
    }

    @Override // defpackage.gl1
    public void b(qs1 qs1Var, j26.d dVar) {
        dVar.a();
        this.e = dVar.b();
        this.d = qs1Var.track(dVar.c(), 1);
    }

    public final void c(gc4 gc4Var) {
        byte[] bArrE = gc4Var.e();
        int iG = gc4Var.g();
        for (int iF = gc4Var.f(); iF < iG; iF++) {
            byte b = bArrE[iF];
            boolean z = (b & UByte.MAX_VALUE) == 255;
            boolean z2 = this.i && (b & 224) == 224;
            this.i = z;
            if (z2) {
                gc4Var.U(iF + 1);
                this.i = false;
                this.f22500a.e()[1] = bArrE[iF];
                this.g = 2;
                this.f = 1;
                return;
            }
        }
        gc4Var.U(iG);
    }

    public final void d(gc4 gc4Var) {
        int iMin = Math.min(gc4Var.a(), this.k - this.g);
        this.d.d(gc4Var, iMin);
        int i = this.g + iMin;
        this.g = i;
        int i2 = this.k;
        if (i < i2) {
            return;
        }
        long j = this.l;
        if (j != -9223372036854775807L) {
            this.d.e(j, 1, i2, 0, null);
            this.l += this.j;
        }
        this.g = 0;
        this.f = 0;
    }

    public final void e(gc4 gc4Var) {
        int iMin = Math.min(gc4Var.a(), 4 - this.g);
        gc4Var.l(this.f22500a.e(), this.g, iMin);
        int i = this.g + iMin;
        this.g = i;
        if (i < 4) {
            return;
        }
        this.f22500a.U(0);
        if (!this.b.a(this.f22500a.q())) {
            this.g = 0;
            this.f = 1;
            return;
        }
        as3.a aVar = this.b;
        this.k = aVar.c;
        if (!this.h) {
            this.j = (((long) aVar.g) * 1000000) / ((long) aVar.d);
            this.d.b(new m.b().U(this.e).g0(this.b.b).Y(4096).J(this.b.e).h0(this.b.d).X(this.c).G());
            this.h = true;
        }
        this.f22500a.U(0);
        this.d.d(this.f22500a, 4);
        this.f = 2;
    }

    @Override // defpackage.gl1
    public void packetStarted(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }

    @Override // defpackage.gl1
    public void seek() {
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.l = -9223372036854775807L;
    }

    public zr3(@Nullable String str) {
        this.f = 0;
        gc4 gc4Var = new gc4(4);
        this.f22500a = gc4Var;
        gc4Var.e()[0] = -1;
        this.b = new as3.a();
        this.l = -9223372036854775807L;
        this.c = str;
    }

    @Override // defpackage.gl1
    public void packetFinished() {
    }
}
