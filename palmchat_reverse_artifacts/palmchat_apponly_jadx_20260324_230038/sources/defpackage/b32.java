package defpackage;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import defpackage.v45;
import defpackage.vi;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class b32 implements os1 {
    public static final ys1 I = new ys1() { // from class: w22
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return b32.l();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };
    public static final byte[] J = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final m K = new m.b().g0("application/x-emsg").G();
    public int A;
    public int B;
    public int C;
    public boolean D;
    public qs1 E;
    public c06[] F;
    public c06[] G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1636a;

    @Nullable
    public final lz5 b;
    public final List<m> c;
    public final SparseArray<b> d;
    public final gc4 e;
    public final gc4 f;
    public final gc4 g;
    public final byte[] h;
    public final gc4 i;

    @Nullable
    public final jy5 j;
    public final pn1 k;
    public final gc4 l;
    public final ArrayDeque<vi.a> m;
    public final ArrayDeque<a> n;

    @Nullable
    public final c06 o;
    public int p;
    public int q;
    public long r;
    public int s;

    @Nullable
    public gc4 t;
    public long u;
    public int v;
    public long w;
    public long x;
    public long y;

    @Nullable
    public b z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f1637a;
        public final boolean b;
        public final int c;

        public a(long j, boolean z, int i) {
            this.f1637a = j;
            this.b = z;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c06 f1638a;
        public d06 d;
        public v71 e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean l;
        public final nz5 b = new nz5();
        public final gc4 c = new gc4();
        public final gc4 j = new gc4(1);
        public final gc4 k = new gc4();

        public b(c06 c06Var, d06 d06Var, v71 v71Var) {
            this.f1638a = c06Var;
            this.d = d06Var;
            this.e = v71Var;
            j(d06Var, v71Var);
        }

        public int c() {
            int i = !this.l ? this.d.g[this.f] : this.b.k[this.f] ? 1 : 0;
            return g() != null ? i | 1073741824 : i;
        }

        public long d() {
            return !this.l ? this.d.c[this.f] : this.b.g[this.h];
        }

        public long e() {
            return !this.l ? this.d.f[this.f] : this.b.c(this.f);
        }

        public int f() {
            return !this.l ? this.d.d[this.f] : this.b.i[this.f];
        }

        @Nullable
        public mz5 g() {
            if (!this.l) {
                return null;
            }
            int i = ((v71) g86.j(this.b.f19645a)).f21370a;
            mz5 mz5VarA = this.b.n;
            if (mz5VarA == null) {
                mz5VarA = this.d.f16956a.a(i);
            }
            if (mz5VarA == null || !mz5VarA.f19397a) {
                return null;
            }
            return mz5VarA;
        }

        public boolean h() {
            this.f++;
            if (!this.l) {
                return false;
            }
            int i = this.g + 1;
            this.g = i;
            int[] iArr = this.b.h;
            int i2 = this.h;
            if (i != iArr[i2]) {
                return true;
            }
            this.h = i2 + 1;
            this.g = 0;
            return false;
        }

        public int i(int i, int i2) {
            gc4 gc4Var;
            mz5 mz5VarG = g();
            if (mz5VarG == null) {
                return 0;
            }
            int length = mz5VarG.d;
            if (length != 0) {
                gc4Var = this.b.o;
            } else {
                byte[] bArr = (byte[]) g86.j(mz5VarG.e);
                this.k.S(bArr, bArr.length);
                gc4 gc4Var2 = this.k;
                length = bArr.length;
                gc4Var = gc4Var2;
            }
            boolean zG = this.b.g(this.f);
            boolean z = zG || i2 != 0;
            this.j.e()[0] = (byte) ((z ? 128 : 0) | length);
            this.j.U(0);
            this.f1638a.a(this.j, 1, 1);
            this.f1638a.a(gc4Var, length, 1);
            if (!z) {
                return length + 1;
            }
            if (!zG) {
                this.c.Q(8);
                byte[] bArrE = this.c.e();
                bArrE[0] = 0;
                bArrE[1] = 1;
                bArrE[2] = (byte) ((i2 >> 8) & 255);
                bArrE[3] = (byte) (i2 & 255);
                bArrE[4] = (byte) ((i >> 24) & 255);
                bArrE[5] = (byte) ((i >> 16) & 255);
                bArrE[6] = (byte) ((i >> 8) & 255);
                bArrE[7] = (byte) (i & 255);
                this.f1638a.a(this.c, 8, 1);
                return length + 1 + 8;
            }
            gc4 gc4Var3 = this.b.o;
            int iN = gc4Var3.N();
            gc4Var3.V(-2);
            int i3 = (iN * 6) + 2;
            if (i2 != 0) {
                this.c.Q(i3);
                byte[] bArrE2 = this.c.e();
                gc4Var3.l(bArrE2, 0, i3);
                int i4 = (((bArrE2[2] & UByte.MAX_VALUE) << 8) | (bArrE2[3] & UByte.MAX_VALUE)) + i2;
                bArrE2[2] = (byte) ((i4 >> 8) & 255);
                bArrE2[3] = (byte) (i4 & 255);
                gc4Var3 = this.c;
            }
            this.f1638a.a(gc4Var3, i3, 1);
            return length + 1 + i3;
        }

        public void j(d06 d06Var, v71 v71Var) {
            this.d = d06Var;
            this.e = v71Var;
            this.f1638a.b(d06Var.f16956a.f);
            k();
        }

        public void k() {
            this.b.f();
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }

        public void l(long j) {
            int i = this.f;
            while (true) {
                nz5 nz5Var = this.b;
                if (i >= nz5Var.f || nz5Var.c(i) > j) {
                    return;
                }
                if (this.b.k[i]) {
                    this.i = i;
                }
                i++;
            }
        }

        public void m() {
            mz5 mz5VarG = g();
            if (mz5VarG == null) {
                return;
            }
            gc4 gc4Var = this.b.o;
            int i = mz5VarG.d;
            if (i != 0) {
                gc4Var.V(i);
            }
            if (this.b.g(this.f)) {
                gc4Var.V(gc4Var.N() * 6);
            }
        }

        public void n(DrmInitData drmInitData) {
            mz5 mz5VarA = this.d.f16956a.a(((v71) g86.j(this.b.f19645a)).f21370a);
            this.f1638a.b(this.d.f16956a.f.b().O(drmInitData.copyWithSchemeType(mz5VarA != null ? mz5VarA.b : null)).G());
        }
    }

    public b32() {
        this(0);
    }

    public static Pair<Long, b60> A(gc4 gc4Var, long j) throws ParserException {
        long jM;
        long jM2;
        gc4Var.U(8);
        int iC = vi.c(gc4Var.q());
        gc4Var.V(4);
        long J2 = gc4Var.J();
        if (iC == 0) {
            jM = gc4Var.J();
            jM2 = gc4Var.J();
        } else {
            jM = gc4Var.M();
            jM2 = gc4Var.M();
        }
        long j2 = jM;
        long j3 = j + jM2;
        long jU0 = g86.U0(j2, 1000000L, J2);
        gc4Var.V(2);
        int iN = gc4Var.N();
        int[] iArr = new int[iN];
        long[] jArr = new long[iN];
        long[] jArr2 = new long[iN];
        long[] jArr3 = new long[iN];
        long j4 = j2;
        long j5 = jU0;
        int i = 0;
        while (i < iN) {
            int iQ = gc4Var.q();
            if ((iQ & Integer.MIN_VALUE) != 0) {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", null);
            }
            long J3 = gc4Var.J();
            iArr[i] = iQ & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j5;
            long j6 = j4 + J3;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i2 = iN;
            int[] iArr2 = iArr;
            long jU02 = g86.U0(j6, 1000000L, J2);
            jArr4[i] = jU02 - jArr5[i];
            gc4Var.V(4);
            j3 += (long) iArr2[i];
            i++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iN = i2;
            j4 = j6;
            j5 = jU02;
        }
        return Pair.create(Long.valueOf(jU0), new b60(iArr, jArr, jArr2, jArr3));
    }

    public static long B(gc4 gc4Var) {
        gc4Var.U(8);
        return vi.c(gc4Var.q()) == 1 ? gc4Var.M() : gc4Var.J();
    }

    @Nullable
    public static b C(gc4 gc4Var, SparseArray<b> sparseArray, boolean z) {
        gc4Var.U(8);
        int iB = vi.b(gc4Var.q());
        b bVarValueAt = z ? sparseArray.valueAt(0) : sparseArray.get(gc4Var.q());
        if (bVarValueAt == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jM = gc4Var.M();
            nz5 nz5Var = bVarValueAt.b;
            nz5Var.c = jM;
            nz5Var.d = jM;
        }
        v71 v71Var = bVarValueAt.e;
        bVarValueAt.b.f19645a = new v71((iB & 2) != 0 ? gc4Var.q() - 1 : v71Var.f21370a, (iB & 8) != 0 ? gc4Var.q() : v71Var.b, (iB & 16) != 0 ? gc4Var.q() : v71Var.c, (iB & 32) != 0 ? gc4Var.q() : v71Var.d);
        return bVarValueAt;
    }

    public static void D(vi.a aVar, SparseArray<b> sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        b bVarC = C(((vi.b) vh.e(aVar.g(1952868452))).b, sparseArray, z);
        if (bVarC == null) {
            return;
        }
        nz5 nz5Var = bVarC.b;
        long j = nz5Var.q;
        boolean z2 = nz5Var.r;
        bVarC.k();
        bVarC.l = true;
        vi.b bVarG = aVar.g(1952867444);
        if (bVarG == null || (i & 2) != 0) {
            nz5Var.q = j;
            nz5Var.r = z2;
        } else {
            nz5Var.q = B(bVarG.b);
            nz5Var.r = true;
        }
        G(aVar, bVarC, i);
        mz5 mz5VarA = bVarC.d.f16956a.a(((v71) vh.e(nz5Var.f19645a)).f21370a);
        vi.b bVarG2 = aVar.g(1935763834);
        if (bVarG2 != null) {
            w((mz5) vh.e(mz5VarA), bVarG2.b, nz5Var);
        }
        vi.b bVarG3 = aVar.g(1935763823);
        if (bVarG3 != null) {
            v(bVarG3.b, nz5Var);
        }
        vi.b bVarG4 = aVar.g(1936027235);
        if (bVarG4 != null) {
            z(bVarG4.b, nz5Var);
        }
        x(aVar, mz5VarA != null ? mz5VarA.b : null, nz5Var);
        int size = aVar.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            vi.b bVar = aVar.c.get(i2);
            if (bVar.f21448a == 1970628964) {
                H(bVar.b, nz5Var, bArr);
            }
        }
    }

    public static Pair<Integer, v71> E(gc4 gc4Var) {
        gc4Var.U(12);
        return Pair.create(Integer.valueOf(gc4Var.q()), new v71(gc4Var.q() - 1, gc4Var.q(), gc4Var.q(), gc4Var.q()));
    }

    public static int F(b bVar, int i, int i2, gc4 gc4Var, int i3) throws ParserException {
        boolean z;
        int iQ;
        boolean z2;
        int iQ2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iQ3;
        b bVar2 = bVar;
        gc4Var.U(8);
        int iB = vi.b(gc4Var.q());
        lz5 lz5Var = bVar2.d.f16956a;
        nz5 nz5Var = bVar2.b;
        v71 v71Var = (v71) g86.j(nz5Var.f19645a);
        nz5Var.h[i] = gc4Var.L();
        long[] jArr = nz5Var.g;
        long j = nz5Var.c;
        jArr[i] = j;
        if ((iB & 1) != 0) {
            jArr[i] = j + ((long) gc4Var.q());
        }
        boolean z6 = (iB & 4) != 0;
        int iQ4 = v71Var.d;
        if (z6) {
            iQ4 = gc4Var.q();
        }
        boolean z7 = (iB & 256) != 0;
        boolean z8 = (iB & 512) != 0;
        boolean z9 = (iB & 1024) != 0;
        boolean z10 = (iB & 2048) != 0;
        long j2 = k(lz5Var) ? ((long[]) g86.j(lz5Var.i))[0] : 0L;
        int[] iArr = nz5Var.i;
        long[] jArr2 = nz5Var.j;
        boolean[] zArr = nz5Var.k;
        int i4 = iQ4;
        boolean z11 = lz5Var.b == 2 && (i2 & 1) != 0;
        int i5 = i3 + nz5Var.h[i];
        boolean z12 = z11;
        long j3 = lz5Var.c;
        long j4 = nz5Var.q;
        int i6 = i3;
        while (i6 < i5) {
            int iE = e(z7 ? gc4Var.q() : v71Var.b);
            if (z8) {
                iQ = gc4Var.q();
                z = z7;
            } else {
                z = z7;
                iQ = v71Var.c;
            }
            int iE2 = e(iQ);
            if (z9) {
                z2 = z6;
                iQ2 = gc4Var.q();
            } else if (i6 == 0 && z6) {
                z2 = z6;
                iQ2 = i4;
            } else {
                z2 = z6;
                iQ2 = v71Var.d;
            }
            if (z10) {
                z3 = z10;
                z4 = z8;
                z5 = z9;
                iQ3 = gc4Var.q();
            } else {
                z3 = z10;
                z4 = z8;
                z5 = z9;
                iQ3 = 0;
            }
            long jU0 = g86.U0((((long) iQ3) + j4) - j2, 1000000L, j3);
            jArr2[i6] = jU0;
            if (!nz5Var.r) {
                jArr2[i6] = jU0 + bVar2.d.h;
            }
            iArr[i6] = iE2;
            zArr[i6] = ((iQ2 >> 16) & 1) == 0 && (!z12 || i6 == 0);
            j4 += (long) iE;
            i6++;
            bVar2 = bVar;
            z7 = z;
            z6 = z2;
            z10 = z3;
            z8 = z4;
            z9 = z5;
        }
        nz5Var.q = j4;
        return i5;
    }

    public static void G(vi.a aVar, b bVar, int i) throws ParserException {
        List<vi.b> list = aVar.c;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            vi.b bVar2 = list.get(i4);
            if (bVar2.f21448a == 1953658222) {
                gc4 gc4Var = bVar2.b;
                gc4Var.U(12);
                int iL = gc4Var.L();
                if (iL > 0) {
                    i3 += iL;
                    i2++;
                }
            }
        }
        bVar.h = 0;
        bVar.g = 0;
        bVar.f = 0;
        bVar.b.e(i2, i3);
        int i5 = 0;
        int iF = 0;
        for (int i6 = 0; i6 < size; i6++) {
            vi.b bVar3 = list.get(i6);
            if (bVar3.f21448a == 1953658222) {
                iF = F(bVar, i5, i, bVar3.b, iF);
                i5++;
            }
        }
    }

    public static void H(gc4 gc4Var, nz5 nz5Var, byte[] bArr) throws ParserException {
        gc4Var.U(8);
        gc4Var.l(bArr, 0, 16);
        if (Arrays.equals(bArr, J)) {
            y(gc4Var, 16, nz5Var);
        }
    }

    public static boolean N(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    public static boolean O(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    public static int e(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw ParserException.createForMalformedContainer("Unexpected negative value: " + i, null);
    }

    @Nullable
    public static DrmInitData h(List<vi.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            vi.b bVar = list.get(i);
            if (bVar.f21448a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrE = bVar.b.e();
                UUID uuidF = xo4.f(bArrE);
                if (uuidF == null) {
                    y53.i("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidF, "video/mp4", bArrE));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    @Nullable
    public static b i(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            b bVarValueAt = sparseArray.valueAt(i);
            if ((bVarValueAt.l || bVarValueAt.f != bVarValueAt.d.b) && (!bVarValueAt.l || bVarValueAt.h != bVarValueAt.b.e)) {
                long jD = bVarValueAt.d();
                if (jD < j) {
                    bVar = bVarValueAt;
                    j = jD;
                }
            }
        }
        return bVar;
    }

    public static boolean k(lz5 lz5Var) {
        long[] jArr;
        long[] jArr2 = lz5Var.h;
        if (jArr2 == null || jArr2.length != 1 || (jArr = lz5Var.i) == null) {
            return false;
        }
        long j = jArr2[0];
        return j == 0 || g86.U0(j + jArr[0], 1000000L, lz5Var.d) >= lz5Var.e;
    }

    public static /* synthetic */ os1[] l() {
        return new os1[]{new b32()};
    }

    public static long t(gc4 gc4Var) {
        gc4Var.U(8);
        return vi.c(gc4Var.q()) == 0 ? gc4Var.J() : gc4Var.M();
    }

    public static void u(vi.a aVar, SparseArray<b> sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        int size = aVar.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            vi.a aVar2 = aVar.d.get(i2);
            if (aVar2.f21448a == 1953653094) {
                D(aVar2, sparseArray, z, i, bArr);
            }
        }
    }

    public static void v(gc4 gc4Var, nz5 nz5Var) throws ParserException {
        gc4Var.U(8);
        int iQ = gc4Var.q();
        if ((vi.b(iQ) & 1) == 1) {
            gc4Var.V(8);
        }
        int iL = gc4Var.L();
        if (iL == 1) {
            nz5Var.d += vi.c(iQ) == 0 ? gc4Var.J() : gc4Var.M();
        } else {
            throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + iL, null);
        }
    }

    public static void w(mz5 mz5Var, gc4 gc4Var, nz5 nz5Var) throws ParserException {
        int i;
        int i2 = mz5Var.d;
        gc4Var.U(8);
        if ((vi.b(gc4Var.q()) & 1) == 1) {
            gc4Var.V(8);
        }
        int iH = gc4Var.H();
        int iL = gc4Var.L();
        if (iL > nz5Var.f) {
            throw ParserException.createForMalformedContainer("Saiz sample count " + iL + " is greater than fragment sample count" + nz5Var.f, null);
        }
        if (iH == 0) {
            boolean[] zArr = nz5Var.m;
            i = 0;
            for (int i3 = 0; i3 < iL; i3++) {
                int iH2 = gc4Var.H();
                i += iH2;
                zArr[i3] = iH2 > i2;
            }
        } else {
            i = (iH * iL) + 0;
            Arrays.fill(nz5Var.m, 0, iL, iH > i2);
        }
        Arrays.fill(nz5Var.m, iL, nz5Var.f, false);
        if (i > 0) {
            nz5Var.d(i);
        }
    }

    public static void x(vi.a aVar, @Nullable String str, nz5 nz5Var) throws ParserException {
        byte[] bArr = null;
        gc4 gc4Var = null;
        gc4 gc4Var2 = null;
        for (int i = 0; i < aVar.c.size(); i++) {
            vi.b bVar = aVar.c.get(i);
            gc4 gc4Var3 = bVar.b;
            int i2 = bVar.f21448a;
            if (i2 == 1935828848) {
                gc4Var3.U(12);
                if (gc4Var3.q() == 1936025959) {
                    gc4Var = gc4Var3;
                }
            } else if (i2 == 1936158820) {
                gc4Var3.U(12);
                if (gc4Var3.q() == 1936025959) {
                    gc4Var2 = gc4Var3;
                }
            }
        }
        if (gc4Var == null || gc4Var2 == null) {
            return;
        }
        gc4Var.U(8);
        int iC = vi.c(gc4Var.q());
        gc4Var.V(4);
        if (iC == 1) {
            gc4Var.V(4);
        }
        if (gc4Var.q() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
        gc4Var2.U(8);
        int iC2 = vi.c(gc4Var2.q());
        gc4Var2.V(4);
        if (iC2 == 1) {
            if (gc4Var2.J() == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
            }
        } else if (iC2 >= 2) {
            gc4Var2.V(4);
        }
        if (gc4Var2.J() != 1) {
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
        }
        gc4Var2.V(1);
        int iH = gc4Var2.H();
        int i3 = (iH & 240) >> 4;
        int i4 = iH & 15;
        boolean z = gc4Var2.H() == 1;
        if (z) {
            int iH2 = gc4Var2.H();
            byte[] bArr2 = new byte[16];
            gc4Var2.l(bArr2, 0, 16);
            if (iH2 == 0) {
                int iH3 = gc4Var2.H();
                bArr = new byte[iH3];
                gc4Var2.l(bArr, 0, iH3);
            }
            nz5Var.l = true;
            nz5Var.n = new mz5(z, str, iH2, bArr2, i3, i4, bArr);
        }
    }

    public static void y(gc4 gc4Var, int i, nz5 nz5Var) throws ParserException {
        gc4Var.U(i + 8);
        int iB = vi.b(gc4Var.q());
        if ((iB & 1) != 0) {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iB & 2) != 0;
        int iL = gc4Var.L();
        if (iL == 0) {
            Arrays.fill(nz5Var.m, 0, nz5Var.f, false);
            return;
        }
        if (iL == nz5Var.f) {
            Arrays.fill(nz5Var.m, 0, iL, z);
            nz5Var.d(gc4Var.a());
            nz5Var.b(gc4Var);
        } else {
            throw ParserException.createForMalformedContainer("Senc sample count " + iL + " is different from fragment sample count" + nz5Var.f, null);
        }
    }

    public static void z(gc4 gc4Var, nz5 nz5Var) throws ParserException {
        y(gc4Var, 0, nz5Var);
    }

    public final void I(long j) throws ParserException {
        while (!this.m.isEmpty() && this.m.peek().b == j) {
            n(this.m.pop());
        }
        f();
    }

    public final boolean J(ps1 ps1Var) throws IOException {
        if (this.s == 0) {
            if (!ps1Var.readFully(this.l.e(), 0, 8, true)) {
                return false;
            }
            this.s = 8;
            this.l.U(0);
            this.r = this.l.J();
            this.q = this.l.q();
        }
        long j = this.r;
        if (j == 1) {
            ps1Var.readFully(this.l.e(), 8, 8);
            this.s += 8;
            this.r = this.l.M();
        } else if (j == 0) {
            long length = ps1Var.getLength();
            if (length == -1 && !this.m.isEmpty()) {
                length = this.m.peek().b;
            }
            if (length != -1) {
                this.r = (length - ps1Var.getPosition()) + ((long) this.s);
            }
        }
        if (this.r < this.s) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        long position = ps1Var.getPosition() - ((long) this.s);
        int i = this.q;
        if ((i == 1836019558 || i == 1835295092) && !this.H) {
            this.E.d(new v45.b(this.x, position));
            this.H = true;
        }
        if (this.q == 1836019558) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                nz5 nz5Var = this.d.valueAt(i2).b;
                nz5Var.b = position;
                nz5Var.d = position;
                nz5Var.c = position;
            }
        }
        int i3 = this.q;
        if (i3 == 1835295092) {
            this.z = null;
            this.u = position + this.r;
            this.p = 2;
            return true;
        }
        if (N(i3)) {
            long position2 = (ps1Var.getPosition() + this.r) - 8;
            this.m.push(new vi.a(this.q, position2));
            if (this.r == this.s) {
                I(position2);
            } else {
                f();
            }
        } else if (O(this.q)) {
            if (this.s != 8) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
            }
            if (this.r > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
            }
            gc4 gc4Var = new gc4((int) this.r);
            System.arraycopy(this.l.e(), 0, gc4Var.e(), 0, 8);
            this.t = gc4Var;
            this.p = 1;
        } else {
            if (this.r > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            this.t = null;
            this.p = 1;
        }
        return true;
    }

    public final void K(ps1 ps1Var) throws IOException {
        int i = ((int) this.r) - this.s;
        gc4 gc4Var = this.t;
        if (gc4Var != null) {
            ps1Var.readFully(gc4Var.e(), 8, i);
            p(new vi.b(this.q, gc4Var), ps1Var.getPosition());
        } else {
            ps1Var.skipFully(i);
        }
        I(ps1Var.getPosition());
    }

    public final void L(ps1 ps1Var) throws IOException {
        int size = this.d.size();
        long j = Long.MAX_VALUE;
        b bVarValueAt = null;
        for (int i = 0; i < size; i++) {
            nz5 nz5Var = this.d.valueAt(i).b;
            if (nz5Var.p) {
                long j2 = nz5Var.d;
                if (j2 < j) {
                    bVarValueAt = this.d.valueAt(i);
                    j = j2;
                }
            }
        }
        if (bVarValueAt == null) {
            this.p = 3;
            return;
        }
        int position = (int) (j - ps1Var.getPosition());
        if (position < 0) {
            throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", null);
        }
        ps1Var.skipFully(position);
        bVarValueAt.b.a(ps1Var);
    }

    public final boolean M(ps1 ps1Var) throws IOException {
        int iC;
        b bVarI = this.z;
        Throwable th = null;
        if (bVarI == null) {
            bVarI = i(this.d);
            if (bVarI == null) {
                int position = (int) (this.u - ps1Var.getPosition());
                if (position < 0) {
                    throw ParserException.createForMalformedContainer("Offset to end of mdat was negative.", null);
                }
                ps1Var.skipFully(position);
                f();
                return false;
            }
            int iD = (int) (bVarI.d() - ps1Var.getPosition());
            if (iD < 0) {
                y53.i("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                iD = 0;
            }
            ps1Var.skipFully(iD);
            this.z = bVarI;
        }
        int i = 4;
        int i2 = 1;
        if (this.p == 3) {
            int iF = bVarI.f();
            this.A = iF;
            if (bVarI.f < bVarI.i) {
                ps1Var.skipFully(iF);
                bVarI.m();
                if (!bVarI.h()) {
                    this.z = null;
                }
                this.p = 3;
                return true;
            }
            if (bVarI.d.f16956a.g == 1) {
                this.A = iF - 8;
                ps1Var.skipFully(8);
            }
            if ("audio/ac4".equals(bVarI.d.f16956a.f.l)) {
                this.B = bVarI.i(this.A, 7);
                n2.a(this.A, this.i);
                bVarI.f1638a.d(this.i, 7);
                this.B += 7;
            } else {
                this.B = bVarI.i(this.A, 0);
            }
            this.A += this.B;
            this.p = 4;
            this.C = 0;
        }
        lz5 lz5Var = bVarI.d.f16956a;
        c06 c06Var = bVarI.f1638a;
        long jE = bVarI.e();
        jy5 jy5Var = this.j;
        if (jy5Var != null) {
            jE = jy5Var.a(jE);
        }
        long j = jE;
        if (lz5Var.j == 0) {
            while (true) {
                int i3 = this.B;
                int i4 = this.A;
                if (i3 >= i4) {
                    break;
                }
                this.B += c06Var.c(ps1Var, i4 - i3, false);
            }
        } else {
            byte[] bArrE = this.f.e();
            bArrE[0] = 0;
            bArrE[1] = 0;
            bArrE[2] = 0;
            int i5 = lz5Var.j;
            int i6 = i5 + 1;
            int i7 = 4 - i5;
            while (this.B < this.A) {
                int i8 = this.C;
                if (i8 == 0) {
                    ps1Var.readFully(bArrE, i7, i6);
                    this.f.U(0);
                    int iQ = this.f.q();
                    if (iQ < i2) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", th);
                    }
                    this.C = iQ - 1;
                    this.e.U(0);
                    c06Var.d(this.e, i);
                    c06Var.d(this.f, i2);
                    this.D = this.G.length > 0 && ot3.g(lz5Var.f.l, bArrE[i]);
                    this.B += 5;
                    this.A += i7;
                } else {
                    if (this.D) {
                        this.g.Q(i8);
                        ps1Var.readFully(this.g.e(), 0, this.C);
                        c06Var.d(this.g, this.C);
                        iC = this.C;
                        int iQ2 = ot3.q(this.g.e(), this.g.g());
                        this.g.U("video/hevc".equals(lz5Var.f.l) ? 1 : 0);
                        this.g.T(iQ2);
                        xz.a(j, this.g, this.G);
                    } else {
                        iC = c06Var.c(ps1Var, i8, false);
                    }
                    this.B += iC;
                    this.C -= iC;
                    th = null;
                    i = 4;
                    i2 = 1;
                }
            }
        }
        int iC2 = bVarI.c();
        mz5 mz5VarG = bVarI.g();
        c06Var.e(j, iC2, this.A, 0, mz5VarG != null ? mz5VarG.c : null);
        s(j);
        if (!bVarI.h()) {
            this.z = null;
        }
        this.p = 3;
        return true;
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.E = qs1Var;
        f();
        j();
        lz5 lz5Var = this.b;
        if (lz5Var != null) {
            this.d.put(0, new b(qs1Var.track(0, lz5Var.b), new d06(this.b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new v71(0, 0, 0, 0)));
            this.E.endTracks();
        }
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        while (true) {
            int i = this.p;
            if (i != 0) {
                if (i == 1) {
                    K(ps1Var);
                } else if (i == 2) {
                    L(ps1Var);
                } else if (M(ps1Var)) {
                    return 0;
                }
            } else if (!J(ps1Var)) {
                return -1;
            }
        }
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        return sf5.b(ps1Var);
    }

    public final void f() {
        this.p = 0;
        this.s = 0;
    }

    public final v71 g(SparseArray<v71> sparseArray, int i) {
        return sparseArray.size() == 1 ? sparseArray.valueAt(0) : (v71) vh.e(sparseArray.get(i));
    }

    public final void j() {
        int i;
        c06[] c06VarArr = new c06[2];
        this.F = c06VarArr;
        c06 c06Var = this.o;
        int i2 = 0;
        if (c06Var != null) {
            c06VarArr[0] = c06Var;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.f1636a & 4) != 0) {
            c06VarArr[i] = this.E.track(100, 5);
            i3 = 101;
            i++;
        }
        c06[] c06VarArr2 = (c06[]) g86.M0(this.F, i);
        this.F = c06VarArr2;
        for (c06 c06Var2 : c06VarArr2) {
            c06Var2.b(K);
        }
        this.G = new c06[this.c.size()];
        while (i2 < this.G.length) {
            c06 c06VarTrack = this.E.track(i3, 3);
            c06VarTrack.b(this.c.get(i2));
            this.G[i2] = c06VarTrack;
            i2++;
            i3++;
        }
    }

    public final void n(vi.a aVar) throws ParserException {
        int i = aVar.f21448a;
        if (i == 1836019574) {
            r(aVar);
        } else if (i == 1836019558) {
            q(aVar);
        } else {
            if (this.m.isEmpty()) {
                return;
            }
            this.m.peek().d(aVar);
        }
    }

    public final void o(gc4 gc4Var) {
        long jU0;
        String str;
        long jU02;
        String str2;
        long J2;
        long jA;
        if (this.F.length == 0) {
            return;
        }
        gc4Var.U(8);
        int iC = vi.c(gc4Var.q());
        if (iC == 0) {
            String str3 = (String) vh.e(gc4Var.B());
            String str4 = (String) vh.e(gc4Var.B());
            long J3 = gc4Var.J();
            jU0 = g86.U0(gc4Var.J(), 1000000L, J3);
            long j = this.y;
            long j2 = j != -9223372036854775807L ? j + jU0 : -9223372036854775807L;
            str = str3;
            jU02 = g86.U0(gc4Var.J(), 1000L, J3);
            str2 = str4;
            J2 = gc4Var.J();
            jA = j2;
        } else {
            if (iC != 1) {
                y53.i("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iC);
                return;
            }
            long J4 = gc4Var.J();
            jA = g86.U0(gc4Var.M(), 1000000L, J4);
            long jU03 = g86.U0(gc4Var.J(), 1000L, J4);
            long J5 = gc4Var.J();
            str = (String) vh.e(gc4Var.B());
            jU02 = jU03;
            J2 = J5;
            str2 = (String) vh.e(gc4Var.B());
            jU0 = -9223372036854775807L;
        }
        byte[] bArr = new byte[gc4Var.a()];
        gc4Var.l(bArr, 0, gc4Var.a());
        gc4 gc4Var2 = new gc4(this.k.a(new EventMessage(str, str2, jU02, J2, bArr)));
        int iA = gc4Var2.a();
        for (c06 c06Var : this.F) {
            gc4Var2.U(0);
            c06Var.d(gc4Var2, iA);
        }
        if (jA == -9223372036854775807L) {
            this.n.addLast(new a(jU0, true, iA));
            this.v += iA;
            return;
        }
        if (!this.n.isEmpty()) {
            this.n.addLast(new a(jA, false, iA));
            this.v += iA;
            return;
        }
        jy5 jy5Var = this.j;
        if (jy5Var != null && !jy5Var.f()) {
            this.n.addLast(new a(jA, false, iA));
            this.v += iA;
            return;
        }
        jy5 jy5Var2 = this.j;
        if (jy5Var2 != null) {
            jA = jy5Var2.a(jA);
        }
        for (c06 c06Var2 : this.F) {
            c06Var2.e(jA, 1, iA, 0, null);
        }
    }

    public final void p(vi.b bVar, long j) throws ParserException {
        if (!this.m.isEmpty()) {
            this.m.peek().e(bVar);
            return;
        }
        int i = bVar.f21448a;
        if (i != 1936286840) {
            if (i == 1701671783) {
                o(bVar.b);
            }
        } else {
            Pair<Long, b60> pairA = A(bVar.b, j);
            this.y = ((Long) pairA.first).longValue();
            this.E.d((v45) pairA.second);
            this.H = true;
        }
    }

    public final void q(vi.a aVar) throws ParserException {
        u(aVar, this.d, this.b != null, this.f1636a, this.h);
        DrmInitData drmInitDataH = h(aVar.c);
        if (drmInitDataH != null) {
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                this.d.valueAt(i).n(drmInitDataH);
            }
        }
        if (this.w != -9223372036854775807L) {
            int size2 = this.d.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.d.valueAt(i2).l(this.w);
            }
            this.w = -9223372036854775807L;
        }
    }

    public final void r(vi.a aVar) throws ParserException {
        int i = 0;
        vh.h(this.b == null, "Unexpected moov box.");
        DrmInitData drmInitDataH = h(aVar.c);
        vi.a aVar2 = (vi.a) vh.e(aVar.f(1836475768));
        SparseArray<v71> sparseArray = new SparseArray<>();
        int size = aVar2.c.size();
        long jT = -9223372036854775807L;
        for (int i2 = 0; i2 < size; i2++) {
            vi.b bVar = aVar2.c.get(i2);
            int i3 = bVar.f21448a;
            if (i3 == 1953654136) {
                Pair<Integer, v71> pairE = E(bVar.b);
                sparseArray.put(((Integer) pairE.first).intValue(), (v71) pairE.second);
            } else if (i3 == 1835362404) {
                jT = t(bVar.b);
            }
        }
        List<d06> listB = wi.B(aVar, new m52(), jT, drmInitDataH, (this.f1636a & 16) != 0, false, new u42() { // from class: t22
            @Override // defpackage.u42
            public final Object apply(Object obj) {
                return this.f20888a.m((lz5) obj);
            }
        });
        int size2 = listB.size();
        if (this.d.size() != 0) {
            vh.g(this.d.size() == size2);
            while (i < size2) {
                d06 d06Var = listB.get(i);
                lz5 lz5Var = d06Var.f16956a;
                this.d.get(lz5Var.f19109a).j(d06Var, g(sparseArray, lz5Var.f19109a));
                i++;
            }
            return;
        }
        while (i < size2) {
            d06 d06Var2 = listB.get(i);
            lz5 lz5Var2 = d06Var2.f16956a;
            this.d.put(lz5Var2.f19109a, new b(this.E.track(i, lz5Var2.b), d06Var2, g(sparseArray, lz5Var2.f19109a)));
            this.x = Math.max(this.x, lz5Var2.e);
            i++;
        }
        this.E.endTracks();
    }

    public final void s(long j) {
        while (!this.n.isEmpty()) {
            a aVarRemoveFirst = this.n.removeFirst();
            this.v -= aVarRemoveFirst.c;
            long jA = aVarRemoveFirst.f1637a;
            if (aVarRemoveFirst.b) {
                jA += j;
            }
            jy5 jy5Var = this.j;
            if (jy5Var != null) {
                jA = jy5Var.a(jA);
            }
            for (c06 c06Var : this.F) {
                c06Var.e(jA, 1, aVarRemoveFirst.c, this.v, null);
            }
        }
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            this.d.valueAt(i).k();
        }
        this.n.clear();
        this.v = 0;
        this.w = j2;
        this.m.clear();
        f();
    }

    public b32(int i) {
        this(i, null);
    }

    public b32(int i, @Nullable jy5 jy5Var) {
        this(i, jy5Var, null, Collections.emptyList());
    }

    public b32(int i, @Nullable jy5 jy5Var, @Nullable lz5 lz5Var, List<m> list) {
        this(i, jy5Var, lz5Var, list, null);
    }

    public b32(int i, @Nullable jy5 jy5Var, @Nullable lz5 lz5Var, List<m> list, @Nullable c06 c06Var) {
        this.f1636a = i;
        this.j = jy5Var;
        this.b = lz5Var;
        this.c = Collections.unmodifiableList(list);
        this.o = c06Var;
        this.k = new pn1();
        this.l = new gc4(16);
        this.e = new gc4(ot3.f19869a);
        this.f = new gc4(5);
        this.g = new gc4();
        byte[] bArr = new byte[16];
        this.h = bArr;
        this.i = new gc4(bArr);
        this.m = new ArrayDeque<>();
        this.n = new ArrayDeque<>();
        this.d = new SparseArray<>();
        this.x = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.E = qs1.c0;
        this.F = new c06[0];
        this.G = new c06[0];
    }

    @Override // defpackage.os1
    public void release() {
    }

    @Nullable
    public lz5 m(@Nullable lz5 lz5Var) {
        return lz5Var;
    }
}
