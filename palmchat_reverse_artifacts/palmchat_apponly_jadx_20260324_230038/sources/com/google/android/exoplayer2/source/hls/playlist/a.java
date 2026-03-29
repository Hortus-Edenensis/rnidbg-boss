package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.a;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.g;
import defpackage.bv2;
import defpackage.ei2;
import defpackage.fi2;
import defpackage.g86;
import defpackage.kh3;
import defpackage.m43;
import defpackage.vh;
import defpackage.yh2;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class a implements HlsPlaylistTracker, Loader.b<g<ei2>> {
    public static final HlsPlaylistTracker.a p = new HlsPlaylistTracker.a() { // from class: v51
        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.a
        public final HlsPlaylistTracker a(yh2 yh2Var, f fVar, fi2 fi2Var) {
            return new a(yh2Var, fVar, fi2Var);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yh2 f5960a;
    public final fi2 b;
    public final f c;
    public final HashMap<Uri, c> d;
    public final CopyOnWriteArrayList<HlsPlaylistTracker.b> e;
    public final double f;

    @Nullable
    public j.a g;

    @Nullable
    public Loader h;

    @Nullable
    public Handler i;

    @Nullable
    public HlsPlaylistTracker.c j;

    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.c k;

    @Nullable
    public Uri l;

    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.b m;
    public boolean n;
    public long o;

    /* JADX INFO: compiled from: SearchBox */
    public class b implements HlsPlaylistTracker.b {
        public b() {
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public void c() {
            a.this.e.remove(this);
        }

        @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b
        public boolean d(Uri uri, f.c cVar, boolean z) {
            c cVar2;
            if (a.this.m == null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                List<c.b> list = ((com.google.android.exoplayer2.source.hls.playlist.c) g86.j(a.this.k)).e;
                int i = 0;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    c cVar3 = (c) a.this.d.get(list.get(i2).f5967a);
                    if (cVar3 != null && jElapsedRealtime < cVar3.h) {
                        i++;
                    }
                }
                f.b bVarB = a.this.c.b(new f.a(1, 0, a.this.k.e.size(), i), cVar);
                if (bVarB != null && bVarB.f6025a == 2 && (cVar2 = (c) a.this.d.get(uri)) != null) {
                    cVar2.k(bVarB.b);
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class c implements Loader.b<g<ei2>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f5962a;
        public final Loader b = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        public final com.google.android.exoplayer2.upstream.a c;

        @Nullable
        public com.google.android.exoplayer2.source.hls.playlist.b d;
        public long e;
        public long f;
        public long g;
        public long h;
        public boolean i;

        @Nullable
        public IOException j;

        public c(Uri uri) {
            this.f5962a = uri;
            this.c = a.this.f5960a.a(4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Uri uri) {
            this.i = false;
            q(uri);
        }

        public final boolean k(long j) {
            this.h = SystemClock.elapsedRealtime() + j;
            return this.f5962a.equals(a.this.l) && !a.this.L();
        }

        public final Uri l() {
            com.google.android.exoplayer2.source.hls.playlist.b bVar = this.d;
            if (bVar != null) {
                b.f fVar = bVar.v;
                if (fVar.f5965a != -9223372036854775807L || fVar.e) {
                    Uri.Builder builderBuildUpon = this.f5962a.buildUpon();
                    com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.d;
                    if (bVar2.v.e) {
                        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(bVar2.k + ((long) bVar2.r.size())));
                        com.google.android.exoplayer2.source.hls.playlist.b bVar3 = this.d;
                        if (bVar3.n != -9223372036854775807L) {
                            List<b.C0357b> list = bVar3.s;
                            int size = list.size();
                            if (!list.isEmpty() && ((b.C0357b) bv2.g(list)).m) {
                                size--;
                            }
                            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                        }
                    }
                    b.f fVar2 = this.d.v;
                    if (fVar2.f5965a != -9223372036854775807L) {
                        builderBuildUpon.appendQueryParameter("_HLS_skip", fVar2.b ? "v2" : "YES");
                    }
                    return builderBuildUpon.build();
                }
            }
            return this.f5962a;
        }

        @Nullable
        public com.google.android.exoplayer2.source.hls.playlist.b m() {
            return this.d;
        }

        public boolean n() {
            int i;
            if (this.d == null) {
                return false;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jMax = Math.max(30000L, g86.m1(this.d.u));
            com.google.android.exoplayer2.source.hls.playlist.b bVar = this.d;
            return bVar.o || (i = bVar.d) == 2 || i == 1 || this.e + jMax > jElapsedRealtime;
        }

        public void p() {
            r(this.f5962a);
        }

        public final void q(Uri uri) {
            g gVar = new g(this.c, uri, 4, a.this.b.a(a.this.k, this.d));
            a.this.g.y(new m43(gVar.f6027a, gVar.b, this.b.m(gVar, this, a.this.c.getMinimumLoadableRetryCount(gVar.c))), gVar.c);
        }

        public final void r(final Uri uri) {
            this.h = 0L;
            if (this.i || this.b.i() || this.b.h()) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jElapsedRealtime >= this.g) {
                q(uri);
            } else {
                this.i = true;
                a.this.i.postDelayed(new Runnable() { // from class: w51
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21625a.o(uri);
                    }
                }, this.g - jElapsedRealtime);
            }
        }

        public void s() throws IOException {
            this.b.maybeThrowError();
            IOException iOException = this.j;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public void e(g<ei2> gVar, long j, long j2, boolean z) {
            m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
            a.this.c.onLoadTaskConcluded(gVar.f6027a);
            a.this.g.p(m43Var, 4);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void f(g<ei2> gVar, long j, long j2) {
            ei2 ei2VarC = gVar.c();
            m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
            if (ei2VarC instanceof com.google.android.exoplayer2.source.hls.playlist.b) {
                w((com.google.android.exoplayer2.source.hls.playlist.b) ei2VarC, m43Var);
                a.this.g.s(m43Var, 4);
            } else {
                this.j = ParserException.createForMalformedManifest("Loaded playlist has unexpected type.", null);
                a.this.g.w(m43Var, 4, this.j, true);
            }
            a.this.c.onLoadTaskConcluded(gVar.f6027a);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public Loader.c j(g<ei2> gVar, long j, long j2, IOException iOException, int i) {
            Loader.c cVarG;
            m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
            boolean z = iOException instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((gVar.d().getQueryParameter("_HLS_msn") != null) || z) {
                int i2 = iOException instanceof HttpDataSource$InvalidResponseCodeException ? ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode : Integer.MAX_VALUE;
                if (z || i2 == 400 || i2 == 503) {
                    this.g = SystemClock.elapsedRealtime();
                    p();
                    ((j.a) g86.j(a.this.g)).w(m43Var, gVar.c, iOException, true);
                    return Loader.f;
                }
            }
            f.c cVar = new f.c(m43Var, new kh3(gVar.c), iOException, i);
            if (a.this.N(this.f5962a, cVar, false)) {
                long jA = a.this.c.a(cVar);
                cVarG = jA != -9223372036854775807L ? Loader.g(false, jA) : Loader.g;
            } else {
                cVarG = Loader.f;
            }
            boolean zC = true ^ cVarG.c();
            a.this.g.w(m43Var, gVar.c, iOException, zC);
            if (zC) {
                a.this.c.onLoadTaskConcluded(gVar.f6027a);
            }
            return cVarG;
        }

        public final void w(com.google.android.exoplayer2.source.hls.playlist.b bVar, m43 m43Var) {
            IOException playlistStuckException;
            boolean z;
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = this.d;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.e = jElapsedRealtime;
            com.google.android.exoplayer2.source.hls.playlist.b bVarG = a.this.G(bVar2, bVar);
            this.d = bVarG;
            if (bVarG != bVar2) {
                this.j = null;
                this.f = jElapsedRealtime;
                a.this.R(this.f5962a, bVarG);
            } else if (!bVarG.o) {
                long size = bVar.k + ((long) bVar.r.size());
                com.google.android.exoplayer2.source.hls.playlist.b bVar3 = this.d;
                if (size < bVar3.k) {
                    playlistStuckException = new HlsPlaylistTracker.PlaylistResetException(this.f5962a);
                    z = true;
                } else {
                    playlistStuckException = ((double) (jElapsedRealtime - this.f)) > ((double) g86.m1(bVar3.m)) * a.this.f ? new HlsPlaylistTracker.PlaylistStuckException(this.f5962a) : null;
                    z = false;
                }
                if (playlistStuckException != null) {
                    this.j = playlistStuckException;
                    a.this.N(this.f5962a, new f.c(m43Var, new kh3(4), playlistStuckException, 1), z);
                }
            }
            com.google.android.exoplayer2.source.hls.playlist.b bVar4 = this.d;
            this.g = jElapsedRealtime + g86.m1(!bVar4.v.e ? bVar4 != bVar2 ? bVar4.m : bVar4.m / 2 : 0L);
            if (!(this.d.n != -9223372036854775807L || this.f5962a.equals(a.this.l)) || this.d.o) {
                return;
            }
            r(l());
        }

        public void x() {
            this.b.k();
        }
    }

    public a(yh2 yh2Var, f fVar, fi2 fi2Var) {
        this(yh2Var, fVar, fi2Var, 3.5d);
    }

    public static b.d F(com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        int i = (int) (bVar2.k - bVar.k);
        List<b.d> list = bVar.r;
        if (i < list.size()) {
            return list.get(i);
        }
        return null;
    }

    public final void E(List<Uri> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = list.get(i);
            this.d.put(uri, new c(uri));
        }
    }

    public final com.google.android.exoplayer2.source.hls.playlist.b G(@Nullable com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        return !bVar2.e(bVar) ? bVar2.o ? bVar.c() : bVar : bVar2.b(I(bVar, bVar2), H(bVar, bVar2));
    }

    public final int H(@Nullable com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        b.d dVarF;
        if (bVar2.i) {
            return bVar2.j;
        }
        com.google.android.exoplayer2.source.hls.playlist.b bVar3 = this.m;
        int i = bVar3 != null ? bVar3.j : 0;
        return (bVar == null || (dVarF = F(bVar, bVar2)) == null) ? i : (bVar.j + dVarF.d) - bVar2.r.get(0).d;
    }

    public final long I(@Nullable com.google.android.exoplayer2.source.hls.playlist.b bVar, com.google.android.exoplayer2.source.hls.playlist.b bVar2) {
        if (bVar2.p) {
            return bVar2.h;
        }
        com.google.android.exoplayer2.source.hls.playlist.b bVar3 = this.m;
        long j = bVar3 != null ? bVar3.h : 0L;
        if (bVar == null) {
            return j;
        }
        int size = bVar.r.size();
        b.d dVarF = F(bVar, bVar2);
        return dVarF != null ? bVar.h + dVarF.e : ((long) size) == bVar2.k - bVar.k ? bVar.d() : j;
    }

    public final Uri J(Uri uri) {
        b.c cVar;
        com.google.android.exoplayer2.source.hls.playlist.b bVar = this.m;
        if (bVar == null || !bVar.v.e || (cVar = bVar.t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter("_HLS_msn", String.valueOf(cVar.b));
        int i = cVar.c;
        if (i != -1) {
            builderBuildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
        }
        return builderBuildUpon.build();
    }

    public final boolean K(Uri uri) {
        List<c.b> list = this.k.e;
        for (int i = 0; i < list.size(); i++) {
            if (uri.equals(list.get(i).f5967a)) {
                return true;
            }
        }
        return false;
    }

    public final boolean L() {
        List<c.b> list = this.k.e;
        int size = list.size();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            c cVar = (c) vh.e(this.d.get(list.get(i).f5967a));
            if (jElapsedRealtime > cVar.h) {
                Uri uri = cVar.f5962a;
                this.l = uri;
                cVar.r(J(uri));
                return true;
            }
        }
        return false;
    }

    public final void M(Uri uri) {
        if (uri.equals(this.l) || !K(uri)) {
            return;
        }
        com.google.android.exoplayer2.source.hls.playlist.b bVar = this.m;
        if (bVar == null || !bVar.o) {
            this.l = uri;
            c cVar = this.d.get(uri);
            com.google.android.exoplayer2.source.hls.playlist.b bVar2 = cVar.d;
            if (bVar2 == null || !bVar2.o) {
                cVar.r(J(uri));
            } else {
                this.m = bVar2;
                this.j.d(bVar2);
            }
        }
    }

    public final boolean N(Uri uri, f.c cVar, boolean z) {
        Iterator<HlsPlaylistTracker.b> it = this.e.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= !it.next().d(uri, cVar, z);
        }
        return z2;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void e(g<ei2> gVar, long j, long j2, boolean z) {
        m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
        this.c.onLoadTaskConcluded(gVar.f6027a);
        this.g.p(m43Var, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void f(g<ei2> gVar, long j, long j2) {
        ei2 ei2VarC = gVar.c();
        boolean z = ei2VarC instanceof com.google.android.exoplayer2.source.hls.playlist.b;
        com.google.android.exoplayer2.source.hls.playlist.c cVarD = z ? com.google.android.exoplayer2.source.hls.playlist.c.d(ei2VarC.f17306a) : (com.google.android.exoplayer2.source.hls.playlist.c) ei2VarC;
        this.k = cVarD;
        this.l = cVarD.e.get(0).f5967a;
        this.e.add(new b());
        E(cVarD.d);
        m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
        c cVar = this.d.get(this.l);
        if (z) {
            cVar.w((com.google.android.exoplayer2.source.hls.playlist.b) ei2VarC, m43Var);
        } else {
            cVar.p();
        }
        this.c.onLoadTaskConcluded(gVar.f6027a);
        this.g.s(m43Var, 4);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public Loader.c j(g<ei2> gVar, long j, long j2, IOException iOException, int i) {
        m43 m43Var = new m43(gVar.f6027a, gVar.b, gVar.d(), gVar.b(), j, j2, gVar.a());
        long jA = this.c.a(new f.c(m43Var, new kh3(gVar.c), iOException, i));
        boolean z = jA == -9223372036854775807L;
        this.g.w(m43Var, gVar.c, iOException, z);
        if (z) {
            this.c.onLoadTaskConcluded(gVar.f6027a);
        }
        return z ? Loader.g : Loader.g(false, jA);
    }

    public final void R(Uri uri, com.google.android.exoplayer2.source.hls.playlist.b bVar) {
        if (uri.equals(this.l)) {
            if (this.m == null) {
                this.n = !bVar.o;
                this.o = bVar.h;
            }
            this.m = bVar;
            this.j.d(bVar);
        }
        Iterator<HlsPlaylistTracker.b> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void a(HlsPlaylistTracker.b bVar) {
        this.e.remove(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public long b() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void c(Uri uri, j.a aVar, HlsPlaylistTracker.c cVar) {
        this.i = g86.w();
        this.g = aVar;
        this.j = cVar;
        g gVar = new g(this.f5960a.a(4), uri, 4, this.b.b());
        vh.g(this.h == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.h = loader;
        aVar.y(new m43(gVar.f6027a, gVar.b, loader.m(gVar, this, this.c.getMinimumLoadableRetryCount(gVar.c))), gVar.c);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void d(Uri uri) throws IOException {
        this.d.get(uri).s();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.c g() {
        return this.k;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void h(Uri uri) {
        this.d.get(uri).p();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void i(HlsPlaylistTracker.b bVar) {
        vh.e(bVar);
        this.e.add(bVar);
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean k(Uri uri) {
        return this.d.get(uri).n();
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean l() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public boolean m(Uri uri, long j) {
        if (this.d.get(uri) != null) {
            return !r2.k(j);
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void n() throws IOException {
        Loader loader = this.h;
        if (loader != null) {
            loader.maybeThrowError();
        }
        Uri uri = this.l;
        if (uri != null) {
            d(uri);
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    @Nullable
    public com.google.android.exoplayer2.source.hls.playlist.b o(Uri uri, boolean z) {
        com.google.android.exoplayer2.source.hls.playlist.b bVarM = this.d.get(uri).m();
        if (bVarM != null && z) {
            M(uri);
        }
        return bVarM;
    }

    @Override // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker
    public void stop() {
        this.l = null;
        this.m = null;
        this.k = null;
        this.o = -9223372036854775807L;
        this.h.k();
        this.h = null;
        Iterator<c> it = this.d.values().iterator();
        while (it.hasNext()) {
            it.next().x();
        }
        this.i.removeCallbacksAndMessages(null);
        this.i = null;
        this.d.clear();
    }

    public a(yh2 yh2Var, f fVar, fi2 fi2Var, double d) {
        this.f5960a = yh2Var;
        this.b = fi2Var;
        this.c = fVar;
        this.f = d;
        this.e = new CopyOnWriteArrayList<>();
        this.d = new HashMap<>();
        this.o = -9223372036854775807L;
    }
}
