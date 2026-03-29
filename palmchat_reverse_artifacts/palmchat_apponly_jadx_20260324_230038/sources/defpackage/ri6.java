package defpackage;

import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ri6 implements v45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pi6 f20488a;
    public final int b;
    public final long c;
    public final long d;
    public final long e;

    public ri6(pi6 pi6Var, int i, long j, long j2) {
        this.f20488a = pi6Var;
        this.b = i;
        this.c = j;
        long j3 = (j2 - j) / ((long) pi6Var.e);
        this.d = j3;
        this.e = a(j3);
    }

    public final long a(long j) {
        return g86.U0(j * ((long) this.b), 1000000L, this.f20488a.c);
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.e;
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        long jR = g86.r((((long) this.f20488a.c) * j) / (((long) this.b) * 1000000), 0L, this.d - 1);
        long j2 = this.c + (((long) this.f20488a.e) * jR);
        long jA = a(jR);
        x45 x45Var = new x45(jA, j2);
        if (jA >= j || jR == this.d - 1) {
            return new v45.a(x45Var);
        }
        long j3 = jR + 1;
        return new v45.a(x45Var, new x45(a(j3), this.c + (((long) this.f20488a.e) * j3)));
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return true;
    }
}
