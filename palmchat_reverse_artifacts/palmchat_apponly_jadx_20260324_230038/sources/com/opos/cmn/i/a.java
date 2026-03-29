package com.opos.cmn.i;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f8024a;
    private int b;
    private int c;
    private volatile long d;
    private volatile long e;
    private InterfaceC0673a f;
    private Object g;

    /* JADX INFO: renamed from: com.opos.cmn.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0673a {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(InterfaceC0673a interfaceC0673a);
    }

    public a(b bVar) {
        this(bVar, Integer.MAX_VALUE, 0);
    }

    public void a() {
        if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
            if (this.e <= 0 || this.c <= SystemClock.elapsedRealtime() - this.e) {
                synchronized (this.g) {
                    if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
                        if (this.e <= 0 || this.c <= SystemClock.elapsedRealtime() - this.e) {
                            this.d = SystemClock.elapsedRealtime();
                            this.e = -1L;
                            InterfaceC0673a interfaceC0673a = new InterfaceC0673a() { // from class: com.opos.cmn.i.a.1
                                @Override // com.opos.cmn.i.a.InterfaceC0673a
                                public void a() {
                                    a.this.a(this, true);
                                }

                                @Override // com.opos.cmn.i.a.InterfaceC0673a
                                public void b() {
                                    a.this.a(this, false);
                                }
                            };
                            this.f = interfaceC0673a;
                            this.f8024a.a(interfaceC0673a);
                        }
                    }
                }
            }
        }
    }

    public a(b bVar, int i, int i2) {
        this.d = -1L;
        this.e = -1L;
        this.g = new Object();
        this.f8024a = bVar;
        this.b = i;
        this.c = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0673a interfaceC0673a, boolean z) {
        if (interfaceC0673a != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == interfaceC0673a) {
                this.d = -1L;
                if (z) {
                    this.e = SystemClock.elapsedRealtime();
                }
                this.f = null;
            }
        }
    }
}
