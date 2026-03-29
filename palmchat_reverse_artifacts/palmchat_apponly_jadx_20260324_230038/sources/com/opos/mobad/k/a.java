package com.opos.mobad.k;

import android.os.IBinder;
import com.opos.mobad.ad.g;
import com.opos.mobad.cmn.func.a.a;
import com.opos.mobad.cmn.func.b.e;
import com.opos.mobad.l.c;
import com.opos.mobad.m.h;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.video.player.d;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f8951a;
    private String b;
    private String c;
    private AdHelper.AdHelperData d;
    private AdHelper.AdHelperData g;
    private int h;
    private final b i;
    private int j;
    private C0749a k;

    /* JADX INFO: renamed from: com.opos.mobad.k.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0749a implements com.opos.mobad.ad.f.b, g {
        private com.opos.mobad.ad.f.b c;

        private C0749a() {
        }

        public void a(com.opos.mobad.ad.f.b bVar) {
            this.c = bVar;
        }

        @Override // com.opos.mobad.ad.f.b, com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            a.this.a(j);
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            a.this.q();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            a.this.e(i, str);
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            a.this.r();
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageClose() {
            a.this.m();
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageOpen() {
            a.this.k();
        }

        @Override // com.opos.mobad.ad.k
        public void onReward(Object... objArr) {
            a.this.a(objArr);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayClose(long j) {
            a.this.b(j);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayComplete() {
            a.this.j();
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayError(String str) {
            a.this.e(str);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayStart() {
            a.this.i();
        }

        @Override // com.opos.mobad.ad.g
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.f.b bVar = this.c;
            if (bVar instanceof g) {
                ((g) bVar).a(map);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
        }
    }

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, d dVar, com.opos.mobad.ad.f.b bVar2) {
        super(bVar2);
        this.f8951a = bVar.c();
        this.b = str;
        C0749a c0749a = new C0749a();
        this.k = c0749a;
        c0749a.a(bVar2);
        b bVar3 = new b(bVar, str, this.k, aVar, dVar);
        this.i = bVar3;
        bVar3.a(new c() { // from class: com.opos.mobad.k.a.1
            @Override // com.opos.mobad.l.c
            public void a(AdHelper.AdHelperData adHelperData) {
                a.this.g = adHelperData;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return null;
            }
        });
    }

    private String s() {
        AdItemData adItemData;
        AdHelper.AdHelperData adHelperData = this.d;
        return (adHelperData == null || (adItemData = adHelperData.c) == null) ? "" : adItemData.c();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        this.j = i;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || ((adHelperData = this.g) == null && (adHelperData = this.d) == null)) ? super.e() : adHelperData.c.ac();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        AdHelper.AdHelperData adHelperData;
        return (!d() || ((adHelperData = this.g) == null && (adHelperData = this.d) == null)) ? super.f() : adHelperData.c.ad();
    }

    @Override // com.opos.mobad.m.h
    public boolean h() {
        com.opos.cmn.an.f.a.b("InterRewardVideoStateAd", "showFallBack");
        boolean zA = false;
        try {
            AdHelper.AdHelperData adHelperDataA = AdHelper.a(this.f8951a.b(), this.b, this.c, s());
            zA = a(adHelperDataA, true);
            e.a(this.f8951a, this.b, this.c, adHelperDataA);
            return zA;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("InterRewardVideoStateAd", "showFallBack", e);
            return zA;
        }
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterRewardVideoStateAd", "destroyAd");
        if (com.opos.mobad.cmn.func.b.g.d()) {
            this.i.a();
            super.b();
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(final String str, int i, List<String> list) {
        this.g = null;
        this.h = 0;
        this.j = 0;
        this.c = str;
        com.opos.mobad.model.b.a(this.f8951a.c().b()).a(this.f8951a, this.b, 5, str, i, new b.a() { // from class: com.opos.mobad.k.a.2
            @Override // com.opos.mobad.model.b.a
            public void a(final int i2, final AdHelper.AdHelperData adHelperData) {
                a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.k.a.2.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Boolean call() throws Exception {
                        com.opos.cmn.an.f.a.b("InterRewardVideoStateAd", " call load succ");
                        a.this.d = adHelperData;
                        a.this.h = i2;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        a.this.c = str;
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i2, String str2, AdData adData) {
                if (adData != null) {
                    a.this.h = adData.c();
                }
                a.this.c(i2, str2);
            }
        }, list);
        return true;
    }

    private boolean a(AdHelper.AdHelperData adHelperData, boolean z) {
        return this.i.a(adHelperData, this.j, new a.b() { // from class: com.opos.mobad.k.a.3
            @Override // com.opos.mobad.cmn.func.a.a.b
            public void a(int i, String str) {
                a.this.e(i, str);
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void d() {
                a.this.n();
            }
        }, this.c);
    }

    @Override // com.opos.mobad.m.h
    public boolean b(boolean z) {
        boolean zA = a(this.d, false);
        com.opos.mobad.b bVar = this.f8951a;
        String str = this.b;
        String str2 = this.c;
        AdHelper.AdHelperData adHelperData = this.g;
        if (adHelperData == null) {
            adHelperData = this.d;
        }
        e.a(bVar, str, str2, adHelperData);
        return zA;
    }
}
