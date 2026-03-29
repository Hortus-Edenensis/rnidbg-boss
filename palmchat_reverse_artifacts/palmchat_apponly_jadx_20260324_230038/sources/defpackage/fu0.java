package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class fu0 implements du0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b60 f17597a;
    public final long b;

    public fu0(b60 b60Var, long j) {
        this.f17597a = b60Var;
        this.b = j;
    }

    @Override // defpackage.du0
    public long a(long j, long j2) {
        return this.f17597a.d[(int) j];
    }

    @Override // defpackage.du0
    public long b(long j, long j2) {
        return 0L;
    }

    @Override // defpackage.du0
    public long c(long j, long j2) {
        return -9223372036854775807L;
    }

    @Override // defpackage.du0
    public long d(long j, long j2) {
        return this.f17597a.a(j + this.b);
    }

    @Override // defpackage.du0
    public long e(long j) {
        return this.f17597a.f1654a;
    }

    @Override // defpackage.du0
    public long f() {
        return 0L;
    }

    @Override // defpackage.du0
    public bt4 g(long j) {
        return new bt4(null, this.f17597a.c[(int) j], r0.b[r9]);
    }

    @Override // defpackage.du0
    public long getTimeUs(long j) {
        return this.f17597a.e[(int) j] - this.b;
    }

    @Override // defpackage.du0
    public boolean h() {
        return true;
    }

    @Override // defpackage.du0
    public long i(long j, long j2) {
        return this.f17597a.f1654a;
    }
}
