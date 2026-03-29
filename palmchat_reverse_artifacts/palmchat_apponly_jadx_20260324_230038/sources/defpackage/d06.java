package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class d06 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lz5 f16956a;
    public final int b;
    public final long[] c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public d06(lz5 lz5Var, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        vh.a(iArr.length == jArr2.length);
        vh.a(jArr.length == jArr2.length);
        vh.a(iArr2.length == jArr2.length);
        this.f16956a = lz5Var;
        this.c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j) {
        for (int i = g86.i(this.f, j, true, false); i >= 0; i--) {
            if ((this.g[i] & 1) != 0) {
                return i;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int iE = g86.e(this.f, j, true, false); iE < this.f.length; iE++) {
            if ((this.g[iE] & 1) != 0) {
                return iE;
            }
        }
        return -1;
    }
}
