package com.bytedance.adsdk.lottie.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x {
    private int nr;
    private float u;

    public void u(float f) {
        float f2 = this.u + f;
        this.u = f2;
        int i = this.nr + 1;
        this.nr = i;
        if (i == Integer.MAX_VALUE) {
            this.u = f2 / 2.0f;
            this.nr = i / 2;
        }
    }
}
