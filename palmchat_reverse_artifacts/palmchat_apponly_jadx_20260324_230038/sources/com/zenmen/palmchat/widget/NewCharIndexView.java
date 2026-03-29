package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.MotionEventCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NewCharIndexView extends View {
    private static final int BG_COLOR_PRESSED = 1337966527;
    private static final int FONT_COLOR = -11119018;
    private static final int FONT_SIZE = 14;
    public static final char[] charArray = {8593, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '#'};
    public char[] mCharArray;
    private a mOnCharacterTouchedListener;
    private TextPaint mPaint;
    private boolean mPressed;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
    }

    public NewCharIndexView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TextPaint textPaint = new TextPaint();
        this.mPaint = textPaint;
        textPaint.setTextSize(context.getResources().getDisplayMetrics().density * 14.0f);
        this.mPaint.setAntiAlias(true);
    }

    private void onTouch(float f) {
        int measuredHeight = getMeasuredHeight();
        char[] cArr = this.mCharArray;
        float length = (int) (f / (measuredHeight / cArr.length));
        if (length >= 0.0f && length >= cArr.length) {
            int length2 = cArr.length;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPressed) {
            this.mPaint.setColor(BG_COLOR_PRESSED);
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.mPaint);
        }
        this.mPaint.setColor(FONT_COLOR);
        int measuredHeight = getMeasuredHeight() / this.mCharArray.length;
        Rect rect = new Rect();
        int i = 0;
        while (true) {
            char[] cArr = this.mCharArray;
            if (i >= cArr.length) {
                return;
            }
            String strValueOf = String.valueOf(cArr[i]);
            this.mPaint.getTextBounds(strValueOf, 0, 1, rect);
            int measuredWidth = (int) ((getMeasuredWidth() - this.mPaint.measureText(strValueOf)) / 2.0f);
            int i2 = rect.bottom;
            canvas.drawText(strValueOf, measuredWidth, ((i * measuredHeight) + (((i2 - rect.top) + measuredHeight) / 2)) - i2, this.mPaint);
            i++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.mPressed = true;
            onTouch(motionEvent.getY());
            invalidate();
        } else if (actionMasked == 1) {
            this.mPressed = false;
            invalidate();
        } else if (actionMasked == 2) {
            onTouch(motionEvent.getY());
        } else if (actionMasked == 3) {
        }
        return true;
    }

    public void setCharArray(char[] cArr) {
        this.mCharArray = cArr;
        invalidate();
    }

    public void setOnCharacterTouchedListener(a aVar) {
    }
}
