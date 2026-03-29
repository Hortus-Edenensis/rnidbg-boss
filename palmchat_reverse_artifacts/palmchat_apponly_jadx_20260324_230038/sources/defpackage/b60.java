package defpackage;

import defpackage.v45;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b60 implements v45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1654a;
    public final int[] b;
    public final long[] c;
    public final long[] d;
    public final long[] e;
    public final long f;

    public b60(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.f1654a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    public int a(long j) {
        return g86.i(this.e, j, true, true);
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.f;
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        int iA = a(j);
        x45 x45Var = new x45(this.e[iA], this.c[iA]);
        if (x45Var.f21874a >= j || iA == this.f1654a - 1) {
            return new v45.a(x45Var);
        }
        int i = iA + 1;
        return new v45.a(x45Var, new x45(this.e[i], this.c[i]));
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f1654a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }
}
