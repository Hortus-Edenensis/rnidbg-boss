package com.github.mikephil.charting.components;

import defpackage.jn;
import defpackage.s86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class XAxis extends jn {
    public int J = 1;
    public int K = 1;
    public int L = 1;
    public int M = 1;
    public float N = 0.0f;
    public boolean O = false;
    public XAxisPosition P = XAxisPosition.TOP;

    /* JADX INFO: compiled from: SearchBox */
    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.c = s86.e(4.0f);
    }

    public float H() {
        return this.N;
    }

    public XAxisPosition I() {
        return this.P;
    }

    public boolean J() {
        return this.O;
    }
}
