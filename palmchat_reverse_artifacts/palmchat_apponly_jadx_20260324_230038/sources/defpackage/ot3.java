package defpackage;

import androidx.annotation.Nullable;
import com.ss.android.ttvecamera.TELogUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ot3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f19869a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object c = new Object();
    public static int[] d = new int[10];

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19870a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int[] h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final float m;
        public final int n;
        public final int o;
        public final int p;

        public a(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10, float f, int i11, int i12, int i13) {
            this.f19870a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = iArr;
            this.i = i7;
            this.j = i8;
            this.k = i9;
            this.l = i10;
            this.m = f;
            this.n = i11;
            this.o = i12;
            this.p = i13;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19871a;
        public final int b;
        public final boolean c;

        public b(int i, int i2, boolean z) {
            this.f19871a = i;
            this.b = i2;
            this.c = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19872a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final float h;
        public final boolean i;
        public final boolean j;
        public final int k;
        public final int l;
        public final int m;
        public final boolean n;
        public final int o;
        public final int p;
        public final int q;

        public c(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, boolean z, boolean z2, int i8, int i9, int i10, boolean z3, int i11, int i12, int i13) {
            this.f19872a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = f;
            this.i = z;
            this.j = z2;
            this.k = i8;
            this.l = i9;
            this.m = i10;
            this.n = z3;
            this.o = i11;
            this.p = i12;
            this.q = i13;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i4 = byteBuffer.get(i) & UByte.MAX_VALUE;
            if (i2 == 3) {
                if (i4 == 1 && (byteBuffer.get(i3) & TELogUtils.DEBUG_LEVEL_V) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i4 == 0) {
                i2++;
            }
            if (i4 != 0) {
                i2 = 0;
            }
            i = i3;
        }
    }

    public static int c(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        vh.g(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            a(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            a(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            a(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b2 = bArr[i5];
            if ((b2 & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b2 == 1) {
                    a(zArr);
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static int d(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int e(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i) {
        return bArr[i + 3] & TELogUtils.DEBUG_LEVEL_V;
    }

    public static boolean g(@Nullable String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & TELogUtils.DEBUG_LEVEL_V) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b2 & 126) >> 1) == 39;
    }

    public static a h(byte[] bArr, int i, int i2) {
        return i(bArr, i + 2, i2);
    }

    public static a i(byte[] bArr, int i, int i2) {
        int i3;
        float f;
        int iH;
        int i4;
        int i5;
        int i6;
        int i7;
        hc4 hc4Var = new hc4(bArr, i, i2);
        hc4Var.l(4);
        int iE = hc4Var.e(3);
        hc4Var.k();
        int iE2 = hc4Var.e(2);
        boolean zD = hc4Var.d();
        int iE3 = hc4Var.e(5);
        int i8 = 0;
        for (int i9 = 0; i9 < 32; i9++) {
            if (hc4Var.d()) {
                i8 |= 1 << i9;
            }
        }
        int[] iArr = new int[6];
        for (int i10 = 0; i10 < 6; i10++) {
            iArr[i10] = hc4Var.e(8);
        }
        int iE4 = hc4Var.e(8);
        int i11 = 0;
        for (int i12 = 0; i12 < iE; i12++) {
            if (hc4Var.d()) {
                i11 += 89;
            }
            if (hc4Var.d()) {
                i11 += 8;
            }
        }
        hc4Var.l(i11);
        if (iE > 0) {
            hc4Var.l((8 - iE) * 2);
        }
        int iH2 = hc4Var.h();
        int iH3 = hc4Var.h();
        if (iH3 == 3) {
            hc4Var.k();
        }
        int iH4 = hc4Var.h();
        int iH5 = hc4Var.h();
        if (hc4Var.d()) {
            int iH6 = hc4Var.h();
            int iH7 = hc4Var.h();
            int iH8 = hc4Var.h();
            int iH9 = hc4Var.h();
            iH4 -= ((iH3 == 1 || iH3 == 2) ? 2 : 1) * (iH6 + iH7);
            iH5 -= (iH3 == 1 ? 2 : 1) * (iH8 + iH9);
        }
        int i13 = iH5;
        int i14 = iH4;
        int i15 = i13;
        int iH10 = hc4Var.h();
        int iH11 = hc4Var.h();
        int iH12 = hc4Var.h();
        for (int i16 = hc4Var.d() ? 0 : iE; i16 <= iE; i16++) {
            hc4Var.h();
            hc4Var.h();
            hc4Var.h();
        }
        hc4Var.h();
        hc4Var.h();
        hc4Var.h();
        hc4Var.h();
        hc4Var.h();
        hc4Var.h();
        if (hc4Var.d() && hc4Var.d()) {
            n(hc4Var);
        }
        hc4Var.l(2);
        if (hc4Var.d()) {
            hc4Var.l(8);
            hc4Var.h();
            hc4Var.h();
            hc4Var.k();
        }
        p(hc4Var);
        if (hc4Var.d()) {
            int iH13 = hc4Var.h();
            for (int i17 = 0; i17 < iH13; i17++) {
                hc4Var.l(iH12 + 4 + 1);
            }
        }
        hc4Var.l(2);
        float f2 = 1.0f;
        if (hc4Var.d()) {
            if (hc4Var.d()) {
                int iE5 = hc4Var.e(8);
                if (iE5 == 255) {
                    int iE6 = hc4Var.e(16);
                    int iE7 = hc4Var.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f2 = iE6 / iE7;
                    }
                } else {
                    float[] fArr = b;
                    if (iE5 < fArr.length) {
                        f2 = fArr[iE5];
                    } else {
                        y53.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (hc4Var.d()) {
                hc4Var.k();
            }
            if (hc4Var.d()) {
                hc4Var.l(3);
                i7 = hc4Var.d() ? 1 : 2;
                if (hc4Var.d()) {
                    int iE8 = hc4Var.e(8);
                    int iE9 = hc4Var.e(8);
                    hc4Var.l(8);
                    iH = xg0.h(iE8);
                    i6 = xg0.i(iE9);
                } else {
                    i6 = -1;
                    iH = -1;
                }
            } else {
                i6 = -1;
                iH = -1;
                i7 = -1;
            }
            if (hc4Var.d()) {
                hc4Var.h();
                hc4Var.h();
            }
            hc4Var.k();
            if (hc4Var.d()) {
                i15 *= 2;
            }
            i5 = i6;
            i4 = i7;
            f = f2;
            i3 = i15;
        } else {
            i3 = i15;
            f = 1.0f;
            iH = -1;
            i4 = -1;
            i5 = -1;
        }
        return new a(iE2, zD, iE3, i8, iH3, iH10, iH11, iArr, iE4, iH2, i14, i3, f, iH, i4, i5);
    }

    public static b j(byte[] bArr, int i, int i2) {
        return k(bArr, i + 1, i2);
    }

    public static b k(byte[] bArr, int i, int i2) {
        hc4 hc4Var = new hc4(bArr, i, i2);
        int iH = hc4Var.h();
        int iH2 = hc4Var.h();
        hc4Var.k();
        return new b(iH, iH2, hc4Var.d());
    }

    public static c l(byte[] bArr, int i, int i2) {
        return m(bArr, i + 1, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x01b4 A[PHI: r16
      0x01b4: PHI (r16v5 float) = (r16v4 float), (r16v9 float) binds: [B:72:0x0132, B:89:0x0182] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c m(byte[] bArr, int i, int i2) {
        int iH;
        boolean zD;
        int i3;
        boolean z;
        boolean z2;
        int iH2;
        int iH3;
        int i4;
        int i5;
        int i6;
        int i7;
        hc4 hc4Var = new hc4(bArr, i, i2);
        int iE = hc4Var.e(8);
        int iE2 = hc4Var.e(8);
        int iE3 = hc4Var.e(8);
        int iH4 = hc4Var.h();
        if (iE == 100 || iE == 110 || iE == 122 || iE == 244 || iE == 44 || iE == 83 || iE == 86 || iE == 118 || iE == 128 || iE == 138) {
            iH = hc4Var.h();
            zD = iH == 3 ? hc4Var.d() : false;
            hc4Var.h();
            hc4Var.h();
            hc4Var.k();
            if (hc4Var.d()) {
                int i8 = iH != 3 ? 8 : 12;
                int i9 = 0;
                while (i9 < i8) {
                    if (hc4Var.d()) {
                        o(hc4Var, i9 < 6 ? 16 : 64);
                    }
                    i9++;
                }
            }
        } else {
            iH = 1;
            zD = false;
        }
        int iH5 = hc4Var.h() + 4;
        int iH6 = hc4Var.h();
        if (iH6 == 0) {
            i3 = iH;
            z = zD;
            iH2 = hc4Var.h() + 4;
            z2 = false;
        } else {
            if (iH6 == 1) {
                boolean zD2 = hc4Var.d();
                hc4Var.g();
                hc4Var.g();
                z = zD;
                long jH = hc4Var.h();
                i3 = iH;
                for (int i10 = 0; i10 < jH; i10++) {
                    hc4Var.h();
                }
                z2 = zD2;
            } else {
                i3 = iH;
                z = zD;
                z2 = false;
            }
            iH2 = 0;
        }
        int iH7 = hc4Var.h();
        hc4Var.k();
        int iH8 = hc4Var.h() + 1;
        int iH9 = hc4Var.h() + 1;
        boolean zD3 = hc4Var.d();
        int i11 = (2 - (zD3 ? 1 : 0)) * iH9;
        if (!zD3) {
            hc4Var.k();
        }
        hc4Var.k();
        int i12 = iH8 * 16;
        int i13 = i11 * 16;
        if (hc4Var.d()) {
            int iH10 = hc4Var.h();
            int iH11 = hc4Var.h();
            int iH12 = hc4Var.h();
            int iH13 = hc4Var.h();
            if (i3 == 0) {
                i7 = 2 - (zD3 ? 1 : 0);
                i6 = 1;
            } else {
                int i14 = i3;
                i6 = i14 == 3 ? 1 : 2;
                i7 = (i14 == 1 ? 2 : 1) * (2 - (zD3 ? 1 : 0));
            }
            i12 -= (iH10 + iH11) * i6;
            i13 -= (iH12 + iH13) * i7;
        }
        int i15 = i12;
        float f = 1.0f;
        if (hc4Var.d()) {
            if (hc4Var.d()) {
                int iE4 = hc4Var.e(8);
                if (iE4 == 255) {
                    int iE5 = hc4Var.e(16);
                    int iE6 = hc4Var.e(16);
                    if (iE5 != 0 && iE6 != 0) {
                        f = iE5 / iE6;
                    }
                } else {
                    float[] fArr = b;
                    if (iE4 < fArr.length) {
                        f = fArr[iE4];
                    } else {
                        y53.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE4);
                    }
                }
            }
            if (hc4Var.d()) {
                hc4Var.k();
            }
            if (hc4Var.d()) {
                hc4Var.l(3);
                int i16 = hc4Var.d() ? 1 : 2;
                if (hc4Var.d()) {
                    int iE7 = hc4Var.e(8);
                    int iE8 = hc4Var.e(8);
                    hc4Var.l(8);
                    iH3 = xg0.h(iE7);
                    i5 = xg0.i(iE8);
                    i4 = i16;
                } else {
                    i4 = i16;
                    iH3 = -1;
                }
            }
            i5 = -1;
        } else {
            iH3 = -1;
            i4 = -1;
            i5 = -1;
        }
        return new c(iE, iE2, iE3, iH4, iH7, i15, i13, f, z, zD3, iH5, iH6, iH2, z2, iH3, i4, i5);
    }

    public static void n(hc4 hc4Var) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (hc4Var.d()) {
                    int iMin = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        hc4Var.g();
                    }
                    for (int i4 = 0; i4 < iMin; i4++) {
                        hc4Var.g();
                    }
                } else {
                    hc4Var.h();
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    public static void o(hc4 hc4Var, int i) {
        int iG = 8;
        int i2 = 8;
        for (int i3 = 0; i3 < i; i3++) {
            if (iG != 0) {
                iG = ((hc4Var.g() + i2) + 256) % 256;
            }
            if (iG != 0) {
                i2 = iG;
            }
        }
    }

    public static void p(hc4 hc4Var) {
        int iH = hc4Var.h();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        while (i3 < iH) {
            if (i3 != 0 && hc4Var.d()) {
                int i4 = i + i2;
                int iH2 = (1 - ((hc4Var.d() ? 1 : 0) * 2)) * (hc4Var.h() + 1);
                int i5 = i4 + 1;
                boolean[] zArr = new boolean[i5];
                for (int i6 = 0; i6 <= i4; i6++) {
                    if (hc4Var.d()) {
                        zArr[i6] = true;
                    } else {
                        zArr[i6] = hc4Var.d();
                    }
                }
                int[] iArr2 = new int[i5];
                int[] iArr3 = new int[i5];
                int i7 = 0;
                for (int i8 = i2 - 1; i8 >= 0; i8--) {
                    int i9 = iArrCopyOf[i8] + iH2;
                    if (i9 < 0 && zArr[i + i8]) {
                        iArr2[i7] = i9;
                        i7++;
                    }
                }
                if (iH2 < 0 && zArr[i4]) {
                    iArr2[i7] = iH2;
                    i7++;
                }
                for (int i10 = 0; i10 < i; i10++) {
                    int i11 = iArr[i10] + iH2;
                    if (i11 < 0 && zArr[i10]) {
                        iArr2[i7] = i11;
                        i7++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr2, i7);
                int i12 = 0;
                for (int i13 = i - 1; i13 >= 0; i13--) {
                    int i14 = iArr[i13] + iH2;
                    if (i14 > 0 && zArr[i13]) {
                        iArr3[i12] = i14;
                        i12++;
                    }
                }
                if (iH2 > 0 && zArr[i4]) {
                    iArr3[i12] = iH2;
                    i12++;
                }
                for (int i15 = 0; i15 < i2; i15++) {
                    int i16 = iArrCopyOf[i15] + iH2;
                    if (i16 > 0 && zArr[i + i15]) {
                        iArr3[i12] = i16;
                        i12++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr3, i12);
                iArr = iArrCopyOf2;
                i = i7;
                i2 = i12;
            } else {
                int iH3 = hc4Var.h();
                int iH4 = hc4Var.h();
                int[] iArr4 = new int[iH3];
                int i17 = 0;
                while (i17 < iH3) {
                    iArr4[i17] = (i17 > 0 ? iArr4[i17 - 1] : 0) - (hc4Var.h() + 1);
                    hc4Var.k();
                    i17++;
                }
                int[] iArr5 = new int[iH4];
                int i18 = 0;
                while (i18 < iH4) {
                    iArr5[i18] = (i18 > 0 ? iArr5[i18 - 1] : 0) + hc4Var.h() + 1;
                    hc4Var.k();
                    i18++;
                }
                i = iH3;
                iArr = iArr4;
                i2 = iH4;
                iArrCopyOf = iArr5;
            }
            i3++;
        }
    }

    public static int q(byte[] bArr, int i) {
        int i2;
        synchronized (c) {
            int iD = 0;
            int i3 = 0;
            while (iD < i) {
                try {
                    iD = d(bArr, iD, i);
                    if (iD < i) {
                        int[] iArr = d;
                        if (iArr.length <= i3) {
                            d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        d[i3] = iD;
                        iD += 3;
                        i3++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i2 = i - i3;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = d[i6] - i5;
                System.arraycopy(bArr, i5, bArr, i4, i7);
                int i8 = i4 + i7;
                int i9 = i8 + 1;
                bArr[i8] = 0;
                i4 = i9 + 1;
                bArr[i9] = 0;
                i5 += i7 + 3;
            }
            System.arraycopy(bArr, i5, bArr, i4, i2 - i4);
        }
        return i2;
    }
}
