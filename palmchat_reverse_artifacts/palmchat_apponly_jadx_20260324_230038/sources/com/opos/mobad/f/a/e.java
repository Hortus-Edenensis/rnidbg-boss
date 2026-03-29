package com.opos.mobad.f.a;

import android.app.Activity;
import android.text.TextUtils;
import com.opos.mobad.ad.b;
import com.opos.mobad.c.a.d;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e extends com.opos.mobad.m.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8857a;
    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.d.c> b;
    private boolean c;
    private String d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.d.d {
        private final int b;

        public a(int i, com.opos.mobad.f.a.a.p pVar) {
            super(i, pVar);
            this.b = i;
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            if (this.b != e.this.b.j()) {
                return;
            }
            com.opos.mobad.c.b.f().b(e.this.f8857a);
            e.this.q();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdClose() {
            if (this.b != e.this.b.j()) {
                return;
            }
            e.this.n();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            if (1 == e.this.c()) {
                super.onAdFailed(i, str);
            } else {
                if (this.b != e.this.b.j()) {
                    return;
                }
                e.this.d(i, str);
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            if (this.b != e.this.b.j()) {
                return;
            }
            com.opos.mobad.c.b.f().a(e.this.f8857a);
            e.this.r();
        }

        @Override // com.opos.mobad.ad.d.d
        public void onVideoPlayComplete() {
            if (this.b != e.this.b.j()) {
                return;
            }
            e.this.g();
        }
    }

    public e(final Activity activity, final String str, com.opos.mobad.f.a.e.a aVar, com.opos.mobad.ad.d.d dVar, final boolean z, List<d.a> list, d.a aVar2, long j, final com.opos.mobad.f.b bVar) {
        super(dVar);
        this.f8857a = str;
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.c>() { // from class: com.opos.mobad.f.a.e.1
            @Override // com.opos.mobad.f.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.d.c b(d.a aVar3, com.opos.mobad.f.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar3.f);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(activity, str, aVar3.g, z, e.this.new a(aVar3.f, pVar));
            }
        }, new com.opos.mobad.f.a.c.a(activity));
    }

    private com.opos.mobad.f.a.a.p<com.opos.mobad.ad.d.c> a(String str, com.opos.mobad.f.a.e.a aVar, List<d.a> list, d.a aVar2, long j, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.c> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.e.2
            @Override // com.opos.mobad.ad.b.a
            public void onAdClose() {
                e.this.n();
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdFailed(int i, String str2) {
                int iA = com.opos.mobad.f.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("InterstitialVideoAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                e.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void onAdReady() {
                e.this.p();
            }
        });
    }

    @Override // com.opos.mobad.m.d, com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        if (com.opos.mobad.c.b.a().b(this.f8857a)) {
            return h.a(this.b.i(), this.b.k());
        }
        return -102;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.c.b.a().p());
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void b(int i) {
        if (com.opos.mobad.c.b.a().b(this.f8857a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.e().a(this.f8857a, this.d, this.b.j(), f(), i);
        }
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        com.opos.mobad.ad.b bVarI;
        if (com.opos.mobad.c.b.a().b(this.f8857a) && (bVarI = this.b.i()) != null) {
            bVarI.c(i);
        }
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public boolean d() {
        com.opos.mobad.ad.d.c cVar = (com.opos.mobad.ad.d.c) this.b.i();
        if (cVar != null) {
            return cVar.d();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void a(int i, String str, int i2) {
        if (com.opos.mobad.c.b.a().b(this.f8857a) && c() == 2 && !this.c) {
            this.c = true;
            com.opos.mobad.c.b.e().a(this.f8857a, this.d, i, str, this.b.j(), f(), i2);
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.k
    public boolean b(Activity activity) {
        com.opos.mobad.ad.d.c cVar = (com.opos.mobad.ad.d.c) this.b.i();
        if (cVar == null) {
            d(-1, "ad is null");
            return false;
        }
        cVar.a(activity);
        return cVar.c() == 3;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        this.c = false;
        this.d = str;
        this.b.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.d = str;
            this.c = false;
            this.b.a(str, i, list, str2);
            return true;
        }
        com.opos.cmn.an.f.a.b("InterstitialVideoAdDelegator", "error request Id:" + str);
        d(10701, "show error, please reload");
        return true;
    }
}
