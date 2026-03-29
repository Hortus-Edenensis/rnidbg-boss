package com.bytedance.sdk.component.widget.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile u nr;
    private volatile nr u;

    private u() {
    }

    public static u u() {
        if (nr == null) {
            synchronized (u.class) {
                if (nr == null) {
                    nr = new u();
                }
            }
        }
        return nr;
    }

    public nr nr() {
        return this.u;
    }
}
