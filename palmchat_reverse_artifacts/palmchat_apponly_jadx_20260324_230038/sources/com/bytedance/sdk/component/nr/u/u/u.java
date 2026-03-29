package com.bytedance.sdk.component.nr.u.u;

import com.bytedance.sdk.component.nr.u.l;
import com.bytedance.sdk.component.nr.u.u.nr.fx;
import com.bytedance.sdk.component.nr.u.u.u.iz;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static AtomicBoolean nr = new AtomicBoolean(true);
    private static volatile u u;

    private u() {
    }

    public static u u() {
        if (u == null) {
            synchronized (u.class) {
                if (u == null) {
                    u = new u();
                }
            }
        }
        return u;
    }

    public boolean nr() {
        AtomicBoolean atomicBoolean = nr;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public static l nr(l.u uVar) {
        return new iz(uVar);
    }

    public void u(boolean z) {
        nr.set(z);
    }

    public static l u(l.u uVar) {
        return new fx(uVar);
    }
}
