package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import defpackage.hz;
import defpackage.iz;
import defpackage.jz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class CandleStickChart extends BarLineChartBase<hz> implements iz {
    public CandleStickChart(Context context) {
        super(context);
    }

    @Override // defpackage.iz
    public hz getCandleData() {
        return (hz) this.mData;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new jz(this, this.mAnimator, this.mViewPortHandler);
        getXAxis().G(0.5f);
        getXAxis().F(0.5f);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
