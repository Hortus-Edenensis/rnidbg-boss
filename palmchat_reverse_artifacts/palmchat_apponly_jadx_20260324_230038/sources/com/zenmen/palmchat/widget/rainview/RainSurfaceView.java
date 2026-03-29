package com.zenmen.palmchat.widget.rainview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.rainview.a;
import defpackage.lg2;
import defpackage.me1;
import defpackage.xw1;
import defpackage.yc0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RainSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private static final int MSG_DRAW = 1;
    private static final String TAG = "RainSurfaceView";
    private Bitmap bitmap;
    boolean canvasAvailable;
    private Drawable drawable;
    private List<com.zenmen.palmchat.widget.rainview.a> fallObjects;
    private xw1 finishListener;
    private int intervalTime;
    private boolean isAutoPlay;
    private boolean isChangeWind;
    private boolean isDebug;
    private boolean isOnce;
    private boolean isPowerMode;
    private boolean isRandomSize;
    private boolean isRandomSpeed;
    private boolean isRandomWind;
    private boolean isRotate;
    private boolean isTrans;
    private int itemHeight;
    private int itemWidth;
    private long lastTime;
    private f mDrawTask;
    Handler mHandler;
    private Handler.Callback mHandlerCallback;
    HandlerThread mHandlerThread;
    SurfaceHolder mSurfaceHolder;
    long mTime;
    private int maxNum;
    private float maxScale;
    private float minScale;
    private boolean raining;
    private int speed;
    private float startTransPercent;
    private float transStatusPercent;
    private int viewHeight;
    private int viewWidth;
    private int wind;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                RainSurfaceView rainSurfaceView = RainSurfaceView.this;
                if (!rainSurfaceView.canvasAvailable) {
                    rainSurfaceView.mHandler.removeMessages(1);
                    return true;
                }
                rainSurfaceView.mHandler.removeMessages(1);
                RainSurfaceView rainSurfaceView2 = RainSurfaceView.this;
                rainSurfaceView2.mHandler.post(rainSurfaceView2.mDrawTask);
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnTouchListener {
        public b(yc0 yc0Var) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            for (com.zenmen.palmchat.widget.rainview.a aVar : RainSurfaceView.this.fallObjects) {
                if (!aVar.E && aVar.d(motionEvent.getX(), motionEvent.getY())) {
                    throw null;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RainSurfaceView.this.setVisibility(4);
            RainSurfaceView.this.raining = false;
            RainSurfaceView.this.clear();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RainSurfaceView.this.mHandler.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RainSurfaceView.this.mHandler.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SurfaceHolder f16059a;

        public f(SurfaceHolder surfaceHolder) {
            this.f16059a = surfaceHolder;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"WrongCall"})
        public void run() {
            Canvas canvasLockCanvas = null;
            try {
                canvasLockCanvas = this.f16059a.lockCanvas();
                if (canvasLockCanvas == null) {
                    RainSurfaceView.this.mHandler.removeMessages(1);
                    if (canvasLockCanvas != null) {
                        try {
                            this.f16059a.unlockCanvasAndPost(canvasLockCanvas);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                synchronized (this.f16059a) {
                    if (RainSurfaceView.this.raining) {
                        RainSurfaceView rainSurfaceView = RainSurfaceView.this;
                        if (rainSurfaceView.canvasAvailable) {
                            rainSurfaceView.logFPS();
                            RainSurfaceView.this.drawImp(canvasLockCanvas);
                            try {
                                this.f16059a.unlockCanvasAndPost(canvasLockCanvas);
                                return;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                return;
                            }
                        }
                    }
                    RainSurfaceView.this.mHandler.removeMessages(1);
                    RainSurfaceView.this.stopRain();
                    try {
                        this.f16059a.unlockCanvasAndPost(canvasLockCanvas);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (canvasLockCanvas != null) {
                    try {
                        this.f16059a.unlockCanvasAndPost(canvasLockCanvas);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public RainSurfaceView(Context context) {
        this(context, null);
    }

    private boolean checkActivityDestroy(Context context) {
        if (context instanceof Activity) {
            return checkActivityDestroy((Activity) context);
        }
        return true;
    }

    private void debug() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.lastTime != 0) {
            Log.e(TAG, "FPS :  " + (1000 / (jCurrentTimeMillis - this.lastTime)));
        }
        this.lastTime = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void drawImp(Canvas canvas) {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        if (this.fallObjects.size() > 0) {
            boolean z = false;
            for (int i = 0; i < this.fallObjects.size(); i++) {
                this.fallObjects.get(i).b(canvas);
                if (!this.fallObjects.get(i).E) {
                    z = true;
                }
            }
            if (z) {
                this.mHandler.sendEmptyMessageDelayed(1, 5L);
            } else {
                stopRain();
                clear();
            }
        }
    }

    public static Rect getScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Rect rect = new Rect();
        windowManager.getDefaultDisplay().getRectSize(rect);
        return rect;
    }

    private void init(Context context, AttributeSet attributeSet) {
        setZOrderOnTop(true);
        setVisibility(4);
        SurfaceHolder holder = getHolder();
        this.mSurfaceHolder = holder;
        holder.addCallback(this);
        this.mSurfaceHolder.setFormat(-2);
        this.fallObjects = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RainView);
        this.isAutoPlay = typedArrayObtainStyledAttributes.getBoolean(0, true);
        this.maxNum = typedArrayObtainStyledAttributes.getInteger(5, 10);
        this.isRandomSize = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.itemWidth = (int) typedArrayObtainStyledAttributes.getDimension(4, 50.0f);
        this.itemHeight = (int) typedArrayObtainStyledAttributes.getDimension(3, 50.0f);
        this.drawable = typedArrayObtainStyledAttributes.getDrawable(2);
        this.speed = typedArrayObtainStyledAttributes.getInteger(11, 5);
        this.wind = typedArrayObtainStyledAttributes.getInteger(13, 5);
        this.isRandomSpeed = typedArrayObtainStyledAttributes.getBoolean(8, false);
        this.isRandomWind = typedArrayObtainStyledAttributes.getBoolean(9, false);
        this.isChangeWind = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.isOnce = typedArrayObtainStyledAttributes.getBoolean(6, false);
        this.isTrans = typedArrayObtainStyledAttributes.getBoolean(12, false);
        this.isRotate = typedArrayObtainStyledAttributes.getBoolean(10, false);
        HandlerThread handlerThreadA = lg2.a("SurfaceRainViewRender");
        this.mHandlerThread = handlerThreadA;
        handlerThreadA.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), this.mHandlerCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logFPS() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.mTime;
        Log.i(TAG, "SurfaceRainView deltaTime=" + j);
        Log.i(TAG, "SurfaceRainView FPS=" + (1000 / j));
        this.mTime = jUptimeMillis;
    }

    private int measureSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    private synchronized void notifySizeChange() {
        List<com.zenmen.palmchat.widget.rainview.a> list = this.fallObjects;
        if (list != null && list.size() > 0) {
            for (com.zenmen.palmchat.widget.rainview.a aVar : this.fallObjects) {
                if (!aVar.E) {
                    aVar.h(this.viewWidth, this.viewHeight);
                }
            }
        }
    }

    public synchronized void addFallObject(com.zenmen.palmchat.widget.rainview.a aVar, int i) {
        if (checkActivityDestroy(getContext())) {
            return;
        }
        if (this.viewWidth <= 0) {
            this.viewWidth = getScreenSize(getContext()).width();
        }
        if (this.viewHeight <= 0) {
            this.viewHeight = getScreenSize(getContext()).height();
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.fallObjects.add(new com.zenmen.palmchat.widget.rainview.a(aVar.w, this.viewWidth, me1.f()));
        }
    }

    public synchronized void clear() {
        List<com.zenmen.palmchat.widget.rainview.a> list = this.fallObjects;
        if (list != null) {
            list.clear();
        }
    }

    public boolean isRaining() {
        return this.raining;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.canvasAvailable = false;
        this.mHandlerThread.quit();
        clear();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMeasureSize = measureSize(600, i);
        int iMeasureSize2 = measureSize(1000, i2);
        setMeasuredDimension(iMeasureSize, iMeasureSize2);
        this.viewWidth = iMeasureSize;
        this.viewHeight = iMeasureSize2;
    }

    public void play(Activity activity) {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            play(activity, bitmap);
            return;
        }
        Drawable drawable = this.drawable;
        if (drawable != null) {
            play(activity, drawable);
        }
    }

    public void setAutoPlay(boolean z) {
        this.isAutoPlay = z;
    }

    public void setChangeWind(boolean z) {
        this.isChangeWind = z;
    }

    public RainSurfaceView setClickListener(yc0 yc0Var) {
        setOnTouchListener(new b(yc0Var));
        return this;
    }

    public void setDebug(boolean z) {
        this.isDebug = z;
    }

    public void setItemHeight(int i) {
        this.itemHeight = i;
    }

    public void setItemWidth(int i) {
        this.itemWidth = i;
    }

    public void setMaxNum(int i) {
        this.maxNum = i;
    }

    public void setOnce(boolean z) {
        this.isOnce = z;
    }

    public void setPowerMode(boolean z) {
        this.isPowerMode = z;
    }

    public void setRandomSize(boolean z, float f2, float f3) {
        this.isRandomSize = z;
        this.minScale = f2;
        this.maxScale = f3;
    }

    public void setRandomSpeed(boolean z) {
        this.isRandomSpeed = z;
    }

    public void setRandomWind(boolean z) {
        this.isRandomWind = z;
    }

    public void setRotate(boolean z) {
        this.isRotate = z;
    }

    public void setSpeed(int i) {
        this.speed = i;
    }

    public void setTrans(boolean z, float f2, float f3) {
        this.isTrans = z;
        this.startTransPercent = f2;
        this.transStatusPercent = f3;
    }

    public void setWind(int i) {
        this.wind = i;
    }

    public void startPlay(Activity activity) {
        if (this.raining) {
            return;
        }
        this.raining = true;
        setVisibility(0);
        post(new d());
    }

    public void stopRain() {
        post(new c());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.viewWidth = i2;
        this.viewHeight = i3;
        notifySizeChange();
        Log.i(TAG, "surfaceChanged");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.canvasAvailable = true;
        if (this.mDrawTask == null) {
            this.mDrawTask = new f(this.mSurfaceHolder);
        }
        Log.i(TAG, "surfaceCreated");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.canvasAvailable = false;
        if (this.raining) {
            stopRain();
        }
        Log.i(TAG, "surfaceDestroyed");
    }

    public RainSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RainSurfaceView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.intervalTime = 20;
        this.isPowerMode = true;
        this.startTransPercent = 0.0f;
        this.transStatusPercent = 0.0f;
        this.mHandlerCallback = new a();
        this.lastTime = 0L;
        init(context, attributeSet);
    }

    public static boolean checkActivityDestroy(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    private void play(Activity activity, Object obj) {
        clear();
        if (this.raining) {
            return;
        }
        this.raining = true;
        if (obj == null) {
            return;
        }
        if (getParent() == null) {
            ((ViewGroup) activity.getWindow().getDecorView()).addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
        addFallObject(new a.C1149a(obj).u(this.speed, this.isRandomSpeed).x(this.wind, this.isRandomWind, this.isChangeWind).t(this.itemWidth, this.itemHeight).r(this.isRandomSize, this.minScale, this.maxScale).q(this.isOnce).v(this.isTrans).s(this.isRotate).w(this.startTransPercent, this.transStatusPercent).o(), this.maxNum);
        setVisibility(0);
        post(new e());
    }

    public RainSurfaceView setFinishListener(xw1 xw1Var) {
        return this;
    }
}
