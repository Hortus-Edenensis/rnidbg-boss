package com.zenmen.palmchat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ClearEditTextView extends EditText implements View.OnFocusChangeListener, TextWatcher {
    private Drawable mClearDrawable;

    public ClearEditTextView(Context context) {
        this(context, null);
    }

    private void init() {
        Drawable drawable = getResources().getDrawable(R.drawable.ic_closed);
        this.mClearDrawable = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mClearDrawable.getIntrinsicHeight());
        setClearIcon(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    private void setClearIcon(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.mClearDrawable : null, getCompoundDrawables()[3]);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            setClearIcon(getText().length() > 0);
        } else {
            setClearIcon(false);
        }
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        setClearIcon(charSequence.length() > 0);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getCompoundDrawables()[2] != null) {
            if (motionEvent.getAction() == 1) {
                boolean z = motionEvent.getX() > ((float) ((getWidth() - getPaddingRight()) - this.mClearDrawable.getIntrinsicWidth())) && motionEvent.getX() < ((float) (getWidth() - getPaddingRight()));
                boolean z2 = motionEvent.getY() > ((float) ((getHeight() - this.mClearDrawable.getIntrinsicHeight()) / 2)) && motionEvent.getY() < ((float) ((getHeight() + this.mClearDrawable.getIntrinsicHeight()) / 2));
                if (z && z2) {
                    setText("");
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public ClearEditTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.editTextStyle);
    }

    public ClearEditTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
