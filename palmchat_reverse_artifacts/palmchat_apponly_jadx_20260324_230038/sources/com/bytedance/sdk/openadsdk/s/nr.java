package com.bytedance.sdk.openadsdk.s;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private int b;
    private n nr;
    private ScheduledExecutorService u = null;
    private long fx = 0;

    public nr(n nVar, int i) {
        this.nr = nVar;
        this.b = i;
    }

    public boolean nr() {
        ScheduledExecutorService scheduledExecutorService = this.u;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }

    public void u(long j) {
        this.fx = j;
    }

    public void u(int i) {
        ScheduledExecutorService scheduledExecutorServiceU = com.bytedance.sdk.component.jk.fx.u(1, new com.bytedance.sdk.component.jk.jk("/CrashMonitor"));
        this.u = scheduledExecutorServiceU;
        scheduledExecutorServiceU.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.s.nr.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (System.currentTimeMillis() - nr.this.fx > nr.this.b) {
                    nr.this.u.shutdown();
                    if (nr.this.nr != null) {
                        nr.this.nr.nr(0, "自动检测卡死");
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void u() {
        ScheduledExecutorService scheduledExecutorService = this.u;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
