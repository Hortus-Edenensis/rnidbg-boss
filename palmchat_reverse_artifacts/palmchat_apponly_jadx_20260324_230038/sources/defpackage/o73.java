package defpackage;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class o73 {
    public static SpannableStringBuilder a(String str, String str2, String str3, ClickableSpan clickableSpan) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(str2);
        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(str3);
        StyleSpan styleSpan = new StyleSpan(1);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#222222"));
        spannableStringBuilder2.setSpan(styleSpan, 0, str.length(), 33);
        spannableStringBuilder2.setSpan(foregroundColorSpan, 0, str.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(Color.parseColor("#666666")), 0, str2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
        spannableStringBuilder4.setSpan(clickableSpan, 0, str3.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder4);
        return spannableStringBuilder;
    }
}
