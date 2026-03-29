package com.bytedance.sdk.openadsdk.core.my;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends nr {
    private static volatile u u;

    private u() {
    }

    public static nr u() {
        if (u == null) {
            synchronized (nr.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.my.nr
    public synchronized long fx() {
        return com.bytedance.sdk.openadsdk.core.fx.pn.u().nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.my.nr
    public synchronized int nr() {
        int iFx = com.bytedance.sdk.openadsdk.core.fx.pn.u().fx();
        if (com.bytedance.sdk.openadsdk.core.fx.pn.u().b() <= 0.0f) {
            return iFx;
        }
        return (int) Math.ceil(r1 * iFx);
    }
}
