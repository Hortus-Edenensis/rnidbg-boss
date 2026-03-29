package com.opos.mobad.splash;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.ad.privacy.b;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.splash.f;
import com.opos.mobad.ui.b.e;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
class b extends com.opos.mobad.j.f {
    private final com.opos.mobad.b f;
    private f.a g;
    private boolean h;
    private com.opos.mobad.template.a i;
    private String j;
    private Activity k;
    private com.opos.mobad.cmn.a.d l;
    private final FrameLayout m;
    private Dialog n;
    private final long o;

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, d dVar) {
        this(bVar, str, aVar, dVar, null);
    }

    private void c() {
        Activity activity;
        Dialog dialog = this.n;
        if (dialog == null || !dialog.isShowing() || (activity = this.k) == null || activity.isFinishing() || this.k.isDestroyed()) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "dialog not dismiss for finishing");
        } else {
            this.n.dismiss();
        }
    }

    private void g() {
        c();
        com.opos.mobad.cmn.a.d dVar = this.l;
        if (dVar != null) {
            dVar.a();
            this.l = null;
        }
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void e(View view, int[] iArr) {
        this.f8949a.b(true, iArr, this.d);
    }

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, d dVar, com.opos.mobad.cmn.a.b bVar2) {
        super(bVar, str, aVar, null, dVar);
        this.g = null;
        this.h = false;
        this.o = 500L;
        com.opos.mobad.b bVarC = bVar.c();
        this.f = bVarC;
        this.j = str;
        if (bVar2 != null) {
            this.l = new com.opos.mobad.cmn.a.d(bVar2);
        }
        this.m = new FrameLayout(bVarC.b());
    }

    public View a() {
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "getSplashView" + this.i);
        return this.m;
    }

    @Override // com.opos.mobad.j.f
    public void b() {
        if (this.h) {
            return;
        }
        synchronized (b.class) {
            super.b();
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "destroy");
            com.opos.mobad.template.a aVar = this.i;
            if (aVar != null) {
                aVar.d();
            }
            g();
            this.k = null;
            this.h = true;
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void c(View view, int[] iArr) {
        ComplianceInfo complianceInfoA = com.opos.mobad.cmn.func.b.a(this.g.b.c);
        if (complianceInfoA == null) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "show per but null data");
            return;
        }
        Activity activity = this.k;
        if (activity != null && !activity.isFinishing()) {
            a(this.k, complianceInfoA.b(), R.string.opos_mob_permission_title);
            return;
        }
        com.opos.mobad.cmn.a.d dVar = this.l;
        if (dVar != null) {
            a(dVar, 1);
        } else {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "error activity");
        }
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void d(long j, long j2) {
        long jA = this.g.a();
        if (j2 > 0) {
            jA = Math.min(j2, this.g.a());
        }
        super.d(j, jA);
        if (j2 <= this.g.a() + 500 || this.g.c) {
            return;
        }
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "report material video over time " + (this.g.a() + 500));
        this.g.c = true;
        this.f.i().a(this.g.b.d.X());
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void a(long j, long j2) {
        this.b.a(j2);
        this.f8949a.b(false, null, this.d);
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void b(View view, int[] iArr) {
        ComplianceInfo complianceInfoA = com.opos.mobad.cmn.func.b.a(this.g.b.c);
        if (complianceInfoA == null) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "show pri but null data");
            return;
        }
        Activity activity = this.k;
        if (activity != null && !activity.isFinishing()) {
            a(this.k, complianceInfoA.a(), R.string.opos_mob_privacy_title);
            return;
        }
        com.opos.mobad.cmn.a.d dVar = this.l;
        if (dVar != null) {
            a(dVar, 0);
        } else {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "error activity");
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void d(View view, int[] iArr) {
        ComplianceInfo complianceInfoA = com.opos.mobad.cmn.func.b.a(this.g.b.c);
        if (complianceInfoA == null) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "show desc but null data");
            return;
        }
        Activity activity = this.k;
        if (activity != null && !activity.isFinishing()) {
            a(this.k, complianceInfoA.c(), R.string.opos_mob_app_desc_title);
            return;
        }
        com.opos.mobad.cmn.a.d dVar = this.l;
        if (dVar != null) {
            a(dVar, 2);
        } else {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "error activity");
        }
    }

    public void a(Activity activity) {
        this.k = activity;
    }

    @Override // com.opos.mobad.j.f, com.opos.mobad.template.a.InterfaceC0778a
    public void b(Map<String, String> map) {
        int i;
        super.b(map);
        try {
            i = Integer.parseInt(map.get("errCode"));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("InterSplash$Presenter", "onError", e);
            i = 0;
        }
        a(i);
    }

    private void a(Activity activity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.a("InterSplash$Presenter", "illegal url");
            return;
        }
        this.i.a();
        c();
        this.n = com.opos.mobad.ui.b.e.a(activity, activity.getString(i), str, new e.b() { // from class: com.opos.mobad.splash.b.2
            @Override // com.opos.mobad.ui.b.e.b
            public void a() {
                if (b.this.h) {
                    return;
                }
                b.this.i.b();
            }
        });
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(View view, int[] iArr) {
    }

    private void a(com.opos.mobad.cmn.a.d dVar, int i) {
        ComplianceInfo complianceInfoA = com.opos.mobad.cmn.func.b.a(this.g.b.c);
        this.i.a();
        dVar.a(this.f.b(), i, complianceInfoA, new b.a() { // from class: com.opos.mobad.splash.b.3
            @Override // com.opos.mobad.ad.privacy.b.a
            public void a() {
                if (b.this.h) {
                    return;
                }
                b.this.i.b();
            }
        });
    }

    public void a(f.a aVar, com.opos.mobad.template.a aVar2, com.opos.mobad.template.e eVar, com.opos.mobad.template.d dVar, String str) {
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "createSplash");
        if (aVar == null) {
            com.opos.cmn.an.f.a.c("InterSplash$Presenter", "create splash failed,splashVo Data is null!");
            return;
        }
        if (aVar2 == null) {
            com.opos.cmn.an.f.a.c("InterSplash$Presenter", "create splash failed,ad template is null!");
            return;
        }
        this.i = aVar2;
        aVar2.a(this);
        this.g = aVar;
        AdHelper.AdHelperData adHelperData = aVar.b;
        a(adHelperData.c, adHelperData.d, aVar.a(), this.i.e(), str);
        this.i.a(f.a(this.f, aVar, eVar, dVar, this.i.e()));
        this.m.removeAllViews();
        this.m.addView(aVar2.c(), new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.template.a.InterfaceC0778a
    public void a(Map<String, String> map) {
        super.a(this.i.c(), map);
    }

    @Override // com.opos.mobad.j.f
    public boolean a(View view, final int[] iArr, com.opos.mobad.cmn.func.b.a aVar) {
        boolean zA = super.a(view, iArr, aVar);
        if (zA) {
            com.opos.mobad.template.a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a();
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.splash.b.1
                @Override // java.lang.Runnable
                public void run() {
                    ((com.opos.mobad.j.f) b.this).f8949a.b(false, iArr, ((com.opos.mobad.j.f) b.this).d);
                }
            }, 100L);
        }
        return zA;
    }
}
