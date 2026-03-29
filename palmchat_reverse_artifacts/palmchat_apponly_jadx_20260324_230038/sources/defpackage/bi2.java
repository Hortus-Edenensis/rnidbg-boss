package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import defpackage.xh2;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class bi2 extends te3 {
    public static final AtomicInteger N = new AtomicInteger();
    public final boolean A;
    public final boolean B;
    public final bk4 C;
    public final long D;
    public ci2 E;
    public ki2 F;
    public int G;
    public boolean H;
    public volatile boolean I;
    public boolean J;
    public ImmutableList<Integer> K;
    public boolean L;
    public boolean M;
    public final int k;
    public final int l;
    public final Uri m;
    public final boolean n;
    public final int o;

    @Nullable
    public final a p;

    @Nullable
    public final b q;

    @Nullable
    public final ci2 r;
    public final boolean s;
    public final boolean t;
    public final jy5 u;
    public final zh2 v;

    @Nullable
    public final List<m> w;

    @Nullable
    public final DrmInitData x;
    public final dq2 y;
    public final gc4 z;

    public bi2(zh2 zh2Var, a aVar, b bVar, m mVar, boolean z, @Nullable a aVar2, @Nullable b bVar2, boolean z2, Uri uri, @Nullable List<m> list, int i, @Nullable Object obj, long j, long j2, long j3, int i2, boolean z3, int i3, boolean z4, boolean z5, jy5 jy5Var, long j4, @Nullable DrmInitData drmInitData, @Nullable ci2 ci2Var, dq2 dq2Var, gc4 gc4Var, boolean z6, bk4 bk4Var) {
        super(aVar, bVar, mVar, i, obj, j, j2, j3);
        this.A = z;
        this.o = i2;
        this.M = z3;
        this.l = i3;
        this.q = bVar2;
        this.p = aVar2;
        this.H = bVar2 != null;
        this.B = z2;
        this.m = uri;
        this.s = z5;
        this.u = jy5Var;
        this.D = j4;
        this.t = z4;
        this.v = zh2Var;
        this.w = list;
        this.x = drmInitData;
        this.r = ci2Var;
        this.y = dq2Var;
        this.z = gc4Var;
        this.n = z6;
        this.C = bk4Var;
        this.K = ImmutableList.of();
        this.k = N.getAndIncrement();
    }

    public static a g(a aVar, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return aVar;
        }
        vh.e(bArr2);
        return new f8(aVar, bArr, bArr2);
    }

    public static bi2 h(zh2 zh2Var, a aVar, m mVar, long j, com.google.android.exoplayer2.source.hls.playlist.b bVar, xh2.e eVar, Uri uri, @Nullable List<m> list, int i, @Nullable Object obj, boolean z, ky5 ky5Var, long j2, @Nullable bi2 bi2Var, @Nullable byte[] bArr, @Nullable byte[] bArr2, boolean z2, bk4 bk4Var, @Nullable qd0 qd0Var) {
        b bVarA;
        a aVarG;
        boolean z3;
        dq2 dq2Var;
        gc4 gc4Var;
        ci2 ci2Var;
        b.e eVar2 = eVar.f21962a;
        com.google.android.exoplayer2.upstream.b bVarA2 = new b.C0361b().i(v56.e(bVar.f17306a, eVar2.f5964a)).h(eVar2.i).g(eVar2.j).b(eVar.d ? 8 : 0).e(qd0Var == null ? ImmutableMap.of() : qd0Var.c(eVar2.c).a()).a();
        boolean z4 = bArr != null;
        a aVarG2 = g(aVar, bArr, z4 ? j((String) vh.e(eVar2.h)) : null);
        b.d dVar = eVar2.b;
        if (dVar != null) {
            boolean z5 = bArr2 != null;
            byte[] bArrJ = z5 ? j((String) vh.e(dVar.h)) : null;
            bVarA = new b.C0361b().i(v56.e(bVar.f17306a, dVar.f5964a)).h(dVar.i).g(dVar.j).e(qd0Var == null ? ImmutableMap.of() : qd0Var.d("i").a()).a();
            aVarG = g(aVar, bArr2, bArrJ);
            z3 = z5;
        } else {
            bVarA = null;
            aVarG = null;
            z3 = false;
        }
        long j3 = j + eVar2.e;
        long j4 = j3 + eVar2.c;
        int i2 = bVar.j + eVar2.d;
        if (bi2Var != null) {
            com.google.android.exoplayer2.upstream.b bVar2 = bi2Var.q;
            boolean z6 = bVarA == bVar2 || (bVarA != null && bVar2 != null && bVarA.f6011a.equals(bVar2.f6011a) && bVarA.g == bi2Var.q.g);
            boolean z7 = uri.equals(bi2Var.m) && bi2Var.J;
            dq2Var = bi2Var.y;
            gc4Var = bi2Var.z;
            ci2Var = (z6 && z7 && !bi2Var.L && bi2Var.l == i2) ? bi2Var.E : null;
        } else {
            dq2Var = new dq2();
            gc4Var = new gc4(10);
            ci2Var = null;
        }
        return new bi2(zh2Var, aVarG2, bVarA2, mVar, z4, aVarG, bVarA, z3, uri, list, i, obj, j3, j4, eVar.b, eVar.c, !eVar.d, i2, eVar2.k, z, ky5Var.a(i2), j2, eVar2.f, ci2Var, dq2Var, gc4Var, z2, bk4Var);
    }

    public static byte[] j(String str) {
        if (th.e(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    public static boolean n(xh2.e eVar, com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        b.e eVar2 = eVar.f21962a;
        return eVar2 instanceof b.C0357b ? ((b.C0357b) eVar2).l || (eVar.c == 0 && bVar.c) : bVar.c;
    }

    public static boolean u(@Nullable bi2 bi2Var, Uri uri, com.google.android.exoplayer2.source.hls.playlist.b bVar, xh2.e eVar, long j) {
        if (bi2Var == null) {
            return false;
        }
        if (uri.equals(bi2Var.m) && bi2Var.J) {
            return false;
        }
        return !n(eVar, bVar) || j + eVar.f21962a.e < bi2Var.h;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void cancelLoad() {
        this.I = true;
    }

    @Override // defpackage.te3
    public boolean f() {
        return this.J;
    }

    public final void i(a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z, boolean z2) throws IOException {
        com.google.android.exoplayer2.upstream.b bVarE;
        long position;
        long j;
        if (z) {
            z = this.G != 0;
            bVarE = bVar;
        } else {
            bVarE = bVar.e(this.G);
        }
        try {
            e51 e51VarS = s(aVar, bVarE, z2);
            if (z) {
                e51VarS.skipFully(this.G);
            }
            while (!this.I && this.E.a(e51VarS)) {
                try {
                    try {
                    } catch (EOFException e) {
                        if ((this.d.e & 16384) == 0) {
                            throw e;
                        }
                        this.E.c();
                        position = e51VarS.getPosition();
                        j = bVar.g;
                    }
                } catch (Throwable th) {
                    this.G = (int) (e51VarS.getPosition() - bVar.g);
                    throw th;
                }
            }
            position = e51VarS.getPosition();
            j = bVar.g;
            this.G = (int) (position - j);
        } finally {
            cv0.a(aVar);
        }
    }

    public int k(int i) {
        vh.g(!this.n);
        if (i >= this.K.size()) {
            return 0;
        }
        return this.K.get(i).intValue();
    }

    public void l(ki2 ki2Var, ImmutableList<Integer> immutableList) {
        this.F = ki2Var;
        this.K = immutableList;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void load() throws IOException {
        ci2 ci2Var;
        vh.e(this.F);
        if (this.E == null && (ci2Var = this.r) != null && ci2Var.d()) {
            this.E = this.r;
            this.H = false;
        }
        q();
        if (this.I) {
            return;
        }
        if (!this.t) {
            p();
        }
        this.J = !this.I;
    }

    public void m() {
        this.L = true;
    }

    public boolean o() {
        return this.M;
    }

    public final void p() throws IOException {
        i(this.i, this.b, this.A, true);
    }

    public final void q() throws IOException {
        if (this.H) {
            vh.e(this.p);
            vh.e(this.q);
            i(this.p, this.q, this.B, false);
            this.G = 0;
            this.H = false;
        }
    }

    public final long r(ps1 ps1Var) throws IOException {
        ps1Var.resetPeekPosition();
        try {
            this.z.Q(10);
            ps1Var.peekFully(this.z.e(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.z.K() != 4801587) {
            return -9223372036854775807L;
        }
        this.z.V(3);
        int iG = this.z.G();
        int i = iG + 10;
        if (i > this.z.b()) {
            byte[] bArrE = this.z.e();
            this.z.Q(i);
            System.arraycopy(bArrE, 0, this.z.e(), 0, 10);
        }
        ps1Var.peekFully(this.z.e(), 10, iG);
        Metadata metadataE = this.y.e(this.z.e(), iG);
        if (metadataE == null) {
            return -9223372036854775807L;
        }
        int length = metadataE.length();
        for (int i2 = 0; i2 < length; i2++) {
            Metadata.Entry entry = metadataE.get(i2);
            if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                    System.arraycopy(privFrame.privateData, 0, this.z.e(), 0, 8);
                    this.z.U(0);
                    this.z.T(8);
                    return this.z.A() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    public final e51 s(a aVar, com.google.android.exoplayer2.upstream.b bVar, boolean z) throws IOException {
        long jA = aVar.a(bVar);
        if (z) {
            try {
                this.u.i(this.s, this.g, this.D);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            } catch (TimeoutException e) {
                throw new IOException(e);
            }
        }
        e51 e51Var = new e51(aVar, bVar.g, jA);
        if (this.E == null) {
            long jR = r(e51Var);
            e51Var.resetPeekPosition();
            ci2 ci2Var = this.r;
            ci2 ci2VarRecreate = ci2Var != null ? ci2Var.recreate() : this.v.a(bVar.f6011a, this.d, this.w, this.u, aVar.getResponseHeaders(), e51Var, this.C);
            this.E = ci2VarRecreate;
            if (ci2VarRecreate.e()) {
                this.F.a0(jR != -9223372036854775807L ? this.u.b(jR) : this.g);
            } else {
                this.F.a0(0L);
            }
            this.F.M();
            this.E.b(this.F);
        }
        this.F.X(this.x);
        return e51Var;
    }

    public void t() {
        this.M = true;
    }
}
