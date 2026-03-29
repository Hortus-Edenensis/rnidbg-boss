package com.zenmen.palmchat.ui.widget.span;

import android.os.Parcel;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class UrlSpanEx extends URLSpan {
    int color;
    private View.OnClickListener mOnClickListener;

    public UrlSpanEx(String str) {
        super(str);
        this.color = -1;
    }

    public View.OnClickListener getOnClickListener() {
        return this.mOnClickListener;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        } else {
            super.onClick(view);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i = this.color;
        if (i != -1) {
            textPaint.setColor(i);
        }
        textPaint.setUnderlineText(false);
    }

    public UrlSpanEx(Parcel parcel) {
        super(parcel);
        this.color = -1;
    }

    public UrlSpanEx(String str, int i) {
        super(str);
        this.color = i;
    }

    public UrlSpanEx(String str, int i, View.OnClickListener onClickListener) {
        super(str);
        this.color = i;
        this.mOnClickListener = onClickListener;
    }

    public UrlSpanEx(Parcel parcel, int i) {
        super(parcel);
        this.color = i;
    }
}
