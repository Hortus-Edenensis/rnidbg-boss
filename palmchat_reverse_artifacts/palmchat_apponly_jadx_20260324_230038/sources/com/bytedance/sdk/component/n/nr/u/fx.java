package com.bytedance.sdk.component.n.nr.u;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements pn {
    private com.bytedance.sdk.component.n.u.pn b;
    private final Queue<String> fx;
    private final b nr;
    private com.bytedance.sdk.component.n.nr.nr.fx.nr pn;
    private final pn u;

    public fx(com.bytedance.sdk.component.n.u.pn pnVar, com.bytedance.sdk.component.n.nr.nr.fx.nr nrVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.fx = concurrentLinkedQueue;
        this.b = pnVar;
        this.pn = nrVar;
        this.u = new iz(concurrentLinkedQueue, pnVar);
        this.nr = new b(this.b);
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public List<com.bytedance.sdk.component.n.u.nr> u(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, List<String> list) {
        return null;
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public synchronized void u(com.bytedance.sdk.component.n.u.nr nrVar) {
        if (!com.bytedance.sdk.component.n.nr.fx.u.a(nrVar, this.b) || !this.pn.b()) {
            this.u.u(nrVar);
        }
        if (nrVar != null) {
            this.nr.u(nrVar);
        }
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public synchronized nr u(int i, List<com.bytedance.sdk.component.n.u.nr> list, int i2) {
        nr nrVarU;
        try {
            Iterator<com.bytedance.sdk.component.n.u.nr> it = list.iterator();
            while (it.hasNext()) {
                this.fx.remove(it.next().fx());
            }
        } catch (Throwable th) {
            nr nrVar = new nr();
            nrVar.u(false);
            nrVar.u("sending exception:" + th.getMessage());
            com.bytedance.sdk.component.n.nr.fx.fx.u(th.getMessage(), this.b);
        }
        try {
            this.u.u(i, list, i2);
        } catch (Throwable th2) {
            nr nrVar2 = new nr();
            nrVar2.u(false);
            nrVar2.u("mem exception:" + th2.getMessage());
            com.bytedance.sdk.component.n.nr.fx.fx.u(th2.getMessage(), this.b);
        }
        try {
            nrVarU = this.nr.u(i, list, i2);
        } catch (Exception e) {
            nr nrVar3 = new nr();
            nrVar3.u(false);
            nrVar3.u("db exception:" + e.getMessage());
            com.bytedance.sdk.component.n.nr.fx.fx.u(e.getMessage(), this.b);
            nrVarU = nrVar3;
        }
        return nrVarU;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public synchronized List<com.bytedance.sdk.component.n.u.nr> u(int i, com.bytedance.sdk.component.n.u.nr nrVar, boolean z, String str) {
        List list;
        boolean z2;
        List<com.bytedance.sdk.component.n.u.nr> listU = this.u.u(i, nrVar, z, (List<String>) null);
        if (listU != null && listU.size() != 0) {
            int size = listU.size();
            list = listU;
            if (com.bytedance.sdk.component.n.nr.fx.u.u(i)) {
                List<com.bytedance.sdk.component.n.u.nr> listU2 = this.nr.u((com.bytedance.sdk.component.n.u.nr) listU.get(0), size, i, z);
                list = listU;
                if (listU2 != null) {
                    list = listU;
                    if (listU2.size() != 0) {
                        listU2.size();
                        HashMap map = new HashMap();
                        for (com.bytedance.sdk.component.n.u.nr nrVar2 : listU2) {
                            map.put(nrVar2.fx(), nrVar2);
                        }
                        ArrayList arrayList = new ArrayList(this.fx);
                        arrayList.size();
                        for (com.bytedance.sdk.component.n.u.nr nrVar3 : listU2) {
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                if (TextUtils.equals(nrVar3.fx(), (String) it.next())) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (z2) {
                                map.remove(nrVar3.fx());
                            }
                        }
                        for (com.bytedance.sdk.component.n.u.nr nrVar4 : listU) {
                            map.put(nrVar4.fx(), nrVar4);
                        }
                        listU.clear();
                        Set setKeySet = map.keySet();
                        map.size();
                        Iterator it2 = setKeySet.iterator();
                        while (it2.hasNext()) {
                            listU.add(map.get((String) it2.next()));
                        }
                        listU2.clear();
                        list = listU;
                    }
                }
            }
        } else {
            ArrayList<String> arrayList2 = new ArrayList(this.fx);
            int size2 = arrayList2.size();
            List<com.bytedance.sdk.component.n.u.nr> listU3 = this.nr.u(i, nrVar, z, arrayList2);
            if (listU3 != null && listU3.size() != 0) {
                listU3.size();
                HashMap map2 = new HashMap();
                for (com.bytedance.sdk.component.n.u.nr nrVar5 : listU3) {
                    map2.put(nrVar5.fx(), nrVar5);
                }
                if (size2 != 0) {
                    for (String str2 : arrayList2) {
                        if (map2.get(str2) != null) {
                            map2.remove(str2);
                        }
                    }
                }
                listU3.clear();
                Set setKeySet2 = map2.keySet();
                map2.size();
                Iterator it3 = setKeySet2.iterator();
                while (it3.hasNext()) {
                    listU3.add(map2.get((String) it3.next()));
                }
            }
            list = listU3;
        }
        if (list != null && !list.isEmpty()) {
            list.size();
            Iterator it4 = list.iterator();
            while (it4.hasNext()) {
                this.fx.offer(((com.bytedance.sdk.component.n.u.nr) it4.next()).fx());
            }
            return list;
        }
        return new ArrayList();
    }

    @Override // com.bytedance.sdk.component.n.nr.u.pn
    public synchronized boolean u(int i, String str, com.bytedance.sdk.component.n.u.nr nrVar) {
        if (this.u.u(i, str, nrVar)) {
            return true;
        }
        if (com.bytedance.sdk.component.n.nr.fx.u.u(i)) {
            if (this.nr.u(i, str, nrVar)) {
                return true;
            }
        }
        return false;
    }
}
