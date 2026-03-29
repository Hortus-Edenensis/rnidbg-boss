package com.bytedance.adsdk.lottie.u.u;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class o implements u.InterfaceC0166u, bg {
    private com.bytedance.adsdk.lottie.model.nr.s b;
    private final com.bytedance.adsdk.lottie.u.nr.u<Float, Float> fx;
    private final String nr;
    private final com.bytedance.adsdk.lottie.n u;

    public o(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.mv mvVar) {
        this.u = nVar;
        this.nr = mvVar.u();
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU = mvVar.nr().u();
        this.fx = uVarU;
        fxVar.u(uVarU);
        uVarU.u(this);
    }

    public com.bytedance.adsdk.lottie.u.nr.u<Float, Float> nr() {
        return this.fx;
    }

    @Override // com.bytedance.adsdk.lottie.u.u.fx
    public void u(List<fx> list, List<fx> list2) {
    }

    private com.bytedance.adsdk.lottie.model.nr.s nr(com.bytedance.adsdk.lottie.model.nr.s sVar) {
        List<com.bytedance.adsdk.lottie.model.u> listFx = sVar.fx();
        boolean zNr = sVar.nr();
        int size = listFx.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.bytedance.adsdk.lottie.model.u uVar = listFx.get(size);
            com.bytedance.adsdk.lottie.model.u uVar2 = listFx.get(u(size - 1, listFx.size()));
            PointF pointFFx = (size != 0 || zNr) ? uVar2.fx() : sVar.u();
            i = (((size != 0 || zNr) ? uVar2.nr() : pointFFx).equals(pointFFx) && uVar.u().equals(pointFFx) && !(!sVar.nr() && size == 0 && size == listFx.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.bytedance.adsdk.lottie.model.nr.s sVar2 = this.b;
        if (sVar2 == null || sVar2.fx().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.bytedance.adsdk.lottie.model.u());
            }
            this.b = new com.bytedance.adsdk.lottie.model.nr.s(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.b.u(zNr);
        return this.b;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        this.u.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.bg
    public com.bytedance.adsdk.lottie.model.nr.s u(com.bytedance.adsdk.lottie.model.nr.s sVar) {
        List<com.bytedance.adsdk.lottie.model.u> list;
        List<com.bytedance.adsdk.lottie.model.u> listFx = sVar.fx();
        if (listFx.size() <= 2) {
            return sVar;
        }
        float fFloatValue = this.fx.x().floatValue();
        if (fFloatValue == 0.0f) {
            return sVar;
        }
        com.bytedance.adsdk.lottie.model.nr.s sVarNr = nr(sVar);
        sVarNr.u(sVar.u().x, sVar.u().y);
        List<com.bytedance.adsdk.lottie.model.u> listFx2 = sVarNr.fx();
        boolean zNr = sVar.nr();
        int i = 0;
        int i2 = 0;
        while (i < listFx.size()) {
            com.bytedance.adsdk.lottie.model.u uVar = listFx.get(i);
            com.bytedance.adsdk.lottie.model.u uVar2 = listFx.get(u(i - 1, listFx.size()));
            com.bytedance.adsdk.lottie.model.u uVar3 = listFx.get(u(i - 2, listFx.size()));
            PointF pointFFx = (i != 0 || zNr) ? uVar2.fx() : sVar.u();
            PointF pointFNr = (i != 0 || zNr) ? uVar2.nr() : pointFFx;
            PointF pointFU = uVar.u();
            PointF pointFFx2 = uVar3.fx();
            PointF pointFFx3 = uVar.fx();
            boolean z = !sVar.nr() && i == 0 && i == listFx.size() + (-1);
            if (pointFNr.equals(pointFFx) && pointFU.equals(pointFFx) && !z) {
                float f = pointFFx.x;
                float f2 = f - pointFFx2.x;
                float f3 = pointFFx.y;
                float f4 = f3 - pointFFx2.y;
                float f5 = pointFFx3.x - f;
                float f6 = pointFFx3.y - f3;
                list = listFx;
                float fHypot = (float) Math.hypot(f2, f4);
                float fHypot2 = (float) Math.hypot(f5, f6);
                float fMin = Math.min(fFloatValue / fHypot, 0.5f);
                float fMin2 = Math.min(fFloatValue / fHypot2, 0.5f);
                float f7 = pointFFx.x;
                float f8 = ((pointFFx2.x - f7) * fMin) + f7;
                float f9 = pointFFx.y;
                float f10 = ((pointFFx2.y - f9) * fMin) + f9;
                float f11 = ((pointFFx3.x - f7) * fMin2) + f7;
                float f12 = ((pointFFx3.y - f9) * fMin2) + f9;
                float f13 = f8 - ((f8 - f7) * 0.5519f);
                float f14 = f10 - ((f10 - f9) * 0.5519f);
                float f15 = f11 - ((f11 - f7) * 0.5519f);
                float f16 = f12 - ((f12 - f9) * 0.5519f);
                com.bytedance.adsdk.lottie.model.u uVar4 = listFx2.get(u(i2 - 1, listFx2.size()));
                com.bytedance.adsdk.lottie.model.u uVar5 = listFx2.get(i2);
                uVar4.nr(f8, f10);
                uVar4.fx(f8, f10);
                if (i == 0) {
                    sVarNr.u(f8, f10);
                }
                uVar5.u(f13, f14);
                i2++;
                com.bytedance.adsdk.lottie.model.u uVar6 = listFx2.get(i2);
                uVar5.nr(f15, f16);
                uVar5.fx(f11, f12);
                uVar6.u(f11, f12);
            } else {
                list = listFx;
                com.bytedance.adsdk.lottie.model.u uVar7 = listFx2.get(u(i2 - 1, listFx2.size()));
                com.bytedance.adsdk.lottie.model.u uVar8 = listFx2.get(i2);
                uVar7.nr(uVar2.nr().x, uVar2.nr().y);
                uVar7.fx(uVar2.fx().x, uVar2.fx().y);
                uVar8.u(uVar.u().x, uVar.u().y);
            }
            i2++;
            i++;
            listFx = list;
        }
        return sVarNr;
    }

    private static int nr(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }

    private static int u(int i, int i2) {
        return i - (nr(i, i2) * i2);
    }
}
