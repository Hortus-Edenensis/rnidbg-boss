package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import defpackage.lk2;
import defpackage.mp;
import defpackage.np;
import defpackage.op;
import defpackage.pp;
import defpackage.vh2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BarChart extends BarLineChartBase<np> implements op {
    private boolean mDrawBarShadow;
    private boolean mDrawValueAboveBar;
    private boolean mFitBars;
    protected boolean mHighlightFullBarEnabled;

    public BarChart(Context context) {
        super(context);
        this.mHighlightFullBarEnabled = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
        this.mFitBars = false;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
        if (this.mFitBars) {
            this.mXAxis.h(((np) this.mData).o() - (((np) this.mData).u() / 2.0f), ((np) this.mData).n() + (((np) this.mData).u() / 2.0f));
        } else {
            this.mXAxis.h(((np) this.mData).o(), ((np) this.mData).n());
        }
        YAxis yAxis = this.mAxisLeft;
        np npVar = (np) this.mData;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.h(npVar.s(axisDependency), ((np) this.mData).q(axisDependency));
        YAxis yAxis2 = this.mAxisRight;
        np npVar2 = (np) this.mData;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.h(npVar2.s(axisDependency2), ((np) this.mData).q(axisDependency2));
    }

    public RectF getBarBounds(BarEntry barEntry) {
        RectF rectF = new RectF();
        getBarBounds(barEntry, rectF);
        return rectF;
    }

    @Override // defpackage.op
    public np getBarData() {
        return (np) this.mData;
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

    public void groupBars(float f, float f2, float f3) {
        if (getBarData() == null) {
            throw new RuntimeException("You need to set data for the chart before grouping bars.");
        }
        getBarData().w(f, f2, f3);
        notifyDataSetChanged();
    }

    public void highlightValue(float f, int i, int i2) {
        highlightValue(new vh2(f, i, i2), false);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new mp(this, this.mAnimator, this.mViewPortHandler);
        setHighlighter(new pp(this));
        getXAxis().G(0.5f);
        getXAxis().F(0.5f);
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

    public void setDrawValueAboveBar(boolean z) {
        this.mDrawValueAboveBar = z;
    }

    public void setFitBars(boolean z) {
        this.mFitBars = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.mHighlightFullBarEnabled = z;
    }

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
        rectF.set(f, f3, f2, y);
        getTransformer(lk2Var.i0()).p(rectF);
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHighlightFullBarEnabled = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
        this.mFitBars = false;
    }

    public BarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHighlightFullBarEnabled = false;
        this.mDrawValueAboveBar = true;
        this.mDrawBarShadow = false;
        this.mFitBars = false;
    }
}
