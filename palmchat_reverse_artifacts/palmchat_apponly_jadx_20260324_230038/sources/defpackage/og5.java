package defpackage;

import android.text.SpannableStringBuilder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class og5 extends SpannableStringBuilder {
    public og5() {
        super("");
    }

    public og5 a(int i, Object obj, int i2) {
        setSpan(obj, i, length(), i2);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public og5 append(CharSequence charSequence) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        return (og5) replace(length, length, charSequence, 0, charSequence.length());
    }

    @Override // android.text.SpannableStringBuilder
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public og5 append(CharSequence charSequence, Object obj, int i) {
        if (charSequence == null) {
            return this;
        }
        int length = length();
        append(charSequence);
        setSpan(obj, length, length(), i);
        return this;
    }

    public og5(CharSequence charSequence) {
        super(charSequence, 0, charSequence.length());
    }
}
