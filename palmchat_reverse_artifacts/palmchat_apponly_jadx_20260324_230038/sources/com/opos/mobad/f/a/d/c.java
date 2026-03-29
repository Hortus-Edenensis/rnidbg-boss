package com.opos.mobad.f.a.d;

import android.app.Activity;
import android.view.View;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.o;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c extends com.opos.mobad.m.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.a.b f8849a;
    private com.opos.mobad.ad.a.b b;
    private com.opos.mobad.ad.a.b c;
    private String d;
    private o g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements com.opos.mobad.ad.a.c {
        private final int b;

        public a(int i) {
            this.b = i;
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            if (c.this.k() != this.b) {
                return;
            }
            c.this.h();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            if (c.this.k() != this.b) {
                return;
            }
            c.this.n();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            if (c.this.k() != this.b) {
                return;
            }
            c.this.d(i, str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
            if (c.this.k() != this.b) {
                return;
            }
            c.this.p();
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            if (c.this.k() != this.b) {
                return;
            }
            c.this.i();
        }
    }

    public c(Activity activity, String str, com.opos.mobad.ad.a.a aVar, com.opos.mobad.ad.a.c cVar, boolean z, com.opos.mobad.ad.c cVar2, com.opos.mobad.ad.c cVar3) {
        super(cVar);
        this.g = cVar instanceof o ? (o) cVar : null;
        this.d = str;
        this.c = cVar3 != null ? cVar3.a(activity, str, str, z, aVar, new a(1001)) : null;
        this.b = cVar2 != null ? cVar2.a(activity, str, str, z, aVar, new a(d.a.f8585a)) : null;
    }

    private com.opos.mobad.ad.a.b j() {
        if (this.c == null) {
            return this.b;
        }
        int iA = d.a().a(this.d);
        if (iA == 0) {
            return this.c;
        }
        if (iA != 6) {
            com.opos.mobad.c.b.e().c().a(this.d, iA, d.a().b());
        }
        this.c.b();
        this.c = null;
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        com.opos.mobad.ad.a.b bVar = this.f8849a;
        if (bVar == null) {
            return -1;
        }
        if (bVar == this.c) {
            return 1001;
        }
        return d.a.f8585a;
    }

    @Override // com.opos.mobad.m.a, com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        if (c() == 5) {
            return;
        }
        super.b();
        com.opos.mobad.ad.a.b bVar = this.b;
        if (bVar != null) {
            bVar.b();
        }
        com.opos.mobad.ad.a.b bVar2 = this.c;
        if (bVar2 != null) {
            bVar2.b();
        }
        this.g = null;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        com.opos.mobad.ad.a.b bVar = this.f8849a;
        if (bVar == null) {
            return;
        }
        bVar.c(i);
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        com.opos.mobad.ad.a.b bVar = this.f8849a;
        return bVar == null ? super.e() : bVar.e();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        com.opos.mobad.ad.a.b bVar = this.f8849a;
        return bVar == null ? super.f() : bVar.f();
    }

    @Override // com.opos.mobad.ad.a.b
    public View g() {
        com.opos.mobad.ad.a.b bVarJ = j();
        this.f8849a = bVarJ;
        if (bVarJ == null) {
            return null;
        }
        return bVarJ.g();
    }

    @Override // com.opos.mobad.ad.a.b
    public void a(int i, int i2) {
        com.opos.mobad.ad.a.b bVarJ = j();
        this.f8849a = bVarJ;
        if (bVarJ == null) {
            return;
        }
        bVarJ.a(i, i2);
    }

    @Override // com.opos.mobad.m.j
    public void b(int i, String str) {
        o oVar = this.g;
        if (oVar != null) {
            oVar.a(k(), i, str);
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("Mob-BannerDelegator", "do load");
        com.opos.mobad.ad.a.b bVarJ = j();
        this.f8849a = bVarJ;
        if (bVarJ == null) {
            return false;
        }
        bVarJ.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("Mob-BannerDelegator", "do load bidIds");
        com.opos.mobad.ad.a.b bVar = this.b;
        this.f8849a = bVar;
        if (bVar == null) {
            return false;
        }
        bVar.a(str, i, list);
        return true;
    }
}
