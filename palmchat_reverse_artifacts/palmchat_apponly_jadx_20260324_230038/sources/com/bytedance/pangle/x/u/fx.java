package com.bytedance.pangle.x.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class fx {
    private int fx;
    private int nr;
    private int[] u = new int[32];

    private void x() {
        int[] iArr = this.u;
        int length = iArr.length;
        int i = this.nr;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.u = iArr2;
        }
    }

    public final int b() {
        return this.fx;
    }

    public final void fx() {
        int i;
        int[] iArr;
        int i2;
        int i3 = this.nr;
        if (i3 == 0 || (i2 = (iArr = this.u)[i3 - 1]) == 0) {
            return;
        }
        int i4 = i2 - 1;
        int i5 = i - 2;
        iArr[i5] = i4;
        iArr[i5 - ((i4 * 2) + 1)] = i4;
        this.nr = i3 - 2;
    }

    public final void iz() {
        int i = this.nr;
        if (i != 0) {
            int i2 = i - 1;
            int i3 = this.u[i2] * 2;
            if ((i2 - 1) - i3 != 0) {
                this.nr = i - (i3 + 2);
                this.fx--;
            }
        }
    }

    public final int nr() {
        int i = this.nr;
        if (i == 0) {
            return 0;
        }
        return this.u[i - 1];
    }

    public final void pn() {
        x();
        int i = this.nr;
        int[] iArr = this.u;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.nr = i + 2;
        this.fx++;
    }

    public final void u() {
        this.nr = 0;
        this.fx = 0;
    }

    public final void u(int i, int i2) {
        if (this.fx == 0) {
            pn();
        }
        x();
        int i3 = this.nr;
        int i4 = i3 - 1;
        int[] iArr = this.u;
        int i5 = iArr[i4];
        int i6 = (i4 - 1) - (i5 * 2);
        int i7 = i5 + 1;
        iArr[i6] = i7;
        iArr[i4] = i;
        iArr[i4 + 1] = i2;
        iArr[i4 + 2] = i7;
        this.nr = i3 + 2;
    }
}
