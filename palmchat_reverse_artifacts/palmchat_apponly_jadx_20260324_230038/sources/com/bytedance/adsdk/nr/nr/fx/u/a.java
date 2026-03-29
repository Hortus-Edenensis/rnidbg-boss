package com.bytedance.adsdk.nr.nr.fx.u;

import java.util.Deque;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a extends iz {
    @Override // com.bytedance.adsdk.nr.nr.fx.u.iz
    public int u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque, com.bytedance.adsdk.nr.nr.fx.u uVar) {
        com.bytedance.adsdk.nr.nr.nr.u uVarPollFirst;
        if (')' != u(i, str)) {
            return uVar.u(str, i, deque);
        }
        LinkedList<com.bytedance.adsdk.nr.nr.nr.u> linkedList = new LinkedList();
        while (true) {
            uVarPollFirst = deque.pollFirst();
            if (uVarPollFirst == null || uVarPollFirst.u() == com.bytedance.adsdk.nr.nr.b.nr.METHOD || uVarPollFirst.u() == com.bytedance.adsdk.nr.nr.b.b.LEFT_PAREN) {
                break;
            }
            linkedList.addFirst(uVarPollFirst);
        }
        if (uVarPollFirst == null) {
            throw new IllegalArgumentException(str.substring(0, i));
        }
        if (uVarPollFirst.u() != com.bytedance.adsdk.nr.nr.b.nr.METHOD) {
            deque.push(com.bytedance.adsdk.nr.nr.pn.nr.u(linkedList, str, i));
            return i + 1;
        }
        com.bytedance.adsdk.nr.nr.nr.u.jk jkVar = (com.bytedance.adsdk.nr.nr.nr.u.jk) uVarPollFirst;
        LinkedList linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (com.bytedance.adsdk.nr.nr.nr.u uVar2 : linkedList) {
            if (uVar2.u() == com.bytedance.adsdk.nr.nr.b.b.COMMA) {
                linkedList2.add(com.bytedance.adsdk.nr.nr.pn.nr.u(linkedList3, str, i));
                linkedList3.clear();
            } else {
                linkedList3.addLast(uVar2);
            }
        }
        if (!linkedList3.isEmpty()) {
            linkedList2.add(com.bytedance.adsdk.nr.nr.pn.nr.u(linkedList3, str, i));
        }
        jkVar.u((com.bytedance.adsdk.nr.nr.nr.u[]) linkedList2.toArray(new com.bytedance.adsdk.nr.nr.nr.u[linkedList2.size()]));
        int i2 = i + 1;
        deque.push(jkVar);
        return i2;
    }
}
