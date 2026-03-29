package com.google.android.exoplayer2.source.hls;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.c;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.e;
import com.google.android.exoplayer2.upstream.f;
import defpackage.ai2;
import defpackage.c41;
import defpackage.di2;
import defpackage.fi2;
import defpackage.g86;
import defpackage.gk0;
import defpackage.hi1;
import defpackage.jr1;
import defpackage.nv1;
import defpackage.od0;
import defpackage.s51;
import defpackage.u06;
import defpackage.u51;
import defpackage.vh;
import defpackage.w9;
import defpackage.xd5;
import defpackage.yh2;
import defpackage.zh2;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class HlsMediaSource extends com.google.android.exoplayer2.source.a implements HlsPlaylistTracker.c {
    public final zh2 h;
    public final p.h i;
    public final yh2 j;
    public final gk0 k;
    public final c l;
    public final f m;
    public final boolean n;
    public final int o;
    public final boolean p;
    public final HlsPlaylistTracker q;
    public final long r;
    public final p s;
    public final long t;
    public p.g u;

    @Nullable
    public u06 v;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yh2 f5957a;
        public zh2 b;
        public fi2 c;
        public HlsPlaylistTracker.a d;
        public gk0 e;

        @Nullable
        public od0.a f;
        public hi1 g;
        public f h;
        public boolean i;
        public int j;
        public boolean k;
        public long l;
        public long m;

        public Factory(a.InterfaceC0360a interfaceC0360a) {
            this(new s51(interfaceC0360a));
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public HlsMediaSource c(p pVar) {
            vh.e(pVar.b);
            fi2 fi2Var = this.c;
            List<StreamKey> list = pVar.b.e;
            fi2 nv1Var = !list.isEmpty() ? new nv1(fi2Var, list) : fi2Var;
            od0.a aVar = this.f;
            if (aVar != null) {
                aVar.a(pVar);
            }
            yh2 yh2Var = this.f5957a;
            zh2 zh2Var = this.b;
            gk0 gk0Var = this.e;
            c cVarA = this.g.a(pVar);
            f fVar = this.h;
            return new HlsMediaSource(pVar, yh2Var, zh2Var, gk0Var, null, cVarA, fVar, this.d.a(this.f5957a, fVar, nv1Var), this.l, this.i, this.j, this.k, this.m);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Factory a(od0.a aVar) {
            this.f = (od0.a) vh.e(aVar);
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Factory d(hi1 hi1Var) {
            this.g = (hi1) vh.f(hi1Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Factory b(f fVar) {
            this.h = (f) vh.f(fVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public Factory(yh2 yh2Var) {
            this.f5957a = (yh2) vh.e(yh2Var);
            this.g = new com.google.android.exoplayer2.drm.a();
            this.c = new u51();
            this.d = com.google.android.exoplayer2.source.hls.playlist.a.p;
            this.b = zh2.f22419a;
            this.h = new e();
            this.e = new c41();
            this.j = 1;
            this.l = -9223372036854775807L;
            this.i = true;
        }
    }

    static {
        jr1.a("goog.exo.hls");
    }

    public static long C(b bVar, long j) {
        long j2;
        b.f fVar = bVar.v;
        long j3 = bVar.e;
        if (j3 != -9223372036854775807L) {
            j2 = bVar.u - j3;
        } else {
            long j4 = fVar.d;
            if (j4 == -9223372036854775807L || bVar.n == -9223372036854775807L) {
                long j5 = fVar.c;
                j2 = j5 != -9223372036854775807L ? j5 : bVar.m * 3;
            } else {
                j2 = j4;
            }
        }
        return j2 + j;
    }

    @Nullable
    public static b.C0357b y(List<b.C0357b> list, long j) {
        b.C0357b c0357b = null;
        for (int i = 0; i < list.size(); i++) {
            b.C0357b c0357b2 = list.get(i);
            long j2 = c0357b2.e;
            if (j2 > j || !c0357b2.l) {
                if (j2 > j) {
                    break;
                }
            } else {
                c0357b = c0357b2;
            }
        }
        return c0357b;
    }

    public static b.d z(List<b.d> list, long j) {
        return list.get(g86.g(list, Long.valueOf(j), true, true));
    }

    public final long A(b bVar) {
        if (bVar.p) {
            return g86.H0(g86.c0(this.r)) - bVar.d();
        }
        return 0L;
    }

    public final long B(b bVar, long j) {
        long jH0 = bVar.e;
        if (jH0 == -9223372036854775807L) {
            jH0 = (bVar.u + j) - g86.H0(this.u.f5918a);
        }
        if (bVar.g) {
            return jH0;
        }
        b.C0357b c0357bY = y(bVar.s, jH0);
        if (c0357bY != null) {
            return c0357bY.e;
        }
        if (bVar.r.isEmpty()) {
            return 0L;
        }
        b.d dVarZ = z(bVar.r, jH0);
        b.C0357b c0357bY2 = y(dVarZ.m, jH0);
        return c0357bY2 != null ? c0357bY2.e : dVarZ.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D(b bVar, long j) {
        boolean z;
        p.g gVar = this.s.d;
        if (gVar.d == -3.4028235E38f && gVar.e == -3.4028235E38f) {
            b.f fVar = bVar.v;
            if (fVar.c == -9223372036854775807L && fVar.d == -9223372036854775807L) {
                z = true;
            }
        } else {
            z = false;
        }
        this.u = new p.g.a().k(g86.m1(j)).j(z ? 1.0f : this.u.d).h(z ? 1.0f : this.u.e).f();
    }

    @Override // com.google.android.exoplayer2.source.i
    public h c(i.b bVar, w9 w9Var, long j) {
        j.a aVarO = o(bVar);
        return new di2(this.h, this.q, this.j, this.v, null, this.l, m(bVar), this.m, aVarO, w9Var, this.k, this.n, this.o, this.p, r(), this.t);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.c
    public void d(b bVar) {
        long jM1 = bVar.p ? g86.m1(bVar.h) : -9223372036854775807L;
        int i = bVar.d;
        long j = (i == 2 || i == 1) ? jM1 : -9223372036854775807L;
        ai2 ai2Var = new ai2((com.google.android.exoplayer2.source.hls.playlist.c) vh.e(this.q.g()), bVar);
        u(this.q.l() ? w(bVar, j, jM1, ai2Var) : x(bVar, j, jM1, ai2Var));
    }

    @Override // com.google.android.exoplayer2.source.i
    public void f(h hVar) {
        ((di2) hVar).r();
    }

    @Override // com.google.android.exoplayer2.source.i
    public p getMediaItem() {
        return this.s;
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() throws IOException {
        this.q.n();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void t(@Nullable u06 u06Var) {
        this.v = u06Var;
        this.l.a((Looper) vh.e(Looper.myLooper()), r());
        this.l.prepare();
        this.q.c(this.i.f5920a, o(null), this);
    }

    @Override // com.google.android.exoplayer2.source.a
    public void v() {
        this.q.stop();
        this.l.release();
    }

    public final xd5 w(b bVar, long j, long j2, ai2 ai2Var) {
        long jB = bVar.h - this.q.b();
        long j3 = bVar.o ? jB + bVar.u : -9223372036854775807L;
        long jA = A(bVar);
        long j4 = this.u.f5918a;
        D(bVar, g86.r(j4 != -9223372036854775807L ? g86.H0(j4) : C(bVar, jA), jA, bVar.u + jA));
        return new xd5(j, j2, -9223372036854775807L, j3, bVar.u, jB, B(bVar, jA), true, !bVar.o, bVar.d == 2 && bVar.f, ai2Var, this.s, this.u);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final xd5 x(b bVar, long j, long j2, ai2 ai2Var) {
        long j3;
        if (bVar.e == -9223372036854775807L || bVar.r.isEmpty()) {
            j3 = 0;
        } else if (!bVar.g) {
            long j4 = bVar.e;
            j3 = j4 == bVar.u ? bVar.e : z(bVar.r, j4).e;
        }
        long j5 = bVar.u;
        return new xd5(j, j2, -9223372036854775807L, j5, j5, 0L, j3, true, false, true, ai2Var, this.s, null);
    }

    public HlsMediaSource(p pVar, yh2 yh2Var, zh2 zh2Var, gk0 gk0Var, @Nullable od0 od0Var, c cVar, f fVar, HlsPlaylistTracker hlsPlaylistTracker, long j, boolean z, int i, boolean z2, long j2) {
        this.i = (p.h) vh.e(pVar.b);
        this.s = pVar;
        this.u = pVar.d;
        this.j = yh2Var;
        this.h = zh2Var;
        this.k = gk0Var;
        this.l = cVar;
        this.m = fVar;
        this.q = hlsPlaylistTracker;
        this.r = j;
        this.n = z;
        this.o = i;
        this.p = z2;
        this.t = j2;
    }
}
