package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.XAxis;
import defpackage.ao2;
import defpackage.hi4;
import defpackage.ii4;
import defpackage.ji4;
import defpackage.s86;
import defpackage.su0;
import defpackage.vb3;
import defpackage.vh2;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class PieChart extends PieRadarChartBase<ii4> {
    private float[] mAbsoluteAngles;
    private CharSequence mCenterText;
    private vb3 mCenterTextOffset;
    private float mCenterTextRadiusPercent;
    private RectF mCircleBox;
    private float[] mDrawAngles;
    private boolean mDrawCenterText;
    private boolean mDrawEntryLabels;
    private boolean mDrawHole;
    private boolean mDrawRoundedSlices;
    private boolean mDrawSlicesUnderHole;
    private float mHoleRadiusPercent;
    protected float mMaxAngle;
    private float mMinAngleForSlices;
    protected float mTransparentCircleRadiusPercent;
    private boolean mUsePercentValues;

    public PieChart(Context context) {
        super(context);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = vb3.c(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }

    private float calcAngle(float f) {
        return calcAngle(f, ((ii4) this.mData).w());
    }

    private void calcAngles() {
        int i = ((ii4) this.mData).i();
        if (this.mDrawAngles.length != i) {
            this.mDrawAngles = new float[i];
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                this.mDrawAngles[i2] = 0.0f;
            }
        }
        if (this.mAbsoluteAngles.length != i) {
            this.mAbsoluteAngles = new float[i];
        } else {
            for (int i3 = 0; i3 < i; i3++) {
                this.mAbsoluteAngles[i3] = 0.0f;
            }
        }
        float fW = ((ii4) this.mData).w();
        List<ao2> listH = ((ii4) this.mData).h();
        float f = this.mMinAngleForSlices;
        boolean z = f != 0.0f && ((float) i) * f <= this.mMaxAngle;
        float[] fArr = new float[i];
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i4 = 0;
        for (int i5 = 0; i5 < ((ii4) this.mData).f(); i5++) {
            ao2 ao2Var = listH.get(i5);
            for (int i6 = 0; i6 < ao2Var.K0(); i6++) {
                float fCalcAngle = calcAngle(Math.abs(ao2Var.h(i6).getY()), fW);
                if (z) {
                    float f4 = this.mMinAngleForSlices;
                    float f5 = fCalcAngle - f4;
                    if (f5 <= 0.0f) {
                        fArr[i4] = f4;
                        f2 += -f5;
                    } else {
                        fArr[i4] = fCalcAngle;
                        f3 += f5;
                    }
                }
                this.mDrawAngles[i4] = fCalcAngle;
                if (i4 == 0) {
                    this.mAbsoluteAngles[i4] = fCalcAngle;
                } else {
                    float[] fArr2 = this.mAbsoluteAngles;
                    fArr2[i4] = fArr2[i4 - 1] + fCalcAngle;
                }
                i4++;
            }
        }
        if (z) {
            for (int i7 = 0; i7 < i; i7++) {
                float f6 = fArr[i7];
                float f7 = f6 - (((f6 - this.mMinAngleForSlices) / f3) * f2);
                fArr[i7] = f7;
                if (i7 == 0) {
                    this.mAbsoluteAngles[0] = fArr[0];
                } else {
                    float[] fArr3 = this.mAbsoluteAngles;
                    fArr3[i7] = fArr3[i7 - 1] + f7;
                }
            }
            this.mDrawAngles = fArr;
        }
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
        calcAngles();
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        super.calculateOffsets();
        if (this.mData == 0) {
            return;
        }
        float diameter = getDiameter() / 2.0f;
        vb3 centerOffsets = getCenterOffsets();
        float fR = ((ii4) this.mData).u().r();
        RectF rectF = this.mCircleBox;
        float f = centerOffsets.c;
        float f2 = centerOffsets.d;
        rectF.set((f - diameter) + fR, (f2 - diameter) + fR, (f + diameter) - fR, (f2 + diameter) - fR);
        vb3.f(centerOffsets);
    }

    public float[] getAbsoluteAngles() {
        return this.mAbsoluteAngles;
    }

    public vb3 getCenterCircleBox() {
        return vb3.c(this.mCircleBox.centerX(), this.mCircleBox.centerY());
    }

    public CharSequence getCenterText() {
        return this.mCenterText;
    }

    public vb3 getCenterTextOffset() {
        vb3 vb3Var = this.mCenterTextOffset;
        return vb3.c(vb3Var.c, vb3Var.d);
    }

    public float getCenterTextRadiusPercent() {
        return this.mCenterTextRadiusPercent;
    }

    public RectF getCircleBox() {
        return this.mCircleBox;
    }

    public int getDataSetIndexForIndex(int i) {
        List<ao2> listH = ((ii4) this.mData).h();
        for (int i2 = 0; i2 < listH.size(); i2++) {
            if (listH.get(i2).o0(i, Float.NaN) != null) {
                return i2;
            }
        }
        return -1;
    }

    public float[] getDrawAngles() {
        return this.mDrawAngles;
    }

    public float getHoleRadius() {
        return this.mHoleRadiusPercent;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int getIndexForAngle(float f) {
        float fQ = s86.q(f - getRotationAngle());
        int i = 0;
        while (true) {
            float[] fArr = this.mAbsoluteAngles;
            if (i >= fArr.length) {
                return -1;
            }
            if (fArr[i] > fQ) {
                return i;
            }
            i++;
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public float[] getMarkerPosition(vh2 vh2Var) {
        vb3 centerCircleBox = getCenterCircleBox();
        float radius = getRadius();
        float holeRadius = (radius / 10.0f) * 3.6f;
        if (isDrawHoleEnabled()) {
            holeRadius = (radius - ((radius / 100.0f) * getHoleRadius())) / 2.0f;
        }
        float f = radius - holeRadius;
        float rotationAngle = getRotationAngle();
        float f2 = this.mDrawAngles[(int) vh2Var.h()] / 2.0f;
        double d = f;
        float fCos = (float) ((Math.cos(Math.toRadians(((this.mAbsoluteAngles[r11] + rotationAngle) - f2) * this.mAnimator.i())) * d) + ((double) centerCircleBox.c));
        float fSin = (float) ((d * Math.sin(Math.toRadians(((rotationAngle + this.mAbsoluteAngles[r11]) - f2) * this.mAnimator.i()))) + ((double) centerCircleBox.d));
        vb3.f(centerCircleBox);
        return new float[]{fCos, fSin};
    }

    public float getMaxAngle() {
        return this.mMaxAngle;
    }

    public float getMinAngleForSlices() {
        return this.mMinAngleForSlices;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectF = this.mCircleBox;
        if (rectF == null) {
            return 0.0f;
        }
        return Math.min(rectF.width() / 2.0f, this.mCircleBox.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredBaseOffset() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRequiredLegendOffset() {
        return this.mLegendRenderer.d().getTextSize() * 2.0f;
    }

    public float getTransparentCircleRadius() {
        return this.mTransparentCircleRadiusPercent;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    @Deprecated
    public XAxis getXAxis() {
        throw new RuntimeException("PieChart has no XAxis");
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mRenderer = new hi4(this, this.mAnimator, this.mViewPortHandler);
        this.mXAxis = null;
        this.mHighlighter = new ji4(this);
    }

    public boolean isDrawCenterTextEnabled() {
        return this.mDrawCenterText;
    }

    public boolean isDrawEntryLabelsEnabled() {
        return this.mDrawEntryLabels;
    }

    public boolean isDrawHoleEnabled() {
        return this.mDrawHole;
    }

    public boolean isDrawRoundedSlicesEnabled() {
        return this.mDrawRoundedSlices;
    }

    public boolean isDrawSlicesUnderHoleEnabled() {
        return this.mDrawSlicesUnderHole;
    }

    public boolean isUsePercentValuesEnabled() {
        return this.mUsePercentValues;
    }

    public boolean needsHighlight(int i) {
        if (!valuesToHighlight()) {
            return false;
        }
        int i2 = 0;
        while (true) {
            vh2[] vh2VarArr = this.mIndicesToHighlight;
            if (i2 >= vh2VarArr.length) {
                return false;
            }
            if (((int) vh2VarArr[i2].h()) == i) {
                return true;
            }
            i2++;
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        su0 su0Var = this.mRenderer;
        if (su0Var != null && (su0Var instanceof hi4)) {
            ((hi4) su0Var).s();
        }
        super.onDetachedFromWindow();
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mData == 0) {
            return;
        }
        this.mRenderer.b(canvas);
        if (valuesToHighlight()) {
            this.mRenderer.d(canvas, this.mIndicesToHighlight);
        }
        this.mRenderer.c(canvas);
        this.mRenderer.e(canvas);
        this.mLegendRenderer.e(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
    }

    public void setCenterText(CharSequence charSequence) {
        if (charSequence == null) {
            this.mCenterText = "";
        } else {
            this.mCenterText = charSequence;
        }
    }

    public void setCenterTextColor(int i) {
        ((hi4) this.mRenderer).n().setColor(i);
    }

    public void setCenterTextOffset(float f, float f2) {
        this.mCenterTextOffset.c = s86.e(f);
        this.mCenterTextOffset.d = s86.e(f2);
    }

    public void setCenterTextRadiusPercent(float f) {
        this.mCenterTextRadiusPercent = f;
    }

    public void setCenterTextSize(float f) {
        ((hi4) this.mRenderer).n().setTextSize(s86.e(f));
    }

    public void setCenterTextSizePixels(float f) {
        ((hi4) this.mRenderer).n().setTextSize(f);
    }

    public void setCenterTextTypeface(Typeface typeface) {
        ((hi4) this.mRenderer).n().setTypeface(typeface);
    }

    public void setDrawCenterText(boolean z) {
        this.mDrawCenterText = z;
    }

    public void setDrawEntryLabels(boolean z) {
        this.mDrawEntryLabels = z;
    }

    public void setDrawHoleEnabled(boolean z) {
        this.mDrawHole = z;
    }

    public void setDrawRoundedSlices(boolean z) {
        this.mDrawRoundedSlices = z;
    }

    @Deprecated
    public void setDrawSliceText(boolean z) {
        this.mDrawEntryLabels = z;
    }

    public void setDrawSlicesUnderHole(boolean z) {
        this.mDrawSlicesUnderHole = z;
    }

    public void setEntryLabelColor(int i) {
        ((hi4) this.mRenderer).o().setColor(i);
    }

    public void setEntryLabelTextSize(float f) {
        ((hi4) this.mRenderer).o().setTextSize(s86.e(f));
    }

    public void setEntryLabelTypeface(Typeface typeface) {
        ((hi4) this.mRenderer).o().setTypeface(typeface);
    }

    public void setHoleColor(int i) {
        ((hi4) this.mRenderer).p().setColor(i);
    }

    public void setHoleRadius(float f) {
        this.mHoleRadiusPercent = f;
    }

    public void setMaxAngle(float f) {
        if (f > 360.0f) {
            f = 360.0f;
        }
        if (f < 90.0f) {
            f = 90.0f;
        }
        this.mMaxAngle = f;
    }

    public void setMinAngleForSlices(float f) {
        float f2 = this.mMaxAngle;
        if (f > f2 / 2.0f) {
            f = f2 / 2.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.mMinAngleForSlices = f;
    }

    public void setTransparentCircleAlpha(int i) {
        ((hi4) this.mRenderer).q().setAlpha(i);
    }

    public void setTransparentCircleColor(int i) {
        Paint paintQ = ((hi4) this.mRenderer).q();
        int alpha = paintQ.getAlpha();
        paintQ.setColor(i);
        paintQ.setAlpha(alpha);
    }

    public void setTransparentCircleRadius(float f) {
        this.mTransparentCircleRadiusPercent = f;
    }

    public void setUsePercentValues(boolean z) {
        this.mUsePercentValues = z;
    }

    private float calcAngle(float f, float f2) {
        return (f / f2) * this.mMaxAngle;
    }

    public PieChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = vb3.c(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }

    public PieChart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCircleBox = new RectF();
        this.mDrawEntryLabels = true;
        this.mDrawAngles = new float[1];
        this.mAbsoluteAngles = new float[1];
        this.mDrawHole = true;
        this.mDrawSlicesUnderHole = false;
        this.mUsePercentValues = false;
        this.mDrawRoundedSlices = false;
        this.mCenterText = "";
        this.mCenterTextOffset = vb3.c(0.0f, 0.0f);
        this.mHoleRadiusPercent = 50.0f;
        this.mTransparentCircleRadiusPercent = 55.0f;
        this.mDrawCenterText = true;
        this.mCenterTextRadiusPercent = 100.0f;
        this.mMaxAngle = 360.0f;
        this.mMinAngleForSlices = 0.0f;
    }
}
