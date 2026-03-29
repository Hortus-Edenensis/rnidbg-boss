package com.zenmen.palmchat.location;

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
import android.view.View;
import android.widget.ImageView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LocationImageView extends ImageView {
    private static final int BOTTOM_COLOR = -1728053248;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    private Paint mPaint;
    private int mSide;
    private int mTextAreaHeight;
    private View mTextAreaView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LocationImageView.this.getDrawable() == null) {
                LocationImageView.this.setImageResource(R.drawable.location_default);
            } else {
                LocationImageView locationImageView = LocationImageView.this;
                locationImageView.invalidate(0, locationImageView.getHeight() - LocationImageView.this.mTextAreaHeight, LocationImageView.this.getWidth(), LocationImageView.this.getHeight());
            }
        }
    }

    public LocationImageView(Context context) {
        super(context);
        this.mTextAreaHeight = -1;
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
        post(new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000d A[Catch: Exception -> 0x009a, TryCatch #0 {Exception -> 0x009a, blocks: (B:4:0x0006, B:6:0x000a, B:8:0x001e, B:10:0x0056, B:12:0x005a, B:13:0x0060, B:7:0x000d), top: B:18:0x0006 }] */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDraw(Canvas canvas) {
        BitmapDrawable bitmapDrawable;
        View view;
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
        if (this.mTextAreaHeight == -1 && (view = this.mTextAreaView) != null) {
            this.mTextAreaHeight = view.getHeight();
        }
        Rect rect = new Rect(0, (getHeight() + 0) - this.mTextAreaHeight, getWidth(), getHeight());
        canvas.drawBitmap(bitmap, (Rect) null, rectF, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(-1728053248);
        canvas.drawRect(rect, this.mPaint);
        this.mPaint.setColor(-16777216);
        canvas.restoreToCount(iSave);
    }

    public void setLeftOrRight(int i) {
        this.mSide = i;
    }

    public void setTextAreaHeight(int i) {
        this.mTextAreaHeight = i;
    }

    public void setmTextAreaHeight(View view) {
        this.mTextAreaView = view;
    }

    public LocationImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextAreaHeight = -1;
        this.mSide = 1;
        init(attributeSet);
    }

    public LocationImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTextAreaHeight = -1;
        this.mSide = 1;
        init(attributeSet);
    }
}
