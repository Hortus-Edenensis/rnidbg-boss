package com.zx.a.I8b7;

import android.app.Activity;
import android.os.Handler;
import com.zx.a.I8b7.k3;
import com.zx.sdk.api.PermissionCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class w2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PermissionCallback f16878a;
    public final /* synthetic */ Activity b;

    public w2(x2 x2Var, PermissionCallback permissionCallback, Activity activity) {
        this.f16878a = permissionCallback;
        this.b = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            c1 c1Var = new c1(this.f16878a);
            Handler handler = k3.f16820a;
            k3 k3Var = k3.a.f16821a;
            if (k3Var.b()) {
                k3.f16820a.post(new j3(k3Var, this.b, c1Var));
            } else if (k3Var.a()) {
                c1Var.onAuthorized();
            } else {
                c1Var.onUnauthorized();
            }
        } catch (Throwable th) {
            g3.a(th, f3.a("ZXManager.registerListener(listener) failed: "));
        }
    }
}
