package com.opos.mobad.f.a.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.e.j;
import com.opos.mobad.ad.e.m;
import com.opos.mobad.ad.e.o;
import com.opos.mobad.ad.e.s;
import com.opos.mobad.n;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b implements com.opos.mobad.ad.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.c f8848a;
    private com.opos.mobad.ad.c b;
    private Context c;
    private AtomicBoolean d;

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.b a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar) {
        if (a()) {
            return new c(activity, str2, aVar, cVar, z, this.f8848a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
        if (this.d.compareAndSet(true, false)) {
            this.f8848a.b();
            com.opos.mobad.ad.c cVar = this.b;
            if (cVar != null) {
                cVar.b();
            }
            d.a().c();
        }
    }

    private void b(Context context, String str, String str2, String str3, boolean z, com.opos.mobad.ad.h hVar) {
        if (!com.opos.mobad.c.b.a().a(1001)) {
            com.opos.cmn.an.f.a.a("MobAdCreator", "init but channel not support");
            return;
        }
        if (TextUtils.isEmpty(com.opos.mobad.c.b.a().x())) {
            com.opos.cmn.an.f.a.a("MobAdCreator", "init but null token");
        } else if (com.opos.mobad.c.b.j().f()) {
            com.opos.cmn.an.f.a.a("MobAdCreator", "init but touristMode");
        } else {
            this.b.a(context, str, str2, str3, z, hVar);
        }
    }

    @Override // com.opos.mobad.ad.c
    public c.a a(Context context) {
        return this.f8848a.a(context);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.a a(Activity activity, String str, String str2, com.opos.mobad.ad.d.e eVar, com.opos.mobad.ad.d.b bVar) {
        if (a()) {
            return new e(activity, str2, bVar, eVar, this.f8848a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.d.d dVar) {
        if (a()) {
            return this.f8848a.a(activity, str, str2, z, dVar);
        }
        return null;
    }

    public com.opos.mobad.ad.e.c a(Context context, String str, String str2, int i, m mVar) {
        if (a()) {
            return ((n) this.f8848a).a(context, str, str2, i, mVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.c a(Context context, String str, String str2, com.opos.mobad.ad.e.f fVar) {
        if (a()) {
            return this.f8848a.a(context, str, str2, fVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.g a(Context context, String str, String str2, int i, int i2, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        if (a()) {
            return new f(context, str2, i, i2, jVar, aVar, this.f8848a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.n a(Context context, s sVar, String str, String str2, o oVar) {
        if (a()) {
            return new g(context, str2, oVar, sVar, this.f8848a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.f.b bVar) {
        if (a()) {
            return new h(context, str2, bVar, this.f8848a, this.b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.g.a a(Context context, String str, String str2, com.opos.mobad.ad.g.f fVar, com.opos.mobad.ad.g.c cVar) {
        if (a()) {
            return this.f8848a.a(context, str, str2, fVar, cVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.g.b a(Activity activity, String str, String str2, com.opos.mobad.ad.g.f fVar, com.opos.mobad.ad.g.c cVar) {
        if (a()) {
            return this.f8848a.a(activity, str, str2, fVar, cVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public String a(String str, int i) {
        if (a()) {
            com.opos.mobad.ad.c cVar = this.f8848a;
            if (cVar == null) {
                return null;
            }
            return cVar.a(str, i);
        }
        com.opos.cmn.an.f.a.d("MobAdCreator", "please init first: " + str);
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z, com.opos.mobad.ad.h hVar) {
        Context applicationContext = context.getApplicationContext();
        this.c = applicationContext;
        if (applicationContext == null) {
            com.opos.cmn.an.f.a.a("MobAdCreator", "init but null context");
            return;
        }
        if (a(context).f8521a) {
            this.f8848a.a(context, str, str2, str3, z, hVar);
            b(context, str, str2, str3, z, hVar);
            if (this.d.compareAndSet(false, true)) {
                d.a().a(context);
            }
        }
    }

    private boolean a() {
        return this.d.get();
    }
}
