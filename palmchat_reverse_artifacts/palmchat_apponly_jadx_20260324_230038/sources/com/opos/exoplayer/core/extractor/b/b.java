package com.opos.exoplayer.core.extractor.b;

import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.p;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class b {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8160a;
        public final int b;
        public final long[] c;
        public final int d;
        public final boolean e;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f8160a = i;
            this.b = i2;
            this.c = jArr;
            this.d = i3;
            this.e = z;
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.extractor.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0689b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8161a;
        public final String[] b;
        public final int c;

        public C0689b(String str, String[] strArr, int i) {
            this.f8161a = str;
            this.b = strArr;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f8162a;
        public final int b;
        public final int c;
        public final int d;

        public c(boolean z, int i, int i2, int i3) {
            this.f8162a = z;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f8163a;
        public final int b;
        public final long c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public d(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.f8163a = j;
            this.b = i;
            this.c = j2;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = i5;
            this.h = i6;
            this.i = z;
            this.j = bArr;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static C0689b b(p pVar) throws m {
        a(3, pVar, false);
        String strE = pVar.e((int) pVar.n());
        int length = strE.length() + 11;
        long jN = pVar.n();
        String[] strArr = new String[(int) jN];
        int length2 = length + 4;
        for (int i = 0; i < jN; i++) {
            String strE2 = pVar.e((int) pVar.n());
            strArr[i] = strE2;
            length2 = length2 + 4 + strE2.length();
        }
        if ((pVar.g() & 1) != 0) {
            return new C0689b(strE, strArr, length2 + 1);
        }
        throw new m("framing bit expected to be set");
    }

    private static void c(j jVar) throws m {
        int iA = jVar.a(6) + 1;
        for (int i = 0; i < iA; i++) {
            int iA2 = jVar.a(16);
            if (iA2 == 0) {
                jVar.b(8);
                jVar.b(16);
                jVar.b(16);
                jVar.b(6);
                jVar.b(8);
                int iA3 = jVar.a(4) + 1;
                for (int i2 = 0; i2 < iA3; i2++) {
                    jVar.b(8);
                }
            } else {
                if (iA2 != 1) {
                    throw new m("floor type greater than 1 not decodable: " + iA2);
                }
                int iA4 = jVar.a(5);
                int[] iArr = new int[iA4];
                int i3 = -1;
                for (int i4 = 0; i4 < iA4; i4++) {
                    int iA5 = jVar.a(4);
                    iArr[i4] = iA5;
                    if (iA5 > i3) {
                        i3 = iA5;
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = jVar.a(3) + 1;
                    int iA6 = jVar.a(2);
                    if (iA6 > 0) {
                        jVar.b(8);
                    }
                    for (int i7 = 0; i7 < (1 << iA6); i7++) {
                        jVar.b(8);
                    }
                }
                jVar.b(2);
                int iA7 = jVar.a(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < iA4; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        jVar.b(iA7);
                        i9++;
                    }
                }
            }
        }
    }

    private static a d(j jVar) throws m {
        if (jVar.a(24) != 5653314) {
            throw new m("expected code book to start with [0x56, 0x43, 0x42] at " + jVar.b());
        }
        int iA = jVar.a(16);
        int iA2 = jVar.a(24);
        long[] jArr = new long[iA2];
        boolean zA = jVar.a();
        long jA = 0;
        if (zA) {
            int iA3 = jVar.a(5) + 1;
            int i = 0;
            while (i < iA2) {
                int iA4 = jVar.a(a(iA2 - i));
                for (int i2 = 0; i2 < iA4 && i < iA2; i2++) {
                    jArr[i] = iA3;
                    i++;
                }
                iA3++;
            }
        } else {
            boolean zA2 = jVar.a();
            for (int i3 = 0; i3 < iA2; i3++) {
                if (!zA2) {
                    jArr[i3] = jVar.a(5) + 1;
                } else if (jVar.a()) {
                    jArr[i3] = jVar.a(5) + 1;
                } else {
                    jArr[i3] = 0;
                }
            }
        }
        int iA5 = jVar.a(4);
        if (iA5 > 2) {
            throw new m("lookup type greater than 2 not decodable: " + iA5);
        }
        if (iA5 == 1 || iA5 == 2) {
            jVar.b(32);
            jVar.b(32);
            int iA6 = jVar.a(4) + 1;
            jVar.b(1);
            if (iA5 != 1) {
                jA = iA2 * iA;
            } else if (iA != 0) {
                jA = a(iA2, iA);
            }
            jVar.b((int) (jA * ((long) iA6)));
        }
        return new a(iA, iA2, jArr, iA5, zA);
    }

    private static long a(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    private static void b(j jVar) throws m {
        int iA = jVar.a(6) + 1;
        for (int i = 0; i < iA; i++) {
            if (jVar.a(16) > 2) {
                throw new m("residueType greater than 2 is not decodable");
            }
            jVar.b(24);
            jVar.b(24);
            jVar.b(24);
            int iA2 = jVar.a(6) + 1;
            jVar.b(8);
            int[] iArr = new int[iA2];
            for (int i2 = 0; i2 < iA2; i2++) {
                iArr[i2] = ((jVar.a() ? jVar.a(5) : 0) * 8) + jVar.a(3);
            }
            for (int i3 = 0; i3 < iA2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        jVar.b(8);
                    }
                }
            }
        }
    }

    public static d a(p pVar) throws m {
        a(1, pVar, false);
        long jN = pVar.n();
        int iG = pVar.g();
        long jN2 = pVar.n();
        int iP = pVar.p();
        int iP2 = pVar.p();
        int iP3 = pVar.p();
        int iG2 = pVar.g();
        return new d(jN, iG, jN2, iP, iP2, iP3, (int) Math.pow(2.0d, iG2 & 15), (int) Math.pow(2.0d, (iG2 & 240) >> 4), (pVar.g() & 1) > 0, Arrays.copyOf(pVar.f8400a, pVar.c()));
    }

    private static void a(int i, j jVar) throws m {
        int iA = jVar.a(6) + 1;
        for (int i2 = 0; i2 < iA; i2++) {
            int iA2 = jVar.a(16);
            if (iA2 != 0) {
                com.opos.cmn.an.f.a.d("VorbisUtil", "mapping type other than 0 not supported: " + iA2);
            } else {
                int iA3 = jVar.a() ? jVar.a(4) + 1 : 1;
                if (jVar.a()) {
                    int iA4 = jVar.a(8) + 1;
                    for (int i3 = 0; i3 < iA4; i3++) {
                        int i4 = i - 1;
                        jVar.b(a(i4));
                        jVar.b(a(i4));
                    }
                }
                if (jVar.a(2) != 0) {
                    throw new m("to reserved bits must be zero after mapping coupling steps");
                }
                if (iA3 > 1) {
                    for (int i5 = 0; i5 < i; i5++) {
                        jVar.b(4);
                    }
                }
                for (int i6 = 0; i6 < iA3; i6++) {
                    jVar.b(8);
                    jVar.b(8);
                    jVar.b(8);
                }
            }
        }
    }

    public static boolean a(int i, p pVar, boolean z) throws m {
        if (pVar.b() < 7) {
            if (z) {
                return false;
            }
            throw new m("too short header: " + pVar.b());
        }
        if (pVar.g() != i) {
            if (z) {
                return false;
            }
            throw new m("expected header type " + Integer.toHexString(i));
        }
        if (pVar.g() == 118 && pVar.g() == 111 && pVar.g() == 114 && pVar.g() == 98 && pVar.g() == 105 && pVar.g() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw new m("expected characters 'vorbis'");
    }

    private static c[] a(j jVar) {
        int iA = jVar.a(6) + 1;
        c[] cVarArr = new c[iA];
        for (int i = 0; i < iA; i++) {
            cVarArr[i] = new c(jVar.a(), jVar.a(16), jVar.a(16), jVar.a(8));
        }
        return cVarArr;
    }

    public static c[] a(p pVar, int i) throws m {
        a(5, pVar, false);
        int iG = pVar.g() + 1;
        j jVar = new j(pVar.f8400a);
        jVar.b(pVar.d() * 8);
        for (int i2 = 0; i2 < iG; i2++) {
            d(jVar);
        }
        int iA = jVar.a(6) + 1;
        for (int i3 = 0; i3 < iA; i3++) {
            if (jVar.a(16) != 0) {
                throw new m("placeholder of time domain transforms not zeroed out");
            }
        }
        c(jVar);
        b(jVar);
        a(i, jVar);
        c[] cVarArrA = a(jVar);
        if (jVar.a()) {
            return cVarArrA;
        }
        throw new m("framing bit after modes not set as expected");
    }
}
