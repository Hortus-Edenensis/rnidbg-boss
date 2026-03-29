package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import defpackage.fp6;
import defpackage.h16;
import defpackage.i16;
import defpackage.lk2;
import defpackage.np;
import defpackage.pi2;
import defpackage.qi2;
import defpackage.s86;
import defpackage.ti2;
import defpackage.vb3;
import defpackage.vh2;
import defpackage.vo6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class HorizontalBarChart extends BarChart {
    protected float[] mGetPositionBuffer;
    private RectF mOffsetsBuffer;

    public HorizontalBarChart(Context context) {
        super(context);
        this.mOffsetsBuffer = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        calculateLegendOffsets(this.mOffsetsBuffer);
        RectF rectF = this.mOffsetsBuffer;
        float f = rectF.left + 0.0f;
        float fL = rectF.top + 0.0f;
        float f2 = rectF.right + 0.0f;
        float fL2 = rectF.bottom + 0.0f;
        if (this.mAxisLeft.V()) {
            fL += this.mAxisLeft.L(this.mAxisRendererLeft.c());
        }
        if (this.mAxisRight.V()) {
            fL2 += this.mAxisRight.L(this.mAxisRendererRight.c());
        }
        XAxis xAxis = this.mXAxis;
        float f3 = xAxis.L;
        if (xAxis.f()) {
            if (this.mXAxis.I() == XAxis.XAxisPosition.BOTTOM) {
                f += f3;
            } else if (this.mXAxis.I() == XAxis.XAxisPosition.TOP) {
                f2 += f3;
            } else if (this.mXAxis.I() == XAxis.XAxisPosition.BOTH_SIDED) {
                f += f3;
                f2 += f3;
            }
        }
        float extraTopOffset = fL + getExtraTopOffset();
        float extraRightOffset = f2 + getExtraRightOffset();
        float extraBottomOffset = fL2 + getExtraBottomOffset();
        float extraLeftOffset = f + getExtraLeftOffset();
        float fE = s86.e(this.mMinOffset);
        this.mViewPortHandler.N(Math.max(fE, extraLeftOffset), Math.max(fE, extraTopOffset), Math.max(fE, extraRightOffset), Math.max(fE, extraBottomOffset));
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb = new StringBuilder();
            sb.append("Content: ");
            sb.append(this.mViewPortHandler.p().toString());
            Log.i(Chart.LOG_TAG, sb.toString());
        }
        prepareOffsetMatrix();
        prepareValuePxMatrix();
    }

    @Override // com.github.mikephil.charting.charts.BarChart
    public void getBarBounds(BarEntry barEntry, RectF rectF) {
        lk2 lk2Var = (lk2) ((np) this.mData).g(barEntry);
        if (lk2Var == null) {
            rectF.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
            return;
        }
        float y = barEntry.getY();
        float x = barEntry.getX();
        float fU = ((np) this.mData).u() / 2.0f;
        float f = x - fU;
        float f2 = x + fU;
        float f3 = y >= 0.0f ? y : 0.0f;
        if (y > 0.0f) {
            y = 0.0f;
        }
        rectF.set(f3, f, y, f2);
        getTransformer(lk2Var.i0()).p(rectF);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, defpackage.rp
    public float getHighestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).h(this.mViewPortHandler.h(), this.mViewPortHandler.j(), this.posForGetHighestVisibleX);
        return (float) Math.min(this.mXAxis.G, this.posForGetHighestVisibleX.d);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public vh2 getHighlightByTouchPoint(float f, float f2) {
        if (this.mData != 0) {
            return getHighlighter().a(f2, f);
        }
        if (!this.mLogEnabled) {
            return null;
        }
        Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
        return null;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, defpackage.rp
    public float getLowestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).h(this.mViewPortHandler.h(), this.mViewPortHandler.f(), this.posForGetLowestVisibleX);
        return (float) Math.max(this.mXAxis.H, this.posForGetLowestVisibleX.d);
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public float[] getMarkerPosition(vh2 vh2Var) {
        return new float[]{vh2Var.f(), vh2Var.e()};
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public vb3 getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = this.mGetPositionBuffer;
        fArr[0] = entry.getY();
        fArr[1] = entry.getX();
        getTransformer(axisDependency).k(fArr);
        return vb3.c(fArr[0], fArr[1]);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        this.mViewPortHandler = new ti2();
        super.init();
        this.mLeftAxisTransformer = new i16(this.mViewPortHandler);
        this.mRightAxisTransformer = new i16(this.mViewPortHandler);
        this.mRenderer = new pi2(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new qi2(this));
        this.mAxisRendererLeft = new fp6(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new fp6(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new vo6(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer, this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void prepareValuePxMatrix() {
        h16 h16Var = this.mRightAxisTransformer;
        YAxis yAxis = this.mAxisRight;
        float f = yAxis.H;
        float f2 = yAxis.I;
        XAxis xAxis = this.mXAxis;
        h16Var.m(f, f2, xAxis.I, xAxis.H);
        h16 h16Var2 = this.mLeftAxisTransformer;
        YAxis yAxis2 = this.mAxisLeft;
        float f3 = yAxis2.H;
        float f4 = yAxis2.I;
        XAxis xAxis2 = this.mXAxis;
        h16Var2.m(f3, f4, xAxis2.I, xAxis2.H);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRange(float f, float f2) {
        float f3 = this.mXAxis.I;
        this.mViewPortHandler.U(f3 / f, f3 / f2);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMaximum(float f) {
        this.mViewPortHandler.W(this.mXAxis.I / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMinimum(float f) {
        this.mViewPortHandler.S(this.mXAxis.I / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRange(float f, float f2, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.T(getAxisRange(axisDependency) / f, getAxisRange(axisDependency) / f2);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRangeMaximum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.V(getAxisRange(axisDependency) / f);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleYRangeMinimum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.R(getAxisRange(axisDependency) / f);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOffsetsBuffer = new RectF();
        this.mGetPositionBuffer = new float[2];
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOffsetsBuffer = new RectF();
        this.mGetPositionBuffer = new float[2];
    }
}
