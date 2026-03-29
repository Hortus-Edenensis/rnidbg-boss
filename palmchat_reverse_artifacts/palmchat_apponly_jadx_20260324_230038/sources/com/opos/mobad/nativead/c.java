package com.opos.mobad.nativead;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.opos.mobad.ad.e.q;
import com.opos.mobad.ad.e.r;
import com.opos.mobad.cmn.func.adhandler.a;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.utils.AdHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c extends b implements com.opos.mobad.ad.e.c, c.b {
    private Handler k;

    public c(com.opos.mobad.b bVar, String str, int i, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.e.f fVar, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(bVar, str, i, aVar, fVar, fVar2);
        this.k = new Handler(Looper.getMainLooper());
    }

    private List<com.opos.mobad.ad.e.d> a(AdData adData) {
        ArrayList arrayList;
        List<AdItemData> listF;
        if (adData == null || (listF = adData.f()) == null || listF.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (AdItemData adItemData : listF) {
                if (adItemData != null) {
                    arrayList.add(new com.opos.mobad.nativead.b.a(this.f9118a.b(), this, adItemData));
                }
            }
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "adDataToINativeAdDataList =", arrayList);
        return arrayList;
    }

    private void b(r rVar) {
        com.opos.cmn.an.f.a.b("InterNativeAd", "fetchNativeAd");
        this.j = com.opos.cmn.i.f.a();
        com.opos.mobad.model.b.a(this.f9118a.b()).a(this.f9118a, this.b, 4, this.j, (int) (rVar != null ? rVar.f8528a : 30000L), new b.a() { // from class: com.opos.mobad.nativead.c.1
            @Override // com.opos.mobad.model.b.a
            public void a(int i, final AdHelper.AdHelperData adHelperData) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.nativead.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        if (cVar.c) {
                            return;
                        }
                        cVar.a(adHelperData);
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(final int i, final String str, AdData adData) {
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.nativead.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVar = c.this;
                        if (cVar.c) {
                            return;
                        }
                        cVar.a(new q(i, str));
                    }
                });
            }
        }, com.opos.mobad.model.b.b);
    }

    private boolean e() {
        boolean zA = this.f9118a.q().a(this.b);
        if (!zA) {
            this.f9118a.r().a(this.b);
        }
        return zA;
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void c(AdItemData adItemData, String str) {
        if (adItemData != null && adItemData.i() != null) {
            b(adItemData, adItemData.i().get(0));
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "notifyLaunchEventFromWeb pkgName:" + str);
    }

    public boolean d() {
        return this.c;
    }

    public c(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.ad.e.f fVar, com.opos.mobad.cmn.func.adhandler.f fVar2) {
        super(bVar, str, aVar, fVar, fVar2);
        this.k = new Handler(Looper.getMainLooper());
    }

    @Override // com.opos.mobad.ad.e.c
    public void a() {
        com.opos.cmn.an.f.a.b("InterNativeAd", "destroyAd");
        if (!g.d() || this.c) {
            return;
        }
        this.h = null;
        com.opos.mobad.cmn.service.pkginstall.c.a(this.f9118a.b()).a(this);
        a.c cVar = this.g;
        if (cVar != null) {
            cVar.a();
        }
        this.c = true;
    }

    public void b(AdItemData adItemData) {
        this.f.b(adItemData);
    }

    private void b(final AdItemData adItemData, final MaterialData materialData) {
        if (this.c) {
            return;
        }
        this.k.post(new Runnable() { // from class: com.opos.mobad.nativead.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (materialData == null || 2 != ((b) c.this).i) {
                    return;
                }
                com.opos.cmn.an.f.a.b("InterNativeAd", "notifyRewardIfNeed pkgNameTime=" + materialData.E());
                if (!c.this.a(materialData.i(), materialData.E())) {
                    c.this.c().onRewardFail(materialData.i(), 1);
                    return;
                }
                c cVar = c.this;
                com.opos.mobad.cmn.func.b.e.a(cVar.f9118a, cVar.b, adItemData, materialData, 0L, 0L, 4);
                c.this.c().onReward(materialData.i());
                g.a(c.this.f9118a.b(), materialData.i(), com.opos.cmn.b.a.a.c());
            }
        });
    }

    @Override // com.opos.mobad.model.d.a
    public void a(int i, String str, AdData adData, Object... objArr) {
    }

    @Override // com.opos.mobad.ad.e.c
    public void a(r rVar) {
        com.opos.cmn.an.f.a.b("InterNativeAd", "loadAd nativeAdParams=", rVar);
        if (!g.d()) {
            b().onAdFailed(new q(11005, b(11005)));
            return;
        }
        if (this.c) {
            return;
        }
        if (!e()) {
            b().onAdFailed(new q(-1, "inter error request"));
            return;
        }
        int iA = a(4);
        if (iA == 0) {
            b(rVar);
        } else {
            a(new q(iA, b(iA)));
        }
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void b(AdItemData adItemData, String str) {
        if (adItemData != null && adItemData.i() != null) {
            b(adItemData, adItemData.i().get(0));
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "notifyLaunchEvent pkgName:" + str);
    }

    @Override // com.opos.mobad.cmn.service.pkginstall.c.b
    public void a(final AdItemData adItemData, final String str) {
        if (adItemData != null) {
            try {
                if (com.opos.cmn.an.d.b.a(str)) {
                    return;
                }
                com.opos.cmn.an.f.a.b("InterNativeAd", "notifyInstallCompletedEvent pkgName=" + str);
                if (this.c) {
                    return;
                }
                this.k.post(new Runnable() { // from class: com.opos.mobad.nativead.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.opos.cmn.an.f.a.b("InterNativeAd", "notifyInstallCompleted pkgName=" + str);
                        try {
                            c.this.c().onInstallCompleted(str);
                            if (1 == ((b) c.this).i) {
                                MaterialData materialData = adItemData.i().get(0);
                                if (c.this.a(str, materialData.E())) {
                                    c cVar = c.this;
                                    com.opos.mobad.cmn.func.b.e.a(cVar.f9118a, cVar.b, adItemData, materialData, 0L, 0L, 2);
                                    c.this.c().onReward(str);
                                    g.a(c.this.f9118a.b(), str, com.opos.cmn.b.a.a.c());
                                } else {
                                    c.this.c().onRewardFail(str, 1);
                                }
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e);
                        }
                    }
                });
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e);
            }
        }
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, com.opos.mobad.cmn.func.b.a aVar, View view, boolean z2) {
        int i = ((b) this).i;
        if (1 == i) {
            adItemData.g(2);
        } else if (2 == i) {
            adItemData.g(4);
        }
        this.f.a(adItemData, z, iArr, null, aVar, view, z2, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdHelper.AdHelperData adHelperData) {
        if (adHelperData != null && adHelperData.f9107a.a() == 0) {
            this.f9118a.j().a(this.b, 4, adHelperData.c.f(), adHelperData.c.b(), adHelperData.d.X(), adHelperData.c.a(), adHelperData.c.P());
            a(new q(-1, com.opos.mobad.ad.a.a(-1)));
        } else if (adHelperData == null) {
            b().onAdFailed(new q(-1, "Unknown error. "));
        } else if (System.currentTimeMillis() <= adHelperData.f9107a.h()) {
            AdData adData = adHelperData.f9107a;
            a(adData, a(adData));
        } else {
            com.opos.cmn.an.f.a.d("InterNativeAd", "now time over ad expire time.");
            a(new q(10003, "now time over ad expire time."));
        }
    }

    public boolean a(AdItemData adItemData, MaterialData materialData) {
        boolean zA = false;
        if (adItemData != null && materialData != null) {
            try {
                if (!com.opos.cmn.an.d.b.a(materialData.i()) && (zA = g.a(this.f9118a, adItemData, materialData, (int[]) null))) {
                    b(adItemData, materialData);
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("launchApp pkgName=");
        sb.append(materialData != null ? materialData.i() : com.igexin.push.core.b.m);
        sb.append(",result=");
        sb.append(zA);
        com.opos.cmn.an.f.a.b("InterNativeAd", sb.toString());
        return zA;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(String str, int i) {
        boolean z = false;
        try {
            if (0 != g.b(this.f9118a.b(), str)) {
                if (com.opos.cmn.b.a.a.c() >= g.b(this.f9118a.b(), str) + ((long) (i * 60 * 1000))) {
                    z = true;
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterNativeAd", "", (Throwable) e);
        }
        com.opos.cmn.an.f.a.b("InterNativeAd", "canReward pkgName=" + str + ",result=" + z);
        return z;
    }
}
