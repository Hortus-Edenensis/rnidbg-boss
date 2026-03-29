package com.opos.mobad.c.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.opos.cmn.i.a;
import com.opos.mobad.c.e.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8607a;
    private m b;
    private m c;
    private LruCache<String, m> d;
    private LruCache<String, m> e;
    private LruCache<String, m> f;
    private com.opos.cmn.i.a g;
    private com.opos.cmn.i.a h;
    private com.opos.cmn.i.a i;
    private com.opos.cmn.i.a j;
    private String k;
    private String l;
    private String m;
    private Throwable n;
    private o o;
    private com.opos.mobad.c.d p;

    public n(com.opos.mobad.c.d dVar) {
        this.p = dVar;
    }

    private m d(final String str) {
        m mVar;
        m mVar2 = this.f.get(str);
        if (mVar2 != null) {
            return mVar2;
        }
        synchronized (this.f) {
            mVar = this.f.get(str);
            if (mVar == null) {
                mVar = new m(180000, 10, new m.a() { // from class: com.opos.mobad.c.e.n.7
                    @Override // com.opos.mobad.c.e.m.a
                    public void a(m mVar3) {
                        n.this.o.a(str, mVar3.d());
                    }
                });
                this.f.put(str, mVar);
            }
        }
        return mVar;
    }

    public void b(String str) {
    }

    public void c(String str) {
        if (this.f8607a == null || TextUtils.isEmpty(str)) {
            return;
        }
        d(str).b();
    }

    public void a(Context context) {
        this.f8607a = context;
        this.o = new o(this.p, context);
        this.c = new m(180000, 10, new m.a() { // from class: com.opos.mobad.c.e.n.1
            @Override // com.opos.mobad.c.e.m.a
            public void a(m mVar) {
                n.this.o.b(mVar.c(), mVar.d());
            }
        });
        this.b = new m(180000, 10, new m.a() { // from class: com.opos.mobad.c.e.n.2
            @Override // com.opos.mobad.c.e.m.a
            public void a(m mVar) {
                n.this.o.a(mVar.c(), mVar.d());
            }
        });
        this.d = new LruCache<>(10);
        this.e = new LruCache<>(10);
        this.f = new LruCache<>(10);
        this.g = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.c.e.n.3
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0673a interfaceC0673a) {
                String str = n.this.k;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0673a.b();
                } else {
                    n.this.o.a(str);
                    interfaceC0673a.a();
                }
            }
        }, 0, 180000);
        this.h = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.c.e.n.4
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0673a interfaceC0673a) {
                String str = n.this.l;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0673a.b();
                } else {
                    n.this.o.b(str);
                    interfaceC0673a.a();
                }
            }
        }, 0, 180000);
        this.i = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.c.e.n.5
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0673a interfaceC0673a) {
                String str = n.this.m;
                if (TextUtils.isEmpty(str)) {
                    interfaceC0673a.b();
                } else {
                    n.this.o.c(str);
                    interfaceC0673a.a();
                }
            }
        }, 0, 180000);
        this.j = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.c.e.n.6
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0673a interfaceC0673a) {
                Throwable th = n.this.n;
                if (th == null) {
                    interfaceC0673a.b();
                    return;
                }
                n.this.o.b(th);
                n.this.n = null;
                interfaceC0673a.a();
            }
        }, 0, 180000);
    }

    public void b(Throwable th) {
        if (this.o == null || th == null) {
            return;
        }
        this.n = th;
        this.j.a();
    }

    public void a(String str) {
    }

    public void b(boolean z) {
        if (this.f8607a == null) {
            return;
        }
        if (z) {
            this.c.a();
        }
        this.c.b();
    }

    public void a(Throwable th) {
        o oVar = this.o;
        if (oVar != null) {
            oVar.a(th);
        }
    }

    public void a(boolean z) {
        if (this.f8607a == null) {
            return;
        }
        if (z) {
            this.b.a();
        }
        this.b.b();
    }
}
