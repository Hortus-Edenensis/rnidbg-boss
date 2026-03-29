package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import com.google.common.collect.ImmutableList;
import defpackage.fr3;
import defpackage.u06;
import defpackage.vh;
import defpackage.w9;
import defpackage.xd5;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class s extends com.google.android.exoplayer2.source.a {
    public final com.google.android.exoplayer2.upstream.b h;
    public final a.InterfaceC0360a i;
    public final com.google.android.exoplayer2.m j;
    public final long k;
    public final com.google.android.exoplayer2.upstream.f l;
    public final boolean m;
    public final e0 n;
    public final com.google.android.exoplayer2.p o;

    @Nullable
    public u06 p;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a.InterfaceC0360a f5988a;
        public com.google.android.exoplayer2.upstream.f b = new com.google.android.exoplayer2.upstream.e();
        public boolean c = true;

        @Nullable
        public Object d;

        @Nullable
        public String e;

        public b(a.InterfaceC0360a interfaceC0360a) {
            this.f5988a = (a.InterfaceC0360a) vh.e(interfaceC0360a);
        }

        public s a(p.k kVar, long j) {
            return new s(this.e, kVar, this.f5988a, j, this.b, this.c, this.d);
        }

        public b b(@Nullable com.google.android.exoplayer2.upstream.f fVar) {
            if (fVar == null) {
                fVar = new com.google.android.exoplayer2.upstream.e();
            }
            this.b = fVar;
            return this;
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public h c(i.b bVar, w9 w9Var, long j) {
        return new r(this.h, this.i, this.p, this.j, this.k, this.l, o(bVar), this.m);
    }

    @Override // com.google.android.exoplayer2.source.i
    public void f(h hVar) {
        ((r) hVar).k();
    }

    @Override // com.google.android.exoplayer2.source.i
    public com.google.android.exoplayer2.p getMediaItem() {
        return this.o;
    }

    @Override // com.google.android.exoplayer2.source.a
    public void t(@Nullable u06 u06Var) {
        this.p = u06Var;
        u(this.n);
    }

    public s(@Nullable String str, p.k kVar, a.InterfaceC0360a interfaceC0360a, long j, com.google.android.exoplayer2.upstream.f fVar, boolean z, @Nullable Object obj) {
        this.i = interfaceC0360a;
        this.k = j;
        this.l = fVar;
        this.m = z;
        com.google.android.exoplayer2.p pVarA = new p.c().i(Uri.EMPTY).d(kVar.f5923a.toString()).g(ImmutableList.of(kVar)).h(obj).a();
        this.o = pVarA;
        m.b bVarW = new m.b().g0((String) fr3.a(kVar.b, MimeTypes.TEXT_UNKNOWN)).X(kVar.c).i0(kVar.d).e0(kVar.e).W(kVar.f);
        String str2 = kVar.g;
        this.j = bVarW.U(str2 == null ? str : str2).G();
        this.h = new b.C0361b().i(kVar.f5923a).b(1).a();
        this.n = new xd5(j, true, false, false, null, pVarA);
    }

    @Override // com.google.android.exoplayer2.source.i
    public void maybeThrowSourceInfoRefreshError() {
    }

    @Override // com.google.android.exoplayer2.source.a
    public void v() {
    }
}
