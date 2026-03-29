package com.wifi.ad.core.interactive;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import android.view.View;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.utils.WifiLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class WkInteractiveCCView extends View {
    private int allHeight;
    private int allWidth;
    private Paint clearPaint;
    private long downTime;
    private double lastX;
    private double lastY;
    private WeakReference<NestAdData> mWeakAdData;
    private Bitmap maskBitmap;
    private Canvas maskCanvas;
    private Paint maskPaint;
    private Path path;
    private double startX;
    private double startY;
    private int totalPixels;
    private int wipeScreenExtra;

    public WkInteractiveCCView(Context context, NestAdData nestAdData) {
        super(context);
        this.totalPixels = 0;
        this.wipeScreenExtra = 80;
        this.downTime = 0L;
        if (nestAdData != null) {
            this.mWeakAdData = new WeakReference<>(nestAdData);
            this.wipeScreenExtra = nestAdData.getWipeScreenExtra();
        }
        init();
    }

    private void calculateErasedPercentage() {
        if (this.maskBitmap == null || this.allWidth <= 0 || this.allHeight <= 0 || this.totalPixels <= 0) {
            return;
        }
        Executors.newCachedThreadPool().execute(new Runnable() { // from class: com.wifi.ad.core.interactive.WkInteractiveCCView.1
            @Override // java.lang.Runnable
            public void run() {
                int i = WkInteractiveCCView.this.totalPixels;
                int[] iArr = new int[i];
                WkInteractiveCCView.this.maskBitmap.getPixels(iArr, 0, WkInteractiveCCView.this.allWidth, 0, 0, WkInteractiveCCView.this.allWidth, WkInteractiveCCView.this.allHeight);
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    if ((iArr[i3] & (-16777216)) == 0) {
                        i2++;
                    }
                }
                float f = (i2 * 100.0f) / WkInteractiveCCView.this.totalPixels;
                float f2 = f < 97.0f ? f : 100.0f;
                WifiLog.d("WkInteractiveCCView calculateErasedPercentage end scale " + f2 + " wipeScreenExtra " + WkInteractiveCCView.this.wipeScreenExtra);
                if (f2 >= WkInteractiveCCView.this.wipeScreenExtra) {
                    WkInteractiveCCView.this.itemClick("1");
                }
            }
        });
    }

    private void init() {
        Paint paint = new Paint();
        this.maskPaint = paint;
        paint.setColor(855638016);
        this.maskPaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.clearPaint = paint2;
        paint2.setAlpha(0);
        this.clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.clearPaint.setAntiAlias(true);
        this.clearPaint.setDither(true);
        this.clearPaint.setStyle(Paint.Style.STROKE);
        this.clearPaint.setStrokeJoin(Paint.Join.ROUND);
        this.clearPaint.setStrokeCap(Paint.Cap.ROUND);
        this.clearPaint.setStrokeWidth(120.0f);
        this.path = new Path();
    }

    private void initMask() {
        Bitmap bitmap = this.maskBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.maskBitmap = null;
        }
        this.maskBitmap = Bitmap.createBitmap(this.allWidth, this.allHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.maskBitmap);
        this.maskCanvas = canvas;
        canvas.drawRect(0.0f, 0.0f, this.allWidth, this.allHeight, this.maskPaint);
    }

    private boolean isClickDistance() {
        return Math.abs(this.startX - this.lastX) < 5.0d && Math.abs(this.startY - this.lastY) < 5.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemClick(String str) {
        WifiLog.d("WkInteractiveCCView itemClick clickFrom " + str);
        "1".equals(str);
        WeakReference<NestAdData> weakReference = this.mWeakAdData;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        resetMask();
        WkInteractiveManager.nestAdClick(this.mWeakAdData.get(), str);
    }

    private void resetMask() {
        if (this.maskCanvas != null) {
            initMask();
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.maskBitmap, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.maskBitmap != null || getMeasuredWidth() <= 0 || getMeasuredHeight() <= 0) {
            return;
        }
        this.allWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.allHeight = measuredHeight;
        this.totalPixels = this.allWidth * measuredHeight;
        initMask();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.path.moveTo(x, y);
            this.downTime = System.currentTimeMillis();
            double d = x;
            this.lastX = d;
            double d2 = y;
            this.lastY = d2;
            this.startX = d;
            this.startY = d2;
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.path.reset();
            if (System.currentTimeMillis() - this.downTime >= 500 || !isClickDistance()) {
                calculateErasedPercentage();
            } else {
                itemClick("0");
            }
        } else if (action == 2) {
            this.lastX = x;
            this.lastY = y;
            this.path.lineTo(x, y);
            if (!isClickDistance()) {
                this.maskCanvas.drawPath(this.path, this.clearPaint);
            }
            invalidate();
        } else if (action == 3) {
        }
        return true;
    }
}
