package com.zenmen.square.comment.widget;

import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.zenmen.square.comment.widget.RichTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16220a;
    public int b;

    public a(String str, int i, RichTextView.b bVar) {
        this.f16220a = str;
        this.b = i;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (this.f16220a.contains("tel:") && TextUtils.isDigitsOnly(this.f16220a.replace("tel:", ""))) {
            return;
        }
        TextUtils.isDigitsOnly(this.f16220a);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(this.b);
        textPaint.setUnderlineText(false);
    }
}
