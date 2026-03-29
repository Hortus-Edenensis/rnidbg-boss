package com.opos.mobad.template.cmn;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.widget.TextView;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ad extends BaseTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f9358a;
    private CharSequence b;

    public ad(Context context) {
        super(context);
        this.f9358a = 0.2f;
        this.b = "";
    }

    private void a() {
        if (this.b == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < this.b.length()) {
            sb.append(("" + this.b.charAt(i)).toLowerCase());
            i++;
            if (i < this.b.length()) {
                sb.append(" ");
            }
        }
        SpannableString spannableString = new SpannableString(sb.toString());
        if (sb.toString().length() > 1) {
            for (int i2 = 1; i2 < sb.toString().length(); i2 += 2) {
                spannableString.setSpan(new ScaleXSpan((this.f9358a + 1.0f) / 10.0f), i2, i2 + 1, 33);
            }
        }
        super.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    @Override // android.widget.TextView
    public float getLetterSpacing() {
        return this.f9358a;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.b;
    }

    @Override // android.widget.TextView
    public void setLetterSpacing(float f) {
        this.f9358a = f;
        a();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.b = charSequence;
        a();
    }
}
