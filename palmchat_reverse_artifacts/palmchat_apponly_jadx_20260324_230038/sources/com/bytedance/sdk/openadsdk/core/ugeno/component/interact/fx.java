package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.z;
import com.bytedance.sdk.openadsdk.core.y.jp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    pn fx;
    b nr;
    bc u;

    public fx(bc bcVar, boolean z, u uVar) {
        this.u = bcVar;
        this.nr = new b(bcVar, z, uVar);
        this.fx = new pn(this.u, z, uVar);
    }

    private void nr(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ("easy_pfwv".equals(childAt.getTag())) {
                    viewGroup.removeView(childAt);
                    this.nr.b();
                    this.fx.b();
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                View childAt2 = viewGroup2.getChildAt(i2);
                if ("easy_pfwv".equals(childAt2.getTag())) {
                    viewGroup2.removeView(childAt2);
                    this.nr.b();
                    this.fx.b();
                }
            }
        }
    }

    private boolean u(boolean z) {
        int iJk = jp.jk(this.u);
        if (iJk == 5 || iJk == 9) {
            return true;
        }
        return (iJk == 3 || iJk == 4) ? z : iJk == 7 || iJk == 8;
    }

    public void u(ViewGroup viewGroup, View view) {
        nr(viewGroup, view);
        if (this.nr.fx()) {
            a.u(this.u, 1);
            if (!u(viewGroup)) {
                a.u(this.u, false, 1, 1);
                return;
            }
            int iFx = z.iz(this.u).fx();
            boolean z = iFx == 0 || iFx == 2;
            if (!u(true)) {
                a.u(this.u, false, 1, 2);
                return;
            }
            b bVar = this.nr;
            if (z) {
                view = viewGroup;
            }
            bVar.u(viewGroup, view, true);
            return;
        }
        if (this.fx.fx()) {
            a.u(this.u, 2);
            if (!u(viewGroup)) {
                a.u(this.u, false, 2, 1);
                return;
            }
            int iNr = z.pn(this.u).nr();
            boolean z2 = iNr == 0 || iNr == 2;
            if (!u(false)) {
                a.u(this.u, false, 2, 2);
                return;
            }
            pn pnVar = this.fx;
            if (z2) {
                view = viewGroup;
            }
            pnVar.u(viewGroup, view, iNr != 2);
        }
    }

    public void nr() {
        this.nr.b();
        this.fx.b();
    }

    private boolean u(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        return (viewGroup instanceof FrameLayout) || (viewGroup instanceof RelativeLayout);
    }

    public iz u() {
        if (this.nr.fx()) {
            return this.nr.nr();
        }
        if (this.fx.fx()) {
            return this.fx.nr();
        }
        return new iz() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.fx.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void u() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void u(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void fx() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void nr() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.interact.iz
            public void pn() {
            }
        };
    }

    public void u(com.bytedance.sdk.openadsdk.qq.u.nr.u.nr nrVar) {
        pn pnVar = this.fx;
        if (pnVar != null) {
            pnVar.u(nrVar);
        }
        b bVar = this.nr;
        if (bVar != null) {
            bVar.u(nrVar);
        }
    }
}
