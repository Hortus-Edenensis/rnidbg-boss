package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class nr {
    final InterfaceC0232nr u;
    final u nr = new u();
    final List<View> fx = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.widget.recycler.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0232nr {
        void b(View view);

        void fx(int i);

        void fx(View view);

        View nr(int i);

        RecyclerView.q nr(View view);

        void nr();

        int u();

        int u(View view);

        void u(int i);

        void u(View view, int i);

        void u(View view, int i, ViewGroup.LayoutParams layoutParams);
    }

    public nr(InterfaceC0232nr interfaceC0232nr) {
        this.u = interfaceC0232nr;
    }

    private int iz(int i) {
        if (i < 0) {
            return -1;
        }
        int iU = this.u.u();
        int i2 = i;
        while (i2 < iU) {
            int iPn = i - (i2 - this.nr.pn(i2));
            if (iPn == 0) {
                while (this.nr.fx(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iPn;
        }
        return -1;
    }

    private boolean n(View view) {
        if (!this.fx.remove(view)) {
            return false;
        }
        this.u.b(view);
        return true;
    }

    private void x(View view) {
        this.fx.add(view);
        this.u.fx(view);
    }

    public View b(int i) {
        return this.u.nr(i);
    }

    public View fx(int i) {
        int size = this.fx.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.fx.get(i2);
            RecyclerView.q qVarNr = this.u.nr(view);
            if (qVarNr.b() == i && !qVarNr.s() && !qVarNr.o()) {
                return view;
            }
        }
        return null;
    }

    public View nr(int i) {
        return this.u.nr(iz(i));
    }

    public void pn(int i) {
        int iIz = iz(i);
        this.nr.b(iIz);
        this.u.fx(iIz);
    }

    public String toString() {
        return this.nr.toString() + ", hidden list:" + this.fx.size();
    }

    public void u(View view, boolean z) {
        u(view, -1, z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        u nr;
        long u = 0;

        private void nr() {
            if (this.nr == null) {
                this.nr = new u();
            }
        }

        public boolean b(int i) {
            if (i >= 64) {
                nr();
                return this.nr.b(i - 64);
            }
            long j = 1 << i;
            long j2 = this.u;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.u = j3;
            long j4 = j - 1;
            this.u = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            u uVar = this.nr;
            if (uVar != null) {
                if (uVar.fx(0)) {
                    u(63);
                }
                this.nr.b(0);
            }
            return z;
        }

        public boolean fx(int i) {
            if (i < 64) {
                return (this.u & (1 << i)) != 0;
            }
            nr();
            return this.nr.fx(i - 64);
        }

        public void insert(int i, boolean z) {
            if (i >= 64) {
                nr();
                this.nr.insert(i - 64, z);
                return;
            }
            long j = this.u;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.u = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                u(i);
            } else {
                nr(i);
            }
            if (z2 || this.nr != null) {
                nr();
                this.nr.insert(0, z2);
            }
        }

        public int pn(int i) {
            u uVar = this.nr;
            return uVar == null ? i >= 64 ? Long.bitCount(this.u) : Long.bitCount(this.u & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.u & ((1 << i) - 1)) : uVar.pn(i - 64) + Long.bitCount(this.u);
        }

        public String toString() {
            if (this.nr == null) {
                return Long.toBinaryString(this.u);
            }
            return this.nr.toString() + "xx" + Long.toBinaryString(this.u);
        }

        public void u(int i) {
            if (i < 64) {
                this.u |= 1 << i;
            } else {
                nr();
                this.nr.u(i - 64);
            }
        }

        public void nr(int i) {
            if (i >= 64) {
                u uVar = this.nr;
                if (uVar != null) {
                    uVar.nr(i - 64);
                    return;
                }
                return;
            }
            this.u &= ~(1 << i);
        }

        public void u() {
            this.u = 0L;
            u uVar = this.nr;
            if (uVar != null) {
                uVar.u();
            }
        }
    }

    public void b(View view) {
        int iU = this.u.u(view);
        if (iU < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        this.nr.u(iU);
        x(view);
    }

    public void u(View view, int i, boolean z) {
        int iU = i < 0 ? this.u.u() : iz(i);
        this.nr.insert(iU, z);
        if (z) {
            x(view);
        }
        this.u.u(view, iU);
    }

    public int nr() {
        return this.u.u() - this.fx.size();
    }

    public boolean iz(View view) {
        int iU = this.u.u(view);
        if (iU == -1) {
            n(view);
            return true;
        }
        if (!this.nr.fx(iU)) {
            return false;
        }
        this.nr.b(iU);
        n(view);
        this.u.u(iU);
        return true;
    }

    public int nr(View view) {
        int iU = this.u.u(view);
        if (iU == -1 || this.nr.fx(iU)) {
            return -1;
        }
        return iU - this.nr.pn(iU);
    }

    public void pn(View view) {
        int iU = this.u.u(view);
        if (iU >= 0) {
            if (this.nr.fx(iU)) {
                this.nr.nr(iU);
                n(view);
                return;
            }
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
        }
        throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
    }

    public int fx() {
        return this.u.u();
    }

    public boolean fx(View view) {
        return this.fx.contains(view);
    }

    public void u(View view) {
        int iU = this.u.u(view);
        if (iU >= 0) {
            if (this.nr.b(iU)) {
                n(view);
            }
            this.u.u(iU);
        }
    }

    public void u(int i) {
        int iIz = iz(i);
        View viewNr = this.u.nr(iIz);
        if (viewNr != null) {
            if (this.nr.b(iIz)) {
                n(viewNr);
            }
            this.u.u(iIz);
        }
    }

    public void u() {
        this.nr.u();
        for (int size = this.fx.size() - 1; size >= 0; size--) {
            this.u.b(this.fx.get(size));
            this.fx.remove(size);
        }
        this.u.nr();
    }

    public void u(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iIz;
        if (i < 0) {
            iIz = this.u.u();
        } else {
            iIz = iz(i);
        }
        this.nr.insert(iIz, z);
        if (z) {
            x(view);
        }
        this.u.u(view, iIz, layoutParams);
    }
}
