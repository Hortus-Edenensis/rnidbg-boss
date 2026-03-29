package com.opos.mobad.g;

import android.app.Activity;
import android.os.RemoteException;
import android.text.TextUtils;
import com.opos.mobad.ad.d.e;
import com.opos.mobad.ad.g;
import com.opos.mobad.cmn.func.adhandler.a;
import com.opos.mobad.cmn.func.adhandler.f;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.p.a;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b extends com.opos.mobad.m.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f8904a;
    private com.opos.mobad.cmn.func.adhandler.a b;
    private com.opos.mobad.g.a c;
    private String d;
    private String g;
    private com.opos.mobad.ad.d.e h;
    private AdHelper.AdHelperData i;
    private int j;
    private int k;
    private a.c l;
    private com.opos.mobad.cmn.func.a m;
    private com.opos.mobad.video.player.d n;
    private BinderC0745b o;
    private com.opos.mobad.video.player.b.c p;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends com.opos.mobad.video.player.b.c implements com.opos.mobad.ad.c.a, g {
        private com.opos.mobad.ad.d.b b;

        public a(com.opos.mobad.ad.d.b bVar) {
            this.b = bVar;
        }

        private void e() {
            if (b.this.i == null || b.this.i.d == null || b.this.i.d.Q() != 0 || TextUtils.isEmpty(b.this.i.d.u()) || b.this.b == null) {
                return;
            }
            b.this.b.a(b.this.i.c, null, b.this.o);
        }

        @Override // com.opos.mobad.ad.c.a
        public void a() {
            com.opos.mobad.ad.d.b bVar = this.b;
            if (bVar instanceof com.opos.mobad.ad.c.a) {
                ((com.opos.mobad.ad.c.a) bVar).a();
            }
        }

        @Override // com.opos.mobad.video.player.b.c, com.opos.mobad.j.d.a
        public void c() {
            e();
        }

        @Override // com.opos.mobad.cmn.func.a.a.b
        public void d() {
            com.opos.mobad.g.a aVar = b.this.c;
            if (aVar != null) {
                aVar.a();
            }
            b.this.n();
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            b.this.q();
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            b.this.r();
        }

        @Override // com.opos.mobad.cmn.func.a.a.b
        public void a(int i, String str) {
            b.this.d(i, str);
        }

        @Override // com.opos.mobad.ad.g
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.d.b bVar = this.b;
            if (bVar instanceof g) {
                ((g) bVar).a(map);
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class BinderC0745b extends a.AbstractBinderC0760a {
        private BinderC0745b() {
        }

        @Override // com.opos.mobad.p.a
        public void a() {
            if (b.this.c() == 5) {
                return;
            }
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.g.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.mobad.g.a aVar = b.this.c;
                    if (aVar != null) {
                        aVar.a();
                    }
                    b.this.n();
                }
            });
        }

        @Override // com.opos.mobad.p.a
        public void a(com.opos.mobad.p.b bVar) {
        }

        @Override // com.opos.mobad.p.a
        public void a(Map map) throws RemoteException {
        }
    }

    public b(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.ad.d.e eVar, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.d.b bVar2, com.opos.mobad.video.player.d dVar, f fVar) {
        super(bVar2);
        this.f8904a = bVar.c();
        this.d = str;
        this.h = eVar;
        this.m = aVar;
        this.p = new a(bVar2);
        com.opos.mobad.cmn.func.adhandler.a aVar2 = new com.opos.mobad.cmn.func.adhandler.a(bVar, this.d, this.m, fVar);
        this.b = aVar2;
        if (bVar2 instanceof g) {
            aVar2.a((g) bVar2);
        }
        a.c cVarB = com.opos.mobad.cmn.func.b.g.b(activity);
        this.l = cVarB;
        this.b.a(cVarB);
        this.n = dVar;
        this.o = new BinderC0745b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e.b g() {
        com.opos.mobad.ad.d.e eVar = this.h;
        return eVar != null ? eVar.c : e.b.NORMAL;
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

    private int a(AdHelper.AdHelperData adHelperData) {
        if (!com.opos.mobad.ui.c.f.a(adHelperData.d.Z())) {
            return 10000;
        }
        if (adHelperData.c.t() == 1 && TextUtils.isEmpty(com.opos.cmn.d.d.a(this.f8904a.b(), adHelperData.e.a(), adHelperData.e.b()))) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "illegal cache url");
            return 10408;
        }
        if (!com.opos.cmn.an.h.c.a.d(this.f8904a.b())) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "no net");
            return 10403;
        }
        if (System.currentTimeMillis() <= adHelperData.c.u()) {
            return 10000;
        }
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "exp time");
        return 10404;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public synchronized void b() {
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "destroyAd");
        if (com.opos.mobad.cmn.func.b.g.d()) {
            a.c cVar = this.l;
            if (cVar != null) {
                cVar.a();
                this.l = null;
            }
            com.opos.mobad.g.a aVar = this.c;
            if (aVar != null) {
                aVar.a();
                this.c = null;
            }
            super.b();
        }
        if (this.f8904a != null) {
            this.f8904a = null;
        }
        com.opos.mobad.cmn.func.adhandler.a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.b();
            this.b = null;
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        this.k = i;
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.k
    public boolean b(Activity activity) {
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "doShow()");
        com.opos.mobad.cmn.func.b.e.a(this.f8904a, this.d, this.g, this.i);
        if (com.opos.cmn.i.b.a(activity)) {
            d(-1, "Activity is null or activity is finishing.");
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "doShow() show but activity error");
            return false;
        }
        AdHelper.AdHelperData adHelperData = this.i;
        if (adHelperData == null) {
            d(-1, com.opos.mobad.ad.a.a(-1));
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "doShow() show but data null");
            return false;
        }
        if (adHelperData != null && adHelperData.f9107a.a() == 0) {
            this.f8904a.j().a(this.d, 2, this.i.c.f(), this.i.c.b(), this.i.d.X(), this.i.c.a(), this.i.c.P());
            d(-1, com.opos.mobad.ad.a.a(-1));
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "doShow() show but vip");
            return false;
        }
        int iA = a(this.i);
        if (10000 != iA) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "illegal play video condition");
            d(iA, com.opos.mobad.ad.a.a(iA));
            return false;
        }
        com.opos.mobad.g.a aVarA = c.a(activity, this.f8904a, this.d, g(), this.p, this.n, this.b, this.i, this.k);
        this.c = aVarA;
        return aVarA.a(activity, this.g);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(final String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "doLoad");
        this.j = 0;
        this.k = 0;
        com.opos.mobad.model.b.a(this.f8904a.b().getApplicationContext()).a(this.f8904a, this.d, 2, str, i, new b.a() { // from class: com.opos.mobad.g.b.1
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final AdHelper.AdHelperData adHelperData) {
                b.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.g.b.1.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        com.opos.cmn.an.f.a.b("InterInterstitialAd", " call load succ");
                        b.this.j = i2;
                        b.this.i = adHelperData;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        b.this.g = str;
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                b.this.c(i2, str2);
                if (adData != null) {
                    b.this.j = adData.c();
                }
                try {
                    if (b.this.g() == e.b.INSTANT_EXIT) {
                        b.this.f8904a.i().b(b.this.d);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("InterInterstitialAd", "reportDefaultInstantExit()", e);
                }
            }
        }, list);
        return true;
    }
}
