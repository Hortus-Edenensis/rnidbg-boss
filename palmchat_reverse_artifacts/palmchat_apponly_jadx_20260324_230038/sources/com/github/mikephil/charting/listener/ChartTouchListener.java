package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import defpackage.vh2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ChartGesture f5815a = ChartGesture.NONE;
    public int b = 0;
    public vh2 c;
    public GestureDetector d;
    public T e;

    /* JADX INFO: compiled from: SearchBox */
    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(T t) {
        this.e = t;
        this.d = new GestureDetector(t.getContext(), this);
    }

    public static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public void b(MotionEvent motionEvent) {
        this.e.getOnChartGestureListener();
    }

    public void c(vh2 vh2Var, MotionEvent motionEvent) {
        if (vh2Var == null || vh2Var.a(this.c)) {
            this.e.highlightValue(null, true);
            this.c = null;
        } else {
            this.e.highlightValue(vh2Var, true);
            this.c = vh2Var;
        }
    }

    public void d(vh2 vh2Var) {
        this.c = vh2Var;
    }

    public void e(MotionEvent motionEvent) {
        this.e.getOnChartGestureListener();
    }
}
