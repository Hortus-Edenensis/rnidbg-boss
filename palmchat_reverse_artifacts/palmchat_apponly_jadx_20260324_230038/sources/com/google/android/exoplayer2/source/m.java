package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.f;
import defpackage.c06;
import defpackage.cv0;
import defpackage.d25;
import defpackage.f12;
import defpackage.fp3;
import defpackage.g86;
import defpackage.gc4;
import defpackage.kh3;
import defpackage.m43;
import defpackage.ml0;
import defpackage.or1;
import defpackage.qs1;
import defpackage.qz5;
import defpackage.rk5;
import defpackage.ru0;
import defpackage.v45;
import defpackage.vh;
import defpackage.vk4;
import defpackage.vz5;
import defpackage.w45;
import defpackage.w9;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class m implements h, qs1, Loader.b<a>, Loader.f, p.d {
    public static final Map<String, String> N = y();
    public static final com.google.android.exoplayer2.m O = new m.b().U("icy").g0("application/x-icy").G();
    public boolean A;
    public boolean C;
    public boolean E;
    public int F;
    public boolean G;
    public long H;
    public boolean J;
    public int K;
    public boolean L;
    public boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f5974a;
    public final com.google.android.exoplayer2.upstream.a b;
    public final com.google.android.exoplayer2.drm.c c;
    public final com.google.android.exoplayer2.upstream.f d;
    public final j.a e;
    public final b.a f;
    public final b g;
    public final w9 h;

    @Nullable
    public final String i;
    public final long j;
    public final l l;

    @Nullable
    public h.a q;

    @Nullable
    public IcyHeaders r;
    public boolean u;
    public boolean v;
    public boolean w;
    public e x;
    public v45 y;
    public final Loader k = new Loader("ProgressiveMediaPeriod");
    public final ml0 m = new ml0();
    public final Runnable n = new Runnable() { // from class: bo4
        @Override // java.lang.Runnable
        public final void run() {
            this.f1791a.H();
        }
    };
    public final Runnable o = new Runnable() { // from class: co4
        @Override // java.lang.Runnable
        public final void run() {
            this.f2493a.E();
        }
    };
    public final Handler p = g86.w();
    public d[] t = new d[0];
    public p[] s = new p[0];
    public long I = -9223372036854775807L;
    public long z = -9223372036854775807L;
    public int B = 1;

    /* JADX INFO: compiled from: SearchBox */
    public final class a implements Loader.e, e.a {
        public final Uri b;
        public final rk5 c;
        public final l d;
        public final qs1 e;
        public final ml0 f;
        public volatile boolean h;
        public long j;

        @Nullable
        public c06 l;
        public boolean m;
        public final vk4 g = new vk4();
        public boolean i = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5975a = m43.a();
        public com.google.android.exoplayer2.upstream.b k = g(0);

        public a(Uri uri, com.google.android.exoplayer2.upstream.a aVar, l lVar, qs1 qs1Var, ml0 ml0Var) {
            this.b = uri;
            this.c = new rk5(aVar);
            this.d = lVar;
            this.e = qs1Var;
            this.f = ml0Var;
        }

        @Override // com.google.android.exoplayer2.source.e.a
        public void a(gc4 gc4Var) {
            long jMax = !this.m ? this.j : Math.max(m.this.A(true), this.j);
            int iA = gc4Var.a();
            c06 c06Var = (c06) vh.e(this.l);
            c06Var.d(gc4Var, iA);
            c06Var.e(jMax, 1, iA, 0, null);
            this.m = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void cancelLoad() {
            this.h = true;
        }

        public final com.google.android.exoplayer2.upstream.b g(long j) {
            return new b.C0361b().i(this.b).h(j).f(m.this.i).b(6).e(m.N).a();
        }

        public final void h(long j, long j2) {
            this.g.f21468a = j;
            this.j = j2;
            this.i = true;
            this.m = false;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void load() throws IOException {
            int iB = 0;
            while (iB == 0 && !this.h) {
                try {
                    long j = this.g.f21468a;
                    com.google.android.exoplayer2.upstream.b bVarG = g(j);
                    this.k = bVarG;
                    long jA = this.c.a(bVarG);
                    if (jA != -1) {
                        jA += j;
                        m.this.M();
                    }
                    long j2 = jA;
                    m.this.r = IcyHeaders.parse(this.c.getResponseHeaders());
                    ru0 eVar = this.c;
                    if (m.this.r != null && m.this.r.metadataInterval != -1) {
                        eVar = new com.google.android.exoplayer2.source.e(this.c, m.this.r.metadataInterval, this);
                        c06 c06VarB = m.this.B();
                        this.l = c06VarB;
                        c06VarB.b(m.O);
                    }
                    long currentInputPosition = j;
                    this.d.a(eVar, this.b, this.c.getResponseHeaders(), j, j2, this.e);
                    if (m.this.r != null) {
                        this.d.disableSeekingOnMp3Streams();
                    }
                    if (this.i) {
                        this.d.seek(currentInputPosition, this.j);
                        this.i = false;
                    }
                    while (true) {
                        long j3 = currentInputPosition;
                        while (iB == 0 && !this.h) {
                            try {
                                this.f.a();
                                iB = this.d.b(this.g);
                                currentInputPosition = this.d.getCurrentInputPosition();
                                if (currentInputPosition > m.this.j + j3) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f.c();
                        m.this.p.post(m.this.o);
                    }
                    if (iB == 1) {
                        iB = 0;
                    } else if (this.d.getCurrentInputPosition() != -1) {
                        this.g.f21468a = this.d.getCurrentInputPosition();
                    }
                    cv0.a(this.c);
                } catch (Throwable th) {
                    if (iB != 1 && this.d.getCurrentInputPosition() != -1) {
                        this.g.f21468a = this.d.getCurrentInputPosition();
                    }
                    cv0.a(this.c);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onSourceInfoRefreshed(long j, boolean z, boolean z2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements d25 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5976a;

        public c(int i) {
            this.f5976a = i;
        }

        @Override // defpackage.d25
        public int c(f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i) {
            return m.this.R(this.f5976a, f12Var, decoderInputBuffer, i);
        }

        @Override // defpackage.d25
        public boolean isReady() {
            return m.this.D(this.f5976a);
        }

        @Override // defpackage.d25
        public void maybeThrowError() throws IOException {
            m.this.L(this.f5976a);
        }

        @Override // defpackage.d25
        public int skipData(long j) {
            return m.this.V(this.f5976a, j);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5977a;
        public final boolean b;

        public d(int i, boolean z) {
            this.f5977a = i;
            this.b = z;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f5977a == dVar.f5977a && this.b == dVar.b;
        }

        public int hashCode() {
            return (this.f5977a * 31) + (this.b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final vz5 f5978a;
        public final boolean[] b;
        public final boolean[] c;
        public final boolean[] d;

        public e(vz5 vz5Var, boolean[] zArr) {
            this.f5978a = vz5Var;
            this.b = zArr;
            int i = vz5Var.f21565a;
            this.c = new boolean[i];
            this.d = new boolean[i];
        }
    }

    public m(Uri uri, com.google.android.exoplayer2.upstream.a aVar, l lVar, com.google.android.exoplayer2.drm.c cVar, b.a aVar2, com.google.android.exoplayer2.upstream.f fVar, j.a aVar3, b bVar, w9 w9Var, @Nullable String str, int i) {
        this.f5974a = uri;
        this.b = aVar;
        this.c = cVar;
        this.f = aVar2;
        this.d = fVar;
        this.e = aVar3;
        this.g = bVar;
        this.h = w9Var;
        this.i = str;
        this.j = i;
        this.l = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        if (this.M) {
            return;
        }
        ((h.a) vh.e(this.q)).c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        this.G = true;
    }

    public static Map<String, String> y() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(map);
    }

    public final long A(boolean z) {
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < this.s.length; i++) {
            if (z || ((e) vh.e(this.x)).c[i]) {
                jMax = Math.max(jMax, this.s[i].z());
            }
        }
        return jMax;
    }

    public c06 B() {
        return Q(new d(0, true));
    }

    public final boolean C() {
        return this.I != -9223372036854775807L;
    }

    public boolean D(int i) {
        return !X() && this.s[i].K(this.L);
    }

    public final void H() {
        if (this.M || this.v || !this.u || this.y == null) {
            return;
        }
        for (p pVar : this.s) {
            if (pVar.F() == null) {
                return;
            }
        }
        this.m.c();
        int length = this.s.length;
        qz5[] qz5VarArr = new qz5[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            com.google.android.exoplayer2.m mVarG = (com.google.android.exoplayer2.m) vh.e(this.s[i].F());
            String str = mVarG.l;
            boolean zO = fp3.o(str);
            boolean z = zO || fp3.s(str);
            zArr[i] = z;
            this.w = z | this.w;
            IcyHeaders icyHeaders = this.r;
            if (icyHeaders != null) {
                if (zO || this.t[i].b) {
                    Metadata metadata = mVarG.j;
                    mVarG = mVarG.b().Z(metadata == null ? new Metadata(icyHeaders) : metadata.copyWithAppendedEntries(icyHeaders)).G();
                }
                if (zO && mVarG.f == -1 && mVarG.g == -1 && icyHeaders.bitrate != -1) {
                    mVarG = mVarG.b().I(icyHeaders.bitrate).G();
                }
            }
            qz5VarArr[i] = new qz5(Integer.toString(i), mVarG.c(this.c.d(mVarG)));
        }
        this.x = new e(new vz5(qz5VarArr), zArr);
        this.v = true;
        ((h.a) vh.e(this.q)).f(this);
    }

    public final void I(int i) {
        w();
        e eVar = this.x;
        boolean[] zArr = eVar.d;
        if (zArr[i]) {
            return;
        }
        com.google.android.exoplayer2.m mVarC = eVar.f5978a.b(i).c(0);
        this.e.h(fp3.k(mVarC.l), mVarC, 0, null, this.H);
        zArr[i] = true;
    }

    public final void J(int i) {
        w();
        boolean[] zArr = this.x.b;
        if (this.J && zArr[i]) {
            if (this.s[i].K(false)) {
                return;
            }
            this.I = 0L;
            this.J = false;
            this.E = true;
            this.H = 0L;
            this.K = 0;
            for (p pVar : this.s) {
                pVar.V();
            }
            ((h.a) vh.e(this.q)).c(this);
        }
    }

    public void K() throws IOException {
        this.k.j(this.d.getMinimumLoadableRetryCount(this.B));
    }

    public void L(int i) throws IOException {
        this.s[i].N();
        K();
    }

    public final void M() {
        this.p.post(new Runnable() { // from class: do4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17105a.F();
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void e(a aVar, long j, long j2, boolean z) {
        rk5 rk5Var = aVar.c;
        m43 m43Var = new m43(aVar.f5975a, aVar.k, rk5Var.d(), rk5Var.e(), j, j2, rk5Var.c());
        this.d.onLoadTaskConcluded(aVar.f5975a);
        this.e.q(m43Var, 1, -1, null, 0, null, aVar.j, this.z);
        if (z) {
            return;
        }
        for (p pVar : this.s) {
            pVar.V();
        }
        if (this.F > 0) {
            ((h.a) vh.e(this.q)).c(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void f(a aVar, long j, long j2) {
        v45 v45Var;
        if (this.z == -9223372036854775807L && (v45Var = this.y) != null) {
            boolean zIsSeekable = v45Var.isSeekable();
            long jA = A(true);
            long j3 = jA == Long.MIN_VALUE ? 0L : jA + 10000;
            this.z = j3;
            this.g.onSourceInfoRefreshed(j3, zIsSeekable, this.A);
        }
        rk5 rk5Var = aVar.c;
        m43 m43Var = new m43(aVar.f5975a, aVar.k, rk5Var.d(), rk5Var.e(), j, j2, rk5Var.c());
        this.d.onLoadTaskConcluded(aVar.f5975a);
        this.e.t(m43Var, 1, -1, null, 0, null, aVar.j, this.z);
        this.L = true;
        ((h.a) vh.e(this.q)).c(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public Loader.c j(a aVar, long j, long j2, IOException iOException, int i) {
        boolean z;
        a aVar2;
        Loader.c cVarG;
        rk5 rk5Var = aVar.c;
        m43 m43Var = new m43(aVar.f5975a, aVar.k, rk5Var.d(), rk5Var.e(), j, j2, rk5Var.c());
        long jA = this.d.a(new f.c(m43Var, new kh3(1, -1, null, 0, null, g86.m1(aVar.j), g86.m1(this.z)), iOException, i));
        if (jA == -9223372036854775807L) {
            cVarG = Loader.g;
        } else {
            int iZ = z();
            if (iZ > this.K) {
                aVar2 = aVar;
                z = true;
            } else {
                z = false;
                aVar2 = aVar;
            }
            cVarG = x(aVar2, iZ) ? Loader.g(z, jA) : Loader.f;
        }
        boolean z2 = !cVarG.c();
        this.e.v(m43Var, 1, -1, null, 0, null, aVar.j, this.z, iOException, z2);
        if (z2) {
            this.d.onLoadTaskConcluded(aVar.f5975a);
        }
        return cVarG;
    }

    public final c06 Q(d dVar) {
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            if (dVar.equals(this.t[i])) {
                return this.s[i];
            }
        }
        p pVarK = p.k(this.h, this.c, this.f);
        pVarK.d0(this);
        int i2 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.t, i2);
        dVarArr[length] = dVar;
        this.t = (d[]) g86.k(dVarArr);
        p[] pVarArr = (p[]) Arrays.copyOf(this.s, i2);
        pVarArr[length] = pVarK;
        this.s = (p[]) g86.k(pVarArr);
        return pVarK;
    }

    public int R(int i, f12 f12Var, DecoderInputBuffer decoderInputBuffer, int i2) {
        if (X()) {
            return -3;
        }
        I(i);
        int iS = this.s[i].S(f12Var, decoderInputBuffer, i2, this.L);
        if (iS == -3) {
            J(i);
        }
        return iS;
    }

    public void S() {
        if (this.v) {
            for (p pVar : this.s) {
                pVar.R();
            }
        }
        this.k.l(this);
        this.p.removeCallbacksAndMessages(null);
        this.q = null;
        this.M = true;
    }

    public final boolean T(boolean[] zArr, long j) {
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            if (!this.s[i].Z(j, false) && (zArr[i] || !this.w)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final void G(v45 v45Var) {
        this.y = this.r == null ? v45Var : new v45.b(-9223372036854775807L);
        this.z = v45Var.getDurationUs();
        boolean z = !this.G && v45Var.getDurationUs() == -9223372036854775807L;
        this.A = z;
        this.B = z ? 7 : 1;
        this.g.onSourceInfoRefreshed(this.z, v45Var.isSeekable(), this.A);
        if (this.v) {
            return;
        }
        H();
    }

    public int V(int i, long j) {
        if (X()) {
            return 0;
        }
        I(i);
        p pVar = this.s[i];
        int iE = pVar.E(j, this.L);
        pVar.e0(iE);
        if (iE == 0) {
            J(i);
        }
        return iE;
    }

    public final void W() {
        a aVar = new a(this.f5974a, this.b, this.l, this, this.m);
        if (this.v) {
            vh.g(C());
            long j = this.z;
            if (j != -9223372036854775807L && this.I > j) {
                this.L = true;
                this.I = -9223372036854775807L;
                return;
            }
            aVar.h(((v45) vh.e(this.y)).getSeekPoints(this.I).f21356a.b, this.I);
            for (p pVar : this.s) {
                pVar.b0(this.I);
            }
            this.I = -9223372036854775807L;
        }
        this.K = z();
        this.e.z(new m43(aVar.f5975a, aVar.k, this.k.m(aVar, this, this.d.getMinimumLoadableRetryCount(this.B))), 1, -1, null, 0, null, aVar.j, this.z);
    }

    public final boolean X() {
        return this.E || C();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j, w45 w45Var) {
        w();
        if (!this.y.isSeekable()) {
            return 0L;
        }
        v45.a seekPoints = this.y.getSeekPoints(j);
        return w45Var.a(j, seekPoints.f21356a.f21874a, seekPoints.b.f21874a);
    }

    @Override // com.google.android.exoplayer2.source.h
    public long b(or1[] or1VarArr, boolean[] zArr, d25[] d25VarArr, boolean[] zArr2, long j) {
        or1 or1Var;
        w();
        e eVar = this.x;
        vz5 vz5Var = eVar.f5978a;
        boolean[] zArr3 = eVar.c;
        int i = this.F;
        int i2 = 0;
        for (int i3 = 0; i3 < or1VarArr.length; i3++) {
            d25 d25Var = d25VarArr[i3];
            if (d25Var != null && (or1VarArr[i3] == null || !zArr[i3])) {
                int i4 = ((c) d25Var).f5976a;
                vh.g(zArr3[i4]);
                this.F--;
                zArr3[i4] = false;
                d25VarArr[i3] = null;
            }
        }
        boolean z = !this.C ? j == 0 : i != 0;
        for (int i5 = 0; i5 < or1VarArr.length; i5++) {
            if (d25VarArr[i5] == null && (or1Var = or1VarArr[i5]) != null) {
                vh.g(or1Var.length() == 1);
                vh.g(or1Var.getIndexInTrackGroup(0) == 0);
                int iC = vz5Var.c(or1Var.getTrackGroup());
                vh.g(!zArr3[iC]);
                this.F++;
                zArr3[iC] = true;
                d25VarArr[i5] = new c(iC);
                zArr2[i5] = true;
                if (!z) {
                    p pVar = this.s[iC];
                    z = (pVar.Z(j, true) || pVar.C() == 0) ? false : true;
                }
            }
        }
        if (this.F == 0) {
            this.J = false;
            this.E = false;
            if (this.k.i()) {
                p[] pVarArr = this.s;
                int length = pVarArr.length;
                while (i2 < length) {
                    pVarArr[i2].r();
                    i2++;
                }
                this.k.e();
            } else {
                p[] pVarArr2 = this.s;
                int length2 = pVarArr2.length;
                while (i2 < length2) {
                    pVarArr2[i2].V();
                    i2++;
                }
            }
        } else if (z) {
            j = seekToUs(j);
            while (i2 < d25VarArr.length) {
                if (d25VarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.C = true;
        return j;
    }

    @Override // com.google.android.exoplayer2.source.p.d
    public void c(com.google.android.exoplayer2.m mVar) {
        this.p.post(this.n);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        if (this.L || this.k.h() || this.J) {
            return false;
        }
        if (this.v && this.F == 0) {
            return false;
        }
        boolean zE = this.m.e();
        if (this.k.i()) {
            return zE;
        }
        W();
        return true;
    }

    @Override // defpackage.qs1
    public void d(final v45 v45Var) {
        this.p.post(new Runnable() { // from class: eo4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17323a.G(v45Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j, boolean z) {
        w();
        if (C()) {
            return;
        }
        boolean[] zArr = this.x.c;
        int length = this.s.length;
        for (int i = 0; i < length; i++) {
            this.s[i].q(j, z, zArr[i]);
        }
    }

    @Override // defpackage.qs1
    public void endTracks() {
        this.u = true;
        this.p.post(this.n);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void g(h.a aVar, long j) {
        this.q = aVar;
        this.m.e();
        W();
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        long jA;
        w();
        if (this.L || this.F == 0) {
            return Long.MIN_VALUE;
        }
        if (C()) {
            return this.I;
        }
        if (this.w) {
            int length = this.s.length;
            jA = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                e eVar = this.x;
                if (eVar.b[i] && eVar.c[i] && !this.s[i].J()) {
                    jA = Math.min(jA, this.s[i].z());
                }
            }
        } else {
            jA = Long.MAX_VALUE;
        }
        if (jA == Long.MAX_VALUE) {
            jA = A(false);
        }
        return jA == Long.MIN_VALUE ? this.H : jA;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public vz5 getTrackGroups() {
        w();
        return this.x.f5978a;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.k.i() && this.m.d();
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        K();
        if (this.L && !this.v) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.f
    public void onLoaderReleased() {
        for (p pVar : this.s) {
            pVar.T();
        }
        this.l.release();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        if (!this.E) {
            return -9223372036854775807L;
        }
        if (!this.L && z() <= this.K) {
            return -9223372036854775807L;
        }
        this.E = false;
        return this.H;
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j) {
        w();
        boolean[] zArr = this.x.b;
        if (!this.y.isSeekable()) {
            j = 0;
        }
        int i = 0;
        this.E = false;
        this.H = j;
        if (C()) {
            this.I = j;
            return j;
        }
        if (this.B != 7 && T(zArr, j)) {
            return j;
        }
        this.J = false;
        this.I = j;
        this.L = false;
        if (this.k.i()) {
            p[] pVarArr = this.s;
            int length = pVarArr.length;
            while (i < length) {
                pVarArr[i].r();
                i++;
            }
            this.k.e();
        } else {
            this.k.f();
            p[] pVarArr2 = this.s;
            int length2 = pVarArr2.length;
            while (i < length2) {
                pVarArr2[i].V();
                i++;
            }
        }
        return j;
    }

    @Override // defpackage.qs1
    public c06 track(int i, int i2) {
        return Q(new d(i, false));
    }

    public final void w() {
        vh.g(this.v);
        vh.e(this.x);
        vh.e(this.y);
    }

    public final boolean x(a aVar, int i) {
        v45 v45Var;
        if (this.G || !((v45Var = this.y) == null || v45Var.getDurationUs() == -9223372036854775807L)) {
            this.K = i;
            return true;
        }
        if (this.v && !X()) {
            this.J = true;
            return false;
        }
        this.E = this.v;
        this.H = 0L;
        this.K = 0;
        for (p pVar : this.s) {
            pVar.V();
        }
        aVar.h(0L, 0L);
        return true;
    }

    public final int z() {
        int iG = 0;
        for (p pVar : this.s) {
            iG += pVar.G();
        }
        return iG;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j) {
    }
}
