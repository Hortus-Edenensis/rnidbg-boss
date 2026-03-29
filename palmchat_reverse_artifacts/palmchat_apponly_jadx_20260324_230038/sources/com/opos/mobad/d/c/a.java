package com.opos.mobad.d.c;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f8753a;
    private b b;

    /* JADX INFO: renamed from: com.opos.mobad.d.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0734a {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8754a;
        private int b;
        private InterfaceC0734a e;
        private volatile long c = -1;
        private volatile long d = -1;
        private Object f = new Object();

        public b(int i, int i2) {
            this.f8754a = i;
            this.b = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(InterfaceC0734a interfaceC0734a, boolean z) {
            if (interfaceC0734a != this.e) {
                return;
            }
            synchronized (this.f) {
                if (this.e == interfaceC0734a) {
                    this.c = -1L;
                    if (z) {
                        this.d = SystemClock.elapsedRealtime();
                    }
                    this.e = null;
                }
            }
        }

        public void a(c cVar) {
            if (cVar == null) {
                com.opos.cmn.an.f.a.b("action driver", "start but null action");
                return;
            }
            if (this.c <= 0 || this.f8754a <= SystemClock.elapsedRealtime() - this.c) {
                if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
                    synchronized (this.f) {
                        if (this.c <= 0 || this.f8754a <= SystemClock.elapsedRealtime() - this.c) {
                            if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
                                this.c = SystemClock.elapsedRealtime();
                                this.d = -1L;
                                InterfaceC0734a interfaceC0734a = new InterfaceC0734a() { // from class: com.opos.mobad.d.c.a.b.1
                                    @Override // com.opos.mobad.d.c.a.InterfaceC0734a
                                    public void a() {
                                        b.this.a(this, true);
                                    }

                                    @Override // com.opos.mobad.d.c.a.InterfaceC0734a
                                    public void b() {
                                        b.this.a(this, false);
                                    }
                                };
                                this.e = interfaceC0734a;
                                cVar.a(interfaceC0734a);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(InterfaceC0734a interfaceC0734a);
    }

    public a(c cVar, int i, int i2) {
        this.f8753a = cVar;
        this.b = new b(i, i2);
    }

    public void a() {
        this.b.a(this.f8753a);
    }
}
