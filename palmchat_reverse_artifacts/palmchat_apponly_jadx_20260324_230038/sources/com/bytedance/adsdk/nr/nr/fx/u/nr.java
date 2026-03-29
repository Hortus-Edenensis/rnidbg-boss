package com.bytedance.adsdk.nr.nr.fx.u;

import com.bytedance.adsdk.nr.nr.nr.u.bq;
import java.util.Deque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr extends iz {
    @Override // com.bytedance.adsdk.nr.nr.fx.u.iz
    public int u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque, com.bytedance.adsdk.nr.nr.fx.u uVar) {
        if ('\'' != u(i, str)) {
            return uVar.u(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && u(i3, str) != '\'') {
            i3++;
        }
        if (u(i3, str) != '\'') {
            throw new com.bytedance.adsdk.nr.u.u("String expression not surrounded by '", str.substring(i2 - 1));
        }
        deque.push(new bq(str.substring(i2, i3)));
        return i3 + 1;
    }
}
