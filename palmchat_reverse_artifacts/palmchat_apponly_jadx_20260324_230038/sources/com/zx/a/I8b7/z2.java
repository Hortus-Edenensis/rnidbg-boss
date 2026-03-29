package com.zx.a.I8b7;

import com.zx.sdk.api.Callback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class z2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16891a;
    public final /* synthetic */ Callback b;

    public z2(x2 x2Var, String str, Callback callback) {
        this.f16891a = str;
        this.b = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            x2.a().b(this.f16891a, this.b);
        } catch (Throwable th) {
            Callback callback = this.b;
            if (callback != null) {
                callback.onFailed(10000, th.getMessage());
            }
            g3.a(th, f3.a("ZXManager.getTag() failed: "));
        }
    }
}
