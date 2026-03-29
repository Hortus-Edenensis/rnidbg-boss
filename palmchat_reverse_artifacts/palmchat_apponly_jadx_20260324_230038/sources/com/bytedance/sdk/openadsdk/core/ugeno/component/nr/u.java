package com.bytedance.sdk.openadsdk.core.ugeno.component.nr;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.ugeno.component.nr.pn;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static int nr = 1;
    public static int u;
    private pn.u fx;
    private int b = 60;
    private int pn = nr;

    private int nr(View view) {
        int iU = (int) (((double) n.u(view.getContext())) / 2.3d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs((iArr[1] + (view.getHeight() / 2)) - iU);
    }

    public int u(RecyclerView recyclerView) {
        pn.u uVar;
        View viewFx;
        pn.u uVar2 = null;
        com.bytedance.sdk.component.widget.recycler.pn pnVar = recyclerView.getLayoutManager() instanceof com.bytedance.sdk.component.widget.recycler.pn ? (com.bytedance.sdk.component.widget.recycler.pn) recyclerView.getLayoutManager() : null;
        if (pnVar != null) {
            int iT = pnVar.t();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int iJk = pnVar.jk(); iJk <= iT; iJk++) {
                Object objFx = recyclerView.fx(iJk);
                if ((objFx instanceof pn.u) && (viewFx = (uVar = (pn.u) objFx).fx()) != null && u(viewFx, this.b)) {
                    if (this.pn == u) {
                        uVar.M_();
                        this.fx = uVar;
                        return iJk;
                    }
                    linkedHashMap.put(Integer.valueOf(iJk), uVar);
                }
            }
            int i = Integer.MAX_VALUE;
            int iIntValue = -1;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iNr = nr(((pn.u) entry.getValue()).fx());
                if (iNr < i) {
                    pn.u uVar3 = (pn.u) entry.getValue();
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    uVar2 = uVar3;
                    i = iNr;
                }
            }
            pn.u uVar4 = this.fx;
            if (uVar4 != uVar2) {
                if (uVar4 != null) {
                    uVar4.L_();
                }
                this.fx = uVar2;
            }
            pn.u uVar5 = this.fx;
            if (uVar5 != null) {
                uVar5.M_();
                return iIntValue;
            }
        }
        return -1;
    }

    public void u() {
        pn.u uVar = this.fx;
        if (uVar == null || uVar.fx() == null || u(this.fx.fx(), this.b)) {
            return;
        }
        this.fx.L_();
    }

    private int u(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean u(View view, int i) {
        return view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && u(view) >= i;
    }
}
