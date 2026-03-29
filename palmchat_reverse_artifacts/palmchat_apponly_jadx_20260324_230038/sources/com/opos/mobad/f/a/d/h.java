package com.opos.mobad.f.a.d;

import android.content.Context;
import com.opos.mobad.c.a.d;
import com.opos.mobad.f.a.a.o;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class h extends com.opos.mobad.m.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f8856a;
    private com.opos.mobad.ad.f.a b;
    private com.opos.mobad.ad.f.a c;
    private com.opos.mobad.ad.f.a d;
    private o g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements com.opos.mobad.ad.f.b {
        private final int c;

        public a(int i) {
            this.c = i;
        }

        @Override // com.opos.mobad.ad.f.b, com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.q();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.n();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.e(i, str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.p();
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.r();
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageClose() {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.m();
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageOpen() {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.k();
        }

        @Override // com.opos.mobad.ad.k
        public void onReward(Object... objArr) {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.a(objArr);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayClose(long j) {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.b(j);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayComplete() {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.j();
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayError(String str) {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.e(str);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayStart() {
            if (h.this.t() != this.c) {
                return;
            }
            h.this.i();
        }
    }

    public h(Context context, String str, com.opos.mobad.ad.f.b bVar, com.opos.mobad.ad.c cVar, com.opos.mobad.ad.c cVar2) {
        super(bVar);
        this.g = bVar instanceof o ? (o) bVar : null;
        this.f8856a = str;
        this.d = cVar2 != null ? cVar2.a(context, str, str, false, (com.opos.mobad.ad.f.b) new a(1001)) : null;
        this.c = cVar != null ? cVar.a(context.getApplicationContext(), str, str, false, (com.opos.mobad.ad.f.b) new a(d.a.f8585a)) : null;
    }

    private com.opos.mobad.ad.f.a s() {
        if (this.d == null) {
            return this.c;
        }
        int iA = d.a().a(this.f8856a);
        if (iA == 0) {
            return this.d;
        }
        if (iA != 6) {
            com.opos.mobad.c.b.e().c().a(this.f8856a, iA, d.a().b());
        }
        this.d.b();
        this.d = null;
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t() {
        com.opos.mobad.ad.f.a aVar = this.b;
        if (aVar == null) {
            return -1;
        }
        if (aVar == this.d) {
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
        com.opos.mobad.ad.f.a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
        com.opos.mobad.ad.f.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.b();
        }
        this.g = null;
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public void c(int i) {
        com.opos.mobad.ad.f.a aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.c(i);
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int e() {
        com.opos.mobad.ad.f.a aVar = this.b;
        return aVar == null ? super.e() : aVar.e();
    }

    @Override // com.opos.mobad.ad.j.a, com.opos.mobad.ad.j
    public int f() {
        com.opos.mobad.ad.f.a aVar = this.b;
        return aVar == null ? super.f() : aVar.f();
    }

    @Override // com.opos.mobad.m.j
    public void b(int i, String str) {
        o oVar = this.g;
        if (oVar != null) {
            oVar.a(t(), i, str);
        }
    }

    @Override // com.opos.mobad.m.j
    public boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i) {
        com.opos.cmn.an.f.a.b("Mob-RWDelegator", "do load");
        com.opos.mobad.ad.f.a aVarS = s();
        this.b = aVarS;
        if (aVarS == null) {
            return false;
        }
        aVarS.a(str, i);
        return true;
    }

    @Override // com.opos.mobad.m.j
    public boolean b(String str, int i, List<String> list) {
        com.opos.cmn.an.f.a.b("Mob-RWDelegator", "do load bidIds");
        com.opos.mobad.ad.f.a aVar = this.c;
        this.b = aVar;
        if (aVar == null) {
            return false;
        }
        aVar.a(str, i, list);
        return true;
    }

    @Override // com.opos.mobad.m.h
    public boolean b(boolean z) {
        com.opos.mobad.ad.f.a aVar = this.b;
        if (aVar == null) {
            return false;
        }
        aVar.a(z);
        return true;
    }
}
