package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.ColorInt;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.zenmen.palmchat.framework.R$styleable;
import defpackage.b05;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WaveViewNew extends View {
    private static final String TAG = "WaveView";
    private int colorBegin;
    private int colorEnd;
    private List<c> mCircleList;
    private final Runnable mCreateCircle;
    private final Runnable mCreateSeconedCircle;
    private long mDuration;
    private float mInitialRadius;
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private long mLastCreateTime;
    private float mMaxRadius;
    private float mMaxRadiusRate;
    private boolean mMaxRadiusSet;
    private Paint mPaint;
    private int mSpeed;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WaveViewNew.this.mIsRunning) {
                WaveViewNew.this.newCircle();
                WaveViewNew waveViewNew = WaveViewNew.this;
                waveViewNew.postDelayed(waveViewNew.mCreateCircle, 2500L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (WaveViewNew.this.mIsRunning) {
                WaveViewNew.this.mCircleList.clear();
                WaveViewNew.this.newCircle();
                WaveViewNew waveViewNew = WaveViewNew.this;
                waveViewNew.postDelayed(waveViewNew.mCreateSeconedCircle, 500L);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16008a = System.currentTimeMillis();

        public c() {
        }

        public int a() {
            int interpolation = (int) (255.0f - (WaveViewNew.this.mInterpolator.getInterpolation((b() - WaveViewNew.this.mInitialRadius) / (WaveViewNew.this.mMaxRadius - WaveViewNew.this.mInitialRadius)) * 255.0f));
            if (interpolation < 0) {
                return 0;
            }
            return interpolation;
        }

        public float b() {
            float interpolation = WaveViewNew.this.mInitialRadius + (WaveViewNew.this.mInterpolator.getInterpolation(((System.currentTimeMillis() - this.f16008a) * 1.0f) / WaveViewNew.this.mDuration) * (WaveViewNew.this.mMaxRadius - WaveViewNew.this.mInitialRadius));
            return interpolation > WaveViewNew.this.mMaxRadius ? WaveViewNew.this.mMaxRadius : interpolation;
        }
    }

    public WaveViewNew(Context context) {
        this(context, null);
    }

    private void clear() {
        removeCallbacks(this.mCreateCircle);
        removeCallbacks(this.mCreateSeconedCircle);
        this.mCircleList.clear();
    }

    private void init(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.wave_view);
        this.mInitialRadius = typedArrayObtainStyledAttributes.getDimension(R$styleable.wave_view_init_radius, 0.0f);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.wave_view_max_radius, 0);
        if (dimensionPixelOffset != 0) {
            this.mMaxRadius = dimensionPixelOffset;
            this.mMaxRadiusSet = true;
        }
        this.mDuration = typedArrayObtainStyledAttributes.getInteger(R$styleable.wave_view_wave_duration, TTAdConstant.STYLE_SIZE_RADIO_3_2);
        this.mSpeed = typedArrayObtainStyledAttributes.getInteger(R$styleable.wave_view_wave_speed, 600);
        this.colorBegin = typedArrayObtainStyledAttributes.getColor(R$styleable.wave_view_wave_color_begin, Color.parseColor("#3BEE76"));
        this.colorEnd = typedArrayObtainStyledAttributes.getColor(R$styleable.wave_view_wave_color_end, Color.parseColor("#3BEE76"));
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(5.0f);
        this.mPaint.setColor(this.colorBegin);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void newCircle() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mCircleList.add(new c());
        if (this.mCircleList.size() == 1) {
            invalidate();
        }
        this.mLastCreateTime = jCurrentTimeMillis;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsRunning) {
            this.mIsRunning = false;
            start();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clear();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (c cVar : this.mCircleList) {
            if (cVar.a() > 0) {
                float fB = cVar.b();
                this.mPaint.setAlpha(cVar.a());
                canvas.drawCircle(getWidth() / 2, getHeight() / 2, fB, this.mPaint);
            }
        }
        if (this.mCircleList.size() > 0) {
            postInvalidateDelayed(100L);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!this.mMaxRadiusSet) {
            this.mMaxRadius = (Math.min(i, i2) * this.mMaxRadiusRate) / 2.0f;
        }
        this.mPaint.setShader(new LinearGradient(0.0f, i2, i, 0.0f, new int[]{this.colorBegin, this.colorEnd}, (float[]) null, Shader.TileMode.CLAMP));
    }

    public void setColor(@ColorInt int i) {
        this.mPaint.setColor(i);
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setEndColor(int i) {
        this.colorEnd = i;
        this.mPaint.setShader(new LinearGradient(0.0f, getMeasuredHeight(), getMeasuredWidth(), 0.0f, new int[]{this.colorBegin, this.colorEnd}, (float[]) null, Shader.TileMode.CLAMP));
    }

    public void setInitialRadius(float f) {
        this.mInitialRadius = f;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
        if (interpolator == null) {
            this.mInterpolator = new LinearInterpolator();
        }
    }

    public void setMaxRadius(float f) {
        this.mMaxRadius = f;
        this.mMaxRadiusSet = true;
    }

    public void setMaxRadiusRate(float f) {
        this.mMaxRadiusRate = f;
    }

    public void setSpeed(int i) {
        this.mSpeed = i;
    }

    public void setStartColor(int i) {
        this.colorBegin = i;
        this.mPaint.setColor(i);
    }

    public void setStyle(Paint.Style style) {
        this.mPaint.setStyle(style);
    }

    public void start() {
        if (!isAttachedToWindow()) {
            this.mIsRunning = true;
        } else {
            if (this.mIsRunning) {
                return;
            }
            b05.d("mCreateCircle.run()方法调用");
            this.mIsRunning = true;
            this.mCreateCircle.run();
        }
    }

    public void stop() {
        this.mIsRunning = false;
    }

    public void stopImmediately() {
        this.mIsRunning = false;
        this.mCircleList.clear();
        invalidate();
    }

    public WaveViewNew(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WaveViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxRadius = 0.0f;
        this.mDuration = 3200L;
        this.mSpeed = 800;
        this.mMaxRadiusRate = 1.0f;
        this.mIsRunning = false;
        this.mCircleList = new ArrayList();
        this.mCreateSeconedCircle = new a();
        this.mCreateCircle = new b();
        this.mInterpolator = new LinearInterpolator();
        this.mPaint = new Paint(1);
        init(attributeSet);
    }
}
