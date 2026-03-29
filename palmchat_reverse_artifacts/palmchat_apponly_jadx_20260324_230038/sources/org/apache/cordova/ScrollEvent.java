package org.apache.cordova;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class ScrollEvent {
    public int l;
    public int nl;
    public int nt;
    public int t;
    private View targetView;

    public ScrollEvent(int i, int i2, int i3, int i4, View view) {
        this.l = i3;
        this.nl = i;
        this.nt = i2;
        this.targetView = view;
    }

    public int dl() {
        return this.nl - this.l;
    }

    public int dt() {
        return this.nt - this.t;
    }

    public View getTargetView() {
        return this.targetView;
    }
}
