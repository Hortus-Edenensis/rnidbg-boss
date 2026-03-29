package com.opos.mobad.f.a.d;

import android.content.Context;
import com.opos.mobad.ad.e.n;
import com.opos.mobad.ad.e.p;
import com.opos.mobad.ad.e.q;
import com.opos.mobad.ad.e.s;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.o;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g extends com.opos.mobad.m.g {
    private n b;
    private n c;
    private n d;
    private String e;
    private o f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements com.opos.mobad.ad.e.o {
        private final int c;

        public a(int i) {
            this.c = i;
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdClick(p pVar) {
            if (g.this.i() != this.c) {
                return;
            }
            g.this.a(pVar);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdClose(p pVar) {
            if (g.this.i() != this.c) {
                return;
            }
            g.this.c(pVar);
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdFailed(int i, String str) {
            if (g.this.i() != this.c) {
                return;
            }
            g.this.c(i, str);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onAdShow(p pVar) {
            if (g.this.i() != this.c) {
                return;
            }
            g.this.b(pVar);
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdSuccess(List<p> list) {
            if (g.this.i() != this.c) {
                return;
            }
            com.opos.cmn.an.f.a.b("INativeTempletAdListener", "onAdSuccess:" + list);
            g.this.b(list);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onRenderFailed(q qVar, p pVar) {
            if (g.this.i() != this.c) {
                return;
            }
            g.this.a(qVar, pVar);
        }

        @Override // com.opos.mobad.ad.e.o
        public void onRenderSuccess(p pVar) {
            if (g.this.i() != this.c) {
                return;
            }
            g.this.d(pVar);
        }
    }

    public g(Context context, String str, com.opos.mobad.ad.e.o oVar, s sVar, com.opos.mobad.ad.c cVar, com.opos.mobad.ad.c cVar2) {
        super(oVar);
        this.f = oVar instanceof o ? (o) oVar : null;
        this.e = str;
        this.d = cVar2 != null ? cVar2.a(context, sVar, str, str, new a(1001)) : null;
        this.c = cVar != null ? cVar.a(context, sVar, str, str, new a(d.a.f8585a)) : null;
    }

    private n h() {
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
        n nVar = this.b;
        if (nVar == null) {
            return d.a.f8585a;
        }
        if (nVar == this.d) {
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
        n nVar = this.c;
        if (nVar != null) {
            nVar.b();
        }
        n nVar2 = this.d;
        if (nVar2 != null) {
            nVar2.b();
        }
        this.f = null;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        n nVar = this.b;
        if (nVar == null) {
            return;
        }
        nVar.c(i);
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        n nVar = this.b;
        return nVar == null ? super.e() : nVar.e();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        n nVar = this.b;
        return nVar == null ? super.f() : nVar.f();
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
        n nVarH = h();
        this.b = nVarH;
        if (nVarH == null) {
            return false;
        }
        nVarH.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.m.f
    public boolean b(String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("Mob-NTDelegator", "do load bidIds");
        n nVar = this.c;
        this.b = nVar;
        if (nVar == null) {
            return false;
        }
        nVar.a(str, i, list);
        return true;
    }
}
