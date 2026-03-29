package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class s0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f6474a;
    public final /* synthetic */ t0 b;

    public s0(t0 t0Var, a1 a1Var) {
        this.b = t0Var;
        this.f6474a = a1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.c) {
            k0<TResult> k0Var = this.b.b;
            if (k0Var != 0) {
                k0Var.a(this.f6474a);
            }
        }
    }
}
