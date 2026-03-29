package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.c;
import defpackage.h10;
import defpackage.kl2;
import defpackage.s86;
import defpackage.uj1;
import defpackage.vb3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class PieRadarChartBase<T extends h10<? extends kl2<? extends Entry>>> extends Chart<T> {
    protected float mMinOffset;
    private float mRawRotationAngle;
    protected boolean mRotateEnabled;
    private float mRotationAngle;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PieRadarChartBase.this.postInvalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5812a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[Legend.LegendOrientation.values().length];
            c = iArr;
            try {
                iArr[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Legend.LegendHorizontalAlignment.values().length];
            b = iArr2;
            try {
                iArr2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[Legend.LegendVerticalAlignment.values().length];
            f5812a = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5812a[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public PieRadarChartBase(Context context) {
        super(context);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007d, code lost:
    
        if (r2 != 2) goto L19;
     */
    @Override // com.github.mikephil.charting.charts.Chart
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void calculateOffsets() {
        float requiredBaseOffset;
        float requiredBaseOffset2;
        float requiredBaseOffset3;
        float fE;
        float fMin;
        float f;
        float f2;
        Legend legend = this.mLegend;
        float requiredBaseOffset4 = 0.0f;
        if (legend == null || !legend.f() || this.mLegend.C()) {
            requiredBaseOffset = 0.0f;
            requiredBaseOffset2 = 0.0f;
            requiredBaseOffset3 = 0.0f;
        } else {
            float fMin2 = Math.min(this.mLegend.x, this.mViewPortHandler.n() * this.mLegend.u());
            int i = b.c[this.mLegend.x().ordinal()];
            if (i != 1) {
                if (i == 2 && (this.mLegend.z() == Legend.LegendVerticalAlignment.TOP || this.mLegend.z() == Legend.LegendVerticalAlignment.BOTTOM)) {
                    fMin = Math.min(this.mLegend.y + getRequiredLegendOffset(), this.mViewPortHandler.m() * this.mLegend.u());
                    int i2 = b.f5812a[this.mLegend.z().ordinal()];
                    if (i2 != 1) {
                    }
                    f2 = fMin;
                    fE = 0.0f;
                    f = 0.0f;
                    requiredBaseOffset4 += getRequiredBaseOffset();
                    requiredBaseOffset = fE + getRequiredBaseOffset();
                    requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                    requiredBaseOffset2 = f + getRequiredBaseOffset();
                }
                fE = 0.0f;
                f = 0.0f;
                f2 = 0.0f;
                requiredBaseOffset4 += getRequiredBaseOffset();
                requiredBaseOffset = fE + getRequiredBaseOffset();
                requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                requiredBaseOffset2 = f + getRequiredBaseOffset();
            } else {
                if (this.mLegend.t() != Legend.LegendHorizontalAlignment.LEFT && this.mLegend.t() != Legend.LegendHorizontalAlignment.RIGHT) {
                    fE = 0.0f;
                } else if (this.mLegend.z() == Legend.LegendVerticalAlignment.CENTER) {
                    fE = fMin2 + s86.e(13.0f);
                } else {
                    fE = fMin2 + s86.e(8.0f);
                    Legend legend2 = this.mLegend;
                    float f3 = legend2.y + legend2.z;
                    vb3 center = getCenter();
                    float width = this.mLegend.t() == Legend.LegendHorizontalAlignment.RIGHT ? (getWidth() - fE) + 15.0f : fE - 15.0f;
                    float f4 = f3 + 15.0f;
                    float fDistanceToCenter = distanceToCenter(width, f4);
                    vb3 position = getPosition(center, getRadius(), getAngleForPoint(width, f4));
                    float fDistanceToCenter2 = distanceToCenter(position.c, position.d);
                    float fE2 = s86.e(5.0f);
                    if (f4 < center.d || getHeight() - fE <= getWidth()) {
                        fE = fDistanceToCenter < fDistanceToCenter2 ? fE2 + (fDistanceToCenter2 - fDistanceToCenter) : 0.0f;
                    }
                    vb3.f(center);
                    vb3.f(position);
                }
                int i3 = b.b[this.mLegend.t().ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            int i4 = b.f5812a[this.mLegend.z().ordinal()];
                            if (i4 == 1) {
                                fMin = Math.min(this.mLegend.y, this.mViewPortHandler.m() * this.mLegend.u());
                                f2 = fMin;
                                fE = 0.0f;
                                f = 0.0f;
                                requiredBaseOffset4 += getRequiredBaseOffset();
                                requiredBaseOffset = fE + getRequiredBaseOffset();
                                requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                                requiredBaseOffset2 = f + getRequiredBaseOffset();
                            } else if (i4 == 2) {
                                fMin = Math.min(this.mLegend.y, this.mViewPortHandler.m() * this.mLegend.u());
                                f = fMin;
                                fE = 0.0f;
                                f2 = 0.0f;
                                requiredBaseOffset4 += getRequiredBaseOffset();
                                requiredBaseOffset = fE + getRequiredBaseOffset();
                                requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                                requiredBaseOffset2 = f + getRequiredBaseOffset();
                            }
                        }
                    }
                    f = 0.0f;
                    f2 = 0.0f;
                    requiredBaseOffset4 += getRequiredBaseOffset();
                    requiredBaseOffset = fE + getRequiredBaseOffset();
                    requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                    requiredBaseOffset2 = f + getRequiredBaseOffset();
                } else {
                    requiredBaseOffset4 = fE;
                }
                fE = 0.0f;
                f = 0.0f;
                f2 = 0.0f;
                requiredBaseOffset4 += getRequiredBaseOffset();
                requiredBaseOffset = fE + getRequiredBaseOffset();
                requiredBaseOffset3 = f2 + getRequiredBaseOffset();
                requiredBaseOffset2 = f + getRequiredBaseOffset();
            }
        }
        float fE3 = s86.e(this.mMinOffset);
        if (this instanceof RadarChart) {
            XAxis xAxis = getXAxis();
            if (xAxis.f() && xAxis.z()) {
                fE3 = Math.max(fE3, xAxis.L);
            }
        }
        float extraTopOffset = requiredBaseOffset3 + getExtraTopOffset();
        float extraRightOffset = requiredBaseOffset + getExtraRightOffset();
        float extraBottomOffset = requiredBaseOffset2 + getExtraBottomOffset();
        float fMax = Math.max(fE3, requiredBaseOffset4 + getExtraLeftOffset());
        float fMax2 = Math.max(fE3, extraTopOffset);
        float fMax3 = Math.max(fE3, extraRightOffset);
        float fMax4 = Math.max(fE3, Math.max(getRequiredBaseOffset(), extraBottomOffset));
        this.mViewPortHandler.N(fMax, fMax2, fMax3, fMax4);
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "offsetLeft: " + fMax + ", offsetTop: " + fMax2 + ", offsetRight: " + fMax3 + ", offsetBottom: " + fMax4);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener instanceof c) {
            ((c) chartTouchListener).g();
        }
    }

    public float distanceToCenter(float f, float f2) {
        vb3 centerOffsets = getCenterOffsets();
        float f3 = centerOffsets.c;
        float fSqrt = (float) Math.sqrt(Math.pow(f > f3 ? f - f3 : f3 - f, 2.0d) + Math.pow(f2 > centerOffsets.d ? f2 - r1 : r1 - f2, 2.0d));
        vb3.f(centerOffsets);
        return fSqrt;
    }

    public float getAngleForPoint(float f, float f2) {
        vb3 centerOffsets = getCenterOffsets();
        double d = f - centerOffsets.c;
        double d2 = f2 - centerOffsets.d;
        float degrees = (float) Math.toDegrees(Math.acos(d2 / Math.sqrt((d * d) + (d2 * d2))));
        if (f > centerOffsets.c) {
            degrees = 360.0f - degrees;
        }
        float f3 = degrees + 90.0f;
        if (f3 > 360.0f) {
            f3 -= 360.0f;
        }
        vb3.f(centerOffsets);
        return f3;
    }

    public float getDiameter() {
        RectF rectFP = this.mViewPortHandler.p();
        rectFP.left += getExtraLeftOffset();
        rectFP.top += getExtraTopOffset();
        rectFP.right -= getExtraRightOffset();
        rectFP.bottom -= getExtraBottomOffset();
        return Math.min(rectFP.width(), rectFP.height());
    }

    public abstract int getIndexForAngle(float f);

    @Override // com.github.mikephil.charting.charts.Chart, defpackage.j10
    public int getMaxVisibleCount() {
        return this.mData.i();
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public vb3 getPosition(vb3 vb3Var, float f, float f2) {
        vb3 vb3VarC = vb3.c(0.0f, 0.0f);
        getPosition(vb3Var, f, f2, vb3VarC);
        return vb3VarC;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.mRawRotationAngle;
    }

    public abstract float getRequiredBaseOffset();

    public abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.mRotationAngle;
    }

    @Override // com.github.mikephil.charting.charts.Chart, defpackage.j10
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart, defpackage.j10
    public float getYChartMin() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mChartTouchListener = new c(this);
    }

    public boolean isRotationEnabled() {
        return this.mRotateEnabled;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData == null) {
            return;
        }
        calcMinMax();
        if (this.mLegend != null) {
            this.mLegendRenderer.a(this.mData);
        }
        calculateOffsets();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ChartTouchListener chartTouchListener;
        return (!this.mTouchEnabled || (chartTouchListener = this.mChartTouchListener) == null) ? super.onTouchEvent(motionEvent) : chartTouchListener.onTouch(this, motionEvent);
    }

    public void setMinOffset(float f) {
        this.mMinOffset = f;
    }

    public void setRotationAngle(float f) {
        this.mRawRotationAngle = f;
        this.mRotationAngle = s86.q(f);
    }

    public void setRotationEnabled(boolean z) {
        this.mRotateEnabled = z;
    }

    @SuppressLint({"NewApi"})
    public void spin(int i, float f, float f2, uj1.c0 c0Var) {
        setRotationAngle(f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "rotationAngle", f, f2);
        objectAnimatorOfFloat.setDuration(i);
        objectAnimatorOfFloat.setInterpolator(c0Var);
        objectAnimatorOfFloat.addUpdateListener(new a());
        objectAnimatorOfFloat.start();
    }

    public void getPosition(vb3 vb3Var, float f, float f2, vb3 vb3Var2) {
        double d = f;
        double d2 = f2;
        vb3Var2.c = (float) (((double) vb3Var.c) + (Math.cos(Math.toRadians(d2)) * d));
        vb3Var2.d = (float) (((double) vb3Var.d) + (d * Math.sin(Math.toRadians(d2))));
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
    }
}
