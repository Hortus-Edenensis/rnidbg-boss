package com.opos.mobad.h;

import android.app.Activity;
import com.igexin.sdk.PushConsts;
import com.opos.mobad.cmn.func.a.a;
import com.opos.mobad.cmn.func.b.e;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.h.b;
import com.opos.mobad.m.d;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f8915a;
    private String b;
    private String c;
    private AdHelper.AdHelperData d;
    private int g;
    private int h;
    private b i;

    public a(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.video.player.d dVar, com.opos.mobad.ad.d.d dVar2) {
        super(dVar2);
        this.g = 0;
        this.h = 0;
        com.opos.mobad.b bVarC = bVar.c();
        this.f8915a = bVarC;
        this.b = str;
        this.i = new b(bVarC, str, aVar, dVar, new b.a() { // from class: com.opos.mobad.h.a.1
            @Override // com.opos.mobad.h.b.a
            public void a() {
                a.this.q();
            }

            @Override // com.opos.mobad.h.b.a
            public void b() {
                a.this.r();
            }

            @Override // com.opos.mobad.h.b.a
            public void c() {
                a.this.g();
            }
        });
    }

    @Override // com.opos.mobad.m.d, com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", "destroyAd");
        if (g.d()) {
            b bVar = this.i;
            if (bVar != null) {
                bVar.a();
            }
            super.b();
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        this.h = i;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.d) == null) ? super.e() : adHelperData.c.ac();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || (adHelperData = this.d) == null) ? super.f() : adHelperData.c.ad();
    }

    @Override // com.opos.mobad.m.k
    public boolean b(Activity activity) {
        String str;
        com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", "doShow()");
        e.a(this.f8915a, this.b, this.c, this.d);
        if (com.opos.cmn.i.b.a(activity)) {
            d(-1, "Activity is null or activity is finishing.");
            str = "doShow() show but activity error";
        } else {
            AdHelper.AdHelperData adHelperData = this.d;
            if (adHelperData == null) {
                d(-1, com.opos.mobad.ad.a.a(-1));
                str = "show but data null";
            } else {
                if (adHelperData == null || adHelperData.f9107a.a() != 0) {
                    return this.i.a(this.d, this.h, new a.b() { // from class: com.opos.mobad.h.a.2
                        @Override // com.opos.mobad.cmn.func.a.a.b
                        public void a(int i, String str2) {
                            a.this.d(i, str2);
                        }

                        @Override // com.opos.mobad.cmn.func.a.a.b
                        public void d() {
                            a.this.n();
                        }
                    }, this.d.c.a());
                }
                this.f8915a.j().a(this.b, 2, this.d.c.f(), this.d.c.b(), this.d.d.X(), this.d.c.a(), this.d.c.P());
                d(-1, com.opos.mobad.ad.a.a(-1));
                str = "doShow() show but vip";
            }
        }
        com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", str);
        return false;
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(final String str, int i) {
        this.g = 0;
        this.h = 0;
        com.opos.mobad.model.b.a(this.f8915a.b().getApplicationContext()).a(this.f8915a, this.b, 2, str, i, new b.a() { // from class: com.opos.mobad.h.a.3
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final AdHelper.AdHelperData adHelperData) {
                if (adHelperData.d.Z() == 60 || adHelperData.d.Z() == 62 || adHelperData.d.Z() == 63 || adHelperData.d.Z() == 80 || adHelperData.d.Z() == 81) {
                    a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.h.a.3.1
                        @Override // java.util.concurrent.Callable
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public Boolean call() throws Exception {
                            com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", " call load succ");
                            a.this.d = adHelperData;
                            a.this.g = i2;
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            a.this.c = str;
                            return Boolean.TRUE;
                        }
                    });
                } else {
                    a.this.c(PushConsts.SET_TAG_RESULT, "posId or posType error");
                }
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                if (adData != null) {
                    a.this.g = adData.c();
                }
                a.this.c(i2, str2);
            }
        });
        return true;
    }
}
