package com.bytedance.sdk.openadsdk.core.kj;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class kw {
    private int fx;
    private int nr;
    private int u;
    private int b = 1;
    private int pn = 0;

    private int iz() {
        return com.bytedance.sdk.openadsdk.core.y.y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), com.bytedance.sdk.openadsdk.core.y.y.pn(com.bytedance.sdk.openadsdk.core.dw.getContext()));
    }

    private int x() {
        return com.bytedance.sdk.openadsdk.core.y.y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), com.bytedance.sdk.openadsdk.core.y.y.b(com.bytedance.sdk.openadsdk.core.dw.getContext()));
    }

    public int b() {
        return this.b == 2 ? 2 : 1;
    }

    public int fx() {
        return this.fx;
    }

    public int nr() {
        return this.nr;
    }

    public int pn() {
        return this.pn;
    }

    public int u() {
        return this.u;
    }

    public void b(int i) {
        this.b = i;
    }

    public void fx(int i) {
        if (i > 0 && i < iz()) {
            this.fx = i;
            return;
        }
        int i2 = this.u;
        if (i2 == 3 || i2 == 4) {
            this.fx = 30;
        } else {
            this.fx = 16;
        }
    }

    public void nr(int i) {
        if (i <= 0 || i >= x()) {
            this.nr = 16;
        } else {
            this.nr = i;
        }
    }

    public void pn(int i) {
        this.pn = i;
    }

    public void u(int i) {
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            this.u = i;
        } else {
            this.u = 2;
        }
    }

    public static boolean u(bc bcVar) {
        return (bcVar == null || bcVar.kp() == null || bcVar.kp().pn() != 1) ? false : true;
    }
}
