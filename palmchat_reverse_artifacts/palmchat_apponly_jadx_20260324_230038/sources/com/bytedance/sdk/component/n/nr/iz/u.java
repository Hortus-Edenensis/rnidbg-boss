package com.bytedance.sdk.component.n.nr.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile nr u;

    public static nr u(com.bytedance.sdk.component.n.u.pn pnVar) {
        if (u == null) {
            synchronized (nr.class) {
                if (u == null) {
                    u = new fx(new iz(pnVar), pnVar);
                }
            }
        }
        return u;
    }
}
