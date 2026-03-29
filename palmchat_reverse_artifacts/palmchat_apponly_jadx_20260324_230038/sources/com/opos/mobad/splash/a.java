package com.opos.mobad.splash;

import android.app.Activity;
import android.view.View;
import com.opos.mobad.ad.g;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.splash.f;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends com.opos.mobad.m.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.b f9252a;
    private final b b;
    private final String c;
    private String d;
    private final com.opos.mobad.ad.g.f g;
    private int h;
    private AdHelper.AdHelperData i;

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.g.c cVar, com.opos.mobad.ad.g.f fVar, com.opos.mobad.cmn.a.b bVar2, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(cVar);
        com.opos.mobad.b bVarC = bVar.c();
        this.f9252a = bVarC;
        this.c = str;
        this.g = fVar;
        com.opos.mobad.cmn.func.adhandler.a aVar2 = new com.opos.mobad.cmn.func.adhandler.a(bVarC, str, aVar, fVar2);
        if (cVar instanceof g) {
            aVar2.a((g) cVar);
        }
        this.b = new b(bVarC, str, aVar2, new d() { // from class: com.opos.mobad.splash.a.1
            @Override // com.opos.mobad.cmn.func.a.a.b
            public void a(int i, String str2) {
                a.this.d(i, str2);
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void d() {
                a.this.n();
            }

            @Override // com.opos.mobad.ad.m.b
            public void onAdClick(long j) {
                a.this.m();
            }

            @Override // com.opos.mobad.ad.m.b
            public void onAdShow(String str2) {
                a.this.e(str2);
            }
        }, bVar2);
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.i) == null) ? super.e() : adHelperData.c.ac();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.i) == null) ? super.f() : adHelperData.c.ad();
    }

    @Override // com.opos.mobad.ad.g.b
    public View g() {
        b bVar;
        if (!com.opos.mobad.cmn.func.b.g.d() || 5 == c() || (bVar = this.b) == null) {
            return null;
        }
        return bVar.a();
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterHotSplashStateAd", "destroyAd");
        super.b();
        b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        b bVar = this.b;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    private static com.opos.mobad.template.d a(f.a aVar) {
        final com.opos.mobad.ad.g.d dVarB = aVar.b();
        if (dVarB != null) {
            return new com.opos.mobad.template.d() { // from class: com.opos.mobad.splash.a.3
                @Override // com.opos.mobad.template.d
                public View a() {
                    return dVarB.getAppLogoView();
                }
            };
        }
        return null;
    }

    @Override // com.opos.mobad.ad.g.a
    public void a(Activity activity) {
        this.b.a(activity);
        com.opos.mobad.cmn.func.b.e.a(this.f9252a, this.c, this.d, this.i);
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b(String str) {
        super.a(str, 3000);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(final String str, int i, List<String> list) {
        this.h = 0;
        com.opos.mobad.model.b.a(this.f9252a.b().getApplicationContext()).a(this.f9252a, this.c, 6, str, i, new b.a() { // from class: com.opos.mobad.splash.a.2
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final AdHelper.AdHelperData adHelperData) {
                if (adHelperData != null && adHelperData.f9107a.a() == 0) {
                    a.this.f9252a.j().a(a.this.c, 6, adHelperData.c.f(), adHelperData.c.b(), adHelperData.d.X(), adHelperData.c.a(), adHelperData.c.P());
                    a.this.h = adHelperData.f9107a.c();
                    a.this.d(-1, com.opos.mobad.ad.a.a(-1));
                    return;
                }
                a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.splash.a.2.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        a.this.d = str;
                        a.this.h = i2;
                        AdHelper.AdHelperData adHelperData2 = adHelperData;
                        if (adHelperData2 != null) {
                            a.this.i = adHelperData2;
                            com.opos.cmn.an.f.a.b("InterHotSplashStateAd", "fetchAd success");
                        }
                        return Boolean.TRUE;
                    }
                });
                final f.a aVarA = f.a(a.this.g, adHelperData);
                if (aVarA != null) {
                    a.this.a(new Runnable() { // from class: com.opos.mobad.splash.a.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            a.this.a(aVarA, str);
                        }
                    });
                } else {
                    com.opos.cmn.an.f.a.c("InterHotSplashStateAd", "splashVo data is null!");
                }
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                com.opos.cmn.an.f.a.b("InterHotSplashStateAd", "fetchAd failed,[code, msg] = " + i2 + "," + str2);
                if (adData != null) {
                    a.this.h = adData.c();
                }
                a.this.c(i2, str2);
            }
        }, list);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f.a aVar, String str) {
        if (this.b != null) {
            com.opos.cmn.an.f.a.b("InterHotSplashStateAd", "createSplashView");
            this.b.a(aVar, com.opos.mobad.ui.c.b.a().a(this.f9252a.b(), aVar.b, null), e.a(aVar, this.f9252a.b(), aVar.f9268a), a(aVar), str);
        }
    }
}
