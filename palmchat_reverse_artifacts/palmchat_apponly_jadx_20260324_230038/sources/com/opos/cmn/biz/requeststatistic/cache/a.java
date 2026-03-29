package com.opos.cmn.biz.requeststatistic.cache;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f7865a;
    private int b;
    private int c;
    private volatile long d;
    private volatile long e;
    private b f;
    private Object g;

    /* JADX INFO: renamed from: com.opos.cmn.biz.requeststatistic.cache.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0656a implements b {
        public C0656a() {
        }

        @Override // com.opos.cmn.biz.requeststatistic.cache.a.b
        public void onFail() {
            a.this.a(this);
        }

        @Override // com.opos.cmn.biz.requeststatistic.cache.a.b
        public void onSuccess() {
            a.this.a(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onFail();

        void onSuccess();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(b bVar);
    }

    public a(c cVar, int i) {
        this(cVar, i, 0);
    }

    public void a() {
        if (this.d > 0 && this.b > SystemClock.elapsedRealtime() - this.d) {
            com.opos.cmn.an.f.a.a("ActionDriver", "start,doing write db!");
            return;
        }
        if (this.e > 0 && this.c > SystemClock.elapsedRealtime() - this.e) {
            com.opos.cmn.an.f.a.a("ActionDriver", "start,end no timeout!");
            return;
        }
        synchronized (this.g) {
            if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
                if (this.e <= 0 || this.c <= SystemClock.elapsedRealtime() - this.e) {
                    this.d = SystemClock.elapsedRealtime();
                    this.e = -1L;
                    C0656a c0656a = new C0656a();
                    this.f = c0656a;
                    this.f7865a.a(c0656a);
                }
            }
        }
    }

    public a(c cVar, int i, int i2) {
        this.d = -1L;
        this.e = -1L;
        this.g = new Object();
        this.f7865a = cVar;
        this.b = i;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("endActionIfRunning,is callback change=");
        sb.append(bVar != this.f);
        com.opos.cmn.an.f.a.a("ActionDriver", sb.toString());
        if (bVar != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == bVar) {
                this.d = -1L;
                this.e = SystemClock.elapsedRealtime();
                this.f = null;
            }
        }
    }
}
