package com.zenmen.palmchat.QRCodeScan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.media3.common.C;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ScannerTargetView extends View {
    private static final long ANIMATION_DELAY = 10;
    private static final int BOARDER_LINE_WIDTH = 1;
    private static final int mScannerBarAnimationInterval = 4;
    private Bitmap mBackgroundLeftBottom;
    private Bitmap mBackgroundLeftTop;
    private Bitmap mBackgroundRightBottom;
    private Bitmap mBackgroundRightTop;
    private int mBoardLineColor;
    private int mMaskColor;
    private Paint mPaint;
    private Bitmap mScannerBar;
    private Rect mScannerBarPositionRect;
    private Rect mTargetRect;

    public ScannerTargetView(Context context) {
        super(context);
        this.mMaskColor = C.ENCODING_PCM_32BIT_BIG_ENDIAN;
        this.mBoardLineColor = -10066330;
        initUI();
    }

    private void drawText(Canvas canvas, String str, int i, Paint paint) {
        paint.setColor(getContext().getResources().getColor(R.color.qr_scan_des));
        paint.setTextSize(getContext().getResources().getDimension(R.dimen.text_size_small));
        canvas.drawText(str, (getWidth() - getFontlength(paint, str)) / 2.0f, i + getContext().getResources().getDimension(R.dimen.search_edit_text_height), paint);
    }

    public static float getFontlength(Paint paint, String str) {
        return paint.measureText(str);
    }

    private void initUI() {
        this.mPaint = new Paint(1);
        this.mBackgroundLeftTop = BitmapFactory.decodeResource(getResources(), R.drawable.scanner_left_top);
        this.mBackgroundLeftBottom = BitmapFactory.decodeResource(getResources(), R.drawable.scanner_left_bottom);
        this.mBackgroundRightTop = BitmapFactory.decodeResource(getResources(), R.drawable.scanner_right_top);
        this.mBackgroundRightBottom = BitmapFactory.decodeResource(getResources(), R.drawable.scanner_right_bottom);
        this.mScannerBar = BitmapFactory.decodeResource(getResources(), R.drawable.scanner_bar);
        this.mScannerBarPositionRect = new Rect();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.mBackgroundLeftTop;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBackgroundLeftTop.recycle();
        }
        Bitmap bitmap2 = this.mBackgroundLeftBottom;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.mBackgroundLeftBottom.recycle();
        }
        Bitmap bitmap3 = this.mBackgroundRightTop;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.mBackgroundRightTop.recycle();
        }
        Bitmap bitmap4 = this.mBackgroundRightBottom;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            this.mBackgroundRightBottom.recycle();
        }
        Bitmap bitmap5 = this.mScannerBar;
        if (bitmap5 == null || bitmap5.isRecycled()) {
            return;
        }
        this.mScannerBar.recycle();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (this.mTargetRect == null) {
            return;
        }
        this.mPaint.setColor(this.mMaskColor);
        float f = width;
        canvas.drawRect(0.0f, 0.0f, f, this.mTargetRect.top, this.mPaint);
        Rect rect = this.mTargetRect;
        canvas.drawRect(0.0f, rect.top, rect.left, rect.bottom, this.mPaint);
        Rect rect2 = this.mTargetRect;
        canvas.drawRect(rect2.right, rect2.top, f, rect2.bottom, this.mPaint);
        canvas.drawRect(0.0f, this.mTargetRect.bottom, f, height, this.mPaint);
        drawText(canvas, getContext().getString(R.string.string_scan_des), this.mTargetRect.bottom, this.mPaint);
        this.mPaint.setStrokeWidth(0.0f);
        Bitmap bitmap = this.mBackgroundLeftTop;
        Rect rect3 = this.mTargetRect;
        canvas.drawBitmap(bitmap, rect3.left - 25, rect3.top - 25, this.mPaint);
        canvas.drawBitmap(this.mBackgroundRightTop, (this.mTargetRect.right - r0.getWidth()) + 25, this.mTargetRect.top - 25, this.mPaint);
        Bitmap bitmap2 = this.mBackgroundLeftBottom;
        Rect rect4 = this.mTargetRect;
        canvas.drawBitmap(bitmap2, rect4.left - 25, (rect4.bottom - bitmap2.getHeight()) + 25, this.mPaint);
        canvas.drawBitmap(this.mBackgroundRightBottom, (this.mTargetRect.right - r0.getWidth()) + 25, (this.mTargetRect.bottom - this.mBackgroundRightBottom.getHeight()) + 25, this.mPaint);
        this.mPaint.setStrokeWidth(0.0f);
        canvas.drawBitmap(this.mScannerBar, (Rect) null, this.mScannerBarPositionRect, this.mPaint);
        Rect rect5 = this.mScannerBarPositionRect;
        rect5.top += 4;
        int i = rect5.bottom + 4;
        rect5.bottom = i;
        Rect rect6 = this.mTargetRect;
        if (i > rect6.bottom) {
            rect5.top = rect6.top;
            rect5.bottom = rect6.top + this.mScannerBar.getHeight();
        }
        postInvalidateDelayed(ANIMATION_DELAY);
    }

    public void setTargetRect(Rect rect) {
        this.mTargetRect = rect;
        Rect rect2 = this.mScannerBarPositionRect;
        rect2.top = rect.top;
        rect2.bottom = rect.top + this.mScannerBar.getHeight();
        Rect rect3 = this.mScannerBarPositionRect;
        Rect rect4 = this.mTargetRect;
        rect3.left = rect4.left;
        rect3.right = rect4.right;
    }

    public ScannerTargetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaskColor = C.ENCODING_PCM_32BIT_BIG_ENDIAN;
        this.mBoardLineColor = -10066330;
        initUI();
    }

    public ScannerTargetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaskColor = C.ENCODING_PCM_32BIT_BIG_ENDIAN;
        this.mBoardLineColor = -10066330;
        initUI();
    }
}
