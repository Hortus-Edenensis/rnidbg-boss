package com.bytedance.adsdk.lottie.u.u;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.u.nr.u;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements u.InterfaceC0166u, mv, pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.n f5010a;
    private final Path b;
    private final Matrix fx;
    private final String iz;
    private List<mv> jk;
    private final List<fx> n;
    private final RectF nr;
    private final RectF pn;
    private com.bytedance.adsdk.lottie.u.nr.my t;
    private final Paint u;
    private final boolean x;

    public b(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, com.bytedance.adsdk.lottie.model.nr.my myVar, com.bytedance.adsdk.lottie.iz izVar) {
        this(nVar, fxVar, myVar.u(), myVar.fx(), u(nVar, izVar, fxVar, myVar.nr()), u(myVar.nr()));
    }

    private boolean pn() {
        int i = 0;
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            if ((this.n.get(i2) instanceof pn) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    private static List<fx> u(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.iz izVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, List<com.bytedance.adsdk.lottie.model.nr.fx> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            fx fxVarU = list.get(i).u(nVar, izVar, fxVar);
            if (fxVarU != null) {
                arrayList.add(fxVarU);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.lottie.u.u.mv
    public Path b() {
        this.fx.reset();
        com.bytedance.adsdk.lottie.u.nr.my myVar = this.t;
        if (myVar != null) {
            this.fx.set(myVar.b());
        }
        this.b.reset();
        if (this.x) {
            return this.b;
        }
        for (int size = this.n.size() - 1; size >= 0; size--) {
            fx fxVar = this.n.get(size);
            if (fxVar instanceof mv) {
                this.b.addPath(((mv) fxVar).b(), this.fx);
            }
        }
        return this.b;
    }

    public Matrix fx() {
        com.bytedance.adsdk.lottie.u.nr.my myVar = this.t;
        if (myVar != null) {
            return myVar.b();
        }
        this.fx.reset();
        return this.fx;
    }

    public List<mv> nr() {
        if (this.jk == null) {
            this.jk = new ArrayList();
            for (int i = 0; i < this.n.size(); i++) {
                fx fxVar = this.n.get(i);
                if (fxVar instanceof mv) {
                    this.jk.add((mv) fxVar);
                }
            }
        }
        return this.jk;
    }

    public b(com.bytedance.adsdk.lottie.n nVar, com.bytedance.adsdk.lottie.model.layer.fx fxVar, String str, boolean z, List<fx> list, com.bytedance.adsdk.lottie.model.u.l lVar) {
        this.u = new com.bytedance.adsdk.lottie.u.u();
        this.nr = new RectF();
        this.fx = new Matrix();
        this.b = new Path();
        this.pn = new RectF();
        this.iz = str;
        this.f5010a = nVar;
        this.x = z;
        this.n = list;
        if (lVar != null) {
            com.bytedance.adsdk.lottie.u.nr.my myVarJk = lVar.jk();
            this.t = myVarJk;
            myVarJk.u(fxVar);
            this.t.u(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            fx fxVar2 = list.get(size);
            if (fxVar2 instanceof jk) {
                arrayList.add((jk) fxVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((jk) arrayList.get(size2)).u(list.listIterator(list.size()));
        }
    }

    public static com.bytedance.adsdk.lottie.model.u.l u(List<com.bytedance.adsdk.lottie.model.nr.fx> list) {
        for (int i = 0; i < list.size(); i++) {
            com.bytedance.adsdk.lottie.model.nr.fx fxVar = list.get(i);
            if (fxVar instanceof com.bytedance.adsdk.lottie.model.u.l) {
                return (com.bytedance.adsdk.lottie.model.u.l) fxVar;
            }
        }
        return null;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        this.f5010a.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.fx
    public void u(List<fx> list, List<fx> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.n.size());
        arrayList.addAll(list);
        for (int size = this.n.size() - 1; size >= 0; size--) {
            fx fxVar = this.n.get(size);
            fxVar.u(arrayList, this.n.subList(0, size));
            arrayList.add(fxVar);
        }
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(Canvas canvas, Matrix matrix, int i) {
        if (this.x) {
            return;
        }
        this.fx.set(matrix);
        com.bytedance.adsdk.lottie.u.nr.my myVar = this.t;
        if (myVar != null) {
            this.fx.preConcat(myVar.b());
            i = (int) (((((this.t.u() == null ? 100 : this.t.u().x().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.f5010a.jk() && pn() && i != 255;
        if (z) {
            this.nr.set(0.0f, 0.0f, 0.0f, 0.0f);
            u(this.nr, this.fx, true);
            this.u.setAlpha(i);
            com.bytedance.adsdk.lottie.pn.a.u(canvas, this.nr, this.u);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.n.size() - 1; size >= 0; size--) {
            fx fxVar = this.n.get(size);
            if (fxVar instanceof pn) {
                ((pn) fxVar).u(canvas, this.fx, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(RectF rectF, Matrix matrix, boolean z) {
        this.fx.set(matrix);
        com.bytedance.adsdk.lottie.u.nr.my myVar = this.t;
        if (myVar != null) {
            this.fx.preConcat(myVar.b());
        }
        this.pn.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.n.size() - 1; size >= 0; size--) {
            fx fxVar = this.n.get(size);
            if (fxVar instanceof pn) {
                ((pn) fxVar).u(this.pn, this.fx, z);
                rectF.union(this.pn);
            }
        }
    }
}
