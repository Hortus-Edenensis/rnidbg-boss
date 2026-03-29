package com.bytedance.adsdk.nr.nr.fx.u;

import java.util.Deque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class iz {
    public int getIdentifier(int i, String str) {
        int i2 = 0;
        while (true) {
            int i3 = i2 + i;
            char cU = u(i3, str);
            if (!com.bytedance.adsdk.nr.nr.pn.u.nr(cU) && !com.bytedance.adsdk.nr.nr.pn.u.fx(cU)) {
                return i3;
            }
            i2++;
        }
    }

    public int nr(int i, String str) {
        while (com.bytedance.adsdk.nr.nr.pn.u.u(u(i, str))) {
            i++;
        }
        return i;
    }

    public char u(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    public abstract int u(String str, int i, Deque<com.bytedance.adsdk.nr.nr.nr.u> deque, com.bytedance.adsdk.nr.nr.fx.u uVar);
}
