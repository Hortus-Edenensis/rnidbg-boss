package com.opos.mobad.f.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.g.f;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.c;
import com.opos.mobad.f.a.i;
import com.opos.mobad.n.a.q;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c extends com.opos.mobad.m.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.g.f f8834a;
    private String b;
    private String c;
    private RelativeLayout d;
    private com.opos.mobad.ad.g.c g;
    private ViewGroup h;
    private Context i;
    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.a> j;
    private com.opos.mobad.f.b k;
    private boolean l;
    private boolean m;
    private List<String> n;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.g, com.opos.mobad.ad.g.c {
        private final int b;
        private final com.opos.mobad.ad.g.c c;

        public a(int i, com.opos.mobad.f.a.a.p pVar, com.opos.mobad.ad.g.c cVar) {
            super(i, pVar);
            this.b = i;
            this.c = cVar;
        }

        @Override // com.opos.mobad.ad.g
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.g.c cVar = this.c;
            if (cVar instanceof com.opos.mobad.ad.g) {
                ((com.opos.mobad.ad.g) cVar).a(map);
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            c.this.d("ad click:" + this.b + "," + c.this.j.i());
            if (this.b != c.this.j.j()) {
                return;
            }
            com.opos.mobad.c.b.f().b(c.this.b);
            c.this.m();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdClose() {
            c.this.d("ad close:" + this.b + "," + c.this.j.i());
            if (this.b != c.this.j.j()) {
                return;
            }
            c.this.m = true;
            c.this.n();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            c.this.d("ad failed:" + i + ",msg:" + str + ", state=" + c.this.c());
            if (1 == c.this.c()) {
                super.onAdFailed(i, str);
                return;
            }
            if (2 == c.this.c() && this.b == c.this.j.j()) {
                c.this.d(i, str);
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.f.a.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.c() == 5) {
                            c.this.d("onFail to destroy view but destroy state");
                        } else {
                            c.this.s();
                        }
                    }
                });
                return;
            }
            c.this.d("ignore fail:" + this.b);
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            c.this.d("ad show");
            if (this.b != c.this.j.j()) {
                return;
            }
            com.opos.mobad.c.b.f().a(c.this.b);
            c.this.e(str);
        }
    }

    public c(final Context context, final String str, com.opos.mobad.ad.g.f fVar, final com.opos.mobad.ad.g.c cVar, final com.opos.mobad.f.b bVar) {
        super(cVar);
        this.m = false;
        if (context == null || TextUtils.isEmpty(str) || fVar == null || cVar == null || bVar == null) {
            com.opos.cmn.an.f.a.c("HostSplashAdDelegator", "HotSplashAd params null.");
            d(-1, "HotSplashAd params null.");
            return;
        }
        this.g = cVar;
        this.b = str;
        this.i = context.getApplicationContext();
        this.d = new RelativeLayout(this.i);
        this.f8834a = a(fVar);
        this.k = bVar;
        this.j = a(str, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.g.a>() { // from class: com.opos.mobad.f.a.c.1
            @Override // com.opos.mobad.f.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.g.a b(d.a aVar, com.opos.mobad.f.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar.f);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(context, str, aVar.g, c.this.f8834a, c.this.new a(aVar.f, pVar, cVar));
            }
        }, new com.opos.mobad.f.a.c.a(this.i));
    }

    private com.opos.mobad.ad.g.f a(com.opos.mobad.ad.g.f fVar) {
        String strA;
        f.a aVarA = new f.a(this.i).a(fVar.f8535a).a(fVar.d).b(fVar.f).c(com.opos.mobad.c.b.a().a(this.b) == q.VERTICAL.a()).a(fVar.g);
        if (TextUtils.isEmpty(fVar.b)) {
            Context context = this.i;
            strA = com.opos.mobad.m.n.a(context, context.getPackageName());
        } else {
            strA = fVar.b;
        }
        String str = TextUtils.isEmpty(fVar.c) ? "欢迎使用" : fVar.c;
        return aVarA.b(str).a(strA).a(m.a(fVar.e, this.i, strA, str)).a();
    }

    private void q() {
        com.opos.cmn.an.f.a.b("HostSplashAdDelegator", "renderAdView");
        this.d.removeAllViews();
        com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.a> pVar = this.j;
        if (pVar == null) {
            return;
        }
        boolean z = pVar.j() != d.a.f8585a;
        if (z) {
            com.opos.mobad.ad.g.f fVar = this.f8834a;
            if (fVar.h) {
                View appLogoView = fVar.e.getAppLogoView();
                if (this.d != null && appLogoView != null) {
                    if (appLogoView.getParent() != null) {
                        ((ViewGroup) appLogoView.getParent()).removeView(appLogoView);
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) ((com.opos.cmn.an.h.f.a.b(this.i) * 0.3778f) + 0.5f));
                    layoutParams.addRule(12);
                    appLogoView.setId(1);
                    appLogoView.setBackgroundColor(-1);
                    n.a(this.d, appLogoView, layoutParams);
                }
            }
        }
        com.opos.mobad.ad.g.a aVar = (com.opos.mobad.ad.g.a) this.j.i();
        if (aVar != null) {
            View viewG = aVar.g();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            if (z) {
                layoutParams2.addRule(2, 1);
            }
            if (n.a(this.d, viewG, layoutParams2)) {
                return;
            }
            d(10500, com.opos.mobad.ad.a.a(10500));
        }
    }

    private int r() {
        return com.opos.mobad.c.b.a().k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        RelativeLayout relativeLayout;
        try {
            ViewGroup viewGroup = this.h;
            if (viewGroup != null && (relativeLayout = this.d) != null) {
                viewGroup.removeView(relativeLayout);
            }
            this.h = null;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("HostSplashAdDelegator", "destroyView", e);
        }
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.a> pVar = this.j;
        if (pVar != null) {
            pVar.b();
        }
        s();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        com.opos.mobad.ad.b bVarI;
        if ((com.opos.mobad.c.b.a().b(this.b) || this.n != null) && (bVarI = this.j.i()) != null) {
            bVarI.c(i);
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        int iA;
        if (com.opos.mobad.c.b.a().b(this.b)) {
            iA = h.a(this.j.j(), this.j.i(), this.j.k());
        } else {
            com.opos.cmn.an.f.a.b("HostSplashAdDelegator", "isBiddingOutEnable:false");
            iA = -102;
        }
        com.opos.mobad.c.b.e().a(this.b, this.c, iA, this.j.j());
        return iA;
    }

    @Override // com.opos.mobad.ad.g.b
    public View g() {
        if (c() != 2) {
            return null;
        }
        q();
        return this.d;
    }

    @Override // com.opos.mobad.m.i, com.opos.mobad.ad.g.b
    public void h() {
        d("zoomOutAnimationStart");
        if (!this.m) {
            d("zoomOutAnimationStart but not dismiss");
            return;
        }
        RelativeLayout relativeLayout = this.d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    @Override // com.opos.mobad.m.i, com.opos.mobad.ad.g.b
    public void i() {
        d("zoomOutAnimationFinish");
        com.opos.mobad.ad.g.b bVar = (com.opos.mobad.ad.g.b) this.j.i();
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.opos.mobad.m.i, com.opos.mobad.ad.g.b
    public View j() {
        com.opos.mobad.ad.g.b bVar = (com.opos.mobad.ad.g.b) this.j.i();
        if (bVar == null) {
            return null;
        }
        return bVar.j();
    }

    @Override // com.opos.mobad.m.i, com.opos.mobad.ad.g.b
    public boolean k() {
        com.opos.mobad.ad.g.b bVar = (com.opos.mobad.ad.g.b) this.j.i();
        if (bVar == null) {
            return false;
        }
        return bVar.k();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.b) && c() == 2 && !this.l) {
            this.l = true;
            com.opos.mobad.c.b.e().a(this.b, this.c, this.j.j(), f(), i);
        }
    }

    public void d(String str) {
        com.opos.cmn.an.f.a.b("HostSplashAdDelegator", str);
    }

    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.a> a(final String str, final com.opos.mobad.f.a.b.b<com.opos.mobad.ad.g.a> bVar, final com.opos.mobad.f.a.c.a aVar) {
        final b.a aVar2 = new b.a() { // from class: com.opos.mobad.f.a.c.2
            @Override // com.opos.mobad.ad.b.a
            public void onAdClose() {
                c.this.d("onAdClose");
                c.this.n();
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdFailed(int i, String str2) {
                int iA = com.opos.mobad.f.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("HostSplashAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                c.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdReady() {
                c.this.d("onAdReady");
                c.this.p();
            }
        };
        final int iK = com.opos.mobad.c.b.a().k();
        return new com.opos.mobad.f.a.a.c(str, 60, new c.a<com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.a>>() { // from class: com.opos.mobad.f.a.c.3
            @Override // com.opos.mobad.f.a.a.c.a
            public int a(int i) {
                return c.this.k.a(i);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.a> a(List<d.a> list, d.a aVar3, long j) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.e.b(iK), list, aVar3, j, bVar, aVar, aVar2);
            }

            @Override // com.opos.mobad.f.a.a.c.a
            public com.opos.mobad.f.a.a.p<com.opos.mobad.ad.g.a> a(List<d.a> list, d.a aVar3, long j, int i) {
                return com.opos.mobad.f.a.a.k.a(str, new com.opos.mobad.f.a.e.c(i, iK), list, aVar3, j, bVar, aVar, aVar2);
            }
        });
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.b bVarI = this.j.i();
        if (bVarI != null) {
            return bVarI.d();
        }
        return false;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void a() {
        a(r());
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.b) && c() == 2 && !this.l) {
            this.l = true;
            com.opos.mobad.c.b.e().a(this.b, this.c, i, str, this.j.j(), f(), i2);
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.l
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f8869a != 0) {
            com.opos.mobad.c.b.f().c(this.b);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    @Override // com.opos.mobad.ad.g.a
    public void a(Activity activity) {
        if (com.opos.cmn.i.b.a(activity)) {
            this.g.onAdFailed(-1, "Activity is null or activity is finishing.");
            return;
        }
        if (!com.opos.cmn.an.h.f.a.a(activity)) {
            this.g.onAdFailed(-1, "splash must be displayed in full screen mode.");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        this.h = viewGroup;
        if (viewGroup == null) {
            this.g.onAdFailed(-1, "container null");
            return;
        }
        View viewG = g();
        if (viewG == null) {
            this.g.onAdFailed(-1, "Unknown error. ");
            return;
        }
        ViewParent parent = viewG.getParent();
        if (parent != null) {
            if (parent == this.h) {
                return;
            }
            if (!(parent instanceof ViewGroup)) {
                this.g.onAdFailed(-1, "view had add to container");
                return;
            }
            ((ViewGroup) parent).removeView(viewG);
        }
        this.h.addView(viewG, new ViewGroup.LayoutParams(-1, -1));
        ((com.opos.mobad.ad.g.a) this.j.i()).a(activity);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list, String str2) {
        d("doload");
        if (TextUtils.isEmpty(str)) {
            d("error request Id:" + str);
            d(10701, "show error, please reload");
            return true;
        }
        this.l = false;
        this.m = false;
        this.c = str;
        this.n = list;
        this.j.a(str, i, list, str2);
        return true;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.l
    public void a(List<String> list) {
        a(r(), list);
    }
}
