package com.zenmen.palmchat.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.zenmen.palmchat.framework.R$drawable;
import com.zenmen.palmchat.framework.R$styleable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ClearEditText extends EditText implements View.OnFocusChangeListener, TextWatcher {
    private boolean isGray;
    private Drawable mClearDrawableNormal;
    private Drawable mClearDrawablePressed;
    private View.OnFocusChangeListener mExtraOnFocusChangeListener;
    private boolean mHasFoucs;

    public ClearEditText(Context context) {
        this(context, null);
    }

    private void init() {
        if (this.isGray) {
            Resources resources = getResources();
            int i = R$drawable.clear_search;
            this.mClearDrawableNormal = resources.getDrawable(i);
            this.mClearDrawablePressed = getResources().getDrawable(i);
        } else {
            Resources resources2 = getResources();
            int i2 = R$drawable.clear_search;
            this.mClearDrawableNormal = resources2.getDrawable(i2);
            this.mClearDrawablePressed = getResources().getDrawable(i2);
        }
        Drawable drawable = this.mClearDrawableNormal;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mClearDrawableNormal.getIntrinsicHeight());
        Drawable drawable2 = this.mClearDrawablePressed;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.mClearDrawablePressed.getIntrinsicHeight());
        setClearIconVisible(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        this.mHasFoucs = z;
        if (z) {
            setClearIconVisible(getText().length() > 0);
        } else {
            setClearIconVisible(false);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.mExtraOnFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(view, z);
        }
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.mHasFoucs) {
            setClearIconVisible(charSequence.length() > 0);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int iHeight = getCompoundDrawables()[2].getBounds().height();
            int height = (getHeight() - iHeight) / 2;
            boolean z = x > getWidth() - getTotalPaddingRight() && x < getWidth() - getPaddingRight();
            boolean z2 = y > height && y < height + iHeight;
            if (z && z2) {
                if (motionEvent.getAction() == 0) {
                    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearDrawablePressed, getCompoundDrawables()[3]);
                } else if (motionEvent.getAction() == 1) {
                    setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearDrawableNormal, getCompoundDrawables()[3]);
                    setText("");
                }
            } else if (motionEvent.getAction() == 1) {
                setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mClearDrawableNormal, getCompoundDrawables()[3]);
            }
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public void setClearDrawable(int i, int i2) {
        this.mClearDrawableNormal = getResources().getDrawable(i);
        this.mClearDrawablePressed = getResources().getDrawable(i2);
        Drawable drawable = this.mClearDrawableNormal;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mClearDrawableNormal.getIntrinsicHeight());
        Drawable drawable2 = this.mClearDrawablePressed;
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.mClearDrawablePressed.getIntrinsicHeight());
    }

    public void setClearIconVisible(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.mClearDrawableNormal : null, getCompoundDrawables()[3]);
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener == this) {
            super.setOnFocusChangeListener(onFocusChangeListener);
        } else {
            this.mExtraOnFocusChangeListener = onFocusChangeListener;
        }
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mExtraOnFocusChangeListener = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClearEditText);
            this.isGray = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ClearEditText_isGray, true);
            typedArrayObtainStyledAttributes.recycle();
        }
        init();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
