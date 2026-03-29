package com.opos.exoplayer.core.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.k;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.mp4.d;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.w;
import com.opos.exoplayer.core.util.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class FragmentedMp4Extractor implements com.opos.exoplayer.core.extractor.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.extractor.h f8198a = new a();
    private static final int b = y.f("seig");
    private static final byte[] c = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final Format d = Format.a((String) null, "application/x-emsg", Long.MAX_VALUE);
    private int A;
    private long B;
    private long C;
    private c D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private com.opos.exoplayer.core.extractor.g I;
    private n[] J;
    private n[] K;
    private boolean L;
    private final int e;
    private final Track f;
    private final List<Format> g;
    private final DrmInitData h;
    private final SparseArray<c> i;
    private final p j;
    private final p k;
    private final p l;
    private final p m;
    private final p n;
    private final w o;
    private final p p;
    private final byte[] q;
    private final Stack<d.a> r;
    private final ArrayDeque<b> s;

    @Nullable
    private final n t;
    private int u;
    private int v;
    private long w;
    private int x;
    private p y;
    private long z;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.opos.exoplayer.core.extractor.h {
        @Override // com.opos.exoplayer.core.extractor.h
        public com.opos.exoplayer.core.extractor.e[] a() {
            return new com.opos.exoplayer.core.extractor.e[]{new FragmentedMp4Extractor()};
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f8199a;
        public final int b;

        public b(long j, int i) {
            this.f8199a = j;
            this.b = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f8200a = new i();
        public final n b;
        public Track c;
        public f d;
        public int e;
        public int f;
        public int g;

        public c(n nVar) {
            this.b = nVar;
        }

        public void a() {
            this.f8200a.a();
            this.e = 0;
            this.g = 0;
            this.f = 0;
        }

        public void a(DrmInitData drmInitData) {
            com.opos.exoplayer.core.extractor.mp4.c cVarA = this.c.a(this.f8200a.f8217a.f8214a);
            this.b.a(this.c.f.a(drmInitData.a(cVarA != null ? cVarA.b : null)));
        }

        public void a(Track track, f fVar) {
            this.c = (Track) com.opos.exoplayer.core.util.a.a(track);
            this.d = (f) com.opos.exoplayer.core.util.a.a(fVar);
            this.b.a(track.f);
            a();
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    private static Pair<Integer, f> b(p pVar) {
        pVar.c(12);
        return Pair.create(Integer.valueOf(pVar.o()), new f(pVar.u() - 1, pVar.u(), pVar.u(), pVar.o()));
    }

    private static long c(p pVar) {
        pVar.c(8);
        return d.a(pVar.o()) == 0 ? pVar.m() : pVar.w();
    }

    private static long d(p pVar) {
        pVar.c(8);
        return d.a(pVar.o()) == 1 ? pVar.w() : pVar.m();
    }

    private boolean e(com.opos.exoplayer.core.extractor.f fVar) throws m {
        int i;
        n.a aVar;
        int iA;
        int i2 = 4;
        int i3 = 1;
        int i4 = 0;
        if (this.u == 3) {
            if (this.D == null) {
                c cVarA = a(this.i);
                if (cVarA == null) {
                    int iC = (int) (this.z - fVar.c());
                    if (iC < 0) {
                        throw new m("Offset to end of mdat was negative.");
                    }
                    fVar.b(iC);
                    a();
                    return false;
                }
                int iC2 = (int) (cVarA.f8200a.g[cVarA.g] - fVar.c());
                if (iC2 < 0) {
                    com.opos.cmn.an.f.a.c("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    iC2 = 0;
                }
                fVar.b(iC2);
                this.D = cVarA;
            }
            c cVar = this.D;
            i iVar = cVar.f8200a;
            this.E = iVar.i[cVar.e];
            if (iVar.m) {
                int iA2 = a(cVar);
                this.F = iA2;
                this.E += iA2;
            } else {
                this.F = 0;
            }
            if (this.D.c.g == 1) {
                this.E -= 8;
                fVar.b(8);
            }
            this.u = 4;
            this.G = 0;
        }
        c cVar2 = this.D;
        i iVar2 = cVar2.f8200a;
        Track track = cVar2.c;
        n nVar = cVar2.b;
        int i5 = cVar2.e;
        int i6 = track.j;
        if (i6 == 0) {
            while (true) {
                int i7 = this.F;
                int i8 = this.E;
                if (i7 >= i8) {
                    break;
                }
                this.F += nVar.a(fVar, i8 - i7, false);
            }
        } else {
            byte[] bArr = this.k.f8400a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i9 = i6 + 1;
            int i10 = 4 - i6;
            while (this.F < this.E) {
                int i11 = this.G;
                if (i11 == 0) {
                    fVar.b(bArr, i10, i9);
                    this.k.c(i4);
                    this.G = this.k.u() - i3;
                    this.j.c(i4);
                    nVar.a(this.j, i2);
                    nVar.a(this.k, i3);
                    this.H = this.K.length > 0 && com.opos.exoplayer.core.util.n.a(track.f.f, bArr[i2]);
                    this.F += 5;
                    this.E += i10;
                } else {
                    if (this.H) {
                        this.l.a(i11);
                        fVar.b(this.l.f8400a, i4, this.G);
                        nVar.a(this.l, this.G);
                        iA = this.G;
                        p pVar = this.l;
                        int iA3 = com.opos.exoplayer.core.util.n.a(pVar.f8400a, pVar.c());
                        this.l.c("video/hevc".equals(track.f.f) ? 1 : 0);
                        this.l.b(iA3);
                        com.opos.exoplayer.core.text.a.c.a(iVar2.b(i5) * 1000, this.l, this.K);
                    } else {
                        iA = nVar.a(fVar, i11, false);
                    }
                    this.F += iA;
                    this.G -= iA;
                    i2 = 4;
                    i3 = 1;
                    i4 = 0;
                }
            }
        }
        long jB = iVar2.b(i5) * 1000;
        w wVar = this.o;
        if (wVar != null) {
            jB = wVar.e(jB);
        }
        boolean z = iVar2.l[i5];
        if (iVar2.m) {
            int i12 = (z ? 1 : 0) | 1073741824;
            com.opos.exoplayer.core.extractor.mp4.c cVarA2 = iVar2.o;
            if (cVarA2 == null) {
                cVarA2 = track.a(iVar2.f8217a.f8214a);
            }
            i = i12;
            aVar = cVarA2.c;
        } else {
            i = z ? 1 : 0;
            aVar = null;
        }
        nVar.a(jB, i, this.E, 0, aVar);
        b(jB);
        c cVar3 = this.D;
        cVar3.e++;
        int i13 = cVar3.f + 1;
        cVar3.f = i13;
        int[] iArr = iVar2.h;
        int i14 = cVar3.g;
        if (i13 == iArr[i14]) {
            cVar3.g = i14 + 1;
            cVar3.f = 0;
            this.D = null;
        }
        this.u = 3;
        return true;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public int a(com.opos.exoplayer.core.extractor.f fVar, k kVar) throws m {
        while (true) {
            int i = this.u;
            if (i != 0) {
                if (i == 1) {
                    c(fVar);
                } else if (i == 2) {
                    d(fVar);
                } else if (e(fVar)) {
                    return 0;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    public FragmentedMp4Extractor(int i) {
        this(i, null);
    }

    private int a(c cVar) {
        p pVar;
        i iVar = cVar.f8200a;
        int i = iVar.f8217a.f8214a;
        com.opos.exoplayer.core.extractor.mp4.c cVarA = iVar.o;
        if (cVarA == null) {
            cVarA = cVar.c.a(i);
        }
        int length = cVarA.d;
        if (length != 0) {
            pVar = iVar.q;
        } else {
            byte[] bArr = cVarA.e;
            this.n.a(bArr, bArr.length);
            pVar = this.n;
            length = bArr.length;
        }
        boolean z = iVar.n[cVar.e];
        p pVar2 = this.m;
        pVar2.f8400a[0] = (byte) ((z ? 128 : 0) | length);
        pVar2.c(0);
        n nVar = cVar.b;
        nVar.a(this.m, 1);
        nVar.a(pVar, length);
        if (!z) {
            return length + 1;
        }
        p pVar3 = iVar.q;
        int iH = pVar3.h();
        pVar3.d(-2);
        int i2 = (iH * 6) + 2;
        nVar.a(pVar3, i2);
        return length + 1 + i2;
    }

    private void b() {
        int i;
        if (this.J == null) {
            n[] nVarArr = new n[2];
            this.J = nVarArr;
            n nVar = this.t;
            if (nVar != null) {
                nVarArr[0] = nVar;
                i = 1;
            } else {
                i = 0;
            }
            if ((this.e & 4) != 0) {
                nVarArr[i] = this.I.a(this.i.size(), 4);
                i++;
            }
            n[] nVarArr2 = (n[]) Arrays.copyOf(this.J, i);
            this.J = nVarArr2;
            for (n nVar2 : nVarArr2) {
                nVar2.a(d);
            }
        }
        if (this.K == null) {
            this.K = new n[this.g.size()];
            for (int i2 = 0; i2 < this.K.length; i2++) {
                n nVarA = this.I.a(this.i.size() + 1 + i2, 3);
                nVarA.a(this.g.get(i2));
                this.K[i2] = nVarA;
            }
        }
    }

    private void d(com.opos.exoplayer.core.extractor.f fVar) throws m {
        int size = this.i.size();
        c cVarValueAt = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            i iVar = this.i.valueAt(i).f8200a;
            if (iVar.r) {
                long j2 = iVar.d;
                if (j2 < j) {
                    cVarValueAt = this.i.valueAt(i);
                    j = j2;
                }
            }
        }
        if (cVarValueAt == null) {
            this.u = 3;
            return;
        }
        int iC = (int) (j - fVar.c());
        if (iC < 0) {
            throw new m("Offset to encryption data was negative.");
        }
        fVar.b(iC);
        cVarValueAt.f8200a.a(fVar);
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void c() {
    }

    public FragmentedMp4Extractor(int i, w wVar) {
        this(i, wVar, null, null);
    }

    private static int a(c cVar, int i, long j, int i2, p pVar, int i3) {
        boolean z;
        int iU;
        boolean z2;
        int iU2;
        boolean z3;
        int iO;
        int i4;
        int i5;
        pVar.c(8);
        int iB = d.b(pVar.o());
        Track track = cVar.c;
        i iVar = cVar.f8200a;
        f fVar = iVar.f8217a;
        iVar.h[i] = pVar.u();
        long[] jArr = iVar.g;
        long j2 = iVar.c;
        jArr[i] = j2;
        if ((iB & 1) != 0) {
            jArr[i] = j2 + ((long) pVar.o());
        }
        boolean z4 = (iB & 4) != 0;
        int iU3 = fVar.d;
        if (z4) {
            iU3 = pVar.u();
        }
        boolean z5 = (iB & 256) != 0;
        boolean z6 = (iB & 512) != 0;
        boolean z7 = (iB & 1024) != 0;
        boolean z8 = (iB & 2048) != 0;
        long[] jArr2 = track.h;
        long jD = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            jD = y.d(track.i[0], 1000L, track.c);
        }
        int[] iArr = iVar.i;
        int[] iArr2 = iVar.j;
        long[] jArr3 = iVar.k;
        boolean[] zArr = iVar.l;
        int i6 = iU3;
        boolean z9 = track.b == 2 && (i2 & 1) != 0;
        int i7 = i3 + iVar.h[i];
        long j3 = track.c;
        long j4 = jD;
        long j5 = i > 0 ? iVar.s : j;
        int i8 = i3;
        while (i8 < i7) {
            if (z5) {
                z = z5;
                iU = pVar.u();
            } else {
                z = z5;
                iU = fVar.b;
            }
            if (z6) {
                z2 = z6;
                iU2 = pVar.u();
            } else {
                z2 = z6;
                iU2 = fVar.c;
            }
            if (i8 == 0 && z4) {
                z3 = z4;
                iO = i6;
            } else if (z7) {
                z3 = z4;
                iO = pVar.o();
            } else {
                z3 = z4;
                iO = fVar.d;
            }
            boolean z10 = z8;
            if (z8) {
                i4 = i7;
                i5 = iU;
                iArr2[i8] = (int) ((((long) pVar.o()) * 1000) / j3);
            } else {
                i4 = i7;
                i5 = iU;
                iArr2[i8] = 0;
            }
            jArr3[i8] = y.d(j5, 1000L, j3) - j4;
            iArr[i8] = iU2;
            zArr[i8] = ((iO >> 16) & 1) == 0 && (!z9 || i8 == 0);
            j5 += (long) i5;
            i8++;
            z5 = z;
            z6 = z2;
            z4 = z3;
            z8 = z10;
            i7 = i4;
        }
        int i9 = i7;
        iVar.s = j5;
        return i9;
    }

    private void b(long j) {
        while (!this.s.isEmpty()) {
            b bVarRemoveFirst = this.s.removeFirst();
            this.A -= bVarRemoveFirst.b;
            for (n nVar : this.J) {
                nVar.a(bVarRemoveFirst.f8199a + j, 1, bVarRemoveFirst.b, this.A, null);
            }
        }
    }

    private void c(com.opos.exoplayer.core.extractor.f fVar) throws m {
        int i = ((int) this.w) - this.x;
        p pVar = this.y;
        if (pVar != null) {
            fVar.b(pVar.f8400a, 8, i);
            a(new d.b(this.v, this.y), fVar.c());
        } else {
            fVar.b(i);
        }
        a(fVar.c());
    }

    public FragmentedMp4Extractor(int i, w wVar, Track track, DrmInitData drmInitData) {
        this(i, wVar, track, drmInitData, Collections.emptyList());
    }

    private static Pair<Long, com.opos.exoplayer.core.extractor.a> a(p pVar, long j) throws m {
        long jW;
        long jW2;
        pVar.c(8);
        int iA = d.a(pVar.o());
        pVar.d(4);
        long jM = pVar.m();
        if (iA == 0) {
            jW = pVar.m();
            jW2 = pVar.m();
        } else {
            jW = pVar.w();
            jW2 = pVar.w();
        }
        long j2 = jW;
        long j3 = j + jW2;
        long jD = y.d(j2, 1000000L, jM);
        pVar.d(2);
        int iH = pVar.h();
        int[] iArr = new int[iH];
        long[] jArr = new long[iH];
        long[] jArr2 = new long[iH];
        long[] jArr3 = new long[iH];
        long j4 = j2;
        long j5 = jD;
        int i = 0;
        while (i < iH) {
            int iO = pVar.o();
            if ((iO & Integer.MIN_VALUE) != 0) {
                throw new m("Unhandled indirect reference");
            }
            long jM2 = pVar.m();
            iArr[i] = iO & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j5;
            long j6 = j4 + jM2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            int i2 = iH;
            int[] iArr2 = iArr;
            long jD2 = y.d(j6, 1000000L, jM);
            jArr4[i] = jD2 - jArr5[i];
            pVar.d(4);
            j3 += (long) iArr2[i];
            i++;
            iArr = iArr2;
            jArr3 = jArr5;
            jArr2 = jArr4;
            jArr = jArr;
            iH = i2;
            j4 = j6;
            j5 = jD2;
        }
        return Pair.create(Long.valueOf(jD), new com.opos.exoplayer.core.extractor.a(iArr, jArr, jArr2, jArr3));
    }

    private void b(d.a aVar) throws m {
        int i;
        int i2;
        int i3 = 0;
        com.opos.exoplayer.core.util.a.b(this.f == null, "Unexpected moov box.");
        DrmInitData drmInitDataA = this.h;
        if (drmInitDataA == null) {
            drmInitDataA = a(aVar.aQ);
        }
        d.a aVarE = aVar.e(d.M);
        SparseArray sparseArray = new SparseArray();
        int size = aVarE.aQ.size();
        long jC = -9223372036854775807L;
        for (int i4 = 0; i4 < size; i4++) {
            d.b bVar = aVarE.aQ.get(i4);
            int i5 = bVar.aO;
            if (i5 == d.y) {
                Pair<Integer, f> pairB = b(bVar.aP);
                sparseArray.put(((Integer) pairB.first).intValue(), pairB.second);
            } else if (i5 == d.N) {
                jC = c(bVar.aP);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar.aR.size();
        int i6 = 0;
        while (i6 < size2) {
            d.a aVar2 = aVar.aR.get(i6);
            if (aVar2.aO == d.D) {
                i = i6;
                i2 = size2;
                Track trackA = e.a(aVar2, aVar.d(d.C), jC, drmInitDataA, (this.e & 16) != 0, false);
                if (trackA != null) {
                    sparseArray2.put(trackA.f8203a, trackA);
                }
            } else {
                i = i6;
                i2 = size2;
            }
            i6 = i + 1;
            size2 = i2;
        }
        int size3 = sparseArray2.size();
        if (this.i.size() == 0) {
            while (i3 < size3) {
                Track track = (Track) sparseArray2.valueAt(i3);
                c cVar = new c(this.I.a(i3, track.b));
                cVar.a(track, (f) sparseArray.get(track.f8203a));
                this.i.put(track.f8203a, cVar);
                this.B = Math.max(this.B, track.e);
                i3++;
            }
            b();
            this.I.a();
            return;
        }
        com.opos.exoplayer.core.util.a.b(this.i.size() == size3);
        while (i3 < size3) {
            Track track2 = (Track) sparseArray2.valueAt(i3);
            this.i.get(track2.f8203a).a(track2, (f) sparseArray.get(track2.f8203a));
            i3++;
        }
    }

    private void c(d.a aVar) throws m {
        a(aVar, this.i, this.e, this.q);
        DrmInitData drmInitDataA = this.h != null ? null : a(aVar.aQ);
        if (drmInitDataA != null) {
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                this.i.valueAt(i).a(drmInitDataA);
            }
        }
    }

    public FragmentedMp4Extractor(int i, w wVar, Track track, DrmInitData drmInitData, List<Format> list) {
        this(i, wVar, track, drmInitData, list, null);
    }

    private static DrmInitData a(List<d.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            d.b bVar = list.get(i);
            if (bVar.aO == d.U) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.aP.f8400a;
                UUID uuidA = com.opos.exoplayer.core.extractor.mp4.b.a(bArr);
                if (uuidA == null) {
                    com.opos.cmn.an.f.a.c("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuidA, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(arrayList);
    }

    private static void b(d.a aVar, SparseArray<c> sparseArray, int i, byte[] bArr) throws m {
        c cVarA = a(aVar.d(d.x).aP, sparseArray, i);
        if (cVarA == null) {
            return;
        }
        i iVar = cVarA.f8200a;
        long jD = iVar.s;
        cVarA.a();
        int i2 = d.w;
        if (aVar.d(i2) != null && (i & 2) == 0) {
            jD = d(aVar.d(i2).aP);
        }
        a(aVar, cVarA, jD, i);
        com.opos.exoplayer.core.extractor.mp4.c cVarA2 = cVarA.c.a(iVar.f8217a.f8214a);
        d.b bVarD = aVar.d(d.ac);
        if (bVarD != null) {
            a(cVarA2, bVarD.aP, iVar);
        }
        d.b bVarD2 = aVar.d(d.ad);
        if (bVarD2 != null) {
            a(bVarD2.aP, iVar);
        }
        d.b bVarD3 = aVar.d(d.ah);
        if (bVarD3 != null) {
            b(bVarD3.aP, iVar);
        }
        d.b bVarD4 = aVar.d(d.ae);
        d.b bVarD5 = aVar.d(d.af);
        if (bVarD4 != null && bVarD5 != null) {
            a(bVarD4.aP, bVarD5.aP, cVarA2 != null ? cVarA2.b : null, iVar);
        }
        int size = aVar.aQ.size();
        for (int i3 = 0; i3 < size; i3++) {
            d.b bVar = aVar.aQ.get(i3);
            if (bVar.aO == d.ag) {
                a(bVar.aP, iVar, bArr);
            }
        }
    }

    public FragmentedMp4Extractor(int i, w wVar, Track track, DrmInitData drmInitData, List<Format> list, @Nullable n nVar) {
        this.e = i | (track != null ? 8 : 0);
        this.o = wVar;
        this.f = track;
        this.h = drmInitData;
        this.g = Collections.unmodifiableList(list);
        this.t = nVar;
        this.p = new p(16);
        this.j = new p(com.opos.exoplayer.core.util.n.f8396a);
        this.k = new p(5);
        this.l = new p();
        this.m = new p(1);
        this.n = new p();
        this.q = new byte[16];
        this.r = new Stack<>();
        this.s = new ArrayDeque<>();
        this.i = new SparseArray<>();
        this.B = -9223372036854775807L;
        this.C = -9223372036854775807L;
        a();
    }

    private static c a(SparseArray<c> sparseArray) {
        int size = sparseArray.size();
        c cVar = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            c cVarValueAt = sparseArray.valueAt(i);
            int i2 = cVarValueAt.g;
            i iVar = cVarValueAt.f8200a;
            if (i2 != iVar.e) {
                long j2 = iVar.g[i2];
                if (j2 < j) {
                    cVar = cVarValueAt;
                    j = j2;
                }
            }
        }
        return cVar;
    }

    private static void b(p pVar, i iVar) throws m {
        a(pVar, 0, iVar);
    }

    private static c a(p pVar, SparseArray<c> sparseArray, int i) {
        pVar.c(8);
        int iB = d.b(pVar.o());
        int iO = pVar.o();
        if ((i & 8) != 0) {
            iO = 0;
        }
        c cVar = sparseArray.get(iO);
        if (cVar == null) {
            return null;
        }
        if ((iB & 1) != 0) {
            long jW = pVar.w();
            i iVar = cVar.f8200a;
            iVar.c = jW;
            iVar.d = jW;
        }
        f fVar = cVar.d;
        cVar.f8200a.f8217a = new f((iB & 2) != 0 ? pVar.u() - 1 : fVar.f8214a, (iB & 8) != 0 ? pVar.u() : fVar.b, (iB & 16) != 0 ? pVar.u() : fVar.c, (iB & 32) != 0 ? pVar.u() : fVar.d);
        return cVar;
    }

    private static boolean b(int i) {
        return i == d.B || i == d.D || i == d.E || i == d.F || i == d.G || i == d.K || i == d.L || i == d.M || i == d.P;
    }

    private void a() {
        this.u = 0;
        this.x = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(com.opos.exoplayer.core.extractor.f fVar) throws m {
        long jC;
        if (this.x == 0) {
            if (!fVar.a(this.p.f8400a, 0, 8, true)) {
                return false;
            }
            this.x = 8;
            this.p.c(0);
            this.w = this.p.m();
            this.v = this.p.o();
        }
        long j = this.w;
        if (j != 1) {
            if (j == 0) {
                long jD = fVar.d();
                if (jD == -1 && !this.r.isEmpty()) {
                    jD = this.r.peek().aP;
                }
                if (jD != -1) {
                    jC = (jD - fVar.c()) + ((long) this.x);
                }
            }
            if (this.w >= this.x) {
                throw new m("Atom size less than header length (unsupported).");
            }
            long jC2 = fVar.c() - ((long) this.x);
            if (this.v == d.K) {
                int size = this.i.size();
                for (int i = 0; i < size; i++) {
                    i iVar = this.i.valueAt(i).f8200a;
                    iVar.b = jC2;
                    iVar.d = jC2;
                    iVar.c = jC2;
                }
            }
            int i2 = this.v;
            if (i2 == d.h) {
                this.D = null;
                this.z = this.w + jC2;
                if (!this.L) {
                    this.I.a(new l.b(this.B, jC2));
                    this.L = true;
                }
                this.u = 2;
                return true;
            }
            if (b(i2)) {
                long jC3 = (fVar.c() + this.w) - 8;
                this.r.add(new d.a(this.v, jC3));
                if (this.w == this.x) {
                    a(jC3);
                } else {
                    a();
                }
            } else {
                if (a(this.v)) {
                    if (this.x != 8) {
                        throw new m("Leaf atom defines extended atom size (unsupported).");
                    }
                    long j2 = this.w;
                    if (j2 > 2147483647L) {
                        throw new m("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    p pVar = new p((int) j2);
                    this.y = pVar;
                    System.arraycopy(this.p.f8400a, 0, pVar.f8400a, 0, 8);
                } else {
                    if (this.w > 2147483647L) {
                        throw new m("Skipping atom with length > 2147483647 (unsupported).");
                    }
                    this.y = null;
                }
                this.u = 1;
            }
            return true;
        }
        fVar.b(this.p.f8400a, 8, 8);
        this.x += 8;
        jC = this.p.w();
        this.w = jC;
        if (this.w >= this.x) {
        }
    }

    private void a(long j) throws m {
        while (!this.r.isEmpty() && this.r.peek().aP == j) {
            a(this.r.pop());
        }
        a();
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(long j, long j2) {
        int size = this.i.size();
        for (int i = 0; i < size; i++) {
            this.i.valueAt(i).a();
        }
        this.s.clear();
        this.A = 0;
        this.r.clear();
        a();
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(com.opos.exoplayer.core.extractor.g gVar) {
        this.I = gVar;
        Track track = this.f;
        if (track != null) {
            c cVar = new c(gVar.a(0, track.b));
            cVar.a(this.f, new f(0, 0, 0, 0));
            this.i.put(0, cVar);
            b();
            this.I.a();
        }
    }

    private static void a(com.opos.exoplayer.core.extractor.mp4.c cVar, p pVar, i iVar) throws m {
        int i;
        int i2 = cVar.d;
        pVar.c(8);
        if ((d.b(pVar.o()) & 1) == 1) {
            pVar.d(8);
        }
        int iG = pVar.g();
        int iU = pVar.u();
        if (iU != iVar.f) {
            throw new m("Length mismatch: " + iU + ", " + iVar.f);
        }
        if (iG == 0) {
            boolean[] zArr = iVar.n;
            i = 0;
            for (int i3 = 0; i3 < iU; i3++) {
                int iG2 = pVar.g();
                i += iG2;
                zArr[i3] = iG2 > i2;
            }
        } else {
            i = (iG * iU) + 0;
            Arrays.fill(iVar.n, 0, iU, iG > i2);
        }
        iVar.a(i);
    }

    private void a(d.a aVar) throws m {
        int i = aVar.aO;
        if (i == d.B) {
            b(aVar);
        } else if (i == d.K) {
            c(aVar);
        } else {
            if (this.r.isEmpty()) {
                return;
            }
            this.r.peek().a(aVar);
        }
    }

    private static void a(d.a aVar, SparseArray<c> sparseArray, int i, byte[] bArr) throws m {
        int size = aVar.aR.size();
        for (int i2 = 0; i2 < size; i2++) {
            d.a aVar2 = aVar.aR.get(i2);
            if (aVar2.aO == d.L) {
                b(aVar2, sparseArray, i, bArr);
            }
        }
    }

    private static void a(d.a aVar, c cVar, long j, int i) {
        List<d.b> list = aVar.aQ;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            d.b bVar = list.get(i4);
            if (bVar.aO == d.z) {
                p pVar = bVar.aP;
                pVar.c(12);
                int iU = pVar.u();
                if (iU > 0) {
                    i3 += iU;
                    i2++;
                }
            }
        }
        cVar.g = 0;
        cVar.f = 0;
        cVar.e = 0;
        cVar.f8200a.a(i2, i3);
        int i5 = 0;
        int iA = 0;
        for (int i6 = 0; i6 < size; i6++) {
            d.b bVar2 = list.get(i6);
            if (bVar2.aO == d.z) {
                iA = a(cVar, i5, j, i, bVar2.aP, iA);
                i5++;
            }
        }
    }

    private void a(d.b bVar, long j) throws m {
        if (!this.r.isEmpty()) {
            this.r.peek().a(bVar);
            return;
        }
        int i = bVar.aO;
        if (i != d.A) {
            if (i == d.aF) {
                a(bVar.aP);
            }
        } else {
            Pair<Long, com.opos.exoplayer.core.extractor.a> pairA = a(bVar.aP, j);
            this.C = ((Long) pairA.first).longValue();
            this.I.a((l) pairA.second);
            this.L = true;
        }
    }

    private void a(p pVar) {
        n[] nVarArr = this.J;
        if (nVarArr == null || nVarArr.length == 0) {
            return;
        }
        pVar.c(12);
        int iB = pVar.b();
        pVar.y();
        pVar.y();
        long jD = y.d(pVar.m(), 1000000L, pVar.m());
        for (n nVar : this.J) {
            pVar.c(12);
            nVar.a(pVar, iB);
        }
        if (this.C == -9223372036854775807L) {
            this.s.addLast(new b(jD, iB));
            this.A += iB;
            return;
        }
        for (n nVar2 : this.J) {
            nVar2.a(this.C + jD, 1, iB, 0, null);
        }
    }

    private static void a(p pVar, int i, i iVar) throws m {
        pVar.c(i + 8);
        int iB = d.b(pVar.o());
        if ((iB & 1) != 0) {
            throw new m("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iB & 2) != 0;
        int iU = pVar.u();
        if (iU == iVar.f) {
            Arrays.fill(iVar.n, 0, iU, z);
            iVar.a(pVar.b());
            iVar.a(pVar);
        } else {
            throw new m("Length mismatch: " + iU + ", " + iVar.f);
        }
    }

    private static void a(p pVar, i iVar) throws m {
        pVar.c(8);
        int iO = pVar.o();
        if ((d.b(iO) & 1) == 1) {
            pVar.d(8);
        }
        int iU = pVar.u();
        if (iU == 1) {
            iVar.d += d.a(iO) == 0 ? pVar.m() : pVar.w();
        } else {
            throw new m("Unexpected saio entry count: " + iU);
        }
    }

    private static void a(p pVar, i iVar, byte[] bArr) throws m {
        pVar.c(8);
        pVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, c)) {
            a(pVar, 16, iVar);
        }
    }

    private static void a(p pVar, p pVar2, String str, i iVar) throws m {
        byte[] bArr;
        pVar.c(8);
        int iO = pVar.o();
        int iO2 = pVar.o();
        int i = b;
        if (iO2 != i) {
            return;
        }
        if (d.a(iO) == 1) {
            pVar.d(4);
        }
        if (pVar.o() != 1) {
            throw new m("Entry count in sbgp != 1 (unsupported).");
        }
        pVar2.c(8);
        int iO3 = pVar2.o();
        if (pVar2.o() != i) {
            return;
        }
        int iA = d.a(iO3);
        if (iA == 1) {
            if (pVar2.m() == 0) {
                throw new m("Variable length description in sgpd found (unsupported)");
            }
        } else if (iA >= 2) {
            pVar2.d(4);
        }
        if (pVar2.m() != 1) {
            throw new m("Entry count in sgpd != 1 (unsupported).");
        }
        pVar2.d(1);
        int iG = pVar2.g();
        int i2 = (iG & 240) >> 4;
        int i3 = iG & 15;
        boolean z = pVar2.g() == 1;
        if (z) {
            int iG2 = pVar2.g();
            byte[] bArr2 = new byte[16];
            pVar2.a(bArr2, 0, 16);
            if (z && iG2 == 0) {
                int iG3 = pVar2.g();
                byte[] bArr3 = new byte[iG3];
                pVar2.a(bArr3, 0, iG3);
                bArr = bArr3;
            } else {
                bArr = null;
            }
            iVar.m = true;
            iVar.o = new com.opos.exoplayer.core.extractor.mp4.c(z, str, iG2, bArr2, i2, i3, bArr);
        }
    }

    private static boolean a(int i) {
        return i == d.S || i == d.R || i == d.C || i == d.A || i == d.T || i == d.w || i == d.x || i == d.O || i == d.y || i == d.z || i == d.U || i == d.ac || i == d.ad || i == d.ah || i == d.ag || i == d.ae || i == d.af || i == d.Q || i == d.N || i == d.aF;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public boolean a(com.opos.exoplayer.core.extractor.f fVar) {
        return h.a(fVar);
    }
}
