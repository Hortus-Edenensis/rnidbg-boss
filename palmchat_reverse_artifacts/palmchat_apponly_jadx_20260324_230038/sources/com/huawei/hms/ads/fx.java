package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fx {
    private static final String Code = "VideoMonitor";
    private String C;
    private boolean V = false;
    private boolean I = false;
    private long Z = 0;
    private long B = 0;

    public fx(String str) {
        this.C = "VideoMonitor_" + str;
    }

    public long B() {
        return this.B;
    }

    public void Code() {
        if (fh.Code()) {
            fh.Code(this.C, "onPlayStart");
        }
        if (this.I) {
            return;
        }
        this.I = true;
        this.B = System.currentTimeMillis();
    }

    public void I() {
        if (fh.Code()) {
            fh.Code(this.C, "onVideoEnd");
        }
        this.I = false;
        this.V = false;
        this.Z = 0L;
        this.B = 0L;
    }

    public void V() {
        if (fh.Code()) {
            fh.Code(this.C, "onBufferStart");
        }
        if (this.V) {
            return;
        }
        this.V = true;
        this.Z = System.currentTimeMillis();
    }

    public long Z() {
        return this.Z;
    }
}
