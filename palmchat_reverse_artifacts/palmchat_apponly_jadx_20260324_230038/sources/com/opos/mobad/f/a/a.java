package com.opos.mobad.f.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.ad.b;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.i;
import com.opos.mobad.f.a.k;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a extends com.opos.mobad.m.a {
    private static Map<String, Boolean> g = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8793a;
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.a.b> b;
    private b c;
    private p d;
    private Context h;
    private String i;
    private int j;
    private boolean k;
    private List<String> l;
    private String m;

    /* JADX INFO: renamed from: com.opos.mobad.f.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0739a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.a.c, com.opos.mobad.ad.g {
        private final int b;
        private final com.opos.mobad.ad.a.c c;

        public C0739a(int i, com.opos.mobad.f.a.a.p pVar, com.opos.mobad.ad.a.c cVar) {
            super(i, pVar);
            this.b = i;
            this.c = cVar;
        }

        @Override // com.opos.mobad.ad.g
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.a.c cVar = this.c;
            if (cVar instanceof com.opos.mobad.ad.g) {
                ((com.opos.mobad.ad.g) cVar).a(map);
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            if (this.b != a.this.b.j()) {
                return;
            }
            com.opos.mobad.c.b.f().b(a.this.f8793a);
            a.this.h();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdClose() {
            if (this.b == a.this.j) {
                a.this.j = -1;
                a.this.n();
                a.this.r();
                return;
            }
            a.this.d("channel is diff =" + this.b + ", " + a.this.b.j());
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            if (1 == a.this.c()) {
                super.onAdFailed(i, str);
            } else {
                if (this.b != a.this.b.j()) {
                    return;
                }
                a.this.d(i, str);
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            if (this.b != a.this.b.j()) {
                return;
            }
            com.opos.mobad.c.b.f().a(a.this.f8793a);
            a.this.i();
        }
    }

    public a(final Activity activity, final String str, com.opos.mobad.f.a.e.a aVar, final boolean z, final com.opos.mobad.ad.a.a aVar2, final com.opos.mobad.ad.a.c cVar, List<d.a> list, d.a aVar3, long j, final com.opos.mobad.f.b bVar) {
        super(cVar);
        this.j = -1;
        this.k = false;
        this.f8793a = str;
        Context applicationContext = activity.getApplicationContext();
        this.h = applicationContext;
        this.c = new b(applicationContext, aVar2, new k.a() { // from class: com.opos.mobad.f.a.a.1
            @Override // com.opos.mobad.f.a.k.a
            public void a(int i, int i2) {
                a.this.b(i, i2);
            }
        });
        this.b = a(str, aVar, list, aVar3, j, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.a.b>() { // from class: com.opos.mobad.f.a.a.2
            @Override // com.opos.mobad.f.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.a.b b(d.a aVar4, com.opos.mobad.f.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar4.f);
                if (cVarB != null) {
                    return cVarB.a(activity, str, aVar4.g, z, aVar2, a.this.new C0739a(aVar4.f, pVar, cVar));
                }
                a.this.d("new banner ad but creator = null,channel is =" + aVar4.f);
                return null;
            }
        }, new com.opos.mobad.f.a.c.a(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        d("banner showView");
        com.opos.mobad.ad.a.b bVarI = this.b.i();
        this.j = this.b.j();
        this.c.a(bVarI.g());
    }

    private int k() {
        return com.opos.mobad.c.b.a().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            d("setBannerCovered posId=" + this.f8793a);
            g.put(this.f8793a, Boolean.TRUE);
            r();
            b bVar = this.c;
            if (bVar != null) {
                bVar.b();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("BannerAdDelegator", "", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        p pVar = this.d;
        if (pVar != null) {
            pVar.a();
            this.d.b();
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        boolean zBooleanValue = false;
        try {
            if (g.containsKey(this.f8793a)) {
                zBooleanValue = g.get(this.f8793a).booleanValue();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("BannerAdDelegator", "", e);
        }
        d("isBannerCovered=" + zBooleanValue);
        return zBooleanValue;
    }

    @Override // com.opos.mobad.m.a, com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        r();
        this.b.b();
        this.c.b();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        com.opos.mobad.ad.a.b bVarI;
        if ((com.opos.mobad.c.b.a().b(this.f8793a) || this.l != null) && (bVarI = this.b.i()) != null) {
            bVarI.c(i);
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        if (com.opos.mobad.c.b.a().b(this.f8793a)) {
            return h.a(this.b.i(), this.b.k());
        }
        return -102;
    }

    @Override // com.opos.mobad.ad.a.b
    public View g() {
        return this.c.a();
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.a.b> a(String str, com.opos.mobad.f.a.e.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.a.b> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(this.h, str, aVar, list, aVar2, j, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.a.3
            @Override // com.opos.mobad.ad.b.a
            public void onAdClose() {
                a.this.d("onAdClose");
                a.this.n();
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdFailed(int i, String str2) {
                int iA = com.opos.mobad.f.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("BannerAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                a.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdReady() {
                a.this.d("onAdReady");
                a.this.p();
                a.this.j();
            }
        });
    }

    private void m() {
        if (this.l != null) {
            com.opos.cmn.an.f.a.b("BannerAdDelegator", "server bid not auto refresh");
        } else if (this.d == null) {
            p pVar = new p(new Runnable() { // from class: com.opos.mobad.f.a.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.c == null || !a.this.c.c()) {
                        a.this.d("banner is invisibile");
                    } else if (a.this.s() || com.opos.cmn.i.k.a(a.this.h, a.this.g())) {
                        a.this.q();
                        a.this.d(11004, "you shouldn't play ad on the top in the shaped screen mobile");
                        return;
                    } else if (TextUtils.isEmpty(a.this.m)) {
                        a.this.a();
                    } else {
                        a aVar = a.this;
                        aVar.a(aVar.m);
                    }
                    if (a.this.d != null) {
                        a.this.d.a(com.opos.mobad.service.d.b().a(a.this.f8793a));
                    }
                }
            });
            this.d = pVar;
            pVar.a(com.opos.mobad.service.d.b().a(this.f8793a));
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.f8793a) && c() == 2 && !this.k) {
            this.k = true;
            com.opos.mobad.c.b.e().a(this.f8793a, this.i, this.b.j(), f(), i);
        }
    }

    public void d(String str) {
        com.opos.cmn.an.f.a.b("BannerAdDelegator", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, int i2) {
        com.opos.mobad.f.a.a.n<com.opos.mobad.ad.a.b> nVar = this.b;
        if (nVar != null) {
            nVar.a(i, i2);
        }
        d("notify banner size change w = " + i + ",h =" + i2);
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void a() {
        a(k());
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.a.b bVarI = this.b.i();
        if (bVarI != null) {
            return bVarI.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.a.b
    public void a(int i, int i2) {
        b(i, i2);
        d("setBannerWidthAndHeight width = " + i + ", height = " + i2);
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.f8793a) && c() == 2 && !this.k) {
            this.k = true;
            com.opos.mobad.c.b.e().a(this.f8793a, this.i, i, str, this.b.j(), f(), i2);
        }
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.l
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f8869a != 0) {
            com.opos.mobad.c.b.f().c(this.f8793a);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list, String str2) {
        int i2;
        String str3;
        d("doload");
        if (TextUtils.isEmpty(str)) {
            d("error request Id");
            i2 = 10701;
            str3 = "show error, please reload";
        } else {
            this.k = false;
            this.i = str;
            if (!s() && !com.opos.cmn.i.k.a(this.h, g())) {
                this.l = list;
                this.m = str2;
                this.b.a(str, i, list, str2);
                if (this.l != null) {
                    p pVar = this.d;
                    if (pVar != null) {
                        pVar.a();
                    }
                } else {
                    m();
                }
                return true;
            }
            q();
            i2 = 11004;
            str3 = "you shouldn't play ad on the top in the shaped screen mobile";
        }
        d(i2, str3);
        return true;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.l
    public void a(List<String> list) {
        a(k(), list);
    }
}
