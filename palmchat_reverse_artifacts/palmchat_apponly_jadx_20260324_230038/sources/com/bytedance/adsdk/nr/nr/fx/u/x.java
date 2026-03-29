package com.bytedance.adsdk.nr.nr.fx.u;

import com.bytedance.adsdk.nr.nr.nr.u.k;
import java.util.Deque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class x extends iz {
    private boolean u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque) {
        if ('-' != u(i, str)) {
            return com.bytedance.adsdk.nr.nr.pn.u.fx(u(i, str));
        }
        if (deque.peek() != null && !com.bytedance.adsdk.nr.nr.b.fx.u(deque.peek().u())) {
            return false;
        }
        if (com.bytedance.adsdk.nr.nr.pn.u.fx(u(i + 1, str))) {
            return true;
        }
        throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
    }

    @Override // com.bytedance.adsdk.nr.nr.fx.u.iz
    public int u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque, com.bytedance.adsdk.nr.nr.fx.u uVar) {
        char cU;
        if (!u(str, i, deque)) {
            return uVar.u(str, i, deque);
        }
        int i2 = u(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            cU = u(i2, str);
            if (!com.bytedance.adsdk.nr.nr.pn.u.fx(cU) && (z || cU != '.')) {
                break;
            }
            i2++;
            if (cU == '.') {
                z = true;
            }
        }
        if (cU != '.') {
            deque.push(new k(str.substring(i, i2)));
            return i2;
        }
        throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
    }
}
