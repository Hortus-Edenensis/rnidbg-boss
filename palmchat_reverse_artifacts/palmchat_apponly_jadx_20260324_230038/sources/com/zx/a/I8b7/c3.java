package com.zx.a.I8b7;

import com.zx.a.I8b7.l2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class c3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f16787a;

    public c3(x2 x2Var, boolean z) {
        this.f16787a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            u3 u3Var = l2.a.f16824a.f16823a;
            boolean z = this.f16787a;
            u3Var.getClass();
            if (z != m3.s) {
                m3.s = z ? 1 : 0;
                u3Var.a(20, m3.s + "", false);
            }
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }
}
