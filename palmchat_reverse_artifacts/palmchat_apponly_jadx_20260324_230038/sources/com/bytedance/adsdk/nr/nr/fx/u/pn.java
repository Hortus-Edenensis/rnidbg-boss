package com.bytedance.adsdk.nr.nr.fx.u;

import java.util.Deque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn extends iz {
    @Override // com.bytedance.adsdk.nr.nr.fx.u.iz
    public int u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque, com.bytedance.adsdk.nr.nr.fx.u uVar) {
        char cU;
        int i2 = i;
        while (true) {
            cU = u(i2, str);
            if (!com.bytedance.adsdk.nr.nr.pn.u.nr(cU) && !com.bytedance.adsdk.nr.nr.pn.u.fx(cU)) {
                break;
            }
            i2++;
        }
        if (cU != '(') {
            return uVar.u(str, i, deque);
        }
        deque.push(new com.bytedance.adsdk.nr.nr.nr.u.jk(str.substring(i, i2)));
        return i2 + 1;
    }
}
