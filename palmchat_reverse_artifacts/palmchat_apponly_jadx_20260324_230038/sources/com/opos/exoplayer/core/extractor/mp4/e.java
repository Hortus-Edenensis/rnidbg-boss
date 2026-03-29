package com.opos.exoplayer.core.extractor.mp4;

import android.util.Pair;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.mp4.a;
import com.opos.exoplayer.core.extractor.mp4.d;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.util.m;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import com.opos.exoplayer.core.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f8208a = y.f("vide");
    private static final int b = y.f("soun");
    private static final int c = y.f("text");
    private static final int d = y.f("sbtl");
    private static final int e = y.f("subt");
    private static final int f = y.f("clcp");
    private static final int g = y.f("meta");

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8209a;
        public int b;
        public int c;
        public long d;
        private final boolean e;
        private final p f;
        private final p g;
        private int h;
        private int i;

        public a(p pVar, p pVar2, boolean z) {
            this.g = pVar;
            this.f = pVar2;
            this.e = z;
            pVar2.c(12);
            this.f8209a = pVar2.u();
            pVar.c(12);
            this.i = pVar.u();
            com.opos.exoplayer.core.util.a.b(pVar.o() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.f8209a) {
                return false;
            }
            this.d = this.e ? this.f.w() : this.f.m();
            if (this.b == this.h) {
                this.c = this.g.u();
                this.g.d(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.u() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        int a();

        int b();

        boolean c();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.exoplayer.core.extractor.mp4.c[] f8210a;
        public Format b;
        public int c;
        public int d = 0;

        public c(int i) {
            this.f8210a = new com.opos.exoplayer.core.extractor.mp4.c[i];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8211a;
        private final int b;
        private final p c;

        public d(d.b bVar) {
            p pVar = bVar.aP;
            this.c = pVar;
            pVar.c(12);
            this.f8211a = pVar.u();
            this.b = pVar.u();
        }

        @Override // com.opos.exoplayer.core.extractor.mp4.e.b
        public int a() {
            return this.b;
        }

        @Override // com.opos.exoplayer.core.extractor.mp4.e.b
        public int b() {
            int i = this.f8211a;
            return i == 0 ? this.c.u() : i;
        }

        @Override // com.opos.exoplayer.core.extractor.mp4.e.b
        public boolean c() {
            return this.f8211a != 0;
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.extractor.mp4.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0693e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p f8212a;
        private final int b;
        private final int c;
        private int d;
        private int e;

        public C0693e(d.b bVar) {
            p pVar = bVar.aP;
            this.f8212a = pVar;
            pVar.c(12);
            this.c = pVar.u() & 255;
            this.b = pVar.u();
        }

        @Override // com.opos.exoplayer.core.extractor.mp4.e.b
        public int a() {
            return this.b;
        }

        @Override // com.opos.exoplayer.core.extractor.mp4.e.b
        public int b() {
            int i = this.c;
            if (i == 8) {
                return this.f8212a.g();
            }
            if (i == 16) {
                return this.f8212a.h();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int iG = this.f8212a.g();
            this.e = iG;
            return (iG & 240) >> 4;
        }

        @Override // com.opos.exoplayer.core.extractor.mp4.e.b
        public boolean c() {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8213a;
        private final long b;
        private final int c;

        public f(int i, long j, int i2) {
            this.f8213a = i;
            this.b = j;
            this.c = i2;
        }
    }

    private static long a(p pVar) {
        pVar.c(8);
        pVar.d(com.opos.exoplayer.core.extractor.mp4.d.a(pVar.o()) != 0 ? 16 : 8);
        return pVar.m();
    }

    private static int b(p pVar, int i, int i2) {
        int iD = pVar.d();
        while (iD - i < i2) {
            pVar.c(iD);
            int iO = pVar.o();
            com.opos.exoplayer.core.util.a.a(iO > 0, "childAtomSize should be positive");
            if (pVar.o() == com.opos.exoplayer.core.extractor.mp4.d.J) {
                return iD;
            }
            iD += iO;
        }
        return -1;
    }

    private static float c(p pVar, int i) {
        pVar.c(i + 8);
        return pVar.u() / pVar.u();
    }

    private static Pair<Long, String> d(p pVar) {
        pVar.c(8);
        int iA = com.opos.exoplayer.core.extractor.mp4.d.a(pVar.o());
        pVar.d(iA == 0 ? 8 : 16);
        long jM = pVar.m();
        pVar.d(iA == 0 ? 4 : 8);
        int iH = pVar.h();
        return Pair.create(Long.valueOf(jM), "" + ((char) (((iH >> 10) & 31) + 96)) + ((char) (((iH >> 5) & 31) + 96)) + ((char) ((iH & 31) + 96)));
    }

    private static int e(p pVar) {
        int iG = pVar.g();
        int i = iG & 127;
        while ((iG & 128) == 128) {
            iG = pVar.g();
            i = (i << 7) | (iG & 127);
        }
        return i;
    }

    private static Pair<long[], long[]> a(d.a aVar) {
        d.b bVarD;
        if (aVar == null || (bVarD = aVar.d(com.opos.exoplayer.core.extractor.mp4.d.Q)) == null) {
            return Pair.create(null, null);
        }
        p pVar = bVarD.aP;
        pVar.c(8);
        int iA = com.opos.exoplayer.core.extractor.mp4.d.a(pVar.o());
        int iU = pVar.u();
        long[] jArr = new long[iU];
        long[] jArr2 = new long[iU];
        for (int i = 0; i < iU; i++) {
            jArr[i] = iA == 1 ? pVar.w() : pVar.m();
            jArr2[i] = iA == 1 ? pVar.q() : pVar.o();
            if (pVar.j() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            pVar.d(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static f b(p pVar) {
        boolean z;
        pVar.c(8);
        int iA = com.opos.exoplayer.core.extractor.mp4.d.a(pVar.o());
        pVar.d(iA == 0 ? 8 : 16);
        int iO = pVar.o();
        pVar.d(4);
        int iD = pVar.d();
        int i = iA == 0 ? 4 : 8;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            }
            if (pVar.f8400a[iD + i3] != -1) {
                z = false;
                break;
            }
            i3++;
        }
        long j = -9223372036854775807L;
        if (z) {
            pVar.d(i);
        } else {
            long jM = iA == 0 ? pVar.m() : pVar.w();
            if (jM != 0) {
                j = jM;
            }
        }
        pVar.d(16);
        int iO2 = pVar.o();
        int iO3 = pVar.o();
        pVar.d(4);
        int iO4 = pVar.o();
        int iO5 = pVar.o();
        if (iO2 == 0 && iO3 == 65536 && iO4 == -65536 && iO5 == 0) {
            i2 = 90;
        } else if (iO2 == 0 && iO3 == -65536 && iO4 == 65536 && iO5 == 0) {
            i2 = 270;
        } else if (iO2 == -65536 && iO3 == 0 && iO4 == 0 && iO5 == -65536) {
            i2 = EffectConstants.ROTATION_DEGREES_180;
        }
        return new f(iO, j, i2);
    }

    private static int c(p pVar) {
        pVar.c(16);
        int iO = pVar.o();
        if (iO == b) {
            return 1;
        }
        if (iO == f8208a) {
            return 2;
        }
        if (iO == c || iO == d || iO == e || iO == f) {
            return 3;
        }
        return iO == g ? 4 : -1;
    }

    private static Pair<String, byte[]> d(p pVar, int i) {
        pVar.c(i + 8 + 4);
        pVar.d(1);
        e(pVar);
        pVar.d(2);
        int iG = pVar.g();
        if ((iG & 128) != 0) {
            pVar.d(2);
        }
        if ((iG & 64) != 0) {
            pVar.d(pVar.h());
        }
        if ((iG & 32) != 0) {
            pVar.d(2);
        }
        pVar.d(1);
        e(pVar);
        String strA = m.a(pVar.g());
        if ("audio/mpeg".equals(strA) || "audio/vnd.dts".equals(strA) || "audio/vnd.dts.hd".equals(strA)) {
            return Pair.create(strA, null);
        }
        pVar.d(12);
        pVar.d(1);
        int iE = e(pVar);
        byte[] bArr = new byte[iE];
        pVar.a(bArr, 0, iE);
        return Pair.create(strA, bArr);
    }

    public static Pair<Integer, com.opos.exoplayer.core.extractor.mp4.c> a(p pVar, int i, int i2) {
        int i3 = i + 8;
        String strE = null;
        Integer numValueOf = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            pVar.c(i3);
            int iO = pVar.o();
            int iO2 = pVar.o();
            if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.ab) {
                numValueOf = Integer.valueOf(pVar.o());
            } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.W) {
                pVar.d(4);
                strE = pVar.e(4);
            } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.X) {
                i4 = i3;
                i5 = iO;
            }
            i3 += iO;
        }
        if (!"cenc".equals(strE) && !"cbc1".equals(strE) && !"cens".equals(strE) && !"cbcs".equals(strE)) {
            return null;
        }
        com.opos.exoplayer.core.util.a.a(numValueOf != null, "frma atom is mandatory");
        com.opos.exoplayer.core.util.a.a(i4 != -1, "schi atom is mandatory");
        com.opos.exoplayer.core.extractor.mp4.c cVarA = a(pVar, i4, i5, strE);
        com.opos.exoplayer.core.util.a.a(cVarA != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, cVarA);
    }

    private static Metadata b(p pVar, int i) {
        pVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (pVar.d() < i) {
            Metadata.Entry entryA = g.a(pVar);
            if (entryA != null) {
                arrayList.add(entryA);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Pair<Integer, com.opos.exoplayer.core.extractor.mp4.c> c(p pVar, int i, int i2) {
        Pair<Integer, com.opos.exoplayer.core.extractor.mp4.c> pairA;
        int iD = pVar.d();
        while (iD - i < i2) {
            pVar.c(iD);
            int iO = pVar.o();
            com.opos.exoplayer.core.util.a.a(iO > 0, "childAtomSize should be positive");
            if (pVar.o() == com.opos.exoplayer.core.extractor.mp4.d.V && (pairA = a(pVar, iD, iO)) != null) {
                return pairA;
            }
            iD += iO;
        }
        return null;
    }

    private static byte[] d(p pVar, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            pVar.c(i3);
            int iO = pVar.o();
            if (pVar.o() == com.opos.exoplayer.core.extractor.mp4.d.aI) {
                return Arrays.copyOfRange(pVar.f8400a, i3, iO + i3);
            }
            i3 += iO;
        }
        return null;
    }

    public static Track a(d.a aVar, d.b bVar, long j, DrmInitData drmInitData, boolean z, boolean z2) throws com.opos.exoplayer.core.m {
        d.b bVar2;
        long j2;
        long[] jArr;
        long[] jArr2;
        d.a aVarE = aVar.e(com.opos.exoplayer.core.extractor.mp4.d.E);
        int iC = c(aVarE.d(com.opos.exoplayer.core.extractor.mp4.d.S).aP);
        if (iC == -1) {
            return null;
        }
        f fVarB = b(aVar.d(com.opos.exoplayer.core.extractor.mp4.d.O).aP);
        if (j == -9223372036854775807L) {
            bVar2 = bVar;
            j2 = fVarB.b;
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        long jA = a(bVar2.aP);
        long jD = j2 != -9223372036854775807L ? y.d(j2, 1000000L, jA) : -9223372036854775807L;
        d.a aVarE2 = aVarE.e(com.opos.exoplayer.core.extractor.mp4.d.F).e(com.opos.exoplayer.core.extractor.mp4.d.G);
        Pair<Long, String> pairD = d(aVarE.d(com.opos.exoplayer.core.extractor.mp4.d.R).aP);
        c cVarA = a(aVarE2.d(com.opos.exoplayer.core.extractor.mp4.d.T).aP, fVarB.f8213a, fVarB.c, (String) pairD.second, drmInitData, z2);
        if (z) {
            jArr = null;
            jArr2 = null;
        } else {
            Pair<long[], long[]> pairA = a(aVar.e(com.opos.exoplayer.core.extractor.mp4.d.P));
            long[] jArr3 = (long[]) pairA.first;
            jArr2 = (long[]) pairA.second;
            jArr = jArr3;
        }
        if (cVarA.b == null) {
            return null;
        }
        return new Track(fVarB.f8213a, iC, ((Long) pairD.first).longValue(), jA, jD, cVarA.b, cVarA.d, cVarA.f8210a, cVarA.c, jArr, jArr2);
    }

    private static com.opos.exoplayer.core.extractor.mp4.c a(p pVar, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            pVar.c(i5);
            int iO = pVar.o();
            if (pVar.o() == com.opos.exoplayer.core.extractor.mp4.d.Y) {
                int iA = com.opos.exoplayer.core.extractor.mp4.d.a(pVar.o());
                pVar.d(1);
                if (iA == 0) {
                    pVar.d(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int iG = pVar.g();
                    i3 = iG & 15;
                    i4 = (iG & 240) >> 4;
                }
                boolean z = pVar.g() == 1;
                int iG2 = pVar.g();
                byte[] bArr2 = new byte[16];
                pVar.a(bArr2, 0, 16);
                if (z && iG2 == 0) {
                    int iG3 = pVar.g();
                    bArr = new byte[iG3];
                    pVar.a(bArr, 0, iG3);
                }
                return new com.opos.exoplayer.core.extractor.mp4.c(z, str, iG2, bArr2, i4, i3, bArr);
            }
            i5 += iO;
        }
    }

    private static c a(p pVar, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws com.opos.exoplayer.core.m {
        pVar.c(12);
        int iO = pVar.o();
        c cVar = new c(iO);
        for (int i3 = 0; i3 < iO; i3++) {
            int iD = pVar.d();
            int iO2 = pVar.o();
            com.opos.exoplayer.core.util.a.a(iO2 > 0, "childAtomSize should be positive");
            int iO3 = pVar.o();
            if (iO3 == com.opos.exoplayer.core.extractor.mp4.d.b || iO3 == com.opos.exoplayer.core.extractor.mp4.d.c || iO3 == com.opos.exoplayer.core.extractor.mp4.d.Z || iO3 == com.opos.exoplayer.core.extractor.mp4.d.ak || iO3 == com.opos.exoplayer.core.extractor.mp4.d.d || iO3 == com.opos.exoplayer.core.extractor.mp4.d.e || iO3 == com.opos.exoplayer.core.extractor.mp4.d.f || iO3 == com.opos.exoplayer.core.extractor.mp4.d.aJ || iO3 == com.opos.exoplayer.core.extractor.mp4.d.aK) {
                a(pVar, iO3, iD, iO2, i, i2, drmInitData, cVar, i3);
            } else if (iO3 == com.opos.exoplayer.core.extractor.mp4.d.i || iO3 == com.opos.exoplayer.core.extractor.mp4.d.aa || iO3 == com.opos.exoplayer.core.extractor.mp4.d.n || iO3 == com.opos.exoplayer.core.extractor.mp4.d.p || iO3 == com.opos.exoplayer.core.extractor.mp4.d.r || iO3 == com.opos.exoplayer.core.extractor.mp4.d.u || iO3 == com.opos.exoplayer.core.extractor.mp4.d.s || iO3 == com.opos.exoplayer.core.extractor.mp4.d.t || iO3 == com.opos.exoplayer.core.extractor.mp4.d.ax || iO3 == com.opos.exoplayer.core.extractor.mp4.d.ay || iO3 == com.opos.exoplayer.core.extractor.mp4.d.l || iO3 == com.opos.exoplayer.core.extractor.mp4.d.m || iO3 == com.opos.exoplayer.core.extractor.mp4.d.j || iO3 == com.opos.exoplayer.core.extractor.mp4.d.aN) {
                a(pVar, iO3, iD, iO2, i, str, z, drmInitData, cVar, i3);
            } else if (iO3 == com.opos.exoplayer.core.extractor.mp4.d.aj || iO3 == com.opos.exoplayer.core.extractor.mp4.d.at || iO3 == com.opos.exoplayer.core.extractor.mp4.d.au || iO3 == com.opos.exoplayer.core.extractor.mp4.d.av || iO3 == com.opos.exoplayer.core.extractor.mp4.d.aw) {
                a(pVar, iO3, iD, iO2, i, str, cVar);
            } else if (iO3 == com.opos.exoplayer.core.extractor.mp4.d.aM) {
                cVar.b = Format.a(Integer.toString(i), "application/x-camera-motion", (String) null, -1, (DrmInitData) null);
            }
            pVar.c(iD + iO2);
        }
        return cVar;
    }

    public static j a(Track track, d.a aVar, com.opos.exoplayer.core.extractor.i iVar) throws com.opos.exoplayer.core.m {
        b c0693e;
        boolean z;
        int iU;
        int iU2;
        Track track2;
        int i;
        String str;
        long[] jArr;
        int[] iArr;
        int i2;
        long[] jArr2;
        int[] iArr2;
        long j;
        long[] jArr3;
        int i3;
        int[] iArr3;
        int[] iArr4;
        long[] jArr4;
        boolean z2;
        int[] iArr5;
        int[] iArr6;
        int[] iArr7;
        String str2;
        int[] iArr8;
        int i4;
        d.b bVarD = aVar.d(com.opos.exoplayer.core.extractor.mp4.d.ap);
        if (bVarD != null) {
            c0693e = new d(bVarD);
        } else {
            d.b bVarD2 = aVar.d(com.opos.exoplayer.core.extractor.mp4.d.aq);
            if (bVarD2 == null) {
                throw new com.opos.exoplayer.core.m("Track has no sample table size information");
            }
            c0693e = new C0693e(bVarD2);
        }
        int iA = c0693e.a();
        if (iA == 0) {
            return new j(new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        d.b bVarD3 = aVar.d(com.opos.exoplayer.core.extractor.mp4.d.ar);
        if (bVarD3 == null) {
            bVarD3 = aVar.d(com.opos.exoplayer.core.extractor.mp4.d.as);
            z = true;
        } else {
            z = false;
        }
        p pVar = bVarD3.aP;
        p pVar2 = aVar.d(com.opos.exoplayer.core.extractor.mp4.d.ao).aP;
        p pVar3 = aVar.d(com.opos.exoplayer.core.extractor.mp4.d.al).aP;
        d.b bVarD4 = aVar.d(com.opos.exoplayer.core.extractor.mp4.d.am);
        p pVar4 = null;
        p pVar5 = bVarD4 != null ? bVarD4.aP : null;
        d.b bVarD5 = aVar.d(com.opos.exoplayer.core.extractor.mp4.d.an);
        p pVar6 = bVarD5 != null ? bVarD5.aP : null;
        a aVar2 = new a(pVar2, pVar, z);
        pVar3.c(12);
        int iU3 = pVar3.u() - 1;
        int iU4 = pVar3.u();
        int iU5 = pVar3.u();
        if (pVar6 != null) {
            pVar6.c(12);
            iU = pVar6.u();
        } else {
            iU = 0;
        }
        int iU6 = -1;
        if (pVar5 != null) {
            pVar5.c(12);
            iU2 = pVar5.u();
            if (iU2 > 0) {
                iU6 = pVar5.u() - 1;
                pVar4 = pVar5;
            }
        } else {
            pVar4 = pVar5;
            iU2 = 0;
        }
        long j2 = 0;
        if (c0693e.c() && "audio/raw".equals(track.f.f) && iU3 == 0 && iU == 0 && iU2 == 0) {
            track2 = track;
            i = iA;
            b bVar = c0693e;
            str = "AtomParsers";
            int i5 = aVar2.f8209a;
            long[] jArr5 = new long[i5];
            int[] iArr9 = new int[i5];
            while (aVar2.a()) {
                int i6 = aVar2.b;
                jArr5[i6] = aVar2.d;
                iArr9[i6] = aVar2.c;
            }
            a.C0692a c0692aA = com.opos.exoplayer.core.extractor.mp4.a.a(bVar.b(), jArr5, iArr9, iU5);
            jArr = c0692aA.f8204a;
            iArr = c0692aA.b;
            i2 = c0692aA.c;
            jArr2 = c0692aA.d;
            iArr2 = c0692aA.e;
            j = c0692aA.f;
        } else {
            jArr = new long[iA];
            iArr = new int[iA];
            int i7 = iU2;
            jArr2 = new long[iA];
            iArr2 = new int[iA];
            int iO = iU5;
            long j3 = 0;
            long j4 = 0;
            int i8 = iU3;
            int i9 = 0;
            i2 = 0;
            int iU7 = 0;
            int iO2 = 0;
            int i10 = 0;
            int i11 = i7;
            int iU8 = iU6;
            int i12 = iU;
            int i13 = iU4;
            while (i9 < iA) {
                while (i10 == 0) {
                    com.opos.exoplayer.core.util.a.b(aVar2.a());
                    j4 = aVar2.d;
                    i10 = aVar2.c;
                    i8 = i8;
                    i13 = i13;
                }
                int i14 = i8;
                int i15 = i13;
                if (pVar6 != null) {
                    while (iU7 == 0 && i12 > 0) {
                        iU7 = pVar6.u();
                        iO2 = pVar6.o();
                        i12--;
                    }
                    iU7--;
                }
                int i16 = iO2;
                jArr[i9] = j4;
                int iB = c0693e.b();
                iArr[i9] = iB;
                int i17 = iA;
                if (iB > i2) {
                    i2 = iB;
                }
                b bVar2 = c0693e;
                jArr2[i9] = j3 + ((long) i16);
                iArr2[i9] = pVar4 == null ? 1 : 0;
                if (i9 == iU8) {
                    iArr2[i9] = 1;
                    i11--;
                    if (i11 > 0) {
                        iU8 = pVar4.u() - 1;
                    }
                }
                j3 += (long) iO;
                int iU9 = i15 - 1;
                if (iU9 == 0 && i14 > 0) {
                    i14--;
                    iU9 = pVar3.u();
                    iO = pVar3.o();
                }
                int i18 = iU9;
                j4 += (long) iArr[i9];
                i10--;
                i9++;
                c0693e = bVar2;
                iA = i17;
                iO = iO;
                i13 = i18;
                iO2 = i16;
                i8 = i14;
            }
            int i19 = i8;
            int i20 = i13;
            int i21 = iO2;
            i = iA;
            j = j3 + ((long) i21);
            com.opos.exoplayer.core.util.a.a(iU7 == 0);
            while (i12 > 0) {
                com.opos.exoplayer.core.util.a.a(pVar6.u() == 0);
                pVar6.o();
                i12--;
            }
            if (i11 == 0 && i20 == 0) {
                i4 = i10;
                if (i4 == 0 && i19 == 0) {
                    track2 = track;
                    str = "AtomParsers";
                }
            } else {
                i4 = i10;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Inconsistent stbl box for track ");
            track2 = track;
            sb.append(track2.f8203a);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i11);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i20);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i4);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i19);
            String string = sb.toString();
            str = "AtomParsers";
            com.opos.cmn.an.f.a.c(str, string);
        }
        long[] jArr6 = jArr2;
        int[] iArr10 = iArr;
        int[] iArr11 = iArr2;
        int i22 = i2;
        long jD = y.d(j, 1000000L, track2.c);
        if (track2.h == null || iVar.a()) {
            y.a(jArr6, 1000000L, track2.c);
            return new j(jArr, iArr10, i22, jArr6, iArr11, jD);
        }
        long[] jArr7 = track2.h;
        if (jArr7.length == 1 && track2.b == 1 && jArr6.length >= 2) {
            long j5 = track2.i[0];
            long jD2 = y.d(jArr7[0], track2.c, track2.d) + j5;
            long j6 = jArr6[0];
            if (j6 <= j5 && j5 < jArr6[1] && jArr6[jArr6.length - 1] < jD2 && jD2 <= j) {
                long j7 = j - jD2;
                long jD3 = y.d(j5 - j6, track2.f.s, track2.c);
                long jD4 = y.d(j7, track2.f.s, track2.c);
                if ((jD3 != 0 || jD4 != 0) && jD3 <= 2147483647L && jD4 <= 2147483647L) {
                    iVar.b = (int) jD3;
                    iVar.c = (int) jD4;
                    y.a(jArr6, 1000000L, track2.c);
                    return new j(jArr, iArr10, i22, jArr6, iArr11, jD);
                }
            }
        }
        long[] jArr8 = track2.h;
        if (jArr8.length == 1 && jArr8[0] == 0) {
            long j8 = track2.i[0];
            for (int i23 = 0; i23 < jArr6.length; i23++) {
                jArr6[i23] = y.d(jArr6[i23] - j8, 1000000L, track2.c);
            }
            return new j(jArr, iArr10, i22, jArr6, iArr11, y.d(j - j8, 1000000L, track2.c));
        }
        boolean z3 = track2.b == 1;
        int i24 = 0;
        int i25 = 0;
        boolean z4 = false;
        int i26 = 0;
        while (true) {
            long[] jArr9 = track2.h;
            if (i26 >= jArr9.length) {
                break;
            }
            long j9 = track2.i[i26];
            if (j9 != -1) {
                iArr8 = iArr11;
                iArr7 = iArr10;
                str2 = str;
                long jD5 = y.d(jArr9[i26], track2.c, track2.d);
                int iB2 = y.b(jArr6, j9, true, true);
                int iB3 = y.b(jArr6, j9 + jD5, z3, false);
                i24 += iB3 - iB2;
                z4 = (i25 != iB2) | z4;
                i25 = iB3;
            } else {
                iArr7 = iArr10;
                str2 = str;
                iArr8 = iArr11;
            }
            i26++;
            iArr11 = iArr8;
            str = str2;
            iArr10 = iArr7;
        }
        int[] iArr12 = iArr10;
        String str3 = str;
        int[] iArr13 = iArr11;
        boolean z5 = (i24 != i) | z4;
        long[] jArr10 = z5 ? new long[i24] : jArr;
        int[] iArr14 = z5 ? new int[i24] : iArr12;
        int i27 = z5 ? 0 : i22;
        int[] iArr15 = z5 ? new int[i24] : iArr13;
        long[] jArr11 = new long[i24];
        int i28 = i27;
        int i29 = 0;
        int i30 = 0;
        while (true) {
            long[] jArr12 = track2.h;
            if (i29 >= jArr12.length) {
                break;
            }
            int i31 = i28;
            int[] iArr16 = iArr13;
            long j10 = track2.i[i29];
            long j11 = jArr12[i29];
            if (j10 != -1) {
                int[] iArr17 = iArr15;
                i3 = i29;
                long jD6 = y.d(j11, track2.c, track2.d) + j10;
                int iB4 = y.b(jArr6, j10, true, true);
                int iB5 = y.b(jArr6, jD6, z3, false);
                if (z5) {
                    int i32 = iB5 - iB4;
                    System.arraycopy(jArr, iB4, jArr10, i30, i32);
                    iArr3 = iArr12;
                    System.arraycopy(iArr3, iB4, iArr14, i30, i32);
                    z2 = z3;
                    iArr6 = iArr16;
                    jArr4 = jArr10;
                    iArr5 = iArr17;
                    System.arraycopy(iArr6, iB4, iArr5, i30, i32);
                } else {
                    iArr3 = iArr12;
                    z2 = z3;
                    iArr6 = iArr16;
                    jArr4 = jArr10;
                    iArr5 = iArr17;
                }
                int i33 = i31;
                while (true) {
                    jArr3 = jArr;
                    iArr4 = iArr6;
                    if (iB4 >= iB5) {
                        break;
                    }
                    long j12 = j10;
                    jArr11[i30] = y.d(j2, 1000000L, track2.d) + y.d(jArr6[iB4] - j10, 1000000L, track2.c);
                    if (z5 && iArr14[i30] > i33) {
                        i33 = iArr3[iB4];
                    }
                    i30++;
                    iB4++;
                    jArr = jArr3;
                    j10 = j12;
                    iArr6 = iArr4;
                }
                i28 = i33;
            } else {
                jArr3 = jArr;
                i3 = i29;
                iArr3 = iArr12;
                iArr4 = iArr16;
                jArr4 = jArr10;
                z2 = z3;
                iArr5 = iArr15;
                i28 = i31;
            }
            j2 += j11;
            i29 = i3 + 1;
            iArr15 = iArr5;
            z3 = z2;
            jArr10 = jArr4;
            jArr = jArr3;
            iArr13 = iArr4;
            iArr12 = iArr3;
        }
        long[] jArr13 = jArr10;
        long[] jArr14 = jArr;
        int[] iArr18 = iArr15;
        int i34 = i28;
        int[] iArr19 = iArr13;
        int[] iArr20 = iArr12;
        long jD7 = y.d(j2, 1000000L, track2.c);
        boolean z6 = false;
        for (int i35 = 0; i35 < iArr18.length && !z6; i35++) {
            z6 |= (iArr18[i35] & 1) != 0;
        }
        if (z6) {
            return new j(jArr13, iArr14, i34, jArr11, iArr18, jD7);
        }
        com.opos.cmn.an.f.a.c(str3, "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
        y.a(jArr6, 1000000L, track2.c);
        return new j(jArr14, iArr20, i22, jArr6, iArr19, jD);
    }

    public static Metadata a(d.b bVar, boolean z) {
        if (z) {
            return null;
        }
        p pVar = bVar.aP;
        pVar.c(8);
        while (pVar.b() >= 8) {
            int iD = pVar.d();
            int iO = pVar.o();
            if (pVar.o() == com.opos.exoplayer.core.extractor.mp4.d.aA) {
                pVar.c(iD);
                return a(pVar, iD + iO);
            }
            pVar.d(iO - 8);
        }
        return null;
    }

    private static Metadata a(p pVar, int i) {
        pVar.d(12);
        while (pVar.d() < i) {
            int iD = pVar.d();
            int iO = pVar.o();
            if (pVar.o() == com.opos.exoplayer.core.extractor.mp4.d.aB) {
                pVar.c(iD);
                return b(pVar, iD + iO);
            }
            pVar.d(iO - 8);
        }
        return null;
    }

    private static void a(p pVar, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, c cVar, int i6) throws com.opos.exoplayer.core.m {
        DrmInitData drmInitDataA = drmInitData;
        pVar.c(i2 + 8 + 8);
        pVar.d(16);
        int iH = pVar.h();
        int iH2 = pVar.h();
        pVar.d(50);
        int iD = pVar.d();
        String str = null;
        int iIntValue = i;
        if (iIntValue == com.opos.exoplayer.core.extractor.mp4.d.Z) {
            Pair<Integer, com.opos.exoplayer.core.extractor.mp4.c> pairC = c(pVar, i2, i3);
            if (pairC != null) {
                iIntValue = ((Integer) pairC.first).intValue();
                drmInitDataA = drmInitDataA == null ? null : drmInitDataA.a(((com.opos.exoplayer.core.extractor.mp4.c) pairC.second).b);
                cVar.f8210a[i6] = (com.opos.exoplayer.core.extractor.mp4.c) pairC.second;
            }
            pVar.c(iD);
        }
        DrmInitData drmInitData2 = drmInitDataA;
        List<byte[]> listSingletonList = null;
        byte[] bArrD = null;
        boolean z = false;
        float fC = 1.0f;
        int i7 = -1;
        while (iD - i2 < i3) {
            pVar.c(iD);
            int iD2 = pVar.d();
            int iO = pVar.o();
            if (iO == 0 && pVar.d() - i2 == i3) {
                break;
            }
            com.opos.exoplayer.core.util.a.a(iO > 0, "childAtomSize should be positive");
            int iO2 = pVar.o();
            if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.H) {
                com.opos.exoplayer.core.util.a.b(str == null);
                pVar.c(iD2 + 8);
                com.opos.exoplayer.core.video.a aVarA = com.opos.exoplayer.core.video.a.a(pVar);
                listSingletonList = aVarA.f8414a;
                cVar.c = aVarA.b;
                str = "video/avc";
                if (!z) {
                    fC = aVarA.e;
                }
            } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.I) {
                com.opos.exoplayer.core.util.a.b(str == null);
                pVar.c(iD2 + 8);
                com.opos.exoplayer.core.video.b bVarA = com.opos.exoplayer.core.video.b.a(pVar);
                listSingletonList = bVarA.f8415a;
                cVar.c = bVarA.b;
                str = "video/hevc";
            } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.aL) {
                com.opos.exoplayer.core.util.a.b(str == null);
                str = iIntValue == com.opos.exoplayer.core.extractor.mp4.d.aJ ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.g) {
                com.opos.exoplayer.core.util.a.b(str == null);
                str = "video/3gpp";
            } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.J) {
                com.opos.exoplayer.core.util.a.b(str == null);
                Pair<String, byte[]> pairD = d(pVar, iD2);
                str = (String) pairD.first;
                listSingletonList = Collections.singletonList(pairD.second);
            } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.ai) {
                fC = c(pVar, iD2);
                z = true;
            } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.aH) {
                bArrD = d(pVar, iD2, iO);
            } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.aG) {
                int iG = pVar.g();
                pVar.d(3);
                if (iG == 0) {
                    int iG2 = pVar.g();
                    if (iG2 == 0) {
                        i7 = 0;
                    } else if (iG2 == 1) {
                        i7 = 1;
                    } else if (iG2 == 2) {
                        i7 = 2;
                    } else if (iG2 == 3) {
                        i7 = 3;
                    }
                }
            }
            iD += iO;
        }
        if (str == null) {
            return;
        }
        cVar.b = Format.a(Integer.toString(i4), str, (String) null, -1, -1, iH, iH2, -1.0f, listSingletonList, i5, fC, bArrD, i7, (ColorInfo) null, drmInitData2);
    }

    private static void a(p pVar, int i, int i2, int i3, int i4, String str, c cVar) {
        pVar.c(i2 + 8 + 8);
        String str2 = "application/ttml+xml";
        List listSingletonList = null;
        long j = Long.MAX_VALUE;
        if (i != com.opos.exoplayer.core.extractor.mp4.d.aj) {
            if (i == com.opos.exoplayer.core.extractor.mp4.d.at) {
                int i5 = (i3 - 8) - 8;
                byte[] bArr = new byte[i5];
                pVar.a(bArr, 0, i5);
                listSingletonList = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i == com.opos.exoplayer.core.extractor.mp4.d.au) {
                str2 = "application/x-mp4-vtt";
            } else if (i == com.opos.exoplayer.core.extractor.mp4.d.av) {
                j = 0;
            } else {
                if (i != com.opos.exoplayer.core.extractor.mp4.d.aw) {
                    throw new IllegalStateException();
                }
                cVar.d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        cVar.b = Format.a(Integer.toString(i4), str2, null, -1, 0, str, -1, null, j, listSingletonList);
    }

    private static void a(p pVar, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, c cVar, int i5) {
        int iH;
        int iRound;
        int iU;
        String str2;
        String str3;
        DrmInitData drmInitData2;
        int i6;
        Format formatB;
        int i7 = i2;
        DrmInitData drmInitDataA = drmInitData;
        pVar.c(i7 + 8 + 8);
        if (z) {
            iH = pVar.h();
            pVar.d(6);
        } else {
            pVar.d(8);
            iH = 0;
        }
        if (iH == 0 || iH == 1) {
            int iH2 = pVar.h();
            pVar.d(6);
            int iS = pVar.s();
            if (iH == 1) {
                pVar.d(16);
            }
            iRound = iS;
            iU = iH2;
        } else {
            if (iH != 2) {
                return;
            }
            pVar.d(16);
            iRound = (int) Math.round(pVar.x());
            iU = pVar.u();
            pVar.d(20);
        }
        int iD = pVar.d();
        int iIntValue = i;
        if (iIntValue == com.opos.exoplayer.core.extractor.mp4.d.aa) {
            Pair<Integer, com.opos.exoplayer.core.extractor.mp4.c> pairC = c(pVar, i7, i3);
            if (pairC != null) {
                iIntValue = ((Integer) pairC.first).intValue();
                drmInitDataA = drmInitDataA == null ? null : drmInitDataA.a(((com.opos.exoplayer.core.extractor.mp4.c) pairC.second).b);
                cVar.f8210a[i5] = (com.opos.exoplayer.core.extractor.mp4.c) pairC.second;
            }
            pVar.c(iD);
        }
        DrmInitData drmInitData3 = drmInitDataA;
        String str4 = "audio/raw";
        String str5 = iIntValue == com.opos.exoplayer.core.extractor.mp4.d.n ? "audio/ac3" : iIntValue == com.opos.exoplayer.core.extractor.mp4.d.p ? "audio/eac3" : iIntValue == com.opos.exoplayer.core.extractor.mp4.d.r ? "audio/vnd.dts" : (iIntValue == com.opos.exoplayer.core.extractor.mp4.d.s || iIntValue == com.opos.exoplayer.core.extractor.mp4.d.t) ? "audio/vnd.dts.hd" : iIntValue == com.opos.exoplayer.core.extractor.mp4.d.u ? "audio/vnd.dts.hd;profile=lbr" : iIntValue == com.opos.exoplayer.core.extractor.mp4.d.ax ? "audio/3gpp" : iIntValue == com.opos.exoplayer.core.extractor.mp4.d.ay ? "audio/amr-wb" : (iIntValue == com.opos.exoplayer.core.extractor.mp4.d.l || iIntValue == com.opos.exoplayer.core.extractor.mp4.d.m) ? "audio/raw" : iIntValue == com.opos.exoplayer.core.extractor.mp4.d.j ? "audio/mpeg" : iIntValue == com.opos.exoplayer.core.extractor.mp4.d.aN ? "audio/alac" : null;
        int iIntValue2 = iU;
        int iIntValue3 = iRound;
        int i8 = iD;
        byte[] bArr = null;
        while (i8 - i7 < i3) {
            pVar.c(i8);
            int iO = pVar.o();
            com.opos.exoplayer.core.util.a.a(iO > 0, "childAtomSize should be positive");
            int iO2 = pVar.o();
            int i9 = com.opos.exoplayer.core.extractor.mp4.d.J;
            if (iO2 == i9 || (z && iO2 == com.opos.exoplayer.core.extractor.mp4.d.k)) {
                str2 = str5;
                str3 = str4;
                drmInitData2 = drmInitData3;
                int iB = iO2 == i9 ? i8 : b(pVar, i8, iO);
                if (iB != -1) {
                    Pair<String, byte[]> pairD = d(pVar, iB);
                    str5 = (String) pairD.first;
                    bArr = (byte[]) pairD.second;
                    if ("audio/mp4a-latm".equals(str5)) {
                        Pair<Integer, Integer> pairA = com.opos.exoplayer.core.util.f.a(bArr);
                        iIntValue3 = ((Integer) pairA.first).intValue();
                        iIntValue2 = ((Integer) pairA.second).intValue();
                    }
                }
                i8 += iO;
                i7 = i2;
                drmInitData3 = drmInitData2;
                str4 = str3;
            } else {
                if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.o) {
                    pVar.c(i8 + 8);
                    formatB = com.opos.exoplayer.core.a.a.a(pVar, Integer.toString(i4), str, drmInitData3);
                } else if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.q) {
                    pVar.c(i8 + 8);
                    formatB = com.opos.exoplayer.core.a.a.b(pVar, Integer.toString(i4), str, drmInitData3);
                } else {
                    if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.v) {
                        str2 = str5;
                        str3 = str4;
                        drmInitData2 = drmInitData3;
                        i6 = i8;
                        cVar.b = Format.a(Integer.toString(i4), str5, null, -1, -1, iIntValue2, iIntValue3, null, drmInitData2, 0, str);
                        iO = iO;
                    } else {
                        i6 = i8;
                        str2 = str5;
                        str3 = str4;
                        drmInitData2 = drmInitData3;
                        if (iO2 == com.opos.exoplayer.core.extractor.mp4.d.aN) {
                            byte[] bArr2 = new byte[iO];
                            i8 = i6;
                            pVar.c(i8);
                            pVar.a(bArr2, 0, iO);
                            bArr = bArr2;
                        }
                    }
                    i8 = i6;
                }
                cVar.b = formatB;
                str2 = str5;
                str3 = str4;
                drmInitData2 = drmInitData3;
            }
            str5 = str2;
            i8 += iO;
            i7 = i2;
            drmInitData3 = drmInitData2;
            str4 = str3;
        }
        String str6 = str5;
        String str7 = str4;
        DrmInitData drmInitData4 = drmInitData3;
        if (cVar.b != null || str6 == null) {
            return;
        }
        cVar.b = Format.a(Integer.toString(i4), str6, (String) null, -1, -1, iIntValue2, iIntValue3, str7.equals(str6) ? 2 : -1, (List<byte[]>) (bArr != null ? Collections.singletonList(bArr) : null), drmInitData4, 0, str);
    }
}
