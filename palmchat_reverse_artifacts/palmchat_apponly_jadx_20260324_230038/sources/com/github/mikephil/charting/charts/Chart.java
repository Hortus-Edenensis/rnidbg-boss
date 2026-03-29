package com.github.mikephil.charting.charts;

import android.animation.ValueAnimator;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import androidx.media3.common.MimeTypes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.huawei.openalliance.ad.constant.bq;
import defpackage.b23;
import defpackage.g10;
import defpackage.h10;
import defpackage.h96;
import defpackage.i10;
import defpackage.j10;
import defpackage.kl2;
import defpackage.la1;
import defpackage.nf6;
import defpackage.o64;
import defpackage.s86;
import defpackage.su0;
import defpackage.uj1;
import defpackage.vb3;
import defpackage.vh2;
import defpackage.wm2;
import defpackage.za1;
import defpackage.zl2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class Chart<T extends h10<? extends kl2<? extends Entry>>> extends ViewGroup implements j10 {
    public static final String LOG_TAG = "MPAndroidChart";
    public static final int PAINT_CENTER_TEXT = 14;
    public static final int PAINT_DESCRIPTION = 11;
    public static final int PAINT_GRID_BACKGROUND = 4;
    public static final int PAINT_HOLE = 13;
    public static final int PAINT_INFO = 7;
    public static final int PAINT_LEGEND_LABEL = 18;
    protected g10 mAnimator;
    protected ChartTouchListener mChartTouchListener;
    protected T mData;
    protected la1 mDefaultValueFormatter;
    protected Paint mDescPaint;
    protected za1 mDescription;
    private boolean mDragDecelerationEnabled;
    private float mDragDecelerationFrictionCoef;
    protected boolean mDrawMarkers;
    private float mExtraBottomOffset;
    private float mExtraLeftOffset;
    private float mExtraRightOffset;
    private float mExtraTopOffset;
    private com.github.mikephil.charting.listener.b mGestureListener;
    protected boolean mHighLightPerTapEnabled;
    protected zl2 mHighlighter;
    protected vh2[] mIndicesToHighlight;
    protected Paint mInfoPaint;
    protected ArrayList<Runnable> mJobs;
    protected Legend mLegend;
    protected b23 mLegendRenderer;
    protected boolean mLogEnabled;
    protected wm2 mMarker;
    protected float mMaxHighlightDistance;
    private String mNoDataText;
    private boolean mOffsetsCalculated;
    protected su0 mRenderer;
    protected o64 mSelectionListener;
    protected boolean mTouchEnabled;
    private boolean mUnbind;
    protected nf6 mViewPortHandler;
    protected XAxis mXAxis;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Chart.this.postInvalidate();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5810a;

        static {
            int[] iArr = new int[Bitmap.CompressFormat.values().length];
            f5810a = iArr;
            try {
                iArr[Bitmap.CompressFormat.PNG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5810a[Bitmap.CompressFormat.WEBP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5810a[Bitmap.CompressFormat.JPEG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Chart(Context context) {
        super(context);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new la1(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new nf6();
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.mUnbind = false;
        init();
    }

    private void unbindDrawables(View view) {
        if (view.getBackground() != null) {
            view.getBackground().setCallback(null);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                viewGroup.removeAllViews();
                return;
            } else {
                unbindDrawables(viewGroup.getChildAt(i));
                i++;
            }
        }
    }

    public void addViewportJob(Runnable runnable) {
        if (this.mViewPortHandler.u()) {
            post(runnable);
        } else {
            this.mJobs.add(runnable);
        }
    }

    @RequiresApi(11)
    public void animateX(int i, uj1.c0 c0Var) {
        this.mAnimator.b(i, c0Var);
    }

    @RequiresApi(11)
    public void animateXY(int i, int i2, uj1.c0 c0Var, uj1.c0 c0Var2) {
        this.mAnimator.e(i, i2, c0Var, c0Var2);
    }

    @RequiresApi(11)
    public void animateY(int i, uj1.c0 c0Var) {
        this.mAnimator.g(i, c0Var);
    }

    public abstract void calcMinMax();

    public abstract void calculateOffsets();

    public void clear() {
        this.mData = null;
        this.mOffsetsCalculated = false;
        this.mIndicesToHighlight = null;
        this.mChartTouchListener.d(null);
        invalidate();
    }

    public void clearAllViewportJobs() {
        this.mJobs.clear();
    }

    public void clearValues() {
        this.mData.d();
        invalidate();
    }

    public void disableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void drawDescription(Canvas canvas) {
        float height;
        float width;
        za1 za1Var = this.mDescription;
        if (za1Var == null || !za1Var.f()) {
            return;
        }
        vb3 vb3VarH = this.mDescription.h();
        this.mDescPaint.setTypeface(this.mDescription.c());
        this.mDescPaint.setTextSize(this.mDescription.b());
        this.mDescPaint.setColor(this.mDescription.a());
        this.mDescPaint.setTextAlign(this.mDescription.j());
        if (vb3VarH == null) {
            width = (getWidth() - this.mViewPortHandler.J()) - this.mDescription.d();
            height = (getHeight() - this.mViewPortHandler.H()) - this.mDescription.e();
        } else {
            float f = vb3VarH.c;
            height = vb3VarH.d;
            width = f;
        }
        canvas.drawText(this.mDescription.i(), width, height, this.mDescPaint);
    }

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
            kl2 kl2VarE = this.mData.e(vh2Var.d());
            Entry entryJ = this.mData.j(this.mIndicesToHighlight[i]);
            int iB = kl2VarE.b(entryJ);
            if (entryJ != null && iB <= kl2VarE.K0() * this.mAnimator.h()) {
                float[] markerPosition = getMarkerPosition(vh2Var);
                if (this.mViewPortHandler.z(markerPosition[0], markerPosition[1])) {
                    this.mMarker.refreshContent(entryJ, vh2Var);
                    this.mMarker.draw(canvas, markerPosition[0], markerPosition[1]);
                }
            }
            i++;
        }
    }

    public void enableScroll() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    public g10 getAnimator() {
        return this.mAnimator;
    }

    public vb3 getCenter() {
        return vb3.c(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    public vb3 getCenterOfView() {
        return getCenter();
    }

    public vb3 getCenterOffsets() {
        return this.mViewPortHandler.o();
    }

    public Bitmap getChartBitmap() {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Drawable background = getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        draw(canvas);
        return bitmapCreateBitmap;
    }

    public RectF getContentRect() {
        return this.mViewPortHandler.p();
    }

    public T getData() {
        return this.mData;
    }

    public h96 getDefaultValueFormatter() {
        return this.mDefaultValueFormatter;
    }

    public za1 getDescription() {
        return this.mDescription;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.mDragDecelerationFrictionCoef;
    }

    public float getExtraBottomOffset() {
        return this.mExtraBottomOffset;
    }

    public float getExtraLeftOffset() {
        return this.mExtraLeftOffset;
    }

    public float getExtraRightOffset() {
        return this.mExtraRightOffset;
    }

    public float getExtraTopOffset() {
        return this.mExtraTopOffset;
    }

    public vh2 getHighlightByTouchPoint(float f, float f2) {
        if (this.mData != null) {
            return getHighlighter().a(f, f2);
        }
        Log.e(LOG_TAG, "Can't select by touch. No data set.");
        return null;
    }

    public vh2[] getHighlighted() {
        return this.mIndicesToHighlight;
    }

    public zl2 getHighlighter() {
        return this.mHighlighter;
    }

    public ArrayList<Runnable> getJobs() {
        return this.mJobs;
    }

    public Legend getLegend() {
        return this.mLegend;
    }

    public b23 getLegendRenderer() {
        return this.mLegendRenderer;
    }

    public wm2 getMarker() {
        return this.mMarker;
    }

    public float[] getMarkerPosition(vh2 vh2Var) {
        return new float[]{vh2Var.e(), vh2Var.f()};
    }

    @Deprecated
    public wm2 getMarkerView() {
        return getMarker();
    }

    @Override // defpackage.j10
    public float getMaxHighlightDistance() {
        return this.mMaxHighlightDistance;
    }

    public abstract /* synthetic */ int getMaxVisibleCount();

    public com.github.mikephil.charting.listener.b getOnChartGestureListener() {
        return null;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.mChartTouchListener;
    }

    public Paint getPaint(int i) {
        if (i == 7) {
            return this.mInfoPaint;
        }
        if (i != 11) {
            return null;
        }
        return this.mDescPaint;
    }

    public su0 getRenderer() {
        return this.mRenderer;
    }

    public nf6 getViewPortHandler() {
        return this.mViewPortHandler;
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    public float getXChartMax() {
        return this.mXAxis.G;
    }

    public float getXChartMin() {
        return this.mXAxis.H;
    }

    public float getXRange() {
        return this.mXAxis.I;
    }

    public abstract /* synthetic */ float getYChartMax();

    public abstract /* synthetic */ float getYChartMin();

    public float getYMax() {
        return this.mData.p();
    }

    public float getYMin() {
        return this.mData.r();
    }

    public void highlightValue(float f, int i) {
        highlightValue(f, i, true);
    }

    public void highlightValues(vh2[] vh2VarArr) {
        this.mIndicesToHighlight = vh2VarArr;
        setLastHighlighted(vh2VarArr);
        invalidate();
    }

    public void init() {
        setWillNotDraw(false);
        this.mAnimator = new g10(new a());
        s86.v(getContext());
        this.mMaxHighlightDistance = s86.e(500.0f);
        this.mDescription = new za1();
        Legend legend = new Legend();
        this.mLegend = legend;
        this.mLegendRenderer = new b23(this.mViewPortHandler, legend);
        this.mXAxis = new XAxis();
        this.mDescPaint = new Paint(1);
        Paint paint = new Paint(1);
        this.mInfoPaint = paint;
        paint.setColor(Color.rgb(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT, 189, 51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(s86.e(12.0f));
        if (this.mLogEnabled) {
            Log.i("", "Chart.init()");
        }
    }

    public boolean isDragDecelerationEnabled() {
        return this.mDragDecelerationEnabled;
    }

    @Deprecated
    public boolean isDrawMarkerViewsEnabled() {
        return isDrawMarkersEnabled();
    }

    public boolean isDrawMarkersEnabled() {
        return this.mDrawMarkers;
    }

    public boolean isEmpty() {
        T t = this.mData;
        return t == null || t.i() <= 0;
    }

    public boolean isHighlightPerTapEnabled() {
        return this.mHighLightPerTapEnabled;
    }

    public boolean isLogEnabled() {
        return this.mLogEnabled;
    }

    public abstract void notifyDataSetChanged();

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mUnbind) {
            unbindDrawables(this);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mData == null) {
            if (!TextUtils.isEmpty(this.mNoDataText)) {
                vb3 center = getCenter();
                canvas.drawText(this.mNoDataText, center.c, center.d, this.mInfoPaint);
                return;
            }
            return;
        }
        if (this.mOffsetsCalculated) {
            return;
        }
        calculateOffsets();
        this.mOffsetsCalculated = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            getChildAt(i5).layout(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iE = (int) s86.e(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), View.resolveSize(iE, i)), Math.max(getSuggestedMinimumHeight(), View.resolveSize(iE, i2)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mLogEnabled) {
            Log.i(LOG_TAG, "OnSizeChanged()");
        }
        if (i > 0 && i2 > 0 && i < 10000 && i2 < 10000) {
            if (this.mLogEnabled) {
                Log.i(LOG_TAG, "Setting chart dimens, width: " + i + ", height: " + i2);
            }
            this.mViewPortHandler.O(i, i2);
        } else if (this.mLogEnabled) {
            Log.w(LOG_TAG, "*Avoiding* setting chart dimens! width: " + i + ", height: " + i2);
        }
        notifyDataSetChanged();
        Iterator<Runnable> it = this.mJobs.iterator();
        while (it.hasNext()) {
            post(it.next());
        }
        this.mJobs.clear();
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void removeViewportJob(Runnable runnable) {
        this.mJobs.remove(runnable);
    }

    public boolean saveToGallery(String str, String str2, String str3, Bitmap.CompressFormat compressFormat, int i) {
        String str4;
        if (i < 0 || i > 100) {
            i = 50;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/" + str2);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        int i2 = b.f5810a[compressFormat.ordinal()];
        if (i2 == 1) {
            str4 = "image/png";
            if (!str.endsWith(".png")) {
                str = str + ".png";
            }
        } else if (i2 != 2) {
            str4 = "image/jpeg";
            if (!str.endsWith(".jpg") && !str.endsWith(".jpeg")) {
                str = str + ".jpg";
            }
        } else {
            boolean zEndsWith = str.endsWith(".webp");
            str4 = MimeTypes.IMAGE_WEBP;
            if (!zEndsWith) {
                str = str + ".webp";
            }
        }
        String str5 = file.getAbsolutePath() + "/" + str;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str5);
            getChartBitmap().compress(compressFormat, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            long length = new File(str5).length();
            ContentValues contentValues = new ContentValues(8);
            contentValues.put("title", str);
            contentValues.put("_display_name", str);
            contentValues.put("date_added", Long.valueOf(jCurrentTimeMillis));
            contentValues.put("mime_type", str4);
            contentValues.put("description", str3);
            contentValues.put(bq.f.V, (Integer) 0);
            contentValues.put("_data", str5);
            contentValues.put("_size", Long.valueOf(length));
            return getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues) != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveToPath(String str, String str2) {
        Bitmap chartBitmap = getChartBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + str2 + "/" + str + ".png");
            chartBitmap.compress(Bitmap.CompressFormat.PNG, 40, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setData(T t) {
        this.mData = t;
        this.mOffsetsCalculated = false;
        if (t == null) {
            return;
        }
        setupDefaultFormatter(t.r(), t.p());
        for (kl2 kl2Var : this.mData.h()) {
            if (kl2Var.B0() || kl2Var.Z() == this.mDefaultValueFormatter) {
                kl2Var.a0(this.mDefaultValueFormatter);
            }
        }
        notifyDataSetChanged();
        if (this.mLogEnabled) {
            Log.i(LOG_TAG, "Data is set.");
        }
    }

    public void setDescription(za1 za1Var) {
        this.mDescription = za1Var;
    }

    public void setDragDecelerationEnabled(boolean z) {
        this.mDragDecelerationEnabled = z;
    }

    public void setDragDecelerationFrictionCoef(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f >= 1.0f) {
            f = 0.999f;
        }
        this.mDragDecelerationFrictionCoef = f;
    }

    @Deprecated
    public void setDrawMarkerViews(boolean z) {
        setDrawMarkers(z);
    }

    public void setDrawMarkers(boolean z) {
        this.mDrawMarkers = z;
    }

    public void setExtraBottomOffset(float f) {
        this.mExtraBottomOffset = s86.e(f);
    }

    public void setExtraLeftOffset(float f) {
        this.mExtraLeftOffset = s86.e(f);
    }

    public void setExtraOffsets(float f, float f2, float f3, float f4) {
        setExtraLeftOffset(f);
        setExtraTopOffset(f2);
        setExtraRightOffset(f3);
        setExtraBottomOffset(f4);
    }

    public void setExtraRightOffset(float f) {
        this.mExtraRightOffset = s86.e(f);
    }

    public void setExtraTopOffset(float f) {
        this.mExtraTopOffset = s86.e(f);
    }

    public void setHardwareAccelerationEnabled(boolean z) {
        if (z) {
            setLayerType(2, null);
        } else {
            setLayerType(1, null);
        }
    }

    public void setHighlightPerTapEnabled(boolean z) {
        this.mHighLightPerTapEnabled = z;
    }

    public void setHighlighter(i10 i10Var) {
        this.mHighlighter = i10Var;
    }

    public void setLastHighlighted(vh2[] vh2VarArr) {
        vh2 vh2Var;
        if (vh2VarArr == null || vh2VarArr.length <= 0 || (vh2Var = vh2VarArr[0]) == null) {
            this.mChartTouchListener.d(null);
        } else {
            this.mChartTouchListener.d(vh2Var);
        }
    }

    public void setLogEnabled(boolean z) {
        this.mLogEnabled = z;
    }

    public void setMarker(wm2 wm2Var) {
        this.mMarker = wm2Var;
    }

    @Deprecated
    public void setMarkerView(wm2 wm2Var) {
        setMarker(wm2Var);
    }

    public void setMaxHighlightDistance(float f) {
        this.mMaxHighlightDistance = s86.e(f);
    }

    public void setNoDataText(String str) {
        this.mNoDataText = str;
    }

    public void setNoDataTextColor(int i) {
        this.mInfoPaint.setColor(i);
    }

    public void setNoDataTextTypeface(Typeface typeface) {
        this.mInfoPaint.setTypeface(typeface);
    }

    public void setOnTouchListener(ChartTouchListener chartTouchListener) {
        this.mChartTouchListener = chartTouchListener;
    }

    public void setPaint(Paint paint, int i) {
        if (i == 7) {
            this.mInfoPaint = paint;
        } else {
            if (i != 11) {
                return;
            }
            this.mDescPaint = paint;
        }
    }

    public void setRenderer(su0 su0Var) {
        if (su0Var != null) {
            this.mRenderer = su0Var;
        }
    }

    public void setTouchEnabled(boolean z) {
        this.mTouchEnabled = z;
    }

    public void setUnbindEnabled(boolean z) {
        this.mUnbind = z;
    }

    public void setupDefaultFormatter(float f, float f2) {
        T t = this.mData;
        this.mDefaultValueFormatter.j(s86.i((t == null || t.i() < 2) ? Math.max(Math.abs(f), Math.abs(f2)) : Math.abs(f2 - f)));
    }

    public boolean valuesToHighlight() {
        vh2[] vh2VarArr = this.mIndicesToHighlight;
        return (vh2VarArr == null || vh2VarArr.length <= 0 || vh2VarArr[0] == null) ? false : true;
    }

    @RequiresApi(11)
    public void animateX(int i) {
        this.mAnimator.a(i);
    }

    @RequiresApi(11)
    public void animateXY(int i, int i2, uj1.c0 c0Var) {
        this.mAnimator.d(i, i2, c0Var);
    }

    @RequiresApi(11)
    public void animateY(int i) {
        this.mAnimator.f(i);
    }

    public void highlightValue(float f, float f2, int i) {
        highlightValue(f, f2, i, true);
    }

    @RequiresApi(11)
    public void animateXY(int i, int i2) {
        this.mAnimator.c(i, i2);
    }

    public void highlightValue(float f, int i, boolean z) {
        highlightValue(f, Float.NaN, i, z);
    }

    public void highlightValue(float f, float f2, int i, boolean z) {
        if (i >= 0 && i < this.mData.f()) {
            highlightValue(new vh2(f, f2, i), z);
        } else {
            highlightValue((vh2) null, z);
        }
    }

    public void highlightValue(vh2 vh2Var) {
        highlightValue(vh2Var, false);
    }

    public void highlightValue(vh2 vh2Var, boolean z) {
        if (vh2Var == null) {
            this.mIndicesToHighlight = null;
        } else {
            if (this.mLogEnabled) {
                Log.i(LOG_TAG, "Highlighted: " + vh2Var.toString());
            }
            if (this.mData.j(vh2Var) == null) {
                this.mIndicesToHighlight = null;
            } else {
                this.mIndicesToHighlight = new vh2[]{vh2Var};
            }
        }
        setLastHighlighted(this.mIndicesToHighlight);
        invalidate();
    }

    public Chart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new la1(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new nf6();
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.mUnbind = false;
        init();
    }

    public void setOnChartGestureListener(com.github.mikephil.charting.listener.b bVar) {
    }

    public void setOnChartValueSelectedListener(o64 o64Var) {
    }

    public boolean saveToGallery(String str, int i) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, i);
    }

    public boolean saveToGallery(String str) {
        return saveToGallery(str, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
    }

    public Chart(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new la1(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new nf6();
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList<>();
        this.mUnbind = false;
        init();
    }
}
