package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class jk {
    public static int nr(RecyclerView.bq bqVar, n nVar, View view, View view2, RecyclerView.a aVar, boolean z) {
        if (aVar.bg() == 0 || bqVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return bqVar.b();
        }
        return (int) (((nVar.nr(view2) - nVar.u(view)) / (Math.abs(aVar.b(view) - aVar.b(view2)) + 1)) * bqVar.b());
    }

    public static int u(RecyclerView.bq bqVar, n nVar, View view, View view2, RecyclerView.a aVar, boolean z, boolean z2) {
        if (aVar.bg() == 0 || bqVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (bqVar.b() - Math.max(aVar.b(view), aVar.b(view2))) - 1) : Math.max(0, Math.min(aVar.b(view), aVar.b(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(nVar.nr(view2) - nVar.u(view)) / (Math.abs(aVar.b(view) - aVar.b(view2)) + 1))) + (nVar.fx() - nVar.u(view)));
        }
        return iMax;
    }

    public static int u(RecyclerView.bq bqVar, n nVar, View view, View view2, RecyclerView.a aVar, boolean z) {
        if (aVar.bg() == 0 || bqVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(aVar.b(view) - aVar.b(view2)) + 1;
        }
        return Math.min(nVar.iz(), nVar.nr(view2) - nVar.u(view));
    }
}
