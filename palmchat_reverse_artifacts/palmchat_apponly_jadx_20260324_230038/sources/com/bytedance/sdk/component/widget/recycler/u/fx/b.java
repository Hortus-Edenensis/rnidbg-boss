package com.bytedance.sdk.component.widget.recycler.u.fx;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private boolean b;
    private final View fx;
    private ViewParent nr;
    private int[] pn;
    private ViewParent u;

    public b(View view) {
        this.fx = view;
    }

    private ViewParent b(int i) {
        if (i == 0) {
            return this.u;
        }
        if (i != 1) {
            return null;
        }
        return this.nr;
    }

    public void fx() {
        fx(0);
    }

    public boolean nr() {
        return u(0);
    }

    public void u(boolean z) {
        if (this.b) {
            x.jk(this.fx);
        }
        this.b = z;
    }

    public void fx(int i) {
        ViewParent viewParentB = b(i);
        if (viewParentB != null) {
            n.u(viewParentB, this.fx, i);
            u(i, (ViewParent) null);
        }
    }

    public boolean nr(int i) {
        return u(i, 0);
    }

    public boolean u() {
        return this.b;
    }

    public boolean u(int i) {
        return b(i) != null;
    }

    public boolean u(int i, int i2) {
        if (u(i2)) {
            return true;
        }
        if (!u()) {
            return false;
        }
        View view = this.fx;
        for (ViewParent parent = this.fx.getParent(); parent != null; parent = parent.getParent()) {
            if (n.u(parent, view, this.fx, i, i2)) {
                u(i2, parent);
                n.nr(parent, view, this.fx, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean u(int i, int i2, int i3, int i4, int[] iArr) {
        return u(i, i2, i3, i4, iArr, 0);
    }

    public boolean u(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentB;
        int i6;
        int i7;
        if (!u() || (viewParentB = b(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.fx.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        n.u(viewParentB, this.fx, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.fx.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean u(int i, int i2, int[] iArr, int[] iArr2) {
        return u(i, i2, iArr, iArr2, 0);
    }

    public boolean u(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentB;
        int i4;
        int i5;
        if (!u() || (viewParentB = b(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.fx.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.pn == null) {
                this.pn = new int[2];
            }
            iArr = this.pn;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        n.u(viewParentB, this.fx, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.fx.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean u(float f, float f2, boolean z) {
        ViewParent viewParentB;
        if (!u() || (viewParentB = b(0)) == null) {
            return false;
        }
        return n.u(viewParentB, this.fx, f, f2, z);
    }

    public boolean u(float f, float f2) {
        ViewParent viewParentB;
        if (!u() || (viewParentB = b(0)) == null) {
            return false;
        }
        return n.u(viewParentB, this.fx, f, f2);
    }

    private void u(int i, ViewParent viewParent) {
        if (i == 0) {
            this.u = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.nr = viewParent;
        }
    }
}
