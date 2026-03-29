package defpackage;

import androidx.annotation.Nullable;
import defpackage.as3;
import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class k96 implements y45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f18603a;
    public final long[] b;
    public final long c;
    public final long d;

    public k96(long[] jArr, long[] jArr2, long j, long j2) {
        this.f18603a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
    }

    @Nullable
    public static k96 a(long j, long j2, as3.a aVar, gc4 gc4Var) {
        int iH;
        gc4Var.V(10);
        int iQ = gc4Var.q();
        if (iQ <= 0) {
            return null;
        }
        int i = aVar.d;
        long jU0 = g86.U0(iQ, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, i);
        int iN = gc4Var.N();
        int iN2 = gc4Var.N();
        int iN3 = gc4Var.N();
        gc4Var.V(2);
        long j3 = j2 + ((long) aVar.c);
        long[] jArr = new long[iN];
        long[] jArr2 = new long[iN];
        int i2 = 0;
        long j4 = j2;
        while (i2 < iN) {
            int i3 = iN2;
            long j5 = j3;
            jArr[i2] = (((long) i2) * jU0) / ((long) iN);
            jArr2[i2] = Math.max(j4, j5);
            if (iN3 == 1) {
                iH = gc4Var.H();
            } else if (iN3 == 2) {
                iH = gc4Var.N();
            } else if (iN3 == 3) {
                iH = gc4Var.K();
            } else {
                if (iN3 != 4) {
                    return null;
                }
                iH = gc4Var.L();
            }
            j4 += ((long) iH) * ((long) i3);
            i2++;
            jArr = jArr;
            iN2 = i3;
            j3 = j5;
        }
        long[] jArr3 = jArr;
        if (j != -1 && j != j4) {
            y53.i("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new k96(jArr3, jArr2, jU0, j4);
    }

    @Override // defpackage.y45
    public long getDataEndPosition() {
        return this.d;
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.c;
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        int i = g86.i(this.f18603a, j, true, true);
        x45 x45Var = new x45(this.f18603a[i], this.b[i]);
        if (x45Var.f21874a >= j || i == this.f18603a.length - 1) {
            return new v45.a(x45Var);
        }
        int i2 = i + 1;
        return new v45.a(x45Var, new x45(this.f18603a[i2], this.b[i2]));
    }

    @Override // defpackage.y45
    public long getTimeUs(long j) {
        return this.f18603a[g86.i(this.b, j, true, true)];
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return true;
    }
}
