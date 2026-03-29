package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class AdRoundCornerCoverView extends View {
    private final Paint mFillPaint;
    private final RectF mRect;
    private float radius;

    public AdRoundCornerCoverView(Context context) {
        super(context);
        this.mFillPaint = new Paint(1);
        this.mRect = new RectF();
        this.radius = 10.0f;
        init();
    }

    private void init() {
        this.mFillPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mFillPaint.setColor(-1);
    }

    private void initRadius(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AdRoundCornerCoverView);
        if (typedArrayObtainStyledAttributes != null) {
            this.radius = typedArrayObtainStyledAttributes.getDimension(0, this.radius);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, width, height, null, 31);
        this.mRect.set(0.0f, 0.0f, width, height);
        canvas.drawColor(-1);
        RectF rectF = this.mRect;
        float f = this.radius;
        canvas.drawRoundRect(rectF, f, f, this.mFillPaint);
        canvas.restoreToCount(iSaveLayer);
    }

    public AdRoundCornerCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFillPaint = new Paint(1);
        this.mRect = new RectF();
        this.radius = 10.0f;
        init();
        initRadius(context, attributeSet);
    }

    public AdRoundCornerCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFillPaint = new Paint(1);
        this.mRect = new RectF();
        this.radius = 10.0f;
        init();
        initRadius(context, attributeSet);
    }
}
