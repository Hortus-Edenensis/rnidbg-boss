package com.opos.mobad.k;

import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bq;
import com.opos.mobad.ad.g;
import com.opos.mobad.ad.k;
import com.opos.mobad.cmn.func.a.a;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.j.e;
import com.opos.mobad.l.c;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.p.a;
import com.opos.mobad.ui.c.f;
import com.opos.mobad.video.player.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b implements a.InterfaceC0723a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f8956a;
    private String b;
    private AdHelper.AdHelperData c;
    private AdHelper.AdHelperData d;
    private com.opos.mobad.cmn.func.adhandler.a f;
    private com.opos.mobad.ad.f.b g;
    private a.b h;
    private d i;
    private e j;
    private a k;
    private C0750b l;
    private com.opos.mobad.video.player.a m;
    private com.opos.mobad.activity.b n;
    private c o;
    private boolean e = false;
    private a.AbstractBinderC0760a p = new a.AbstractBinderC0760a() { // from class: com.opos.mobad.k.b.2
        @Override // com.opos.mobad.p.a
        public void a() {
            if (b.this.e) {
                return;
            }
            b.this.g.onLandingPageClose();
            if (b.this.h != null) {
                b.this.h.d();
            }
        }

        @Override // com.opos.mobad.p.a
        public void a(com.opos.mobad.p.b bVar) {
            if (b.this.e) {
                return;
            }
            b.this.g.onLandingPageOpen();
        }

        @Override // com.opos.mobad.p.a
        public void a(Map map) throws RemoteException {
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public class a implements c.b {
        private a() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void a(AdItemData adItemData, String str) {
            try {
                com.opos.cmn.an.f.a.b("RewardVideoPresenter", "notifyInstallCompletedEvent pkgName=" + str);
                if (b.this.e) {
                    return;
                }
                b.this.j.b(adItemData, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("RewardVideoPresenter", "", (Throwable) e);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void b(AdItemData adItemData, String str) {
            b.this.j.a(adItemData, str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void c(AdItemData adItemData, String str) {
            b.this.j.a(adItemData, str);
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.k.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0750b implements com.opos.mobad.l.a {
        private C0750b() {
        }

        @Override // com.opos.mobad.l.a
        public void a() {
            if (b.this.e) {
                return;
            }
            (b.this.d != null ? b.this.d : b.this.c).c.d(true);
            b.this.g.onReward(new Object[0]);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.opos.mobad.l.a
        public void d() {
            if (b.this.e) {
                return;
            }
            b.this.g.onVideoPlayStart();
        }

        @Override // com.opos.mobad.l.a
        public void e() {
            if (b.this.e) {
                return;
            }
            b.this.g.onVideoPlayComplete();
        }

        @Override // com.opos.mobad.l.a
        public void a(int i, String str) {
            if (b.this.e) {
                return;
            }
            b.this.g.onAdFailed(i, str);
        }

        @Override // com.opos.mobad.l.a
        public void a(long j) {
            if (b.this.e) {
                return;
            }
            b.this.g.onAdClick(j);
        }

        @Override // com.opos.mobad.l.a
        public void a(long j, boolean z) {
            b bVar;
            AdHelper.AdHelperData adHelperData;
            if (b.this.e) {
                return;
            }
            if (z) {
                b.this.g.onVideoPlayClose(j);
                if (b.this.h != null) {
                    b.this.h.d();
                }
            }
            if (b.this.d != null) {
                bVar = b.this;
                adHelperData = bVar.d;
            } else {
                bVar = b.this;
                adHelperData = bVar.c;
            }
            bVar.a(adHelperData);
        }

        @Override // com.opos.mobad.l.a
        public void a(final com.opos.mobad.l.c cVar) throws RemoteException {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "getFallbackAd()");
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.k.b.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b bVar = b.this;
                        bVar.d = bVar.d();
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAd()", e);
                    }
                    if (b.this.d != null) {
                        if (b.this.j != null) {
                            b.this.j.a(b.this.d.c, b.this.d.d);
                        }
                        b bVar2 = b.this;
                        bVar2.b(bVar2.c);
                        b bVar3 = b.this;
                        bVar3.a(bVar3.d);
                    }
                    if (b.this.o != null) {
                        try {
                            b.this.o.a(b.this.d);
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAd()", e2);
                        }
                    }
                    com.opos.mobad.l.c cVar2 = cVar;
                    if (cVar2 != null) {
                        try {
                            cVar2.a(b.this.d);
                        } catch (Exception e3) {
                            com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAd()", e3);
                        }
                    }
                }
            });
        }

        @Override // com.opos.mobad.l.a
        public void a(String str) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "onProcessError(), s=", str);
            if (b.this.e) {
                return;
            }
            b.this.g.onVideoPlayError(str);
        }

        @Override // com.opos.mobad.l.a
        public void a(String str, com.opos.mobad.l.b bVar) {
            if (b.this.e) {
                return;
            }
            b.this.g.onAdShow(str);
        }

        @Override // com.opos.mobad.l.a
        public void a(Map map) throws RemoteException {
            if (b.this.g instanceof g) {
                ((g) b.this.g).a(map);
            }
        }

        @Override // com.opos.mobad.l.a
        public void b() {
        }

        @Override // com.opos.mobad.l.a
        public void c() {
        }

        @Override // com.opos.mobad.l.a
        public void f() throws RemoteException {
        }
    }

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.ad.f.b bVar2, com.opos.mobad.cmn.func.a aVar, d dVar) {
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "RewardVideoPresenter()");
        this.f8956a = bVar;
        this.b = str;
        this.g = bVar2;
        com.opos.mobad.cmn.func.adhandler.a aVar2 = new com.opos.mobad.cmn.func.adhandler.a(bVar, str, aVar);
        this.f = aVar2;
        if (bVar2 instanceof g) {
            aVar2.a((g) bVar2);
        }
        this.k = new a();
        this.l = new C0750b();
        this.i = dVar;
        this.j = new e(this.f8956a, new k() { // from class: com.opos.mobad.k.b.1
            @Override // com.opos.mobad.ad.k
            public void onReward(Object... objArr) {
                b.this.a(objArr);
            }
        });
    }

    private int c(AdHelper.AdHelperData adHelperData) {
        MaterialData materialData;
        if (adHelperData == null || (materialData = adHelperData.d) == null) {
            return 10601;
        }
        AdItemData adItemData = adHelperData.c;
        int iZ = materialData.Z();
        if (!f.a(iZ) && !f.b(iZ) && !f.c(iZ)) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "illegal type=", Integer.valueOf(iZ));
            return 10409;
        }
        if (1 != adItemData.t() && 2 != adItemData.t()) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "illegal mode");
            return 10407;
        }
        if (adItemData.t() == 1 && TextUtils.isEmpty(com.opos.cmn.d.d.a(this.f8956a.b(), adHelperData.e.a(), adHelperData.e.b()))) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "illegal cache url");
            return 10408;
        }
        if (!com.opos.cmn.an.h.c.a.d(this.f8956a.b())) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "no net");
            return 10403;
        }
        if (System.currentTimeMillis() > adItemData.u()) {
            com.opos.cmn.an.f.a.b("RewardVideoPresenter", "exp time");
            return 10404;
        }
        if (!com.opos.mobad.model.utils.e.a(adItemData, materialData) || com.opos.mobad.model.utils.e.a(materialData) != null) {
            return 10000;
        }
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "trial game icon data is null");
        return 10601;
    }

    public void a() {
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "destroy()");
        this.e = true;
        this.j.i();
        b();
        c();
        com.opos.mobad.cmn.service.pkginstall.c.a(this.f8956a.b()).a(this.k);
        this.o = null;
    }

    private void a(int i, AdHelper.AdHelperData adHelperData, String str) {
        com.opos.mobad.b bVar;
        String strB;
        String str2;
        String str3;
        String strC;
        String strA;
        if (this.e) {
            return;
        }
        HashMap map = new HashMap();
        map.put("rsCode", "" + i);
        if (adHelperData == null) {
            bVar = this.f8956a;
            strB = "";
            str2 = this.b;
            str3 = "4";
            strC = "";
            strA = str;
        } else {
            map.put("clientTemplateId", String.valueOf(adHelperData.d.b()));
            bVar = this.f8956a;
            strB = adHelperData.c.b();
            str2 = this.b;
            str3 = "4";
            strC = adHelperData.c.c();
            strA = adHelperData.c.a();
        }
        com.opos.mobad.cmn.func.b.e.a(bVar, strB, str2, str3, strC, strA, map);
        a.b bVar2 = this.h;
        if (bVar2 != null) {
            bVar2.a(i, com.opos.mobad.ad.a.a(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdHelper.AdHelperData d() {
        String strA = "";
        try {
            strA = com.opos.mobad.o.d.a(this.f8956a.b(), "fallbackAdPosId", "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAdInner", e);
        }
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "getFallbackAdInner posId=", strA);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AdHelper.AdHelperData[] adHelperDataArr = new AdHelper.AdHelperData[1];
        com.opos.mobad.model.b.a(this.f8956a.b()).a(this.f8956a, strA, new b.a() { // from class: com.opos.mobad.k.b.3
            @Override // com.opos.mobad.model.b.a
            public void a(int i, AdHelper.AdHelperData adHelperData) {
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append("getFallbackAd onSuccess data=");
                sb.append(adHelperData != null);
                objArr[0] = sb.toString();
                com.opos.cmn.an.f.a.b("RewardVideoPresenter", objArr);
                if (adHelperData != null) {
                    adHelperData.c.e(true);
                    adHelperData.c.j(b.this.c.c.a());
                    adHelperDataArr[0] = adHelperData;
                }
                countDownLatch.countDown();
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i, String str, AdData adData) {
                com.opos.cmn.an.f.a.b("RewardVideoPresenter", "getFallbackAd onAdFailed code=", Integer.valueOf(i), ", msg=", str);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(5000, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("RewardVideoPresenter", "getFallbackAdInner", e2);
        }
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        sb.append("getFallbackAdInner data=");
        sb.append(adHelperDataArr[0] != null);
        objArr[0] = sb.toString();
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", objArr);
        return adHelperDataArr[0];
    }

    private void b() {
        com.opos.mobad.video.player.a aVar = this.m;
        if (aVar != null) {
            aVar.g();
            this.m = null;
        }
    }

    private void c() {
        com.opos.mobad.activity.b bVar = this.n;
        if (bVar != null) {
            bVar.b();
            this.n = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdHelper.AdHelperData adHelperData) {
        if (adHelperData == null || TextUtils.isEmpty(adHelperData.d.i())) {
            return;
        }
        com.opos.mobad.cmn.service.pkginstall.c.a(this.f8956a.b()).b(adHelperData.d.i(), this.k);
    }

    public void a(com.opos.mobad.l.c cVar) {
        this.o = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdHelper.AdHelperData adHelperData) {
        if (adHelperData == null || TextUtils.isEmpty(adHelperData.d.i())) {
            return;
        }
        com.opos.mobad.cmn.service.pkginstall.c.a(this.f8956a.b()).a(adHelperData.d.i(), this.f8956a, this.k, adHelperData.c);
    }

    private void a(String str) {
        a(10402, null, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object... objArr) {
        com.opos.mobad.ad.f.b bVar;
        if (this.e || (bVar = this.g) == null) {
            return;
        }
        bVar.onReward(objArr);
    }

    public boolean a(AdHelper.AdHelperData adHelperData, int i, a.b bVar, String str) {
        com.opos.cmn.an.f.a.b("RewardVideoPresenter", "show()");
        return a(adHelperData, i, bVar, false, str);
    }

    private boolean a(AdHelper.AdHelperData adHelperData, int i, a.b bVar, boolean z, String str) {
        try {
            this.h = bVar;
            if (adHelperData == null) {
                a(str);
                return false;
            }
            int iC = c(adHelperData);
            if (10000 != iC && !adHelperData.c.H()) {
                com.opos.cmn.an.f.a.b("RewardVideoPresenter", "illegal play video condition");
                a(iC, adHelperData, str);
                return false;
            }
            b();
            c();
            b(this.c);
            this.m = new com.opos.mobad.video.player.a(this.l);
            this.n = new com.opos.mobad.activity.b(this.p);
            this.c = adHelperData;
            this.d = null;
            this.j.a(adHelperData.c, adHelperData.d);
            this.i.a(this.f8956a.b(), this.c, z, i, this.m, this.p, 1);
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RewardVideoPresenter", bq.b.V, e);
            return false;
        }
    }
}
