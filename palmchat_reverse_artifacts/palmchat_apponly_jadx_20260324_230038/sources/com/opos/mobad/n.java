package com.opos.mobad;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.opos.mobad.ad.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n implements com.opos.mobad.ad.c {
    private static final String[] k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.opos.mobad.cmn.func.a f9113a;
    protected com.opos.mobad.video.player.d b;
    protected com.opos.mobad.cmn.a.b c;
    protected final com.opos.mobad.cmn.func.adhandler.f d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private Context f;
    private String g;
    private String h;
    private boolean i;
    private l j;

    static {
        if (com.opos.mobad.cmn.func.b.g.j()) {
            k = new String[]{com.kuaishou.weapon.p0.g.b, com.kuaishou.weapon.p0.g.d, com.kuaishou.weapon.p0.g.f7481a};
        } else {
            k = new String[]{com.kuaishou.weapon.p0.g.b, com.kuaishou.weapon.p0.g.d, com.kuaishou.weapon.p0.g.f7481a, "android.permission.QUERY_ALL_PACKAGES"};
        }
    }

    public n(com.opos.mobad.video.player.d dVar, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.activity.webview.a aVar2, com.opos.mobad.cmn.a.b bVar, com.opos.mobad.cmn.func.adhandler.f fVar) {
        this.b = dVar;
        this.c = bVar;
        this.f9113a = aVar;
        this.d = fVar;
        com.opos.mobad.cmn.service.a.a().a(aVar, aVar2);
        com.opos.mobad.cmn.service.a.a().a(com.opos.mobad.c.b.j().c());
    }

    private int a(int i) {
        switch (i) {
            case 1:
                return 6;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return 0;
        }
    }

    public b b(Context context) {
        return d.a().b(context);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.b a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar) {
        b bVarB;
        if (a() && (bVarB = b(activity)) != null) {
            return new com.opos.mobad.a.d(activity, bVarB, str2, z, this.f9113a, cVar, this.c, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
        this.e.compareAndSet(true, false);
        l lVar = this.j;
        if (lVar != null) {
            lVar.a();
        }
        com.opos.mobad.cmn.func.adhandler.f fVar = this.d;
        if (fVar != null) {
            fVar.c();
        }
        com.opos.mobad.cmn.service.a.a().e();
    }

    @Override // com.opos.mobad.ad.c
    public c.a a(Context context) {
        if (!com.opos.mobad.cmn.func.b.g.c()) {
            return new c.a(false, "sdk not support android sdk version <19 .");
        }
        if (!com.opos.cmn.i.j.a(this.f, k)) {
            return new c.a(false, "don't have some need normal permission.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(context.getPackageName());
        sb.append(".MobFileProvider");
        return !com.opos.cmn.i.c.a(context, Uri.parse(sb.toString())) ? new c.a(false, "com.heytap.msp.mobad.api.MobFileProvider don't find in AndroidManifest.xml.") : new c.a(true, "");
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.a a(Activity activity, String str, String str2, com.opos.mobad.ad.d.e eVar, com.opos.mobad.ad.d.b bVar) {
        b bVarB;
        if (a() && (bVarB = b(activity)) != null) {
            return new com.opos.mobad.g.b(activity, bVarB, str2, eVar, this.f9113a, bVar, this.b, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.d.d dVar) {
        b bVarB;
        if (a() && (bVarB = b(activity)) != null) {
            return new com.opos.mobad.h.a(activity, bVarB, str2, this.f9113a, this.b, dVar);
        }
        return null;
    }

    public com.opos.mobad.ad.e.c a(Context context, String str, String str2, int i, com.opos.mobad.ad.e.m mVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.nativead.c(bVarB, str2, i, this.f9113a, mVar, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.c a(Context context, String str, String str2, com.opos.mobad.ad.e.f fVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.nativead.c(bVarB, str2, this.f9113a, fVar, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.g a(Context context, String str, String str2, int i, int i2, com.opos.mobad.ad.e.j jVar, com.opos.mobad.ad.privacy.a aVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.nativead.d(bVarB, str2, this.f9113a, jVar, aVar, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.n a(Context context, com.opos.mobad.ad.e.s sVar, String str, String str2, com.opos.mobad.ad.e.o oVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.nativead.e(bVarB, str2, sVar, this.f9113a, oVar, this.c, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.f.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.f.b bVar) {
        b bVarB;
        if (a() && (bVarB = b(com.opos.mobad.service.a.a(context))) != null) {
            return new com.opos.mobad.k.a(bVarB, str2, this.f9113a, this.b, bVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.g.a a(Context context, String str, String str2, com.opos.mobad.ad.g.f fVar, com.opos.mobad.ad.g.c cVar) {
        b bVarB;
        if (a() && (bVarB = b(context)) != null) {
            return new com.opos.mobad.splash.a(bVarB, str2, this.f9113a, cVar, fVar, this.c, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.g.b a(Activity activity, String str, String str2, com.opos.mobad.ad.g.f fVar, com.opos.mobad.ad.g.c cVar) {
        b bVarB;
        if (a() && (bVarB = b(activity)) != null) {
            return new com.opos.mobad.splash.c(activity, bVarB, str2, this.f9113a, cVar, fVar, this.d);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public String a(String str, int i) {
        String str2;
        if (a()) {
            b bVarB = b(this.f);
            if (bVarB == null) {
                return null;
            }
            int iA = a(i);
            if (iA != 0) {
                return i == 4 ? com.opos.mobad.cmn.a.a(bVarB, str, iA) : com.opos.mobad.cmn.a.b(bVarB, str, iA);
            }
            str2 = "";
        } else {
            str2 = "please init first";
        }
        com.opos.cmn.an.f.a.d("MobBaseAdCreator", str2);
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z, com.opos.mobad.ad.h hVar) {
        String str4;
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("MobBaseAdCreator", "init with null content or appId ");
            str4 = "init with null content or appId";
        } else {
            if (a(context).f8521a) {
                if (this.e.compareAndSet(false, true)) {
                    this.f = context.getApplicationContext();
                    this.g = str;
                    this.h = str2;
                    this.i = z;
                    d.a().a(context);
                    l lVar = new l();
                    this.j = lVar;
                    lVar.a(context, str);
                }
                hVar.onSuccess();
                return;
            }
            str4 = "init but fail";
            com.opos.cmn.an.f.a.b("MobBaseAdCreator", "init but fail");
        }
        hVar.onFailed(str4);
    }

    public boolean a() {
        return this.e.get() && this.f != null;
    }
}
