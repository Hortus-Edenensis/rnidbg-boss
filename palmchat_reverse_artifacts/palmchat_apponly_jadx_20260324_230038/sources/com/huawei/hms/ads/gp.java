package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gp implements hb {
    private static final String Code = "OmPresent";
    private hm I;
    private gx V;
    private boolean Z;
    private boolean B = true;
    private boolean C = false;
    private boolean S = false;
    private boolean F = false;
    private boolean D = false;

    @Override // com.huawei.hms.ads.hm
    public void B() {
        hm hmVar = this.I;
        if (hmVar == null) {
            return;
        }
        hmVar.B();
    }

    @Override // com.huawei.hms.ads.hm
    public void C() {
        hm hmVar = this.I;
        if (hmVar == null) {
            return;
        }
        hmVar.C();
    }

    public gx Code() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.hr
    public void D() {
        fh.V(Code, "impressionOccurred");
        if (this.S) {
            return;
        }
        gx gxVar = this.V;
        if (gxVar instanceof gs) {
            ((gs) gxVar).D();
            this.S = true;
        }
        gx gxVar2 = this.V;
        if (gxVar2 instanceof ha) {
            ((ha) gxVar2).B();
            this.S = true;
        }
    }

    @Override // com.huawei.hms.ads.hm
    public String F() {
        hm hmVar = this.I;
        if (hmVar == null) {
            return null;
        }
        return hmVar.F();
    }

    @Override // com.huawei.hms.ads.hb
    public void I() {
        fh.V(Code, "release");
        if (this.F) {
            this.B = true;
            this.C = false;
            this.S = false;
            gx gxVar = this.V;
            if (gxVar != null) {
                gxVar.V();
            }
            hm hmVar = this.I;
            if (hmVar != null) {
                hmVar.B();
            }
            this.F = false;
        }
    }

    @Override // com.huawei.hms.ads.hr
    public void L() {
        fh.V(Code, "load");
        if (this.B || !this.S) {
            gx gxVar = this.V;
            if (gxVar instanceof gs) {
                ((gs) gxVar).L();
            }
        }
    }

    @Override // com.huawei.hms.ads.hm
    public hi S() {
        hm hmVar = this.I;
        if (hmVar == null) {
            return null;
        }
        return hmVar.S();
    }

    @Override // com.huawei.hms.ads.hb
    public hm V() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.hm
    public void Z() {
        hm hmVar = this.I;
        if (hmVar == null) {
            fh.V(Code, "AdSessionAgent is null");
        } else {
            hmVar.Z();
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void a() {
        fh.V(Code, "complete");
        if (this.B || !this.C) {
            gx gxVar = this.V;
            if (gxVar instanceof ha) {
                ((ha) gxVar).a();
                this.C = true;
            }
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void b() {
        if (this.B || !this.C) {
            gx gxVar = this.V;
            if (gxVar instanceof ha) {
                ((ha) gxVar).b();
            }
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void c() {
        if (this.B || !this.C) {
            gx gxVar = this.V;
            if (gxVar instanceof ha) {
                ((ha) gxVar).c();
            }
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void d() {
        fh.V(Code, "skipped");
        gx gxVar = this.V;
        if (gxVar instanceof ha) {
            ((ha) gxVar).d();
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void e() {
        fh.V(Code, "pause");
        if (!this.B && this.C) {
            fh.I(Code, "pause: Video completed");
            return;
        }
        gx gxVar = this.V;
        if (gxVar instanceof ha) {
            ((ha) gxVar).e();
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void f() {
        fh.V(Code, com.huawei.openalliance.ad.constant.az.ag);
        if (!this.B && this.C) {
            fh.I(Code, "resume: Video completed");
            return;
        }
        gx gxVar = this.V;
        if (gxVar instanceof ha) {
            ((ha) gxVar).f();
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void Code(float f) {
        if (fh.Code()) {
            fh.Code(Code, "onProgress, isAllowRepeat= %s, isVideoComplete= %s", Boolean.valueOf(this.B), Boolean.valueOf(this.C));
        }
        if (this.B || !this.C) {
            gx gxVar = this.V;
            if (gxVar instanceof ha) {
                ((ha) gxVar).Code(f);
            }
        }
    }

    @Override // com.huawei.hms.ads.hm
    public void I(View view) {
        hm hmVar = this.I;
        if (hmVar == null) {
            return;
        }
        hmVar.I(view);
    }

    @Override // com.huawei.hms.ads.hw
    public void V(float f) {
        if (!this.B && this.C) {
            fh.I(Code, "volumeChange: Video completed");
            return;
        }
        gx gxVar = this.V;
        if (gxVar instanceof ha) {
            ((ha) gxVar).V(f);
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void Code(float f, boolean z) {
        fh.V(Code, "start");
        if (!this.B && this.C) {
            fh.I(Code, "start: Video completed");
            return;
        }
        gx gxVar = this.V;
        if (gxVar instanceof ha) {
            ((ha) gxVar).Code(f, z);
        }
    }

    @Override // com.huawei.hms.ads.hm
    public void V(View view) {
        hm hmVar = this.I;
        if (hmVar == null) {
            return;
        }
        hmVar.V(view);
    }

    @Override // com.huawei.hms.ads.hb
    public void Code(Context context, AdContentData adContentData, gl glVar, boolean z) {
        if ((adContentData != null ? adContentData.aj() : null) == null) {
            fh.V(Code, "om is null, no initialization is required");
            return;
        }
        if (this.F) {
            return;
        }
        fh.V(Code, "init omPresent");
        this.I = gr.Code(context, adContentData, glVar, z);
        gx gxVarCode = gw.Code(adContentData);
        this.V = gxVarCode;
        gxVarCode.Code(this.I);
        this.Z = z;
        this.F = true;
        this.D = false;
        this.S = false;
    }

    @Override // com.huawei.hms.ads.hw
    public void V(boolean z) {
        gx gxVar = this.V;
        if (gxVar instanceof ha) {
            ((ha) gxVar).V(z);
        }
    }

    @Override // com.huawei.hms.ads.hm
    public void Code(View view) {
        if (this.Z) {
            return;
        }
        hm hmVar = this.I;
        if (hmVar == null) {
            fh.V(Code, "AdSessionAgent is null");
        } else {
            hmVar.Code(view);
        }
    }

    @Override // com.huawei.hms.ads.hm
    public void Code(View view, hl hlVar, String str) {
        hm hmVar = this.I;
        if (hmVar == null) {
            return;
        }
        hmVar.Code(view, hlVar, str);
    }

    @Override // com.huawei.hms.ads.hm
    public void Code(hk hkVar, String str) {
        hm hmVar = this.I;
        if (hmVar == null) {
            return;
        }
        hmVar.Code(hkVar, str);
    }

    @Override // com.huawei.hms.ads.hr
    public void Code(hv hvVar) {
        fh.V(Code, "load vastPropertiesWrapper");
        if (this.B || !this.S) {
            gx gxVar = this.V;
            if (gxVar instanceof gs) {
                ((gs) gxVar).Code(hvVar);
            }
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void Code(hx hxVar) {
        gx gxVar = this.V;
        if (gxVar instanceof ha) {
            ((ha) gxVar).Code(hxVar);
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void Code(hy hyVar) {
        gx gxVar = this.V;
        if (gxVar instanceof ha) {
            ((ha) gxVar).Code(hyVar);
        }
    }

    @Override // com.huawei.hms.ads.hw
    public void Code(ia iaVar) {
        if (!this.B && this.C) {
            fh.I(Code, "loaded: Video completed");
            return;
        }
        if (this.D) {
            if (fh.Code()) {
                fh.Code(Code, "Already loaded");
            }
        } else {
            gx gxVar = this.V;
            if (gxVar instanceof ha) {
                ((ha) gxVar).Code(iaVar);
            }
            this.D = true;
        }
    }

    @Override // com.huawei.hms.ads.hb
    public void Code(boolean z) {
        this.B = z;
    }
}
