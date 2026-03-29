package com.bytedance.sdk.openadsdk.core.kj;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class gc {
    private int fx;
    private int nr;
    private int u;

    private int b() {
        return com.bytedance.sdk.openadsdk.core.y.y.b(com.bytedance.sdk.openadsdk.core.dw.getContext(), com.bytedance.sdk.openadsdk.core.y.y.pn(com.bytedance.sdk.openadsdk.core.dw.getContext()));
    }

    public int fx() {
        return this.fx;
    }

    public int nr() {
        return this.nr;
    }

    public int u() {
        return this.u;
    }

    public void fx(int i) {
        if (i > 0 && i < b()) {
            this.fx = i;
            return;
        }
        int i2 = this.u;
        if (i2 == 1) {
            this.fx = 90;
        } else if (i2 == 2) {
            this.fx = 150;
        }
    }

    public void nr(int i) {
        if (i > 0 && i < b()) {
            this.nr = i;
            return;
        }
        int i2 = this.u;
        if (i2 == 1) {
            this.nr = 90;
        } else if (i2 == 2) {
            this.nr = 150;
        }
    }

    public void u(int i) {
        if (i != 1 && i != 2) {
            i = 0;
        }
        this.u = i;
    }
}
