package com.bytedance.sdk.component.fx.nr.u.pn;

import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    private final int[] nr = new int[10];
    private int u;

    public int b(int i) {
        return (this.u & 32) != 0 ? this.nr[5] : i;
    }

    public int fx() {
        if ((this.u & 2) != 0) {
            return this.nr[1];
        }
        return -1;
    }

    public int nr(int i) {
        return this.nr[i];
    }

    public void u() {
        this.u = 0;
        Arrays.fill(this.nr, 0);
    }

    public int b() {
        if ((this.u & 128) != 0) {
            return this.nr[7];
        }
        return 65535;
    }

    public int fx(int i) {
        return (this.u & 16) != 0 ? this.nr[4] : i;
    }

    public int nr() {
        return Integer.bitCount(this.u);
    }

    public s u(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.nr;
            if (i < iArr.length) {
                this.u = (1 << i) | this.u;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public boolean u(int i) {
        return ((1 << i) & this.u) != 0;
    }

    public void u(s sVar) {
        for (int i = 0; i < 10; i++) {
            if (sVar.u(i)) {
                u(i, sVar.nr(i));
            }
        }
    }
}
