package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import defpackage.tp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class o23 extends s23 {
    public q23 i;
    public Paint j;
    public WeakReference<Bitmap> k;
    public Canvas l;
    public Bitmap.Config m;
    public Path n;
    public Path o;
    public float[] p;
    public Path q;
    public HashMap<kl2, b> r;
    public float[] s;

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19667a;

        static {
            int[] iArr = new int[LineDataSet.Mode.values().length];
            f19667a = iArr;
            try {
                iArr[LineDataSet.Mode.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19667a[LineDataSet.Mode.STEPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19667a[LineDataSet.Mode.CUBIC_BEZIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19667a[LineDataSet.Mode.HORIZONTAL_BEZIER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public o23(q23 q23Var, g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.m = Bitmap.Config.ARGB_8888;
        this.n = new Path();
        this.o = new Path();
        this.p = new float[4];
        this.q = new Path();
        this.r = new HashMap<>();
        this.s = new float[2];
        this.i = q23Var;
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.j.setColor(-1);
    }

    @Override // defpackage.su0
    public void b(Canvas canvas) {
        int iN = (int) this.f20113a.n();
        int iM = (int) this.f20113a.m();
        WeakReference<Bitmap> weakReference = this.k;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != iN || bitmapCreateBitmap.getHeight() != iM) {
            if (iN <= 0 || iM <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iN, iM, this.m);
            this.k = new WeakReference<>(bitmapCreateBitmap);
            this.l = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (T t : this.i.getLineData().h()) {
            if (t.isVisible()) {
                q(canvas, t);
            }
        }
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, this.c);
    }

    @Override // defpackage.su0
    public void c(Canvas canvas) {
        n(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.github.mikephil.charting.data.Entry, fq] */
    @Override // defpackage.su0
    public void d(Canvas canvas, vh2[] vh2VarArr) {
        p23 lineData = this.i.getLineData();
        for (vh2 vh2Var : vh2VarArr) {
            hm2 hm2Var = (hm2) lineData.e(vh2Var.d());
            if (hm2Var != null && hm2Var.O()) {
                ?? O0 = hm2Var.o0(vh2Var.h(), vh2Var.j());
                if (h(O0, hm2Var)) {
                    ub3 ub3VarE = this.i.getTransformer(hm2Var.i0()).e(O0.getX(), O0.getY() * this.b.i());
                    vh2Var.m((float) ub3VarE.c, (float) ub3VarE.d);
                    j(canvas, (float) ub3VarE.c, (float) ub3VarE.d, hm2Var);
                }
            }
        }
    }

    @Override // defpackage.su0
    public void e(Canvas canvas) {
        int i;
        hm2 hm2Var;
        Entry entry;
        if (g(this.i)) {
            List<T> listH = this.i.getLineData().h();
            for (int i2 = 0; i2 < listH.size(); i2++) {
                hm2 hm2Var2 = (hm2) listH.get(i2);
                if (i(hm2Var2) && hm2Var2.K0() >= 1) {
                    a(hm2Var2);
                    h16 transformer = this.i.getTransformer(hm2Var2.i0());
                    int iV0 = (int) (hm2Var2.v0() * 1.75f);
                    if (!hm2Var2.N()) {
                        iV0 /= 2;
                    }
                    int i3 = iV0;
                    this.g.a(this.i, hm2Var2);
                    float fH = this.b.h();
                    float fI = this.b.i();
                    tp.a aVar = this.g;
                    float[] fArrC = transformer.c(hm2Var2, fH, fI, aVar.f21030a, aVar.b);
                    h96 h96VarZ = hm2Var2.Z();
                    vb3 vb3VarD = vb3.d(hm2Var2.L0());
                    vb3VarD.c = s86.e(vb3VarD.c);
                    vb3VarD.d = s86.e(vb3VarD.d);
                    int i4 = 0;
                    while (i4 < fArrC.length) {
                        float f = fArrC[i4];
                        float f2 = fArrC[i4 + 1];
                        if (!this.f20113a.C(f)) {
                            break;
                        }
                        if (this.f20113a.B(f) && this.f20113a.F(f2)) {
                            int i5 = i4 / 2;
                            Entry entryH = hm2Var2.h(this.g.f21030a + i5);
                            if (hm2Var2.h0()) {
                                entry = entryH;
                                i = i3;
                                hm2Var = hm2Var2;
                                u(canvas, h96VarZ.h(entryH), f, f2 - i3, hm2Var2.l(i5));
                            } else {
                                entry = entryH;
                                i = i3;
                                hm2Var = hm2Var2;
                            }
                            if (entry.getIcon() != null && hm2Var.B()) {
                                Drawable icon = entry.getIcon();
                                s86.f(canvas, icon, (int) (f + vb3VarD.c), (int) (f2 + vb3VarD.d), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            }
                        } else {
                            i = i3;
                            hm2Var = hm2Var2;
                        }
                        i4 += 2;
                        hm2Var2 = hm2Var;
                        i3 = i;
                    }
                    vb3.f(vb3VarD);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [com.github.mikephil.charting.data.Entry, fq] */
    public void n(Canvas canvas) {
        b bVar;
        Bitmap bitmapB;
        this.c.setStyle(Paint.Style.FILL);
        float fI = this.b.i();
        float[] fArr = this.s;
        char c = 0;
        float f = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        List<T> listH = this.i.getLineData().h();
        int i = 0;
        while (i < listH.size()) {
            hm2 hm2Var = (hm2) listH.get(i);
            if (hm2Var.isVisible() && hm2Var.N() && hm2Var.K0() != 0) {
                this.j.setColor(hm2Var.e());
                h16 transformer = this.i.getTransformer(hm2Var.i0());
                this.g.a(this.i, hm2Var);
                float fV0 = hm2Var.v0();
                float fP = hm2Var.P();
                boolean z = hm2Var.O0() && fP < fV0 && fP > f;
                boolean z2 = z && hm2Var.e() == 1122867;
                a aVar = null;
                if (this.r.containsKey(hm2Var)) {
                    bVar = this.r.get(hm2Var);
                } else {
                    bVar = new b(this, aVar);
                    this.r.put(hm2Var, bVar);
                }
                if (bVar.c(hm2Var)) {
                    bVar.a(hm2Var, z, z2);
                }
                tp.a aVar2 = this.g;
                int i2 = aVar2.c;
                int i3 = aVar2.f21030a;
                int i4 = i2 + i3;
                while (i3 <= i4) {
                    ?? H = hm2Var.h(i3);
                    if (H == 0) {
                        break;
                    }
                    this.s[c] = H.getX();
                    this.s[1] = H.getY() * fI;
                    transformer.k(this.s);
                    if (!this.f20113a.C(this.s[c])) {
                        break;
                    }
                    if (this.f20113a.B(this.s[c]) && this.f20113a.F(this.s[1]) && (bitmapB = bVar.b(i3)) != null) {
                        float[] fArr2 = this.s;
                        canvas.drawBitmap(bitmapB, fArr2[c] - fV0, fArr2[1] - fV0, (Paint) null);
                    }
                    i3++;
                    c = 0;
                }
            }
            i++;
            c = 0;
            f = 0.0f;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r4v5 */
    public void o(hm2 hm2Var) {
        float fI = this.b.i();
        h16 transformer = this.i.getTransformer(hm2Var.i0());
        this.g.a(this.i, hm2Var);
        float fY = hm2Var.Y();
        this.n.reset();
        tp.a aVar = this.g;
        if (aVar.c >= 1) {
            int i = aVar.f21030a + 1;
            Object objH = hm2Var.h(Math.max(i - 2, 0));
            ?? H = hm2Var.h(Math.max(i - 1, 0));
            if (H != 0) {
                this.n.moveTo(H.getX(), H.getY() * fI);
                ?? r4 = H;
                int i2 = this.g.f21030a + 1;
                int i3 = -1;
                ?? r2 = H;
                ?? r3 = objH;
                while (true) {
                    tp.a aVar2 = this.g;
                    ?? H2 = r2;
                    if (i2 > aVar2.c + aVar2.f21030a) {
                        break;
                    }
                    if (i3 != i2) {
                        H2 = hm2Var.h(i2);
                    }
                    int i4 = i2 + 1;
                    if (i4 < hm2Var.K0()) {
                        i2 = i4;
                    }
                    ?? H3 = hm2Var.h(i2);
                    this.n.cubicTo(r4.getX() + ((H2.getX() - r3.getX()) * fY), (r4.getY() + ((H2.getY() - r3.getY()) * fY)) * fI, H2.getX() - ((H3.getX() - r4.getX()) * fY), (H2.getY() - ((H3.getY() - r4.getY()) * fY)) * fI, H2.getX(), H2.getY() * fI);
                    r3 = r4;
                    r4 = H2;
                    r2 = H3;
                    int i5 = i2;
                    i2 = i4;
                    i3 = i5;
                }
            } else {
                return;
            }
        }
        if (hm2Var.w0()) {
            this.o.reset();
            this.o.addPath(this.n);
            p(this.l, hm2Var, this.o, transformer, this.g);
        }
        this.c.setColor(hm2Var.getColor());
        this.c.setStyle(Paint.Style.STROKE);
        transformer.i(this.n);
        this.l.drawPath(this.n, this.c);
        this.c.setPathEffect(null);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r8v2, types: [com.github.mikephil.charting.data.Entry] */
    public void p(Canvas canvas, hm2 hm2Var, Path path, h16 h16Var, tp.a aVar) {
        float fA = hm2Var.z().a(hm2Var, this.i);
        path.lineTo(hm2Var.h(aVar.f21030a + aVar.c).getX(), fA);
        path.lineTo(hm2Var.h(aVar.f21030a).getX(), fA);
        path.close();
        h16Var.i(path);
        Drawable drawableF = hm2Var.f();
        if (drawableF != null) {
            m(canvas, path, drawableF);
        } else {
            l(canvas, path, hm2Var.getFillColor(), hm2Var.R());
        }
    }

    public void q(Canvas canvas, hm2 hm2Var) {
        if (hm2Var.K0() < 1) {
            return;
        }
        this.c.setStrokeWidth(hm2Var.U());
        this.c.setPathEffect(hm2Var.D());
        int i = a.f19667a[hm2Var.y0().ordinal()];
        if (i == 3) {
            o(hm2Var);
        } else if (i != 4) {
            s(canvas, hm2Var);
        } else {
            r(hm2Var);
        }
        this.c.setPathEffect(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.github.mikephil.charting.data.Entry, fq] */
    public void r(hm2 hm2Var) {
        float fI = this.b.i();
        h16 transformer = this.i.getTransformer(hm2Var.i0());
        this.g.a(this.i, hm2Var);
        this.n.reset();
        tp.a aVar = this.g;
        if (aVar.c >= 1) {
            ?? H = hm2Var.h(aVar.f21030a);
            this.n.moveTo(H.getX(), H.getY() * fI);
            int i = this.g.f21030a + 1;
            ?? r2 = H;
            while (true) {
                tp.a aVar2 = this.g;
                if (i > aVar2.c + aVar2.f21030a) {
                    break;
                }
                ?? H2 = hm2Var.h(i);
                float x = r2.getX() + ((H2.getX() - r2.getX()) / 2.0f);
                this.n.cubicTo(x, r2.getY() * fI, x, H2.getY() * fI, H2.getX(), H2.getY() * fI);
                i++;
                r2 = H2;
            }
        }
        if (hm2Var.w0()) {
            this.o.reset();
            this.o.addPath(this.n);
            p(this.l, hm2Var, this.o, transformer, this.g);
        }
        this.c.setColor(hm2Var.getColor());
        this.c.setStyle(Paint.Style.STROKE);
        transformer.i(this.n);
        this.l.drawPath(this.n, this.c);
        this.c.setPathEffect(null);
    }

    /* JADX WARN: Type inference failed for: r12v11, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r13v5, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r8v22, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.github.mikephil.charting.data.Entry, fq] */
    public void s(Canvas canvas, hm2 hm2Var) {
        int iK0 = hm2Var.K0();
        boolean z = hm2Var.y0() == LineDataSet.Mode.STEPPED;
        int i = z ? 4 : 2;
        h16 transformer = this.i.getTransformer(hm2Var.i0());
        float fI = this.b.i();
        this.c.setStyle(Paint.Style.STROKE);
        Canvas canvas2 = hm2Var.c() ? this.l : canvas;
        this.g.a(this.i, hm2Var);
        if (hm2Var.w0() && iK0 > 0) {
            t(canvas, hm2Var, transformer, this.g);
        }
        if (hm2Var.e0().size() > 1) {
            int i2 = i * 2;
            if (this.p.length <= i2) {
                this.p = new float[i * 4];
            }
            int i3 = this.g.f21030a;
            while (true) {
                tp.a aVar = this.g;
                if (i3 > aVar.c + aVar.f21030a) {
                    break;
                }
                ?? H = hm2Var.h(i3);
                if (H != 0) {
                    this.p[0] = H.getX();
                    this.p[1] = H.getY() * fI;
                    if (i3 < this.g.b) {
                        ?? H2 = hm2Var.h(i3 + 1);
                        if (H2 == 0) {
                            break;
                        }
                        if (z) {
                            this.p[2] = H2.getX();
                            float[] fArr = this.p;
                            float f = fArr[1];
                            fArr[3] = f;
                            fArr[4] = fArr[2];
                            fArr[5] = f;
                            fArr[6] = H2.getX();
                            this.p[7] = H2.getY() * fI;
                        } else {
                            this.p[2] = H2.getX();
                            this.p[3] = H2.getY() * fI;
                        }
                    } else {
                        float[] fArr2 = this.p;
                        fArr2[2] = fArr2[0];
                        fArr2[3] = fArr2[1];
                    }
                    transformer.k(this.p);
                    if (!this.f20113a.C(this.p[0])) {
                        break;
                    }
                    if (this.f20113a.B(this.p[2]) && (this.f20113a.D(this.p[1]) || this.f20113a.A(this.p[3]))) {
                        this.c.setColor(hm2Var.z0(i3));
                        canvas2.drawLines(this.p, 0, i2, this.c);
                    }
                }
                i3++;
            }
        } else {
            int i4 = iK0 * i;
            if (this.p.length < Math.max(i4, i) * 2) {
                this.p = new float[Math.max(i4, i) * 4];
            }
            if (hm2Var.h(this.g.f21030a) != 0) {
                int i5 = this.g.f21030a;
                int i6 = 0;
                while (true) {
                    tp.a aVar2 = this.g;
                    if (i5 > aVar2.c + aVar2.f21030a) {
                        break;
                    }
                    ?? H3 = hm2Var.h(i5 == 0 ? 0 : i5 - 1);
                    ?? H4 = hm2Var.h(i5);
                    if (H3 != 0 && H4 != 0) {
                        int i7 = i6 + 1;
                        this.p[i6] = H3.getX();
                        int i8 = i7 + 1;
                        this.p[i7] = H3.getY() * fI;
                        if (z) {
                            int i9 = i8 + 1;
                            this.p[i8] = H4.getX();
                            int i10 = i9 + 1;
                            this.p[i9] = H3.getY() * fI;
                            int i11 = i10 + 1;
                            this.p[i10] = H4.getX();
                            i8 = i11 + 1;
                            this.p[i11] = H3.getY() * fI;
                        }
                        int i12 = i8 + 1;
                        this.p[i8] = H4.getX();
                        this.p[i12] = H4.getY() * fI;
                        i6 = i12 + 1;
                    }
                    i5++;
                }
                if (i6 > 0) {
                    transformer.k(this.p);
                    int iMax = Math.max((this.g.c + 1) * i, i) * 2;
                    this.c.setColor(hm2Var.getColor());
                    canvas2.drawLines(this.p, 0, iMax, this.c);
                }
            }
        }
        this.c.setPathEffect(null);
    }

    public void t(Canvas canvas, hm2 hm2Var, h16 h16Var, tp.a aVar) {
        int i;
        int i2;
        Path path = this.q;
        int i3 = aVar.f21030a;
        int i4 = aVar.c + i3;
        int i5 = 0;
        do {
            i = (i5 * 128) + i3;
            i2 = i + 128;
            if (i2 > i4) {
                i2 = i4;
            }
            if (i <= i2) {
                v(hm2Var, i, i2, path);
                h16Var.i(path);
                Drawable drawableF = hm2Var.f();
                if (drawableF != null) {
                    m(canvas, path, drawableF);
                } else {
                    l(canvas, path, hm2Var.getFillColor(), hm2Var.R());
                }
            }
            i5++;
        } while (i <= i2);
    }

    public void u(Canvas canvas, String str, float f, float f2, int i) {
        this.f.setColor(i);
        canvas.drawText(str, f, f2, this.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r3v2, types: [fq] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.github.mikephil.charting.data.Entry] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.github.mikephil.charting.data.Entry, fq] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final void v(hm2 hm2Var, int i, int i2, Path path) {
        float fA = hm2Var.z().a(hm2Var, this.i);
        float fI = this.b.i();
        boolean z = hm2Var.y0() == LineDataSet.Mode.STEPPED;
        path.reset();
        ?? H = hm2Var.h(i);
        path.moveTo(H.getX(), fA);
        path.lineTo(H.getX(), H.getY() * fI);
        int i3 = i + 1;
        ?? r4 = 0;
        ?? r3 = H;
        while (i3 <= i2) {
            ?? H2 = hm2Var.h(i3);
            if (z) {
                path.lineTo(H2.getX(), r3.getY() * fI);
            }
            path.lineTo(H2.getX(), H2.getY() * fI);
            i3++;
            r3 = H2;
            r4 = H2;
        }
        if (r4 != 0) {
            path.lineTo(r4.getX(), fA);
        }
        path.close();
    }

    public void w() {
        Canvas canvas = this.l;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.l = null;
        }
        WeakReference<Bitmap> weakReference = this.k;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.k.clear();
            this.k = null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Path f19668a;
        public Bitmap[] b;

        public b() {
            this.f19668a = new Path();
        }

        public void a(hm2 hm2Var, boolean z, boolean z2) {
            int iW = hm2Var.w();
            float fV0 = hm2Var.v0();
            float fP = hm2Var.P();
            for (int i = 0; i < iW; i++) {
                int i2 = (int) (((double) fV0) * 2.1d);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                this.b[i] = bitmapCreateBitmap;
                o23.this.c.setColor(hm2Var.M(i));
                if (z2) {
                    this.f19668a.reset();
                    this.f19668a.addCircle(fV0, fV0, fV0, Path.Direction.CW);
                    this.f19668a.addCircle(fV0, fV0, fP, Path.Direction.CCW);
                    canvas.drawPath(this.f19668a, o23.this.c);
                } else {
                    canvas.drawCircle(fV0, fV0, fV0, o23.this.c);
                    if (z) {
                        canvas.drawCircle(fV0, fV0, fP, o23.this.j);
                    }
                }
            }
        }

        public Bitmap b(int i) {
            Bitmap[] bitmapArr = this.b;
            return bitmapArr[i % bitmapArr.length];
        }

        public boolean c(hm2 hm2Var) {
            int iW = hm2Var.w();
            Bitmap[] bitmapArr = this.b;
            if (bitmapArr == null) {
                this.b = new Bitmap[iW];
                return true;
            }
            if (bitmapArr.length == iW) {
                return false;
            }
            this.b = new Bitmap[iW];
            return true;
        }

        public /* synthetic */ b(o23 o23Var, a aVar) {
            this();
        }
    }

    @Override // defpackage.su0
    public void f() {
    }
}
