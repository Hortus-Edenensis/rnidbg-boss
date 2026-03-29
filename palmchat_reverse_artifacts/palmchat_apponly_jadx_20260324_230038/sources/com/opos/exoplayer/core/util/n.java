package com.opos.exoplayer.core.util;

import com.ss.android.ttvecamera.TELogUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f8396a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object c = new Object();
    private static int[] d = new int[10];

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8397a;
        public final int b;
        public final boolean c;

        public a(int i, int i2, boolean z) {
            this.f8397a = i;
            this.b = i2;
            this.c = z;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8398a;
        public final int b;
        public final int c;
        public final float d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public final int h;
        public final int i;
        public final boolean j;

        public b(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.f8398a = i;
            this.b = i2;
            this.c = i3;
            this.d = f;
            this.e = z;
            this.f = z2;
            this.g = i4;
            this.h = i5;
            this.i = i6;
            this.j = z3;
        }
    }

    public static int a(byte[] bArr, int i) {
        int i2;
        synchronized (c) {
            int iC = 0;
            int i3 = 0;
            while (iC < i) {
                try {
                    iC = c(bArr, iC, i);
                    if (iC < i) {
                        int[] iArr = d;
                        if (iArr.length <= i3) {
                            d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        d[i3] = iC;
                        iC += 3;
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
                int i7 = d[i6] - i4;
                System.arraycopy(bArr, i4, bArr, i5, i7);
                int i8 = i5 + i7;
                int i9 = i8 + 1;
                bArr[i8] = 0;
                i5 = i9 + 1;
                bArr[i9] = 0;
                i4 += i7 + 3;
            }
            System.arraycopy(bArr, i4, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static int b(byte[] bArr, int i) {
        return bArr[i + 3] & TELogUtils.DEBUG_LEVEL_V;
    }

    public static int c(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0093, code lost:
    
        r9 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        com.opos.exoplayer.core.util.a.b(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr != null) {
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
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b2 = bArr[i5];
            if ((b2 & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b2 == 1) {
                    if (zArr != null) {
                        a(zArr);
                    }
                    return i6;
                }
                i5 -= 2;
            }
            i5 += 3;
        }
        if (zArr != null) {
            boolean z = i3 > 2 ? false : false;
            zArr[0] = z;
            zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
            zArr[2] = bArr[i4] == 0;
        }
        return i2;
    }

    public static a b(byte[] bArr, int i, int i2) {
        q qVar = new q(bArr, i, i2);
        qVar.a(8);
        int iD = qVar.d();
        int iD2 = qVar.d();
        qVar.a();
        return new a(iD, iD2, qVar.b());
    }

    private static int c(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(byte[] bArr, int i, int i2) {
        int iD;
        boolean z;
        boolean z2;
        int iD2;
        boolean z3;
        boolean zB;
        float f;
        q qVar = new q(bArr, i, i2);
        qVar.a(8);
        int iC = qVar.c(8);
        qVar.a(16);
        int iD3 = qVar.d();
        if (iC == 100 || iC == 110 || iC == 122 || iC == 244 || iC == 44 || iC == 83 || iC == 86 || iC == 118 || iC == 128 || iC == 138) {
            iD = qVar.d();
            boolean zB2 = iD == 3 ? qVar.b() : false;
            qVar.d();
            qVar.d();
            qVar.a();
            if (qVar.b()) {
                int i3 = iD != 3 ? 8 : 12;
                int i4 = 0;
                while (i4 < i3) {
                    if (qVar.b()) {
                        a(qVar, i4 < 6 ? 16 : 64);
                    }
                    i4++;
                }
            }
            z = zB2;
        } else {
            iD = 1;
            z = false;
        }
        int iD4 = qVar.d() + 4;
        int iD5 = qVar.d();
        if (iD5 == 0) {
            iD2 = qVar.d() + 4;
            z2 = z;
        } else {
            if (iD5 == 1) {
                boolean zB3 = qVar.b();
                qVar.e();
                qVar.e();
                long jD = qVar.d();
                z2 = z;
                for (int i5 = 0; i5 < jD; i5++) {
                    qVar.d();
                }
                z3 = zB3;
                iD2 = 0;
                qVar.d();
                qVar.a();
                int iD6 = qVar.d() + 1;
                int iD7 = qVar.d() + 1;
                zB = qVar.b();
                int i6 = 2 - (zB ? 1 : 0);
                int i7 = iD7 * i6;
                if (!zB) {
                    qVar.a();
                }
                qVar.a();
                int i8 = iD6 * 16;
                int i9 = i7 * 16;
                if (qVar.b()) {
                    int iD8 = qVar.d();
                    int iD9 = qVar.d();
                    int iD10 = qVar.d();
                    int iD11 = qVar.d();
                    if (iD != 0) {
                        int i10 = iD == 3 ? 1 : 2;
                        i6 *= iD == 1 ? 2 : 1;
                        i = i10;
                    }
                    i8 -= (iD8 + iD9) * i;
                    i9 -= (iD10 + iD11) * i6;
                }
                int i11 = i8;
                int i12 = i9;
                if (qVar.b() || !qVar.b()) {
                    f = 1.0f;
                } else {
                    int iC2 = qVar.c(8);
                    if (iC2 == 255) {
                        int iC3 = qVar.c(16);
                        int iC4 = qVar.c(16);
                        if (iC3 != 0 && iC4 != 0) {
                            f = iC3 / iC4;
                        }
                    } else {
                        float[] fArr = b;
                        if (iC2 < fArr.length) {
                            f = fArr[iC2];
                        } else {
                            com.opos.cmn.an.f.a.c("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iC2);
                            f = 1.0f;
                        }
                    }
                }
                return new b(iD3, i11, i12, f, z2, zB, iD4, iD5, iD2, z3);
            }
            z2 = z;
            iD2 = 0;
        }
        z3 = false;
        qVar.d();
        qVar.a();
        int iD62 = qVar.d() + 1;
        int iD72 = qVar.d() + 1;
        zB = qVar.b();
        int i62 = 2 - (zB ? 1 : 0);
        int i72 = iD72 * i62;
        if (!zB) {
        }
        qVar.a();
        int i82 = iD62 * 16;
        int i92 = i72 * 16;
        if (qVar.b()) {
        }
        int i112 = i82;
        int i122 = i92;
        if (qVar.b()) {
            f = 1.0f;
        }
        return new b(iD3, i112, i122, f, z2, zB, iD4, iD5, iD2, z3);
    }

    private static void a(q qVar, int i) {
        int iE = 8;
        int i2 = 8;
        for (int i3 = 0; i3 < i; i3++) {
            if (iE != 0) {
                iE = ((qVar.e() + i2) + 256) % 256;
            }
            if (iE != 0) {
                i2 = iE;
            }
        }
    }

    public static void a(ByteBuffer byteBuffer) {
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

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean a(String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & TELogUtils.DEBUG_LEVEL_V) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b2 & 126) >> 1) == 39;
    }
}
