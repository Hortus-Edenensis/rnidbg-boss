package com.opos.mobad.splash;

import android.app.Activity;
import android.view.View;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.m.i;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.splash.f;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.b f9261a;
    private final b b;
    private final String c;
    private com.opos.mobad.ad.g.f d;
    private int g;
    private AdHelper.AdHelperData h;

    /* JADX INFO: renamed from: com.opos.mobad.splash.c$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass2 implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9263a;

        public AnonymousClass2(String str) {
            this.f9263a = str;
        }

        @Override // com.opos.mobad.model.b.a
        public void a(final int i, final AdHelper.AdHelperData adHelperData) {
            if (adHelperData == null || adHelperData.f9107a.a() != 0) {
                c.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.splash.c.2.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        c.this.g = i;
                        AdHelper.AdHelperData adHelperData2 = adHelperData;
                        if (adHelperData2 != null) {
                            c.this.h = adHelperData2;
                            com.opos.cmn.an.f.a.b("InterSplash$StateAd", "fetchAd success");
                            final f.a aVarA = f.a(c.this.d, adHelperData);
                            if (aVarA != null) {
                                c.this.a(new Runnable() { // from class: com.opos.mobad.splash.c.2.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        c.this.a(aVarA, anonymousClass2.f9263a);
                                    }
                                });
                            } else {
                                com.opos.cmn.an.f.a.c("InterSplash$StateAd", "splashVo data is null!");
                            }
                        }
                        return Boolean.TRUE;
                    }
                });
                return;
            }
            c.this.f9261a.j().a(c.this.c, 3, adHelperData.c.f(), adHelperData.c.b(), adHelperData.d.X(), adHelperData.c.a(), adHelperData.c.P());
            c.this.g = adHelperData.f9107a.c();
            c.this.d(-1, com.opos.mobad.ad.a.a(-1));
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i, String str, AdData adData) {
            com.opos.cmn.an.f.a.b("InterSplash$StateAd", "fetchAd failed,[code, msg] = " + i + "," + str);
            if (adData != null) {
                c.this.g = adData.c();
            }
            c.this.c(i, str);
        }
    }

    public c(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.g.c cVar, com.opos.mobad.ad.g.f fVar, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(cVar);
        com.opos.mobad.b bVarC = bVar.c();
        this.f9261a = bVarC;
        this.c = str;
        this.d = fVar;
        b bVar2 = new b(bVarC, str, new com.opos.mobad.cmn.func.adhandler.a(bVarC, str, aVar, fVar2), new d() { // from class: com.opos.mobad.splash.c.1
            @Override // com.opos.mobad.cmn.func.a.a.b
            public void a(int i, String str2) {
                c.this.d(i, str2);
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void d() {
                c.this.n();
            }

            @Override // com.opos.mobad.ad.m.b
            public void onAdClick(long j) {
                c.this.m();
            }

            @Override // com.opos.mobad.ad.m.b
            public void onAdShow(String str2) {
                c.this.e(str2);
            }
        });
        this.b = bVar2;
        bVar2.a(activity);
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterSplash$StateAd", "destroyAd");
        super.b();
        if (g.d()) {
            this.b.b();
        }
        this.d = null;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.h) == null) ? super.e() : adHelperData.c.ac();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.h) == null) ? super.f() : adHelperData.c.ad();
    }

    @Override // com.opos.mobad.ad.g.b
    public View g() {
        b bVar;
        if (!g.d() || 5 == c() || (bVar = this.b) == null) {
            return null;
        }
        return bVar.a();
    }

    private static com.opos.mobad.template.d a(f.a aVar) {
        final com.opos.mobad.ad.g.d dVarB = aVar.b();
        if (dVarB != null) {
            return new com.opos.mobad.template.d() { // from class: com.opos.mobad.splash.c.3
                @Override // com.opos.mobad.template.d
                public View a() {
                    return dVarB.getAppLogoView();
                }
            };
        }
        return null;
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
        this.g = 0;
        com.opos.mobad.model.b.a(this.f9261a.b().getApplicationContext()).a(this.f9261a, this.c, 3, str, i, new AnonymousClass2(str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f.a aVar, String str) {
        if (this.b != null) {
            this.b.a(aVar, com.opos.mobad.ui.c.b.a().a(this.f9261a.b(), aVar.b, null), e.a(aVar, this.f9261a.b(), aVar.f9268a), a(aVar), str);
        }
    }
}
