package com.bytedance.adsdk.nr.nr.fx.u;

import com.bytedance.adsdk.nr.nr.nr.u.c;
import java.util.Deque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx extends iz {
    @Override // com.bytedance.adsdk.nr.nr.fx.u.iz
    public int u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque, com.bytedance.adsdk.nr.nr.fx.u uVar) {
        char cU = u(i, str);
        return (com.bytedance.adsdk.nr.nr.pn.u.nr(cU) || cU == '$') ? u(str, i, deque) : uVar.u(str, i, deque);
    }

    private int u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char cU = u(i2, str);
            if (!com.bytedance.adsdk.nr.nr.pn.u.nr(cU) && !com.bytedance.adsdk.nr.nr.pn.u.fx(cU) && '.' != cU && '[' != cU && ']' != cU && '_' != cU && '$' != cU) {
                break;
            }
            i3++;
        }
        String strSubstring = str.substring(i, i2);
        if (com.bytedance.adsdk.nr.nr.b.u.u(strSubstring) != null) {
            deque.push(new com.bytedance.adsdk.nr.nr.nr.u.x(strSubstring));
        } else {
            deque.push(new c(strSubstring));
        }
        return i2;
    }
}
