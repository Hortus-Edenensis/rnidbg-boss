package com.opos.cmn.biz.monitor.a;

import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f7832a;
    private int b;
    private int c;
    private InterfaceC0650a f;
    private volatile long d = -1;
    private volatile long e = -1;
    private Object g = new Object();

    /* JADX INFO: renamed from: com.opos.cmn.biz.monitor.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0650a {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(InterfaceC0650a interfaceC0650a);
    }

    public a(b bVar, int i, int i2) {
        this.f7832a = bVar;
        this.b = i;
        this.c = i2;
    }

    public void a() {
        if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
            if (this.e <= 0 || this.c <= SystemClock.elapsedRealtime() - this.e) {
                synchronized (this.g) {
                    if (this.d <= 0 || this.b <= SystemClock.elapsedRealtime() - this.d) {
                        if (this.e <= 0 || this.c <= SystemClock.elapsedRealtime() - this.e) {
                            this.d = SystemClock.elapsedRealtime();
                            this.e = -1L;
                            InterfaceC0650a interfaceC0650a = new InterfaceC0650a() { // from class: com.opos.cmn.biz.monitor.a.a.1
                                @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0650a
                                public void a() {
                                    a.this.a(this);
                                }

                                @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0650a
                                public void b() {
                                    a.this.a(this);
                                }
                            };
                            this.f = interfaceC0650a;
                            this.f7832a.a(interfaceC0650a);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InterfaceC0650a interfaceC0650a) {
        if (interfaceC0650a != this.f) {
            return;
        }
        synchronized (this.g) {
            if (this.f == interfaceC0650a) {
                this.d = -1L;
                this.e = SystemClock.elapsedRealtime();
                this.f = null;
            }
        }
    }
}
