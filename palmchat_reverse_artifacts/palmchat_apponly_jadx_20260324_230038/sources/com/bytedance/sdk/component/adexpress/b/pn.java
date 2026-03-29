package com.bytedance.sdk.component.adexpress.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    public static void nr(com.bytedance.sdk.component.jk.a aVar, int i) {
        if (aVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.u.u.fx fxVarFx = com.bytedance.sdk.component.adexpress.u.u.u.u().fx();
        ExecutorService executorServiceMv = fxVarFx != null ? fxVarFx.mv() : null;
        if (executorServiceMv == null) {
            com.bytedance.sdk.component.jk.x.u(aVar);
        } else {
            aVar.setPriority(i);
            executorServiceMv.execute(aVar);
        }
    }

    public static void u(com.bytedance.sdk.component.jk.a aVar, int i) {
        if (aVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.u.u.fx fxVarFx = com.bytedance.sdk.component.adexpress.u.u.u.u().fx();
        ExecutorService executorServiceS = fxVarFx != null ? fxVarFx.s() : null;
        if (executorServiceS == null) {
            com.bytedance.sdk.component.jk.x.u(aVar, i);
        } else {
            aVar.setPriority(i);
            executorServiceS.execute(aVar);
        }
    }

    public static ScheduledFuture u(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.jk.x.b().schedule(runnable, j, timeUnit);
    }
}
