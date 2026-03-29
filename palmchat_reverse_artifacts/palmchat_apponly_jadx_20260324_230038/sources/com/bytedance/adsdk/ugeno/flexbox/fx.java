package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5026a;
    int iz;
    float jk;
    int k;
    int l;
    int mv;
    int my;
    int n;
    boolean o;
    int pn;
    boolean sx;
    float t;
    int x;
    int u = Integer.MAX_VALUE;
    int nr = Integer.MAX_VALUE;
    int fx = Integer.MIN_VALUE;
    int b = Integer.MIN_VALUE;
    List<Integer> s = new ArrayList();

    public int nr() {
        return this.n - this.f5026a;
    }

    public int u() {
        return this.x;
    }

    public void u(View view, int i, int i2, int i3, int i4) {
        nr nrVar = (nr) view.getLayoutParams();
        this.u = Math.min(this.u, (view.getLeft() - nrVar.mv()) - i);
        this.nr = Math.min(this.nr, (view.getTop() - nrVar.s()) - i2);
        this.fx = Math.max(this.fx, view.getRight() + nrVar.k() + i3);
        this.b = Math.max(this.b, view.getBottom() + nrVar.my() + i4);
    }
}
