package com.opos.exoplayer.core.upstream;

import android.content.Context;
import com.opos.exoplayer.core.upstream.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class l implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8382a;
    private final r<? super g> b;
    private final g.a c;

    public l(Context context, r<? super g> rVar, g.a aVar) {
        this.f8382a = context.getApplicationContext();
        this.b = rVar;
        this.c = aVar;
    }

    @Override // com.opos.exoplayer.core.upstream.g.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k a() {
        return new k(this.f8382a, this.b, this.c.a());
    }

    public l(Context context, String str) {
        this(context, str, (r<? super g>) null);
    }

    public l(Context context, String str, r<? super g> rVar) {
        this(context, rVar, new n(str, rVar));
    }
}
