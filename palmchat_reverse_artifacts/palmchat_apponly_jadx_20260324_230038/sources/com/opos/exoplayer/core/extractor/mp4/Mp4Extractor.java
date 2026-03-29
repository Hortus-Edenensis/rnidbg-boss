package com.opos.exoplayer.core.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.k;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.m;
import com.opos.exoplayer.core.extractor.mp4.d;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Stack;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class Mp4Extractor implements com.opos.exoplayer.core.extractor.e, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.opos.exoplayer.core.extractor.h f8201a = new a();
    private static final int b = y.f("qt  ");
    private final int c;
    private final p d;
    private final p e;
    private final p f;
    private final Stack<d.a> g;
    private int h;
    private int i;
    private long j;
    private int k;
    private p l;
    private int m;
    private int n;
    private int o;
    private com.opos.exoplayer.core.extractor.g p;
    private b[] q;
    private long[][] r;
    private int s;
    private long t;
    private boolean u;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements com.opos.exoplayer.core.extractor.h {
        @Override // com.opos.exoplayer.core.extractor.h
        public com.opos.exoplayer.core.extractor.e[] a() {
            return new com.opos.exoplayer.core.extractor.e[]{new Mp4Extractor()};
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Track f8202a;
        public final j b;
        public final n c;
        public int d;

        public b(Track track, j jVar, n nVar) {
            this.f8202a = track;
            this.b = jVar;
            this.c = nVar;
        }
    }

    public Mp4Extractor() {
        this(0);
    }

    private int c(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            b[] bVarArr = this.q;
            if (i3 >= bVarArr.length) {
                break;
            }
            b bVar = bVarArr[i3];
            int i4 = bVar.d;
            j jVar = bVar.b;
            if (i4 != jVar.f8218a) {
                long j5 = jVar.b[i4];
                long j6 = this.r[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i2 = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i : i2;
    }

    private void d() {
        this.h = 0;
        this.k = 0;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public int a(com.opos.exoplayer.core.extractor.f fVar, k kVar) {
        while (true) {
            int i = this.h;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return c(fVar, kVar);
                    }
                    throw new IllegalStateException();
                }
                if (b(fVar, kVar)) {
                    return 1;
                }
            } else if (!b(fVar)) {
                return -1;
            }
        }
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public long b() {
        return this.t;
    }

    public Mp4Extractor(int i) {
        this.c = i;
        this.f = new p(16);
        this.g = new Stack<>();
        this.d = new p(com.opos.exoplayer.core.util.n.f8396a);
        this.e = new p(4);
        this.m = -1;
    }

    private static int a(j jVar, long j) {
        int iA = jVar.a(j);
        return iA == -1 ? jVar.b(j) : iA;
    }

    private int c(com.opos.exoplayer.core.extractor.f fVar, k kVar) {
        long jC = fVar.c();
        if (this.m == -1) {
            int iC = c(jC);
            this.m = iC;
            if (iC == -1) {
                return -1;
            }
        }
        b bVar = this.q[this.m];
        n nVar = bVar.c;
        int i = bVar.d;
        j jVar = bVar.b;
        long j = jVar.b[i];
        int i2 = jVar.c[i];
        long j2 = (j - jC) + ((long) this.n);
        if (j2 < 0 || j2 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            kVar.f8182a = j;
            return 1;
        }
        if (bVar.f8202a.g == 1) {
            j2 += 8;
            i2 -= 8;
        }
        fVar.b((int) j2);
        int i3 = bVar.f8202a.j;
        if (i3 == 0) {
            while (true) {
                int i4 = this.n;
                if (i4 >= i2) {
                    break;
                }
                int iA = nVar.a(fVar, i2 - i4, false);
                this.n += iA;
                this.o -= iA;
            }
        } else {
            byte[] bArr = this.e.f8400a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i5 = 4 - i3;
            while (this.n < i2) {
                int i6 = this.o;
                if (i6 == 0) {
                    fVar.b(this.e.f8400a, i5, i3);
                    this.e.c(0);
                    this.o = this.e.u();
                    this.d.c(0);
                    nVar.a(this.d, 4);
                    this.n += 4;
                    i2 += i5;
                } else {
                    int iA2 = nVar.a(fVar, i6, false);
                    this.n += iA2;
                    this.o -= iA2;
                }
            }
        }
        j jVar2 = bVar.b;
        nVar.a(jVar2.e[i], jVar2.f[i], i2, 0, null);
        bVar.d++;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        return 0;
    }

    private void d(long j) {
        for (b bVar : this.q) {
            j jVar = bVar.b;
            int iA = jVar.a(j);
            if (iA == -1) {
                iA = jVar.b(j);
            }
            bVar.d = iA;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public l.a b(long j) {
        long j2;
        long j3;
        int iB;
        b[] bVarArr = this.q;
        if (bVarArr.length == 0) {
            return new l.a(m.f8185a);
        }
        int i = this.s;
        long jA = -1;
        if (i != -1) {
            j jVar = bVarArr[i].b;
            int iA = a(jVar, j);
            if (iA == -1) {
                return new l.a(m.f8185a);
            }
            long j4 = jVar.e[iA];
            j2 = jVar.b[iA];
            if (j4 >= j || iA >= jVar.f8218a - 1 || (iB = jVar.b(j)) == -1 || iB == iA) {
                j3 = -9223372036854775807L;
            } else {
                j3 = jVar.e[iB];
                jA = jVar.b[iB];
            }
            j = j4;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            b[] bVarArr2 = this.q;
            if (i2 >= bVarArr2.length) {
                break;
            }
            if (i2 != this.s) {
                j jVar2 = bVarArr2[i2].b;
                long jA2 = a(jVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    jA = a(jVar2, j3, jA);
                }
                j2 = jA2;
            }
            i2++;
        }
        m mVar = new m(j, j2);
        return j3 == -9223372036854775807L ? new l.a(mVar) : new l.a(mVar, new m(j3, jA));
    }

    private static long a(j jVar, long j, long j2) {
        int iA = a(jVar, j);
        return iA == -1 ? j2 : Math.min(jVar.b[iA], j2);
    }

    private static boolean b(int i) {
        return i == d.B || i == d.D || i == d.E || i == d.F || i == d.G || i == d.P;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void c() {
    }

    private void a(long j) throws com.opos.exoplayer.core.m {
        while (!this.g.isEmpty() && this.g.peek().aP == j) {
            d.a aVarPop = this.g.pop();
            if (aVarPop.aO == d.B) {
                a(aVarPop);
                this.g.clear();
                this.h = 2;
            } else if (!this.g.isEmpty()) {
                this.g.peek().a(aVarPop);
            }
        }
        if (this.h != 2) {
            d();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(com.opos.exoplayer.core.extractor.f fVar) throws com.opos.exoplayer.core.m {
        long jC;
        if (this.k == 0) {
            if (!fVar.a(this.f.f8400a, 0, 8, true)) {
                return false;
            }
            this.k = 8;
            this.f.c(0);
            this.j = this.f.m();
            this.i = this.f.o();
        }
        long j = this.j;
        if (j != 1) {
            if (j == 0) {
                long jD = fVar.d();
                if (jD == -1 && !this.g.isEmpty()) {
                    jD = this.g.peek().aP;
                }
                if (jD != -1) {
                    jC = (jD - fVar.c()) + ((long) this.k);
                }
            }
            if (this.j >= this.k) {
                throw new com.opos.exoplayer.core.m("Atom size less than header length (unsupported).");
            }
            if (b(this.i)) {
                long jC2 = (fVar.c() + this.j) - ((long) this.k);
                this.g.add(new d.a(this.i, jC2));
                if (this.j == this.k) {
                    a(jC2);
                } else {
                    d();
                }
            } else {
                if (a(this.i)) {
                    com.opos.exoplayer.core.util.a.b(this.k == 8);
                    com.opos.exoplayer.core.util.a.b(this.j <= 2147483647L);
                    p pVar = new p((int) this.j);
                    this.l = pVar;
                    System.arraycopy(this.f.f8400a, 0, pVar.f8400a, 0, 8);
                } else {
                    this.l = null;
                }
                this.h = 1;
            }
            return true;
        }
        fVar.b(this.f.f8400a, 8, 8);
        this.k += 8;
        jC = this.f.w();
        this.j = jC;
        if (this.j >= this.k) {
        }
    }

    private boolean b(com.opos.exoplayer.core.extractor.f fVar, k kVar) throws com.opos.exoplayer.core.m {
        boolean z;
        long j = this.j - ((long) this.k);
        long jC = fVar.c() + j;
        p pVar = this.l;
        if (pVar != null) {
            fVar.b(pVar.f8400a, this.k, (int) j);
            if (this.i == d.f8207a) {
                this.u = a(this.l);
            } else if (!this.g.isEmpty()) {
                this.g.peek().a(new d.b(this.i, this.l));
            }
        } else {
            if (j >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                kVar.f8182a = fVar.c() + j;
                z = true;
                a(jC);
                return (z || this.h == 2) ? false : true;
            }
            fVar.b((int) j);
        }
        z = false;
        a(jC);
        if (z) {
        }
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(long j, long j2) {
        this.g.clear();
        this.k = 0;
        this.m = -1;
        this.n = 0;
        this.o = 0;
        if (j == 0) {
            d();
        } else if (this.q != null) {
            d(j2);
        }
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(com.opos.exoplayer.core.extractor.g gVar) {
        this.p = gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(d.a aVar) throws com.opos.exoplayer.core.m {
        Metadata metadataA;
        ArrayList arrayList = new ArrayList();
        com.opos.exoplayer.core.extractor.i iVar = new com.opos.exoplayer.core.extractor.i();
        d.b bVarD = aVar.d(d.az);
        if (bVarD != null) {
            metadataA = e.a(bVarD, this.u);
            if (metadataA != null) {
                iVar.a(metadataA);
            }
        } else {
            metadataA = null;
        }
        long jMax = -9223372036854775807L;
        int size = -1;
        for (int i = 0; i < aVar.aR.size(); i++) {
            d.a aVar2 = aVar.aR.get(i);
            if (aVar2.aO == d.D) {
                Track trackA = e.a(aVar2, aVar.d(d.C), -9223372036854775807L, (DrmInitData) null, (this.c & 1) != 0, this.u);
                if (trackA != null) {
                    j jVarA = e.a(trackA, aVar2.e(d.E).e(d.F).e(d.G), iVar);
                    if (jVarA.f8218a != 0) {
                        b bVar = new b(trackA, jVarA, this.p.a(i, trackA.b));
                        Format formatA = trackA.f.a(jVarA.d + 30);
                        if (trackA.b == 1) {
                            if (iVar.a()) {
                                formatA = formatA.a(iVar.b, iVar.c);
                            }
                            if (metadataA != null) {
                                formatA = formatA.a(metadataA);
                            }
                        }
                        bVar.c.a(formatA);
                        long j = trackA.e;
                        if (j == -9223372036854775807L) {
                            j = jVarA.g;
                        }
                        jMax = Math.max(jMax, j);
                        if (trackA.b == 2 && size == -1) {
                            size = arrayList.size();
                        }
                        arrayList.add(bVar);
                    }
                }
            }
        }
        this.s = size;
        this.t = jMax;
        b[] bVarArr = (b[]) arrayList.toArray(new b[arrayList.size()]);
        this.q = bVarArr;
        this.r = a(bVarArr);
        this.p.a();
        this.p.a(this);
    }

    @Override // com.opos.exoplayer.core.extractor.l
    public boolean a() {
        return true;
    }

    private static boolean a(int i) {
        return i == d.R || i == d.C || i == d.S || i == d.T || i == d.al || i == d.am || i == d.an || i == d.Q || i == d.ao || i == d.ap || i == d.aq || i == d.ar || i == d.as || i == d.O || i == d.f8207a || i == d.az;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public boolean a(com.opos.exoplayer.core.extractor.f fVar) {
        return h.b(fVar);
    }

    private static boolean a(p pVar) {
        pVar.c(8);
        if (pVar.o() == b) {
            return true;
        }
        pVar.d(4);
        while (pVar.b() > 0) {
            if (pVar.o() == b) {
                return true;
            }
        }
        return false;
    }

    private static long[][] a(b[] bVarArr) {
        long[][] jArr = new long[bVarArr.length][];
        int[] iArr = new int[bVarArr.length];
        long[] jArr2 = new long[bVarArr.length];
        boolean[] zArr = new boolean[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            jArr[i] = new long[bVarArr[i].b.f8218a];
            jArr2[i] = bVarArr[i].b.e[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < bVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < bVarArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            long[] jArr3 = jArr[i3];
            jArr3[i5] = j;
            j jVar = bVarArr[i3].b;
            j += (long) jVar.c[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr3.length) {
                jArr2[i3] = jVar.e[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }
}
