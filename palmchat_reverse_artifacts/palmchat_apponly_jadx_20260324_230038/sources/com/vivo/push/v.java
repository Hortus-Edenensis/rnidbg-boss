package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.gdt.action.ActionUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11312a;
    private String b;

    public v(int i) {
        this.f11312a = -1;
        if (i < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f11312a = i;
    }

    private void e(d dVar) {
        dVar.a(com.heytap.mcssdk.constant.b.y, this.f11312a);
        dVar.a("client_pkgname", this.b);
        c(dVar);
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.f11312a;
    }

    public abstract void c(d dVar);

    public boolean c() {
        return false;
    }

    public abstract void d(d dVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(Intent intent) {
        d dVarA = d.a(intent);
        if (dVarA == null) {
            com.vivo.push.util.t.b("PushCommand", "bundleWapper is null");
            return;
        }
        dVarA.a(ActionUtils.METHOD, this.f11312a);
        e(dVarA);
        Bundle bundleB = dVarA.b();
        if (bundleB != null) {
            intent.putExtras(bundleB);
        }
    }

    public final void a(Intent intent) {
        d dVarA = d.a(intent);
        if (dVarA == null) {
            com.vivo.push.util.t.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(dVarA);
        Bundle bundleB = dVarA.b();
        if (bundleB != null) {
            intent.putExtras(bundleB);
        }
    }

    public final void a(d dVar) {
        String strA = x.a(this.f11312a);
        if (strA == null) {
            strA = "";
        }
        dVar.a(ActionUtils.METHOD, strA);
        e(dVar);
    }

    public final void b(d dVar) {
        String strA = dVar.a();
        if (!TextUtils.isEmpty(strA)) {
            this.b = strA;
        } else {
            this.b = dVar.a("client_pkgname");
        }
        d(dVar);
    }
}
