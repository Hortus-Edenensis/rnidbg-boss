package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class my implements u.InterfaceC0166u, jk, mv, pn, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.u.nr.my f5012a;
    private final com.bytedance.adsdk.lottie.model.layer.fx b;
    private final com.bytedance.adsdk.lottie.n fx;
    private final boolean iz;
    private b jk;
    private final com.bytedance.adsdk.lottie.u.nr.u<Float, Float> n;
    private final String pn;
    private final com.bytedance.adsdk.lottie.u.nr.u<Float, Float> x;
    private final Matrix u = new Matrix();
    private final Path nr = new Path();

    public my(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.l lVar) {
        this.fx = nVar;
        this.b = fxVar;
        this.pn = lVar.u();
        this.iz = lVar.pn();
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU = lVar.nr().u();
        this.x = uVarU;
        fxVar.u(uVarU);
        uVarU.u(this);
        com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU2 = lVar.fx().u();
        this.n = uVarU2;
        fxVar.u(uVarU2);
        uVarU2.u(this);
        com.bytedance.adsdk.lottie.u.nr.my myVarJk = lVar.b().jk();
        this.f5012a = myVarJk;
        myVarJk.u(fxVar);
        myVarJk.u(this);
    }

    @Override // com.bytedance.adsdk.lottie.u.u.mv
    public Path b() {
        Path pathB = this.jk.b();
        this.nr.reset();
        float fFloatValue = this.x.x().floatValue();
        float fFloatValue2 = this.n.x().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.u.set(this.f5012a.nr(i + fFloatValue2));
            this.nr.addPath(pathB, this.u);
        }
        return this.nr;
    }

    @Override // com.bytedance.adsdk.lottie.u.u.jk
    public void u(ListIterator<fx> listIterator) {
        if (this.jk != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.jk = new b(this.fx, this.b, "Repeater", this.iz, arrayList, null);
    }

    @Override // com.bytedance.adsdk.lottie.u.u.fx
    public void u(List<fx> list, List<fx> list2) {
        this.jk.u(list, list2);
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.x.x().floatValue();
        float fFloatValue2 = this.n.x().floatValue();
        float fFloatValue3 = this.f5012a.nr().x().floatValue() / 100.0f;
        float fFloatValue4 = this.f5012a.fx().x().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.u.set(matrix);
            float f = i2;
            this.u.preConcat(this.f5012a.nr(f + fFloatValue2));
            this.jk.u(canvas, this.u, (int) (i * com.bytedance.adsdk.lottie.pn.n.u(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        this.jk.u(rectF, matrix, z);
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        this.fx.invalidateSelf();
    }
}
