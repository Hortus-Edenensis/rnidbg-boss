package com.zx.a.I8b7;

import com.zx.a.I8b7.l2;
import com.zx.sdk.api.PermissionCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class u2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionCallback f16870a;

    public u2(x2 x2Var, PermissionCallback permissionCallback) {
        this.f16870a = permissionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l2.a.f16824a.f16823a.c(1);
            r.a("用户已授权获取卓信ID");
            try {
                x2.a().a(m3.f16830a);
            } catch (Exception e) {
                r.b(e.getMessage());
            }
            this.f16870a.onAuthorized();
        } catch (Throwable th) {
            g3.a(th, f3.a("卓信ID授权失败 error: "));
        }
    }
}
