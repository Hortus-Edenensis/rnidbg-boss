package com.bytedance.embedapplog;

import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class oa {
    private static final LinkedList<ju> u = new LinkedList<>();
    private static final LinkedList<ju> nr = new LinkedList<>();

    public static void u(ju juVar) {
        LinkedList<ju> linkedList = u;
        synchronized (linkedList) {
            if (linkedList.size() > 200) {
                ju juVarPoll = linkedList.poll();
                ti.nr("drop event in cache", null);
                nr.add(juVarPoll);
            }
            linkedList.add(juVar);
        }
    }

    public static void u() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<ju> linkedList3 = u;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<ju> linkedList4 = nr;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            xg.u((ju) linkedList.poll());
        }
    }
}
