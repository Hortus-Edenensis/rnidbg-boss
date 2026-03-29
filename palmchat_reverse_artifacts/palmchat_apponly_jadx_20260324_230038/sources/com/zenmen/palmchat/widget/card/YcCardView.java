package com.zenmen.palmchat.widget.card;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import defpackage.hp6;
import defpackage.jp6;
import defpackage.kp6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class YcCardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    private static final jp6 IMPL;
    private int endShadowColor;
    private final hp6 mCardViewDelegate;
    private boolean mCompatPadding;
    private final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    private final Rect mShadowBounds;
    private int mUserSetMinHeight;
    private int mUserSetMinWidth;
    private int startShadowColor;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements hp6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f16025a;

        public a() {
        }

        @Override // defpackage.hp6
        public Drawable getCardBackground() {
            return this.f16025a;
        }

        @Override // defpackage.hp6
        public boolean getPreventCornerOverlap() {
            return YcCardView.this.getPreventCornerOverlap();
        }

        @Override // defpackage.hp6
        public void setCardBackground(Drawable drawable) {
            this.f16025a = drawable;
            YcCardView.this.setBackgroundDrawable(drawable);
        }

        @Override // defpackage.hp6
        public void setMinWidthHeightInternal(int i, int i2) {
            if (i > YcCardView.this.mUserSetMinWidth) {
                YcCardView.super.setMinimumWidth(i);
            }
            if (i2 > YcCardView.this.mUserSetMinHeight) {
                YcCardView.super.setMinimumHeight(i2);
            }
        }

        @Override // defpackage.hp6
        public void setShadowPadding(int i, int i2, int i3, int i4) {
            YcCardView.this.mShadowBounds.set(i, i2, i3, i4);
            YcCardView ycCardView = YcCardView.this;
            YcCardView.super.setPadding(i + ycCardView.mContentPadding.left, i2 + YcCardView.this.mContentPadding.top, i3 + YcCardView.this.mContentPadding.right, i4 + YcCardView.this.mContentPadding.bottom);
        }
    }

    static {
        kp6 kp6Var = new kp6();
        IMPL = kp6Var;
        kp6Var.initStatic();
    }

    public YcCardView(Context context) {
        super(context);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new a();
        initialize(context, null, 0);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i) {
        int color;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.zenmen.palmchat.R.styleable.YcCardView, i, com.zenmen.palmchat.R.style.YcCardView);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            color = typedArrayObtainStyledAttributes.getColor(3, 0);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color2 = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color2, fArr);
            color = fArr[2] > 0.5f ? getResources().getColor(com.zenmen.palmchat.R.color.yc_cardview_light_background) : getResources().getColor(com.zenmen.palmchat.R.color.yc_cardview_dark_background);
        }
        int i2 = color;
        this.startShadowColor = typedArrayObtainStyledAttributes.getColor(14, 0);
        this.endShadowColor = typedArrayObtainStyledAttributes.getColor(13, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(4, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(6, 0.0f);
        this.mCompatPadding = typedArrayObtainStyledAttributes.getBoolean(8, false);
        this.mPreventCornerOverlap = typedArrayObtainStyledAttributes.getBoolean(7, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, 0);
        this.mContentPadding.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        this.mContentPadding.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        this.mContentPadding.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        this.mContentPadding.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.mUserSetMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        IMPL.g(this.mCardViewDelegate, context, i2, dimension, dimension2, f, this.startShadowColor, this.endShadowColor);
    }

    public float getCardElevation() {
        return IMPL.i(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.k(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.d(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        jp6 jp6Var = IMPL;
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(jp6Var.e(this.mCardViewDelegate)), View.MeasureSpec.getSize(i)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(jp6Var.b(this.mCardViewDelegate)), View.MeasureSpec.getSize(i2)), mode2);
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        IMPL.a(this.mCardViewDelegate, i);
    }

    public void setCardElevation(float f) {
        IMPL.m(this.mCardViewDelegate, f);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.c(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.h(this.mCardViewDelegate, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.j(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f) {
        IMPL.f(this.mCardViewDelegate, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.l(this.mCardViewDelegate);
        }
    }

    public YcCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new a();
        initialize(context, attributeSet, 0);
    }

    public YcCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new a();
        initialize(context, attributeSet, i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }
}
