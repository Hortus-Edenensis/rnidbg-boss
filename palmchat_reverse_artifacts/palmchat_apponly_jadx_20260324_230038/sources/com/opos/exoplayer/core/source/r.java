package com.opos.exoplayer.core.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.decoder.DecoderInputBuffer;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.source.g;
import com.opos.exoplayer.core.source.i;
import com.opos.exoplayer.core.source.k;
import com.opos.exoplayer.core.u;
import com.opos.exoplayer.core.upstream.DataSpec;
import com.opos.exoplayer.core.upstream.p;
import com.opos.exoplayer.core.util.y;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class r implements com.opos.exoplayer.core.extractor.g, g, k.a, p.a<c>, p.c {
    private boolean[] A;
    private boolean[] B;
    private boolean[] C;
    private boolean D;
    private long F;
    private boolean H;
    private int I;
    private boolean J;
    private boolean K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f8306a;
    private final com.opos.exoplayer.core.upstream.g b;
    private final int c;
    private final i.a d;
    private final e e;
    private final com.opos.exoplayer.core.upstream.b f;

    @Nullable
    private final String g;
    private final long h;
    private final d j;
    private g.a o;
    private com.opos.exoplayer.core.extractor.l p;
    private boolean s;
    private boolean t;
    private int u;
    private boolean v;
    private boolean w;
    private int x;
    private p y;
    private final com.opos.exoplayer.core.upstream.p i = new com.opos.exoplayer.core.upstream.p("Loader:ExtractorMediaPeriod");
    private final com.opos.exoplayer.core.util.h k = new com.opos.exoplayer.core.util.h();
    private final Runnable l = new a();
    private final Runnable m = new b();
    private final Handler n = new Handler();
    private int[] r = new int[0];
    private k[] q = new k[0];
    private long G = -9223372036854775807L;
    private long E = -1;
    private long z = -9223372036854775807L;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r.this.j();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.this.K) {
                return;
            }
            r.this.o.a(r.this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements p.b {
        private final Uri b;
        private final com.opos.exoplayer.core.upstream.g c;
        private final d d;
        private final com.opos.exoplayer.core.util.h e;
        private volatile boolean g;
        private long i;
        private DataSpec j;
        private long l;
        private final com.opos.exoplayer.core.extractor.k f = new com.opos.exoplayer.core.extractor.k();
        private boolean h = true;
        private long k = -1;

        public c(Uri uri, com.opos.exoplayer.core.upstream.g gVar, d dVar, com.opos.exoplayer.core.util.h hVar) {
            this.b = (Uri) com.opos.exoplayer.core.util.a.a(uri);
            this.c = (com.opos.exoplayer.core.upstream.g) com.opos.exoplayer.core.util.a.a(gVar);
            this.d = (d) com.opos.exoplayer.core.util.a.a(dVar);
            this.e = hVar;
        }

        @Override // com.opos.exoplayer.core.upstream.p.b
        public void a() {
            this.g = true;
        }

        @Override // com.opos.exoplayer.core.upstream.p.b
        public boolean b() {
            return this.g;
        }

        @Override // com.opos.exoplayer.core.upstream.p.b
        public void c() throws Throwable {
            com.opos.exoplayer.core.extractor.b bVar;
            int iA = 0;
            while (iA == 0 && !this.g) {
                try {
                    long jC = this.f.f8182a;
                    DataSpec dataSpec = new DataSpec(this.b, jC, -1L, r.this.g);
                    this.j = dataSpec;
                    long jA = this.c.a(dataSpec);
                    this.k = jA;
                    if (jA != -1) {
                        this.k = jA + jC;
                    }
                    bVar = new com.opos.exoplayer.core.extractor.b(this.c, jC, this.k);
                    try {
                        com.opos.exoplayer.core.extractor.e eVarA = this.d.a(bVar, this.c.a());
                        if (this.h) {
                            eVarA.a(jC, this.i);
                            this.h = false;
                        }
                        while (iA == 0 && !this.g) {
                            this.e.c();
                            iA = eVarA.a(bVar, this.f);
                            if (bVar.c() > r.this.h + jC) {
                                jC = bVar.c();
                                this.e.b();
                                r.this.n.post(r.this.m);
                            }
                        }
                        if (iA == 1) {
                            iA = 0;
                        } else {
                            this.f.f8182a = bVar.c();
                            this.l = this.f.f8182a - this.j.c;
                        }
                        y.a(this.c);
                    } catch (Throwable th) {
                        th = th;
                        if (iA != 1 && bVar != null) {
                            this.f.f8182a = bVar.c();
                            this.l = this.f.f8182a - this.j.c;
                        }
                        y.a(this.c);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = null;
                }
            }
        }

        public void a(long j, long j2) {
            this.f.f8182a = j;
            this.i = j2;
            this.h = true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.opos.exoplayer.core.extractor.e[] f8310a;
        private final com.opos.exoplayer.core.extractor.g b;
        private com.opos.exoplayer.core.extractor.e c;

        public d(com.opos.exoplayer.core.extractor.e[] eVarArr, com.opos.exoplayer.core.extractor.g gVar) {
            this.f8310a = eVarArr;
            this.b = gVar;
        }

        public com.opos.exoplayer.core.extractor.e a(com.opos.exoplayer.core.extractor.f fVar, Uri uri) throws q {
            com.opos.exoplayer.core.extractor.e eVar = this.c;
            if (eVar != null) {
                return eVar;
            }
            com.opos.exoplayer.core.extractor.e[] eVarArr = this.f8310a;
            int length = eVarArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.opos.exoplayer.core.extractor.e eVar2 = eVarArr[i];
                try {
                    if (eVar2.a(fVar)) {
                        this.c = eVar2;
                        fVar.a();
                        break;
                    }
                    continue;
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    fVar.a();
                    throw th;
                }
                fVar.a();
                i++;
            }
            com.opos.exoplayer.core.extractor.e eVar3 = this.c;
            if (eVar3 != null) {
                eVar3.a(this.b);
                return this.c;
            }
            throw new q("None of the available extractors (" + y.a(this.f8310a) + ") could read the stream.", uri);
        }

        public void a() {
            com.opos.exoplayer.core.extractor.e eVar = this.c;
            if (eVar != null) {
                eVar.c();
                this.c = null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a(long j, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class f implements l {
        private final int b;

        public f(int i) {
            this.b = i;
        }

        @Override // com.opos.exoplayer.core.source.l
        public int a(long j) {
            return r.this.a(this.b, j);
        }

        @Override // com.opos.exoplayer.core.source.l
        public boolean b() {
            return r.this.a(this.b);
        }

        @Override // com.opos.exoplayer.core.source.l
        public void c() throws IOException {
            r.this.h();
        }

        @Override // com.opos.exoplayer.core.source.l
        public int a(com.opos.exoplayer.core.j jVar, DecoderInputBuffer decoderInputBuffer, boolean z) {
            return r.this.a(this.b, jVar, decoderInputBuffer, z);
        }
    }

    public r(Uri uri, com.opos.exoplayer.core.upstream.g gVar, com.opos.exoplayer.core.extractor.e[] eVarArr, int i, i.a aVar, e eVar, com.opos.exoplayer.core.upstream.b bVar, @Nullable String str, int i2) {
        this.f8306a = uri;
        this.b = gVar;
        this.c = i;
        this.d = aVar;
        this.e = eVar;
        this.f = bVar;
        this.g = str;
        this.h = i2;
        this.j = new d(eVarArr, this);
        this.u = i == -1 ? 3 : i;
    }

    private boolean i() {
        return this.w || n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.K || this.t || this.p == null || !this.s) {
            return;
        }
        for (k kVar : this.q) {
            if (kVar.e() == null) {
                return;
            }
        }
        this.k.b();
        int length = this.q.length;
        o[] oVarArr = new o[length];
        this.B = new boolean[length];
        this.A = new boolean[length];
        this.C = new boolean[length];
        this.z = this.p.b();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= length) {
                break;
            }
            Format formatE = this.q[i].e();
            oVarArr[i] = new o(formatE);
            String str = formatE.f;
            if (!com.opos.exoplayer.core.util.m.b(str) && !com.opos.exoplayer.core.util.m.a(str)) {
                z = false;
            }
            this.B[i] = z;
            this.D = z | this.D;
            i++;
        }
        this.y = new p(oVarArr);
        if (this.c == -1 && this.E == -1 && this.p.b() == -9223372036854775807L) {
            this.u = 6;
        }
        this.t = true;
        this.e.a(this.z, this.p.a());
        this.o.a((g) this);
    }

    private void k() {
        c cVar = new c(this.f8306a, this.b, this.j, this.k);
        if (this.t) {
            com.opos.exoplayer.core.util.a.b(n());
            long j = this.z;
            if (j != -9223372036854775807L && this.G >= j) {
                this.J = true;
                this.G = -9223372036854775807L;
                return;
            } else {
                cVar.a(this.p.b(this.G).f8183a.c, this.G);
                this.G = -9223372036854775807L;
            }
        }
        this.I = l();
        this.d.a(cVar.j, 1, -1, null, 0, null, cVar.i, this.z, this.i.a(cVar, this, this.u));
    }

    private int l() {
        int iB = 0;
        for (k kVar : this.q) {
            iB += kVar.b();
        }
        return iB;
    }

    private long m() {
        long jMax = Long.MIN_VALUE;
        for (k kVar : this.q) {
            jMax = Math.max(jMax, kVar.f());
        }
        return jMax;
    }

    private boolean n() {
        return this.G != -9223372036854775807L;
    }

    public int a(int i, long j) {
        int i2 = 0;
        if (i()) {
            return 0;
        }
        k kVar = this.q[i];
        if (!this.J || j <= kVar.f()) {
            int iB = kVar.b(j, true, true);
            if (iB != -1) {
                i2 = iB;
            }
        } else {
            i2 = kVar.i();
        }
        if (i2 > 0) {
            b(i);
        } else {
            c(i);
        }
        return i2;
    }

    @Override // com.opos.exoplayer.core.source.g
    public long b(long j) {
        if (!this.p.a()) {
            j = 0;
        }
        this.F = j;
        this.w = false;
        if (!n() && d(j)) {
            return j;
        }
        this.H = false;
        this.G = j;
        this.J = false;
        if (this.i.a()) {
            this.i.b();
        } else {
            for (k kVar : this.q) {
                kVar.a();
            }
        }
        return j;
    }

    @Override // com.opos.exoplayer.core.source.g
    public long c() {
        if (!this.w) {
            return -9223372036854775807L;
        }
        if (!this.J && l() <= this.I) {
            return -9223372036854775807L;
        }
        this.w = false;
        return this.F;
    }

    @Override // com.opos.exoplayer.core.source.g
    public void c_() throws IOException {
        h();
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public long d() {
        long jM;
        if (this.J) {
            return Long.MIN_VALUE;
        }
        if (n()) {
            return this.G;
        }
        if (this.D) {
            int length = this.q.length;
            jM = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (this.B[i]) {
                    jM = Math.min(jM, this.q[i].f());
                }
            }
        } else {
            jM = m();
        }
        return jM == Long.MIN_VALUE ? this.F : jM;
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public long e() {
        if (this.x == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public void h() throws IOException {
        this.i.a(this.u);
    }

    public int a(int i, com.opos.exoplayer.core.j jVar, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (i()) {
            return -3;
        }
        int iA = this.q[i].a(jVar, decoderInputBuffer, z, this.J, this.F);
        if (iA == -4) {
            b(i);
        } else if (iA == -3) {
            c(i);
        }
        return iA;
    }

    @Override // com.opos.exoplayer.core.source.g
    public p b() {
        return this.y;
    }

    public void f() {
        if (this.t) {
            for (k kVar : this.q) {
                kVar.h();
            }
        }
        this.i.a(this);
        this.n.removeCallbacksAndMessages(null);
        this.K = true;
    }

    @Override // com.opos.exoplayer.core.upstream.p.c
    public void g() {
        for (k kVar : this.q) {
            kVar.a();
        }
        this.j.a();
    }

    private void b(int i) {
        if (this.C[i]) {
            return;
        }
        Format formatA = this.y.a(i).a(0);
        this.d.a(com.opos.exoplayer.core.util.m.e(formatA.f), formatA, 0, null, this.F);
        this.C[i] = true;
    }

    private void c(int i) {
        if (this.H && this.B[i] && !this.q[i].c()) {
            this.G = 0L;
            this.H = false;
            this.w = true;
            this.F = 0L;
            this.I = 0;
            for (k kVar : this.q) {
                kVar.a();
            }
            this.o.a(this);
        }
    }

    private boolean d(long j) {
        int length = this.q.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                return true;
            }
            k kVar = this.q[i];
            kVar.g();
            if (!(kVar.b(j, true, false) != -1) && (this.B[i] || !this.D)) {
                break;
            }
            i++;
        }
        return false;
    }

    @Override // com.opos.exoplayer.core.upstream.p.a
    public int a(c cVar, long j, long j2, IOException iOException) {
        c cVar2;
        boolean z;
        boolean zA = a(iOException);
        this.d.a(cVar.j, 1, -1, null, 0, null, cVar.i, this.z, j, j2, cVar.l, iOException, zA);
        a(cVar);
        if (zA) {
            return 3;
        }
        int iL = l();
        if (iL > this.I) {
            cVar2 = cVar;
            z = true;
        } else {
            cVar2 = cVar;
            z = false;
        }
        if (a(cVar2, iL)) {
            return z ? 1 : 0;
        }
        return 2;
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public boolean c(long j) {
        if (this.J || this.H) {
            return false;
        }
        if (this.t && this.x == 0) {
            return false;
        }
        boolean zA = this.k.a();
        if (this.i.a()) {
            return zA;
        }
        k();
        return true;
    }

    @Override // com.opos.exoplayer.core.source.g
    public long a(long j, u uVar) {
        if (!this.p.a()) {
            return 0L;
        }
        l.a aVarB = this.p.b(j);
        return y.a(j, uVar, aVarB.f8183a.b, aVarB.b.b);
    }

    @Override // com.opos.exoplayer.core.source.g
    public long a(com.opos.exoplayer.core.c.f[] fVarArr, boolean[] zArr, l[] lVarArr, boolean[] zArr2, long j) {
        com.opos.exoplayer.core.c.f fVar;
        com.opos.exoplayer.core.util.a.b(this.t);
        int i = this.x;
        int i2 = 0;
        for (int i3 = 0; i3 < fVarArr.length; i3++) {
            l lVar = lVarArr[i3];
            if (lVar != null && (fVarArr[i3] == null || !zArr[i3])) {
                int i4 = ((f) lVar).b;
                com.opos.exoplayer.core.util.a.b(this.A[i4]);
                this.x--;
                this.A[i4] = false;
                lVarArr[i3] = null;
            }
        }
        boolean z = !this.v ? j == 0 : i != 0;
        for (int i5 = 0; i5 < fVarArr.length; i5++) {
            if (lVarArr[i5] == null && (fVar = fVarArr[i5]) != null) {
                com.opos.exoplayer.core.util.a.b(fVar.e() == 1);
                com.opos.exoplayer.core.util.a.b(fVar.b(0) == 0);
                int iA = this.y.a(fVar.d());
                com.opos.exoplayer.core.util.a.b(!this.A[iA]);
                this.x++;
                this.A[iA] = true;
                lVarArr[i5] = new f(iA);
                zArr2[i5] = true;
                if (!z) {
                    k kVar = this.q[iA];
                    kVar.g();
                    z = kVar.b(j, true, true) == -1 && kVar.d() != 0;
                }
            }
        }
        if (this.x == 0) {
            this.H = false;
            this.w = false;
            if (this.i.a()) {
                k[] kVarArr = this.q;
                int length = kVarArr.length;
                while (i2 < length) {
                    kVarArr[i2].h();
                    i2++;
                }
                this.i.b();
            } else {
                k[] kVarArr2 = this.q;
                int length2 = kVarArr2.length;
                while (i2 < length2) {
                    kVarArr2[i2].a();
                    i2++;
                }
            }
        } else if (z) {
            j = b(j);
            while (i2 < lVarArr.length) {
                if (lVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.v = true;
        return j;
    }

    @Override // com.opos.exoplayer.core.extractor.g
    public com.opos.exoplayer.core.extractor.n a(int i, int i2) {
        int length = this.q.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.r[i3] == i) {
                return this.q[i3];
            }
        }
        k kVar = new k(this.f);
        kVar.a(this);
        int i4 = length + 1;
        int[] iArrCopyOf = Arrays.copyOf(this.r, i4);
        this.r = iArrCopyOf;
        iArrCopyOf[length] = i;
        k[] kVarArr = (k[]) Arrays.copyOf(this.q, i4);
        this.q = kVarArr;
        kVarArr[length] = kVar;
        return kVar;
    }

    @Override // com.opos.exoplayer.core.extractor.g
    public void a() {
        this.s = true;
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.source.g, com.opos.exoplayer.core.source.m
    public void a(long j) {
    }

    @Override // com.opos.exoplayer.core.source.g
    public void a(long j, boolean z) {
        int length = this.q.length;
        for (int i = 0; i < length; i++) {
            this.q[i].a(j, z, this.A[i]);
        }
    }

    @Override // com.opos.exoplayer.core.source.k.a
    public void a(Format format) {
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.extractor.g
    public void a(com.opos.exoplayer.core.extractor.l lVar) {
        this.p = lVar;
        this.n.post(this.l);
    }

    @Override // com.opos.exoplayer.core.source.g
    public void a(g.a aVar, long j) {
        this.o = aVar;
        this.k.a();
        k();
    }

    private void a(c cVar) {
        if (this.E == -1) {
            this.E = cVar.k;
        }
    }

    @Override // com.opos.exoplayer.core.upstream.p.a
    public void a(c cVar, long j, long j2) {
        if (this.z == -9223372036854775807L) {
            long jM = m();
            long j3 = jM == Long.MIN_VALUE ? 0L : jM + 10000;
            this.z = j3;
            this.e.a(j3, this.p.a());
        }
        this.d.a(cVar.j, 1, -1, null, 0, null, cVar.i, this.z, j, j2, cVar.l);
        a(cVar);
        this.J = true;
        this.o.a(this);
    }

    @Override // com.opos.exoplayer.core.upstream.p.a
    public void a(c cVar, long j, long j2, boolean z) {
        this.d.b(cVar.j, 1, -1, null, 0, null, cVar.i, this.z, j, j2, cVar.l);
        if (z) {
            return;
        }
        a(cVar);
        for (k kVar : this.q) {
            kVar.a();
        }
        if (this.x > 0) {
            this.o.a(this);
        }
    }

    public boolean a(int i) {
        return !i() && (this.J || this.q[i].c());
    }

    private boolean a(c cVar, int i) {
        com.opos.exoplayer.core.extractor.l lVar;
        if (this.E != -1 || ((lVar = this.p) != null && lVar.b() != -9223372036854775807L)) {
            this.I = i;
            return true;
        }
        if (this.t && !i()) {
            this.H = true;
            return false;
        }
        this.w = this.t;
        this.F = 0L;
        this.I = 0;
        for (k kVar : this.q) {
            kVar.a();
        }
        cVar.a(0L, 0L);
        return true;
    }

    private static boolean a(IOException iOException) {
        return iOException instanceof q;
    }
}
