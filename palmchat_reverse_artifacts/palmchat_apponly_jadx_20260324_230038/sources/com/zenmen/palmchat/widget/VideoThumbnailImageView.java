package com.zenmen.palmchat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class VideoThumbnailImageView extends ImageView {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private Paint mPaint;
    private int mSide;

    public VideoThumbnailImageView(Context context) {
        super(context);
        this.mSide = 1;
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ChatItemSide);
            this.mSide = typedArrayObtainStyledAttributes.getInt(3, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000d A[Catch: Exception -> 0x005b, TryCatch #0 {Exception -> 0x005b, blocks: (B:4:0x0006, B:6:0x000a, B:8:0x001e, B:7:0x000d), top: B:13:0x0006 }] */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        BitmapDrawable bitmapDrawable;
        Drawable drawable = getDrawable();
        if (drawable != null) {
            try {
                bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : (BitmapDrawable) AppContext.getContext().getResources().getDrawable(R.drawable.location_default);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        Bitmap bitmap = bitmapDrawable.getBitmap();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        int iSave = canvas.save();
        float f = getResources().getDisplayMetrics().density * 8.0f;
        Path path = new Path();
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, (Rect) null, rectF, this.mPaint);
        canvas.restoreToCount(iSave);
    }

    public void setLeftOrRight(int i) {
        this.mSide = i;
    }

    public VideoThumbnailImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSide = 1;
        init(attributeSet);
    }

    public VideoThumbnailImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSide = 1;
        init(attributeSet);
    }
}
