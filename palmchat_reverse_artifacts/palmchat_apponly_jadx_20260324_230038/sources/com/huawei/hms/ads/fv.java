package com.huawei.hms.ads;

import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fv extends fy {
    private static final String Code = "NativeViewMonitor";
    private boolean B;
    private long C;
    private long I;
    private int S;
    private fu V;
    private int Z;

    public fv(View view, fu fuVar) {
        super(view);
        this.I = 500L;
        this.Z = 50;
        this.B = false;
        this.V = fuVar;
        this.C = com.huawei.openalliance.ad.utils.z.Code();
    }

    private void B() {
        if (this.B) {
            return;
        }
        fh.V(Code, "viewShowStartRecord");
        this.B = true;
        this.C = System.currentTimeMillis();
        fu fuVar = this.V;
        if (fuVar != null) {
            fuVar.a_();
        }
    }

    private void C() {
        if (this.B) {
            fh.V(Code, "viewShowEndRecord");
            this.B = false;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.C;
            if (fh.Code()) {
                fh.Code(Code, "max visible area percentage: %d duration: %d", Integer.valueOf(this.S), Long.valueOf(jCurrentTimeMillis));
            }
            fu fuVar = this.V;
            if (fuVar != null) {
                fuVar.Code(jCurrentTimeMillis, this.S);
            }
            this.S = 0;
        }
    }

    @Override // com.huawei.hms.ads.fy
    public void Code() {
        fu fuVar = this.V;
        if (fuVar != null) {
            fuVar.I();
        }
    }

    public int I() {
        return this.S;
    }

    public void V() {
        this.Z = 50;
        this.I = 500L;
    }

    public long Z() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.fy
    public void Code(int i) {
        if (i > this.S) {
            this.S = i;
        }
        if (i >= this.Z) {
            B();
        } else {
            C();
        }
    }

    public void V(long j, int i) {
        this.Z = i;
        this.I = j;
    }

    @Override // com.huawei.hms.ads.fy
    public void Code(long j, int i) {
        C();
        fu fuVar = this.V;
        if (fuVar != null) {
            fuVar.V(j, i);
        }
    }

    public boolean Code(long j) {
        return j >= this.I && this.S >= this.Z;
    }
}
