package com.wifi.adsdk.baseview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.wifi.ad.core.utils.UIUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdRoundCornerCoverView extends View {
    private String bgColor;
    private final Paint mFillPaint;
    private final RectF mRect;
    private float radius;

    public LxAdRoundCornerCoverView(Context context) {
        super(context);
        this.mFillPaint = new Paint(1);
        this.mRect = new RectF();
        this.radius = 10.0f;
        this.bgColor = "#FFFFFF";
        init();
    }

    private void init() {
        this.mFillPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mFillPaint.setColor(-1);
        this.radius = UIUtils.dip2px(getContext(), 12.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, width, height, null, 31);
        this.mRect.set(0.0f, 0.0f, width, height);
        try {
            canvas.drawColor(Color.parseColor(this.bgColor));
            RectF rectF = this.mRect;
            float f = this.radius;
            canvas.drawRoundRect(rectF, f, f, this.mFillPaint);
            canvas.restoreToCount(iSaveLayer);
        } catch (Exception unused) {
        }
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public LxAdRoundCornerCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFillPaint = new Paint(1);
        this.mRect = new RectF();
        this.radius = 10.0f;
        this.bgColor = "#FFFFFF";
        init();
    }

    public LxAdRoundCornerCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFillPaint = new Paint(1);
        this.mRect = new RectF();
        this.radius = 10.0f;
        this.bgColor = "#FFFFFF";
        init();
    }
}
