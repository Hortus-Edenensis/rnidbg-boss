package com.opos.mobad.f.a;

import android.app.Activity;
import android.text.TextUtils;
import com.opos.mobad.ad.b;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.i;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d extends com.opos.mobad.m.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8842a;
    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.d.a> b;
    private boolean c;
    private String d;
    private List<String> g;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.c.a, com.opos.mobad.ad.d.b, com.opos.mobad.ad.g {
        private final int b;
        private final com.opos.mobad.ad.d.b c;

        public a(int i, com.opos.mobad.f.a.a.p pVar, com.opos.mobad.ad.d.b bVar) {
            super(i, pVar);
            this.b = i;
            this.c = bVar;
        }

        @Override // com.opos.mobad.ad.c.a
        public void a() {
            com.opos.mobad.ad.d.b bVar = this.c;
            if (bVar instanceof com.opos.mobad.ad.c.a) {
                ((com.opos.mobad.ad.c.a) bVar).a();
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            if (this.b != d.this.b.j()) {
                return;
            }
            com.opos.mobad.c.b.f().b(d.this.f8842a);
            d.this.q();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdClose() {
            if (this.b != d.this.b.j()) {
                return;
            }
            d.this.n();
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            if (this.b != d.this.b.j()) {
                return;
            }
            com.opos.mobad.c.b.f().a(d.this.f8842a);
            d.this.r();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.f.a.a.o
        public void a(int i, int i2, String str) {
            if (1 == d.this.c()) {
                super.a(i, i2, str);
            } else {
                if (this.b != d.this.b.j()) {
                    return;
                }
                d.this.e(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.g
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.d.b bVar = this.c;
            if (bVar instanceof com.opos.mobad.ad.g) {
                ((com.opos.mobad.ad.g) bVar).a(map);
            }
        }
    }

    public d(final Activity activity, final String str, com.opos.mobad.f.a.e.a aVar, final com.opos.mobad.ad.d.b bVar, List<d.a> list, d.a aVar2, long j, final com.opos.mobad.f.b bVar2, final com.opos.mobad.ad.d.e eVar) {
        super(bVar);
        this.f8842a = str;
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.a>() { // from class: com.opos.mobad.f.a.d.1
            @Override // com.opos.mobad.f.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.d.a b(d.a aVar3, com.opos.mobad.f.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar2.b(aVar3.f);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(activity, str, aVar3.g, eVar, d.this.new a(aVar3.f, pVar, bVar));
            }
        }, new com.opos.mobad.f.a.c.a(activity));
    }

    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.d.a> a(String str, com.opos.mobad.f.a.e.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.a> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.d.2
            @Override // com.opos.mobad.ad.b.a
            public void onAdClose() {
                d.this.n();
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdFailed(int i, String str2) {
                int iA = com.opos.mobad.f.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("InterstitialAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                d.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdReady() {
                d.this.p();
            }
        });
    }

    private int g() {
        return com.opos.mobad.c.b.a().n();
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        if (com.opos.mobad.c.b.a().b(this.f8842a)) {
            return h.a(this.b.i(), this.b.k());
        }
        return -102;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void a() {
        a(g());
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.f8842a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.e().a(this.f8842a, this.d, this.b.j(), f(), i);
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        com.opos.mobad.ad.b bVarI;
        if ((com.opos.mobad.c.b.a().b(this.f8842a) || this.g != null) && (bVarI = this.b.i()) != null) {
            bVarI.c(i);
        }
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.d.a aVar = (com.opos.mobad.ad.d.a) this.b.i();
        if (aVar != null) {
            return aVar.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.f8842a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.e().a(this.f8842a, this.d, i, str, this.b.j(), f(), i2);
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
            com.opos.mobad.c.b.f().c(this.f8842a);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.m.k
    public boolean b(Activity activity) {
        com.opos.mobad.ad.d.a aVar = (com.opos.mobad.ad.d.a) this.b.i();
        if (aVar == null) {
            d(-1, "ad is null");
            return false;
        }
        aVar.a(activity);
        return aVar.c() == 3;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        return b(str, i, (List<String>) null);
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.l
    public void a(List<String> list) {
        a(g(), list);
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            this.c = false;
            this.g = list;
            this.b.a(str, i, list, str2);
            return true;
        }
        com.opos.cmn.an.f.a.b("InterstitialAdDelegator", "error request Id:" + str);
        d(10701, "show error, please reload");
        return true;
    }
}
