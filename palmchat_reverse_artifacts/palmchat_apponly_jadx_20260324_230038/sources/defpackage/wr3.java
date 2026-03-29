package defpackage;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import defpackage.v45;
import defpackage.vi;
import defpackage.wi;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class wr3 implements os1, v45 {
    public static final ys1 y = new ys1() { // from class: pr3
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return wr3.m();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21785a;
    public final gc4 b;
    public final gc4 c;
    public final gc4 d;
    public final gc4 e;
    public final ArrayDeque<vi.a> f;
    public final z45 g;
    public final List<Metadata.Entry> h;
    public int i;
    public int j;
    public long k;
    public int l;

    @Nullable
    public gc4 m;
    public int n;
    public int o;
    public int p;
    public int q;
    public qs1 r;
    public a[] s;
    public long[][] t;
    public int u;
    public long v;
    public int w;

    @Nullable
    public MotionPhotoMetadata x;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lz5 f21786a;
        public final d06 b;
        public final c06 c;

        @Nullable
        public final s16 d;
        public int e;

        public a(lz5 lz5Var, d06 d06Var, c06 c06Var) {
            this.f21786a = lz5Var;
            this.b = d06Var;
            this.c = c06Var;
            this.d = "audio/true-hd".equals(lz5Var.f.l) ? new s16() : null;
        }
    }

    public wr3() {
        this(0);
    }

    public static int f(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    public static long[][] g(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            jArr[i] = new long[aVarArr[i].b.b];
            jArr2[i] = aVarArr[i].b.f[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < aVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
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
            d06 d06Var = aVarArr[i3].b;
            j += (long) d06Var.d[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr3.length) {
                jArr2[i3] = d06Var.f[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    public static int j(d06 d06Var, long j) {
        int iA = d06Var.a(j);
        return iA == -1 ? d06Var.b(j) : iA;
    }

    public static /* synthetic */ os1[] m() {
        return new os1[]{new wr3()};
    }

    public static long n(d06 d06Var, long j, long j2) {
        int iJ = j(d06Var, j);
        return iJ == -1 ? j2 : Math.min(d06Var.c[iJ], j2);
    }

    public static int r(gc4 gc4Var) {
        gc4Var.U(8);
        int iF = f(gc4Var.q());
        if (iF != 0) {
            return iF;
        }
        gc4Var.V(4);
        while (gc4Var.a() > 0) {
            int iF2 = f(gc4Var.q());
            if (iF2 != 0) {
                return iF2;
            }
        }
        return 0;
    }

    public static boolean y(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    public static boolean z(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    public final void A(a aVar, long j) {
        d06 d06Var = aVar.b;
        int iA = d06Var.a(j);
        if (iA == -1) {
            iA = d06Var.b(j);
        }
        aVar.e = iA;
    }

    @Override // defpackage.os1
    public void b(qs1 qs1Var) {
        this.r = qs1Var;
    }

    @Override // defpackage.os1
    public int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        while (true) {
            int i = this.i;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return w(ps1Var, vk4Var);
                    }
                    if (i == 3) {
                        return x(ps1Var, vk4Var);
                    }
                    throw new IllegalStateException();
                }
                if (v(ps1Var, vk4Var)) {
                    return 1;
                }
            } else if (!u(ps1Var)) {
                return -1;
            }
        }
    }

    @Override // defpackage.os1
    public boolean d(ps1 ps1Var) throws IOException {
        return sf5.d(ps1Var, (this.f21785a & 2) != 0);
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.v;
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        return i(j, -1);
    }

    public final void h() {
        this.i = 0;
        this.l = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public v45.a i(long j, int i) {
        long jN;
        long j2;
        long jN2;
        long j3;
        int iB;
        a[] aVarArr = this.s;
        if (aVarArr.length == 0) {
            return new v45.a(x45.c);
        }
        int i2 = i != -1 ? i : this.u;
        if (i2 != -1) {
            d06 d06Var = aVarArr[i2].b;
            int iJ = j(d06Var, j);
            if (iJ == -1) {
                return new v45.a(x45.c);
            }
            j2 = d06Var.f[iJ];
            jN = d06Var.c[iJ];
            if (j2 < j && iJ < d06Var.b - 1 && (iB = d06Var.b(j)) != -1 && iB != iJ) {
                j3 = d06Var.f[iB];
                jN2 = d06Var.c[iB];
            }
            if (i == -1) {
                int i3 = 0;
                while (true) {
                    a[] aVarArr2 = this.s;
                    if (i3 >= aVarArr2.length) {
                        break;
                    }
                    if (i3 != this.u) {
                        d06 d06Var2 = aVarArr2[i3].b;
                        jN = n(d06Var2, j2, jN);
                        if (j3 != -9223372036854775807L) {
                            jN2 = n(d06Var2, j3, jN2);
                        }
                    }
                    i3++;
                }
            }
            x45 x45Var = new x45(j2, jN);
            return j3 != -9223372036854775807L ? new v45.a(x45Var) : new v45.a(x45Var, new x45(j3, jN2));
        }
        jN = Long.MAX_VALUE;
        j2 = j;
        jN2 = -1;
        j3 = -9223372036854775807L;
        if (i == -1) {
        }
        x45 x45Var2 = new x45(j2, jN);
        if (j3 != -9223372036854775807L) {
        }
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return true;
    }

    public final int k(long j) {
        int i = -1;
        int i2 = -1;
        int i3 = 0;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.s;
            if (i3 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i3];
            int i4 = aVar.e;
            d06 d06Var = aVar.b;
            if (i4 != d06Var.b) {
                long j5 = d06Var.c[i4];
                long j6 = ((long[][]) g86.j(this.t))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i2 = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
            i3++;
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    public final void o(ps1 ps1Var) throws IOException {
        this.d.Q(8);
        ps1Var.peekFully(this.d.e(), 0, 8);
        wi.f(this.d);
        ps1Var.skipFully(this.d.f());
        ps1Var.resetPeekPosition();
    }

    public final void p(long j) throws ParserException {
        while (!this.f.isEmpty() && this.f.peek().b == j) {
            vi.a aVarPop = this.f.pop();
            if (aVarPop.f21448a == 1836019574) {
                s(aVarPop);
                this.f.clear();
                this.i = 2;
            } else if (!this.f.isEmpty()) {
                this.f.peek().d(aVarPop);
            }
        }
        if (this.i != 2) {
            h();
        }
    }

    public final void q() {
        if (this.w != 2 || (this.f21785a & 2) == 0) {
            return;
        }
        this.r.track(0, 4).b(new m.b().Z(this.x == null ? null : new Metadata(this.x)).G());
        this.r.endTracks();
        this.r.d(new v45.b(-9223372036854775807L));
    }

    public final void s(vi.a aVar) throws ParserException {
        Metadata metadata;
        Metadata metadata2;
        Metadata metadata3;
        List<d06> list;
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        boolean z = this.w == 1;
        m52 m52Var = new m52();
        vi.b bVarG = aVar.g(1969517665);
        if (bVarG != null) {
            wi.i iVarC = wi.C(bVarG);
            Metadata metadata4 = iVarC.f21719a;
            Metadata metadata5 = iVarC.b;
            Metadata metadata6 = iVarC.c;
            if (metadata4 != null) {
                m52Var.c(metadata4);
            }
            metadata = metadata6;
            metadata2 = metadata4;
            metadata3 = metadata5;
        } else {
            metadata = null;
            metadata2 = null;
            metadata3 = null;
        }
        vi.a aVarF = aVar.f(1835365473);
        Metadata metadataO = aVarF != null ? wi.o(aVarF) : null;
        Metadata metadata7 = wi.q(((vi.b) vh.e(aVar.g(1836476516))).b).f21714a;
        Metadata metadata8 = metadataO;
        List<d06> listB = wi.B(aVar, m52Var, -9223372036854775807L, null, (this.f21785a & 1) != 0, z, new u42() { // from class: sr3
            @Override // defpackage.u42
            public final Object apply(Object obj) {
                return wr3.l((lz5) obj);
            }
        });
        int size = listB.size();
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        int i3 = 0;
        int size2 = -1;
        while (i3 < size) {
            d06 d06Var = listB.get(i3);
            if (d06Var.b == 0) {
                list = listB;
                i = size;
            } else {
                lz5 lz5Var = d06Var.f16956a;
                list = listB;
                i = size;
                long j3 = lz5Var.e;
                if (j3 == j) {
                    j3 = d06Var.h;
                }
                long jMax = Math.max(j2, j3);
                a aVar2 = new a(lz5Var, d06Var, this.r.track(i3, lz5Var.b));
                int i4 = "audio/true-hd".equals(lz5Var.f.l) ? d06Var.e * 16 : d06Var.e + 30;
                m.b bVarB = lz5Var.f.b();
                bVarB.Y(i4);
                if (lz5Var.b == 2 && j3 > 0 && (i2 = d06Var.b) > 1) {
                    bVarB.R(i2 / (j3 / 1000000.0f));
                }
                xo3.k(lz5Var.b, m52Var, bVarB);
                int i5 = lz5Var.b;
                Metadata[] metadataArr = new Metadata[4];
                metadataArr[0] = metadata3;
                metadataArr[1] = this.h.isEmpty() ? null : new Metadata(this.h);
                metadataArr[2] = metadata;
                metadataArr[3] = metadata7;
                xo3.l(i5, metadata2, metadata8, bVarB, metadataArr);
                aVar2.c.b(bVarB.G());
                if (lz5Var.b == 2 && size2 == -1) {
                    size2 = arrayList.size();
                }
                arrayList.add(aVar2);
                j2 = jMax;
            }
            i3++;
            listB = list;
            size = i;
            j = -9223372036854775807L;
        }
        this.u = size2;
        this.v = j2;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.s = aVarArr;
        this.t = g(aVarArr);
        this.r.endTracks();
        this.r.d(this);
    }

    @Override // defpackage.os1
    public void seek(long j, long j2) {
        this.f.clear();
        this.l = 0;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        if (j == 0) {
            if (this.i != 3) {
                h();
                return;
            } else {
                this.g.g();
                this.h.clear();
                return;
            }
        }
        for (a aVar : this.s) {
            A(aVar, j2);
            s16 s16Var = aVar.d;
            if (s16Var != null) {
                s16Var.b();
            }
        }
    }

    public final void t(long j) {
        if (this.j == 1836086884) {
            int i = this.l;
            this.x = new MotionPhotoMetadata(0L, j, -9223372036854775807L, j + ((long) i), this.k - ((long) i));
        }
    }

    public final boolean u(ps1 ps1Var) throws IOException {
        vi.a aVarPeek;
        if (this.l == 0) {
            if (!ps1Var.readFully(this.e.e(), 0, 8, true)) {
                q();
                return false;
            }
            this.l = 8;
            this.e.U(0);
            this.k = this.e.J();
            this.j = this.e.q();
        }
        long j = this.k;
        if (j == 1) {
            ps1Var.readFully(this.e.e(), 8, 8);
            this.l += 8;
            this.k = this.e.M();
        } else if (j == 0) {
            long length = ps1Var.getLength();
            if (length == -1 && (aVarPeek = this.f.peek()) != null) {
                length = aVarPeek.b;
            }
            if (length != -1) {
                this.k = (length - ps1Var.getPosition()) + ((long) this.l);
            }
        }
        if (this.k < this.l) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        if (y(this.j)) {
            long position = ps1Var.getPosition();
            long j2 = this.k;
            int i = this.l;
            long j3 = (position + j2) - ((long) i);
            if (j2 != i && this.j == 1835365473) {
                o(ps1Var);
            }
            this.f.push(new vi.a(this.j, j3));
            if (this.k == this.l) {
                p(j3);
            } else {
                h();
            }
        } else if (z(this.j)) {
            vh.g(this.l == 8);
            vh.g(this.k <= 2147483647L);
            gc4 gc4Var = new gc4((int) this.k);
            System.arraycopy(this.e.e(), 0, gc4Var.e(), 0, 8);
            this.m = gc4Var;
            this.i = 1;
        } else {
            t(ps1Var.getPosition() - ((long) this.l));
            this.m = null;
            this.i = 1;
        }
        return true;
    }

    public final boolean v(ps1 ps1Var, vk4 vk4Var) throws IOException {
        boolean z;
        long j = this.k - ((long) this.l);
        long position = ps1Var.getPosition() + j;
        gc4 gc4Var = this.m;
        if (gc4Var != null) {
            ps1Var.readFully(gc4Var.e(), this.l, (int) j);
            if (this.j == 1718909296) {
                this.w = r(gc4Var);
            } else if (!this.f.isEmpty()) {
                this.f.peek().e(new vi.b(this.j, gc4Var));
            }
        } else {
            if (j >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                vk4Var.f21468a = ps1Var.getPosition() + j;
                z = true;
                p(position);
                return (z || this.i == 2) ? false : true;
            }
            ps1Var.skipFully((int) j);
        }
        z = false;
        p(position);
        if (z) {
        }
    }

    public final int w(ps1 ps1Var, vk4 vk4Var) throws IOException {
        int i;
        vk4 vk4Var2;
        long position = ps1Var.getPosition();
        if (this.n == -1) {
            int iK = k(position);
            this.n = iK;
            if (iK == -1) {
                return -1;
            }
        }
        a aVar = this.s[this.n];
        c06 c06Var = aVar.c;
        int i2 = aVar.e;
        d06 d06Var = aVar.b;
        long j = d06Var.c[i2];
        int i3 = d06Var.d[i2];
        s16 s16Var = aVar.d;
        long j2 = (j - position) + ((long) this.o);
        if (j2 < 0) {
            i = 1;
            vk4Var2 = vk4Var;
        } else {
            if (j2 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                if (aVar.f21786a.g == 1) {
                    j2 += 8;
                    i3 -= 8;
                }
                ps1Var.skipFully((int) j2);
                lz5 lz5Var = aVar.f21786a;
                if (lz5Var.j == 0) {
                    if ("audio/ac4".equals(lz5Var.f.l)) {
                        if (this.p == 0) {
                            n2.a(i3, this.d);
                            c06Var.d(this.d, 7);
                            this.p += 7;
                        }
                        i3 += 7;
                    } else if (s16Var != null) {
                        s16Var.d(ps1Var);
                    }
                    while (true) {
                        int i4 = this.p;
                        if (i4 >= i3) {
                            break;
                        }
                        int iC = c06Var.c(ps1Var, i3 - i4, false);
                        this.o += iC;
                        this.p += iC;
                        this.q -= iC;
                    }
                } else {
                    byte[] bArrE = this.c.e();
                    bArrE[0] = 0;
                    bArrE[1] = 0;
                    bArrE[2] = 0;
                    int i5 = aVar.f21786a.j;
                    int i6 = 4 - i5;
                    while (this.p < i3) {
                        int i7 = this.q;
                        if (i7 == 0) {
                            ps1Var.readFully(bArrE, i6, i5);
                            this.o += i5;
                            this.c.U(0);
                            int iQ = this.c.q();
                            if (iQ < 0) {
                                throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                            }
                            this.q = iQ;
                            this.b.U(0);
                            c06Var.d(this.b, 4);
                            this.p += 4;
                            i3 += i6;
                        } else {
                            int iC2 = c06Var.c(ps1Var, i7, false);
                            this.o += iC2;
                            this.p += iC2;
                            this.q -= iC2;
                        }
                    }
                }
                int i8 = i3;
                d06 d06Var2 = aVar.b;
                long j3 = d06Var2.f[i2];
                int i9 = d06Var2.g[i2];
                if (s16Var != null) {
                    s16Var.c(c06Var, j3, i9, i8, 0, null);
                    if (i2 + 1 == aVar.b.b) {
                        s16Var.a(c06Var, null);
                    }
                } else {
                    c06Var.e(j3, i9, i8, 0, null);
                }
                aVar.e++;
                this.n = -1;
                this.o = 0;
                this.p = 0;
                this.q = 0;
                return 0;
            }
            vk4Var2 = vk4Var;
            i = 1;
        }
        vk4Var2.f21468a = j;
        return i;
    }

    public final int x(ps1 ps1Var, vk4 vk4Var) throws IOException {
        int iC = this.g.c(ps1Var, vk4Var, this.h);
        if (iC == 1 && vk4Var.f21468a == 0) {
            h();
        }
        return iC;
    }

    public wr3(int i) {
        this.f21785a = i;
        this.i = (i & 4) != 0 ? 3 : 0;
        this.g = new z45();
        this.h = new ArrayList();
        this.e = new gc4(16);
        this.f = new ArrayDeque<>();
        this.b = new gc4(ot3.f19869a);
        this.c = new gc4(4);
        this.d = new gc4();
        this.n = -1;
        this.r = qs1.c0;
        this.s = new a[0];
    }

    @Override // defpackage.os1
    public void release() {
    }

    public static /* synthetic */ lz5 l(lz5 lz5Var) {
        return lz5Var;
    }
}
