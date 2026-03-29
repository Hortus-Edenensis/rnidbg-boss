package com.amap.api.col.p0002sl;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f3041a;
    protected int b;
    private Handler c = null;
    private int d = 0;
    private boolean e = false;
    private boolean f = true;
    private Runnable g = new Runnable() { // from class: com.amap.api.col.2sl.p.1
        @Override // java.lang.Runnable
        public final void run() {
            p.this.j();
            if (!p.this.g()) {
                if (p.this.c != null) {
                    p.this.c.removeCallbacks(this);
                }
                p.c(p.this);
                if (p.this.f) {
                    p.this.c();
                    return;
                } else {
                    p.this.b();
                    return;
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            p.this.a();
            p.this.k();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            int i = p.this.b;
            if (jCurrentTimeMillis2 < i) {
                try {
                    Thread.sleep(((long) i) - jCurrentTimeMillis2);
                } catch (InterruptedException e) {
                    ct.a(e, "AnimBase", "run");
                }
            }
        }
    };

    public p(int i, int i2) {
        this.f3041a = i;
        this.b = i2;
    }

    public static /* synthetic */ Handler c(p pVar) {
        pVar.c = null;
        return null;
    }

    private void i() {
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int i = this.d + this.b;
        this.d = i;
        int i2 = this.f3041a;
        if (i2 == -1 || i <= i2) {
            return;
        }
        i();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        Handler handler = this.c;
        if (handler != null) {
            handler.post(this.g);
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public final void f() {
        this.e = false;
    }

    public final boolean g() {
        return this.e;
    }

    public final void h() {
        this.f = true;
    }

    public void a(int i) {
        this.f3041a = i;
    }

    public final void d() {
        if (!g()) {
            this.c = new Handler(Looper.getMainLooper());
            this.e = true;
            this.f = false;
            this.d = 0;
        }
        k();
    }

    public final void e() {
        w.a().b();
        i();
        this.g.run();
    }
}
