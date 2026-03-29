package com.bytedance.sdk.component.iz.b;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.iz.bq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends u {
    private com.bytedance.sdk.component.iz.x nr;
    private byte[] u;

    public pn(byte[] bArr, com.bytedance.sdk.component.iz.x xVar) {
        this.u = bArr;
        this.nr = xVar;
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public String u() {
        return "decode";
    }

    @Override // com.bytedance.sdk.component.iz.b.a
    public void u(com.bytedance.sdk.component.iz.fx.fx fxVar) {
        com.bytedance.sdk.component.iz.fx.iz izVarL = fxVar.l();
        com.bytedance.sdk.component.iz.fx.nr.u uVarU = izVarL.u(fxVar);
        try {
            bq bqVarK = fxVar.k();
            if (bqVarK != null) {
                bqVarK.onStep(10, null);
            }
            Bitmap bitmapU = uVarU.u(this.u);
            if (bitmapU != null) {
                fxVar.u(new mv(bitmapU, this.u, this.nr, false));
                izVarL.u(fxVar.mv()).u(fxVar.getMemoryCacheKey(), bitmapU);
            } else {
                u(1002, "decode failed bitmap null", null, fxVar);
            }
            if (bqVarK != null) {
                bqVarK.onStep(11, bitmapU);
            }
        } catch (Throwable th) {
            u(1002, "decode failed:" + th.getMessage(), th, fxVar);
        }
    }

    private void u(int i, String str, Throwable th, com.bytedance.sdk.component.iz.fx.fx fxVar) {
        if (this.nr == null) {
            fxVar.u(new t());
        } else {
            fxVar.u(new n(i, str, th));
        }
    }
}
