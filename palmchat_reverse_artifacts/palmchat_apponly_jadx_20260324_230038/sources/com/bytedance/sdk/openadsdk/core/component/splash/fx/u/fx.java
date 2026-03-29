package com.bytedance.sdk.openadsdk.core.component.splash.fx.u;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5260a;
    public n b;
    private Context iz;
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr jk;
    private int n = 1;
    private iz pn;
    private boolean t;
    private String x;

    public fx(Context context, String str, iz izVar, n nVar, com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        this.iz = context;
        this.x = str;
        this.pn = izVar;
        this.t = izVar.pn();
        this.nr = izVar.nr();
        this.b = nVar;
        this.jk = nrVar;
    }

    public boolean a() {
        return this.t;
    }

    public iz b() {
        return this.pn;
    }

    public Context getContext() {
        return this.iz;
    }

    public String iz() {
        return this.x;
    }

    public int n() {
        return this.f5260a;
    }

    public n pn() {
        return this.b;
    }

    public com.bytedance.sdk.openadsdk.my.fx.fx.nr x() {
        return this.jk;
    }
}
