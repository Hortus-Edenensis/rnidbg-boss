package com.google.android.exoplayer2.source;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.upstream.a;
import defpackage.bk4;
import defpackage.hi1;
import defpackage.jl3;
import defpackage.lv;
import defpackage.od0;
import defpackage.u06;
import defpackage.vh;
import defpackage.w9;
import defpackage.xd5;
import defpackage.ys1;
import defpackage.z12;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class n extends com.google.android.exoplayer2.source.a implements m.b {
    public final com.google.android.exoplayer2.p h;
    public final p.h i;
    public final a.InterfaceC0360a j;
    public final l.a k;
    public final com.google.android.exoplayer2.drm.c l;
    public final com.google.android.exoplayer2.upstream.f m;
    public final int n;
    public boolean o;
    public long p;
    public boolean q;
    public boolean r;

    @Nullable
    public u06 s;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends z12 {
        public a(e0 e0Var) {
            super(e0Var);
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public e0.b k(int i, e0.b bVar, boolean z) {
            super.k(i, bVar, z);
            bVar.f = true;
            return bVar;
        }

        @Override // defpackage.z12, com.google.android.exoplayer2.e0
        public e0.d s(int i, e0.d dVar, long j) {
            super.s(i, dVar, j);
            dVar.l = true;
            return dVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0360a f5979a;
        public l.a b;
        public hi1 c;
        public com.google.android.exoplayer2.upstream.f d;
        public int e;

        public b(a.InterfaceC0360a interfaceC0360a, final ys1 ys1Var) {
            this(interfaceC0360a, new l.a() { // from class: fo4
                @Override // com.google.android.exoplayer2.source.l.a
                public final l a(bk4 bk4Var) {
                    return n.b.g(ys1Var, bk4Var);
                }
            });
        }

        public static /* synthetic */ l g(ys1 ys1Var, bk4 bk4Var) {
            return new lv(ys1Var);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        public /* synthetic */ i.a a(od0.a aVar) {
            return jl3.a(this, aVar);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public n c(com.google.android.exoplayer2.p pVar) {
            vh.e(pVar.b);
            return new n(pVar, this.f5979a, this.b, this.c.a(pVar), this.d, this.e, null);
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b d(hi1 hi1Var) {
            this.c = (hi1) vh.f(hi1Var, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @Override // com.google.android.exoplayer2.source.i.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public b b(com.google.android.exoplayer2.upstream.f fVar) {
            this.d = (com.google.android.exoplayer2.upstream.f) vh.f(fVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        public b(a.InterfaceC0360a interfaceC0360a, l.a aVar) {
            this(interfaceC0360a, aVar, new com.google.android.exoplayer2.drm.a(), new com.google.android.exoplayer2.upstream.e(), 1048576);
        }

        public b(a.InterfaceC0360a interfaceC0360a, l.a aVar, hi1 hi1Var, com.google.android.exoplayer2.upstream.f fVar, int i) {
            this.f5979a = interfaceC0360a;
            this.b = aVar;
            this.c = hi1Var;
            this.d = fVar;
            this.e = i;
        }
    }

    public /* synthetic */ n(com.google.android.exoplayer2.p pVar, a.InterfaceC0360a interfaceC0360a, l.a aVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.upstream.f fVar, int i, a aVar2) {
        this(pVar, interfaceC0360a, aVar, cVar, fVar, i);
    }

    @Override // com.google.android.exoplayer2.source.i
    public h c(i.b bVar, w9 w9Var, long j) {
        com.google.android.exoplayer2.upstream.a aVarCreateDataSource = this.j.createDataSource();
        u06 u06Var = this.s;
        if (u06Var != null) {
            aVarCreateDataSource.b(u06Var);
        }
        return new m(this.i.f5920a, aVarCreateDataSource, this.k.a(r()), this.l, m(bVar), this.m, o(bVar), this, w9Var, this.i.f, this.n);
    }

    @Override // com.google.android.exoplayer2.source.i
    public void f(h hVar) {
        ((m) hVar).S();
    }

    @Override // com.google.android.exoplayer2.source.i
    public com.google.android.exoplayer2.p getMediaItem() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.source.m.b
    public void onSourceInfoRefreshed(long j, boolean z, boolean z2) {
        if (j == -9223372036854775807L) {
            j = this.p;
        }
        if (!this.o && this.p == j && this.q == z && this.r == z2) {
            return;
        }
        this.p = j;
        this.q = z;
        this.r = z2;
        this.o = false;
        w();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void t(@Nullable u06 u06Var) {
        this.s = u06Var;
        this.l.a((Looper) vh.e(Looper.myLooper()), r());
        this.l.prepare();
        w();
    }

    @Override // com.google.android.exoplayer2.source.a
    public void v() {
        this.l.release();
    }

    public final void w() {
        e0 xd5Var = new xd5(this.p, this.q, false, this.r, null, this.h);
        if (this.o) {
            xd5Var = new a(xd5Var);
        }
        u(xd5Var);
    }

    public n(com.google.android.exoplayer2.p pVar, a.InterfaceC0360a interfaceC0360a, l.a aVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.upstream.f fVar, int i) {
        this.i = (p.h) vh.e(pVar.b);
        this.h = pVar;
        this.j = interfaceC0360a;
        this.k = aVar;
        this.l = cVar;
        this.m = fVar;
        this.n = i;
        this.o = true;
        this.p = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() {
    }
}
