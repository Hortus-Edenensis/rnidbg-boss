package com.opos.exoplayer.core.c;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.opos.exoplayer.core.c.f;
import com.opos.exoplayer.core.r;
import com.opos.exoplayer.core.s;
import com.opos.exoplayer.core.source.o;
import com.opos.exoplayer.core.source.p;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class e extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<Map<p, b>> f8124a = new SparseArray<>();
    private final SparseBooleanArray b = new SparseBooleanArray();
    private int c = 0;
    private a d;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8125a;
        private final int[] b;
        private final p[] c;
        private final int[] d;
        private final int[][][] e;
        private final p f;

        public a(int[] iArr, p[] pVarArr, int[] iArr2, int[][][] iArr3, p pVar) {
            this.b = iArr;
            this.c = pVarArr;
            this.e = iArr3;
            this.d = iArr2;
            this.f = pVar;
            this.f8125a = pVarArr.length;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f.a f8126a;
        public final int b;
        public final int[] c;

        public f a(p pVar) {
            return this.f8126a.b(pVar.a(this.b), this.c);
        }
    }

    private static int a(r[] rVarArr, o oVar) {
        int length = rVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < rVarArr.length; i2++) {
            r rVar = rVarArr[i2];
            for (int i3 = 0; i3 < oVar.f8303a; i3++) {
                int iA = rVar.a(oVar.a(i3)) & 7;
                if (iA > i) {
                    if (iA == 4) {
                        return i2;
                    }
                    length = i2;
                    i = iA;
                }
            }
        }
        return length;
    }

    public abstract f[] a(r[] rVarArr, p[] pVarArr, int[][][] iArr);

    @Override // com.opos.exoplayer.core.c.h
    public final i a(r[] rVarArr, p pVar) {
        int[] iArr = new int[rVarArr.length + 1];
        int length = rVarArr.length + 1;
        o[][] oVarArr = new o[length][];
        int[][][] iArr2 = new int[rVarArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = pVar.b;
            oVarArr[i] = new o[i2];
            iArr2[i] = new int[i2][];
        }
        int[] iArrA = a(rVarArr);
        for (int i3 = 0; i3 < pVar.b; i3++) {
            o oVarA = pVar.a(i3);
            int iA = a(rVarArr, oVarA);
            int[] iArrA2 = iA == rVarArr.length ? new int[oVarA.f8303a] : a(rVarArr[iA], oVarA);
            int i4 = iArr[iA];
            oVarArr[iA][i4] = oVarA;
            iArr2[iA][i4] = iArrA2;
            iArr[iA] = i4 + 1;
        }
        p[] pVarArr = new p[rVarArr.length];
        int[] iArr3 = new int[rVarArr.length];
        for (int i5 = 0; i5 < rVarArr.length; i5++) {
            int i6 = iArr[i5];
            pVarArr[i5] = new p((o[]) Arrays.copyOf(oVarArr[i5], i6));
            iArr2[i5] = (int[][]) Arrays.copyOf(iArr2[i5], i6);
            iArr3[i5] = rVarArr[i5].a();
        }
        p pVar2 = new p((o[]) Arrays.copyOf(oVarArr[rVarArr.length], iArr[rVarArr.length]));
        f[] fVarArrA = a(rVarArr, pVarArr, iArr2);
        int i7 = 0;
        while (true) {
            if (i7 >= rVarArr.length) {
                break;
            }
            if (this.b.get(i7)) {
                fVarArrA[i7] = null;
            } else {
                p pVar3 = pVarArr[i7];
                if (a(i7, pVar3)) {
                    b bVar = this.f8124a.get(i7).get(pVar3);
                    fVarArrA[i7] = bVar != null ? bVar.a(pVar3) : null;
                }
            }
            i7++;
        }
        boolean[] zArrA = a(rVarArr, fVarArrA);
        a aVar = new a(iArr3, pVarArr, iArrA, iArr2, pVar2);
        s[] sVarArr = new s[rVarArr.length];
        for (int i8 = 0; i8 < rVarArr.length; i8++) {
            sVarArr[i8] = zArrA[i8] ? s.f8279a : null;
        }
        a(rVarArr, pVarArr, iArr2, sVarArr, fVarArrA, this.c);
        return new i(pVar, zArrA, new g(fVarArrA), aVar, sVarArr);
    }

    @Override // com.opos.exoplayer.core.c.h
    public final void a(Object obj) {
        this.d = (a) obj;
    }

    private static void a(r[] rVarArr, p[] pVarArr, int[][][] iArr, s[] sVarArr, f[] fVarArr, int i) {
        boolean z;
        if (i == 0) {
            return;
        }
        boolean z2 = false;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < rVarArr.length; i4++) {
            int iA = rVarArr[i4].a();
            f fVar = fVarArr[i4];
            if ((iA == 1 || iA == 2) && fVar != null && a(iArr[i4], pVarArr[i4], fVar)) {
                if (iA == 1) {
                    if (i3 != -1) {
                        z = false;
                        break;
                    }
                    i3 = i4;
                } else {
                    if (i2 != -1) {
                        z = false;
                        break;
                    }
                    i2 = i4;
                }
            }
        }
        z = true;
        if (i3 != -1 && i2 != -1) {
            z2 = true;
        }
        if (z && z2) {
            s sVar = new s(i);
            sVarArr[i3] = sVar;
            sVarArr[i2] = sVar;
        }
    }

    public final boolean a(int i, p pVar) {
        Map<p, b> map = this.f8124a.get(i);
        return map != null && map.containsKey(pVar);
    }

    private static boolean a(int[][] iArr, p pVar, f fVar) {
        if (fVar == null) {
            return false;
        }
        int iA = pVar.a(fVar.d());
        for (int i = 0; i < fVar.e(); i++) {
            if ((iArr[iA][fVar.b(i)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    private static int[] a(r rVar, o oVar) {
        int[] iArr = new int[oVar.f8303a];
        for (int i = 0; i < oVar.f8303a; i++) {
            iArr[i] = rVar.a(oVar.a(i));
        }
        return iArr;
    }

    private static int[] a(r[] rVarArr) {
        int length = rVarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = rVarArr[i].m();
        }
        return iArr;
    }

    private boolean[] a(r[] rVarArr, f[] fVarArr) {
        int length = fVarArr.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = !this.b.get(i) && (rVarArr[i].a() == 5 || fVarArr[i] != null);
        }
        return zArr;
    }
}
