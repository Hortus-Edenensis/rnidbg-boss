package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.zenmen.giftkit.R$color;
import defpackage.k86;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class RedDeleteLineText extends AppCompatTextView {
    int endPosition;
    Paint linePaint;
    boolean show;
    int startPosition;

    public RedDeleteLineText(Context context) {
        super(context);
        this.show = false;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.show) {
            getLayout().getLineBounds(getLayout().getLineForOffset(this.startPosition), new Rect());
            canvas.drawLine(getLayout().getPrimaryHorizontal(this.startPosition), r0.centerY(), getLayout().getSecondaryHorizontal(this.endPosition), r0.centerY(), this.linePaint);
        }
    }

    public void setDeleteText(String str) {
        super.setText((CharSequence) str);
        if (!TextUtils.isEmpty(str)) {
            this.show = true;
            this.startPosition = 0;
            this.endPosition = str.length();
            if (this.linePaint == null) {
                Paint paint = new Paint();
                this.linePaint = paint;
                paint.setAntiAlias(true);
                this.linePaint.setStrokeWidth(k86.e(getContext(), 1.0f));
                this.linePaint.setColor(getResources().getColor(R$color.Gg));
            }
        }
        invalidate();
    }

    public void setText(String str) {
        this.show = false;
        super.setText((CharSequence) str);
    }

    public RedDeleteLineText(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.show = false;
    }

    public RedDeleteLineText(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.show = false;
    }
}
