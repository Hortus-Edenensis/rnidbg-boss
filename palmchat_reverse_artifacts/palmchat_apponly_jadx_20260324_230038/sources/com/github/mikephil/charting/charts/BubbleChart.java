package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.uu;
import defpackage.vu;
import defpackage.wu;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class BubbleChart extends BarLineChartBase<vu> implements wu {
    public BubbleChart(Context context) {
        super(context);
    }

    @Override // defpackage.wu
    public vu getBubbleData() {
        return (vu) this.mData;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new uu(this, this.mAnimator, this.mViewPortHandler);
    }

    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
