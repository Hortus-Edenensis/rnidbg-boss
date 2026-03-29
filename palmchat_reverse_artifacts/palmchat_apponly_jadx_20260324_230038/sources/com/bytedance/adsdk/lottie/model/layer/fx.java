package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mapapi.map.WeightedLatLng;
import com.bytedance.adsdk.lottie.a;
import com.bytedance.adsdk.lottie.model.layer.n;
import com.bytedance.adsdk.lottie.model.nr.n;
import com.bytedance.adsdk.lottie.u.nr.my;
import com.bytedance.adsdk.lottie.u.nr.u;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class fx implements u.InterfaceC0166u, com.bytedance.adsdk.lottie.u.u.pn {
    final my b;
    private final Matrix bf;
    private final RectF bg;
    private final RectF bq;
    private final String c;
    private final List<com.bytedance.adsdk.lottie.u.nr.u<?, ?>> d;
    private final RectF dw;
    final n fx;
    private List<fx> gi;
    private boolean h;
    BlurMaskFilter iz;
    private Paint ja;
    private final Paint k;
    private fx kj;
    private final Paint my;
    private boolean n;
    final com.bytedance.adsdk.lottie.n nr;
    private final RectF o;
    float pn;
    private com.bytedance.adsdk.lottie.u.nr.n q;
    private com.bytedance.adsdk.lottie.u.nr.b qq;
    private boolean rh;
    private final RectF sx;
    final Matrix u;
    private float wq;
    private fx z;
    private final Handler x = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f4985a = new Path();
    private final Matrix jk = new Matrix();
    private final Matrix t = new Matrix();
    private final Paint l = new com.bytedance.adsdk.lottie.u.u(1);
    private final Paint mv = new com.bytedance.adsdk.lottie.u.u(1, PorterDuff.Mode.DST_IN);
    private final Paint s = new com.bytedance.adsdk.lottie.u.u(1, PorterDuff.Mode.DST_OUT);

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.layer.fx$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] nr;
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[n.u.values().length];
            nr = iArr;
            try {
                iArr[n.u.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                nr[n.u.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                nr[n.u.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                nr[n.u.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[n.u.values().length];
            u = iArr2;
            try {
                iArr2[n.u.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                u[n.u.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                u[n.u.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                u[n.u.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                u[n.u.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                u[n.u.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                u[n.u.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public fx(com.bytedance.adsdk.lottie.n nVar, n nVar2) {
        com.bytedance.adsdk.lottie.u.u uVar = new com.bytedance.adsdk.lottie.u.u(1);
        this.k = uVar;
        this.my = new com.bytedance.adsdk.lottie.u.u(PorterDuff.Mode.CLEAR);
        this.o = new RectF();
        this.sx = new RectF();
        this.bg = new RectF();
        this.bq = new RectF();
        this.dw = new RectF();
        this.u = new Matrix();
        this.d = new ArrayList();
        this.h = true;
        this.pn = 0.0f;
        this.bf = new Matrix();
        this.wq = 1.0f;
        this.nr = nVar;
        this.fx = nVar2;
        this.c = nVar2.iz() + "#draw";
        if (nVar2.l() == n.nr.INVERT) {
            uVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            uVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        my myVarJk = nVar2.k().jk();
        this.b = myVarJk;
        myVarJk.u((u.InterfaceC0166u) this);
        if (nVar2.jk() != null && !nVar2.jk().isEmpty()) {
            com.bytedance.adsdk.lottie.u.nr.n nVar3 = new com.bytedance.adsdk.lottie.u.nr.n(nVar2.jk());
            this.q = nVar3;
            Iterator<com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.s, Path>> it = nVar3.nr().iterator();
            while (it.hasNext()) {
                it.next().u(this);
            }
            for (com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar2 : this.q.fx()) {
                u(uVar2);
                uVar2.u(this);
            }
        }
        s();
    }

    private void k() {
        this.nr.invalidateSelf();
    }

    private boolean my() {
        if (this.q.nr().isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.q.u().size(); i++) {
            if (this.q.u().get(i).u() != n.u.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void o() {
        if (this.gi != null) {
            return;
        }
        if (this.z == null) {
            this.gi = Collections.emptyList();
            return;
        }
        this.gi = new ArrayList();
        for (fx fxVar = this.z; fxVar != null; fxVar = fxVar.z) {
            this.gi.add(fxVar);
        }
    }

    private void s() {
        if (this.fx.b().isEmpty()) {
            nr(true);
            return;
        }
        com.bytedance.adsdk.lottie.u.nr.b bVar = new com.bytedance.adsdk.lottie.u.nr.b(this.fx.b());
        this.qq = bVar;
        bVar.u();
        this.qq.u(new u.InterfaceC0166u() { // from class: com.bytedance.adsdk.lottie.model.layer.fx.1
            @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
            public void u() {
                fx fxVar = fx.this;
                fxVar.nr(fxVar.qq.a() == 1.0f);
            }
        });
        nr(this.qq.x().floatValue() == 1.0f);
        u(this.qq);
    }

    public boolean a() {
        com.bytedance.adsdk.lottie.u.nr.n nVar = this.q;
        return (nVar == null || nVar.nr().isEmpty()) ? false : true;
    }

    public n b() {
        return this.fx;
    }

    public Matrix iz() {
        return this.bf;
    }

    public boolean jk() {
        return this.h;
    }

    public com.bytedance.adsdk.lottie.model.nr.u l() {
        return this.fx.q();
    }

    public com.bytedance.adsdk.lottie.b.jk mv() {
        return this.fx.qq();
    }

    public float n() {
        return this.wq;
    }

    public boolean nr() {
        return this.n;
    }

    public boolean pn() {
        return this.kj != null;
    }

    public String t() {
        return this.fx.iz();
    }

    @Override // com.bytedance.adsdk.lottie.u.u.fx
    public void u(List<com.bytedance.adsdk.lottie.u.u.fx> list, List<com.bytedance.adsdk.lottie.u.u.fx> list2) {
    }

    public String x() {
        n nVar = this.fx;
        if (nVar != null) {
            return nVar.x();
        }
        return null;
    }

    private void b(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.s, Path> uVar, com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar2) {
        com.bytedance.adsdk.lottie.pn.a.u(canvas, this.o, this.mv);
        this.f4985a.set(uVar.x());
        this.f4985a.transform(matrix);
        this.l.setAlpha((int) (uVar2.x().intValue() * 2.55f));
        canvas.drawPath(this.f4985a, this.l);
        canvas.restore();
    }

    private void pn(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.s, Path> uVar, com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar2) {
        com.bytedance.adsdk.lottie.pn.a.u(canvas, this.o, this.mv);
        canvas.drawRect(this.o, this.l);
        this.s.setAlpha((int) (uVar2.x().intValue() * 2.55f));
        this.f4985a.set(uVar.x());
        this.f4985a.transform(matrix);
        canvas.drawPath(this.f4985a, this.s);
        canvas.restore();
    }

    public void fx() {
        this.n = true;
    }

    public void nr(fx fxVar) {
        this.z = fxVar;
    }

    private void fx(float f) {
        this.nr.gi().fx().u(this.fx.iz(), f);
    }

    private void nr(RectF rectF, Matrix matrix) {
        if (pn() && this.fx.l() != n.nr.INVERT) {
            this.bq.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.kj.u(this.bq, matrix, true);
            if (rectF.intersect(this.bq)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void u(Runnable runnable) {
        this.x.post(runnable);
    }

    public static fx u(b bVar, n nVar, com.bytedance.adsdk.lottie.n nVar2, com.bytedance.adsdk.lottie.iz izVar, Context context) {
        switch (AnonymousClass2.u[nVar.t().ordinal()]) {
            case 1:
                return new jk(nVar2, nVar, bVar, izVar);
            case 2:
                return new b(nVar2, nVar, izVar.nr(nVar.x()), izVar, context);
            case 3:
                return new t(nVar2, nVar);
            case 4:
                if (u(nVar2, nVar, "text:")) {
                    return new iz(nVar2, nVar, context);
                }
                if (u(nVar2, nVar, "videoview:")) {
                    a.u uVarU = u(nVar2, nVar);
                    if (uVarU != null) {
                        a.u.C0163u c0163u = uVarU.u;
                        if (c0163u != null && c0163u.u > 0.0f) {
                            return new pn(nVar2, nVar, context, c0163u);
                        }
                        if (uVarU.nr) {
                            return new nr(nVar2, nVar, context);
                        }
                        return new s(nVar2, nVar, context);
                    }
                    return new s(nVar2, nVar, context);
                }
                if (u(nVar2, nVar, "animview:")) {
                    return new u(nVar2, nVar, context);
                }
                if (u(nVar2, nVar, "view:")) {
                    return new mv(nVar2, nVar, context);
                }
                return new x(nVar2, nVar);
            case 5:
                return new a(nVar2, nVar);
            case 6:
                return new l(nVar2, nVar);
            default:
                com.bytedance.adsdk.lottie.pn.pn.nr("Unknown layer type " + nVar.t());
                return null;
        }
    }

    private void fx(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.s, Path> uVar, com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar2) {
        com.bytedance.adsdk.lottie.pn.a.u(canvas, this.o, this.s);
        canvas.drawRect(this.o, this.l);
        this.s.setAlpha((int) (uVar2.x().intValue() * 2.55f));
        this.f4985a.set(uVar.x());
        this.f4985a.transform(matrix);
        canvas.drawPath(this.f4985a, this.s);
        canvas.restore();
    }

    public void nr(Canvas canvas, Matrix matrix, int i) {
        u(i);
    }

    private void nr(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.s, Path> uVar, com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar2) {
        com.bytedance.adsdk.lottie.pn.a.u(canvas, this.o, this.l);
        canvas.drawRect(this.o, this.l);
        this.f4985a.set(uVar.x());
        this.f4985a.transform(matrix);
        this.l.setAlpha((int) (uVar2.x().intValue() * 2.55f));
        canvas.drawPath(this.f4985a, this.s);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(boolean z) {
        if (z != this.h) {
            this.h = z;
            k();
        }
    }

    public BlurMaskFilter nr(float f) {
        if (this.pn == f) {
            return this.iz;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.iz = blurMaskFilter;
        this.pn = f;
        return blurMaskFilter;
    }

    private static a.u u(com.bytedance.adsdk.lottie.n nVar, n nVar2) {
        com.bytedance.adsdk.lottie.a aVarIz;
        if (nVar == null || nVar2 == null || (aVarIz = nVar.iz(nVar2.x())) == null) {
            return null;
        }
        return aVarIz.jk();
    }

    private static boolean u(com.bytedance.adsdk.lottie.n nVar, n nVar2, String str) {
        com.bytedance.adsdk.lottie.a aVarIz;
        if (nVar == null || nVar2 == null || str == null || (aVarIz = nVar.iz(nVar2.x())) == null) {
            return false;
        }
        return str.equals(aVarIz.s());
    }

    public void u(boolean z) {
        if (z && this.ja == null) {
            this.ja = new com.bytedance.adsdk.lottie.u.u();
        }
        this.rh = z;
    }

    @Override // com.bytedance.adsdk.lottie.u.nr.u.InterfaceC0166u
    public void u() {
        k();
    }

    public void u(fx fxVar) {
        this.kj = fxVar;
    }

    public void u(com.bytedance.adsdk.lottie.u.nr.u<?, ?> uVar) {
        if (uVar == null) {
            return;
        }
        this.d.add(uVar);
    }

    public void u(RectF rectF, Matrix matrix, boolean z) {
        this.o.set(0.0f, 0.0f, 0.0f, 0.0f);
        o();
        this.u.set(matrix);
        if (z) {
            List<fx> list = this.gi;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.u.preConcat(this.gi.get(size).b.b());
                }
            } else {
                fx fxVar = this.z;
                if (fxVar != null) {
                    this.u.preConcat(fxVar.b.b());
                }
            }
        }
        this.u.preConcat(this.b.b());
    }

    @Override // com.bytedance.adsdk.lottie.u.u.pn
    public void u(Canvas canvas, Matrix matrix, int i) {
        Paint paint;
        Integer numX;
        com.bytedance.adsdk.lottie.pn.u(this.c);
        if (this.h && !this.fx.c()) {
            o();
            com.bytedance.adsdk.lottie.pn.u("Layer#parentMatrix");
            this.bf.set(matrix);
            this.jk.reset();
            this.jk.set(matrix);
            for (int size = this.gi.size() - 1; size >= 0; size--) {
                this.jk.preConcat(this.gi.get(size).b.b());
            }
            com.bytedance.adsdk.lottie.pn.nr("Layer#parentMatrix");
            com.bytedance.adsdk.lottie.u.nr.u<?, Integer> uVarU = this.b.u();
            int iIntValue = (int) ((((i / 255.0f) * ((uVarU == null || (numX = uVarU.x()) == null) ? 100 : numX.intValue())) / 100.0f) * 255.0f);
            if (!pn() && !a()) {
                this.jk.preConcat(this.b.b());
                com.bytedance.adsdk.lottie.pn.u("Layer#drawLayer");
                nr(canvas, this.jk, iIntValue);
                com.bytedance.adsdk.lottie.pn.nr("Layer#drawLayer");
                fx(com.bytedance.adsdk.lottie.pn.nr(this.c));
                return;
            }
            com.bytedance.adsdk.lottie.pn.u("Layer#computeBounds");
            u(this.o, this.jk, false);
            nr(this.o, matrix);
            this.jk.preConcat(this.b.b());
            u(this.o, this.jk);
            this.sx.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.t);
            if (!this.t.isIdentity()) {
                Matrix matrix2 = this.t;
                matrix2.invert(matrix2);
                this.t.mapRect(this.sx);
            }
            if (!this.o.intersect(this.sx)) {
                this.o.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.bytedance.adsdk.lottie.pn.nr("Layer#computeBounds");
            if (this.o.width() >= 1.0f && this.o.height() >= 1.0f) {
                com.bytedance.adsdk.lottie.pn.u("Layer#saveLayer");
                this.l.setAlpha(255);
                com.bytedance.adsdk.lottie.pn.a.u(canvas, this.o, this.l);
                com.bytedance.adsdk.lottie.pn.nr("Layer#saveLayer");
                u(canvas);
                com.bytedance.adsdk.lottie.pn.u("Layer#drawLayer");
                nr(canvas, this.jk, iIntValue);
                com.bytedance.adsdk.lottie.pn.nr("Layer#drawLayer");
                if (a()) {
                    u(canvas, this.jk);
                }
                if (pn()) {
                    com.bytedance.adsdk.lottie.pn.u("Layer#drawMatte");
                    com.bytedance.adsdk.lottie.pn.u("Layer#saveLayer");
                    com.bytedance.adsdk.lottie.pn.a.u(canvas, this.o, this.k, 19);
                    com.bytedance.adsdk.lottie.pn.nr("Layer#saveLayer");
                    u(canvas);
                    this.kj.u(canvas, matrix, iIntValue);
                    com.bytedance.adsdk.lottie.pn.u("Layer#restoreLayer");
                    canvas.restore();
                    com.bytedance.adsdk.lottie.pn.nr("Layer#restoreLayer");
                    com.bytedance.adsdk.lottie.pn.nr("Layer#drawMatte");
                }
                com.bytedance.adsdk.lottie.pn.u("Layer#restoreLayer");
                canvas.restore();
                com.bytedance.adsdk.lottie.pn.nr("Layer#restoreLayer");
            }
            if (this.rh && (paint = this.ja) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.ja.setColor(-251901);
                this.ja.setStrokeWidth(4.0f);
                canvas.drawRect(this.o, this.ja);
                this.ja.setStyle(Paint.Style.FILL);
                this.ja.setColor(1357638635);
                canvas.drawRect(this.o, this.ja);
            }
            fx(com.bytedance.adsdk.lottie.pn.nr(this.c));
            return;
        }
        com.bytedance.adsdk.lottie.pn.nr(this.c);
    }

    private void u(Canvas canvas) {
        com.bytedance.adsdk.lottie.pn.u("Layer#clearLayer");
        RectF rectF = this.o;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.my);
        com.bytedance.adsdk.lottie.pn.nr("Layer#clearLayer");
    }

    private void u(RectF rectF, Matrix matrix) {
        this.bg.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (a()) {
            int size = this.q.u().size();
            for (int i = 0; i < size; i++) {
                com.bytedance.adsdk.lottie.model.nr.n nVar = this.q.u().get(i);
                Path pathX = this.q.nr().get(i).x();
                if (pathX != null) {
                    this.f4985a.set(pathX);
                    this.f4985a.transform(matrix);
                    int i2 = AnonymousClass2.nr[nVar.u().ordinal()];
                    if (i2 == 1 || i2 == 2) {
                        return;
                    }
                    if ((i2 == 3 || i2 == 4) && nVar.b()) {
                        return;
                    }
                    this.f4985a.computeBounds(this.dw, false);
                    if (i == 0) {
                        this.bg.set(this.dw);
                    } else {
                        RectF rectF2 = this.bg;
                        rectF2.set(Math.min(rectF2.left, this.dw.left), Math.min(this.bg.top, this.dw.top), Math.max(this.bg.right, this.dw.right), Math.max(this.bg.bottom, this.dw.bottom));
                    }
                }
            }
            if (rectF.intersect(this.bg)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public void u(int i) {
        this.wq = ((this.b.u() != null ? this.b.u().x().intValue() : 100) / 100.0f) * (i / 255.0f);
    }

    private void u(Canvas canvas, Matrix matrix) {
        com.bytedance.adsdk.lottie.pn.u("Layer#saveLayer");
        com.bytedance.adsdk.lottie.pn.a.u(canvas, this.o, this.mv, 19);
        if (Build.VERSION.SDK_INT < 28) {
            u(canvas);
        }
        com.bytedance.adsdk.lottie.pn.nr("Layer#saveLayer");
        for (int i = 0; i < this.q.u().size(); i++) {
            com.bytedance.adsdk.lottie.model.nr.n nVar = this.q.u().get(i);
            com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.s, Path> uVar = this.q.nr().get(i);
            com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar2 = this.q.fx().get(i);
            int i2 = AnonymousClass2.nr[nVar.u().ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    if (i == 0) {
                        this.l.setColor(-16777216);
                        this.l.setAlpha(255);
                        canvas.drawRect(this.o, this.l);
                    }
                    if (nVar.b()) {
                        fx(canvas, matrix, uVar, uVar2);
                    } else {
                        u(canvas, matrix, uVar);
                    }
                } else if (i2 != 3) {
                    if (i2 == 4) {
                        if (nVar.b()) {
                            nr(canvas, matrix, uVar, uVar2);
                        } else {
                            u(canvas, matrix, uVar, uVar2);
                        }
                    }
                } else if (nVar.b()) {
                    pn(canvas, matrix, uVar, uVar2);
                } else {
                    b(canvas, matrix, uVar, uVar2);
                }
            } else if (my()) {
                this.l.setAlpha(255);
                canvas.drawRect(this.o, this.l);
            }
        }
        com.bytedance.adsdk.lottie.pn.u("Layer#restoreLayer");
        canvas.restore();
        com.bytedance.adsdk.lottie.pn.nr("Layer#restoreLayer");
    }

    private void u(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.s, Path> uVar, com.bytedance.adsdk.lottie.u.nr.u<Integer, Integer> uVar2) {
        this.f4985a.set(uVar.x());
        this.f4985a.transform(matrix);
        this.l.setAlpha((int) (uVar2.x().intValue() * 2.55f));
        canvas.drawPath(this.f4985a, this.l);
    }

    private void u(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.u.nr.u<com.bytedance.adsdk.lottie.model.nr.s, Path> uVar) {
        this.f4985a.set(uVar.x());
        this.f4985a.transform(matrix);
        canvas.drawPath(this.f4985a, this.s);
    }

    public void u(@FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY) float f) {
        this.b.u(f);
        if (this.q != null) {
            for (int i = 0; i < this.q.nr().size(); i++) {
                this.q.nr().get(i).u(f);
            }
        }
        com.bytedance.adsdk.lottie.u.nr.b bVar = this.qq;
        if (bVar != null) {
            bVar.u(f);
        }
        fx fxVar = this.kj;
        if (fxVar != null) {
            fxVar.u(f);
        }
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            this.d.get(i2).u(f);
        }
    }
}
