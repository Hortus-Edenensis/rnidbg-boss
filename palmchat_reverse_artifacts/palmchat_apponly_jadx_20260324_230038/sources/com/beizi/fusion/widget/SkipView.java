package com.beizi.fusion.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.beizi.fusion.tool.ap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class SkipView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4789a;
    private TextPaint b;
    private float c;
    private float d;
    private boolean e;
    private RectF f;
    private RectF g;
    private int h;
    private boolean i;
    private SparseIntArray j;
    private final a k;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        int a(int i, RectF rectF);
    }

    public SkipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 20.0f;
        this.f = new RectF();
        this.i = true;
        this.k = new a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.a
            @TargetApi(16)
            public int a(int i2, RectF rectF) {
                SkipView.this.b.setTextSize(i2);
                String string = SkipView.this.getText().toString();
                SkipView.this.f.bottom = SkipView.this.b.getFontSpacing();
                SkipView.this.f.right = SkipView.this.b.measureText(string);
                SkipView.this.f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f) ? -1 : 1;
            }
        };
        init(context);
    }

    public void init(Context context) {
        setGravity(17);
        setLines(1);
        setMaxLines(1);
        setTextColor(-1);
        a(context, 0);
        TextPaint textPaint = new TextPaint();
        this.b = textPaint;
        textPaint.set(getPaint());
        this.c = getTextSize();
        this.g = new RectF();
        this.j = new SparseIntArray();
        this.e = true;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        SparseIntArray sparseIntArray = this.j;
        if (sparseIntArray != null) {
            sparseIntArray.clear();
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        a();
    }

    public void setData(int i, int i2) {
        a(getContext(), i);
        this.f4789a = i2;
    }

    private void a(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i == 1) {
            gradientDrawable.setStroke(1, Color.parseColor("#C0C0C0"));
        }
        gradientDrawable.setCornerRadius(ap.a(context, 45.0f));
        setBackgroundDrawable(gradientDrawable);
    }

    private static int b(int i, int i2, a aVar, RectF rectF) {
        int i3 = i2 - 1;
        int i4 = i;
        while (i <= i3) {
            i4 = (i + i3) >>> 1;
            int iA = aVar.a(i4, rectF);
            if (iA >= 0) {
                if (iA <= 0) {
                    break;
                }
                i4--;
                i3 = i4;
            } else {
                int i5 = i4 + 1;
                i4 = i;
                i = i5;
            }
        }
        return i4;
    }

    public SkipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 20.0f;
        this.f = new RectF();
        this.i = true;
        this.k = new a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.a
            @TargetApi(16)
            public int a(int i2, RectF rectF) {
                SkipView.this.b.setTextSize(i2);
                String string = SkipView.this.getText().toString();
                SkipView.this.f.bottom = SkipView.this.b.getFontSpacing();
                SkipView.this.f.right = SkipView.this.b.measureText(string);
                SkipView.this.f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f) ? -1 : 1;
            }
        };
        init(context);
    }

    private void a() {
        a(getText().toString());
    }

    private void a(String str) {
        if (this.e) {
            int i = (int) this.d;
            int measuredHeight = ((getMeasuredHeight() - getCompoundPaddingBottom()) - getCompoundPaddingTop()) - this.f4789a;
            int measuredWidth = ((getMeasuredWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()) - ap.a(getContext(), 8.0f);
            this.h = measuredWidth;
            RectF rectF = this.g;
            rectF.right = measuredWidth;
            rectF.bottom = measuredHeight;
            super.setTextSize(0, a(i, (int) this.c, this.k, rectF));
        }
    }

    public SkipView(Context context) {
        super(context);
        this.d = 20.0f;
        this.f = new RectF();
        this.i = true;
        this.k = new a() { // from class: com.beizi.fusion.widget.SkipView.1
            @Override // com.beizi.fusion.widget.SkipView.a
            @TargetApi(16)
            public int a(int i2, RectF rectF) {
                SkipView.this.b.setTextSize(i2);
                String string = SkipView.this.getText().toString();
                SkipView.this.f.bottom = SkipView.this.b.getFontSpacing();
                SkipView.this.f.right = SkipView.this.b.measureText(string);
                SkipView.this.f.offsetTo(0.0f, 0.0f);
                return rectF.contains(SkipView.this.f) ? -1 : 1;
            }
        };
        init(context);
    }

    private int a(int i, int i2, a aVar, RectF rectF) {
        if (!this.i) {
            return b(i, i2, aVar, rectF);
        }
        String string = getText().toString();
        int length = string == null ? 0 : string.length();
        int i3 = this.j.get(length);
        if (i3 != 0) {
            return i3;
        }
        int iB = b(i, i2, aVar, rectF);
        this.j.put(length, iB);
        return iB;
    }
}
