package com.bytedance.sdk.openadsdk.core.component.splash.fx.u;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.my.fx.nr.nr f5265a;
    private int b;
    private boolean iz;
    private long jk;
    private boolean n;
    private String pn;
    private int t;
    private int x;

    public x() {
        this.b = -1;
        this.pn = "unknown";
        this.iz = false;
        this.n = false;
        this.t = -1;
    }

    public com.bytedance.sdk.openadsdk.my.fx.nr.nr a() {
        return this.f5265a;
    }

    public int b() {
        return this.b;
    }

    public void fx(int i) {
        this.t = i;
    }

    public boolean iz() {
        return this.iz;
    }

    public boolean n() {
        return this.n;
    }

    public void nr(int i) {
        this.b = i;
    }

    public String pn() {
        return TextUtils.isEmpty(this.pn) ? "unknown" : this.pn;
    }

    public void u(String str) {
        this.pn = str;
    }

    public int x() {
        return this.x;
    }

    public void b(int i) {
        this.x = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.u.u
    public long fx() {
        return this.jk;
    }

    public void nr(boolean z) {
        this.n = z;
    }

    public void u(boolean z) {
        this.iz = z;
    }

    public void u(com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        this.f5265a = nrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.fx.u.u
    public void u(long j) {
        this.jk = j;
    }

    public x(int i, String str, boolean z) {
        this.iz = false;
        this.t = -1;
        this.b = i;
        this.pn = str;
        this.n = z;
    }
}
