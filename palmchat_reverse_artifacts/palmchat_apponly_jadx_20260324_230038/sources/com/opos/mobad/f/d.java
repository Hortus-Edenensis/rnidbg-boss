package com.opos.mobad.f;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.e.g;
import com.opos.mobad.ad.e.j;
import com.opos.mobad.ad.e.n;
import com.opos.mobad.ad.e.o;
import com.opos.mobad.ad.e.s;
import com.opos.mobad.ad.h;
import com.opos.mobad.c.a.d;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d extends c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<d.a> f8890a;
    private final d.a b;
    private final b c;
    private final long d;
    private com.opos.mobad.f.a.e.a e;

    public d(com.opos.mobad.f.a.e.a aVar, List<d.a> list, d.a aVar2, long j, b bVar) {
        this.e = aVar;
        this.f8890a = list;
        this.b = aVar2;
        this.c = bVar;
        this.d = j;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.b a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar) {
        return new com.opos.mobad.f.a.a(activity, str, this.e, false, aVar, cVar, this.f8890a, this.b, this.d, this.c);
    }

    @Override // com.opos.mobad.ad.c
    public c.a a(Context context) {
        return new c.a(true, "");
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.a a(Activity activity, String str, String str2, com.opos.mobad.ad.d.e eVar, com.opos.mobad.ad.d.b bVar) {
        return new com.opos.mobad.f.a.d(activity, str, this.e, bVar, this.f8890a, this.b, this.d, this.c, eVar);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.d.d dVar) {
        return new com.opos.mobad.f.a.e(activity, str, this.e, dVar, z, this.f8890a, this.b, this.d, this.c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.c a(Context context, String str, String str2, com.opos.mobad.ad.e.f fVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public g a(Context context, String str, String str2, int i, int i2, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        return new com.opos.mobad.f.a.f(context, str, this.e, jVar, this.f8890a, this.b, this.d, this.c, aVar);
    }

    @Override // com.opos.mobad.ad.c
    public n a(Context context, s sVar, String str, String str2, o oVar) {
        return new com.opos.mobad.f.a.g(context, sVar, str, this.e, oVar, this.f8890a, this.b, this.d, this.c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.f.b bVar) {
        return new com.opos.mobad.f.a.j(context, str, this.e, bVar, z, this.f8890a, this.b, this.d, this.c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.g.a a(Context context, String str, String str2, com.opos.mobad.ad.g.f fVar, com.opos.mobad.ad.g.c cVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.g.b a(Activity activity, String str, String str2, com.opos.mobad.ad.g.f fVar, com.opos.mobad.ad.g.c cVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z, h hVar) {
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
    }
}
