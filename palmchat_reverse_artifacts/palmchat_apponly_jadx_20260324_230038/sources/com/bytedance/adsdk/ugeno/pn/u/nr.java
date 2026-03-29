package com.bytedance.adsdk.ugeno.pn.u;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr implements fx {
    private List<b> u = new CopyOnWriteArrayList();

    @Override // com.bytedance.adsdk.ugeno.pn.u.fx
    public void u(b bVar) {
        this.u.add(bVar);
    }

    @Override // com.bytedance.adsdk.ugeno.pn.u.fx
    public void u(String str) {
        if (this.u.isEmpty()) {
            return;
        }
        Iterator<b> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().u(str);
        }
    }
}
