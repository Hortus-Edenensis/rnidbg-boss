package com.bytedance.adsdk.nr.nr.fx.u;

import com.bytedance.adsdk.nr.nr.nr.u.my;
import java.util.Deque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class n extends iz {
    @Override // com.bytedance.adsdk.nr.nr.fx.u.iz
    public int u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque, com.bytedance.adsdk.nr.nr.fx.u uVar) {
        if (!com.bytedance.adsdk.nr.nr.pn.u.b(u(i, str))) {
            return uVar.u(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{u(i, str), u(i2, str)});
        if (com.bytedance.adsdk.nr.nr.b.fx.u(str2) != null) {
            deque.push(new my(com.bytedance.adsdk.nr.nr.b.fx.u(str2)));
            return i + 2;
        }
        String strValueOf = String.valueOf(u(i, str));
        if (com.bytedance.adsdk.nr.nr.b.fx.u(strValueOf) != null) {
            deque.push(new my(com.bytedance.adsdk.nr.nr.b.fx.u(strValueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i));
    }
}
