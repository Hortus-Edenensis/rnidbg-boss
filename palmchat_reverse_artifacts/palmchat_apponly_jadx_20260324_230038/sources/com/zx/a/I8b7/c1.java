package com.zx.a.I8b7;

import com.zx.a.I8b7.v3;
import com.zx.sdk.api.PermissionCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class c1 implements PermissionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PermissionCallback f16786a;

    public c1(PermissionCallback permissionCallback) {
        this.f16786a = permissionCallback;
    }

    @Override // com.zx.sdk.api.PermissionCallback
    public void onAuthorized() {
        try {
            if (this.f16786a != null) {
                x2 x2VarB = x2.b();
                PermissionCallback permissionCallback = this.f16786a;
                x2VarB.getClass();
                v3.f.f16875a.f16874a.execute(new u2(x2VarB, permissionCallback));
            }
        } catch (Throwable th) {
            r2.a(th);
        }
    }

    @Override // com.zx.sdk.api.PermissionCallback
    public void onUnauthorized() {
        try {
            if (this.f16786a != null) {
                x2 x2VarB = x2.b();
                x2VarB.getClass();
                v3.f.f16875a.f16874a.execute(new v2(x2VarB));
                this.f16786a.onUnauthorized();
            }
        } catch (Throwable th) {
            r2.a(th);
        }
    }
}
