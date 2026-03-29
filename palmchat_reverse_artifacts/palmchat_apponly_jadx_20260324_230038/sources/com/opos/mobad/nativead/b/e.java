package com.opos.mobad.nativead.b;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.ad.e.o;
import com.opos.mobad.ad.e.p;
import com.opos.mobad.ad.j;
import com.opos.mobad.cmn.func.adhandler.a;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.cmn.service.pkginstall.c;
import com.opos.mobad.j.f;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e extends j.a implements p, com.opos.mobad.ad.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f9140a;
    private AdItemData b;
    private MaterialData c;
    private f d;
    private com.opos.mobad.template.a e;
    private o f;
    private a.c g;
    private com.opos.mobad.ad.privacy.b h;
    private String i;
    private com.opos.mobad.ui.feedback.a j;
    private com.opos.mobad.cmn.func.adhandler.a k;
    private Object l;
    private c.b m = new c.b() { // from class: com.opos.mobad.nativead.b.e.1
        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("NativeTemplateAdViewImpl", "notifyInstallCompletedEvent:" + str);
            e.this.a(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.c.b
        public void c(AdItemData adItemData, String str) {
        }
    };
    private f.a n = new f.a() { // from class: com.opos.mobad.nativead.b.e.2
        @Override // com.opos.mobad.cmn.func.a.a.b
        public void a(int i, String str) {
            if (e.this.f != null) {
                e.this.f.onRenderFailed(f.a(i, str), e.this);
            }
        }

        @Override // com.opos.mobad.cmn.func.a.a.b
        public void d() {
            e.this.e.d();
            if (e.this.f != null) {
                e.this.f.onAdClose(e.this);
            }
        }

        @Override // com.opos.mobad.j.a.InterfaceC0748a
        public void g_() {
            if (e.this.f != null) {
                e.this.f.onRenderSuccess(e.this);
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            e.this.f.onAdClick(e.this);
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            if (e.this.f != null) {
                e.this.f.onAdShow(e.this);
            }
            if (e.this.b == null || e.this.b.V() == null) {
                return;
            }
            e.this.j.a(e.this.b.V());
        }

        @Override // com.opos.mobad.j.d.a
        public void a(long j) {
        }

        @Override // com.opos.mobad.j.d.a
        public void a(String str) {
        }

        @Override // com.opos.mobad.j.d.a
        public void b() {
        }

        @Override // com.opos.mobad.j.d.a
        public void c() {
        }

        @Override // com.opos.mobad.ad.k
        public void onReward(Object... objArr) {
        }
    };

    public e(com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, String str, com.opos.mobad.cmn.func.adhandler.a aVar, com.opos.mobad.template.a aVar2, o oVar, com.opos.mobad.cmn.a.b bVar2, String str2, com.opos.mobad.template.l.a aVar3) {
        this.f9140a = bVar;
        this.k = aVar;
        this.b = adItemData;
        this.c = materialData;
        this.e = aVar2;
        this.f = oVar;
        this.h = new com.opos.mobad.cmn.a.d(bVar2);
        com.opos.mobad.ui.feedback.a aVar4 = new com.opos.mobad.ui.feedback.a(bVar.b(), null);
        this.j = aVar4;
        this.d = new f(bVar, adItemData, materialData, str, aVar, aVar4, aVar2, this.m, this.n, this.h, aVar3);
        a.c cVarA = g.a(bVar.b(), aVar2.c());
        this.g = cVarA;
        aVar.a(cVarA);
        this.i = str2;
    }

    @Override // com.opos.mobad.ad.e.p
    public View a() {
        View viewC = this.e.c();
        if (viewC != null && Build.VERSION.SDK_INT >= 29) {
            viewC.setForceDarkAllowed(false);
            com.opos.cmn.an.f.a.b("NativeTemplateAdViewImpl", "get Ad view set force");
        }
        return viewC;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        return this.b.ac();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        return this.b.ad();
    }

    @Override // com.opos.mobad.ad.e.p
    public String g() {
        return this.i;
    }

    @Override // com.opos.mobad.ad.f
    public void setDlClickListener(com.opos.mobad.ad.g gVar) {
        com.opos.mobad.cmn.func.adhandler.a aVar = this.k;
        if (aVar != null) {
            aVar.a(gVar);
        }
    }

    @Override // com.opos.mobad.ad.e.p
    public void b() {
        this.d.a();
    }

    @Override // com.opos.mobad.ad.e.p
    public void c() {
        this.e.d();
        this.d.b();
        a.c cVar = this.g;
        if (cVar != null) {
            cVar.a();
        }
        this.h.a();
    }

    @Override // com.opos.mobad.ad.e.p
    public Object d() {
        return this.l;
    }

    @Override // com.opos.mobad.ad.e.p
    public void a(Object obj) {
        this.l = obj;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        this.d.b(i);
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("NativeTemplateAdViewImpl", "notifyInstallCompletedEvent pkgname =" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.c.i()) || !this.c.i().equals(str)) {
            return;
        }
        this.d.a(str);
    }
}
