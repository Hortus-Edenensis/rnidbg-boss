package com.opos.mobad.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.ad.b;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.i;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class j extends com.opos.mobad.m.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8870a;
    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.f.a> b;
    private boolean c;
    private boolean d;
    private String g;
    private com.opos.mobad.ad.f.a h;
    private boolean i;
    private List<String> j;
    private boolean k;
    private Context l;
    private boolean m;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.f.b, com.opos.mobad.ad.g {
        private final int c;
        private final com.opos.mobad.ad.f.b d;

        public a(int i, com.opos.mobad.f.a.a.p pVar, com.opos.mobad.ad.f.b bVar) {
            super(i, pVar);
            this.c = i;
            this.d = bVar;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.f.a.a.o
        public void a(int i, int i2, String str) {
            j.this.d("onAdFailed code=" + i2 + ",msg=" + str + ",currentState=" + j.this.c() + ", realChannel =" + i);
            if (1 == j.this.c()) {
                super.a(i, i2, str);
                return;
            }
            j.this.d("current:" + this.c + ",select=" + j.this.b.j());
            if (this.c != j.this.b.j()) {
                return;
            }
            j.this.e(i2, str);
        }

        @Override // com.opos.mobad.ad.f.b, com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                com.opos.mobad.c.b.f().b(j.this.f8870a);
                j.this.a(j);
            }
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdClose() {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                j.this.n();
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                j.this.r();
            }
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageClose() {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                j.this.m();
            }
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageOpen() {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                j.this.k();
            }
        }

        @Override // com.opos.mobad.ad.k
        public void onReward(Object... objArr) {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                j.this.a(objArr);
            }
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayClose(long j) {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                j.this.b(j);
            }
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayComplete() {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                j.this.j();
            }
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayError(String str) {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                j.this.e(str);
            }
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayStart() {
            if ((this.c == d.a.f8585a && j.this.m) || this.c == j.this.b.j()) {
                com.opos.mobad.c.b.f().a(j.this.f8870a);
                j.this.i();
            }
        }

        @Override // com.opos.mobad.ad.g
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.f.b bVar = this.d;
            if (bVar instanceof com.opos.mobad.ad.g) {
                ((com.opos.mobad.ad.g) bVar).a(map);
            }
        }
    }

    public j(final Context context, final String str, com.opos.mobad.f.a.e.a aVar, final com.opos.mobad.ad.f.b bVar, final boolean z, List<d.a> list, d.a aVar2, long j, final com.opos.mobad.f.b bVar2) {
        super(bVar);
        this.i = false;
        this.k = false;
        this.l = context.getApplicationContext();
        this.f8870a = str;
        com.opos.mobad.f.a.b.b<com.opos.mobad.ad.f.a> bVar3 = new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.f.a>() { // from class: com.opos.mobad.f.a.j.1
            @Override // com.opos.mobad.f.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.f.a b(d.a aVar3, com.opos.mobad.f.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar2.b(aVar3.f);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(context, str, aVar3.g, z, j.this.new a(aVar3.f, pVar, bVar));
            }
        };
        this.h = a(context, bVar2, str);
        this.b = a(str, aVar, list, aVar2, j, bVar3, new com.opos.mobad.f.a.c.a(context));
    }

    private com.opos.mobad.ad.f.a a(Context context, com.opos.mobad.f.b bVar, String str) {
        com.opos.mobad.ad.c cVarB;
        if (context == null || bVar == null || (cVarB = bVar.b(1000)) == null) {
            return null;
        }
        return cVarB.a(context, str, str, true, new com.opos.mobad.ad.f.b() { // from class: com.opos.mobad.f.a.j.3
            @Override // com.opos.mobad.ad.f.b, com.opos.mobad.ad.m.b
            public void onAdClick(long j) {
                j.this.a(j);
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdClose() {
                j.this.n();
            }

            @Override // com.opos.mobad.ad.m.b
            public void onAdShow(String str2) {
                j.this.r();
            }

            @Override // com.opos.mobad.ad.f.b
            public void onLandingPageClose() {
                j.this.m();
            }

            @Override // com.opos.mobad.ad.f.b
            public void onLandingPageOpen() {
                j.this.k();
            }

            @Override // com.opos.mobad.ad.k
            public void onReward(Object... objArr) {
                j.this.a(objArr);
            }

            @Override // com.opos.mobad.ad.f.b
            public void onVideoPlayClose(long j) {
                j.this.b(j);
            }

            @Override // com.opos.mobad.ad.f.b
            public void onVideoPlayComplete() {
                j.this.j();
            }

            @Override // com.opos.mobad.ad.f.b
            public void onVideoPlayError(String str2) {
                j.this.e(str2);
            }

            @Override // com.opos.mobad.ad.f.b
            public void onVideoPlayStart() {
                j.this.i();
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdReady() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdFailed(int i, String str2) {
            }
        });
    }

    private int s() {
        return com.opos.mobad.c.b.a().q();
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
        com.opos.mobad.ad.f.a aVar = this.h;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        if (com.opos.mobad.c.b.a().b(this.f8870a)) {
            return h.a(this.b.i(), this.b.k());
        }
        return -102;
    }

    public boolean f_() {
        com.opos.mobad.ad.f.a aVar = (com.opos.mobad.ad.f.a) this.b.h();
        if (!(aVar instanceof com.opos.mobad.m.h)) {
            return false;
        }
        boolean zH = ((com.opos.mobad.m.h) aVar).h();
        this.m = zH;
        return zH;
    }

    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.f.a> a(String str, com.opos.mobad.f.a.e.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.f.a> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.j.2
            @Override // com.opos.mobad.ad.b.a
            public void onAdClose() {
                j.this.n();
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdFailed(int i, String str2) {
                int iA = com.opos.mobad.f.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("RewardVideoAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                if (j.this.h != null && j.this.d(i) && j.this.h.c() == 2) {
                    j.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.j.2.1
                        @Override // java.util.concurrent.Callable
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public Boolean call() throws Exception {
                            j.this.i = true;
                            return Boolean.TRUE;
                        }
                    });
                } else {
                    j.this.c(iA, str2);
                }
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdReady() {
                j.this.d("onAdReady");
                j.this.p();
            }
        });
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.f8870a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.e().a(this.f8870a, this.g, this.b.j(), f(), i);
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        com.opos.mobad.ad.b bVarI;
        if ((com.opos.mobad.c.b.a().b(this.f8870a) || this.j != null) && (bVarI = this.b.i()) != null) {
            bVarI.c(i);
        }
    }

    public void d(String str) {
        com.opos.cmn.an.f.a.b("RewardVideoAdDelegator", str);
    }

    @Override // com.opos.mobad.m.h, com.opos.mobad.ad.f.a
    public void g() {
        boolean z = !this.d && (c() == 3 || c() == 4);
        if ((this.m && !this.d) || z) {
            this.d = true;
            com.opos.mobad.c.b.e().a(this.f8870a, this.g);
            return;
        }
        d("notify user rewarded but ignore " + c() + "," + this.d);
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void a() {
        a(s());
    }

    @Override // com.opos.mobad.m.j
    public void b(int i, String str) {
        com.opos.mobad.b bVarB;
        super.b(i, str);
        if ((i != 10006 && i != 10008) || this.k || (bVarB = com.opos.mobad.d.a().b(this.l)) == null) {
            return;
        }
        bVarB.i().a(i, this.f8870a, 5);
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public boolean d() {
        if (this.i) {
            return this.h.d();
        }
        com.opos.mobad.ad.f.a aVar = (com.opos.mobad.ad.f.a) this.b.i();
        if (aVar != null) {
            return aVar.d();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i) {
        if (i == 10011) {
            return true;
        }
        if (i != -1 && i != -2 && i != -5 && i != -8 && i != -3) {
            return false;
        }
        d("need to intercept check errorCode = " + i);
        return true;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.f8870a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.e().a(this.f8870a, this.g, i, str, this.b.j(), f(), i2);
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.l
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f8869a != 0) {
            com.opos.mobad.c.b.f().c(this.f8870a);
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
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("RewardVideoAdDelegator", "error request Id:" + str);
            d(10701, "show error, please reload");
            return true;
        }
        this.c = false;
        this.d = false;
        this.g = str;
        this.i = false;
        this.k = true;
        this.j = list;
        com.opos.mobad.ad.f.a aVar = this.h;
        if (aVar != null) {
            aVar.a(str, i);
        }
        this.b.a(str, i, list, str2);
        return true;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.l
    public void a(List<String> list) {
        a(s(), list);
    }

    @Override // com.opos.mobad.m.h
    public boolean b(boolean z) {
        d("doShow");
        com.opos.mobad.ad.f.a aVar = this.i ? this.h : (com.opos.mobad.ad.f.a) this.b.i();
        if (aVar == null) {
            d(-1, "ad is null");
            return false;
        }
        this.m = false;
        aVar.a(z);
        this.k = false;
        return aVar.c() == 3;
    }
}
