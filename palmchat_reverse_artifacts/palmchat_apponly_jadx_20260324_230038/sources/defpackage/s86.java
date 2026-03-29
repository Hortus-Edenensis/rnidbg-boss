package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class s86 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DisplayMetrics f20681a = null;
    public static int b = 50;
    public static int c = 8000;
    public static final double d = Double.longBitsToDouble(1);
    public static final float e = Float.intBitsToFloat(1);
    public static Rect f = new Rect();
    public static Paint.FontMetrics g = new Paint.FontMetrics();
    public static Rect h = new Rect();
    public static final int[] i = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};
    public static h96 j = h();
    public static Rect k = new Rect();
    public static Rect l = new Rect();
    public static Paint.FontMetrics m = new Paint.FontMetrics();

    public static int a(Paint paint, String str) {
        Rect rect = f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static at1 b(Paint paint, String str) {
        at1 at1VarB = at1.b(0.0f, 0.0f);
        c(paint, str, at1VarB);
        return at1VarB;
    }

    public static void c(Paint paint, String str, at1 at1Var) {
        Rect rect = h;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        at1Var.c = rect.width();
        at1Var.d = rect.height();
    }

    public static int d(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float e(float f2) {
        DisplayMetrics displayMetrics = f20681a;
        if (displayMetrics != null) {
            return f2 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static void f(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5) {
        vb3 vb3VarB = vb3.b();
        vb3VarB.c = i2 - (i4 / 2);
        vb3VarB.d = i3 - (i5 / 2);
        drawable.copyBounds(k);
        Rect rect = k;
        int i6 = rect.left;
        int i7 = rect.top;
        drawable.setBounds(i6, i7, i6 + i4, i4 + i7);
        int iSave = canvas.save();
        canvas.translate(vb3VarB.c, vb3VarB.d);
        drawable.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public static void g(Canvas canvas, String str, float f2, float f3, Paint paint, vb3 vb3Var, float f4) {
        float fontMetrics = paint.getFontMetrics(m);
        paint.getTextBounds(str, 0, str.length(), l);
        float fWidth = 0.0f - l.left;
        float f5 = (-m.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f4 != 0.0f) {
            float fWidth2 = fWidth - (l.width() * 0.5f);
            float f6 = f5 - (fontMetrics * 0.5f);
            if (vb3Var.c != 0.5f || vb3Var.d != 0.5f) {
                at1 at1VarT = t(l.width(), fontMetrics, f4);
                f2 -= at1VarT.c * (vb3Var.c - 0.5f);
                f3 -= at1VarT.d * (vb3Var.d - 0.5f);
                at1.c(at1VarT);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.drawText(str, fWidth2, f6, paint);
            canvas.restore();
        } else {
            if (vb3Var.c != 0.0f || vb3Var.d != 0.0f) {
                fWidth -= l.width() * vb3Var.c;
                f5 -= fontMetrics * vb3Var.d;
            }
            canvas.drawText(str, fWidth + f2, f5 + f3, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static h96 h() {
        return new la1(1);
    }

    public static int i(float f2) {
        float fY = y(f2);
        if (Float.isInfinite(fY)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10(fY))) + 2;
    }

    public static h96 j() {
        return j;
    }

    public static float k(Paint paint) {
        return l(paint, g);
    }

    public static float l(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float m(Paint paint) {
        return n(paint, g);
    }

    public static float n(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int o() {
        return c;
    }

    public static int p() {
        return b;
    }

    public static float q(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2 % 360.0f;
    }

    public static void r(vb3 vb3Var, float f2, float f3, vb3 vb3Var2) {
        double d2 = f2;
        double d3 = f3;
        vb3Var2.c = (float) (((double) vb3Var.c) + (Math.cos(Math.toRadians(d3)) * d2));
        vb3Var2.d = (float) (((double) vb3Var.d) + (d2 * Math.sin(Math.toRadians(d3))));
    }

    public static int s() {
        return Build.VERSION.SDK_INT;
    }

    public static at1 t(float f2, float f3, float f4) {
        return u(f2, f3, f4 * 0.017453292f);
    }

    public static at1 u(float f2, float f3, float f4) {
        double d2 = f4;
        return at1.b(Math.abs(((float) Math.cos(d2)) * f2) + Math.abs(((float) Math.sin(d2)) * f3), Math.abs(f2 * ((float) Math.sin(d2))) + Math.abs(f3 * ((float) Math.cos(d2))));
    }

    public static void v(Context context) {
        if (context == null) {
            b = ViewConfiguration.getMinimumFlingVelocity();
            c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            b = viewConfiguration.getScaledMinimumFlingVelocity();
            c = viewConfiguration.getScaledMaximumFlingVelocity();
            f20681a = context.getResources().getDisplayMetrics();
        }
    }

    public static double w(double d2) {
        if (d2 == Double.POSITIVE_INFINITY) {
            return d2;
        }
        double d3 = d2 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d3) + (d3 >= 0.0d ? 1L : -1L));
    }

    @SuppressLint({"NewApi"})
    public static void x(View view) {
        view.postInvalidateOnAnimation();
    }

    public static float y(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 == 0.0d) {
            return 0.0f;
        }
        return Math.round(d2 * ((double) r0)) / ((float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d2 < 0.0d ? -d2 : d2)))));
    }

    public static void z(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (i2 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }
}
