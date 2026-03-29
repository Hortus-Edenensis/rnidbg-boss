package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class t0<TResult> implements j0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f6476a;
    public k0<TResult> b;
    public final Object c = new Object();

    public t0(Executor executor, k0<TResult> k0Var) {
        this.b = k0Var;
        this.f6476a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1 a1Var) {
        this.f6476a.execute(new s0(this, a1Var));
    }
}
