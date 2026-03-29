package com.zx.a.I8b7;

import com.zx.a.I8b7.l2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class b3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f16784a;

    public b3(x2 x2Var, boolean z) {
        this.f16784a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l2.a.f16824a.f16823a.b(this.f16784a ? 1 : 0);
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXCore setEnable failed: "));
        }
    }
}
