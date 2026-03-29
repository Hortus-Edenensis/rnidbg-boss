package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.data.Entry;
import defpackage.ai0;
import defpackage.bi0;
import defpackage.di0;
import defpackage.hz;
import defpackage.mk2;
import defpackage.np;
import defpackage.p23;
import defpackage.t25;
import defpackage.vh2;
import defpackage.vu;
import defpackage.zh0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class CombinedChart extends BarLineChartBase<ai0> implements bi0 {
    private boolean mDrawBarShadow;
    protected DrawOrder[] mDrawOrder;
    private boolean mDrawValueAboveBar;
    protected boolean mHighlightFullBarEnabled;

    /* JADX INFO: compiled from: SearchBox */
    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
        this.mDrawValueAboveBar = true;
        this.mHighlightFullBarEnabled = false;
        this.mDrawBarShadow = false;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void drawMarkers(Canvas canvas) {
        if (this.mMarker == null || !isDrawMarkersEnabled() || !valuesToHighlight()) {
            return;
        }
        int i = 0;
        while (true) {
            vh2[] vh2VarArr = this.mIndicesToHighlight;
            if (i >= vh2VarArr.length) {
                return;
            }
            vh2 vh2Var = vh2VarArr[i];
            mk2<? extends Entry> mk2VarZ = ((ai0) this.mData).z(vh2Var);
            Entry entryJ = ((ai0) this.mData).j(vh2Var);
            if (entryJ != null && mk2VarZ.b(entryJ) <= mk2VarZ.K0() * this.mAnimator.h()) {
                float[] markerPosition = getMarkerPosition(vh2Var);
                if (this.mViewPortHandler.z(markerPosition[0], markerPosition[1])) {
                    this.mMarker.refreshContent(entryJ, vh2Var);
                    this.mMarker.draw(canvas, markerPosition[0], markerPosition[1]);
                }
            }
            i++;
        }
    }

    @Override // defpackage.op
    public np getBarData() {
        T t = this.mData;
        if (t == 0) {
            return null;
        }
        return ((ai0) t).v();
    }

    @Override // defpackage.wu
    public vu getBubbleData() {
        T t = this.mData;
        if (t == 0) {
            return null;
        }
        return ((ai0) t).w();
    }

    @Override // defpackage.iz
    public hz getCandleData() {
        T t = this.mData;
        if (t == 0) {
            return null;
        }
        return ((ai0) t).x();
    }

    @Override // defpackage.bi0
    public ai0 getCombinedData() {
        return (ai0) this.mData;
    }

    public DrawOrder[] getDrawOrder() {
        return this.mDrawOrder;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public vh2 getHighlightByTouchPoint(float f, float f2) {
        if (this.mData == 0) {
            Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
            return null;
        }
        vh2 vh2VarA = getHighlighter().a(f, f2);
        return (vh2VarA == null || !isHighlightFullBarEnabled()) ? vh2VarA : new vh2(vh2VarA.h(), vh2VarA.j(), vh2VarA.i(), vh2VarA.k(), vh2VarA.d(), -1, vh2VarA.b());
    }

    @Override // defpackage.q23
    public p23 getLineData() {
        T t = this.mData;
        if (t == 0) {
            return null;
        }
        return ((ai0) t).A();
    }

    @Override // defpackage.u25
    public t25 getScatterData() {
        T t = this.mData;
        if (t == 0) {
            return null;
        }
        return ((ai0) t).B();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mDrawOrder = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new di0(this, this));
        setHighlightFullBarEnabled(true);
        this.mRenderer = new zh0(this, this.mAnimator, this.mViewPortHandler);
    }

    @Override // defpackage.op
    public boolean isDrawBarShadowEnabled() {
        return this.mDrawBarShadow;
    }

    @Override // defpackage.op
    public boolean isDrawValueAboveBarEnabled() {
        return this.mDrawValueAboveBar;
    }

    @Override // defpackage.op
    public boolean isHighlightFullBarEnabled() {
        return this.mHighlightFullBarEnabled;
    }

    public void setDrawBarShadow(boolean z) {
        this.mDrawBarShadow = z;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr == null || drawOrderArr.length <= 0) {
            return;
        }
        this.mDrawOrder = drawOrderArr;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.mDrawValueAboveBar = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.mHighlightFullBarEnabled = z;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setData(ai0 ai0Var) {
        super.setData(ai0Var);
        setHighlighter(new di0(this, this));
        ((zh0) this.mRenderer).h();
        this.mRenderer.f();
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDrawValueAboveBar = true;
        this.mHighlightFullBarEnabled = false;
        this.mDrawBarShadow = false;
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDrawValueAboveBar = true;
        this.mHighlightFullBarEnabled = false;
        this.mDrawBarShadow = false;
    }
}
