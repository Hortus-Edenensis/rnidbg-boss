package com.zenmen.palmchat.widget.rainview;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.rainview.a;
import defpackage.xw1;
import defpackage.yc0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RainView extends View {
    private static final String TAG = "RainView";
    private Bitmap bitmap;
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
    private int maxNum;
    private float maxScale;
    private float minScale;
    private Runnable runnable;
    private int speed;
    private float startTransPercent;
    private float transStatusPercent;
    private int viewHeight;
    private int viewWidth;
    private int wind;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnTouchListener {
        public a(yc0 yc0Var) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            for (com.zenmen.palmchat.widget.rainview.a aVar : RainView.this.fallObjects) {
                if (!aVar.E && aVar.d(motionEvent.getX(), motionEvent.getY())) {
                    throw null;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (RainView.this.isDebug) {
                RainView.this.debug();
            }
            RainView.this.invalidate();
        }
    }

    public RainView(Context context) {
        this(context, null);
    }

    private boolean checkActivityDestroy(Context context) {
        if (context instanceof Activity) {
            return checkActivityDestroy((Activity) context);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.lastTime != 0) {
            Log.e(TAG, "FPS :  " + (1000 / (jCurrentTimeMillis - this.lastTime)));
        }
        this.lastTime = jCurrentTimeMillis;
    }

    public static Rect getScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Rect rect = new Rect();
        windowManager.getDefaultDisplay().getRectSize(rect);
        return rect;
    }

    private void init(Context context, AttributeSet attributeSet) {
        Drawable drawable;
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
        if (!this.isAutoPlay || (drawable = this.drawable) == null) {
            return;
        }
        play(drawable);
    }

    private int measureSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    private void notifySizeChange() {
        List<com.zenmen.palmchat.widget.rainview.a> list = this.fallObjects;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (com.zenmen.palmchat.widget.rainview.a aVar : this.fallObjects) {
            if (!aVar.E) {
                aVar.h(this.viewWidth, this.viewHeight);
            }
        }
    }

    public void addFallObject(com.zenmen.palmchat.widget.rainview.a aVar, int i) {
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
            this.fallObjects.add(new com.zenmen.palmchat.widget.rainview.a(aVar.w, this.viewWidth, this.viewHeight));
        }
        invalidate();
    }

    public void clear() {
        List<com.zenmen.palmchat.widget.rainview.a> list = this.fallObjects;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Log.d(TAG, "invalidate");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw " + this.fallObjects.size());
        if (this.fallObjects.size() > 0) {
            boolean z = false;
            for (int i = 0; i < this.fallObjects.size(); i++) {
                this.fallObjects.get(i).b(canvas);
                if (!this.fallObjects.get(i).E) {
                    z = true;
                }
            }
            if (!z) {
                clear();
            } else if (this.isPowerMode) {
                getHandler().post(this.runnable);
            } else {
                getHandler().postDelayed(this.runnable, this.intervalTime);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMeasureSize = measureSize(600, i);
        int iMeasureSize2 = measureSize(1000, i2);
        setMeasuredDimension(iMeasureSize, iMeasureSize2);
        this.viewWidth = iMeasureSize;
        this.viewHeight = iMeasureSize2;
        notifySizeChange();
    }

    public void play() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            play(bitmap);
            return;
        }
        Drawable drawable = this.drawable;
        if (drawable != null) {
            play(drawable);
        }
    }

    public void setAutoPlay(boolean z) {
        this.isAutoPlay = z;
    }

    public void setChangeWind(boolean z) {
        this.isChangeWind = z;
    }

    public RainView setClickListener(yc0 yc0Var) {
        setOnTouchListener(new a(yc0Var));
        return this;
    }

    public void setDebug(boolean z) {
        this.isDebug = z;
    }

    public RainView setItemBitmap(Bitmap bitmap) {
        return setItemBitmap(bitmap, false);
    }

    public RainView setItemDrawable(Drawable drawable) {
        return setItemDrawable(drawable, false);
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

    public void setRandomSize(boolean z, float f, float f2) {
        this.isRandomSize = z;
        this.minScale = f;
        this.maxScale = f2;
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

    public void setTrans(boolean z, float f, float f2) {
        this.isTrans = z;
        this.startTransPercent = f;
        this.transStatusPercent = f2;
    }

    public void setWind(int i) {
        this.wind = i;
    }

    public RainView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RainView setItemBitmap(Bitmap bitmap, boolean z) {
        this.bitmap = bitmap;
        if (z) {
            play(bitmap);
        }
        return this;
    }

    public RainView setItemDrawable(Drawable drawable, boolean z) {
        this.drawable = drawable;
        if (z) {
            play(drawable);
        }
        return this;
    }

    public RainView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.intervalTime = 20;
        this.isPowerMode = true;
        this.startTransPercent = 0.0f;
        this.transStatusPercent = 0.0f;
        this.runnable = new b();
        this.lastTime = 0L;
        init(context, attributeSet);
    }

    public static boolean checkActivityDestroy(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isDestroyed();
    }

    private void play(Object obj) {
        clear();
        if (obj == null) {
            return;
        }
        addFallObject(new a.C1149a(obj).u(this.speed, this.isRandomSpeed).x(this.wind, this.isRandomWind, this.isChangeWind).t(this.itemWidth, this.itemHeight).r(this.isRandomSize, this.minScale, this.maxScale).q(this.isOnce).v(this.isTrans).s(this.isRotate).w(this.startTransPercent, this.transStatusPercent).o(), this.maxNum);
    }

    public RainView setFinishListener(xw1 xw1Var) {
        return this;
    }
}
