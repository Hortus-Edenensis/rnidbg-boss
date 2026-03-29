package com.opos.mobad.video.player.e;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.heytap.msp.mobad.api.R;
import com.opos.cmn.i.n;
import com.opos.mobad.ad.k;
import com.opos.mobad.cmn.func.adhandler.a;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.template.a;
import com.opos.mobad.template.h.aj;
import com.opos.mobad.ui.b.e;
import com.opos.mobad.video.player.b;
import com.opos.mobad.video.player.c.a;
import com.opos.mobad.video.player.c.a.a;
import com.wifi.ad.core.p001const.WifiNestConst;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a extends com.opos.mobad.j.f {
    private InterfaceC0815a A;
    private n B;
    private boolean C;
    protected Activity f;
    protected com.opos.mobad.b g;
    protected AdItemData h;
    protected MaterialData i;
    protected b j;
    protected com.opos.mobad.template.d.f k;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    protected long o;
    private com.opos.mobad.video.player.c p;
    private com.opos.mobad.p.a q;
    private com.opos.mobad.video.player.g.e r;
    private com.opos.mobad.cmn.func.adhandler.a s;
    private int t;
    private e u;
    private f v;
    private boolean w;
    private boolean x;
    private final int y;
    private boolean z;

    /* JADX INFO: renamed from: com.opos.mobad.video.player.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0815a {
        void a(int i, String str, Map<String, String> map);
    }

    public a(d dVar) {
        super(dVar.b().c(), dVar.c(), dVar.d(), dVar.f(), dVar.f());
        this.k = null;
        this.l = false;
        this.n = false;
        this.o = -1L;
        this.t = 1;
        this.x = false;
        this.z = false;
        this.A = null;
        this.C = false;
        this.g = dVar.b().c();
        this.f = dVar.a();
        this.j = dVar.e();
        this.q = dVar.g();
        this.r = dVar.f();
        this.y = dVar.h();
        this.j.f.a(new b.InterfaceC0807b() { // from class: com.opos.mobad.video.player.e.a.1
            @Override // com.opos.mobad.video.player.b.InterfaceC0807b
            public void a(View view, int[] iArr) {
                if (a.this.u == null || !a.this.u.d()) {
                    a.this.d(iArr);
                    return;
                }
                a.this.k.i("EXT_PARAM_KEY_E_COMMERCE_DIALOG_CLOSE", "1");
                a aVar = a.this;
                aVar.j.b.a(aVar.k);
            }

            @Override // com.opos.mobad.video.player.b.InterfaceC0807b
            public void b(View view, final int[] iArr) {
                if (a.this.u == null || !a.this.u.d()) {
                    a.this.r();
                } else {
                    com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.e(iArr);
                        }
                    }, 100L);
                }
            }
        });
        this.j.b.a(this);
        com.opos.mobad.template.a aVarN = n();
        if (aVarN != null) {
            aVarN.a(this);
        }
        com.opos.mobad.template.a aVar = this.j.d;
        if (aVar != null) {
            aVar.a(this);
        }
        this.j.g.a(new com.opos.mobad.ui.feedback.b() { // from class: com.opos.mobad.video.player.e.a.8
            @Override // com.opos.mobad.ui.feedback.b
            public void a(int i) {
                ((com.opos.mobad.j.f) a.this).f8949a.b(i);
                boolean z = i == com.opos.mobad.ui.feedback.a.a.TAG_BLOCK_CONTENT.a() || i == com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_COMPLAINT.a();
                a.this.k.b(z);
                a aVar2 = a.this;
                aVar2.j.b.a(aVar2.k);
                if (z) {
                    return;
                }
                a.this.g();
            }

            @Override // com.opos.mobad.ui.feedback.b
            public void b(boolean z) {
                a aVar2 = a.this;
                if (aVar2.j.b != null) {
                    if (z) {
                        aVar2.r();
                    } else {
                        aVar2.s();
                    }
                }
            }

            @Override // com.opos.mobad.ui.feedback.b
            public void a(boolean z) {
                a.this.r();
            }
        });
        if (v()) {
            this.u = new e();
        }
        b bVar = this.j;
        com.opos.mobad.video.player.c.a aVar2 = bVar.i;
        if (aVar2 != null) {
            aVar2.a(new a.InterfaceC0808a() { // from class: com.opos.mobad.video.player.e.a.9
                @Override // com.opos.mobad.video.player.c.a.InterfaceC0808a
                public void a() {
                    a aVar3 = a.this;
                    aVar3.a(aVar3.j.b.c());
                }

                @Override // com.opos.mobad.video.player.c.a.InterfaceC0808a
                public void b() {
                    if (a.this.B != null) {
                        a.this.B.a();
                    }
                }
            });
        } else if (bVar.j != null) {
            f fVar = new f(dVar.a(), dVar.e(), this);
            this.v = fVar;
            fVar.a(new a.b() { // from class: com.opos.mobad.video.player.e.a.10
                @Override // com.opos.mobad.video.player.c.a.a.b
                public boolean c() {
                    return a.this.w;
                }
            });
        }
        dVar.d().a(new a.d() { // from class: com.opos.mobad.video.player.e.a.11
            @Override // com.opos.mobad.cmn.func.adhandler.a.d
            public void a(int i) {
                com.opos.cmn.an.f.a.b("AdShowController", "rewardFromDeepLink onSuccess:" + i);
                if (a.this.d() && i == 5 && ((com.opos.mobad.j.f) a.this).c != null) {
                    ((com.opos.mobad.j.f) a.this).c.f();
                }
            }

            @Override // com.opos.mobad.cmn.func.adhandler.a.d
            public void a(int i, int i2) {
                com.opos.cmn.an.f.a.b("AdShowController", " rewardFromDeepLink onFailed:" + i + ";code:" + i2);
            }
        });
        dVar.d().a(new a.c() { // from class: com.opos.mobad.video.player.e.a.12
            @Override // com.opos.mobad.cmn.func.adhandler.a.c
            public void a() {
                a.this.j.f.a();
            }

            @Override // com.opos.mobad.cmn.func.adhandler.a.c
            public void a(final a.b bVar2) {
                a.this.s();
                a.this.j.f.a(new b.a() { // from class: com.opos.mobad.video.player.e.a.12.1
                    @Override // com.opos.mobad.video.player.b.a
                    public void a() {
                        a.this.r();
                        a.b bVar3 = bVar2;
                        if (bVar3 != null) {
                            bVar3.a();
                        }
                    }

                    @Override // com.opos.mobad.video.player.b.a
                    public void b() {
                        a.this.r();
                        a.b bVar3 = bVar2;
                        if (bVar3 != null) {
                            bVar3.b();
                        }
                    }
                });
            }
        });
        this.s = dVar.d();
    }

    private boolean A() {
        MaterialData materialData;
        if (this.h == null || (materialData = this.i) == null) {
            return false;
        }
        return materialData.Q() == 1 && n() != null;
    }

    private void B() {
        p();
        b bVar = this.j;
        if (bVar != null) {
            com.opos.mobad.video.player.g.d.f(bVar.d);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean C() {
        boolean z;
        int iA = com.opos.mobad.video.player.g.d.a(this.j.b);
        boolean z2 = iA == 7 || iA == 12 || iA == 13 || iA == 14 || iA == 15 || iA == 2007;
        boolean zM = this.g.n().m();
        boolean zD = this.h.D();
        MaterialData materialData = this.i;
        if (materialData != null) {
            boolean zA = g.a(this.h, materialData);
            FloatLayerData floatLayerDataR = this.i.R();
            String strF = floatLayerDataR == null ? this.i.f() : floatLayerDataR.b();
            String strG = floatLayerDataR == null ? this.i.g() : floatLayerDataR.c();
            MaterialFileData materialFileDataA = null;
            if (zA) {
                List<MaterialFileData> listE = floatLayerDataR == null ? this.i.e() : floatLayerDataR.d();
                if (listE != null && !listE.isEmpty()) {
                    materialFileDataA = listE.get(0);
                }
            } else if (floatLayerDataR != null) {
                materialFileDataA = floatLayerDataR.a();
            } else {
                List<MaterialFileData> listH = this.i.h();
                if (listH != null && !listH.isEmpty()) {
                    materialFileDataA = listH.get(0);
                }
            }
            String strA = materialFileDataA != null ? materialFileDataA.a() : "";
            z = !zA ? !(TextUtils.isEmpty(strA) || TextUtils.isEmpty(strF)) : !(TextUtils.isEmpty(strA) || TextUtils.isEmpty(strG));
        }
        boolean z3 = (!z2 || zM || !zD || l() || z) ? false : true;
        com.opos.cmn.an.f.a.b("AdShowController", "canShowInterstitialDialog()==>canShow=" + z3);
        return z3;
    }

    private boolean v() {
        return e.a(u()) && com.opos.mobad.video.player.g.c.a(this.y);
    }

    private void w() {
        this.C = false;
    }

    private void x() {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.video.player.e.a.4
            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                if (aVar.k == null) {
                    return;
                }
                if (((com.opos.mobad.j.f) aVar).d >= 0) {
                    boolean zD = ((com.opos.mobad.j.f) a.this).c.d();
                    a aVar2 = a.this;
                    aVar2.k.i("EXT_PARAM_KEY_COUNTDOWN", zD ? "0" : ((com.opos.mobad.j.f) aVar2).c.d(a.this.o));
                    a.this.q();
                }
                a aVar3 = a.this;
                aVar3.j.b.a(aVar3.k);
            }
        });
    }

    private void y() {
        com.opos.mobad.template.d.f fVar;
        if (this.k == null) {
            return;
        }
        int i = 0;
        if (this.c.d() && this.t == 0) {
            this.k.c(0);
            return;
        }
        if (this.t == 0) {
            fVar = this.k;
            i = 1;
        } else {
            fVar = this.k;
        }
        fVar.c(i);
    }

    private void z() {
        MaterialData materialData;
        if (this.h == null || (materialData = this.i) == null) {
            return;
        }
        int iQ = materialData.Q();
        if (iQ != 0) {
            if (iQ == 1) {
                k();
                return;
            } else {
                if (iQ != 2) {
                    m(null, null);
                    return;
                }
                return;
            }
        }
        if (!TextUtils.isEmpty(this.i.u())) {
            com.opos.mobad.cmn.func.adhandler.a aVar = this.s;
            if (aVar != null) {
                aVar.a(this.h, null, this.q);
            }
            com.opos.mobad.video.player.g.e eVar = this.r;
            if (eVar != null) {
                eVar.e();
            }
        }
        g();
    }

    public void d(int i) {
        this.t = i;
        if (this.k == null) {
            return;
        }
        y();
        this.j.b.a(this.k);
    }

    public void k() {
        com.opos.cmn.an.f.a.b("AdShowController", "showEndPage()");
        if (o()) {
            return;
        }
        com.opos.mobad.video.player.g.d.e(n());
        b bVar = this.j;
        if (bVar != null) {
            com.opos.mobad.video.player.g.d.b(bVar.b);
        }
        p();
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void l(View view, int[] iArr) {
        if (this.t != 0) {
            com.opos.cmn.an.f.a.b("AdShowController", "vip click but disable");
        } else if (this.c.g()) {
            m(view, iArr);
        }
    }

    public com.opos.mobad.template.d.f m() {
        return this.k;
    }

    public com.opos.mobad.template.a n() {
        b bVar = this.j;
        if (bVar != null) {
            return bVar.c;
        }
        return null;
    }

    public boolean o() {
        com.opos.mobad.template.a aVar;
        b bVar = this.j;
        if (bVar == null || (aVar = bVar.d) == null) {
            return false;
        }
        return com.opos.mobad.video.player.g.d.d(aVar);
    }

    public void p() {
        com.opos.cmn.an.f.a.b("AdShowController", "setHasShowedInterstialDialog()==>");
        this.k.i("EXT_PARAM_KEY_TYPE_INTER_EXIT_ANI", "0");
        this.x = true;
    }

    public void q() {
        com.opos.mobad.j.e eVar;
        com.opos.mobad.template.d.f fVar = this.k;
        if (fVar == null || (eVar = this.c) == null) {
            return;
        }
        fVar.f(eVar.c(this.o));
    }

    public void r() {
        if (this.m || this.n) {
            com.opos.cmn.an.f.a.b("AdShowController", "startAdTemplate() but ad has completed or has stopped.");
            return;
        }
        b bVar = this.j;
        if (bVar != null) {
            com.opos.mobad.video.player.g.d.c(bVar.b);
        }
    }

    public void s() {
        b bVar = this.j;
        if (bVar != null) {
            com.opos.mobad.video.player.g.d.b(bVar.b);
        }
    }

    public Context t() {
        com.opos.mobad.b bVar = this.g;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    public int u() {
        return com.opos.mobad.video.player.g.d.a(this.j.b);
    }

    private void f(int[] iArr) {
        com.opos.cmn.an.f.a.b("AdShowController", "showInterRetainEndPage()==>");
        com.opos.mobad.template.a aVar = this.j.d;
        if (aVar == null || this.x) {
            return;
        }
        com.opos.mobad.video.player.g.d.e(aVar);
        s();
        p();
    }

    public void a() {
    }

    @Override // com.opos.mobad.j.f
    public void b() {
        com.opos.cmn.an.f.a.b("AdShowController", "destroy");
        com.opos.mobad.video.player.g.e eVar = this.r;
        if (eVar != null) {
            eVar.d();
            eVar.a(this.d);
            com.opos.mobad.cmn.service.pkginstall.c.a(t()).a(eVar);
            this.r = null;
        }
        super.b();
        n nVar = this.B;
        if (nVar != null) {
            nVar.b();
        }
        b bVar = this.j;
        if (bVar != null) {
            bVar.a();
        }
        e eVar2 = this.u;
        if (eVar2 != null) {
            eVar2.a();
        }
        f fVar = this.v;
        if (fVar != null) {
            fVar.g();
        }
        if (this.A != null) {
            this.A = null;
        }
        if (this.f != null) {
            this.f = null;
        }
        com.opos.mobad.cmn.func.adhandler.a aVar = this.s;
        if (aVar != null) {
            aVar.b();
            this.s = null;
        }
    }

    public void c() {
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void d(long j, long j2) {
        super.d(j, j2);
        f fVar = this.v;
        if (fVar != null) {
            fVar.a(j, j2);
        }
        this.o = j2;
        x();
        a(j);
    }

    @Override // com.opos.mobad.j.f
    public void e() {
        if (!o()) {
            super.e();
        } else {
            r();
            B();
        }
    }

    public void g() {
        d((int[]) null);
    }

    public void h() {
        k(null, null);
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.p != null) {
                    a.this.p.a();
                }
            }
        });
    }

    public void i() {
        com.opos.mobad.template.a aVarN = n();
        if (aVarN != null) {
            com.opos.cmn.an.f.a.b("AdShowController", "doShow()", "endPageTemplateId=", Integer.valueOf(com.opos.mobad.video.player.g.d.a(aVarN)));
            j();
            com.opos.mobad.video.player.g.d.f(aVarN);
        }
    }

    public void j() {
        com.opos.mobad.template.a aVarN = n();
        if (aVarN != null) {
            com.opos.mobad.video.player.g.d.a(aVarN, m());
        }
    }

    public boolean l() {
        com.opos.mobad.template.a aVarN = n();
        if (aVarN == null) {
            return false;
        }
        return com.opos.mobad.video.player.g.d.d(aVarN);
    }

    public void m(View view, int[] iArr) {
        b(view, iArr, false);
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void a(int i) {
        super.a(i);
        if (this.y != 4) {
            this.j.f.b();
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void b(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("AdShowController", "onAppSafeClick");
        if (com.opos.cmn.i.b.a(this.f)) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal activity");
            return;
        }
        AppPrivacyData appPrivacyDataU = this.h.U();
        if (appPrivacyDataU == null || TextUtils.isEmpty(appPrivacyDataU.b)) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal url");
        } else {
            s();
            this.j.f.a(this.f.getString(R.string.opos_mob_privacy_title), appPrivacyDataU.b, new e.b() { // from class: com.opos.mobad.video.player.e.a.15
                @Override // com.opos.mobad.ui.b.e.b
                public void a() {
                    a.this.r();
                }
            });
        }
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void c(int i) {
        super.c(i);
        B();
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void d(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("AdShowController", "onAppIntroduceClick");
        if (com.opos.cmn.i.b.a(this.f)) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal activity");
            return;
        }
        AppPrivacyData appPrivacyDataU = this.h.U();
        if (appPrivacyDataU == null || TextUtils.isEmpty(appPrivacyDataU.f)) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal url");
        } else {
            s();
            this.j.f.a(this.f.getString(R.string.opos_mob_app_desc_title), appPrivacyDataU.f, new e.b() { // from class: com.opos.mobad.video.player.e.a.3
                @Override // com.opos.mobad.ui.b.e.b
                public void a() {
                    a.this.r();
                }
            });
        }
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void e(View view, int[] iArr) {
        if (!C() || this.x) {
            c(iArr);
        } else {
            f(iArr);
        }
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void g(View view, int[] iArr) {
        super.g(view, iArr);
        x();
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void h(View view, int[] iArr) {
        super.h(view, iArr);
        x();
    }

    private void d(AdItemData adItemData, MaterialData materialData) {
        if (this.j.d != null) {
            if (this.i.R() == null) {
                this.k.l(materialData.f());
                this.k.k(materialData.g());
                this.k.j(com.opos.mobad.model.a.a(t(), this.h, materialData, this.l));
                List<MaterialFileData> listE = materialData.e();
                if (listE != null && !listE.isEmpty()) {
                    for (MaterialFileData materialFileData : listE) {
                        this.k.b(materialFileData.a(), materialFileData.b());
                    }
                }
                List<MaterialFileData> listH = materialData.h();
                if (listH != null && !listH.isEmpty()) {
                    this.k.h(listH.get(0).a(), listH.get(0).b());
                }
            }
            this.k.i("EXT_PARAM_KEY_TYPE_LINK", g.a(adItemData, materialData) ? "1" : "0");
            this.k.i("EXT_PARAM_KEY_TYPE_INTER_EXIT_ANI", "1");
            this.k.i("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR", com.opos.cmn.an.h.f.a.a(this.f) ? "0" : "1");
            this.j.d.a(this.k);
            this.j.d.c().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int[] iArr) {
        com.opos.cmn.an.f.a.b("AdShowController", "clickECommerceDialogBtn()");
        a((View) null, iArr, com.opos.mobad.cmn.func.b.a.E_COMMERCE_DIALOG_BTN);
        e eVar = this.u;
        if (eVar != null) {
            eVar.h();
        }
    }

    public void a(int i, String str, AdItemData adItemData, MaterialData materialData, Map<String, String> map) {
        com.opos.mobad.cmn.func.b.e.a(this.g, adItemData != null ? adItemData.g() : "", adItemData, materialData, true, String.valueOf(u()), com.opos.mobad.cmn.func.b.e.a(com.opos.mobad.j.f.b(i, com.opos.mobad.mediaplayer.a.c.c(map)), str, map));
    }

    public void b(View view, int[] iArr, final boolean z) {
        try {
            super.e(view, iArr);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdShowController", "onCloseClick()", e);
        }
        final com.opos.mobad.video.player.g.e eVar = this.r;
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.a.5
            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.video.player.g.e eVar2;
                try {
                    if (a.this.p != null) {
                        a.this.p.a();
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("AdShowController", "onClose", e2);
                }
                if (!z || (eVar2 = eVar) == null) {
                    return;
                }
                eVar2.a();
            }
        });
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void c(long j, long j2) {
        super.c(j, j2);
        f fVar = this.v;
        if (fVar != null) {
            fVar.b(j, j2);
        }
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void a(int i, int[] iArr) {
        try {
            switch (i) {
                case 2:
                    d(iArr);
                    break;
                case 3:
                    r();
                    a((View) null, iArr, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_INTERSTITIAL_RETAIN);
                    B();
                    break;
                case 4:
                    b((View) null, iArr, true);
                    break;
                case 5:
                default:
                    return;
                case 6:
                    a((View) null, iArr, com.opos.mobad.cmn.func.b.a.OUT_COUPONS);
                    break;
                case 7:
                    e eVar = this.u;
                    if (eVar != null && eVar.d()) {
                        this.k.i("EXT_PARAM_KEY_E_COMMERCE_DIALOG_CLOSE", "1");
                        this.j.b.a(this.k);
                        this.u.i();
                    }
                    break;
                case 8:
                    e(iArr);
                    break;
                case 9:
                    c(iArr);
                    break;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("AdShowController", "onInteractionClick()", e);
        }
    }

    public void b(AdItemData adItemData, MaterialData materialData) {
        this.k.i("EXT_PARAM_KEY_SHOW_ENDPAGE", A() ? "1" : "0");
        this.k.g(this.c.a(t(), adItemData, false));
        this.k.i("EXT_PARAM_KEY_TYPE_INTER_STATUSBAR", com.opos.cmn.an.h.f.a.a(this.f) ? "0" : "1");
        if (v()) {
            e eVar = this.u;
            if (eVar != null) {
                eVar.b();
            }
            this.k.i("EXT_PARAM_KEY_E_COMMERCE_DIALOG_COUNTDOWN", String.valueOf(this.u.c()));
        }
        this.j.b.a(this.k);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void c(View view, int[] iArr) {
        com.opos.cmn.an.f.a.b("AdShowController", "onAppPermissionClick");
        if (com.opos.cmn.i.b.a(this.f)) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal activity");
            return;
        }
        AppPrivacyData appPrivacyDataU = this.h.U();
        if (appPrivacyDataU == null || TextUtils.isEmpty(appPrivacyDataU.f9081a)) {
            com.opos.cmn.an.f.a.a("AdShowController", "illegal url");
        } else {
            s();
            this.j.f.a(this.f.getString(R.string.opos_mob_permission_title), appPrivacyDataU.f9081a, new e.b() { // from class: com.opos.mobad.video.player.e.a.2
                @Override // com.opos.mobad.ui.b.e.b
                public void a() {
                    a.this.r();
                }
            });
        }
    }

    public void d(int[] iArr) {
        m(null, iArr);
    }

    private void a(long j) {
        if (this.j.i == null || this.B != null) {
            return;
        }
        com.opos.cmn.an.f.a.b("AdShowController", "showLightInteractiveIfNeed() position=", Long.valueOf(j));
        if (this.i.ad() == null || j < r0.f9087a) {
            return;
        }
        this.j.i.b();
        n nVar = new n(com.opos.mobad.d.c.c.a(), new Runnable() { // from class: com.opos.mobad.video.player.e.a.14
            @Override // java.lang.Runnable
            public void run() {
                a.this.j.i.d();
            }
        });
        this.B = nVar;
        nVar.a(r0.b);
    }

    public void b(AdItemData adItemData, String str) {
        com.opos.cmn.an.f.a.b("AdShowController", "notifyInstallComplete");
        this.c.b(adItemData, str);
        this.l = true;
        com.opos.mobad.template.d.f fVar = this.k;
        if (fVar == null) {
            return;
        }
        fVar.d(com.opos.mobad.model.a.a(t(), adItemData, this.i, this.l, false, this.c.d()));
        x();
        this.k.j(com.opos.mobad.model.a.a(t(), adItemData, this.i, this.l, true, this.c.d()));
        j();
    }

    public void c(AdItemData adItemData, MaterialData materialData) {
        if (this.k == null) {
            this.k = com.opos.mobad.model.a.a(t(), this.g, adItemData, materialData, this.l, u());
        }
    }

    @Override // com.opos.mobad.j.f
    public boolean d() {
        e eVar = this.u;
        if (eVar == null || !eVar.d()) {
            return super.d();
        }
        return false;
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void a(long j, long j2) {
        super.a(j, j2);
        f fVar = this.v;
        if (fVar != null) {
            fVar.c(j, j2);
        }
        this.k.d(2);
        this.k.i("EXT_PARAM_KEY_COUNTDOWN", this.c.d() ? "0" : this.c.d(this.o));
        q();
        this.j.b.a(this.k);
        this.m = true;
        z();
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void b(Map<String, String> map) {
        int i;
        String str;
        InterfaceC0815a interfaceC0815a;
        try {
            i = Integer.parseInt(map.get("errCode"));
        } catch (Exception e) {
            e = e;
            i = 0;
        }
        try {
            str = map.get(WifiNestConst.OtherConst.KEY_MSG);
        } catch (Exception e2) {
            e = e2;
            com.opos.cmn.an.f.a.d("AdShowController", "onError", e);
            str = "";
        }
        String strC = com.opos.mobad.mediaplayer.a.c.c(map);
        com.opos.cmn.an.f.a.b("AdShowController", "onError code=", Integer.valueOf(i), ", msg=", str);
        if (!this.z && this.o <= 0 && com.opos.mobad.video.player.g.c.a(this.y) && com.opos.mobad.video.player.g.c.a(i, str, strC) && (interfaceC0815a = this.A) != null) {
            this.z = true;
            interfaceC0815a.a(i, str, map);
            return;
        }
        super.b(map);
        f fVar = this.v;
        if (fVar != null) {
            fVar.a(i, str);
        }
        if (com.opos.mobad.model.utils.e.a(this.h, this.i)) {
            return;
        }
        this.j.f.b();
    }

    public void c(int[] iArr) {
        CharSequence charSequenceB;
        CharSequence charSequenceC;
        e eVar = this.u;
        if (eVar != null && eVar.d() && !this.u.e()) {
            MaterialData materialData = this.i;
            a(this.u.a(materialData != null ? materialData.f() : ""), this.u.f(), this.u.g());
            return;
        }
        if (!this.g.n().l()) {
            com.opos.cmn.an.f.a.b("AdShowController", "showRWCloseDialog() but not allow show close dialog");
            d(iArr);
            return;
        }
        CharSequence charSequenceB2 = this.c.b(this.o);
        if (TextUtils.isEmpty(charSequenceB2)) {
            d(iArr);
            return;
        }
        e eVar2 = this.u;
        if (eVar2 == null || !eVar2.d()) {
            charSequenceB = this.c.b();
            charSequenceC = this.c.c();
        } else {
            MaterialData materialData2 = this.i;
            charSequenceB2 = this.u.a(materialData2 != null ? materialData2.f() : "");
            charSequenceB = this.u.f();
            charSequenceC = this.u.g();
        }
        a(charSequenceB2, charSequenceB, charSequenceC);
    }

    private void b(boolean z) {
        if (z) {
            try {
                if (1 == com.opos.cmn.an.h.b.a.b(t()) || com.opos.cmn.an.h.b.a.b(t()) == 0) {
                    a(false);
                    return;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("AdShowController", "", (Throwable) e);
                return;
            }
        }
        a(true);
    }

    public void a(Configuration configuration) {
        com.opos.mobad.template.a aVar = this.j.b;
        if (aVar instanceof aj) {
            ((aj) aVar).i();
        }
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void a(View view, int i, boolean z) {
        com.opos.cmn.an.f.a.b("AdShowController", "onViewMockEventIntercept() view=", view.getClass().getName(), "clickMockEvent=", Integer.valueOf(i), "disAllowClick=", Boolean.valueOf(z));
        com.opos.mobad.j.a aVar = this.f8949a;
        if (aVar != null) {
            aVar.a(view, i, z);
        }
    }

    public boolean b(View view, int[] iArr, com.opos.mobad.cmn.func.b.a aVar) {
        boolean z = this.j.h;
        boolean zA = super.a(view, iArr, aVar);
        if (z && !zA && aVar == com.opos.mobad.cmn.func.b.a.VIDEO && !this.m) {
            if (this.n) {
                b bVar = this.j;
                if (bVar != null) {
                    com.opos.mobad.video.player.g.d.c(bVar.b);
                }
            } else {
                b bVar2 = this.j;
                if (bVar2 != null) {
                    com.opos.mobad.video.player.g.d.b(bVar2.b);
                }
            }
            this.n = !this.n;
        }
        return zA;
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(View view, int[] iArr) {
        if (this.j.g != null) {
            s();
            b bVar = this.j;
            bVar.g.a(bVar.b.c());
        }
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void a(View view, int[] iArr, boolean z) {
        com.opos.cmn.an.f.a.b("AdShowController", "onSoundClick()", "preSoundOn=", Boolean.valueOf(z));
        this.k.d(!z ? 1 : 0);
        this.j.b.a(this.k);
    }

    @Override // com.opos.mobad.j.f
    public void a(k kVar, Object... objArr) {
        if (this.c.d()) {
            this.k.d(com.opos.mobad.model.a.a(t(), this.h, this.i, this.l, false, true));
            this.k.c(0);
            this.k.i("EXT_PARAM_KEY_COUNTDOWN", "0");
            this.k.i("EXT_PARAM_KEY_REWARD", "1");
            this.j.b.a(this.k);
        }
        super.a(kVar, objArr);
    }

    public void a(AdItemData adItemData, MaterialData materialData) {
        com.opos.cmn.an.f.a.b("AdShowController", "doShow");
        c(adItemData, materialData);
        w();
        y();
        i();
        d(adItemData, materialData);
        b(adItemData, materialData);
        this.n = false;
        this.m = false;
    }

    public void a(AdItemData adItemData, String str) {
        this.c.a(adItemData, str);
        x();
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void a(a.b bVar, Map<String, String> map) {
        com.opos.mobad.j.e eVar;
        if (v()) {
            if (this.u == null) {
                this.u = new e();
            }
            this.u.a(bVar, map);
            e eVar2 = this.u;
            if (eVar2 != null && eVar2.d() && bVar == a.b.E_COMMERCE_DIALOG_RESUME) {
                this.u.i();
                if (e.a(u())) {
                    this.k.i("EXT_PARAM_KEY_E_COMMERCE_DIALOG_COUNTDOWN", String.valueOf(this.u.c()));
                }
                if (this.u.e() && (eVar = this.c) != null) {
                    eVar.e();
                }
                com.opos.mobad.j.e eVar3 = this.c;
                if (eVar3 != null) {
                    this.k.i("EXT_PARAM_KEY_COUNTDOWN", eVar3.d() ? "0" : this.c.d(this.o));
                    this.k.f(this.c.c(this.o));
                }
                this.j.b.a(this.k);
            }
        }
    }

    public void a(InterfaceC0815a interfaceC0815a) {
        this.A = interfaceC0815a;
    }

    private void a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        s();
        this.j.f.a(charSequence, charSequence2, charSequence3);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(Map<String, String> map) {
        super.a(this.j.b.c(), map);
    }

    public void a(boolean z) {
        if (this.m) {
            return;
        }
        this.k.d(z ? 1 : 0);
        this.j.b.a(this.k);
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void a(int[] iArr) {
        super.a(iArr);
        e eVar = this.u;
        if (eVar == null || !eVar.d()) {
            return;
        }
        this.u.h();
    }

    public boolean a(int i, KeyEvent keyEvent) {
        if (i != 4) {
            if (i == 24) {
                b(false);
            } else if (i == 25) {
                b(true);
            }
            return false;
        }
        if (o()) {
            r();
            B();
            return true;
        }
        com.opos.mobad.video.player.c.a aVar = this.j.i;
        if (aVar == null || !aVar.c()) {
            c((int[]) null);
        }
        return true;
    }

    @Override // com.opos.mobad.j.f
    public boolean a(View view, int[] iArr, com.opos.mobad.cmn.func.b.a aVar) {
        int i;
        this.w = true;
        boolean zB = b(view, iArr, aVar);
        if (zB && ((i = this.y) == 2 || i == 3)) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.video.player.e.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.h();
                    com.opos.cmn.an.f.a.a("AdShowController", "close ad after click");
                }
            }, 500L);
        }
        return zB;
    }

    public boolean a(final AdItemData adItemData, final MaterialData materialData, int i, com.opos.mobad.video.player.c cVar) {
        this.h = adItemData;
        this.i = materialData;
        this.l = com.opos.cmn.an.h.d.a.d(t(), this.i.i());
        this.p = cVar;
        com.opos.mobad.template.a aVarN = n();
        a(adItemData, materialData, materialData.s(), com.opos.mobad.video.player.g.d.a(this.j.b), aVarN != null ? aVarN.e() : 0, adItemData.a());
        b(i);
        this.z = false;
        if (System.currentTimeMillis() > adItemData.u()) {
            com.opos.cmn.an.f.a.b("AdShowController", "show() exp time");
            a(10003);
            return false;
        }
        if (this.j.e && adItemData.t() == 2 && !com.opos.cmn.an.h.c.a.e(t()) && com.opos.mobad.video.player.g.f.a(adItemData)) {
            this.j.f.b(new b.a() { // from class: com.opos.mobad.video.player.e.a.13
                @Override // com.opos.mobad.video.player.b.a
                public void a() {
                    com.opos.mobad.video.player.g.f.a(false);
                    a.this.a(adItemData, materialData);
                }

                @Override // com.opos.mobad.video.player.b.a
                public void b() {
                    a.this.g();
                }
            });
            return true;
        }
        a(adItemData, materialData);
        return true;
    }
}
