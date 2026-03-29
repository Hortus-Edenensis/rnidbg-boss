package com.tencent.matrix.trace.view;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.tencent.matrix.AppActiveMatrixDelegate;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.batterycanary.R;
import com.tencent.matrix.listeners.IAppForeground;
import com.tencent.matrix.trace.TracePlugin;
import com.tencent.matrix.trace.core.UIThreadMonitor;
import com.tencent.matrix.trace.listeners.IDoFrameListener;
import com.tencent.matrix.trace.tracer.FrameTracer;
import com.tencent.matrix.util.MatrixHandlerThread;
import com.tencent.matrix.util.MatrixLog;
import j$.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class FrameDecorator extends IDoFrameListener implements IAppForeground {
    private static final String TAG = "Matrix.FrameDecorator";
    private static FrameDecorator instance;
    private int belongColor;
    private int bestColor;
    private View.OnClickListener clickListener;
    private DisplayMetrics displayMetrics;
    private int[] dropLevel;
    private Executor executor;
    private float frameIntervalMs;
    private int frozenColor;
    private Handler handler;
    private int highColor;
    private boolean isEnable;
    private boolean isShowing;
    private long[] lastCost;
    private long[] lastFrames;
    private String lastVisibleScene;
    private WindowManager.LayoutParams layoutParam;
    private float maxFps;
    private int middleColor;
    private int normalColor;
    private int[] sumDropLevel;
    private long sumFrameCost;
    private long sumFrames;
    private Runnable updateDefaultRunnable;
    private FloatFrameView view;
    private WindowManager windowManager;
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final Object lock = new Object();

    public static FrameDecorator get() {
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler getHandler() {
        Handler handler = this.handler;
        if ((handler == null || !handler.getLooper().getThread().isAlive()) && MatrixHandlerThread.getDefaultHandlerThread() != null) {
            this.handler = new Handler(MatrixHandlerThread.getDefaultHandlerThread().getLooper());
        }
        return this.handler;
    }

    public static FrameDecorator getInstance(final Context context) {
        if (instance == null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                instance = new FrameDecorator(context, new FloatFrameView(context));
            } else {
                try {
                    Object obj = lock;
                    synchronized (obj) {
                        mainHandler.post(new Runnable() { // from class: com.tencent.matrix.trace.view.FrameDecorator.6
                            @Override // java.lang.Runnable
                            public void run() {
                                FrameDecorator unused = FrameDecorator.instance = new FrameDecorator(context, new FloatFrameView(context));
                                synchronized (FrameDecorator.lock) {
                                    FrameDecorator.lock.notifyAll();
                                }
                            }
                        });
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }

    private void initLayoutParams(Context context) {
        this.windowManager = (WindowManager) context.getApplicationContext().getSystemService("window");
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (this.windowManager.getDefaultDisplay() != null) {
                this.windowManager.getDefaultDisplay().getMetrics(this.displayMetrics);
                this.windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            }
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.layoutParam = layoutParams;
            if (Build.VERSION.SDK_INT >= 26) {
                layoutParams.type = 2038;
            } else {
                layoutParams.type = 2002;
            }
            layoutParams.flags = 40;
            layoutParams.gravity = 8388659;
            FloatFrameView floatFrameView = this.view;
            if (floatFrameView != null) {
                layoutParams.x = displayMetrics.widthPixels - (floatFrameView.getLayoutParams().width * 2);
            }
            WindowManager.LayoutParams layoutParams2 = this.layoutParam;
            layoutParams2.y = 0;
            layoutParams2.width = -2;
            layoutParams2.height = -2;
            layoutParams2.format = -2;
        } catch (Exception unused) {
        }
    }

    private void updateView(final FloatFrameView floatFrameView, final float f, final int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i2 + i3 + i4 + i5;
        float f2 = i10 <= 0 ? 0.0f : ((i5 * 1.0f) / i10) * 60.0f;
        float f3 = i10 <= 0 ? 0.0f : ((i4 * 1.0f) / i10) * 25.0f;
        float f4 = i10 <= 0 ? 0.0f : ((i3 * 1.0f) / i10) * 14.0f;
        float f5 = i10 <= 0 ? 0.0f : ((i2 * 1.0f) / i10) * 1.0f;
        float f6 = f2 + f3 + f4 + f5;
        int i11 = i6 + i7 + i8 + i9;
        float f7 = i11 <= 0 ? 0.0f : ((i9 * 1.0f) / i11) * 60.0f;
        float f8 = i11 <= 0 ? 0.0f : ((i8 * 1.0f) / i11) * 25.0f;
        float f9 = i11 <= 0 ? 0.0f : ((i7 * 1.0f) / i11) * 14.0f;
        float f10 = i11 > 0 ? ((i6 * 1.0f) / i11) * 1.0f : 0.0f;
        final String str = String.format("%.1f", Float.valueOf(f2));
        final String str2 = String.format("%.1f", Float.valueOf(f3));
        final String str3 = String.format("%.1f", Float.valueOf(f4));
        final String str4 = String.format("%.1f", Float.valueOf(f5));
        final String str5 = String.format("current: %.1f", Float.valueOf(f6));
        final String str6 = String.format("%.1f", Float.valueOf(f7));
        final String str7 = String.format("%.1f", Float.valueOf(f8));
        final String str8 = String.format("%.1f", Float.valueOf(f9));
        final String str9 = String.format("%.1f", Float.valueOf(f10));
        final String str10 = String.format("sum: %.1f", Float.valueOf(f7 + f8 + f9 + f10));
        final String str11 = String.format("%.2f FPS", Float.valueOf(f));
        mainHandler.post(new Runnable() { // from class: com.tencent.matrix.trace.view.FrameDecorator.4
            @Override // java.lang.Runnable
            public void run() {
                floatFrameView.chartView.addFps((int) f, i);
                floatFrameView.fpsView.setText(str11);
                floatFrameView.fpsView.setTextColor(i);
                floatFrameView.qiWangView.setText(str5);
                floatFrameView.levelFrozenView.setText(str);
                floatFrameView.levelHighView.setText(str2);
                floatFrameView.levelMiddleView.setText(str3);
                floatFrameView.levelNormalView.setText(str4);
                floatFrameView.sumQiWangView.setText(str10);
                floatFrameView.sumLevelFrozenView.setText(str6);
                floatFrameView.sumLevelHighView.setText(str7);
                floatFrameView.sumLevelMiddleView.setText(str8);
                floatFrameView.sumLevelNormalView.setText(str9);
            }
        });
    }

    public void dismiss() {
        if (this.isEnable) {
            mainHandler.post(new Runnable() { // from class: com.tencent.matrix.trace.view.FrameDecorator.8
                @Override // java.lang.Runnable
                public void run() {
                    if (FrameDecorator.this.isShowing) {
                        FrameDecorator.this.isShowing = false;
                        FrameDecorator.this.windowManager.removeView(FrameDecorator.this.view);
                    }
                }
            });
        }
    }

    @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
    public void doFrameAsync(String str, long j, long j2, int i, boolean z, long j3, long j4, long j5, long j6) {
        super.doFrameAsync(str, j, j2, i, z, j3, j4, j5, j6);
        if (!Objects.equals(str, this.lastVisibleScene)) {
            this.dropLevel = new int[FrameTracer.DropStatus.values().length];
            this.lastVisibleScene = str;
            this.lastCost[0] = 0;
            this.lastFrames[0] = 0;
        }
        long j7 = (long) (this.sumFrameCost + ((i + 1) * this.frameIntervalMs));
        this.sumFrameCost = j7;
        long j8 = this.sumFrames + 1;
        this.sumFrames = j8;
        float f = j7 - this.lastCost[0];
        if (i >= 42) {
            int[] iArr = this.dropLevel;
            int i2 = FrameTracer.DropStatus.DROPPED_FROZEN.index;
            iArr[i2] = iArr[i2] + 1;
            int[] iArr2 = this.sumDropLevel;
            iArr2[i2] = iArr2[i2] + 1;
            this.belongColor = this.frozenColor;
        } else if (i >= 24) {
            int[] iArr3 = this.dropLevel;
            int i3 = FrameTracer.DropStatus.DROPPED_HIGH.index;
            iArr3[i3] = iArr3[i3] + 1;
            int[] iArr4 = this.sumDropLevel;
            iArr4[i3] = iArr4[i3] + 1;
            if (this.belongColor != this.frozenColor) {
                this.belongColor = this.highColor;
            }
        } else if (i >= 9) {
            int[] iArr5 = this.dropLevel;
            int i4 = FrameTracer.DropStatus.DROPPED_MIDDLE.index;
            iArr5[i4] = iArr5[i4] + 1;
            int[] iArr6 = this.sumDropLevel;
            iArr6[i4] = iArr6[i4] + 1;
            int i5 = this.belongColor;
            if (i5 != this.frozenColor && i5 != this.highColor) {
                this.belongColor = this.middleColor;
            }
        } else if (i >= 3) {
            int[] iArr7 = this.dropLevel;
            int i6 = FrameTracer.DropStatus.DROPPED_NORMAL.index;
            iArr7[i6] = iArr7[i6] + 1;
            int[] iArr8 = this.sumDropLevel;
            iArr8[i6] = iArr8[i6] + 1;
            int i7 = this.belongColor;
            if (i7 != this.frozenColor && i7 != this.highColor && i7 != this.middleColor) {
                this.belongColor = this.normalColor;
            }
        } else {
            int[] iArr9 = this.dropLevel;
            int i8 = FrameTracer.DropStatus.DROPPED_BEST.index;
            iArr9[i8] = iArr9[i8] + 1;
            int[] iArr10 = this.sumDropLevel;
            iArr10[i8] = iArr10[i8] + 1;
            int i9 = this.belongColor;
            if (i9 != this.frozenColor && i9 != this.highColor && i9 != this.middleColor && i9 != this.normalColor) {
                this.belongColor = this.bestColor;
            }
        }
        long j9 = j8 - this.lastFrames[0];
        if (f >= 200.0f) {
            float fMin = Math.min(this.maxFps, (j9 * 1000.0f) / f);
            FloatFrameView floatFrameView = this.view;
            int i10 = this.belongColor;
            int[] iArr11 = this.dropLevel;
            int i11 = FrameTracer.DropStatus.DROPPED_NORMAL.index;
            int i12 = iArr11[i11];
            int i13 = FrameTracer.DropStatus.DROPPED_MIDDLE.index;
            int i14 = iArr11[i13];
            int i15 = FrameTracer.DropStatus.DROPPED_HIGH.index;
            int i16 = iArr11[i15];
            int i17 = FrameTracer.DropStatus.DROPPED_FROZEN.index;
            int i18 = iArr11[i17];
            int[] iArr12 = this.sumDropLevel;
            updateView(floatFrameView, fMin, i10, i12, i14, i16, i18, iArr12[i11], iArr12[i13], iArr12[i15], iArr12[i17]);
            this.belongColor = this.bestColor;
            this.lastCost[0] = this.sumFrameCost;
            this.lastFrames[0] = this.sumFrames;
            mainHandler.removeCallbacks(this.updateDefaultRunnable);
            mainHandler.postDelayed(this.updateDefaultRunnable, 250L);
        }
    }

    @Override // com.tencent.matrix.trace.listeners.IDoFrameListener
    public Executor getExecutor() {
        return this.executor;
    }

    public FloatFrameView getView() {
        return this.view;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public boolean isShowing() {
        return this.isShowing;
    }

    @Override // com.tencent.matrix.listeners.IAppForeground
    public void onForeground(final boolean z) {
        Handler handler;
        MatrixLog.i(TAG, "[onForeground] isForeground:%s", Boolean.valueOf(z));
        if (this.isEnable && (handler = mainHandler) != null) {
            handler.post(new Runnable() { // from class: com.tencent.matrix.trace.view.FrameDecorator.9
                @Override // java.lang.Runnable
                public void run() {
                    if (z) {
                        FrameDecorator.this.show();
                    } else {
                        FrameDecorator.this.dismiss();
                    }
                }
            });
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.clickListener = onClickListener;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void setExtraInfo(String str) {
        TextView textView;
        if (getView() == null || (textView = (TextView) getView().findViewById(R.id.extra_info)) == null) {
            return;
        }
        textView.setText(str);
    }

    public void show() {
        if (this.isEnable) {
            mainHandler.post(new Runnable() { // from class: com.tencent.matrix.trace.view.FrameDecorator.7
                @Override // java.lang.Runnable
                public void run() {
                    if (FrameDecorator.this.isShowing) {
                        return;
                    }
                    FrameDecorator.this.isShowing = true;
                    FrameDecorator.this.windowManager.addView(FrameDecorator.this.view, FrameDecorator.this.layoutParam);
                }
            });
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private FrameDecorator(Context context, final FloatFrameView floatFrameView) {
        this.displayMetrics = new DisplayMetrics();
        this.isEnable = true;
        this.lastCost = new long[1];
        this.belongColor = this.bestColor;
        this.lastFrames = new long[1];
        this.dropLevel = new int[FrameTracer.DropStatus.values().length];
        this.sumDropLevel = new int[FrameTracer.DropStatus.values().length];
        this.lastVisibleScene = MapController.DEFAULT_LAYER_TAG;
        this.updateDefaultRunnable = new Runnable() { // from class: com.tencent.matrix.trace.view.FrameDecorator.3
            @Override // java.lang.Runnable
            public void run() {
                FrameDecorator.this.view.fpsView.setText(String.format("%.2f FPS", Float.valueOf(FrameDecorator.this.maxFps)));
                FrameDecorator.this.view.fpsView.setTextColor(FrameDecorator.this.view.getResources().getColor(R.color.level_best_color));
            }
        };
        this.executor = new Executor() { // from class: com.tencent.matrix.trace.view.FrameDecorator.5
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                FrameDecorator.this.getHandler().post(runnable);
            }
        };
        float frameIntervalNanos = (UIThreadMonitor.getMonitor().getFrameIntervalNanos() * 1.0f) / 1000000.0f;
        this.frameIntervalMs = frameIntervalNanos;
        float fRound = Math.round(1000.0f / frameIntervalNanos);
        this.maxFps = fRound;
        this.view = floatFrameView;
        floatFrameView.fpsView.setText(String.format("%.2f FPS", Float.valueOf(fRound)));
        this.bestColor = context.getResources().getColor(R.color.level_best_color);
        this.normalColor = context.getResources().getColor(R.color.level_normal_color);
        this.middleColor = context.getResources().getColor(R.color.level_middle_color);
        this.highColor = context.getResources().getColor(R.color.level_high_color);
        this.frozenColor = context.getResources().getColor(R.color.level_frozen_color);
        AppActiveMatrixDelegate.INSTANCE.addListener(this);
        floatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.tencent.matrix.trace.view.FrameDecorator.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                TracePlugin tracePlugin;
                MatrixLog.i(FrameDecorator.TAG, "onViewAttachedToWindow", new Object[0]);
                if (!Matrix.isInstalled() || (tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class)) == null) {
                    return;
                }
                tracePlugin.getFrameTracer().addListener(FrameDecorator.this);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                TracePlugin tracePlugin;
                MatrixLog.i(FrameDecorator.TAG, "onViewDetachedFromWindow", new Object[0]);
                if (!Matrix.isInstalled() || (tracePlugin = (TracePlugin) Matrix.with().getPluginByClass(TracePlugin.class)) == null) {
                    return;
                }
                tracePlugin.getFrameTracer().removeListener(FrameDecorator.this);
            }
        });
        initLayoutParams(context);
        floatFrameView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.matrix.trace.view.FrameDecorator.2
            float downX = 0.0f;
            float downY = 0.0f;
            int downOffsetX = 0;
            int downOffsetY = 0;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(final View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.downX = motionEvent.getX();
                    this.downY = motionEvent.getY();
                    this.downOffsetX = FrameDecorator.this.layoutParam.x;
                    this.downOffsetY = FrameDecorator.this.layoutParam.y;
                } else if (action == 1) {
                    int[] iArr = new int[2];
                    iArr[0] = FrameDecorator.this.layoutParam.x;
                    iArr[1] = FrameDecorator.this.layoutParam.x > FrameDecorator.this.displayMetrics.widthPixels / 2 ? FrameDecorator.this.displayMetrics.widthPixels - floatFrameView.getWidth() : 0;
                    ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofInt("trans", iArr));
                    valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.matrix.trace.view.FrameDecorator.2.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (FrameDecorator.this.isShowing) {
                                FrameDecorator.this.layoutParam.x = ((Integer) valueAnimator.getAnimatedValue("trans")).intValue();
                                FrameDecorator.this.windowManager.updateViewLayout(view, FrameDecorator.this.layoutParam);
                            }
                        }
                    });
                    valueAnimatorOfPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
                    valueAnimatorOfPropertyValuesHolder.setDuration(180L).start();
                    int i = FrameDecorator.this.layoutParam.x;
                    int i2 = FrameDecorator.this.layoutParam.y;
                    if (Math.abs(i - this.downOffsetX) <= 20 && Math.abs(i2 - this.downOffsetY) <= 20 && FrameDecorator.this.clickListener != null) {
                        FrameDecorator.this.clickListener.onClick(view);
                    }
                } else if (action == 2) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    FrameDecorator.this.layoutParam.x = (int) (r2.x + ((x - this.downX) / 3.0f));
                    FrameDecorator.this.layoutParam.y = (int) (r0.y + ((y - this.downY) / 3.0f));
                    if (view != null) {
                        FrameDecorator.this.windowManager.updateViewLayout(view, FrameDecorator.this.layoutParam);
                    }
                }
                return true;
            }
        });
    }
}
