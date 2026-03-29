package com.afollestad.materialdialogs.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.R$dimen;
import defpackage.ed1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class MDButton extends TextView {
    private Drawable mDefaultBackground;
    private boolean mStacked;
    private Drawable mStackedBackground;
    private int mStackedEndPadding;
    private GravityEnum mStackedGravity;

    public MDButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStacked = false;
        init(context, attributeSet, 0, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mStackedEndPadding = context.getResources().getDimensionPixelSize(R$dimen.md_dialog_frame_margin);
        this.mStackedGravity = GravityEnum.END;
    }

    public void setAllCapsCompat(boolean z) {
        setAllCaps(z);
    }

    public void setDefaultSelector(Drawable drawable) {
        this.mDefaultBackground = drawable;
        if (this.mStacked) {
            return;
        }
        setStacked(false, true);
    }

    public void setStacked(boolean z, boolean z2) {
        if (this.mStacked != z || z2) {
            setGravity(z ? this.mStackedGravity.getGravityInt() | 16 : 17);
            setTextAlignment(z ? this.mStackedGravity.getTextAlignment() : 4);
            ed1.o(this, z ? this.mStackedBackground : this.mDefaultBackground);
            if (z) {
                setPadding(this.mStackedEndPadding, getPaddingTop(), this.mStackedEndPadding, getPaddingBottom());
            }
            this.mStacked = z;
        }
    }

    public void setStackedGravity(GravityEnum gravityEnum) {
        this.mStackedGravity = gravityEnum;
    }

    public void setStackedSelector(Drawable drawable) {
        this.mStackedBackground = drawable;
        if (this.mStacked) {
            setStacked(true, true);
        }
    }

    public MDButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStacked = false;
        init(context, attributeSet, i, 0);
    }

    @TargetApi(21)
    public MDButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mStacked = false;
        init(context, attributeSet, i, i2);
    }
}
