package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import defpackage.kl2;
import defpackage.mk2;
import defpackage.nf6;
import defpackage.qp;
import defpackage.s86;
import defpackage.vb3;
import defpackage.vh2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends ChartTouchListener<BarLineChartBase<? extends qp<? extends mk2<? extends Entry>>>> {
    public Matrix f;
    public Matrix g;
    public vb3 h;
    public vb3 i;
    public float j;
    public float k;
    public float l;
    public kl2 m;
    public VelocityTracker n;
    public long o;
    public vb3 p;
    public vb3 q;
    public float r;
    public float s;

    public a(BarLineChartBase<? extends qp<? extends mk2<? extends Entry>>> barLineChartBase, Matrix matrix, float f) {
        super(barLineChartBase);
        this.f = new Matrix();
        this.g = new Matrix();
        this.h = vb3.c(0.0f, 0.0f);
        this.i = vb3.c(0.0f, 0.0f);
        this.j = 1.0f;
        this.k = 1.0f;
        this.l = 1.0f;
        this.o = 0L;
        this.p = vb3.c(0.0f, 0.0f);
        this.q = vb3.c(0.0f, 0.0f);
        this.f = matrix;
        this.r = s86.e(f);
        this.s = s86.e(3.5f);
    }

    public static float h(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    public static float i(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public static void k(vb3 vb3Var, MotionEvent motionEvent) {
        float x = motionEvent.getX(0) + motionEvent.getX(1);
        float y = motionEvent.getY(0) + motionEvent.getY(1);
        vb3Var.c = x / 2.0f;
        vb3Var.d = y / 2.0f;
    }

    public static float p(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public void f() {
        vb3 vb3Var = this.q;
        if (vb3Var.c == 0.0f && vb3Var.d == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.q.c *= ((BarLineChartBase) this.e).getDragDecelerationFrictionCoef();
        this.q.d *= ((BarLineChartBase) this.e).getDragDecelerationFrictionCoef();
        float f = (jCurrentAnimationTimeMillis - this.o) / 1000.0f;
        vb3 vb3Var2 = this.q;
        float f2 = vb3Var2.c * f;
        float f3 = vb3Var2.d * f;
        vb3 vb3Var3 = this.p;
        float f4 = vb3Var3.c + f2;
        vb3Var3.c = f4;
        float f5 = vb3Var3.d + f3;
        vb3Var3.d = f5;
        MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentAnimationTimeMillis, jCurrentAnimationTimeMillis, 2, f4, f5, 0);
        l(motionEventObtain, ((BarLineChartBase) this.e).isDragXEnabled() ? this.p.c - this.h.c : 0.0f, ((BarLineChartBase) this.e).isDragYEnabled() ? this.p.d - this.h.d : 0.0f);
        motionEventObtain.recycle();
        this.f = ((BarLineChartBase) this.e).getViewPortHandler().L(this.f, this.e, false);
        this.o = jCurrentAnimationTimeMillis;
        if (Math.abs(this.q.c) >= 0.01d || Math.abs(this.q.d) >= 0.01d) {
            s86.x(this.e);
            return;
        }
        ((BarLineChartBase) this.e).calculateOffsets();
        ((BarLineChartBase) this.e).postInvalidate();
        q();
    }

    public vb3 g(float f, float f2) {
        nf6 viewPortHandler = ((BarLineChartBase) this.e).getViewPortHandler();
        return vb3.c(f - viewPortHandler.I(), j() ? -(f2 - viewPortHandler.K()) : -((((BarLineChartBase) this.e).getMeasuredHeight() - f2) - viewPortHandler.H()));
    }

    public final boolean j() {
        kl2 kl2Var;
        return (this.m == null && ((BarLineChartBase) this.e).isAnyAxisInverted()) || ((kl2Var = this.m) != null && ((BarLineChartBase) this.e).isInverted(kl2Var.i0()));
    }

    public final void l(MotionEvent motionEvent, float f, float f2) {
        this.f5815a = ChartTouchListener.ChartGesture.DRAG;
        this.f.set(this.g);
        ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (j()) {
            if (this.e instanceof HorizontalBarChart) {
                f = -f;
            } else {
                f2 = -f2;
            }
        }
        this.f.postTranslate(f, f2);
    }

    public final void m(MotionEvent motionEvent) {
        vh2 highlightByTouchPoint = ((BarLineChartBase) this.e).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY());
        if (highlightByTouchPoint == null || highlightByTouchPoint.a(this.c)) {
            return;
        }
        this.c = highlightByTouchPoint;
        ((BarLineChartBase) this.e).highlightValue(highlightByTouchPoint, true);
    }

    public final void n(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            ((BarLineChartBase) this.e).getOnChartGestureListener();
            float fP = p(motionEvent);
            if (fP > this.s) {
                vb3 vb3Var = this.i;
                vb3 vb3VarG = g(vb3Var.c, vb3Var.d);
                nf6 viewPortHandler = ((BarLineChartBase) this.e).getViewPortHandler();
                int i = this.b;
                if (i == 4) {
                    this.f5815a = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f = fP / this.l;
                    boolean z = f < 1.0f;
                    boolean zC = z ? viewPortHandler.c() : viewPortHandler.a();
                    boolean zD = z ? viewPortHandler.d() : viewPortHandler.b();
                    float f2 = ((BarLineChartBase) this.e).isScaleXEnabled() ? f : 1.0f;
                    float f3 = ((BarLineChartBase) this.e).isScaleYEnabled() ? f : 1.0f;
                    if (zD || zC) {
                        this.f.set(this.g);
                        this.f.postScale(f2, f3, vb3VarG.c, vb3VarG.d);
                    }
                } else if (i == 2 && ((BarLineChartBase) this.e).isScaleXEnabled()) {
                    this.f5815a = ChartTouchListener.ChartGesture.X_ZOOM;
                    float fH = h(motionEvent) / this.j;
                    if (fH < 1.0f ? viewPortHandler.c() : viewPortHandler.a()) {
                        this.f.set(this.g);
                        this.f.postScale(fH, 1.0f, vb3VarG.c, vb3VarG.d);
                    }
                } else if (this.b == 3 && ((BarLineChartBase) this.e).isScaleYEnabled()) {
                    this.f5815a = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float fI = i(motionEvent) / this.k;
                    if (fI < 1.0f ? viewPortHandler.d() : viewPortHandler.b()) {
                        this.f.set(this.g);
                        this.f.postScale(1.0f, fI, vb3VarG.c, vb3VarG.d);
                    }
                }
                vb3.f(vb3VarG);
            }
        }
    }

    public final void o(MotionEvent motionEvent) {
        this.g.set(this.f);
        this.h.c = motionEvent.getX();
        this.h.d = motionEvent.getY();
        this.m = ((BarLineChartBase) this.e).getDataSetByTouchPoint(motionEvent.getX(), motionEvent.getY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f5815a = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (((BarLineChartBase) this.e).isDoubleTapToZoomEnabled() && ((qp) ((BarLineChartBase) this.e).getData()).i() > 0) {
            vb3 vb3VarG = g(motionEvent.getX(), motionEvent.getY());
            T t = this.e;
            ((BarLineChartBase) t).zoom(((BarLineChartBase) t).isScaleXEnabled() ? 1.4f : 1.0f, ((BarLineChartBase) this.e).isScaleYEnabled() ? 1.4f : 1.0f, vb3VarG.c, vb3VarG.d);
            if (((BarLineChartBase) this.e).isLogEnabled()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + vb3VarG.c + ", y: " + vb3VarG.d);
            }
            vb3.f(vb3VarG);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f5815a = ChartTouchListener.ChartGesture.FLING;
        ((BarLineChartBase) this.e).getOnChartGestureListener();
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f5815a = ChartTouchListener.ChartGesture.LONG_PRESS;
        ((BarLineChartBase) this.e).getOnChartGestureListener();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f5815a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        ((BarLineChartBase) this.e).getOnChartGestureListener();
        if (!((BarLineChartBase) this.e).isHighlightPerTapEnabled()) {
            return false;
        }
        c(((BarLineChartBase) this.e).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.n == null) {
            this.n = VelocityTracker.obtain();
        }
        this.n.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.n) != null) {
            velocityTracker.recycle();
            this.n = null;
        }
        if (this.b == 0) {
            this.d.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.e).isDragEnabled() && !((BarLineChartBase) this.e).isScaleXEnabled() && !((BarLineChartBase) this.e).isScaleYEnabled()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                VelocityTracker velocityTracker2 = this.n;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker2.computeCurrentVelocity(1000, s86.o());
                float yVelocity = velocityTracker2.getYVelocity(pointerId);
                float xVelocity = velocityTracker2.getXVelocity(pointerId);
                if ((Math.abs(xVelocity) > s86.p() || Math.abs(yVelocity) > s86.p()) && this.b == 1 && ((BarLineChartBase) this.e).isDragDecelerationEnabled()) {
                    q();
                    this.o = AnimationUtils.currentAnimationTimeMillis();
                    this.p.c = motionEvent.getX();
                    this.p.d = motionEvent.getY();
                    vb3 vb3Var = this.q;
                    vb3Var.c = xVelocity;
                    vb3Var.d = yVelocity;
                    s86.x(this.e);
                }
                int i = this.b;
                if (i == 2 || i == 3 || i == 4 || i == 5) {
                    ((BarLineChartBase) this.e).calculateOffsets();
                    ((BarLineChartBase) this.e).postInvalidate();
                }
                this.b = 0;
                ((BarLineChartBase) this.e).enableScroll();
                VelocityTracker velocityTracker3 = this.n;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.n = null;
                }
                b(motionEvent);
            } else if (action == 2) {
                int i2 = this.b;
                if (i2 == 1) {
                    ((BarLineChartBase) this.e).disableScroll();
                    l(motionEvent, ((BarLineChartBase) this.e).isDragXEnabled() ? motionEvent.getX() - this.h.c : 0.0f, ((BarLineChartBase) this.e).isDragYEnabled() ? motionEvent.getY() - this.h.d : 0.0f);
                } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                    ((BarLineChartBase) this.e).disableScroll();
                    if (((BarLineChartBase) this.e).isScaleXEnabled() || ((BarLineChartBase) this.e).isScaleYEnabled()) {
                        n(motionEvent);
                    }
                } else if (i2 == 0 && Math.abs(ChartTouchListener.a(motionEvent.getX(), this.h.c, motionEvent.getY(), this.h.d)) > this.r && ((BarLineChartBase) this.e).isDragEnabled()) {
                    if ((((BarLineChartBase) this.e).isFullyZoomedOut() && ((BarLineChartBase) this.e).hasNoDragOffset()) ? false : true) {
                        float fAbs = Math.abs(motionEvent.getX() - this.h.c);
                        float fAbs2 = Math.abs(motionEvent.getY() - this.h.d);
                        if ((((BarLineChartBase) this.e).isDragXEnabled() || fAbs2 >= fAbs) && (((BarLineChartBase) this.e).isDragYEnabled() || fAbs2 <= fAbs)) {
                            this.f5815a = ChartTouchListener.ChartGesture.DRAG;
                            this.b = 1;
                        }
                    } else if (((BarLineChartBase) this.e).isHighlightPerDragEnabled()) {
                        this.f5815a = ChartTouchListener.ChartGesture.DRAG;
                        if (((BarLineChartBase) this.e).isHighlightPerDragEnabled()) {
                            m(motionEvent);
                        }
                    }
                }
            } else if (action == 3) {
                this.b = 0;
                b(motionEvent);
            } else if (action != 5) {
                if (action == 6) {
                    s86.z(motionEvent, this.n);
                    this.b = 5;
                }
            } else if (motionEvent.getPointerCount() >= 2) {
                ((BarLineChartBase) this.e).disableScroll();
                o(motionEvent);
                this.j = h(motionEvent);
                this.k = i(motionEvent);
                float fP = p(motionEvent);
                this.l = fP;
                if (fP > 10.0f) {
                    if (((BarLineChartBase) this.e).isPinchZoomEnabled()) {
                        this.b = 4;
                    } else if (((BarLineChartBase) this.e).isScaleXEnabled() != ((BarLineChartBase) this.e).isScaleYEnabled()) {
                        this.b = ((BarLineChartBase) this.e).isScaleXEnabled() ? 2 : 3;
                    } else {
                        this.b = this.j > this.k ? 2 : 3;
                    }
                }
                k(this.i, motionEvent);
            }
        } else {
            e(motionEvent);
            q();
            o(motionEvent);
        }
        this.f = ((BarLineChartBase) this.e).getViewPortHandler().L(this.f, this.e, true);
        return true;
    }

    public void q() {
        vb3 vb3Var = this.q;
        vb3Var.c = 0.0f;
        vb3Var.d = 0.0f;
    }
}
