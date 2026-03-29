package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.o23;
import defpackage.p23;
import defpackage.q23;
import defpackage.su0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class LineChart extends BarLineChartBase<p23> implements q23 {
    public LineChart(Context context) {
        super(context);
    }

    @Override // defpackage.q23
    public p23 getLineData() {
        return (p23) this.mData;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new o23(this, this.mAnimator, this.mViewPortHandler);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        su0 su0Var = this.mRenderer;
        if (su0Var != null && (su0Var instanceof o23)) {
            ((o23) su0Var).w();
        }
        super.onDetachedFromWindow();
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
