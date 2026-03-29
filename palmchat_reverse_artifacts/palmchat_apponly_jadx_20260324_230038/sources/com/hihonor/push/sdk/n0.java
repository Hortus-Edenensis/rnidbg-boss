package com.hihonor.push.sdk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class n0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1 f6463a = new a1();

    public void a(TResult tresult) {
        a1 a1Var = this.f6463a;
        synchronized (a1Var.f6439a) {
            if (!a1Var.b) {
                a1Var.b = true;
                a1Var.c = tresult;
                a1Var.f6439a.notifyAll();
                a1Var.a();
            }
        }
    }

    public void a(Exception exc) {
        a1 a1Var = this.f6463a;
        synchronized (a1Var.f6439a) {
            if (!a1Var.b) {
                a1Var.b = true;
                a1Var.d = exc;
                a1Var.f6439a.notifyAll();
                a1Var.a();
            }
        }
    }
}
