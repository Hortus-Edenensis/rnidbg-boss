package com.bytedance.adsdk.lottie.model.nr;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {
    private final int[] nr;
    private final float[] u;

    public b(float[] fArr, int[] iArr) {
        this.u = fArr;
        this.nr = iArr;
    }

    public int fx() {
        return this.nr.length;
    }

    public int[] nr() {
        return this.nr;
    }

    public float[] u() {
        return this.u;
    }

    public void u(b bVar, b bVar2, float f) {
        if (bVar.nr.length == bVar2.nr.length) {
            for (int i = 0; i < bVar.nr.length; i++) {
                this.u[i] = com.bytedance.adsdk.lottie.pn.n.u(bVar.u[i], bVar2.u[i], f);
                this.nr[i] = com.bytedance.adsdk.lottie.pn.fx.u(f, bVar.nr[i], bVar2.nr[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + bVar.nr.length + " vs " + bVar2.nr.length + ")");
    }

    public b u(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = u(fArr[i]);
        }
        return new b(fArr, iArr);
    }

    private int u(float f) {
        int iBinarySearch = Arrays.binarySearch(this.u, f);
        if (iBinarySearch >= 0) {
            return this.nr[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.nr[0];
        }
        int[] iArr = this.nr;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.u;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.lottie.pn.fx.u((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}
