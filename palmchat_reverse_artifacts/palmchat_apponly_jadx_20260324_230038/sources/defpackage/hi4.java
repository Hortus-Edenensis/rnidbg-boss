package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieDataSet$ValuePosition;
import com.github.mikephil.charting.data.PieEntry;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class hi4 extends su0 {
    public PieChart g;
    public Paint h;
    public Paint i;
    public Paint j;
    public TextPaint k;
    public Paint l;
    public StaticLayout m;
    public CharSequence n;
    public RectF o;
    public RectF[] p;
    public WeakReference<Bitmap> q;
    public Canvas r;
    public Path s;
    public RectF t;
    public Path u;
    public Path v;
    public RectF w;

    public hi4(PieChart pieChart, g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.o = new RectF();
        this.p = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.s = new Path();
        this.t = new RectF();
        this.u = new Path();
        this.v = new Path();
        this.w = new RectF();
        this.g = pieChart;
        Paint paint = new Paint(1);
        this.h = paint;
        paint.setColor(-1);
        this.h.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.i = paint2;
        paint2.setColor(-1);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setAlpha(105);
        TextPaint textPaint = new TextPaint(1);
        this.k = textPaint;
        textPaint.setColor(-16777216);
        this.k.setTextSize(s86.e(12.0f));
        this.f.setTextSize(s86.e(13.0f));
        this.f.setColor(-1);
        this.f.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint(1);
        this.l = paint3;
        paint3.setColor(-1);
        this.l.setTextAlign(Paint.Align.CENTER);
        this.l.setTextSize(s86.e(13.0f));
        Paint paint4 = new Paint(1);
        this.j = paint4;
        paint4.setStyle(Paint.Style.STROKE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.su0
    public void b(Canvas canvas) {
        int iN = (int) this.f20113a.n();
        int iM = (int) this.f20113a.m();
        WeakReference<Bitmap> weakReference = this.q;
        Bitmap bitmapCreateBitmap = weakReference == null ? null : weakReference.get();
        if (bitmapCreateBitmap == null || bitmapCreateBitmap.getWidth() != iN || bitmapCreateBitmap.getHeight() != iM) {
            if (iN <= 0 || iM <= 0) {
                return;
            }
            bitmapCreateBitmap = Bitmap.createBitmap(iN, iM, Bitmap.Config.ARGB_4444);
            this.q = new WeakReference<>(bitmapCreateBitmap);
            this.r = new Canvas(bitmapCreateBitmap);
        }
        bitmapCreateBitmap.eraseColor(0);
        for (ao2 ao2Var : ((ii4) this.g.getData()).h()) {
            if (ao2Var.isVisible() && ao2Var.K0() > 0) {
                j(canvas, ao2Var);
            }
        }
    }

    @Override // defpackage.su0
    public void c(Canvas canvas) {
        l(canvas);
        canvas.drawBitmap(this.q.get(), 0.0f, 0.0f, (Paint) null);
        i(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.su0
    public void d(Canvas canvas, vh2[] vh2VarArr) {
        int i;
        RectF rectF;
        float f;
        float[] fArr;
        boolean z;
        float f2;
        float f3;
        vb3 vb3Var;
        ao2 ao2VarE;
        float f4;
        int i2;
        float[] fArr2;
        float f5;
        int i3;
        float fH;
        float fMax;
        vh2[] vh2VarArr2 = vh2VarArr;
        boolean z2 = this.g.isDrawHoleEnabled() && !this.g.isDrawSlicesUnderHoleEnabled();
        if (z2 && this.g.isDrawRoundedSlicesEnabled()) {
            return;
        }
        float fH2 = this.b.h();
        float fI = this.b.i();
        float rotationAngle = this.g.getRotationAngle();
        float[] drawAngles = this.g.getDrawAngles();
        float[] absoluteAngles = this.g.getAbsoluteAngles();
        vb3 centerCircleBox = this.g.getCenterCircleBox();
        float radius = this.g.getRadius();
        float holeRadius = z2 ? (this.g.getHoleRadius() / 100.0f) * radius : 0.0f;
        RectF rectF2 = this.w;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 0;
        while (i4 < vh2VarArr2.length) {
            int iH = (int) vh2VarArr2[i4].h();
            if (iH < drawAngles.length && (ao2VarE = ((ii4) this.g.getData()).e(vh2VarArr2[i4].d())) != null && ao2VarE.O()) {
                int iK0 = ao2VarE.K0();
                int i5 = 0;
                for (int i6 = 0; i6 < iK0; i6++) {
                    if (Math.abs(ao2VarE.h(i6).getY()) > s86.e) {
                        i5++;
                    }
                }
                if (iH == 0) {
                    i2 = 1;
                    f4 = 0.0f;
                } else {
                    f4 = absoluteAngles[iH - 1] * fH2;
                    i2 = 1;
                }
                float fL0 = i5 <= i2 ? 0.0f : ao2VarE.l0();
                float f6 = drawAngles[iH];
                float fR = ao2VarE.r();
                int i7 = i4;
                float f7 = radius + fR;
                float f8 = holeRadius;
                rectF2.set(this.g.getCircleBox());
                float f9 = -fR;
                rectF2.inset(f9, f9);
                boolean z3 = fL0 > 0.0f && f6 <= 180.0f;
                this.c.setColor(ao2VarE.z0(iH));
                float f10 = i5 == 1 ? 0.0f : fL0 / (radius * 0.017453292f);
                float f11 = i5 == 1 ? 0.0f : fL0 / (f7 * 0.017453292f);
                float f12 = rotationAngle + (((f10 / 2.0f) + f4) * fI);
                float f13 = (f6 - f10) * fI;
                float f14 = f13 < 0.0f ? 0.0f : f13;
                float f15 = (((f11 / 2.0f) + f4) * fI) + rotationAngle;
                float f16 = (f6 - f11) * fI;
                if (f16 < 0.0f) {
                    f16 = 0.0f;
                }
                this.s.reset();
                if (f14 < 360.0f || f14 % 360.0f > s86.e) {
                    fArr2 = drawAngles;
                    f5 = f4;
                    double d = f15 * 0.017453292f;
                    i3 = i5;
                    z = z2;
                    this.s.moveTo(centerCircleBox.c + (((float) Math.cos(d)) * f7), centerCircleBox.d + (f7 * ((float) Math.sin(d))));
                    this.s.arcTo(rectF2, f15, f16);
                } else {
                    this.s.addCircle(centerCircleBox.c, centerCircleBox.d, f7, Path.Direction.CW);
                    fArr2 = drawAngles;
                    f5 = f4;
                    i3 = i5;
                    z = z2;
                }
                if (z3) {
                    double d2 = f12 * 0.017453292f;
                    i = i7;
                    rectF = rectF2;
                    f = f8;
                    vb3Var = centerCircleBox;
                    fArr = fArr2;
                    fH = h(centerCircleBox, radius, f6 * fI, (((float) Math.cos(d2)) * radius) + centerCircleBox.c, centerCircleBox.d + (((float) Math.sin(d2)) * radius), f12, f14);
                } else {
                    rectF = rectF2;
                    vb3Var = centerCircleBox;
                    i = i7;
                    f = f8;
                    fArr = fArr2;
                    fH = 0.0f;
                }
                RectF rectF3 = this.t;
                float f17 = vb3Var.c;
                float f18 = vb3Var.d;
                rectF3.set(f17 - f, f18 - f, f17 + f, f18 + f);
                if (!z || (f <= 0.0f && !z3)) {
                    f2 = fH2;
                    f3 = fI;
                    if (f14 % 360.0f > s86.e) {
                        if (z3) {
                            double d3 = (f12 + (f14 / 2.0f)) * 0.017453292f;
                            this.s.lineTo(vb3Var.c + (((float) Math.cos(d3)) * fH), vb3Var.d + (fH * ((float) Math.sin(d3))));
                        } else {
                            this.s.lineTo(vb3Var.c, vb3Var.d);
                        }
                    }
                } else {
                    if (z3) {
                        if (fH < 0.0f) {
                            fH = -fH;
                        }
                        fMax = Math.max(f, fH);
                    } else {
                        fMax = f;
                    }
                    float f19 = (i3 == 1 || fMax == 0.0f) ? 0.0f : fL0 / (fMax * 0.017453292f);
                    float f20 = ((f5 + (f19 / 2.0f)) * fI) + rotationAngle;
                    float f21 = (f6 - f19) * fI;
                    if (f21 < 0.0f) {
                        f21 = 0.0f;
                    }
                    float f22 = f20 + f21;
                    if (f14 < 360.0f || f14 % 360.0f > s86.e) {
                        double d4 = f22 * 0.017453292f;
                        f2 = fH2;
                        f3 = fI;
                        this.s.lineTo(vb3Var.c + (((float) Math.cos(d4)) * fMax), vb3Var.d + (fMax * ((float) Math.sin(d4))));
                        this.s.arcTo(this.t, f22, -f21);
                    } else {
                        this.s.addCircle(vb3Var.c, vb3Var.d, fMax, Path.Direction.CCW);
                        f2 = fH2;
                        f3 = fI;
                    }
                }
                this.s.close();
                this.r.drawPath(this.s, this.c);
            } else {
                i = i4;
                rectF = rectF2;
                f = holeRadius;
                fArr = drawAngles;
                z = z2;
                f2 = fH2;
                f3 = fI;
                vb3Var = centerCircleBox;
            }
            i4 = i + 1;
            fH2 = f2;
            rectF2 = rectF;
            holeRadius = f;
            centerCircleBox = vb3Var;
            fI = f3;
            drawAngles = fArr;
            z2 = z;
            vh2VarArr2 = vh2VarArr;
        }
        vb3.f(centerCircleBox);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03db  */
    @Override // defpackage.su0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e(Canvas canvas) {
        int i;
        float[] fArr;
        float[] fArr2;
        float f;
        float f2;
        float f3;
        List<ao2> list;
        vb3 vb3Var;
        float f4;
        Canvas canvas2;
        PieDataSet$ValuePosition pieDataSet$ValuePosition;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        vb3 vb3Var2;
        h96 h96Var;
        vb3 vb3Var3;
        ao2 ao2Var;
        float f10;
        List<ao2> list2;
        PieEntry pieEntry;
        Canvas canvas3;
        String str;
        String str2;
        Canvas canvas4;
        vb3 vb3Var4;
        vb3 vb3Var5;
        Canvas canvas5 = canvas;
        vb3 centerCircleBox = this.g.getCenterCircleBox();
        float radius = this.g.getRadius();
        float rotationAngle = this.g.getRotationAngle();
        float[] drawAngles = this.g.getDrawAngles();
        float[] absoluteAngles = this.g.getAbsoluteAngles();
        float fH = this.b.h();
        float fI = this.b.i();
        float holeRadius = (radius - ((this.g.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        float holeRadius2 = this.g.getHoleRadius() / 100.0f;
        float f11 = (radius / 10.0f) * 3.6f;
        if (this.g.isDrawHoleEnabled()) {
            f11 = (radius - (radius * holeRadius2)) / 2.0f;
            if (!this.g.isDrawSlicesUnderHoleEnabled() && this.g.isDrawRoundedSlicesEnabled()) {
                rotationAngle = (float) (((double) rotationAngle) + (((double) (holeRadius * 360.0f)) / (((double) radius) * 6.283185307179586d)));
            }
        }
        float f12 = rotationAngle;
        float f13 = radius - f11;
        ii4 ii4Var = (ii4) this.g.getData();
        List<ao2> listH = ii4Var.h();
        float fW = ii4Var.w();
        boolean zIsDrawEntryLabelsEnabled = this.g.isDrawEntryLabelsEnabled();
        canvas.save();
        float fE = s86.e(5.0f);
        int i2 = 0;
        int i3 = 0;
        while (i3 < listH.size()) {
            ao2 ao2Var2 = listH.get(i3);
            boolean zH0 = ao2Var2.h0();
            if (zH0 || zIsDrawEntryLabelsEnabled) {
                PieDataSet$ValuePosition pieDataSet$ValuePositionF = ao2Var2.F();
                PieDataSet$ValuePosition pieDataSet$ValuePositionE0 = ao2Var2.E0();
                a(ao2Var2);
                int i4 = i2;
                i = i3;
                float fA = s86.a(this.f, "Q") + s86.e(4.0f);
                h96 h96VarZ = ao2Var2.Z();
                int iK0 = ao2Var2.K0();
                List<ao2> list3 = listH;
                this.j.setColor(ao2Var2.x0());
                this.j.setStrokeWidth(s86.e(ao2Var2.b0()));
                float fR = r(ao2Var2);
                vb3 vb3VarD = vb3.d(ao2Var2.L0());
                vb3 vb3Var6 = centerCircleBox;
                vb3VarD.c = s86.e(vb3VarD.c);
                vb3VarD.d = s86.e(vb3VarD.d);
                int i5 = 0;
                while (i5 < iK0) {
                    vb3 vb3Var7 = vb3VarD;
                    PieEntry pieEntryH = ao2Var2.h(i5);
                    int i6 = iK0;
                    float f14 = f12 + (((i4 == 0 ? 0.0f : absoluteAngles[i4 - 1] * fH) + ((drawAngles[i4] - ((fR / (f13 * 0.017453292f)) / 2.0f)) / 2.0f)) * fI);
                    float f15 = fR;
                    String strG = h96VarZ.g(this.g.isUsePercentValuesEnabled() ? (pieEntryH.getY() / fW) * 100.0f : pieEntryH.getY(), pieEntryH);
                    float[] fArr3 = drawAngles;
                    String label = pieEntryH.getLabel();
                    h96 h96Var2 = h96VarZ;
                    double d = f14 * 0.017453292f;
                    float[] fArr4 = absoluteAngles;
                    float f16 = fH;
                    float fCos = (float) Math.cos(d);
                    float f17 = fI;
                    float fSin = (float) Math.sin(d);
                    boolean z = zIsDrawEntryLabelsEnabled && pieDataSet$ValuePositionF == PieDataSet$ValuePosition.OUTSIDE_SLICE;
                    float f18 = f12;
                    boolean z2 = zH0 && pieDataSet$ValuePositionE0 == PieDataSet$ValuePosition.OUTSIDE_SLICE;
                    boolean z3 = zIsDrawEntryLabelsEnabled && pieDataSet$ValuePositionF == PieDataSet$ValuePosition.INSIDE_SLICE;
                    PieDataSet$ValuePosition pieDataSet$ValuePosition2 = pieDataSet$ValuePositionF;
                    boolean z4 = zH0 && pieDataSet$ValuePositionE0 == PieDataSet$ValuePosition.INSIDE_SLICE;
                    if (z || z2) {
                        float fC0 = ao2Var2.c0();
                        float fN = ao2Var2.n();
                        float fJ = ao2Var2.J() / 100.0f;
                        pieDataSet$ValuePosition = pieDataSet$ValuePositionE0;
                        if (this.g.isDrawHoleEnabled()) {
                            float f19 = radius * holeRadius2;
                            f5 = ((radius - f19) * fJ) + f19;
                        } else {
                            f5 = radius * fJ;
                        }
                        float fAbs = ao2Var2.F0() ? fN * f13 * ((float) Math.abs(Math.sin(d))) : fN * f13;
                        vb3 vb3Var8 = vb3Var6;
                        float f20 = vb3Var8.c;
                        float f21 = (f5 * fCos) + f20;
                        f6 = radius;
                        float f22 = vb3Var8.d;
                        float f23 = (f5 * fSin) + f22;
                        float f24 = (fC0 + 1.0f) * f13;
                        float f25 = (f24 * fCos) + f20;
                        float f26 = f22 + (f24 * fSin);
                        double d2 = ((double) f14) % 360.0d;
                        if (d2 < 90.0d || d2 > 270.0d) {
                            f7 = f25 + fAbs;
                            this.f.setTextAlign(Paint.Align.LEFT);
                            if (z) {
                                this.l.setTextAlign(Paint.Align.LEFT);
                            }
                            f8 = f7 + fE;
                        } else {
                            float f27 = f25 - fAbs;
                            this.f.setTextAlign(Paint.Align.RIGHT);
                            if (z) {
                                this.l.setTextAlign(Paint.Align.RIGHT);
                            }
                            f7 = f27;
                            f8 = f27 - fE;
                        }
                        if (ao2Var2.x0() != 1122867) {
                            if (ao2Var2.G0()) {
                                this.j.setColor(ao2Var2.z0(i5));
                            }
                            f9 = fSin;
                            ao2Var = ao2Var2;
                            h96Var = h96Var2;
                            vb3Var2 = vb3Var7;
                            vb3Var3 = vb3Var8;
                            f10 = f8;
                            list2 = list3;
                            pieEntry = pieEntryH;
                            canvas.drawLine(f21, f23, f25, f26, this.j);
                            canvas.drawLine(f25, f26, f7, f26, this.j);
                        } else {
                            f9 = fSin;
                            vb3Var2 = vb3Var7;
                            h96Var = h96Var2;
                            vb3Var3 = vb3Var8;
                            ao2Var = ao2Var2;
                            f10 = f8;
                            list2 = list3;
                            pieEntry = pieEntryH;
                        }
                        if (z && z2) {
                            m(canvas, strG, f10, f26, ao2Var.l(i5));
                            if (i5 >= ii4Var.i() || label == null) {
                                canvas4 = canvas;
                                str2 = label;
                            } else {
                                canvas3 = canvas;
                                str = label;
                                k(canvas3, str, f10, f26 + fA);
                                str2 = str;
                                canvas4 = canvas3;
                            }
                        } else {
                            canvas3 = canvas;
                            float f28 = f10;
                            str = label;
                            if (z) {
                                if (i5 < ii4Var.i() && str != null) {
                                    k(canvas3, str, f28, f26 + (fA / 2.0f));
                                }
                            } else if (z2) {
                                str2 = str;
                                canvas4 = canvas3;
                                m(canvas, strG, f28, f26 + (fA / 2.0f), ao2Var.l(i5));
                            }
                            str2 = str;
                            canvas4 = canvas3;
                        }
                    } else {
                        pieDataSet$ValuePosition = pieDataSet$ValuePositionE0;
                        f9 = fSin;
                        vb3Var3 = vb3Var6;
                        vb3Var2 = vb3Var7;
                        h96Var = h96Var2;
                        str2 = label;
                        ao2Var = ao2Var2;
                        f6 = radius;
                        canvas4 = canvas;
                        list2 = list3;
                        pieEntry = pieEntryH;
                    }
                    if (z3 || z4) {
                        vb3Var4 = vb3Var3;
                        float f29 = (f13 * fCos) + vb3Var4.c;
                        float f30 = (f13 * f9) + vb3Var4.d;
                        this.f.setTextAlign(Paint.Align.CENTER);
                        if (z3 && z4) {
                            m(canvas, strG, f29, f30, ao2Var.l(i5));
                            if (i5 < ii4Var.i() && str2 != null) {
                                k(canvas4, str2, f29, f30 + fA);
                            }
                        } else {
                            if (z3) {
                                if (i5 < ii4Var.i() && str2 != null) {
                                    k(canvas4, str2, f29, f30 + (fA / 2.0f));
                                }
                            } else if (z4) {
                                m(canvas, strG, f29, f30 + (fA / 2.0f), ao2Var.l(i5));
                            }
                            if (pieEntry.getIcon() == null && ao2Var.B()) {
                                Drawable icon = pieEntry.getIcon();
                                vb3Var5 = vb3Var2;
                                float f31 = vb3Var5.d;
                                s86.f(canvas, icon, (int) (((f13 + f31) * fCos) + vb3Var4.c), (int) (((f31 + f13) * f9) + vb3Var4.d + vb3Var5.c), icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                            } else {
                                vb3Var5 = vb3Var2;
                            }
                            i4++;
                            i5++;
                            vb3VarD = vb3Var5;
                            ao2Var2 = ao2Var;
                            radius = f6;
                            fR = f15;
                            iK0 = i6;
                            list3 = list2;
                            drawAngles = fArr3;
                            absoluteAngles = fArr4;
                            fH = f16;
                            f12 = f18;
                            pieDataSet$ValuePositionF = pieDataSet$ValuePosition2;
                            pieDataSet$ValuePositionE0 = pieDataSet$ValuePosition;
                            h96VarZ = h96Var;
                            vb3Var6 = vb3Var4;
                            fI = f17;
                        }
                    } else {
                        vb3Var4 = vb3Var3;
                    }
                    if (pieEntry.getIcon() == null) {
                        vb3Var5 = vb3Var2;
                    }
                    i4++;
                    i5++;
                    vb3VarD = vb3Var5;
                    ao2Var2 = ao2Var;
                    radius = f6;
                    fR = f15;
                    iK0 = i6;
                    list3 = list2;
                    drawAngles = fArr3;
                    absoluteAngles = fArr4;
                    fH = f16;
                    f12 = f18;
                    pieDataSet$ValuePositionF = pieDataSet$ValuePosition2;
                    pieDataSet$ValuePositionE0 = pieDataSet$ValuePosition;
                    h96VarZ = h96Var;
                    vb3Var6 = vb3Var4;
                    fI = f17;
                }
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f = fH;
                f2 = fI;
                f3 = f12;
                list = list3;
                vb3Var = vb3Var6;
                f4 = radius;
                canvas2 = canvas;
                vb3.f(vb3VarD);
                i2 = i4;
            } else {
                i = i3;
                list = listH;
                f4 = radius;
                fArr = drawAngles;
                fArr2 = absoluteAngles;
                f = fH;
                f2 = fI;
                f3 = f12;
                canvas2 = canvas5;
                vb3Var = centerCircleBox;
            }
            i3 = i + 1;
            canvas5 = canvas2;
            centerCircleBox = vb3Var;
            radius = f4;
            listH = list;
            drawAngles = fArr;
            absoluteAngles = fArr2;
            fH = f;
            fI = f2;
            f12 = f3;
        }
        vb3.f(centerCircleBox);
        canvas.restore();
    }

    public float h(vb3 vb3Var, float f, float f2, float f3, float f4, float f5, float f6) {
        double d = (f5 + f6) * 0.017453292f;
        float fCos = vb3Var.c + (((float) Math.cos(d)) * f);
        float fSin = vb3Var.d + (((float) Math.sin(d)) * f);
        double d2 = (f5 + (f6 / 2.0f)) * 0.017453292f;
        return (float) (((double) (f - ((float) ((Math.sqrt(Math.pow(fCos - f3, 2.0d) + Math.pow(fSin - f4, 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) f2)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((vb3Var.c + (((float) Math.cos(d2)) * f)) - ((fCos + f3) / 2.0f), 2.0d) + Math.pow((vb3Var.d + (((float) Math.sin(d2)) * f)) - ((fSin + f4) / 2.0f), 2.0d)));
    }

    public void i(Canvas canvas) {
        vb3 vb3Var;
        CharSequence centerText = this.g.getCenterText();
        if (!this.g.isDrawCenterTextEnabled() || centerText == null) {
            return;
        }
        vb3 centerCircleBox = this.g.getCenterCircleBox();
        vb3 centerTextOffset = this.g.getCenterTextOffset();
        float f = centerCircleBox.c + centerTextOffset.c;
        float f2 = centerCircleBox.d + centerTextOffset.d;
        float radius = (!this.g.isDrawHoleEnabled() || this.g.isDrawSlicesUnderHoleEnabled()) ? this.g.getRadius() : this.g.getRadius() * (this.g.getHoleRadius() / 100.0f);
        RectF[] rectFArr = this.p;
        RectF rectF = rectFArr[0];
        rectF.left = f - radius;
        rectF.top = f2 - radius;
        rectF.right = f + radius;
        rectF.bottom = f2 + radius;
        RectF rectF2 = rectFArr[1];
        rectF2.set(rectF);
        float centerTextRadiusPercent = this.g.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
            rectF2.inset((rectF2.width() - (rectF2.width() * centerTextRadiusPercent)) / 2.0f, (rectF2.height() - (rectF2.height() * centerTextRadiusPercent)) / 2.0f);
        }
        if (centerText.equals(this.n) && rectF2.equals(this.o)) {
            vb3Var = centerTextOffset;
        } else {
            this.o.set(rectF2);
            this.n = centerText;
            vb3Var = centerTextOffset;
            this.m = new StaticLayout(centerText, 0, centerText.length(), this.k, (int) Math.max(Math.ceil(this.o.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.m.getHeight();
        canvas.save();
        Path path = this.v;
        path.reset();
        path.addOval(rectF, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.translate(rectF2.left, rectF2.top + ((rectF2.height() - height) / 2.0f));
        this.m.draw(canvas);
        canvas.restore();
        vb3.f(centerCircleBox);
        vb3.f(vb3Var);
    }

    public void j(Canvas canvas, ao2 ao2Var) {
        int i;
        int i2;
        int i3;
        float[] fArr;
        float f;
        float f2;
        float f3;
        float f4;
        vb3 vb3Var;
        RectF rectF;
        int i4;
        float f5;
        RectF rectF2;
        float f6;
        RectF rectF3;
        RectF rectF4;
        vb3 vb3Var2;
        float f7;
        int i5;
        hi4 hi4Var = this;
        ao2 ao2Var2 = ao2Var;
        float rotationAngle = hi4Var.g.getRotationAngle();
        float fH = hi4Var.b.h();
        float fI = hi4Var.b.i();
        RectF circleBox = hi4Var.g.getCircleBox();
        int iK0 = ao2Var.K0();
        float[] drawAngles = hi4Var.g.getDrawAngles();
        vb3 centerCircleBox = hi4Var.g.getCenterCircleBox();
        float radius = hi4Var.g.getRadius();
        boolean z = hi4Var.g.isDrawHoleEnabled() && !hi4Var.g.isDrawSlicesUnderHoleEnabled();
        float holeRadius = z ? (hi4Var.g.getHoleRadius() / 100.0f) * radius : 0.0f;
        float holeRadius2 = (radius - ((hi4Var.g.getHoleRadius() * radius) / 100.0f)) / 2.0f;
        RectF rectF5 = new RectF();
        boolean z2 = z && hi4Var.g.isDrawRoundedSlicesEnabled();
        int i6 = 0;
        for (int i7 = 0; i7 < iK0; i7++) {
            if (Math.abs(ao2Var2.h(i7).getY()) > s86.e) {
                i6++;
            }
        }
        float fR = i6 <= 1 ? 0.0f : hi4Var.r(ao2Var2);
        int i8 = 0;
        float f8 = 0.0f;
        while (i8 < iK0) {
            float f9 = drawAngles[i8];
            float fAbs = Math.abs(ao2Var2.h(i8).getY());
            float f10 = s86.e;
            if (fAbs > f10 && (!hi4Var.g.needsHighlight(i8) || z2)) {
                boolean z3 = fR > 0.0f && f9 <= 180.0f;
                hi4Var.c.setColor(ao2Var2.z0(i8));
                float f11 = i6 == 1 ? 0.0f : fR / (radius * 0.017453292f);
                float f12 = rotationAngle + ((f8 + (f11 / 2.0f)) * fI);
                float f13 = (f9 - f11) * fI;
                if (f13 < 0.0f) {
                    f13 = 0.0f;
                }
                hi4Var.s.reset();
                if (z2) {
                    float f14 = radius - holeRadius2;
                    i = i8;
                    i2 = i6;
                    double d = f12 * 0.017453292f;
                    i3 = iK0;
                    fArr = drawAngles;
                    float fCos = centerCircleBox.c + (((float) Math.cos(d)) * f14);
                    float fSin = centerCircleBox.d + (f14 * ((float) Math.sin(d)));
                    rectF5.set(fCos - holeRadius2, fSin - holeRadius2, fCos + holeRadius2, fSin + holeRadius2);
                } else {
                    i = i8;
                    i2 = i6;
                    i3 = iK0;
                    fArr = drawAngles;
                }
                double d2 = f12 * 0.017453292f;
                f = rotationAngle;
                f2 = fH;
                float fCos2 = centerCircleBox.c + (((float) Math.cos(d2)) * radius);
                float fSin2 = centerCircleBox.d + (((float) Math.sin(d2)) * radius);
                if (f13 < 360.0f || f13 % 360.0f > f10) {
                    if (z2) {
                        hi4Var.s.arcTo(rectF5, f12 + 180.0f, -180.0f);
                    }
                    hi4Var.s.arcTo(circleBox, f12, f13);
                } else {
                    hi4Var.s.addCircle(centerCircleBox.c, centerCircleBox.d, radius, Path.Direction.CW);
                }
                RectF rectF6 = hi4Var.t;
                float f15 = centerCircleBox.c;
                float f16 = centerCircleBox.d;
                float f17 = f13;
                rectF6.set(f15 - holeRadius, f16 - holeRadius, f15 + holeRadius, f16 + holeRadius);
                if (!z) {
                    f3 = holeRadius;
                    f4 = radius;
                    vb3Var = centerCircleBox;
                    rectF = circleBox;
                    i4 = i2;
                    f5 = f17;
                    rectF2 = rectF5;
                    f6 = 360.0f;
                } else if (holeRadius > 0.0f || z3) {
                    if (z3) {
                        f7 = f17;
                        rectF = circleBox;
                        i4 = i2;
                        rectF4 = rectF5;
                        f3 = holeRadius;
                        i5 = 1;
                        f4 = radius;
                        vb3Var2 = centerCircleBox;
                        float fH2 = h(centerCircleBox, radius, f9 * fI, fCos2, fSin2, f12, f7);
                        if (fH2 < 0.0f) {
                            fH2 = -fH2;
                        }
                        holeRadius = Math.max(f3, fH2);
                    } else {
                        rectF4 = rectF5;
                        f3 = holeRadius;
                        f4 = radius;
                        vb3Var2 = centerCircleBox;
                        rectF = circleBox;
                        i4 = i2;
                        f7 = f17;
                        i5 = 1;
                    }
                    float f18 = (i4 == i5 || holeRadius == 0.0f) ? 0.0f : fR / (holeRadius * 0.017453292f);
                    float f19 = f + ((f8 + (f18 / 2.0f)) * fI);
                    float f20 = (f9 - f18) * fI;
                    if (f20 < 0.0f) {
                        f20 = 0.0f;
                    }
                    float f21 = f19 + f20;
                    if (f13 < 360.0f || f7 % 360.0f > f10) {
                        hi4Var = this;
                        if (z2) {
                            float f22 = f4 - holeRadius2;
                            double d3 = f21 * 0.017453292f;
                            float fCos3 = vb3Var2.c + (((float) Math.cos(d3)) * f22);
                            float fSin3 = vb3Var2.d + (f22 * ((float) Math.sin(d3)));
                            rectF2 = rectF4;
                            rectF2.set(fCos3 - holeRadius2, fSin3 - holeRadius2, fCos3 + holeRadius2, fSin3 + holeRadius2);
                            hi4Var.s.arcTo(rectF2, f21, 180.0f);
                        } else {
                            rectF2 = rectF4;
                            double d4 = f21 * 0.017453292f;
                            hi4Var.s.lineTo(vb3Var2.c + (((float) Math.cos(d4)) * holeRadius), vb3Var2.d + (holeRadius * ((float) Math.sin(d4))));
                        }
                        hi4Var.s.arcTo(hi4Var.t, f21, -f20);
                    } else {
                        hi4Var = this;
                        hi4Var.s.addCircle(vb3Var2.c, vb3Var2.d, holeRadius, Path.Direction.CCW);
                        rectF2 = rectF4;
                    }
                    vb3Var = vb3Var2;
                    rectF3 = rectF2;
                    hi4Var.s.close();
                    hi4Var.r.drawPath(hi4Var.s, hi4Var.c);
                    f8 += f9 * f2;
                } else {
                    f3 = holeRadius;
                    f4 = radius;
                    vb3Var = centerCircleBox;
                    rectF = circleBox;
                    i4 = i2;
                    f5 = f17;
                    f6 = 360.0f;
                    rectF2 = rectF5;
                }
                if (f5 % f6 <= f10) {
                    rectF3 = rectF2;
                } else if (z3) {
                    float f23 = f12 + (f5 / 2.0f);
                    rectF3 = rectF2;
                    float fH3 = h(vb3Var, f4, f9 * fI, fCos2, fSin2, f12, f5);
                    double d5 = f23 * 0.017453292f;
                    hi4Var.s.lineTo(vb3Var.c + (((float) Math.cos(d5)) * fH3), vb3Var.d + (fH3 * ((float) Math.sin(d5))));
                } else {
                    rectF3 = rectF2;
                    hi4Var.s.lineTo(vb3Var.c, vb3Var.d);
                }
                hi4Var.s.close();
                hi4Var.r.drawPath(hi4Var.s, hi4Var.c);
                f8 += f9 * f2;
            } else {
                f8 += f9 * fH;
                i = i8;
                rectF3 = rectF5;
                f4 = radius;
                f = rotationAngle;
                f2 = fH;
                rectF = circleBox;
                i3 = iK0;
                fArr = drawAngles;
                i4 = i6;
                f3 = holeRadius;
                vb3Var = centerCircleBox;
            }
            i8 = i + 1;
            rectF5 = rectF3;
            holeRadius = f3;
            i6 = i4;
            centerCircleBox = vb3Var;
            radius = f4;
            rotationAngle = f;
            iK0 = i3;
            drawAngles = fArr;
            fH = f2;
            circleBox = rectF;
            ao2Var2 = ao2Var;
        }
        vb3.f(centerCircleBox);
    }

    public void k(Canvas canvas, String str, float f, float f2) {
        canvas.drawText(str, f, f2, this.l);
    }

    public void l(Canvas canvas) {
        if (!this.g.isDrawHoleEnabled() || this.r == null) {
            return;
        }
        float radius = this.g.getRadius();
        float holeRadius = (this.g.getHoleRadius() / 100.0f) * radius;
        vb3 centerCircleBox = this.g.getCenterCircleBox();
        if (Color.alpha(this.h.getColor()) > 0) {
            this.r.drawCircle(centerCircleBox.c, centerCircleBox.d, holeRadius, this.h);
        }
        if (Color.alpha(this.i.getColor()) > 0 && this.g.getTransparentCircleRadius() > this.g.getHoleRadius()) {
            int alpha = this.i.getAlpha();
            float transparentCircleRadius = radius * (this.g.getTransparentCircleRadius() / 100.0f);
            this.i.setAlpha((int) (alpha * this.b.h() * this.b.i()));
            this.u.reset();
            this.u.addCircle(centerCircleBox.c, centerCircleBox.d, transparentCircleRadius, Path.Direction.CW);
            this.u.addCircle(centerCircleBox.c, centerCircleBox.d, holeRadius, Path.Direction.CCW);
            this.r.drawPath(this.u, this.i);
            this.i.setAlpha(alpha);
        }
        vb3.f(centerCircleBox);
    }

    public void m(Canvas canvas, String str, float f, float f2, int i) {
        this.f.setColor(i);
        canvas.drawText(str, f, f2, this.f);
    }

    public TextPaint n() {
        return this.k;
    }

    public Paint o() {
        return this.l;
    }

    public Paint p() {
        return this.h;
    }

    public Paint q() {
        return this.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float r(ao2 ao2Var) {
        if (!ao2Var.g()) {
            return ao2Var.l0();
        }
        if (ao2Var.l0() / this.f20113a.t() > (ao2Var.W() / ((ii4) this.g.getData()).w()) * 2.0f) {
            return 0.0f;
        }
        return ao2Var.l0();
    }

    public void s() {
        Canvas canvas = this.r;
        if (canvas != null) {
            canvas.setBitmap(null);
            this.r = null;
        }
        WeakReference<Bitmap> weakReference = this.q;
        if (weakReference != null) {
            Bitmap bitmap = weakReference.get();
            if (bitmap != null) {
                bitmap.recycle();
            }
            this.q.clear();
            this.q = null;
        }
    }

    @Override // defpackage.su0
    public void f() {
    }
}
