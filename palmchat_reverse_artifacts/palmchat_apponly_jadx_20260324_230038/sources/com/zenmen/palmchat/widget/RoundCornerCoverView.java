package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.zenmen.palmchat.framework.R$styleable;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RoundCornerCoverView extends View {
    private final Paint mFillPaint;
    private final RectF mRect;
    private float rad;

    public RoundCornerCoverView(Context context) {
        super(context);
        this.mFillPaint = new Paint(1);
        this.mRect = new RectF();
        this.rad = 0.0f;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mFillPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.mFillPaint.setColor(-1);
        if (attributeSet != null) {
            this.rad = context.obtainStyledAttributes(attributeSet, R$styleable.RoundCornerCoverView).getDimension(R$styleable.RoundCornerCoverView_cornerRad, me1.b(getContext(), 8));
        } else {
            this.rad = me1.b(getContext(), 8);
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
        float f = this.rad;
        canvas.drawRoundRect(rectF, f, f, this.mFillPaint);
        canvas.restoreToCount(iSaveLayer);
    }

    public RoundCornerCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFillPaint = new Paint(1);
        this.mRect = new RectF();
        this.rad = 0.0f;
        init(context, attributeSet);
    }

    public RoundCornerCoverView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFillPaint = new Paint(1);
        this.mRect = new RectF();
        this.rad = 0.0f;
        init(context, attributeSet);
    }
}
