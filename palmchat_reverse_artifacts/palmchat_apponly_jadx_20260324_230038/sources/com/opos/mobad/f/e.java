package com.opos.mobad.f;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.e.g;
import com.opos.mobad.ad.e.j;
import com.opos.mobad.ad.e.m;
import com.opos.mobad.ad.e.n;
import com.opos.mobad.ad.e.o;
import com.opos.mobad.ad.e.s;
import com.opos.mobad.ad.h;
import com.opos.mobad.model.e.k;
import com.opos.mobad.provider.MobAdGlobalProvider;
import com.opos.mobad.service.d.d;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k f8891a;

    private void c() {
        if (this.f8891a == null) {
            return;
        }
        com.opos.mobad.c.b.e().a(this.f8891a.a(), this.f8891a.b(), this.f8891a.c());
    }

    public com.opos.mobad.ad.a.b a(Activity activity, String str, com.opos.mobad.ad.a.c cVar) {
        return c.e().a(activity, str, cVar);
    }

    public com.opos.mobad.ad.g.b b(Activity activity, String str, com.opos.mobad.ad.g.c cVar, com.opos.mobad.ad.g.f fVar) {
        return c.e().b(activity, str, cVar, fVar);
    }

    private void b() {
    }

    public com.opos.mobad.ad.d.a a(Activity activity, String str, com.opos.mobad.ad.d.e eVar, com.opos.mobad.ad.d.b bVar) {
        return c.e().a(activity, str, eVar, bVar);
    }

    private void b(final Context context) {
        com.opos.mobad.cmn.func.b.b.a.a(context, new com.opos.mobad.cmn.func.b.b.b() { // from class: com.opos.mobad.f.e.7
            @Override // com.opos.mobad.cmn.func.b.b.b
            public void a(int i, String str) {
                com.opos.mobad.c.b.e().c().a(i, str);
            }

            @Override // com.opos.mobad.cmn.func.b.b.b
            public void a(String str) {
                com.opos.cmn.an.f.a.b("MobAdManager", "TBL.so unzip suc Path: " + str);
                com.opos.mobad.mediaplayer.a.e.a(context, str);
            }
        });
    }

    public com.opos.mobad.ad.d.c a(Activity activity, String str, com.opos.mobad.ad.d.d dVar) {
        return c.e().a(activity, str, dVar);
    }

    public com.opos.mobad.ad.e.c a(Context context, String str, int i, m mVar) {
        return c.e().a(context, str, i, mVar);
    }

    public com.opos.mobad.ad.e.c a(Context context, String str, com.opos.mobad.ad.e.f fVar) {
        return c.e().a(context, str, fVar);
    }

    public g a(Context context, String str, j jVar) {
        return c.e().a(context, str, jVar);
    }

    public n a(Context context, String str, s sVar, o oVar) {
        return c.e().a(context, str, sVar, oVar);
    }

    public com.opos.mobad.ad.f.a a(Context context, String str, com.opos.mobad.ad.f.b bVar) {
        return c.e().a(context, str, bVar);
    }

    public com.opos.mobad.ad.g.a a(Context context, String str, com.opos.mobad.ad.g.c cVar, com.opos.mobad.ad.g.f fVar) {
        return c.e().a(context, str, cVar, fVar);
    }

    public com.opos.mobad.ad.g.b a(Activity activity, String str, com.opos.mobad.ad.g.c cVar, com.opos.mobad.ad.g.f fVar) {
        return c.e().a(activity, str, cVar, fVar);
    }

    public String a(String str, int i) {
        return c.e().a(str, i);
    }

    public void a(Context context) {
        if (context == null) {
            com.opos.cmn.an.f.a.d("MobAdManager", "exit with null context");
            return;
        }
        c.b(com.opos.mobad.service.a.a(context));
        com.opos.mobad.c.b.l();
        com.opos.mobad.service.a.a();
    }

    public void a(Context context, String str, int i) {
        a(context, str, i, (h) null);
    }

    public void a(Context context, String str, int i, h hVar) {
        a(context, str, false, true, i, hVar, false, 0, null);
    }

    public void a(Context context, String str, boolean z, boolean z2, int i, h hVar, boolean z3, int i2, com.opos.mobad.ad.d dVar) {
        a(context, str, z, z2, i, hVar, z3, i2, dVar, null);
    }

    public void a(final Context context, final String str, boolean z, boolean z2, final int i, h hVar, boolean z3, int i2, final com.opos.mobad.ad.d dVar, com.opos.mobad.ad.e eVar) {
        this.f8891a = new k();
        if (context == null || com.opos.cmn.an.d.b.a(str)) {
            if (hVar != null) {
                hVar.onFailed("context or appId is null.");
                return;
            }
            return;
        }
        if (com.opos.cmn.an.c.c.b() < 19) {
            if (hVar != null) {
                hVar.onFailed("init sdk failed! sdk not support android sdk version < 19");
                return;
            }
            return;
        }
        if (!com.opos.cmn.i.c.a(context, Uri.parse("content://" + MobAdGlobalProvider.getAuthority(context)))) {
            if (hVar != null) {
                hVar.onFailed("init sdk failed! com.opos.mobad.provider.MobAdGlobalProvider don't find in AndroidManifest.xml.");
                return;
            }
            return;
        }
        if (!com.opos.cmn.i.c.a(context, Uri.parse("content://" + context.getPackageName() + ".MobFileProvider"))) {
            if (hVar != null) {
                hVar.onFailed("init sdk failed! com.heytap.msp.mobad.api.MobFileProvider don't find in AndroidManifest.xml.");
                return;
            }
            return;
        }
        k kVar = this.f8891a;
        if (kVar != null) {
            kVar.a(true);
        }
        com.opos.cmn.an.e.a.a.a(context);
        com.opos.mobad.service.a.a(context, context);
        com.opos.mobad.c.b.a(context, z, new d.a() { // from class: com.opos.mobad.f.e.1
            private String d;
            private String e;
            private int f = -1;

            @Override // com.opos.mobad.service.d.d.a
            public String a() {
                return str;
            }

            @Override // com.opos.mobad.service.d.d.a
            public String b() {
                if (TextUtils.isEmpty(this.d)) {
                    this.d = context.getPackageName();
                }
                return this.d;
            }

            @Override // com.opos.mobad.service.d.d.a
            public String c() {
                if (TextUtils.isEmpty(this.e)) {
                    Context context2 = context;
                    this.e = com.opos.cmn.an.h.d.a.c(context2, context2.getPackageName());
                }
                return this.e;
            }

            @Override // com.opos.mobad.service.d.d.a
            public int d() {
                if (this.f < 0) {
                    Context context2 = context;
                    this.f = com.opos.cmn.an.h.d.a.b(context2, context2.getPackageName());
                }
                return this.f;
            }
        }, new d.f() { // from class: com.opos.mobad.f.e.2
            @Override // com.opos.mobad.service.d.d.f
            public int a() {
                return 910004;
            }

            @Override // com.opos.mobad.service.d.d.f
            public String b() {
                return "9.1.0";
            }

            @Override // com.opos.mobad.service.d.d.f
            public int c() {
                return i;
            }
        }, z2, z3, i2, new d.InterfaceC0771d() { // from class: com.opos.mobad.f.e.3
            private String c;
            private String d;
            private Boolean e;

            @Override // com.opos.mobad.service.d.d.InterfaceC0771d
            public String a() {
                if (TextUtils.isEmpty(this.c)) {
                    this.c = com.opos.mobad.cmn.func.b.c.a(context);
                }
                return this.c;
            }

            @Override // com.opos.mobad.service.d.d.InterfaceC0771d
            public String b() {
                if (TextUtils.isEmpty(this.d)) {
                    this.d = com.opos.mobad.cmn.func.b.c.a();
                }
                return this.d;
            }

            @Override // com.opos.mobad.service.d.d.InterfaceC0771d
            public boolean c() {
                if (this.e == null) {
                    this.e = Boolean.valueOf(com.opos.mobad.cmn.func.b.c.b(context));
                }
                return this.e.booleanValue();
            }

            @Override // com.opos.mobad.service.d.d.InterfaceC0771d
            public void d() {
                this.c = com.opos.mobad.cmn.func.b.c.a(context);
                this.d = com.opos.mobad.cmn.func.b.c.a();
                this.e = Boolean.valueOf(com.opos.mobad.cmn.func.b.c.b(context));
            }
        }, new d.g() { // from class: com.opos.mobad.f.e.4
            private String c;
            private String d;
            private Boolean e;

            @Override // com.opos.mobad.service.d.d.g
            public String a() {
                if (TextUtils.isEmpty(this.c)) {
                    this.c = com.opos.mobad.cmn.func.b.c.a(context);
                }
                return this.c;
            }

            @Override // com.opos.mobad.service.d.d.g
            public String b() {
                if (TextUtils.isEmpty(this.d)) {
                    this.d = com.opos.mobad.cmn.func.b.c.a();
                }
                return this.d;
            }

            @Override // com.opos.mobad.service.d.d.g
            public boolean c() {
                if (this.e == null) {
                    this.e = Boolean.valueOf(com.opos.mobad.cmn.func.b.c.b(context));
                }
                return this.e.booleanValue();
            }

            @Override // com.opos.mobad.service.d.d.g
            public void d() {
                this.c = com.opos.mobad.cmn.func.b.c.a(context);
                this.d = com.opos.mobad.cmn.func.b.c.a();
                this.e = Boolean.valueOf(com.opos.mobad.cmn.func.b.c.b(context));
            }
        }, dVar == null ? null : new d.c() { // from class: com.opos.mobad.f.e.5
            @Override // com.opos.mobad.service.d.d.c
            public String a() {
                return dVar.getClassifyByAge();
            }
        }, eVar);
        k kVar2 = this.f8891a;
        if (kVar2 != null) {
            kVar2.b(true);
        }
        c.e().a(context, str, i, z, z3);
        if (com.opos.cmn.a.a.a()) {
            c.a aVarB = c.e().b();
            if (!aVarB.f8521a) {
                com.opos.cmn.an.f.a.d("MobAdManager", aVarB.b);
                if (hVar != null) {
                    hVar.onFailed(aVarB.b);
                    return;
                }
                return;
            }
        }
        if (!c.e().c()) {
            if (hVar != null) {
                hVar.onFailed("init fail");
                return;
            }
            return;
        }
        b();
        if (com.opos.mobad.mediaplayer.a.f9001a.booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir().getAbsolutePath());
            String str2 = File.separator;
            sb.append(str2);
            sb.append(".mob_ad");
            sb.append(str2);
            sb.append(".tplay");
            sb.append(str2);
            sb.append("d41d8cd98f00b204e9800998ecf8427e");
            final String string = sb.toString();
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.f.e.6
                @Override // java.lang.Runnable
                public void run() {
                    File file = new File(string);
                    if (file.exists()) {
                        return;
                    }
                    file.mkdirs();
                }
            });
            com.opos.mobad.mediaplayer.a.e.a(context, string);
            b(context);
        } else {
            com.opos.mobad.mediaplayer.a.e.a(context, "");
        }
        com.opos.mobad.cmn.func.b.e.a(context);
        k kVar3 = this.f8891a;
        if (kVar3 != null) {
            kVar3.c(true);
            c();
        }
        if (hVar != null) {
            hVar.onSuccess();
        }
    }

    public boolean a() {
        return com.opos.mobad.c.b.a().c();
    }

    public boolean a(String str) {
        return com.opos.mobad.c.b.a().f(str);
    }
}
