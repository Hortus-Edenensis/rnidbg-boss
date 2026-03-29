package com.bytedance.sdk.openadsdk.core.component.splash.fx.u;

import com.bytedance.sdk.openadsdk.core.kj.oa;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends u {
    public static int b = 1;
    public static int pn = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.component.splash.u.pn f5264a;
    private com.bytedance.sdk.openadsdk.my.fx.fx.nr iz;
    private String n;
    private oa x;

    public pn(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, oa oaVar, com.bytedance.sdk.openadsdk.core.component.splash.u.pn pnVar) {
        this.iz = nrVar;
        this.x = oaVar;
        if (nrVar != null) {
            this.n = nrVar.b();
        }
        this.f5264a = pnVar;
    }

    public com.bytedance.sdk.openadsdk.my.fx.fx.nr b() {
        return this.iz;
    }

    public String iz() {
        return this.n;
    }

    public oa pn() {
        return this.x;
    }

    public com.bytedance.sdk.openadsdk.core.component.splash.u.pn x() {
        return this.f5264a;
    }
}
