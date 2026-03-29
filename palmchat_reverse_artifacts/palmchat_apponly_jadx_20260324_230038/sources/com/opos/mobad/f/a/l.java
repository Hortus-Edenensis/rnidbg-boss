package com.opos.mobad.f.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.g.f;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.c;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class l extends com.opos.mobad.m.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.g.f f8876a;
    private String b;
    private RelativeLayout c;
    private ViewGroup d;
    private Context g;
    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.b> h;
    private RelativeLayout i;
    private com.opos.mobad.f.b j;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.g.c {
        private final int b;

        public a(int i, com.opos.mobad.f.a.a.p pVar) {
            super(i, pVar);
            this.b = i;
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            l.this.d("ad click:" + this.b + "," + l.this.h.i());
            if (this.b != l.this.h.j()) {
                return;
            }
            com.opos.mobad.c.b.f().b(l.this.b);
            l.this.m();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdClose() {
            l.this.d("ad close:" + this.b + "," + l.this.h.i());
            if (this.b != l.this.h.j()) {
                return;
            }
            l.this.n();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            l.this.d("ad failed:" + i + ",msg:" + str + ", state=" + l.this.c());
            if (1 == l.this.c()) {
                super.onAdFailed(i, str);
                return;
            }
            if (2 == l.this.c() && this.b == l.this.h.j()) {
                l.this.d(i, str);
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.f.a.l.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (l.this.c() == 5) {
                            l.this.d("onFail to destroy view but destroy state");
                        } else {
                            l.this.s();
                        }
                    }
                });
                return;
            }
            l.this.d("ignore fail:" + this.b);
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            l.this.d("ad show");
            if (this.b != l.this.h.j()) {
                return;
            }
            com.opos.mobad.c.b.f().a(l.this.b);
            l.this.e(str);
        }
    }

    public l(final Activity activity, final String str, com.opos.mobad.ad.g.f fVar, com.opos.mobad.ad.g.c cVar, final com.opos.mobad.f.b bVar) {
        super(cVar);
        if (fVar == null) {
            com.opos.cmn.an.f.a.c("SplashAdDelegator", "SplashAd params null.");
            d(-1, "SplashAd params null.");
            return;
        }
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            com.opos.cmn.an.f.a.c("SplashAdDelegator", "SplashAd constructor param activity error.");
            d(-1, "SplashAd Constructor param Activity was died.");
            return;
        }
        if (!com.opos.cmn.an.h.f.a.a(activity)) {
            com.opos.cmn.an.f.a.c("SplashAdDelegator", "SplashAd must be displayed in full screen mode.");
            d(-1, "SplashAd must be displayed in full screen mode.");
            return;
        }
        this.b = str;
        this.g = activity.getApplicationContext();
        this.f8876a = a(fVar);
        this.c = new RelativeLayout(this.g);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
        this.d = viewGroup;
        this.j = bVar;
        if (viewGroup == null) {
            com.opos.cmn.an.f.a.c("SplashAdDelegator", "SplashAd must has contentView.");
            d(-1, "SplashAd must has contentView.");
        } else if (a(this.f8876a.e.getAppLogoView())) {
            String strA = com.opos.mobad.ad.a.a(10502);
            d(10502, strA);
            com.opos.cmn.an.f.a.c("SplashAdDelegator", strA);
        } else {
            if (fVar.h) {
                a(this.g, this.f8876a);
            }
            this.h = a(str, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.g.b>() { // from class: com.opos.mobad.f.a.l.1
                @Override // com.opos.mobad.f.a.b.a
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public com.opos.mobad.ad.g.b b(d.a aVar, com.opos.mobad.f.a.a.p pVar) {
                    com.opos.mobad.ad.c cVarB = bVar.b(aVar.f);
                    if (cVarB == null) {
                        return null;
                    }
                    return cVarB.a(activity, str, aVar.g, l.this.f8876a, (com.opos.mobad.ad.g.c) l.this.new a(aVar.f, pVar));
                }
            }, new com.opos.mobad.f.a.c.a(this.g));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.c.removeAllViews();
        com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.b> pVar = this.h;
        if (pVar == null) {
            return;
        }
        boolean z = pVar.j() != d.a.f8585a;
        if (z) {
            com.opos.mobad.ad.g.f fVar = this.f8876a;
            if (fVar.h) {
                View appLogoView = fVar.e.getAppLogoView();
                if (this.c != null && appLogoView != null) {
                    if (appLogoView.getParent() != null) {
                        ((ViewGroup) appLogoView.getParent()).removeView(appLogoView);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((com.opos.cmn.an.h.f.a.b(this.g) * 0.3778f) + 0.5f));
                    layoutParams.addRule(12);
                    appLogoView.setId(1);
                    appLogoView.setBackgroundColor(-1);
                    n.a(this.c, appLogoView, layoutParams);
                }
            }
        }
        com.opos.mobad.ad.g.b bVar = (com.opos.mobad.ad.g.b) this.h.i();
        if (bVar != null) {
            View viewG = bVar.g();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                layoutParams2.addRule(2, 1);
            }
            if (!n.a(this.c, viewG, layoutParams2)) {
                d(10500, com.opos.mobad.ad.a.a(10500));
                return;
            }
        }
        n.a(this.d, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.f.a.l.4
            @Override // java.lang.Runnable
            public void run() {
                if (l.this.c() == 5) {
                    l.this.d("remove pre view but has destroy");
                    return;
                }
                l.this.d("removePreLoadView");
                if (l.this.d == null || l.this.i == null) {
                    return;
                }
                l.this.d.removeView(l.this.i);
                l.this.i.removeAllViews();
                l.this.i = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        ViewGroup viewGroup = this.d;
        if (viewGroup != null) {
            RelativeLayout relativeLayout = this.i;
            if (relativeLayout != null) {
                viewGroup.removeView(relativeLayout);
            }
            RelativeLayout relativeLayout2 = this.c;
            if (relativeLayout2 != null) {
                viewGroup.removeView(relativeLayout2);
            }
            this.d = null;
        }
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.b> pVar = this.h;
        if (pVar != null) {
            pVar.b();
        }
        s();
    }

    @Override // com.opos.mobad.ad.g.b
    public View g() {
        if (c() != 2) {
            return null;
        }
        q();
        return this.c;
    }

    @Override // com.opos.mobad.m.i, com.opos.mobad.ad.g.b
    public View j() {
        return null;
    }

    private com.opos.mobad.ad.g.f a(com.opos.mobad.ad.g.f fVar) {
        String strA;
        f.a aVarA = new f.a(this.g).a(fVar.f8535a).a(fVar.d).b(fVar.f).c(fVar.h).a(fVar.g);
        if (TextUtils.isEmpty(fVar.b)) {
            Context context = this.g;
            strA = com.opos.mobad.m.n.a(context, context.getPackageName());
        } else {
            strA = fVar.b;
        }
        String str = TextUtils.isEmpty(fVar.c) ? "欢迎使用" : fVar.c;
        return aVarA.b(str).a(strA).a(m.a(fVar.e, this.g, strA, str)).a();
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    public void d(String str) {
        com.opos.cmn.an.f.a.b("SplashAdDelegator", str);
    }

    @Override // com.opos.mobad.m.i, com.opos.mobad.ad.g.b
    public void h() {
    }

    @Override // com.opos.mobad.m.i, com.opos.mobad.ad.g.b
    public void i() {
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.b bVarI = this.h.i();
        if (bVarI != null) {
            return bVarI.d();
        }
        return false;
    }

    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.b> a(final String str, final com.opos.mobad.f.a.b.b<com.opos.mobad.ad.g.b> bVar, final com.opos.mobad.f.a.c.a aVar) {
        final b.a aVar2 = new b.a() { // from class: com.opos.mobad.f.a.l.2
            @Override // com.opos.mobad.ad.b.a
            public void onAdClose() {
                l.this.d("onAdClose");
                l.this.n();
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdFailed(int i, String str2) {
                int iA = com.opos.mobad.f.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("SplashAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                l.this.c(iA, str2);
                l.this.r();
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdReady() {
                l.this.d("onAdReady");
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.f.a.l.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (l.this.c() == 5) {
                            l.this.d("remove but has destroy");
                        } else {
                            l.this.r();
                            l.this.q();
                        }
                    }
                });
                l.this.p();
            }
        };
        final int iK = com.opos.mobad.c.b.a().k();
        return new com.opos.mobad.f.a.a.c(str, 60, new c.a<com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.b>>() { // from class: com.opos.mobad.f.a.l.3
            @Override // com.opos.mobad.f.a.a.c.a
            public int a(int i) {
                return l.this.j.a(i);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.b> a(List<d.a> list, d.a aVar3, long j) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.e.b(iK), list, aVar3, j, bVar, aVar, aVar2);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.b> a(List<d.a> list, d.a aVar3, long j, int i) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.e.c(i, iK), list, aVar3, j, bVar, aVar, aVar2);
            }
        });
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        d("doLoad");
        this.h.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.c.b.a().k());
    }

    public void a(Context context, com.opos.mobad.ad.g.f fVar) {
        View appLogoView = fVar.e.getAppLogoView();
        boolean z = fVar.d;
        d("showPreLoadPage: " + z);
        if (z) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            this.i = relativeLayout;
            relativeLayout.setBackgroundColor(-1);
            this.i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, n.a(context));
            layoutParams.addRule(12);
            this.i.addView(appLogoView, layoutParams);
            n.a(this.d, this.i);
        }
    }

    private boolean a(View view) {
        return (view == null || view.getParent() == null) ? false : true;
    }
}
