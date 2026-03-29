package com.bytedance.sdk.openadsdk.core.my;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends nr {
    private static volatile pn u;

    private pn() {
    }

    public static nr u() {
        if (u == null) {
            synchronized (nr.class) {
                if (u == null) {
                    u = new pn();
                }
            }
        }
        return u;
    }

    @Override // com.bytedance.sdk.openadsdk.core.my.nr
    public long fx() {
        return com.bytedance.sdk.openadsdk.core.fx.pn.u().nr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.my.nr
    public int nr() {
        return com.bytedance.sdk.openadsdk.core.fx.pn.u().fx();
    }
}
