package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import com.baidu.mapapi.map.WeightedLatLng;
import defpackage.ah1;
import defpackage.b03;
import defpackage.c03;
import defpackage.cg5;
import defpackage.cv5;
import defpackage.eu;
import defpackage.fr2;
import defpackage.h75;
import defpackage.hd3;
import defpackage.i93;
import defpackage.ii1;
import defpackage.ko0;
import defpackage.m03;
import defpackage.m63;
import defpackage.o03;
import defpackage.r86;
import defpackage.sq;
import defpackage.u73;
import defpackage.u83;
import defpackage.ux1;
import defpackage.w06;
import defpackage.y34;
import defpackage.z65;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements ah1, sq.b, c03 {

    @Nullable
    public Paint A;
    public float B;

    @Nullable
    public BlurMaskFilter C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f2526a = new Path();
    public final Matrix b = new Matrix();
    public final Matrix c = new Matrix();
    public final Paint d = new o03(1);
    public final Paint e = new o03(1, PorterDuff.Mode.DST_IN);
    public final Paint f = new o03(1, PorterDuff.Mode.DST_OUT);
    public final Paint g;
    public final Paint h;
    public final RectF i;
    public final RectF j;
    public final RectF k;
    public final RectF l;
    public final RectF m;
    public final String n;
    public final Matrix o;
    public final u83 p;
    public final Layer q;

    @Nullable
    public hd3 r;

    @Nullable
    public ux1 s;

    @Nullable
    public a t;

    @Nullable
    public a u;
    public List<a> v;
    public final List<sq<?, ?>> w;
    public final w06 x;
    public boolean y;
    public boolean z;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.layer.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class C0048a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2527a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f2527a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2527a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2527a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2527a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2527a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2527a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2527a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public a(u83 u83Var, Layer layer) {
        o03 o03Var = new o03(1);
        this.g = o03Var;
        this.h = new o03(PorterDuff.Mode.CLEAR);
        this.i = new RectF();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new RectF();
        this.m = new RectF();
        this.o = new Matrix();
        this.w = new ArrayList();
        this.y = true;
        this.B = 0.0f;
        this.p = u83Var;
        this.q = layer;
        this.n = layer.i() + "#draw";
        if (layer.h() == Layer.MatteType.INVERT) {
            o03Var.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            o03Var.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        w06 w06VarB = layer.w().b();
        this.x = w06VarB;
        w06VarB.b(this);
        if (layer.g() != null && !layer.g().isEmpty()) {
            hd3 hd3Var = new hd3(layer.g());
            this.r = hd3Var;
            Iterator<sq<z65, Path>> it = hd3Var.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            for (sq<Integer, Integer> sqVar : this.r.c()) {
                i(sqVar);
                sqVar.a(this);
            }
        }
        N();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        M(this.s.p() == 1.0f);
    }

    @Nullable
    public static a u(b bVar, Layer layer, u83 u83Var, u73 u73Var) {
        switch (C0048a.f2527a[layer.f().ordinal()]) {
            case 1:
                return new h75(u83Var, layer, bVar);
            case 2:
                return new b(u83Var, layer, u73Var.o(layer.m()), u73Var);
            case 3:
                return new cg5(u83Var, layer);
            case 4:
                return new fr2(u83Var, layer);
            case 5:
                return new y34(u83Var, layer);
            case 6:
                return new cv5(u83Var, layer);
            default:
                m63.c("Unknown layer type " + layer.f());
                return null;
        }
    }

    public boolean A() {
        return this.t != null;
    }

    public final void B(RectF rectF, Matrix matrix) {
        this.k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (z()) {
            int size = this.r.b().size();
            for (int i = 0; i < size; i++) {
                Mask mask = this.r.b().get(i);
                Path pathH = this.r.a().get(i).h();
                if (pathH != null) {
                    this.f2526a.set(pathH);
                    this.f2526a.transform(matrix);
                    int i2 = C0048a.b[mask.a().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && mask.d()) {
                        return;
                    }
                    this.f2526a.computeBounds(this.m, false);
                    if (i == 0) {
                        this.k.set(this.m);
                    } else {
                        RectF rectF2 = this.k;
                        rectF2.set(Math.min(rectF2.left, this.m.left), Math.min(this.k.top, this.m.top), Math.max(this.k.right, this.m.right), Math.max(this.k.bottom, this.m.bottom));
                    }
                }
            }
            if (rectF.intersect(this.k)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void C(RectF rectF, Matrix matrix) {
        if (A() && this.q.h() != Layer.MatteType.INVERT) {
            this.l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.t.a(this.l, matrix, true);
            if (rectF.intersect(this.l)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public final void D() {
        this.p.invalidateSelf();
    }

    public final void F(float f) {
        this.p.L().n().a(this.q.i(), f);
    }

    public void G(sq<?, ?> sqVar) {
        this.w.remove(sqVar);
    }

    public void I(@Nullable a aVar) {
        this.t = aVar;
    }

    public void J(boolean z) {
        if (z && this.A == null) {
            this.A = new o03();
        }
        this.z = z;
    }

    public void K(@Nullable a aVar) {
        this.u = aVar;
    }

    public void L(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        this.x.j(f);
        if (this.r != null) {
            for (int i = 0; i < this.r.a().size(); i++) {
                this.r.a().get(i).m(f);
            }
        }
        ux1 ux1Var = this.s;
        if (ux1Var != null) {
            ux1Var.m(f);
        }
        a aVar = this.t;
        if (aVar != null) {
            aVar.L(f);
        }
        for (int i2 = 0; i2 < this.w.size(); i2++) {
            this.w.get(i2).m(f);
        }
    }

    public final void M(boolean z) {
        if (z != this.y) {
            this.y = z;
            D();
        }
    }

    public final void N() {
        if (this.q.e().isEmpty()) {
            M(true);
            return;
        }
        ux1 ux1Var = new ux1(this.q.e());
        this.s = ux1Var;
        ux1Var.l();
        this.s.a(new sq.b() { // from class: tq
            @Override // sq.b
            public final void e() {
                this.f21040a.E();
            }
        });
        M(this.s.h().floatValue() == 1.0f);
        i(this.s);
    }

    @Override // defpackage.ah1
    @CallSuper
    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.o.set(matrix);
        if (z) {
            List<a> list = this.v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.o.preConcat(this.v.get(size).x.f());
                }
            } else {
                a aVar = this.u;
                if (aVar != null) {
                    this.o.preConcat(aVar.x.f());
                }
            }
        }
        this.o.preConcat(this.x.f());
    }

    @Override // defpackage.c03
    public void c(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
        a aVar = this.t;
        if (aVar != null) {
            b03 b03VarA = b03Var2.a(aVar.getName());
            if (b03Var.c(this.t.getName(), i)) {
                list.add(b03VarA.i(this.t));
            }
            if (b03Var.h(getName(), i)) {
                this.t.H(b03Var, b03Var.e(this.t.getName(), i) + i, list, b03VarA);
            }
        }
        if (b03Var.g(getName(), i)) {
            if (!"__container".equals(getName())) {
                b03Var2 = b03Var2.a(getName());
                if (b03Var.c(getName(), i)) {
                    list.add(b03Var2.i(this));
                }
            }
            if (b03Var.h(getName(), i)) {
                H(b03Var, i + b03Var.e(getName(), i), list, b03Var2);
            }
        }
    }

    @Override // defpackage.ah1
    public void d(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        m03.a(this.n);
        if (!this.y || this.q.x()) {
            m03.b(this.n);
            return;
        }
        r();
        m03.a("Layer#parentMatrix");
        this.b.reset();
        this.b.set(matrix);
        for (int size = this.v.size() - 1; size >= 0; size--) {
            this.b.preConcat(this.v.get(size).x.f());
        }
        m03.b("Layer#parentMatrix");
        int iIntValue = (int) ((((i / 255.0f) * (this.x.h() == null ? 100 : this.x.h().h().intValue())) / 100.0f) * 255.0f);
        if (!A() && !z()) {
            this.b.preConcat(this.x.f());
            m03.a("Layer#drawLayer");
            t(canvas, this.b, iIntValue);
            m03.b("Layer#drawLayer");
            F(m03.b(this.n));
            return;
        }
        m03.a("Layer#computeBounds");
        a(this.i, this.b, false);
        C(this.i, matrix);
        this.b.preConcat(this.x.f());
        B(this.i, this.b);
        this.j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.c);
        if (!this.c.isIdentity()) {
            Matrix matrix2 = this.c;
            matrix2.invert(matrix2);
            this.c.mapRect(this.j);
        }
        if (!this.i.intersect(this.j)) {
            this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        m03.b("Layer#computeBounds");
        if (this.i.width() >= 1.0f && this.i.height() >= 1.0f) {
            m03.a("Layer#saveLayer");
            this.d.setAlpha(255);
            r86.m(canvas, this.i, this.d);
            m03.b("Layer#saveLayer");
            s(canvas);
            m03.a("Layer#drawLayer");
            t(canvas, this.b, iIntValue);
            m03.b("Layer#drawLayer");
            if (z()) {
                o(canvas, this.b);
            }
            if (A()) {
                m03.a("Layer#drawMatte");
                m03.a("Layer#saveLayer");
                r86.n(canvas, this.i, this.g, 19);
                m03.b("Layer#saveLayer");
                s(canvas);
                this.t.d(canvas, matrix, iIntValue);
                m03.a("Layer#restoreLayer");
                canvas.restore();
                m03.b("Layer#restoreLayer");
                m03.b("Layer#drawMatte");
            }
            m03.a("Layer#restoreLayer");
            canvas.restore();
            m03.b("Layer#restoreLayer");
        }
        if (this.z && (paint = this.A) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.A.setColor(-251901);
            this.A.setStrokeWidth(4.0f);
            canvas.drawRect(this.i, this.A);
            this.A.setStyle(Paint.Style.FILL);
            this.A.setColor(1357638635);
            canvas.drawRect(this.i, this.A);
        }
        F(m03.b(this.n));
    }

    @Override // sq.b
    public void e() {
        D();
    }

    @Override // defpackage.ko0
    public String getName() {
        return this.q.i();
    }

    @CallSuper
    public <T> void h(T t, @Nullable i93<T> i93Var) {
        this.x.c(t, i93Var);
    }

    public void i(@Nullable sq<?, ?> sqVar) {
        if (sqVar == null) {
            return;
        }
        this.w.add(sqVar);
    }

    public final void j(Canvas canvas, Matrix matrix, sq<z65, Path> sqVar, sq<Integer, Integer> sqVar2) {
        this.f2526a.set(sqVar.h());
        this.f2526a.transform(matrix);
        this.d.setAlpha((int) (sqVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f2526a, this.d);
    }

    public final void k(Canvas canvas, Matrix matrix, sq<z65, Path> sqVar, sq<Integer, Integer> sqVar2) {
        r86.m(canvas, this.i, this.e);
        this.f2526a.set(sqVar.h());
        this.f2526a.transform(matrix);
        this.d.setAlpha((int) (sqVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f2526a, this.d);
        canvas.restore();
    }

    public final void l(Canvas canvas, Matrix matrix, sq<z65, Path> sqVar, sq<Integer, Integer> sqVar2) {
        r86.m(canvas, this.i, this.d);
        canvas.drawRect(this.i, this.d);
        this.f2526a.set(sqVar.h());
        this.f2526a.transform(matrix);
        this.d.setAlpha((int) (sqVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f2526a, this.f);
        canvas.restore();
    }

    public final void m(Canvas canvas, Matrix matrix, sq<z65, Path> sqVar, sq<Integer, Integer> sqVar2) {
        r86.m(canvas, this.i, this.e);
        canvas.drawRect(this.i, this.d);
        this.f.setAlpha((int) (sqVar2.h().intValue() * 2.55f));
        this.f2526a.set(sqVar.h());
        this.f2526a.transform(matrix);
        canvas.drawPath(this.f2526a, this.f);
        canvas.restore();
    }

    public final void n(Canvas canvas, Matrix matrix, sq<z65, Path> sqVar, sq<Integer, Integer> sqVar2) {
        r86.m(canvas, this.i, this.f);
        canvas.drawRect(this.i, this.d);
        this.f.setAlpha((int) (sqVar2.h().intValue() * 2.55f));
        this.f2526a.set(sqVar.h());
        this.f2526a.transform(matrix);
        canvas.drawPath(this.f2526a, this.f);
        canvas.restore();
    }

    public final void o(Canvas canvas, Matrix matrix) {
        m03.a("Layer#saveLayer");
        r86.n(canvas, this.i, this.e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        m03.b("Layer#saveLayer");
        for (int i = 0; i < this.r.b().size(); i++) {
            Mask mask = this.r.b().get(i);
            sq<z65, Path> sqVar = this.r.a().get(i);
            sq<Integer, Integer> sqVar2 = this.r.c().get(i);
            int i2 = C0048a.b[mask.a().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.d.setColor(-16777216);
                        this.d.setAlpha(255);
                        canvas.drawRect(this.i, this.d);
                    }
                    if (mask.d()) {
                        n(canvas, matrix, sqVar, sqVar2);
                    } else {
                        p(canvas, matrix, sqVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (mask.d()) {
                            l(canvas, matrix, sqVar, sqVar2);
                        } else {
                            j(canvas, matrix, sqVar, sqVar2);
                        }
                    }
                } else if (mask.d()) {
                    m(canvas, matrix, sqVar, sqVar2);
                } else {
                    k(canvas, matrix, sqVar, sqVar2);
                }
            } else if (q()) {
                this.d.setAlpha(255);
                canvas.drawRect(this.i, this.d);
            }
        }
        m03.a("Layer#restoreLayer");
        canvas.restore();
        m03.b("Layer#restoreLayer");
    }

    public final void p(Canvas canvas, Matrix matrix, sq<z65, Path> sqVar) {
        this.f2526a.set(sqVar.h());
        this.f2526a.transform(matrix);
        canvas.drawPath(this.f2526a, this.f);
    }

    public final boolean q() {
        if (this.r.a().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.r.b().size(); i++) {
            if (this.r.b().get(i).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    public final void r() {
        if (this.v != null) {
            return;
        }
        if (this.u == null) {
            this.v = Collections.emptyList();
            return;
        }
        this.v = new ArrayList();
        for (a aVar = this.u; aVar != null; aVar = aVar.u) {
            this.v.add(aVar);
        }
    }

    public final void s(Canvas canvas) {
        m03.a("Layer#clearLayer");
        RectF rectF = this.i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.h);
        m03.b("Layer#clearLayer");
    }

    public abstract void t(Canvas canvas, Matrix matrix, int i);

    @Nullable
    public eu v() {
        return this.q.a();
    }

    public BlurMaskFilter w(float f) {
        if (this.B == f) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f;
        return blurMaskFilter;
    }

    @Nullable
    public ii1 x() {
        return this.q.c();
    }

    public Layer y() {
        return this.q;
    }

    public boolean z() {
        hd3 hd3Var = this.r;
        return (hd3Var == null || hd3Var.a().isEmpty()) ? false : true;
    }

    @Override // defpackage.ko0
    public void f(List<ko0> list, List<ko0> list2) {
    }

    public void H(b03 b03Var, int i, List<b03> list, b03 b03Var2) {
    }
}
