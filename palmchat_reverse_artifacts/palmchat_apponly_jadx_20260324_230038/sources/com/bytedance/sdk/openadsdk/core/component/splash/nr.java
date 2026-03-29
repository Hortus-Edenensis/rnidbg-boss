package com.bytedance.sdk.openadsdk.core.component.splash;

import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.n;
import com.bytedance.sdk.openadsdk.core.pn.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public int b;
    public n.fx iz;
    public iz.u pn;
    public int u = 0;
    public long nr = 0;
    public int fx = -1;

    public boolean nr() {
        n.fx fxVar;
        if (this.nr <= 0 || this.u != 3) {
            return false;
        }
        iz.u uVar = this.pn;
        nr((uVar == null || (fxVar = this.iz) == null) ? -1 : uVar.u(fxVar.pn(), this.iz));
        this.fx = 2;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ae, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int u(int i) {
        double d;
        this.b = i;
        int iN = dw.nr().n(i);
        if (iN > 0 && iN <= 3) {
            n.nr nrVarU = com.bytedance.sdk.openadsdk.core.kj.n.u();
            boolean z = false;
            int iA = nrVarU == null ? 0 : nrVarU.a();
            n.fx fxVarT = nrVarU == null ? null : nrVarU.t();
            this.iz = fxVarT;
            if (fxVarT != null && iA == 5) {
                if (fxVarT.nr() > 0) {
                    try {
                        d = Double.parseDouble(com.bytedance.sdk.openadsdk.core.rh.u.u().u("DeviceRate", "bytebench_value"));
                    } catch (Exception unused) {
                        d = 0.0d;
                    }
                    if (d > 0.0d && d < this.iz.nr()) {
                        this.u = 1;
                        return 1;
                    }
                }
                if (this.iz.fx() > 0) {
                    if ((r0 = o.fx(dw.getContext())) != 2) {
                        if (z) {
                            this.u = 2;
                            return 1;
                        }
                    } else if (z) {
                    }
                }
                this.pn = com.bytedance.sdk.openadsdk.core.pn.iz.u(String.valueOf(i), this.iz);
                if (this.iz.b() > 0) {
                    this.u = 3;
                    int iU = this.pn.u(this.iz.b(), this.iz);
                    if (iU > 0) {
                        this.nr = System.currentTimeMillis() - ((((long) iU) * 60) * 1000);
                        return 1;
                    }
                    if (iU == 0) {
                        return 1;
                    }
                }
                this.u = 4;
                nr(this.pn.u(this.iz.pn(), this.iz));
                return 2;
            }
        }
        return iN;
    }

    private void nr(int i) {
        if (i > 0) {
            this.nr = System.currentTimeMillis() - ((((long) i) * 60) * 1000);
        } else if (i == 0) {
            this.nr = 0L;
        } else {
            this.nr = System.currentTimeMillis();
        }
    }

    public boolean u() {
        return this.u == 4;
    }
}
