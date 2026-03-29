package com.bytedance.sdk.component.n.nr.fx;

import com.bytedance.sdk.component.n.u.b;
import com.bytedance.sdk.component.n.u.pn;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static void u(AtomicLong atomicLong, int i, pn pnVar) {
        b bVarB = pnVar.b();
        if (bVarB == null || !bVarB.a() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i);
    }
}
