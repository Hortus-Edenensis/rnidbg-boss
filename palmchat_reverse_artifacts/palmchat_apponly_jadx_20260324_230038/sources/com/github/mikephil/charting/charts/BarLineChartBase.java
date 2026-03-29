package com.github.mikephil.charting.charts;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import defpackage.ee;
import defpackage.ep6;
import defpackage.h16;
import defpackage.hr3;
import defpackage.i10;
import defpackage.ir6;
import defpackage.mk2;
import defpackage.nf6;
import defpackage.qp;
import defpackage.rp;
import defpackage.s86;
import defpackage.su0;
import defpackage.u64;
import defpackage.ub3;
import defpackage.uo6;
import defpackage.vb3;
import defpackage.vh2;
import defpackage.zd;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@SuppressLint({"RtlHardcoded"})
public abstract class BarLineChartBase<T extends qp<? extends mk2<? extends Entry>>> extends Chart<T> implements rp {
    private long drawCycles;
    protected boolean mAutoScaleMinMaxEnabled;
    protected YAxis mAxisLeft;
    protected ep6 mAxisRendererLeft;
    protected ep6 mAxisRendererRight;
    protected YAxis mAxisRight;
    protected Paint mBorderPaint;
    protected boolean mClipValuesToContent;
    private boolean mCustomViewPortEnabled;
    protected boolean mDoubleTapToZoomEnabled;
    private boolean mDragXEnabled;
    private boolean mDragYEnabled;
    protected boolean mDrawBorders;
    protected boolean mDrawGridBackground;
    protected u64 mDrawListener;
    protected Matrix mFitScreenMatrixBuffer;
    protected float[] mGetPositionBuffer;
    protected Paint mGridBackgroundPaint;
    protected boolean mHighlightPerDragEnabled;
    protected boolean mKeepPositionOnRotation;
    protected h16 mLeftAxisTransformer;
    protected int mMaxVisibleCount;
    protected float mMinOffset;
    private RectF mOffsetsBuffer;
    protected float[] mOnSizeChangedBuffer;
    protected boolean mPinchZoomEnabled;
    protected h16 mRightAxisTransformer;
    private boolean mScaleXEnabled;
    private boolean mScaleYEnabled;
    protected uo6 mXAxisRenderer;
    protected Matrix mZoomMatrixBuffer;
    protected ub3 posForGetHighestVisibleX;
    protected ub3 posForGetLowestVisibleX;
    private long totalTime;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f5807a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;

