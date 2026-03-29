package com.bytedance.sdk.component.widget.recycler;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class mv {
    u nr = new u();
    final nr u;

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        int nr();

        int nr(View view);

        int u();

        int u(View view);

        View u(int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        int b;
        int fx;
        int nr;
        int pn;
        int u = 0;

        public boolean nr() {
            int i = this.u;
            if ((i & 7) != 0 && (i & (u(this.b, this.nr) << 0)) == 0) {
                return false;
            }
            int i2 = this.u;
            if ((i2 & 112) != 0 && (i2 & (u(this.b, this.fx) << 4)) == 0) {
                return false;
            }
            int i3 = this.u;
            if ((i3 & 1792) != 0 && (i3 & (u(this.pn, this.nr) << 8)) == 0) {
                return false;
            }
            int i4 = this.u;
            return (i4 & 28672) == 0 || (i4 & (u(this.pn, this.fx) << 12)) != 0;
        }

        public int u(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        public void u(int i, int i2, int i3, int i4) {
            this.nr = i;
            this.fx = i2;
            this.b = i3;
            this.pn = i4;
        }

        public void u(int i) {
            this.u = i | this.u;
        }

        public void u() {
            this.u = 0;
        }
    }

    public mv(nr nrVar) {
        this.u = nrVar;
    }

    public View u(int i, int i2, int i3, int i4) {
        int iU = this.u.u();
        int iNr = this.u.nr();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewU = this.u.u(i);
            this.nr.u(iU, iNr, this.u.u(viewU), this.u.nr(viewU));
            if (i3 != 0) {
                this.nr.u();
                this.nr.u(i3);
                if (this.nr.nr()) {
                    return viewU;
                }
            }
            if (i4 != 0) {
                this.nr.u();
                this.nr.u(i4);
                if (this.nr.nr()) {
                    view = viewU;
                }
            }
            i += i5;
        }
        return view;
    }
}
