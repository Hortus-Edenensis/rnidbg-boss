package com.opos.exoplayer.core.upstream;

import com.opos.exoplayer.core.upstream.HttpDataSource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class n extends HttpDataSource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8383a;
    private final r<? super g> b;
    private final int c;
    private final int d;
    private final boolean e;

    public n(String str, r<? super g> rVar) {
        this(str, rVar, 8000, 8000, false);
    }

    @Override // com.opos.exoplayer.core.upstream.HttpDataSource.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public m b(HttpDataSource.e eVar) {
        return new m(this.f8383a, null, this.b, this.c, this.d, this.e, eVar);
    }

    public n(String str, r<? super g> rVar, int i, int i2, boolean z) {
        this.f8383a = str;
        this.b = rVar;
        this.c = i;
        this.d = i2;
        this.e = z;
    }
}
