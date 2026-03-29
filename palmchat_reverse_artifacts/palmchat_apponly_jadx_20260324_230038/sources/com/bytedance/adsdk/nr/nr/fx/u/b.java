package com.bytedance.adsdk.nr.nr.fx.u;

import com.bytedance.adsdk.nr.nr.nr.u.dw;
import java.util.Deque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends iz {
    @Override // com.bytedance.adsdk.nr.nr.fx.u.iz
    public int u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque, com.bytedance.adsdk.nr.nr.fx.u uVar) {
        if ('(' != u(i, str)) {
            return uVar.u(str, i, deque);
        }
        deque.push(new dw(com.bytedance.adsdk.nr.nr.b.b.LEFT_PAREN));
        return i + 1;
    }
}
