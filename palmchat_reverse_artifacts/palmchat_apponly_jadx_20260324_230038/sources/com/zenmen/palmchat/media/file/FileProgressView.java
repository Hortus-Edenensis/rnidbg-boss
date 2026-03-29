package com.zenmen.palmchat.media.file;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class FileProgressView extends View {
    private Context mContext;
    private Paint mPaint;
    private Paint mPaintMask;
    private final float radical2;
    private float startAngle;

    public FileProgressView(Context context) {
        super(context);
        this.startAngle = 0.0f;
        this.radical2 = 1.41f;
        this.mContext = context;
        initView();
    }

    private float getR() {
        return getWidth() * 1.41f;
    }

    private void initView() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaintMask = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaintMask.setColor(-1);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.mPaint.setColor(Color.argb(255, 0, 0, 0));
        canvas.drawRoundRect(rectF, this.mContext.getResources().getDimension(R.dimen.file_list_item_icon_round), this.mContext.getResources().getDimension(R.dimen.file_list_item_icon_round), this.mPaint);
        this.mPaintMask.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        float r = getR();
        float width = getWidth() * (-0.41f);
        RectF rectF2 = new RectF(width, width, r, r);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getWidth(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
        this.mPaint.setColor(Color.argb(59, 0, 0, 0));
        float f = this.startAngle;
        canvas2.drawArc(rectF2, f - 90.0f, 360.0f - f, true, this.mPaint);
        this.mPaintMask.setFilterBitmap(true);
        canvas.drawBitmap(bitmapCreateBitmap, (Rect) null, rectF2, this.mPaintMask);
        this.mPaint.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    public void setProgress(float f) {
        this.startAngle = f * 100.0f * 3.6f;
        invalidate();
    }

    public FileProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startAngle = 0.0f;
        this.radical2 = 1.41f;
        this.mContext = context;
        initView();
    }
}
