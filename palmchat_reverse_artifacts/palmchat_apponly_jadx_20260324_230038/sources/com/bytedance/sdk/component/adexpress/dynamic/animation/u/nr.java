package com.bytedance.sdk.component.adexpress.dynamic.animation.u;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pn {
    List<b> u = new ArrayList();

    public nr(View view, List<com.bytedance.sdk.component.adexpress.dynamic.fx.u> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.fx.u> it = list.iterator();
        while (it.hasNext()) {
            b bVarU = fx.u().u(view, it.next());
            if (bVarU != null) {
                this.u.add(bVarU);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.pn
    public void nr() {
        Iterator<b> it = this.u.iterator();
        while (it.hasNext()) {
            try {
                it.next().nr();
            } catch (Exception unused) {
            }
        }
    }

    public void u() {
        Iterator<b> it = this.u.iterator();
        while (it.hasNext()) {
            try {
                it.next().fx();
            } catch (Exception unused) {
            }
        }
    }
}
