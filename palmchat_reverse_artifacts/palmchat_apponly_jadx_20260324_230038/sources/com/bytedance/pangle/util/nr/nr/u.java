package com.bytedance.pangle.util.nr.nr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private List<fx> u = new ArrayList();

    public List<fx> u() {
        return this.u;
    }

    public void u(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (fx fxVar : this.u) {
            if (!set.contains(fxVar.l())) {
                arrayList.add(fxVar);
            }
        }
        this.u = arrayList;
    }

    public void u(List<fx> list) {
        this.u = list;
    }
}
