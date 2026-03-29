package com.zenmen.palmchat.circle.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleExpandTextView extends AppCompatTextView {
    private a mCallback;
    private String mText;
    private int maxLineCount;
    private StaticLayout sl;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void b();
    }

    public CircleExpandTextView(Context context) {
        super(context);
        this.mText = "";
        this.maxLineCount = 3;
    }

    private void setChanged() {
        requestLayout();
    }

    public int getAllLineCount() {
        StaticLayout staticLayout = this.sl;
        if (staticLayout == null) {
            return 0;
        }
        return staticLayout.getLineCount();
    }

    public int getLineEndOffSet(int i) {
        if (i > 0 && this.sl != null) {
            return getAllLineCount() > i ? this.sl.getLineEnd(i - 1) : this.mText.length();
        }
        return 0;
    }

    public int getMaxLineCount() {
        return this.maxLineCount;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        StaticLayout staticLayout = new StaticLayout(this.mText, getPaint(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        this.sl = staticLayout;
        int lineCount = staticLayout.getLineCount();
        int i3 = this.maxLineCount;
        if (lineCount > i3) {
            this.mCallback.a();
            lineCount = i3;
        } else {
            setText(this.mText);
            this.mCallback.b();
        }
        int iHeight = 0;
        for (int i4 = 0; i4 < lineCount; i4++) {
            Rect rect = new Rect();
            this.sl.getLineBounds(i4, rect);
            iHeight += rect.height();
            if (i4 != lineCount - 1) {
                iHeight = (int) (iHeight + getLineSpacingExtra());
            }
        }
        setMeasuredDimension(getMeasuredWidth(), iHeight + getPaddingTop() + getPaddingBottom());
    }

    public CircleExpandTextView setCallback(a aVar) {
        this.mCallback = aVar;
        return this;
    }

    public void setExpandText(String str) {
        if (str == null) {
            str = "";
        }
        this.mText = str;
        setText(str);
    }

    public CircleExpandTextView setMaxLineCount(int i) {
        this.maxLineCount = i;
        setChanged();
        return this;
    }

    public CircleExpandTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mText = "";
        this.maxLineCount = 3;
    }

    public CircleExpandTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mText = "";
        this.maxLineCount = 3;
    }
}
