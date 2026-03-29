package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class z0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f6490a;
    public final /* synthetic */ Callable b;

    public z0(n0 n0Var, Callable callable) {
        this.f6490a = n0Var;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f6490a.a(this.b.call());
        } catch (Exception e) {
            this.f6490a.a(e);
        }
    }
}
