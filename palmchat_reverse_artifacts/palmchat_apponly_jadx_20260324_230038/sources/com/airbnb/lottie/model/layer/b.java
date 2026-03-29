package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.model.layer.Layer;
import com.baidu.mapapi.map.WeightedLatLng;
import defpackage.b03;
import defpackage.d93;
import defpackage.dd;
import defpackage.f96;
import defpackage.h75;
import defpackage.i93;
import defpackage.m03;
import defpackage.r86;
import defpackage.sq;
import defpackage.u73;
import defpackage.u83;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class b extends com.airbnb.lottie.model.layer.a {

    @Nullable
    public sq<Float, Float> D;
    public final List<com.airbnb.lottie.model.layer.a> E;
    public final RectF F;
    public final RectF G;
    public final Paint H;

    @Nullable
    public Boolean I;

    @Nullable
    public Boolean J;
    public boolean K;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2528a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f2528a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2528a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(u83 u83Var, Layer layer, List<Layer> list, u73 u73Var) {
        int i;
        com.airbnb.lottie.model.layer.a aVar;
        super(u83Var, layer);
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.K = true;
        dd ddVarU = layer.u();
        if (ddVarU != null) {
            sq<Float, Float> sqVarA = ddVarU.a();
            this.D = sqVarA;
            i(sqVarA);
            this.D.a(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(u73Var.k().size());
        int size = list.size() - 1;
        com.airbnb.lottie.model.layer.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            com.airbnb.lottie.model.layer.a aVarU = com.airbnb.lottie.model.layer.a.u(this, layer2, u83Var, u73Var);
            if (aVarU != null) {
                longSparseArray.put(aVarU.y().d(), aVarU);
                if (aVar2 != null) {
                    aVar2.I(aVarU);
                    aVar2 = null;
                } else {
                    this.E.add(0, aVarU);
                    int i2 = a.f2528a[layer2.h().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        aVar2 = aVarU;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            com.airbnb.lottie.model.layer.a aVar3 = (com.airbnb.lottie.model.layer.a) longSparseArray.get(longSparseArray.keyAt(i));
            if (aVar3 != null && (aVar = (com.airbnb.lottie.model.layer.a) longSparseArray.get(aVar3.y().j())) != null) {
                aVar3.K(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void H(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        for (int i2 = 0; i2 < this.E.size(); i2++) {
            this.E.get(i2).c(b03Var, i, list, b03Var2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void J(boolean z) {
        super.J(z);
        Iterator<com.airbnb.lottie.model.layer.a> it = this.E.iterator();
        while (it.hasNext()) {
            it.next().J(z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void L(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        super.L(f);
        if (this.D != null) {
            f = ((this.D.h().floatValue() * this.q.b().i()) - this.q.b().p()) / (this.p.L().e() + 0.01f);
        }
        if (this.D == null) {
            f -= this.q.r();
        }
        if (this.q.v() != 0.0f && !"__container".equals(this.q.i())) {
            f /= this.q.v();
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.E.get(size).L(f);
        }
    }

    public boolean O() {
        if (this.J == null) {
            for (int size = this.E.size() - 1; size >= 0; size--) {
                com.airbnb.lottie.model.layer.a aVar = this.E.get(size);
                if (aVar instanceof h75) {
                    if (aVar.z()) {
                        this.J = Boolean.TRUE;
                        return true;
                    }
                } else if ((aVar instanceof b) && ((b) aVar).O()) {
                    this.J = Boolean.TRUE;
                    return true;
                }
            }
            this.J = Boolean.FALSE;
        }
        return this.J.booleanValue();
    }

    public boolean P() {
        if (this.I == null) {
            if (A()) {
                this.I = Boolean.TRUE;
                return true;
            }
            for (int size = this.E.size() - 1; size >= 0; size--) {
                if (this.E.get(size).A()) {
                    this.I = Boolean.TRUE;
                    return true;
                }
            }
            this.I = Boolean.FALSE;
        }
        return this.I.booleanValue();
    }

    public void Q(boolean z) {
        this.K = z;
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.ah1
    public void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.F.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.E.get(size).a(this.F, this.o, true);
            rectF.union(this.F);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, defpackage.c03
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        super.h(t, i93Var);
        if (t == d93.E) {
            if (i93Var == null) {
                sq<Float, Float> sqVar = this.D;
                if (sqVar != null) {
                    sqVar.n(null);
                    return;
                }
                return;
            }
            f96 f96Var = new f96(i93Var);
            this.D = f96Var;
            f96Var.a(this);
            i(this.D);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void t(Canvas canvas, Matrix matrix, int i) {
        m03.a("CompositionLayer#draw");
        this.G.set(0.0f, 0.0f, this.q.l(), this.q.k());
        matrix.mapRect(this.G);
        boolean z = this.p.i0() && this.E.size() > 1 && i != 255;
        if (z) {
            this.H.setAlpha(i);
            r86.m(canvas, this.G, this.H);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (((!this.K && "__container".equals(this.q.i())) || this.G.isEmpty()) ? true : canvas.clipRect(this.G)) {
                this.E.get(size).d(canvas, matrix, i);
            }
        }
        canvas.restore();
        m03.b("CompositionLayer#draw");
    }
}
