package com.zenmen.media.camera.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class HorizontalselectedView extends View {
    private int anInt;
    private float anOffset;
    private int centerTextHeight;
    private Context context;
    private float downX;
    private boolean firstVisible;
    private int height;
    private int n;
    private Rect rect;
    private int seeSize;
    private int selectedColor;
    private Paint selectedPaint;
    private float selectedTextSize;
    private List<String> strings;
    private int textColor;
    private int textHeight;
    private TextPaint textPaint;
    private float textSize;
    private int textWidth;
    private int width;

    public HorizontalselectedView(Context context) {
        this(context, null);
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalselectedView);
        this.seeSize = typedArrayObtainStyledAttributes.getInteger(0, 3);
        this.selectedTextSize = typedArrayObtainStyledAttributes.getDimension(2, 50.0f);
        this.selectedColor = typedArrayObtainStyledAttributes.getColor(1, this.context.getResources().getColor(android.R.color.black));
        this.textSize = typedArrayObtainStyledAttributes.getDimension(4, 40.0f);
        this.textColor = typedArrayObtainStyledAttributes.getColor(3, this.context.getResources().getColor(android.R.color.darker_gray));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initPaint() {
        TextPaint textPaint = new TextPaint(1);
        this.textPaint = textPaint;
        textPaint.setTextSize(this.textSize);
        this.textPaint.setColor(this.textColor);
        TextPaint textPaint2 = new TextPaint(1);
        this.selectedPaint = textPaint2;
        textPaint2.setColor(this.selectedColor);
        this.selectedPaint.setTextSize(this.selectedTextSize);
    }

    public String getSelectedString() {
        if (this.strings.size() != 0) {
            return this.strings.get(this.n);
        }
        return null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.firstVisible) {
            this.width = getWidth();
            this.height = getHeight();
            this.anInt = this.width / this.seeSize;
            this.firstVisible = false;
        }
        int i = this.n;
        if (i < 0 || i > this.strings.size() - 1) {
            return;
        }
        String str = this.strings.get(this.n);
        this.selectedPaint.getTextBounds(str, 0, str.length(), this.rect);
        int iWidth = this.rect.width();
        this.centerTextHeight = this.rect.height();
        canvas.drawText(this.strings.get(this.n), ((getWidth() / 2) - (iWidth / 2)) + this.anOffset, (getHeight() / 2) + (this.centerTextHeight / 2), this.selectedPaint);
        for (int i2 = 0; i2 < this.strings.size(); i2++) {
            int i3 = this.n;
            if (i3 > 0 && i3 < this.strings.size() - 1) {
                this.textPaint.getTextBounds(this.strings.get(this.n - 1), 0, this.strings.get(this.n - 1).length(), this.rect);
                int iWidth2 = this.rect.width();
                this.textPaint.getTextBounds(this.strings.get(this.n + 1), 0, this.strings.get(this.n + 1).length(), this.rect);
                this.textWidth = (iWidth2 + this.rect.width()) / 2;
            }
            if (i2 == 0) {
                this.textPaint.getTextBounds(this.strings.get(0), 0, this.strings.get(0).length(), this.rect);
                this.textHeight = this.rect.height();
            }
            if (i2 != this.n) {
                canvas.drawText(this.strings.get(i2), ((((i2 - this.n) * this.anInt) + (getWidth() / 2)) - (this.textWidth / 2)) + this.anOffset, (getHeight() / 2) + (this.textHeight / 2), this.textPaint);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        Log.e("action", "onTouchEvent: " + motionEvent.getAction());
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downX = motionEvent.getX();
        } else if (action == 1) {
            this.anOffset = 0.0f;
            invalidate();
        } else if (action == 2) {
            float x = motionEvent.getX();
            int i2 = this.n;
            if (i2 == 0 || i2 == this.strings.size() - 1) {
                this.anOffset = (float) (((double) (x - this.downX)) / 1.5d);
            } else {
                this.anOffset = x - this.downX;
            }
            float f = this.downX;
            if (x > f) {
                if (x - f >= this.anInt && (i = this.n) > 0) {
                    this.anOffset = 0.0f;
                    this.n = i - 1;
                    this.downX = x;
                }
            } else if (f - x >= this.anInt && this.n < this.strings.size() - 1) {
                this.anOffset = 0.0f;
                this.n++;
                this.downX = x;
            }
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAnLeftOffset() {
        if (this.n < this.strings.size() - 1) {
            this.n++;
            invalidate();
        }
    }

    public void setAnRightOffset() {
        int i = this.n;
        if (i > 0) {
            this.n = i - 1;
            invalidate();
        }
    }

    public void setData(List<String> list) {
        this.strings = list;
        this.n = list.size() / 2;
        invalidate();
    }

    public void setSeeSize(int i) {
        if (this.seeSize > 0) {
            this.seeSize = i;
            invalidate();
        }
    }

    public HorizontalselectedView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalselectedView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.strings = new ArrayList();
        this.seeSize = 5;
        this.firstVisible = true;
        this.rect = new Rect();
        this.textWidth = 0;
        this.textHeight = 0;
        this.centerTextHeight = 0;
        this.context = context;
        setWillNotDraw(false);
        setClickable(true);
        initAttrs(attributeSet);
        initPaint();
    }
}
