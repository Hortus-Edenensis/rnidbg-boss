package com.bytedance.sdk.component.n.nr.u;

import com.bytedance.sdk.component.n.nr.u.nr.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements pn {
    private List<com.bytedance.sdk.component.n.nr.u.nr.u> u = new ArrayList();

    public iz(Queue<String> queue, com.bytedance.sdk.component.n.u.pn pnVar) {
        if (com.bytedance.sdk.component.n.nr.nr.u.u(pnVar)) {
            this.u.add(new com.bytedance.sdk.component.n.nr.u.nr.fx(pnVar.x(), queue, pnVar));
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.pn(pnVar)) {
            this.u.add(new com.bytedance.sdk.component.n.nr.u.nr.b(pnVar.u() != null ? pnVar.u() : pnVar.n(), queue, pnVar));
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.nr(pnVar)) {
            this.u.add(new com.bytedance.sdk.component.n.nr.u.nr.pn(pnVar.n(), queue, pnVar));
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.fx(pnVar)) {
            this.u.add(new com.bytedance.sdk.component.n.nr.u.nr.iz(pnVar.n(), queue, pnVar));
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.b(pnVar)) {
            this.u.add(new com.bytedance.sdk.component.n.nr.u.nr.nr(pnVar.a(), queue, pnVar));
        }
        if (com.bytedance.sdk.component.n.nr.nr.u.iz(pnVar)) {
            this.u.add(new x(pnVar.iz(), queue, pnVar));
        }
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public List<com.bytedance.sdk.component.n.u.nr> u(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, String str) {
        return null;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public void u(com.bytedance.sdk.component.n.u.nr nrVar) {
        Iterator<com.bytedance.sdk.component.n.nr.u.nr.u> it = this.u.iterator();
        while (it.hasNext()) {
            it.next().nr(nrVar);
        }
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public nr u(int i, List<com.bytedance.sdk.component.n.u.nr> list, int i2) {
        Iterator<com.bytedance.sdk.component.n.nr.u.nr.u> it = this.u.iterator();
        nr nrVarU = null;
        while (it.hasNext()) {
            nrVarU = it.next().u(i, list, i2);
            if (nrVarU.u()) {
                break;
            }
        }
        return nrVarU;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public List<com.bytedance.sdk.component.n.u.nr> u(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, List<String> list) {
        Iterator<com.bytedance.sdk.component.n.nr.u.nr.u> it = this.u.iterator();
        while (it.hasNext()) {
            List<com.bytedance.sdk.component.n.u.nr> listU = it.next().u(i, nrVar, z, list, "get");
            if (listU != null && listU.size() != 0) {
                return listU;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public boolean u(int i, String str, com.bytedance.sdk.component.n.u.nr nrVar) {
        Iterator<com.bytedance.sdk.component.n.nr.u.nr.u> it = this.u.iterator();
        while (it.hasNext()) {
            if (it.next().u(i, str, nrVar)) {
                return true;
            }
        }
        return false;
    }
}
