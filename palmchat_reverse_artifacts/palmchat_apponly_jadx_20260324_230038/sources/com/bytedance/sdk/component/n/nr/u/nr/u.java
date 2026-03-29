package com.bytedance.sdk.component.n.nr.u.nr;

import com.bytedance.sdk.component.n.u.nr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class u<T extends com.bytedance.sdk.component.n.u.nr> extends com.bytedance.sdk.component.n.nr.u.u {
    private Queue<T> b = new ConcurrentLinkedQueue();
    public com.bytedance.sdk.component.n.u.pn fx;
    public String nr;
    private Queue<String> pn;
    public com.bytedance.sdk.component.n.nr.b.nr.u u;

    public u(com.bytedance.sdk.component.n.nr.b.nr.u uVar, Queue<String> queue, String str, com.bytedance.sdk.component.n.u.pn pnVar) {
        this.u = uVar;
        this.pn = queue;
        this.fx = pnVar;
        this.nr = str;
    }

    public void nr(T t) {
        if (this.b == null || t == null || !u(t)) {
            return;
        }
        this.b.offer(t);
    }

    public com.bytedance.sdk.component.n.nr.u.nr u(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.n.nr.u.nr nrVar = new com.bytedance.sdk.component.n.nr.u.nr();
        if (list == null || list.size() == 0 || list.get(0) == null || !u(list.get(0))) {
            nrVar.u(false);
            return nrVar;
        }
        nr(i, list, i2);
        nrVar.u(true);
        return nrVar;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u
    public List<com.bytedance.sdk.component.n.u.nr> nr(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        this.b.size();
        do {
            T tPoll = this.b.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.u.nr());
        return arrayList;
    }

    private void nr(int i, List<T> list, int i2) {
        com.bytedance.sdk.component.n.u.nr nrVar;
        int size = this.b.size();
        if ((i == -1 || i == 200 || i == 509 || i == -3) && list != null && list.size() != 0 && size != 0) {
            HashMap map = new HashMap();
            for (T t : this.b) {
                if (t != null) {
                    map.put(t.fx(), t);
                }
            }
            for (T t2 : list) {
                if (t2 != null && (nrVar = (com.bytedance.sdk.component.n.u.nr) map.get(t2.fx())) != null) {
                    this.b.remove(nrVar);
                }
            }
        }
        this.b.size();
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u
    public boolean u(String str) {
        return this.b.size() > 0;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.u
    public boolean nr(int i, String str, com.bytedance.sdk.component.n.u.nr nrVar) {
        int size = this.b.size();
        int iU = this.u.u();
        com.bytedance.sdk.component.n.nr.fx.u.nr(i);
        return size >= iU;
    }
}
