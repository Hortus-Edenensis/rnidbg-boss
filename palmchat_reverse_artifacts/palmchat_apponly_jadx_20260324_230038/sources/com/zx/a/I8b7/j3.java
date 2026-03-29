package com.zx.a.I8b7;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.zx.sdk.api.PermissionCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class j3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f16815a;
    public final /* synthetic */ PermissionCallback b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l3 f16816a;

        public a(l3 l3Var) {
            this.f16816a = l3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16816a.dismiss();
            j3.this.b.onAuthorized();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l3 f16817a;

        public b(l3 l3Var) {
            this.f16817a = l3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16817a.dismiss();
            j3.this.b.onUnauthorized();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l3 f16818a;

        public c(l3 l3Var) {
            this.f16818a = l3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16818a.dismiss();
            r2.a("用户点击了解更多");
            j3.this.f16815a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://aid.mobileservice.cn/")));
        }
    }

    public j3(k3 k3Var, Activity activity, PermissionCallback permissionCallback) {
        this.f16815a = activity;
        this.b = permissionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l3 l3Var = new l3(this.f16815a);
            l3Var.b = new a(l3Var);
            l3Var.f16825a = new b(l3Var);
            l3Var.c = new c(l3Var);
            l3Var.show();
        } catch (Throwable th) {
            g3.a(th, f3.a("卓信ID授权弹窗异常: "));
        }
    }
}
