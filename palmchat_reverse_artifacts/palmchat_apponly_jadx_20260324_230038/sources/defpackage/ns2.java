package defpackage;

import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ns2 implements v45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f19589a;
    public final long[] b;
    public final long c;
    public final boolean d;

    public ns2(long[] jArr, long[] jArr2, long j) {
        vh.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z = length > 0;
        this.d = z;
        if (!z || jArr2[0] <= 0) {
            this.f19589a = jArr;
            this.b = jArr2;
        } else {
            int i = length + 1;
            long[] jArr3 = new long[i];
            this.f19589a = jArr3;
            long[] jArr4 = new long[i];
            this.b = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.c = j;
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.c;
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        if (!this.d) {
            return new v45.a(x45.c);
        }
        int i = g86.i(this.b, j, true, true);
        x45 x45Var = new x45(this.b[i], this.f19589a[i]);
        if (x45Var.f21874a == j || i == this.b.length - 1) {
            return new v45.a(x45Var);
        }
        int i2 = i + 1;
        return new v45.a(x45Var, new x45(this.b[i2], this.f19589a[i2]));
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return this.d;
    }
}
