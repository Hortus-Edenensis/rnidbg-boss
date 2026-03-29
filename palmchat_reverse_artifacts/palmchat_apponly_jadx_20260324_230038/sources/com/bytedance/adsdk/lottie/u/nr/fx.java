package com.bytedance.adsdk.lottie.u.nr;

import android.graphics.Color;
import android.graphics.Paint;
import com.bytedance.adsdk.lottie.u.nr.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx implements u.InterfaceC0166u {
    private final u<Float, Float> b;
    private final u<Float, Float> fx;
    private final u<Float, Float> iz;
    private final u<Integer, Integer> nr;
    private final u<Float, Float> pn;
    private final u.InterfaceC0166u u;
    private boolean x = true;

    public fx(u.InterfaceC0166u interfaceC0166u, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.b.jk jkVar) {
        this.u = interfaceC0166u;
        u<Integer, Integer> uVarU = jkVar.u().u();
        this.nr = uVarU;
        uVarU.u(this);
        fxVar.u(uVarU);
        u<Float, Float> uVarU2 = jkVar.nr().u();
        this.fx = uVarU2;
        uVarU2.u(this);
        fxVar.u(uVarU2);
        u<Float, Float> uVarU3 = jkVar.fx().u();
        this.b = uVarU3;
        uVarU3.u(this);
        fxVar.u(uVarU3);
        u<Float, Float> uVarU4 = jkVar.b().u();
        this.pn = uVarU4;
        uVarU4.u(this);
        fxVar.u(uVarU4);
        u<Float, Float> uVarU5 = jkVar.pn().u();
        this.iz = uVarU5;
        uVarU5.u(this);
        fxVar.u(uVarU5);
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        this.x = true;
        this.u.u();
    }

    public void u(Paint paint) {
        if (this.x) {
            this.x = false;
            double dFloatValue = ((double) this.b.x().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.pn.x().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.nr.x().intValue();
            paint.setShadowLayer(this.iz.x().floatValue(), fSin, fCos, Color.argb(Math.round(this.fx.x().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }
}