        public a(float f, float f2, float f3, float f4) {
            this.f5807a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        @Override // java.lang.Runnable
        public void run() {
            BarLineChartBase.this.mViewPortHandler.N(this.f5807a, this.b, this.c, this.d);
            BarLineChartBase.this.prepareOffsetMatrix();
            BarLineChartBase.this.prepareValuePxMatrix();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5808a;
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
            f5808a = iArr3;
            try {
                iArr3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5808a[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragXEnabled = true;
        this.mDragYEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mDrawGridBackground = false;
        this.mDrawBorders = false;
        this.mClipValuesToContent = false;
        this.mMinOffset = 15.0f;
        this.mKeepPositionOnRotation = false;
        this.totalTime = 0L;
        this.drawCycles = 0L;
        this.mOffsetsBuffer = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        this.mFitScreenMatrixBuffer = new Matrix();
        this.mCustomViewPortEnabled = false;
        this.mGetPositionBuffer = new float[2];
        this.posForGetLowestVisibleX = ub3.b(0.0d, 0.0d);
        this.posForGetHighestVisibleX = ub3.b(0.0d, 0.0d);
        this.mOnSizeChangedBuffer = new float[2];
    }

    public void autoScale() {
        ((qp) this.mData).c(getLowestVisibleX(), getHighestVisibleX());
        this.mXAxis.h(((qp) this.mData).o(), ((qp) this.mData).n());
        if (this.mAxisLeft.f()) {
            YAxis yAxis = this.mAxisLeft;
            qp qpVar = (qp) this.mData;
            YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
            yAxis.h(qpVar.s(axisDependency), ((qp) this.mData).q(axisDependency));
        }
        if (this.mAxisRight.f()) {
            YAxis yAxis2 = this.mAxisRight;
            qp qpVar2 = (qp) this.mData;
            YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
            yAxis2.h(qpVar2.s(axisDependency2), ((qp) this.mData).q(axisDependency2));
        }
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void calcMinMax() {
        this.mXAxis.h(((qp) this.mData).o(), ((qp) this.mData).n());
        YAxis yAxis = this.mAxisLeft;
        qp qpVar = (qp) this.mData;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.h(qpVar.s(axisDependency), ((qp) this.mData).q(axisDependency));
        YAxis yAxis2 = this.mAxisRight;
        qp qpVar2 = (qp) this.mData;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.h(qpVar2.s(axisDependency2), ((qp) this.mData).q(axisDependency2));
    }

    public void calculateLegendOffsets(RectF rectF) {
        rectF.left = 0.0f;
        rectF.right = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = 0.0f;
        Legend legend = this.mLegend;
        if (legend == null || !legend.f() || this.mLegend.C()) {
            return;
        }
        int i = b.c[this.mLegend.x().ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            int i2 = b.f5808a[this.mLegend.z().ordinal()];
            if (i2 == 1) {
                rectF.top += Math.min(this.mLegend.y, this.mViewPortHandler.m() * this.mLegend.u()) + this.mLegend.e();
                return;
            } else {
                if (i2 != 2) {
                    return;
                }
                rectF.bottom += Math.min(this.mLegend.y, this.mViewPortHandler.m() * this.mLegend.u()) + this.mLegend.e();
                return;
            }
        }
        int i3 = b.b[this.mLegend.t().ordinal()];
        if (i3 == 1) {
            rectF.left += Math.min(this.mLegend.x, this.mViewPortHandler.n() * this.mLegend.u()) + this.mLegend.d();
            return;
        }
        if (i3 == 2) {
            rectF.right += Math.min(this.mLegend.x, this.mViewPortHandler.n() * this.mLegend.u()) + this.mLegend.d();
            return;
        }
        if (i3 != 3) {
            return;
        }
        int i4 = b.f5808a[this.mLegend.z().ordinal()];
        if (i4 == 1) {
            rectF.top += Math.min(this.mLegend.y, this.mViewPortHandler.m() * this.mLegend.u()) + this.mLegend.e();
        } else {
            if (i4 != 2) {
                return;
            }
            rectF.bottom += Math.min(this.mLegend.y, this.mViewPortHandler.m() * this.mLegend.u()) + this.mLegend.e();
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        if (!this.mCustomViewPortEnabled) {
            calculateLegendOffsets(this.mOffsetsBuffer);
            RectF rectF = this.mOffsetsBuffer;
            float fM = rectF.left + 0.0f;
            float f = rectF.top + 0.0f;
            float fM2 = rectF.right + 0.0f;
            float f2 = rectF.bottom + 0.0f;
            if (this.mAxisLeft.V()) {
                fM += this.mAxisLeft.M(this.mAxisRendererLeft.c());
            }
            if (this.mAxisRight.V()) {
                fM2 += this.mAxisRight.M(this.mAxisRendererRight.c());
            }
            if (this.mXAxis.f() && this.mXAxis.z()) {
                float fE = r2.M + this.mXAxis.e();
                if (this.mXAxis.I() == XAxis.XAxisPosition.BOTTOM) {
                    f2 += fE;
                } else if (this.mXAxis.I() == XAxis.XAxisPosition.TOP) {
                    f += fE;
                } else if (this.mXAxis.I() == XAxis.XAxisPosition.BOTH_SIDED) {
                    f2 += fE;
                    f += fE;
                }
            }
            float extraTopOffset = f + getExtraTopOffset();
            float extraRightOffset = fM2 + getExtraRightOffset();
            float extraBottomOffset = f2 + getExtraBottomOffset();
            float extraLeftOffset = fM + getExtraLeftOffset();
            float fE2 = s86.e(this.mMinOffset);
            this.mViewPortHandler.N(Math.max(fE2, extraLeftOffset), Math.max(fE2, extraTopOffset), Math.max(fE2, extraRightOffset), Math.max(fE2, extraBottomOffset));
            if (this.mLogEnabled) {
                Log.i(Chart.LOG_TAG, "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
                StringBuilder sb = new StringBuilder();
                sb.append("Content: ");
                sb.append(this.mViewPortHandler.p().toString());
                Log.i(Chart.LOG_TAG, sb.toString());
            }
        }
        prepareOffsetMatrix();
        prepareValuePxMatrix();
    }

    public void centerViewTo(float f, float f2, YAxis.AxisDependency axisDependency) {
        float axisRange = getAxisRange(axisDependency) / this.mViewPortHandler.s();
        addViewportJob(hr3.b(this.mViewPortHandler, f - ((getXAxis().I / this.mViewPortHandler.r()) / 2.0f), f2 + (axisRange / 2.0f), getTransformer(axisDependency), this));
    }

    @TargetApi(11)
    public void centerViewToAnimated(float f, float f2, YAxis.AxisDependency axisDependency, long j) {
        ub3 valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.h(), this.mViewPortHandler.j(), axisDependency);
        float axisRange = getAxisRange(axisDependency) / this.mViewPortHandler.s();
        addViewportJob(zd.d(this.mViewPortHandler, f - ((getXAxis().I / this.mViewPortHandler.r()) / 2.0f), f2 + (axisRange / 2.0f), getTransformer(axisDependency), this, (float) valuesByTouchPoint.c, (float) valuesByTouchPoint.d, j));
        ub3.c(valuesByTouchPoint);
    }

    public void centerViewToY(float f, YAxis.AxisDependency axisDependency) {
        addViewportJob(hr3.b(this.mViewPortHandler, 0.0f, f + ((getAxisRange(axisDependency) / this.mViewPortHandler.s()) / 2.0f), getTransformer(axisDependency), this));
    }

    @Override // android.view.View
    public void computeScroll() {
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener instanceof com.github.mikephil.charting.listener.a) {
            ((com.github.mikephil.charting.listener.a) chartTouchListener).f();
        }
    }

    public void drawGridBackground(Canvas canvas) {
        if (this.mDrawGridBackground) {
            canvas.drawRect(this.mViewPortHandler.p(), this.mGridBackgroundPaint);
        }
        if (this.mDrawBorders) {
            canvas.drawRect(this.mViewPortHandler.p(), this.mBorderPaint);
        }
    }

    public void fitScreen() {
        Matrix matrix = this.mFitScreenMatrixBuffer;
        this.mViewPortHandler.l(matrix);
        this.mViewPortHandler.L(matrix, this, false);
        calculateOffsets();
        postInvalidate();
    }

    public YAxis getAxis(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.mAxisLeft : this.mAxisRight;
    }

    public YAxis getAxisLeft() {
        return this.mAxisLeft;
    }

    public float getAxisRange(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.mAxisLeft.I : this.mAxisRight.I;
    }

    public YAxis getAxisRight() {
        return this.mAxisRight;
    }

    @Override // com.github.mikephil.charting.charts.Chart, defpackage.j10, defpackage.rp
    public /* bridge */ /* synthetic */ qp getData() {
        return (qp) super.getData();
    }

    public mk2 getDataSetByTouchPoint(float f, float f2) {
        vh2 highlightByTouchPoint = getHighlightByTouchPoint(f, f2);
        if (highlightByTouchPoint != null) {
            return (mk2) ((qp) this.mData).e(highlightByTouchPoint.d());
        }
        return null;
    }

    public u64 getDrawListener() {
        return null;
    }

    public Entry getEntryByTouchPoint(float f, float f2) {
        vh2 highlightByTouchPoint = getHighlightByTouchPoint(f, f2);
        if (highlightByTouchPoint != null) {
            return ((qp) this.mData).j(highlightByTouchPoint);
        }
        return null;
    }

    @Override // defpackage.rp
    public float getHighestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).h(this.mViewPortHandler.i(), this.mViewPortHandler.f(), this.posForGetHighestVisibleX);
        return (float) Math.min(this.mXAxis.G, this.posForGetHighestVisibleX.c);
    }

    @Override // defpackage.rp
    public float getLowestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).h(this.mViewPortHandler.h(), this.mViewPortHandler.f(), this.posForGetLowestVisibleX);
        return (float) Math.max(this.mXAxis.H, this.posForGetLowestVisibleX.c);
    }

