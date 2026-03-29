package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ip {
    private final String B = "min_show_time_task" + hashCode();
    private final String C = "max_show_time_task" + hashCode();
    protected eh Code;
    private mg Z;

    public ip(eh ehVar, mg mgVar) {
        this.Code = ehVar;
        this.Z = mgVar;
    }

    public void B() {
        com.huawei.openalliance.ad.utils.bj.Code(this.B);
    }

    public void Code() {
    }

    public void I() {
        mg mgVar = this.Z;
        if (mgVar != null) {
            mgVar.Code();
        }
    }

    public void V() {
    }

    public void Z() {
        mg mgVar = this.Z;
        if (mgVar != null) {
            mgVar.V();
        }
    }

    public void Code(long j) {
        fh.V(getClass().getSimpleName(), "start max show time task duration: %d", Long.valueOf(j));
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ip.1
            @Override // java.lang.Runnable
            public void run() {
                ip.this.B();
                ip.this.Z();
            }
        }, this.C, j);
    }

    public void V(long j) {
        fh.V(getClass().getSimpleName(), "start min show time task duration: %d", Long.valueOf(j));
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ip.2
            @Override // java.lang.Runnable
            public void run() {
                ip.this.I();
            }
        }, this.B, j);
    }
}
