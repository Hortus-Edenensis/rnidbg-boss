package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import defpackage.gp6;
import defpackage.hs4;
import defpackage.is4;
import defpackage.js4;
import defpackage.s86;
import defpackage.wo6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class RadarChart extends PieRadarChartBase<is4> {
    private boolean mDrawWeb;
    private float mInnerWebLineWidth;
    private int mSkipWebLineCount;
    private int mWebAlpha;
    private int mWebColor;
    private int mWebColorInner;
    private float mWebLineWidth;
    protected wo6 mXAxisRenderer;
    private YAxis mYAxis;
    protected gp6 mYAxisRenderer;

    public RadarChart(Context context) {
        super(context);
        this.mWebLineWidth = 2.5f;
        this.mInnerWebLineWidth = 1.5f;
        this.mWebColor = Color.rgb(122, 122, 122);
        this.mWebColorInner = Color.rgb(122, 122, 122);
        this.mWebAlpha = 150;
        this.mDrawWeb = true;
        this.mSkipWebLineCount = 0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
        super.calcMinMax();
        YAxis yAxis = this.mYAxis;
        is4 is4Var = (is4) this.mData;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.h(is4Var.s(axisDependency), ((is4) this.mData).q(axisDependency));
        this.mXAxis.h(0.0f, ((is4) this.mData).m().K0());
    }

    public float getFactor() {
        RectF rectFP = this.mViewPortHandler.p();
        return Math.min(rectFP.width() / 2.0f, rectFP.height() / 2.0f) / this.mYAxis.I;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f) {
        float fQ = s86.q(f - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int iK0 = ((is4) this.mData).m().K0();
        int i = 0;
        while (i < iK0) {
            int i2 = i + 1;
            if ((i2 * sliceAngle) - (sliceAngle / 2.0f) > fQ) {
                return i;
            }
            i = i2;
        }
        return 0;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectFP = this.mViewPortHandler.p();
        return Math.min(rectFP.width() / 2.0f, rectFP.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredBaseOffset() {
        return (this.mXAxis.f() && this.mXAxis.z()) ? this.mXAxis.L : s86.e(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredLegendOffset() {
        return this.mLegendRenderer.d().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.mSkipWebLineCount;
    }

    public float getSliceAngle() {
        return 360.0f / ((is4) this.mData).m().K0();
    }

    public int getWebAlpha() {
        return this.mWebAlpha;
    }

    public int getWebColor() {
        return this.mWebColor;
    }

    public int getWebColorInner() {
        return this.mWebColorInner;
    }

    public float getWebLineWidth() {
        return this.mWebLineWidth;
    }

    public float getWebLineWidthInner() {
        return this.mInnerWebLineWidth;
    }

    public YAxis getYAxis() {
        return this.mYAxis;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart, defpackage.j10
    public float getYChartMax() {
        return this.mYAxis.G;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart, defpackage.j10
    public float getYChartMin() {
        return this.mYAxis.H;
    }

    public float getYRange() {
        return this.mYAxis.I;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mYAxis = new YAxis(YAxis.AxisDependency.LEFT);
        this.mWebLineWidth = s86.e(1.5f);
        this.mInnerWebLineWidth = s86.e(0.75f);
        this.mRenderer = new hs4(this, this.mAnimator, this.mViewPortHandler);
        this.mYAxisRenderer = new gp6(this.mViewPortHandler, this.mYAxis, this);
        this.mXAxisRenderer = new wo6(this.mViewPortHandler, this.mXAxis, this);
        this.mHighlighter = new js4(this);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData == 0) {
            return;
        }
        calcMinMax();
        gp6 gp6Var = this.mYAxisRenderer;
        YAxis yAxis = this.mYAxis;
        gp6Var.a(yAxis.H, yAxis.G, yAxis.U());
        wo6 wo6Var = this.mXAxisRenderer;
        XAxis xAxis = this.mXAxis;
        wo6Var.a(xAxis.H, xAxis.G, false);
        Legend legend = this.mLegend;
        if (legend != null && !legend.D()) {
            this.mLegendRenderer.a(this.mData);
        }
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == 0) {
            return;
        }
        if (this.mXAxis.f()) {
            wo6 wo6Var = this.mXAxisRenderer;
            XAxis xAxis = this.mXAxis;
            wo6Var.a(xAxis.H, xAxis.G, false);
        }
        this.mXAxisRenderer.i(canvas);
        if (this.mDrawWeb) {
            this.mRenderer.c(canvas);
        }
        if (this.mYAxis.f() && this.mYAxis.A()) {
            this.mYAxisRenderer.l(canvas);
        }
        this.mRenderer.b(canvas);
        if (valuesToHighlight()) {
            this.mRenderer.d(canvas, this.mIndicesToHighlight);
        }
        if (this.mYAxis.f() && !this.mYAxis.A()) {
            this.mYAxisRenderer.l(canvas);
        }
        this.mYAxisRenderer.i(canvas);
        this.mRenderer.e(canvas);
        this.mLegendRenderer.e(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
    }

    public void setDrawWeb(boolean z) {
        this.mDrawWeb = z;
    }

    public void setSkipWebLineCount(int i) {
        this.mSkipWebLineCount = Math.max(0, i);
    }

    public void setWebAlpha(int i) {
        this.mWebAlpha = i;
    }

    public void setWebColor(int i) {
        this.mWebColor = i;
    }

    public void setWebColorInner(int i) {
        this.mWebColorInner = i;
    }

    public void setWebLineWidth(float f) {
        this.mWebLineWidth = s86.e(f);
    }

    public void setWebLineWidthInner(float f) {
        this.mInnerWebLineWidth = s86.e(f);
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWebLineWidth = 2.5f;
        this.mInnerWebLineWidth = 1.5f;
        this.mWebColor = Color.rgb(122, 122, 122);
        this.mWebColorInner = Color.rgb(122, 122, 122);
        this.mWebAlpha = 150;
        this.mDrawWeb = true;
        this.mSkipWebLineCount = 0;
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWebLineWidth = 2.5f;
        this.mInnerWebLineWidth = 1.5f;
        this.mWebColor = Color.rgb(122, 122, 122);
        this.mWebColorInner = Color.rgb(122, 122, 122);
        this.mWebAlpha = 150;
        this.mDrawWeb = true;
        this.mSkipWebLineCount = 0;
    }
}
