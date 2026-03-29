package com.bytedance.sdk.openadsdk.core.component.nr;

import com.bytedance.sdk.openadsdk.core.component.fx.fx;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.pn.nr;
import com.bytedance.sdk.openadsdk.my.fx.nr.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends com.bytedance.sdk.openadsdk.core.pn.nr<List<a>> {
    public nr(com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar) {
        super(nrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr
    public /* bridge */ /* synthetic */ void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List list, List<a> list2) {
        u2(nrVar, (List<bc>) list, list2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.pn.nr
    public void u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, nr.u<List<a>> uVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<bc> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new fx(dw.getContext(), it.next(), 9, nrVar));
        }
        if (uVar != null) {
            uVar.u(arrayList);
        }
    }

    /* JADX INFO: renamed from: u, reason: avoid collision after fix types in other method */
    public void u2(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar, List<bc> list, List<a> list2) {
        for (int i = 0; i < list2.size(); i++) {
            bc bcVar = list.get(i);
            a aVar = list2.get(i);
            com.bytedance.sdk.openadsdk.core.pn.pn.nr nrVar2 = this.u;
            if (nrVar2 != null) {
                nrVar2.u().u(nrVar, bcVar, aVar, false);
            }
        }
    }
}
