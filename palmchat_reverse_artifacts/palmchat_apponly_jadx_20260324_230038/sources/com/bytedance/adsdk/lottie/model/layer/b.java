package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bytedance.adsdk.lottie.model.layer.n;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b extends fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RectF f4984a;
    private final RectF jk;
    private boolean l;
    private final List<fx> n;
    private final Paint t;
    private com.bytedance.adsdk.lottie.u.nr.u<Float, Float> x;

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.layer.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[n.nr.values().length];
            u = iArr;
            try {
                iArr[n.nr.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[n.nr.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(com.bytedance.adsdk.lottie.n nVar, n nVar2, List<n> list, com.bytedance.adsdk.lottie.iz izVar, Context context) {
        int i;
        fx fxVar;
        n.nr nrVarL;
        int i2;
        super(nVar, nVar2);
        this.n = new ArrayList();
        this.f4984a = new RectF();
        this.jk = new RectF();
        this.t = new Paint();
        this.l = true;
        com.bytedance.adsdk.lottie.model.u.nr nrVarDw = nVar2.dw();
        if (nrVarDw != null) {
            com.bytedance.adsdk.lottie.u.nr.u<Float, Float> uVarU = nrVarDw.u();
            this.x = uVarU;
            u(uVarU);
            this.x.u(this);
        } else {
            this.x = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(izVar.s().size());
        int size = list.size() - 1;
        fx fxVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            n nVar3 = list.get(size);
            fx fxVarU = fx.u(this, nVar3, nVar, izVar, context);
            if (fxVarU != null) {
                longSparseArray.put(fxVarU.b().pn(), fxVarU);
                if (fxVar2 != null) {
                    fxVar2.u(fxVarU);
                    fxVar2 = null;
                } else {
                    this.n.add(0, fxVarU);
                    if (nVar3 != null && (nrVarL = nVar3.l()) != null && ((i2 = AnonymousClass1.u[nrVarL.ordinal()]) == 1 || i2 == 2)) {
                        fxVar2 = fxVarU;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            fx fxVar3 = (fx) longSparseArray.get(longSparseArray.keyAt(i));
            if (fxVar3 != null && (fxVar = (fx) longSparseArray.get(fxVar3.b().mv())) != null) {
                fxVar3.nr(fxVar);
            }
        }
    }

    public void nr(boolean z) {
        this.l = z;
    }

    public List<fx> s() {
        return this.n;
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public void u(boolean z) {
        super.u(z);
        Iterator<fx> it = this.n.iterator();
        while (it.hasNext()) {
            it.next().u(z);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public void nr(Canvas canvas, Matrix matrix, int i) {
        super.nr(canvas, matrix, i);
        com.bytedance.adsdk.lottie.pn.u("CompositionLayer#draw");
        this.jk.set(0.0f, 0.0f, this.fx.n(), this.fx.a());
        matrix.mapRect(this.jk);
        boolean z = this.nr.jk() && this.n.size() > 1 && i != 255;
        if (z) {
            this.t.setAlpha(i);
            com.bytedance.adsdk.lottie.pn.a.u(canvas, this.jk, this.t);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.n.size() - 1; size >= 0; size--) {
            if (((!this.l && "__container".equals(this.fx.iz())) || this.jk.isEmpty()) ? true : canvas.clipRect(this.jk)) {
                this.n.get(size).u(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.bytedance.adsdk.lottie.pn.nr("CompositionLayer#draw");
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx, com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        super.u(rectF, matrix, z);
        for (int size = this.n.size() - 1; size >= 0; size--) {
            this.f4984a.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.n.get(size).u(this.f4984a, this.u, true);
            rectF.union(this.f4984a);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.fx
    public void u(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        super.u(f);
        if (this.x != null) {
            f = ((this.x.x().floatValue() * this.fx.u().mv()) - this.fx.u().iz()) / (this.nr.gi().sx() + 0.01f);
        }
        if (this.x == null) {
            f -= this.fx.fx();
        }
        if (this.fx.nr() != 0.0f && !"__container".equals(this.fx.iz())) {
            f /= this.fx.nr();
        }
        for (int size = this.n.size() - 1; size >= 0; size--) {
            this.n.get(size).u(f);
        }
    }
}