    @Override // com.github.mikephil.charting.charts.Chart, defpackage.j10
    public int getMaxVisibleCount() {
        return this.mMaxVisibleCount;
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Paint getPaint(int i) {
        Paint paint = super.getPaint(i);
        if (paint != null) {
            return paint;
        }
        if (i != 4) {
            return null;
        }
        return this.mGridBackgroundPaint;
    }

    public ub3 getPixelForValues(float f, float f2, YAxis.AxisDependency axisDependency) {
        return getTransformer(axisDependency).e(f, f2);
    }

    public vb3 getPosition(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        this.mGetPositionBuffer[0] = entry.getX();
        this.mGetPositionBuffer[1] = entry.getY();
        getTransformer(axisDependency).k(this.mGetPositionBuffer);
        float[] fArr = this.mGetPositionBuffer;
        return vb3.c(fArr[0], fArr[1]);
    }

    public ep6 getRendererLeftYAxis() {
        return this.mAxisRendererLeft;
    }

    public ep6 getRendererRightYAxis() {
        return this.mAxisRendererRight;
    }

    public uo6 getRendererXAxis() {
        return this.mXAxisRenderer;
    }

    @Override // android.view.View
    public float getScaleX() {
        nf6 nf6Var = this.mViewPortHandler;
        if (nf6Var == null) {
            return 1.0f;
        }
        return nf6Var.r();
    }

    @Override // android.view.View
    public float getScaleY() {
        nf6 nf6Var = this.mViewPortHandler;
        if (nf6Var == null) {
            return 1.0f;
        }
        return nf6Var.s();
    }

    @Override // defpackage.rp
    public h16 getTransformer(YAxis.AxisDependency axisDependency) {
        return axisDependency == YAxis.AxisDependency.LEFT ? this.mLeftAxisTransformer : this.mRightAxisTransformer;
    }

    public ub3 getValuesByTouchPoint(float f, float f2, YAxis.AxisDependency axisDependency) {
        ub3 ub3VarB = ub3.b(0.0d, 0.0d);
        getValuesByTouchPoint(f, f2, axisDependency, ub3VarB);
        return ub3VarB;
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // com.github.mikephil.charting.charts.Chart, defpackage.j10
    public float getYChartMax() {
        return Math.max(this.mAxisLeft.G, this.mAxisRight.G);
    }

    @Override // com.github.mikephil.charting.charts.Chart, defpackage.j10
    public float getYChartMin() {
        return Math.min(this.mAxisLeft.H, this.mAxisRight.H);
    }

    public boolean hasNoDragOffset() {
        return this.mViewPortHandler.v();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void init() {
        super.init();
        this.mAxisLeft = new YAxis(YAxis.AxisDependency.LEFT);
        this.mAxisRight = new YAxis(YAxis.AxisDependency.RIGHT);
        this.mLeftAxisTransformer = new h16(this.mViewPortHandler);
        this.mRightAxisTransformer = new h16(this.mViewPortHandler);
        this.mAxisRendererLeft = new ep6(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new ep6(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new uo6(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer);
        setHighlighter(new i10(this));
        this.mChartTouchListener = new com.github.mikephil.charting.listener.a(this, this.mViewPortHandler.q(), 3.0f);
        Paint paint = new Paint();
        this.mGridBackgroundPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mGridBackgroundPaint.setColor(Color.rgb(240, 240, 240));
        Paint paint2 = new Paint();
        this.mBorderPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(-16777216);
        this.mBorderPaint.setStrokeWidth(s86.e(1.0f));
    }

    public boolean isAnyAxisInverted() {
        return this.mAxisLeft.U() || this.mAxisRight.U();
    }

    public boolean isAutoScaleMinMaxEnabled() {
        return this.mAutoScaleMinMaxEnabled;
    }

    public boolean isClipValuesToContentEnabled() {
        return this.mClipValuesToContent;
    }

    public boolean isDoubleTapToZoomEnabled() {
        return this.mDoubleTapToZoomEnabled;
    }

    public boolean isDragEnabled() {
        return this.mDragXEnabled || this.mDragYEnabled;
    }

    public boolean isDragXEnabled() {
        return this.mDragXEnabled;
    }

    public boolean isDragYEnabled() {
        return this.mDragYEnabled;
    }

    public boolean isDrawBordersEnabled() {
        return this.mDrawBorders;
    }

    public boolean isFullyZoomedOut() {
        return this.mViewPortHandler.w();
    }

    public boolean isHighlightPerDragEnabled() {
        return this.mHighlightPerDragEnabled;
    }

    @Override // defpackage.rp
    public boolean isInverted(YAxis.AxisDependency axisDependency) {
        return getAxis(axisDependency).U();
    }

    public boolean isKeepPositionOnRotation() {
        return this.mKeepPositionOnRotation;
    }

    public boolean isPinchZoomEnabled() {
        return this.mPinchZoomEnabled;
    }

    public boolean isScaleXEnabled() {
        return this.mScaleXEnabled;
    }

    public boolean isScaleYEnabled() {
        return this.mScaleYEnabled;
    }

    public void moveViewTo(float f, float f2, YAxis.AxisDependency axisDependency) {
        addViewportJob(hr3.b(this.mViewPortHandler, f, f2 + ((getAxisRange(axisDependency) / this.mViewPortHandler.s()) / 2.0f), getTransformer(axisDependency), this));
    }

    @TargetApi(11)
    public void moveViewToAnimated(float f, float f2, YAxis.AxisDependency axisDependency, long j) {
        ub3 valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.h(), this.mViewPortHandler.j(), axisDependency);
        addViewportJob(zd.d(this.mViewPortHandler, f, f2 + ((getAxisRange(axisDependency) / this.mViewPortHandler.s()) / 2.0f), getTransformer(axisDependency), this, (float) valuesByTouchPoint.c, (float) valuesByTouchPoint.d, j));
        ub3.c(valuesByTouchPoint);
    }

    public void moveViewToX(float f) {
        addViewportJob(hr3.b(this.mViewPortHandler, f, 0.0f, getTransformer(YAxis.AxisDependency.LEFT), this));
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData == 0) {
            if (this.mLogEnabled) {
                Log.i(Chart.LOG_TAG, "Preparing... DATA NOT SET.");
                return;
            }
            return;
        }
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "Preparing...");
        }
        su0 su0Var = this.mRenderer;
        if (su0Var != null) {
            su0Var.f();
        }
        calcMinMax();
        ep6 ep6Var = this.mAxisRendererLeft;
        YAxis yAxis = this.mAxisLeft;
        ep6Var.a(yAxis.H, yAxis.G, yAxis.U());
        ep6 ep6Var2 = this.mAxisRendererRight;
        YAxis yAxis2 = this.mAxisRight;
        ep6Var2.a(yAxis2.H, yAxis2.G, yAxis2.U());
        uo6 uo6Var = this.mXAxisRenderer;
        XAxis xAxis = this.mXAxis;
        uo6Var.a(xAxis.H, xAxis.G, false);
        if (this.mLegend != null) {
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
        long jCurrentTimeMillis = System.currentTimeMillis();
        drawGridBackground(canvas);
        if (this.mAutoScaleMinMaxEnabled) {
            autoScale();
        }
        if (this.mAxisLeft.f()) {
            ep6 ep6Var = this.mAxisRendererLeft;
            YAxis yAxis = this.mAxisLeft;
            ep6Var.a(yAxis.H, yAxis.G, yAxis.U());
        }
        if (this.mAxisRight.f()) {
            ep6 ep6Var2 = this.mAxisRendererRight;
            YAxis yAxis2 = this.mAxisRight;
            ep6Var2.a(yAxis2.H, yAxis2.G, yAxis2.U());
        }
        if (this.mXAxis.f()) {
            uo6 uo6Var = this.mXAxisRenderer;
            XAxis xAxis = this.mXAxis;
            uo6Var.a(xAxis.H, xAxis.G, false);
        }
        this.mXAxisRenderer.j(canvas);
        this.mAxisRendererLeft.j(canvas);
        this.mAxisRendererRight.j(canvas);
        if (this.mXAxis.x()) {
            this.mXAxisRenderer.k(canvas);
        }
        if (this.mAxisLeft.x()) {
            this.mAxisRendererLeft.k(canvas);
        }
        if (this.mAxisRight.x()) {
            this.mAxisRendererRight.k(canvas);
        }
        if (this.mXAxis.f() && this.mXAxis.A()) {
            this.mXAxisRenderer.n(canvas);
        }
        if (this.mAxisLeft.f() && this.mAxisLeft.A()) {
            this.mAxisRendererLeft.l(canvas);
        }
        if (this.mAxisRight.f() && this.mAxisRight.A()) {
            this.mAxisRendererRight.l(canvas);
        }
        int iSave = canvas.save();
        canvas.clipRect(this.mViewPortHandler.p());
        this.mRenderer.b(canvas);
        if (!this.mXAxis.x()) {
            this.mXAxisRenderer.k(canvas);
        }
        if (!this.mAxisLeft.x()) {
            this.mAxisRendererLeft.k(canvas);
        }
        if (!this.mAxisRight.x()) {
            this.mAxisRendererRight.k(canvas);
        }
        if (valuesToHighlight()) {
            this.mRenderer.d(canvas, this.mIndicesToHighlight);
        }
        canvas.restoreToCount(iSave);
        this.mRenderer.c(canvas);
        if (this.mXAxis.f() && !this.mXAxis.A()) {
            this.mXAxisRenderer.n(canvas);
        }
        if (this.mAxisLeft.f() && !this.mAxisLeft.A()) {
            this.mAxisRendererLeft.l(canvas);
        }
        if (this.mAxisRight.f() && !this.mAxisRight.A()) {
            this.mAxisRendererRight.l(canvas);
        }
        this.mXAxisRenderer.i(canvas);
        this.mAxisRendererLeft.i(canvas);
        this.mAxisRendererRight.i(canvas);
        if (isClipValuesToContentEnabled()) {
            int iSave2 = canvas.save();
            canvas.clipRect(this.mViewPortHandler.p());
            this.mRenderer.e(canvas);
            canvas.restoreToCount(iSave2);
        } else {
            this.mRenderer.e(canvas);
        }
        this.mLegendRenderer.e(canvas);
        drawDescription(canvas);
        drawMarkers(canvas);
        if (this.mLogEnabled) {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            long j = this.totalTime + jCurrentTimeMillis2;
            this.totalTime = j;
            long j2 = this.drawCycles + 1;
            this.drawCycles = j2;
            Log.i(Chart.LOG_TAG, "Drawtime: " + jCurrentTimeMillis2 + " ms, average: " + (j / j2) + " ms, cycles: " + this.drawCycles);
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float[] fArr = this.mOnSizeChangedBuffer;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        if (this.mKeepPositionOnRotation) {
            fArr[0] = this.mViewPortHandler.h();
            this.mOnSizeChangedBuffer[1] = this.mViewPortHandler.j();
            getTransformer(YAxis.AxisDependency.LEFT).j(this.mOnSizeChangedBuffer);
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mKeepPositionOnRotation) {
            getTransformer(YAxis.AxisDependency.LEFT).k(this.mOnSizeChangedBuffer);
            this.mViewPortHandler.e(this.mOnSizeChangedBuffer, this);
        } else {
            nf6 nf6Var = this.mViewPortHandler;
            nf6Var.L(nf6Var.q(), this, true);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        ChartTouchListener chartTouchListener = this.mChartTouchListener;
        if (chartTouchListener == null || this.mData == 0 || !this.mTouchEnabled) {
            return false;
        }
        return chartTouchListener.onTouch(this, motionEvent);
    }

    public void prepareOffsetMatrix() {
        this.mRightAxisTransformer.l(this.mAxisRight.U());
        this.mLeftAxisTransformer.l(this.mAxisLeft.U());
    }

    public void prepareValuePxMatrix() {
        if (this.mLogEnabled) {
            Log.i(Chart.LOG_TAG, "Preparing Value-Px Matrix, xmin: " + this.mXAxis.H + ", xmax: " + this.mXAxis.G + ", xdelta: " + this.mXAxis.I);
        }
        h16 h16Var = this.mRightAxisTransformer;
        XAxis xAxis = this.mXAxis;
        float f = xAxis.H;
        float f2 = xAxis.I;
        YAxis yAxis = this.mAxisRight;
        h16Var.m(f, f2, yAxis.I, yAxis.H);
        h16 h16Var2 = this.mLeftAxisTransformer;
        XAxis xAxis2 = this.mXAxis;
        float f3 = xAxis2.H;
        float f4 = xAxis2.I;
        YAxis yAxis2 = this.mAxisLeft;
        h16Var2.m(f3, f4, yAxis2.I, yAxis2.H);
    }

    public void resetTracking() {
        this.totalTime = 0L;
        this.drawCycles = 0L;
    }

    public void resetViewPortOffsets() {
        this.mCustomViewPortEnabled = false;
        calculateOffsets();
    }

    public void resetZoom() {
        this.mViewPortHandler.M(this.mZoomMatrixBuffer);
        this.mViewPortHandler.L(this.mZoomMatrixBuffer, this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void setAutoScaleMinMaxEnabled(boolean z) {
        this.mAutoScaleMinMaxEnabled = z;
    }

    public void setBorderColor(int i) {
        this.mBorderPaint.setColor(i);
    }

    public void setBorderWidth(float f) {
        this.mBorderPaint.setStrokeWidth(s86.e(f));
    }

    public void setClipValuesToContent(boolean z) {
        this.mClipValuesToContent = z;
    }

    public void setDoubleTapToZoomEnabled(boolean z) {
        this.mDoubleTapToZoomEnabled = z;
    }

    public void setDragEnabled(boolean z) {
        this.mDragXEnabled = z;
        this.mDragYEnabled = z;
    }

    public void setDragOffsetX(float f) {
        this.mViewPortHandler.P(f);
    }

    public void setDragOffsetY(float f) {
        this.mViewPortHandler.Q(f);
    }

    public void setDragXEnabled(boolean z) {
        this.mDragXEnabled = z;
    }

    public void setDragYEnabled(boolean z) {
        this.mDragYEnabled = z;
    }

    public void setDrawBorders(boolean z) {
        this.mDrawBorders = z;
    }

    public void setDrawGridBackground(boolean z) {
        this.mDrawGridBackground = z;
    }

    public void setGridBackgroundColor(int i) {
        this.mGridBackgroundPaint.setColor(i);
    }

    public void setHighlightPerDragEnabled(boolean z) {
        this.mHighlightPerDragEnabled = z;
    }

    public void setKeepPositionOnRotation(boolean z) {
        this.mKeepPositionOnRotation = z;
    }

    public void setMaxVisibleValueCount(int i) {
        this.mMaxVisibleCount = i;
    }

    public void setMinOffset(float f) {
        this.mMinOffset = f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setPaint(Paint paint, int i) {
        super.setPaint(paint, i);
        if (i != 4) {
            return;
        }
        this.mGridBackgroundPaint = paint;
    }

    public void setPinchZoom(boolean z) {
        this.mPinchZoomEnabled = z;
    }

    public void setRendererLeftYAxis(ep6 ep6Var) {
        this.mAxisRendererLeft = ep6Var;
    }

    public void setRendererRightYAxis(ep6 ep6Var) {
        this.mAxisRendererRight = ep6Var;
    }

    public void setScaleEnabled(boolean z) {
        this.mScaleXEnabled = z;
        this.mScaleYEnabled = z;
    }

    public void setScaleMinima(float f, float f2) {
        this.mViewPortHandler.V(f);
        this.mViewPortHandler.W(f2);
    }

    public void setScaleXEnabled(boolean z) {
        this.mScaleXEnabled = z;
    }

    public void setScaleYEnabled(boolean z) {
        this.mScaleYEnabled = z;
    }

    public void setViewPortOffsets(float f, float f2, float f3, float f4) {
        this.mCustomViewPortEnabled = true;
        post(new a(f, f2, f3, f4));
    }

    public void setVisibleXRange(float f, float f2) {
        float f3 = this.mXAxis.I;
        this.mViewPortHandler.T(f3 / f, f3 / f2);
    }

    public void setVisibleXRangeMaximum(float f) {
        this.mViewPortHandler.V(this.mXAxis.I / f);
    }

    public void setVisibleXRangeMinimum(float f) {
        this.mViewPortHandler.R(this.mXAxis.I / f);
    }

    public void setVisibleYRange(float f, float f2, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.U(getAxisRange(axisDependency) / f, getAxisRange(axisDependency) / f2);
    }

    public void setVisibleYRangeMaximum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.W(getAxisRange(axisDependency) / f);
    }

    public void setVisibleYRangeMinimum(float f, YAxis.AxisDependency axisDependency) {
        this.mViewPortHandler.S(getAxisRange(axisDependency) / f);
    }

    public void setXAxisRenderer(uo6 uo6Var) {
        this.mXAxisRenderer = uo6Var;
    }

    public void zoom(float f, float f2, float f3, float f4) {
        this.mViewPortHandler.Z(f, f2, f3, -f4, this.mZoomMatrixBuffer);
        this.mViewPortHandler.L(this.mZoomMatrixBuffer, this, false);
        calculateOffsets();
        postInvalidate();
    }

    @TargetApi(11)
    public void zoomAndCenterAnimated(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency, long j) {
        ub3 valuesByTouchPoint = getValuesByTouchPoint(this.mViewPortHandler.h(), this.mViewPortHandler.j(), axisDependency);
        addViewportJob(ee.d(this.mViewPortHandler, this, getTransformer(axisDependency), getAxis(axisDependency), this.mXAxis.I, f, f2, this.mViewPortHandler.r(), this.mViewPortHandler.s(), f3, f4, (float) valuesByTouchPoint.c, (float) valuesByTouchPoint.d, j));
        ub3.c(valuesByTouchPoint);
    }

    public void zoomIn() {
        vb3 vb3VarO = this.mViewPortHandler.o();
        this.mViewPortHandler.b0(vb3VarO.c, -vb3VarO.d, this.mZoomMatrixBuffer);
        this.mViewPortHandler.L(this.mZoomMatrixBuffer, this, false);
        vb3.f(vb3VarO);
        calculateOffsets();
        postInvalidate();
    }

    public void zoomOut() {
        vb3 vb3VarO = this.mViewPortHandler.o();
        this.mViewPortHandler.c0(vb3VarO.c, -vb3VarO.d, this.mZoomMatrixBuffer);
        this.mViewPortHandler.L(this.mZoomMatrixBuffer, this, false);
        vb3.f(vb3VarO);
        calculateOffsets();
        postInvalidate();
    }

    public void zoomToCenter(float f, float f2) {
        vb3 centerOffsets = getCenterOffsets();
        Matrix matrix = this.mZoomMatrixBuffer;
        this.mViewPortHandler.Z(f, f2, centerOffsets.c, -centerOffsets.d, matrix);
        this.mViewPortHandler.L(matrix, this, false);
    }

    public void getValuesByTouchPoint(float f, float f2, YAxis.AxisDependency axisDependency, ub3 ub3Var) {
        getTransformer(axisDependency).h(f, f2, ub3Var);
    }

    public void zoom(float f, float f2, float f3, float f4, YAxis.AxisDependency axisDependency) {
        addViewportJob(ir6.b(this.mViewPortHandler, f, f2, f3, f4, getTransformer(axisDependency), axisDependency, this));
    }

    public BarLineChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragXEnabled = true;
        this.mDragYEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mDrawGridBackground = false;
        this.mDrawBorders = false;
        this.mClipValuesToContent = false;
        this.mMinOffset = 15.0f;
        this.mKeepPositionOnRotation = false;
        this.totalTime = 0L;
        this.drawCycles = 0L;
        this.mOffsetsBuffer = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        this.mFitScreenMatrixBuffer = new Matrix();
        this.mCustomViewPortEnabled = false;
        this.mGetPositionBuffer = new float[2];
        this.posForGetLowestVisibleX = ub3.b(0.0d, 0.0d);
        this.posForGetHighestVisibleX = ub3.b(0.0d, 0.0d);
        this.mOnSizeChangedBuffer = new float[2];
    }

    public void setOnDrawListener(u64 u64Var) {
    }

    public BarLineChartBase(Context context) {
        super(context);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragXEnabled = true;
        this.mDragYEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mDrawGridBackground = false;
        this.mDrawBorders = false;
        this.mClipValuesToContent = false;
        this.mMinOffset = 15.0f;
        this.mKeepPositionOnRotation = false;
        this.totalTime = 0L;
        this.drawCycles = 0L;
        this.mOffsetsBuffer = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        this.mFitScreenMatrixBuffer = new Matrix();
        this.mCustomViewPortEnabled = false;
        this.mGetPositionBuffer = new float[2];
        this.posForGetLowestVisibleX = ub3.b(0.0d, 0.0d);
        this.posForGetHighestVisibleX = ub3.b(0.0d, 0.0d);
        this.mOnSizeChangedBuffer = new float[2];
    }
}
