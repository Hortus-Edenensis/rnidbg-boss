package com.zx.a.I8b7;

import com.zx.sdk.api.ZXIDListener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class s2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16859a;
    public final /* synthetic */ ZXIDListener b;

    public s2(x2 x2Var, String str, ZXIDListener zXIDListener) {
        this.f16859a = str;
        this.b = zXIDListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            x2.a().a(this.f16859a, this.b);
        } catch (Throwable th) {
            ZXIDListener zXIDListener = this.b;
            if (zXIDListener != null) {
                zXIDListener.onFailed(10000, th.getMessage());
            }
            g3.a(th, f3.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }
}
