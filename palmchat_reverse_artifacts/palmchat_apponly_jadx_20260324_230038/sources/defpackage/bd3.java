package defpackage;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.a0;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class bd3 extends o06 {

    @Nullable
    public a c;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1688a;
        public final String[] b;
        public final int[] c;
        public final vz5[] d;
        public final int[] e;
        public final int[][][] f;
        public final vz5 g;

        @VisibleForTesting
        public a(String[] strArr, int[] iArr, vz5[] vz5VarArr, int[] iArr2, int[][][] iArr3, vz5 vz5Var) {
            this.b = strArr;
            this.c = iArr;
            this.d = vz5VarArr;
            this.f = iArr3;
            this.e = iArr2;
            this.g = vz5Var;
            this.f1688a = iArr.length;
        }

        public int a(int i, int i2, boolean z) {
            int i3 = this.d[i].b(i2).f20360a;
            int[] iArr = new int[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int iG = g(i, i2, i5);
                if (iG == 4 || (z && iG == 3)) {
                    iArr[i4] = i5;
                    i4++;
                }
            }
            return b(i, i2, Arrays.copyOf(iArr, i4));
        }

        public int b(int i, int i2, int[] iArr) {
            int i3 = 0;
            String str = null;
            boolean z = false;
            int i4 = 0;
            int iMin = 16;
            while (i3 < iArr.length) {
                String str2 = this.d[i].b(i2).c(iArr[i3]).l;
                int i5 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !g86.c(str, str2);
                }
                iMin = Math.min(iMin, qv4.d(this.f[i][i2][i3]));
                i3++;
                i4 = i5;
            }
            return z ? Math.min(iMin, this.e[i]) : iMin;
        }

        public int c(int i, int i2, int i3) {
            return this.f[i][i2][i3];
        }

        public int d() {
            return this.f1688a;
        }

        public int e(int i) {
            return this.c[i];
        }

        public vz5 f(int i) {
            return this.d[i];
        }

        public int g(int i, int i2, int i3) {
            return qv4.f(c(i, i2, i3));
        }

        public vz5 h() {
            return this.g;
        }
    }

    public static int n(a0[] a0VarArr, qz5 qz5Var, int[] iArr, boolean z) throws ExoPlaybackException {
        int length = a0VarArr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < a0VarArr.length; i2++) {
            a0 a0Var = a0VarArr[i2];
            int iMax = 0;
            for (int i3 = 0; i3 < qz5Var.f20360a; i3++) {
                iMax = Math.max(iMax, qv4.f(a0Var.a(qz5Var.c(i3))));
            }
            boolean z3 = iArr[i2] == 0;
            if (iMax > i || (iMax == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = iMax;
            }
        }
        return length;
    }

    public static int[] o(a0 a0Var, qz5 qz5Var) throws ExoPlaybackException {
        int[] iArr = new int[qz5Var.f20360a];
        for (int i = 0; i < qz5Var.f20360a; i++) {
            iArr[i] = a0Var.a(qz5Var.c(i));
        }
        return iArr;
    }

    public static int[] p(a0[] a0VarArr) throws ExoPlaybackException {
        int length = a0VarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = a0VarArr[i].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Override // defpackage.o06
    public final void i(@Nullable Object obj) {
        this.c = (a) obj;
    }

    @Override // defpackage.o06
    public final p06 k(a0[] a0VarArr, vz5 vz5Var, i.b bVar, e0 e0Var) throws ExoPlaybackException {
        int[] iArr = new int[a0VarArr.length + 1];
        int length = a0VarArr.length + 1;
        qz5[][] qz5VarArr = new qz5[length][];
        int[][][] iArr2 = new int[a0VarArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = vz5Var.f21565a;
            qz5VarArr[i] = new qz5[i2];
            iArr2[i] = new int[i2][];
        }
        int[] iArrP = p(a0VarArr);
        for (int i3 = 0; i3 < vz5Var.f21565a; i3++) {
            qz5 qz5VarB = vz5Var.b(i3);
            int iN = n(a0VarArr, qz5VarB, iArr, qz5VarB.c == 5);
            int[] iArrO = iN == a0VarArr.length ? new int[qz5VarB.f20360a] : o(a0VarArr[iN], qz5VarB);
            int i4 = iArr[iN];
            qz5VarArr[iN][i4] = qz5VarB;
            iArr2[iN][i4] = iArrO;
            iArr[iN] = i4 + 1;
        }
        vz5[] vz5VarArr = new vz5[a0VarArr.length];
        String[] strArr = new String[a0VarArr.length];
        int[] iArr3 = new int[a0VarArr.length];
        for (int i5 = 0; i5 < a0VarArr.length; i5++) {
            int i6 = iArr[i5];
            vz5VarArr[i5] = new vz5((qz5[]) g86.M0(qz5VarArr[i5], i6));
            iArr2[i5] = (int[][]) g86.M0(iArr2[i5], i6);
            strArr[i5] = a0VarArr[i5].getName();
            iArr3[i5] = a0VarArr[i5].getTrackType();
        }
        a aVar = new a(strArr, iArr3, vz5VarArr, iArrP, iArr2, new vz5((qz5[]) g86.M0(qz5VarArr[a0VarArr.length], iArr[a0VarArr.length])));
        Pair<tv4[], or1[]> pairQ = q(aVar, iArr2, iArrP, bVar, e0Var);
        return new p06((tv4[]) pairQ.first, (or1[]) pairQ.second, l06.a(aVar, (e06[]) pairQ.second), aVar);
    }

    public abstract Pair<tv4[], or1[]> q(a aVar, int[][][] iArr, int[] iArr2, i.b bVar, e0 e0Var) throws ExoPlaybackException;
}
