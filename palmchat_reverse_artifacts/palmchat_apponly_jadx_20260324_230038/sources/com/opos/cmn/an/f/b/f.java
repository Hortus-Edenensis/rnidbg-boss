package com.opos.cmn.an.f.b;

import com.opos.cmn.an.f.b.b.a;
import com.opos.cmn.an.f.b.b.c;
import com.opos.cmn.an.f.b.b.d;
import com.opos.cmn.an.f.b.b.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f7771a;
    private volatile boolean b = false;
    private volatile int c;
    private volatile int d;

    @Override // com.opos.cmn.an.f.b.b
    public void a() {
        if (this.b) {
            this.b = false;
            try {
                this.f7771a.a(new a.b().a(), 5);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.opos.cmn.an.f.b.b
    public void b(String str, Object obj) {
        a(5, str, obj, null, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void c(String str, String str2) {
        a(4, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void d(String str, String str2) {
        a(5, str, str2, null, 1);
    }

    private void a(int i, String str, Object obj, Throwable th, int i2) {
        try {
            if (!this.b || i == 1) {
                return;
            }
            if ((com.opos.cmn.an.f.c.f.b() || com.opos.cmn.an.f.c.f.j() || ((this.d != -1 && i >= this.d) || (c.b() && this.c != -1 && i >= this.c))) && str != null) {
                if (obj == null) {
                    obj = com.igexin.push.core.b.m;
                    i2 = 1;
                }
                this.f7771a.a(new d.b().a(i).a(obj).a(str).a(th).a(Thread.currentThread().getId()).b(Thread.currentThread().getName()).b(System.currentTimeMillis()).b(i2).a(), 2);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.b
    public void b(String str, String str2) {
        a(2, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void c(String str, String str2, Throwable th) {
        a(4, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void d(String str, String str2, Throwable th) {
        a(5, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void a(com.opos.cmn.an.f.a.b bVar) {
        try {
            this.c = bVar.c;
            this.d = bVar.b;
            com.opos.cmn.an.f.c.f.a(bVar.g);
            this.f7771a = new d();
            this.f7771a.a(new c.b().a(bVar).a(), 1);
            this.b = true;
        } catch (Exception unused) {
        }
    }

    @Override // com.opos.cmn.an.f.b.b
    public void b(String str, String str2, Throwable th) {
        a(2, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void c(String str, Object... objArr) {
        a(4, str, objArr, null, 2);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void d(String str, Object... objArr) {
        a(5, str, objArr, null, 2);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void a(com.opos.cmn.an.f.a.c cVar, com.opos.cmn.an.f.a.a aVar) {
        if (this.b) {
            try {
                this.f7771a.a(new g.b().a(cVar).a(aVar).a(), 3);
            } catch (Exception unused) {
                if (aVar != null) {
                    aVar.onUploaderFailed("unkown error");
                }
            }
        }
    }

    @Override // com.opos.cmn.an.f.b.b
    public void b(String str, Object... objArr) {
        a(2, str, objArr, null, 2);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void a(String str, Object obj) {
        a(2, str, obj, null, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void a(String str, Object obj, Throwable th) {
        a(3, str, obj, th, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void a(String str, String str2) {
        a(3, str, str2, null, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void a(String str, String str2, Throwable th) {
        a(3, str, str2, th, 1);
    }

    @Override // com.opos.cmn.an.f.b.b
    public void a(String str, Object... objArr) {
        a(3, str, objArr, null, 2);
    }
}
