package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class w0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f6482a;
    public final /* synthetic */ x0 b;

    public w0(x0 x0Var, a1 a1Var) {
        this.b = x0Var;
        this.f6482a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.c) {
            Object obj = this.b.b;
            if (obj != null) {
                this.f6482a.c();
                ((y0) obj).f6486a.countDown();
            }
        }
    }
}
