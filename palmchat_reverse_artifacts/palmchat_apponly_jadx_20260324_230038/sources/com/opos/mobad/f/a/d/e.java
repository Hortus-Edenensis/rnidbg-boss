package com.opos.mobad.f.a.d;

import android.app.Activity;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.o;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e extends com.opos.mobad.m.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.d.a f8853a;
    private com.opos.mobad.ad.d.a b;
    private com.opos.mobad.ad.d.a c;
    private String d;
    private o g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements com.opos.mobad.ad.c.a, com.opos.mobad.ad.d.b {
        private final int b;

        public a(int i) {
            this.b = i;
        }

        @Override // com.opos.mobad.ad.c.a
        public void a() {
            if (e.this.g instanceof com.opos.mobad.ad.c.a) {
                ((com.opos.mobad.ad.c.a) e.this.g).a();
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.q();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.n();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.e(i, str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.p();
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            if (e.this.h() != this.b) {
                return;
            }
            e.this.r();
        }
    }

    public e(Activity activity, String str, com.opos.mobad.ad.d.b bVar, com.opos.mobad.ad.d.e eVar, com.opos.mobad.ad.c cVar, com.opos.mobad.ad.c cVar2) {
        super(bVar);
        this.g = bVar instanceof o ? (o) bVar : null;
        this.d = str;
        this.c = cVar2 != null ? cVar2.a(activity, str, str, eVar, new a(1001)) : null;
        this.b = cVar != null ? cVar.a(activity, str, str, eVar, new a(d.a.f8585a)) : null;
    }

    private com.opos.mobad.ad.d.a g() {
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
    public int h() {
        com.opos.mobad.ad.d.a aVar = this.f8853a;
        if (aVar == null) {
            return d.a.f8585a;
        }
        if (aVar == this.c) {
            return 1001;
        }
        return d.a.f8585a;
    }

    @Override // com.opos.mobad.m.j, com.opos.mobad.ad.b
    public void b() {
        if (c() == 5) {
            return;
        }
        super.b();
        com.opos.mobad.ad.d.a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
        com.opos.mobad.ad.d.a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.g = null;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        com.opos.mobad.ad.d.a aVar = this.f8853a;
        if (aVar == null) {
            return;
        }
        aVar.c(i);
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        com.opos.mobad.ad.d.a aVar = this.f8853a;
        return aVar == null ? super.e() : aVar.e();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        com.opos.mobad.ad.d.a aVar = this.f8853a;
        return aVar == null ? super.f() : aVar.f();
    }

    @Override // com.opos.mobad.m.j
    public void b(int i, String str) {
        o oVar = this.g;
        if (oVar != null) {
            oVar.a(h(), i, str);
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.k
    public boolean b(Activity activity) {
        com.opos.mobad.ad.d.a aVar = this.f8853a;
        if (aVar == null) {
            return false;
        }
        aVar.a(activity);
        return true;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("Mob-InterDelegator", "do load");
        com.opos.mobad.ad.d.a aVarG = g();
        this.f8853a = aVarG;
        if (aVarG == null) {
            return false;
        }
        aVarG.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("Mob-InterDelegator", "do load bidIds");
        com.opos.mobad.ad.d.a aVar = this.b;
        this.f8853a = aVar;
        if (aVar == null) {
            return false;
        }
        aVar.a(str, i, list);
        return true;
    }
}
