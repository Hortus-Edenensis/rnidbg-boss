package com.opos.mobad.c;

import android.content.Context;
import android.util.Log;
import com.opos.mobad.c.e;
import com.opos.mobad.c.e.n;
import com.opos.mobad.service.d.d;
import com.opos.mobad.service.tasks.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f8589a;
    private volatile boolean b = false;
    private f c;
    private com.opos.mobad.c.a.d d;
    private com.opos.mobad.service.b.a e;
    private com.opos.mobad.c.a f;
    private com.opos.mobad.c.a.b g;
    private com.opos.mobad.c.d.a h;
    private n i;
    private com.opos.mobad.c.b.a j;
    private com.opos.mobad.service.tasks.c k;
    private com.opos.mobad.c.c.a l;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements a.InterfaceC0774a {
        private a() {
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0774a
        public boolean a() {
            return !b.a().A();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0774a
        public boolean b() {
            return com.opos.mobad.service.d.b.a().isCanUseWriteExternal();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0774a
        public boolean c() {
            return com.opos.mobad.service.d.b.a().isCanUseWifiState();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0774a
        public boolean d() {
            return com.opos.mobad.service.d.b.a().isCanUsePhoneState();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0774a
        public boolean e() {
            return com.opos.mobad.service.d.b.a().isCanUseLocation();
        }

        @Override // com.opos.mobad.service.tasks.a.InterfaceC0774a
        public String f() {
            return com.opos.mobad.service.d.b.a().getMacAddress();
        }
    }

    private b() {
        c cVar = new c();
        this.d = new com.opos.mobad.c.a.d(cVar);
        this.e = new com.opos.mobad.service.b.a();
        this.f = new com.opos.mobad.c.a(cVar);
        this.g = new com.opos.mobad.c.a.b();
        this.h = new com.opos.mobad.c.d.a(cVar);
        this.i = new n(cVar);
        this.j = new com.opos.mobad.c.b.a(cVar);
        this.k = new com.opos.mobad.service.tasks.c(cVar);
        this.l = new com.opos.mobad.c.c.a(cVar);
        this.c = new f();
    }

    public static final com.opos.mobad.c.a.d a() {
        return m().d;
    }

    public static final com.opos.mobad.service.b.a b() {
        return m().e;
    }

    public static final com.opos.mobad.c.a c() {
        return m().f;
    }

    public static final com.opos.mobad.c.a.b d() {
        return m().g;
    }

    public static final com.opos.mobad.c.d.a e() {
        return m().h;
    }

    public static final n f() {
        return m().i;
    }

    public static final com.opos.mobad.c.b.a g() {
        return m().j;
    }

    public static final com.opos.mobad.service.tasks.c h() {
        return m().k;
    }

    public static final com.opos.mobad.c.c.a i() {
        return m().l;
    }

    public static final f j() {
        return m().c;
    }

    public static final boolean k() {
        return m().b;
    }

    public static final void l() {
        com.opos.mobad.service.d.a();
        synchronized (b.class) {
            b bVar = f8589a;
            if (bVar != null) {
                bVar.n();
                f8589a = null;
            }
        }
    }

    private static b m() {
        b bVar = f8589a;
        if (bVar == null) {
            synchronized (b.class) {
                bVar = new b();
                f8589a = bVar;
            }
        }
        return bVar;
    }

    private void n() {
        f fVarJ = j();
        if (fVarJ != null) {
            fVarJ.p();
        }
        h().a();
        c().a();
    }

    private final synchronized void a(Context context, e eVar, d.f fVar, d.InterfaceC0771d interfaceC0771d, d.g gVar, d.e eVar2, String str, d.c cVar, com.opos.mobad.ad.e eVar3) {
        try {
        } catch (Exception e) {
            Log.e("bService", "init() fail", e);
            this.b = false;
            l();
        }
        if (this.b) {
            com.opos.cmn.an.f.a.b("bService", "init() but had initialized.");
            return;
        }
        com.opos.mobad.ad.e cVar2 = eVar3 == null ? new com.opos.mobad.service.d.c() : eVar3;
        Context applicationContext = context.getApplicationContext();
        j().a(eVar, str, cVar, cVar2.getMinorsMode(), cVar2.getMinorsModeEnable(), cVar2.getMinorsModeAgeRange());
        com.opos.mobad.service.d.a(applicationContext, eVar.f8595a, eVar.h, eVar.j);
        g().a();
        com.opos.mobad.service.d.a(applicationContext, eVar.g, eVar.h, eVar.l, cVar2);
        a().a(applicationContext, eVar.b, eVar.c, eVar.k, fVar.a(), eVar.f);
        e().a(applicationContext, eVar.b, fVar.a(), fVar.c());
        d().a(applicationContext, eVar.b, fVar.a(), eVar.k);
        com.opos.mobad.service.d.a(applicationContext, interfaceC0771d, gVar, fVar, eVar2, cVar2);
        b().a(applicationContext, eVar.b, eVar.c, eVar.k, fVar.a());
        f().a(applicationContext);
        this.b = true;
        a(applicationContext, eVar.h, eVar.i);
        com.opos.cmn.an.f.a.b("bService", "init() custom default provider:", Boolean.valueOf(cVar2 instanceof com.opos.mobad.service.d.c));
    }

    private void a(final Context context, final boolean z, final int i) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.b.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    b.h().a(context.getApplicationContext(), z, i, new a());
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("bService", "", e);
                }
            }
        });
    }

    public static final void a(Context context, boolean z, d.a aVar, d.f fVar, boolean z2, boolean z3, int i, d.InterfaceC0771d interfaceC0771d, d.g gVar, d.c cVar, com.opos.mobad.ad.e eVar) {
        m().a(context, new e.a().a(z).a(aVar.a()).b(aVar.b()).a(aVar.d()).c(aVar.c()).b(z2).c(z3).b(i).c(0).d("CN").a(), fVar, interfaceC0771d, gVar, null, null, cVar, eVar);
    }
}
