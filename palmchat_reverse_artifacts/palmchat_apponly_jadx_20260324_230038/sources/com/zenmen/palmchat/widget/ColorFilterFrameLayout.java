package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.huawei.openalliance.ad.constant.bq;
import defpackage.vs0;
import defpackage.zn6;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ColorFilterFrameLayout extends FrameLayout {
    private boolean enable;
    private Paint mPaint;

    public ColorFilterFrameLayout(Context context) {
        super(context);
        this.enable = false;
        initPaint();
    }

    private void initPaint() {
        boolean zIsEnable = isEnable();
        this.enable = zIsEnable;
        if (zIsEnable) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setColor(Color.argb(255, 255, 128, 102));
            this.mPaint.setColorFilter(new ColorMatrixColorFilter(new float[]{0.33f, 0.59f, 0.11f, 0.0f, 0.0f, 0.33f, 0.59f, 0.11f, 0.0f, 0.0f, 0.33f, 0.59f, 0.11f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
            zn6.c("grayfilter", "view");
        }
    }

    private boolean isEnable() {
        JSONObject config = vs0.a().getConfig("grayFilter");
        if (config == null || !config.optBoolean("enable", false)) {
            return false;
        }
        long jOptLong = config.optLong("startTime", 0L) * 1000;
        long jOptLong2 = config.optLong(bq.f.h, 0L) * 1000;
        long jCurrentTimeMillis = System.currentTimeMillis();
        return jCurrentTimeMillis > jOptLong && jCurrentTimeMillis < jOptLong2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.enable && this.mPaint != null) {
            canvas.saveLayer(new RectF(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight()), this.mPaint, 31);
        }
        super.dispatchDraw(canvas);
    }

    public void onResume() {
        if (!this.enable || this.mPaint == null) {
            return;
        }
        this.enable = isEnable();
    }

    public ColorFilterFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.enable = false;
        initPaint();
    }

    public ColorFilterFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.enable = false;
        initPaint();
    }
}
