package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class p extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f3381a;
    private Object b;
    private boolean c;

    public p() {
        this.f3381a = null;
        this.b = new Object();
        this.c = false;
    }

    public void a() {
        if (b.f3368a) {
            b.a("Looper thread quit()");
        }
        Handler handler = this.f3381a;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        this.f3381a.getLooper().quit();
    }

    public void b() {
        synchronized (this.b) {
            try {
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!this.c) {
                this.b.wait();
            }
        }
    }

    public void c() {
        synchronized (this.b) {
            this.c = true;
            this.b.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f3381a = new Handler();
        if (b.f3368a) {
            b.a("new Handler() finish!!");
        }
        Looper.loop();
        if (b.f3368a) {
            b.a("LooperThread run() thread id:" + String.valueOf(Thread.currentThread().getId()));
        }
    }

    public p(String str) {
        super(str);
        this.f3381a = null;
        this.b = new Object();
        this.c = false;
    }
}
