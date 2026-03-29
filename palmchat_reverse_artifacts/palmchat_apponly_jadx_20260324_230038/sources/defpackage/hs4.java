package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarEntry;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class hs4 extends s23 {
    public RadarChart i;
    public Paint j;
    public Paint k;
    public Path l;
    public Path m;

    public hs4(RadarChart radarChart, g10 g10Var, nf6 nf6Var) {
        super(g10Var, nf6Var);
        this.l = new Path();
        this.m = new Path();
        this.i = radarChart;
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(2.0f);
        this.d.setColor(Color.rgb(255, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME, 115));
        Paint paint2 = new Paint(1);
        this.j = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.k = new Paint(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.su0
    public void b(Canvas canvas) {
        is4 is4Var = (is4) this.i.getData();
        int iK0 = is4Var.m().K0();
        for (eo2 eo2Var : is4Var.h()) {
            if (eo2Var.isVisible()) {
                n(canvas, eo2Var, iK0);
            }
        }
    }

    @Override // defpackage.su0
    public void c(Canvas canvas) {
        q(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e7  */
    @Override // defpackage.su0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(Canvas canvas, vh2[] vh2VarArr) {
        int i;
        float sliceAngle = this.i.getSliceAngle();
        float factor = this.i.getFactor();
        vb3 centerOffsets = this.i.getCenterOffsets();
        vb3 vb3VarC = vb3.c(0.0f, 0.0f);
        is4 is4Var = (is4) this.i.getData();
        int length = vh2VarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i3 < length) {
            vh2 vh2Var = vh2VarArr[i3];
            eo2 eo2VarE = is4Var.e(vh2Var.d());
            if (eo2VarE == null || !eo2VarE.O()) {
                i = i3;
            } else {
                Entry entry = (RadarEntry) eo2VarE.h((int) vh2Var.h());
                if (h(entry, eo2VarE)) {
                    s86.r(centerOffsets, (entry.getY() - this.i.getYChartMin()) * factor * this.b.i(), (vh2Var.h() * sliceAngle * this.b.h()) + this.i.getRotationAngle(), vb3VarC);
                    vh2Var.m(vb3VarC.c, vb3VarC.d);
                    j(canvas, vb3VarC.c, vb3VarC.d, eo2VarE);
                    if (eo2VarE.p0() && !Float.isNaN(vb3VarC.c) && !Float.isNaN(vb3VarC.d)) {
                        int iT = eo2VarE.T();
                        if (iT == 1122867) {
                            iT = eo2VarE.z0(i2);
                        }
                        if (eo2VarE.x() < 255) {
                            iT = xh0.a(iT, eo2VarE.x());
                        }
                        i = i3;
                        o(canvas, vb3VarC, eo2VarE.m0(), eo2VarE.X(), eo2VarE.a(), iT, eo2VarE.j0());
                    }
                }
            }
            i3 = i + 1;
            i2 = 0;
        }
        vb3.f(centerOffsets);
        vb3.f(vb3VarC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.su0
    public void e(Canvas canvas) {
        int i;
        float f;
        RadarEntry radarEntry;
        int i2;
        eo2 eo2Var;
        int i3;
        float f2;
        vb3 vb3Var;
        h96 h96Var;
        float fH = this.b.h();
        float fI = this.b.i();
        float sliceAngle = this.i.getSliceAngle();
        float factor = this.i.getFactor();
        vb3 centerOffsets = this.i.getCenterOffsets();
        vb3 vb3VarC = vb3.c(0.0f, 0.0f);
        vb3 vb3VarC2 = vb3.c(0.0f, 0.0f);
        float fE = s86.e(5.0f);
        int i4 = 0;
        while (i4 < ((is4) this.i.getData()).f()) {
            eo2 eo2VarE = ((is4) this.i.getData()).e(i4);
            if (i(eo2VarE)) {
                a(eo2VarE);
                h96 h96VarZ = eo2VarE.Z();
                vb3 vb3VarD = vb3.d(eo2VarE.L0());
                vb3VarD.c = s86.e(vb3VarD.c);
                vb3VarD.d = s86.e(vb3VarD.d);
                int i5 = 0;
                while (i5 < eo2VarE.K0()) {
                    RadarEntry radarEntry2 = (RadarEntry) eo2VarE.h(i5);
                    vb3 vb3Var2 = vb3VarD;
                    float f3 = i5 * sliceAngle * fH;
                    s86.r(centerOffsets, (radarEntry2.getY() - this.i.getYChartMin()) * factor * fI, f3 + this.i.getRotationAngle(), vb3VarC);
                    if (eo2VarE.h0()) {
                        radarEntry = radarEntry2;
                        i2 = i5;
                        f2 = fH;
                        vb3Var = vb3Var2;
                        h96Var = h96VarZ;
                        eo2Var = eo2VarE;
                        i3 = i4;
                        p(canvas, h96VarZ.i(radarEntry2), vb3VarC.c, vb3VarC.d - fE, eo2VarE.l(i5));
                    } else {
                        radarEntry = radarEntry2;
                        i2 = i5;
                        eo2Var = eo2VarE;
                        i3 = i4;
                        f2 = fH;
                        vb3Var = vb3Var2;
                        h96Var = h96VarZ;
                    }
                    if (radarEntry.getIcon() != null && eo2Var.B()) {
                        Drawable icon = radarEntry.getIcon();
                        s86.r(centerOffsets, (radarEntry.getY() * factor * fI) + vb3Var.d, f3 + this.i.getRotationAngle(), vb3VarC2);
                        float f4 = vb3VarC2.d + vb3Var.c;
                        vb3VarC2.d = f4;
                        s86.f(canvas, icon, (int) vb3VarC2.c, (int) f4, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
                    }
                    i5 = i2 + 1;
                    vb3VarD = vb3Var;
                    eo2VarE = eo2Var;
                    h96VarZ = h96Var;
                    i4 = i3;
                    fH = f2;
                }
                i = i4;
                f = fH;
                vb3.f(vb3VarD);
            } else {
                i = i4;
                f = fH;
            }
            i4 = i + 1;
            fH = f;
        }
        vb3.f(centerOffsets);
        vb3.f(vb3VarC);
        vb3.f(vb3VarC2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(Canvas canvas, eo2 eo2Var, int i) {
        float fH = this.b.h();
        float fI = this.b.i();
        float sliceAngle = this.i.getSliceAngle();
        float factor = this.i.getFactor();
        vb3 centerOffsets = this.i.getCenterOffsets();
        vb3 vb3VarC = vb3.c(0.0f, 0.0f);
        Path path = this.l;
        path.reset();
        boolean z = false;
        for (int i2 = 0; i2 < eo2Var.K0(); i2++) {
            this.c.setColor(eo2Var.z0(i2));
            s86.r(centerOffsets, (((RadarEntry) eo2Var.h(i2)).getY() - this.i.getYChartMin()) * factor * fI, (i2 * sliceAngle * fH) + this.i.getRotationAngle(), vb3VarC);
            if (!Float.isNaN(vb3VarC.c)) {
                if (z) {
                    path.lineTo(vb3VarC.c, vb3VarC.d);
                } else {
                    path.moveTo(vb3VarC.c, vb3VarC.d);
                    z = true;
                }
            }
        }
        if (eo2Var.K0() > i) {
            path.lineTo(centerOffsets.c, centerOffsets.d);
        }
        path.close();
        if (eo2Var.w0()) {
            Drawable drawableF = eo2Var.f();
            if (drawableF != null) {
                m(canvas, path, drawableF);
            } else {
                l(canvas, path, eo2Var.getFillColor(), eo2Var.R());
            }
        }
        this.c.setStrokeWidth(eo2Var.U());
        this.c.setStyle(Paint.Style.STROKE);
        if (!eo2Var.w0() || eo2Var.R() < 255) {
            canvas.drawPath(path, this.c);
        }
        vb3.f(centerOffsets);
        vb3.f(vb3VarC);
    }

    public void o(Canvas canvas, vb3 vb3Var, float f, float f2, int i, int i2, float f3) {
        canvas.save();
        float fE = s86.e(f2);
        float fE2 = s86.e(f);
        if (i != 1122867) {
            Path path = this.m;
            path.reset();
            path.addCircle(vb3Var.c, vb3Var.d, fE, Path.Direction.CW);
            if (fE2 > 0.0f) {
                path.addCircle(vb3Var.c, vb3Var.d, fE2, Path.Direction.CCW);
            }
            this.k.setColor(i);
            this.k.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.k);
        }
        if (i2 != 1122867) {
            this.k.setColor(i2);
            this.k.setStyle(Paint.Style.STROKE);
            this.k.setStrokeWidth(s86.e(f3));
            canvas.drawCircle(vb3Var.c, vb3Var.d, fE, this.k);
        }
        canvas.restore();
    }

    public void p(Canvas canvas, String str, float f, float f2, int i) {
        this.f.setColor(i);
        canvas.drawText(str, f, f2, this.f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void q(Canvas canvas) {
        float sliceAngle = this.i.getSliceAngle();
        float factor = this.i.getFactor();
        float rotationAngle = this.i.getRotationAngle();
        vb3 centerOffsets = this.i.getCenterOffsets();
        this.j.setStrokeWidth(this.i.getWebLineWidth());
        this.j.setColor(this.i.getWebColor());
        this.j.setAlpha(this.i.getWebAlpha());
        int skipWebLineCount = this.i.getSkipWebLineCount() + 1;
        int iK0 = ((is4) this.i.getData()).m().K0();
        vb3 vb3VarC = vb3.c(0.0f, 0.0f);
        for (int i = 0; i < iK0; i += skipWebLineCount) {
            s86.r(centerOffsets, this.i.getYRange() * factor, (i * sliceAngle) + rotationAngle, vb3VarC);
            canvas.drawLine(centerOffsets.c, centerOffsets.d, vb3VarC.c, vb3VarC.d, this.j);
        }
        vb3.f(vb3VarC);
        this.j.setStrokeWidth(this.i.getWebLineWidthInner());
        this.j.setColor(this.i.getWebColorInner());
        this.j.setAlpha(this.i.getWebAlpha());
        int i2 = this.i.getYAxis().n;
        vb3 vb3VarC2 = vb3.c(0.0f, 0.0f);
        vb3 vb3VarC3 = vb3.c(0.0f, 0.0f);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (i4 < ((is4) this.i.getData()).i()) {
                float yChartMin = (this.i.getYAxis().l[i3] - this.i.getYChartMin()) * factor;
                s86.r(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle, vb3VarC2);
                i4++;
                s86.r(centerOffsets, yChartMin, (i4 * sliceAngle) + rotationAngle, vb3VarC3);
                canvas.drawLine(vb3VarC2.c, vb3VarC2.d, vb3VarC3.c, vb3VarC3.d, this.j);
            }
        }
        vb3.f(vb3VarC2);
        vb3.f(vb3VarC3);
    }

    @Override // defpackage.su0
    public void f() {
    }
}
