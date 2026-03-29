package com.opos.mobad.f.a.d;

import android.content.Context;
import com.opos.mobad.ad.e.j;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.o;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f extends com.opos.mobad.m.e {
    private com.opos.mobad.ad.e.g b;
    private com.opos.mobad.ad.e.g c;
    private com.opos.mobad.ad.e.g d;
    private String e;
    private o f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements j {
        private final int b;

        public a(int i) {
            this.b = i;
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdFailed(int i, String str) {
            if (f.this.i() != this.b) {
                return;
            }
            f.this.c(i, str);
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdSuccess(List<com.opos.mobad.ad.e.h> list) {
            if (f.this.i() != this.b) {
                return;
            }
            com.opos.cmn.an.f.a.b("Mob-NTDelegator", "onAdSuccess:" + list);
            f.this.b(list);
        }
    }

    public f(Context context, String str, int i, int i2, j jVar, com.opos.mobad.ad.privacy.a aVar, com.opos.mobad.ad.c cVar, com.opos.mobad.ad.c cVar2) {
        super(jVar);
        this.f = jVar instanceof o ? (o) jVar : null;
        this.e = str;
        this.d = cVar2 != null ? cVar2.a(context, str, str, i, i2, new a(1001), aVar) : null;
        this.c = cVar != null ? cVar.a(context, str, str, i, i2, new a(d.a.f8585a), aVar) : null;
    }

    private com.opos.mobad.ad.e.g h() {
        if (this.d == null) {
            return this.c;
        }
        int iA = d.a().a(this.e);
        if (iA == 0) {
            return this.d;
        }
        if (iA != 6) {
            com.opos.mobad.c.b.e().c().a(this.e, iA, d.a().b());
        }
        this.d.b();
        this.d = null;
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i() {
        com.opos.mobad.ad.e.g gVar = this.b;
        if (gVar == null) {
            return d.a.f8585a;
        }
        if (gVar == this.d) {
            return 1001;
        }
        return d.a.f8585a;
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.ad.b
    public void b() {
        if (c() == 5) {
            return;
        }
        super.b();
        com.opos.mobad.ad.e.g gVar = this.c;
        if (gVar != null) {
            gVar.b();
        }
        com.opos.mobad.ad.e.g gVar2 = this.d;
        if (gVar2 != null) {
            gVar2.b();
        }
        this.f = null;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        com.opos.mobad.ad.e.g gVar = this.b;
        if (gVar == null) {
            return;
        }
        gVar.c(i);
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        com.opos.mobad.ad.e.g gVar = this.b;
        return gVar == null ? super.e() : gVar.e();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        com.opos.mobad.ad.e.g gVar = this.b;
        return gVar == null ? super.f() : gVar.f();
    }

    @Override // com.opos.mobad.m.f
    public void b(int i, String str) {
        o oVar = this.f;
        if (oVar != null) {
            oVar.a(i(), i, str);
        }
    }

    @Override // com.opos.mobad.m.f
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.f
    public boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("Mob-NTDelegator", "do load");
        com.opos.mobad.ad.e.g gVarH = h();
        this.b = gVarH;
        if (gVarH == null) {
            return false;
        }
        gVarH.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.m.f
    public boolean b(String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("Mob-NTDelegator", "do load bidIds");
        com.opos.mobad.ad.e.g gVar = this.c;
        this.b = gVar;
        if (gVar == null) {
            return false;
        }
        gVar.a(str, i, list);
        return true;
    }
}
