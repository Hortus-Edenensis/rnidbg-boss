package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import defpackage.s86;
import defpackage.vb3;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c extends ChartTouchListener<PieRadarChartBase<?>> {
    public vb3 f;
    public float g;
    public ArrayList<a> h;
    public long i;
    public float j;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f5816a;
        public float b;

        public a(long j, float f) {
            this.f5816a = j;
            this.b = f;
        }
    }

    public c(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
        this.f = vb3.c(0.0f, 0.0f);
        this.g = 0.0f;
        this.h = new ArrayList<>();
        this.i = 0L;
        this.j = 0.0f;
    }

    public final float f() {
        if (this.h.isEmpty()) {
            return 0.0f;
        }
        a aVar = this.h.get(0);
        ArrayList<a> arrayList = this.h;
        a aVar2 = arrayList.get(arrayList.size() - 1);
        a aVar3 = aVar;
        for (int size = this.h.size() - 1; size >= 0; size--) {
            aVar3 = this.h.get(size);
            if (aVar3.b != aVar2.b) {
                break;
            }
        }
        float f = (aVar2.f5816a - aVar.f5816a) / 1000.0f;
        if (f == 0.0f) {
            f = 0.1f;
        }
        boolean z = aVar2.b >= aVar3.b;
        if (Math.abs(r1 - r6) > 270.0d) {
            z = !z;
        }
        float f2 = aVar2.b;
        float f3 = aVar.b;
        if (f2 - f3 > 180.0d) {
            aVar.b = (float) (((double) f3) + 360.0d);
        } else if (f3 - f2 > 180.0d) {
            aVar2.b = (float) (((double) f2) + 360.0d);
        }
        float fAbs = Math.abs((aVar2.b - aVar.b) / f);
        return !z ? -fAbs : fAbs;
    }

    public void g() {
        if (this.j == 0.0f) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.j *= ((PieRadarChartBase) this.e).getDragDecelerationFrictionCoef();
        T t = this.e;
        ((PieRadarChartBase) t).setRotationAngle(((PieRadarChartBase) t).getRotationAngle() + (this.j * ((jCurrentAnimationTimeMillis - this.i) / 1000.0f)));
        this.i = jCurrentAnimationTimeMillis;
        if (Math.abs(this.j) >= 0.001d) {
            s86.x(this.e);
        } else {
            k();
        }
    }

    public final void h() {
        this.h.clear();
    }

    public final void i(float f, float f2) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.h.add(new a(jCurrentAnimationTimeMillis, ((PieRadarChartBase) this.e).getAngleForPoint(f, f2)));
        for (int size = this.h.size(); size - 2 > 0 && jCurrentAnimationTimeMillis - this.h.get(0).f5816a > 1000; size--) {
            this.h.remove(0);
        }
    }

    public void j(float f, float f2) {
        this.g = ((PieRadarChartBase) this.e).getAngleForPoint(f, f2) - ((PieRadarChartBase) this.e).getRawRotationAngle();
    }

    public void k() {
        this.j = 0.0f;
    }

    public void l(float f, float f2) {
        T t = this.e;
        ((PieRadarChartBase) t).setRotationAngle(((PieRadarChartBase) t).getAngleForPoint(f, f2) - this.g);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.f5815a = ChartTouchListener.ChartGesture.LONG_PRESS;
        ((PieRadarChartBase) this.e).getOnChartGestureListener();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f5815a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        ((PieRadarChartBase) this.e).getOnChartGestureListener();
        if (!((PieRadarChartBase) this.e).isHighlightPerTapEnabled()) {
            return false;
        }
        c(((PieRadarChartBase) this.e).getHighlightByTouchPoint(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.d.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.e).isRotationEnabled()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                e(motionEvent);
                k();
                h();
                if (((PieRadarChartBase) this.e).isDragDecelerationEnabled()) {
                    i(x, y);
                }
                j(x, y);
                vb3 vb3Var = this.f;
                vb3Var.c = x;
                vb3Var.d = y;
            } else if (action == 1) {
                if (((PieRadarChartBase) this.e).isDragDecelerationEnabled()) {
                    k();
                    i(x, y);
                    float f = f();
                    this.j = f;
                    if (f != 0.0f) {
                        this.i = AnimationUtils.currentAnimationTimeMillis();
                        s86.x(this.e);
                    }
                }
                ((PieRadarChartBase) this.e).enableScroll();
                this.b = 0;
                b(motionEvent);
            } else if (action == 2) {
                if (((PieRadarChartBase) this.e).isDragDecelerationEnabled()) {
                    i(x, y);
                }
                if (this.b == 0) {
                    vb3 vb3Var2 = this.f;
                    if (ChartTouchListener.a(x, vb3Var2.c, y, vb3Var2.d) > s86.e(8.0f)) {
                        this.f5815a = ChartTouchListener.ChartGesture.ROTATE;
                        this.b = 6;
                        ((PieRadarChartBase) this.e).disableScroll();
                    } else if (this.b == 6) {
                        l(x, y);
                        ((PieRadarChartBase) this.e).invalidate();
                    }
                    b(motionEvent);
                }
            }
        }
        return true;
    }
}
