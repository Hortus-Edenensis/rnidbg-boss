package com.opos.mobad.cmn.func.adhandler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.ad.g;
import com.opos.mobad.cmn.func.adhandler.b;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f8642a;
    private com.opos.mobad.cmn.func.adhandler.b b;
    private c c;
    private String d;
    private com.opos.mobad.cmn.func.a e;
    private f f;
    private g g;
    private d h;

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.adhandler.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0724a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AdItemData f8644a;
        private com.opos.mobad.cmn.func.adhandler.e b;

        public C0724a(AdItemData adItemData, com.opos.mobad.cmn.func.adhandler.e eVar) {
            this.f8644a = adItemData;
            this.b = eVar;
        }

        @Override // com.opos.mobad.cmn.func.adhandler.b.a
        public void a(int i, int i2, String str, String str2) {
            if (this.f8644a.R()) {
                return;
            }
            this.f8644a.h(true);
            com.opos.mobad.cmn.func.adhandler.e eVar = this.b;
            if (eVar != null) {
                eVar.a(101, "");
            }
        }

        @Override // com.opos.mobad.cmn.func.adhandler.b.a
        public void b(int i, int i2, String str, String str2) {
            if (this.f8644a.S()) {
                return;
            }
            this.f8644a.i(true);
            com.opos.mobad.cmn.func.adhandler.e eVar = this.b;
            if (eVar != null) {
                eVar.a(105, "");
            }
        }

        @Override // com.opos.mobad.cmn.func.adhandler.b.a
        public void a(int i, int i2, String str, String str2, String str3) {
            com.opos.mobad.cmn.func.adhandler.e eVar = this.b;
            if (eVar != null) {
                eVar.a(106, str3);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a();

        void a(b bVar);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a(int i);

        void a(int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.mobad.b f8645a;
        private com.opos.mobad.cmn.func.adhandler.e b;
        private d c;
        private c.b d;
        private AdItemData e;
        private MaterialData f;
        private g g;
        private d h;

        public e(com.opos.mobad.b bVar, com.opos.mobad.cmn.func.adhandler.e eVar, AdItemData adItemData) {
            this(bVar, eVar, adItemData, null, null);
        }

        public void b(b.e eVar) {
            com.opos.mobad.cmn.func.adhandler.d dVar;
            final MaterialData materialDataC;
            com.opos.cmn.an.f.a.b("AdHandler", "notifyDownloadClickInfo,mDlClickListener=" + this.g);
            if (this.g == null || eVar.c.f8668a != 1 || !eVar.b() || (dVar = eVar.f8669a) == null || (materialDataC = dVar.c()) == null) {
                return;
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.a.e.1
                @Override // java.lang.Runnable
                public void run() {
                    HashMap map = new HashMap();
                    map.put("app_pkg", materialDataC.i());
                    e.this.g.a(map);
                }
            });
        }

        public e(com.opos.mobad.b bVar, com.opos.mobad.cmn.func.adhandler.e eVar, AdItemData adItemData, d dVar, c.b bVar2) {
            this.f8645a = bVar;
            this.b = eVar;
            this.e = adItemData;
            this.f = adItemData.i().get(0);
            this.c = dVar;
            this.d = bVar2;
        }

        public void a(g gVar) {
            this.g = gVar;
        }

        public void a(d dVar) {
            this.h = dVar;
        }

        @Override // com.opos.mobad.cmn.func.adhandler.b.d
        public void a(b.e eVar) {
            if (eVar == null) {
                com.opos.cmn.an.f.a.b("AdHandler", "onResult but null");
                return;
            }
            com.opos.cmn.an.f.a.b("AdHandler", "onResult=" + eVar.toString());
            a.b(this.e, this.f, this.d, eVar);
            a.b(this.f8645a, this.e, this.f, this.b, this.d, eVar);
            b(eVar);
            com.opos.mobad.cmn.func.adhandler.e eVar2 = this.b;
            if (eVar2 != null) {
                eVar2.a(eVar);
            }
            if (this.h != null) {
                if (eVar.c()) {
                    com.opos.cmn.an.f.a.b("AdHandler", "rewardFromDeepLink onResult success");
                    this.h.a(eVar.c.f8668a);
                } else {
                    com.opos.cmn.an.f.a.b("AdHandler", "rewardFromDeepLink onResult failed");
                    d dVar = this.h;
                    b.c cVar = eVar.c;
                    dVar.a(cVar.f8668a, cVar.b);
                }
            }
            if (this.c != null) {
                if (eVar.c()) {
                    this.c.a(eVar.c.f8668a);
                    return;
                }
                d dVar2 = this.c;
                b.c cVar2 = eVar.c;
                dVar2.a(cVar2.f8668a, cVar2.b);
            }
        }
    }

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar) {
        this(bVar, str, aVar, null);
    }

    private Context c() {
        com.opos.mobad.b bVar = this.f8642a;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    private com.opos.mobad.cmn.func.adhandler.e d(AdItemData adItemData) {
        return new com.opos.mobad.cmn.func.adhandler.e(this.f8642a, this.d, adItemData);
    }

    public a a() {
        return new a(this.f8642a, this.d, this.e, this.f);
    }

    public void b() {
        this.c = null;
    }

    public a(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, f fVar) {
        this.f8642a = bVar;
        if (bVar != null) {
            this.f8642a = bVar.c();
        }
        this.d = str;
        this.e = aVar;
        this.f = fVar;
        this.b = new com.opos.mobad.cmn.func.adhandler.b(bVar, str, aVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, com.opos.mobad.cmn.func.adhandler.e eVar, c.b bVar2, b.e eVar2) {
        String str;
        com.opos.cmn.an.f.a.b("AdHandler", "pkgInstallListener :" + bVar2);
        int i = eVar2.c.f8668a;
        if (i != 1 && i != 7) {
            str = "not need to add listener";
        } else {
            if (eVar2.b()) {
                if (eVar2.c.f8668a == 7) {
                    bVar2 = new com.opos.mobad.cmn.func.adhandler.c(bVar, eVar, bVar2);
                }
                com.opos.mobad.cmn.service.pkginstall.c cVarM = bVar.m();
                String strI = materialData.i();
                if (bVar2 == null) {
                    cVarM.a(strI, bVar, adItemData);
                    return;
                } else {
                    cVarM.a(strI, bVar, bVar2, adItemData);
                    return;
                }
            }
            str = "not need to add listener for not success";
        }
        com.opos.cmn.an.f.a.b("AdHandler", str);
    }

    private static boolean c(AdItemData adItemData) {
        if (adItemData != null) {
            return adItemData.i().get(0) != null;
        }
        com.opos.cmn.an.f.a.b("AdHandler", "checkAdItemDataValid but null adItemData");
        return false;
    }

    public void a(g gVar) {
        this.g = gVar;
        com.opos.mobad.cmn.func.adhandler.b bVar = this.b;
        if (bVar != null) {
            bVar.a(gVar);
        }
    }

    public void b(AdItemData adItemData) {
        if (!c(adItemData)) {
            com.opos.cmn.an.f.a.b("AdHandler", "prepareInstantIfNeed but invalid adItemData");
        } else {
            this.b.a(com.opos.mobad.cmn.func.adhandler.d.a(c(), adItemData, 11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(AdItemData adItemData, MaterialData materialData, c.b bVar, b.e eVar) {
        if (bVar == null) {
            return;
        }
        int i = eVar.c.f8668a;
        if ((i == 9 || i == 20 || i == 10) && eVar.b()) {
            bVar.b(adItemData, materialData.i());
        }
    }

    public void a(c cVar) {
        this.c = cVar;
    }

    public void a(d dVar) {
        this.h = dVar;
    }

    public void a(AdItemData adItemData) {
        if (!c(adItemData)) {
            com.opos.cmn.an.f.a.b("AdHandler", "handleActivating but invalid adItemData");
            return;
        }
        e eVar = new e(this.f8642a, d(adItemData), adItemData);
        com.opos.mobad.cmn.func.adhandler.d dVarA = com.opos.mobad.cmn.func.adhandler.d.a(c(), adItemData, 10);
        dVarA.a(eVar);
        eVar.a(this.h);
        this.b.a(dVarA);
    }

    public void a(AdItemData adItemData, c.b bVar, com.opos.mobad.p.a aVar) {
        if (!c(adItemData)) {
            com.opos.cmn.an.f.a.b("AdHandler", "handleVideoLandingPage but invalid params");
            return;
        }
        com.opos.mobad.cmn.func.adhandler.d dVarA = com.opos.mobad.cmn.func.adhandler.d.a(c(), adItemData, 9, null, aVar, null, null);
        dVarA.a(bVar);
        this.b.a(dVarA);
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, View view, com.opos.mobad.cmn.func.b.a aVar, View view2, c.b bVar, com.opos.mobad.p.a aVar2, com.opos.mobad.p.c cVar, String str, d dVar, Integer num, Integer num2, Boolean bool, Long l, Map<String, String> map) {
        c cVar2;
        if (!c(adItemData)) {
            com.opos.cmn.an.f.a.b("AdHandler", "handleJudgeAdClickActionAndSTEvent but invalid adItemData");
            return;
        }
        MaterialData materialData = adItemData.i().get(0);
        com.opos.mobad.cmn.func.adhandler.e eVarD = d(adItemData);
        final com.opos.mobad.cmn.func.adhandler.d dVarA = com.opos.mobad.cmn.func.adhandler.d.a(c(), adItemData, aVar, new C0724a(adItemData, eVarD), aVar2, cVar, str, !TextUtils.isEmpty(adItemData.ah()) ? adItemData.ah() : null);
        e eVar = new e(this.f8642a, eVarD, adItemData, dVar, bVar);
        eVar.a(this.g);
        eVar.a(this.h);
        dVarA.a(eVar).a(bVar);
        eVarD.a(aVar, iArr).b(com.opos.mobad.d.c.e.a(c(), view2 != null ? view2 : view)).a(view != null ? com.opos.mobad.d.c.e.c(view) : com.opos.mobad.d.c.e.c(view2)).a(com.opos.mobad.d.c.e.d(view2)).b(com.opos.mobad.d.c.e.b(view)).a(z).a(view).a(materialData.n());
        if (num != null && (aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT || aVar == com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_SHAKE)) {
            eVarD.c(num.intValue());
        }
        if (map != null && !map.isEmpty()) {
            eVarD.a(map);
            eVarD.b(map);
        }
        if (num2 != null) {
            eVarD.b(num2.intValue());
        }
        if (bool != null) {
            eVarD.c(bool.booleanValue());
        }
        if (l != null && l.longValue() > 0) {
            eVarD.a(l.longValue());
        }
        dVarA.a(eVarD.a());
        if (!com.opos.mobad.cmn.func.b.g.a(this.f8642a, adItemData, aVar) || (cVar2 = this.c) == null) {
            this.b.a(dVarA);
        } else {
            cVar2.a(new b() { // from class: com.opos.mobad.cmn.func.adhandler.a.1
                @Override // com.opos.mobad.cmn.func.adhandler.a.b
                public void a() {
                    com.opos.cmn.an.f.a.b("AdHandler", "download success:");
                    com.opos.mobad.cmn.func.b.g.a(false);
                    a.this.b.a(dVarA);
                }

                @Override // com.opos.mobad.cmn.func.adhandler.a.b
                public void b() {
                    com.opos.cmn.an.f.a.b("AdHandler", "download cancel");
                    if (dVarA.d != null) {
                        b.e eVar2 = new b.e();
                        eVar2.a(dVarA);
                        eVar2.a(new b.c(7, -1));
                        dVarA.d.a(eVar2);
                    }
                }
            });
        }
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, View view, com.opos.mobad.cmn.func.b.a aVar, View view2, c.b bVar, Integer num, Integer num2, Boolean bool, Long l, Map<String, String> map) {
        a(adItemData, z, iArr, view, aVar, view2, bVar, null, null, null, null, num, num2, bool, l, map);
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, View view, com.opos.mobad.cmn.func.b.a aVar, View view2, String str, com.opos.mobad.p.c cVar, boolean z2, Long l, Map<String, String> map) {
        a(adItemData, z, iArr, view, aVar, view2, null, null, cVar, str, null, null, null, Boolean.valueOf(z2), l, map);
    }

    public void a(AdItemData adItemData, boolean z, int[] iArr, View view, com.opos.mobad.cmn.func.b.a aVar, View view2, boolean z2, c.b bVar) {
        a(adItemData, z, iArr, view, aVar, view2, bVar, null, null, null, null, null, null, Boolean.valueOf(z2), null, null);
    }
}
