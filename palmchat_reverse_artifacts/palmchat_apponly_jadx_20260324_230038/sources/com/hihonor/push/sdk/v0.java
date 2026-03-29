package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class v0<TResult> implements j0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f6480a;
    public l0 b;
    public final Object c = new Object();

    public v0(Executor executor, l0 l0Var) {
        this.b = l0Var;
        this.f6480a = executor;
    }

    @Override // com.hihonor.push.sdk.j0
    public final void a(a1 a1Var) {
        if (a1Var.e()) {
            return;
        }
        a1Var.d();
        this.f6480a.execute(new u0(this, a1Var));
    }
}
