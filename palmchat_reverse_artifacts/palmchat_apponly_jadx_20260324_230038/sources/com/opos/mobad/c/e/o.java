package com.opos.mobad.c.e;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.i.a;
import com.opos.mobad.c.e.m;
import com.opos.mobad.provider.record.CacheEntity;
import com.opos.mobad.service.g.f;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.c.d f8615a;
    private Context b;
    private m c = new m(1, 1, 80, 0.0d, new m.a() { // from class: com.opos.mobad.c.e.o.1
        @Override // com.opos.mobad.c.e.m.a
        public void a(m mVar) {
            o.this.e.a();
        }
    });
    private m d = new m(1, 1, 30, 0.0d, new m.a() { // from class: com.opos.mobad.c.e.o.2
        @Override // com.opos.mobad.c.e.m.a
        public void a(m mVar) {
            o.this.e.a();
        }
    });
    private com.opos.cmn.i.a e = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.c.e.o.3
        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0673a interfaceC0673a) {
            o.this.c();
            interfaceC0673a.a();
        }
    }, 0, 180000);
    private com.opos.cmn.i.a f = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.c.e.o.4
        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0673a interfaceC0673a) {
            o.this.d();
            interfaceC0673a.a();
        }
    });
    private com.opos.mobad.provider.record.a g;
    private l h;
    private k i;
    private j j;
    private j k;
    private j l;
    private com.opos.mobad.service.h.a m;
    private k n;

    public o(com.opos.mobad.c.d dVar, Context context) {
        this.f8615a = dVar;
        this.b = context.getApplicationContext();
        this.g = new com.opos.mobad.provider.record.a(context);
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.c.e.o.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CacheEntity cacheEntityA = o.this.g.a();
                    o.this.c.a(cacheEntityA.f9170a, cacheEntityA.b);
                    CacheEntity cacheEntityB = o.this.g.b();
                    o.this.d.a(cacheEntityB.f9170a, cacheEntityB.b);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
        a();
    }

    private void b() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.e.o.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.g.c();
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f8615a.d().c().a(this.c.c(), this.c.d(), this.d.c(), this.d.d());
        b();
    }

    private void a() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.e.o.6
            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                try {
                    int iE = o.this.g.e();
                    com.opos.cmn.an.f.a.b("watch", "check cr amount:" + iE);
                    if (iE >= 5) {
                        oVar = o.this;
                    } else {
                        long jF = o.this.g.f();
                        com.opos.cmn.an.f.a.b("watch", "check cr time:" + jF);
                        if (jF <= 0 || System.currentTimeMillis() - jF <= 86400000) {
                            return;
                        } else {
                            oVar = o.this;
                        }
                    }
                    oVar.a(iE);
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.b("watch", "report cr fail", th);
                }
            }
        });
    }

    private void c(final int i, final int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.e.o.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.g.a(new CacheEntity(i, i2));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.i != null) {
            f.a aVarC = this.f8615a.d().c();
            k kVar = this.i;
            aVarC.b(kVar.f8604a, kVar.b);
            this.i = null;
            return;
        }
        if (this.h != null) {
            f.a aVarC2 = this.f8615a.d().c();
            l lVar = this.h;
            aVarC2.a(lVar.f8605a, lVar.b);
            this.h = null;
            return;
        }
        j jVar = this.j;
        if (jVar != null) {
            this.f8615a.d().c().a(jVar.f8603a);
            this.j = null;
        }
        j jVar2 = this.k;
        if (jVar2 != null) {
            this.f8615a.d().c().b(jVar2.f8603a);
            this.k = null;
        }
        j jVar3 = this.l;
        if (jVar3 != null) {
            this.f8615a.d().c().c(jVar3.f8603a);
            this.l = null;
        }
        e();
        if (this.n != null) {
            f.a aVarC3 = this.f8615a.d().c();
            k kVar2 = this.n;
            aVarC3.c(kVar2.f8604a, kVar2.b);
            this.n = null;
        }
    }

    private void e() {
        try {
            com.opos.mobad.service.h.a aVar = this.m;
            if (aVar != null) {
                this.m = null;
                StringWriter stringWriter = new StringWriter();
                aVar.f9246a.printStackTrace(new PrintWriter(stringWriter));
                this.f8615a.d().c().e(stringWriter.toString());
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("watch", "record strategy but exception", th);
        }
    }

    public void b(int i, int i2) {
        d(this.d.c() + i, this.d.d() + i2);
        this.d.a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) throws Exception {
        String strG = this.g.g();
        String strH = this.g.h();
        this.f8615a.d().c().a(i, strG, !TextUtils.isEmpty(strH) ? new JSONObject(strH) : null);
        this.g.a((String) null);
    }

    private void d(final int i, final int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.e.o.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.g.b(new CacheEntity(i, i2));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("", "", e);
                }
            }
        });
    }

    public void a(int i, int i2) {
        this.c.a(i, i2);
        c(i + this.c.c(), i2 + this.c.d());
    }

    public void b(String str) {
        this.k = new j(str);
        this.f.a();
    }

    public void c(String str) {
        this.l = new j(str);
        this.f.a();
    }

    public void b(Throwable th) {
        if (th == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("", "record strategy error");
        this.m = new com.opos.mobad.service.h.a(th);
        this.f.a();
    }

    public void a(String str) {
        this.j = new j(str);
        this.f.a();
    }

    public void a(String str, int i) {
        this.n = new k(str, i);
        this.f.a();
    }

    public void a(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            this.g.a(stringWriter.toString(), com.opos.mobad.o.e.a(this.b));
        } catch (Throwable th2) {
            com.opos.cmn.an.f.a.b("watch", "add cr fail", th2);
        }
    }
}
