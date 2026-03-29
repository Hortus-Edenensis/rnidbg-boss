package com.opos.exoplayer.core.text.ttml;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.baidu.mapapi.http.HttpClient;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class d {
    public static TtmlStyle a(TtmlStyle ttmlStyle, String[] strArr, Map<String, TtmlStyle> map) {
        if (ttmlStyle == null && strArr == null) {
            return null;
        }
        int i = 0;
        if (ttmlStyle == null && strArr.length == 1) {
            return map.get(strArr[0]);
        }
        if (ttmlStyle == null && strArr.length > 1) {
            TtmlStyle ttmlStyle2 = new TtmlStyle();
            int length = strArr.length;
            while (i < length) {
                ttmlStyle2.a(map.get(strArr[i]));
                i++;
            }
            return ttmlStyle2;
        }
        if (ttmlStyle != null && strArr != null && strArr.length == 1) {
            return ttmlStyle.a(map.get(strArr[0]));
        }
        if (ttmlStyle != null && strArr != null && strArr.length > 1) {
            int length2 = strArr.length;
            while (i < length2) {
                ttmlStyle.a(map.get(strArr[i]));
                i++;
            }
        }
        return ttmlStyle;
    }

    public static String a(String str) {
        return str.replaceAll(HttpClient.NEWLINE, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void a(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, TtmlStyle ttmlStyle) {
        Object absoluteSizeSpan;
        if (ttmlStyle.a() != -1) {
            spannableStringBuilder.setSpan(new StyleSpan(ttmlStyle.a()), i, i2, 33);
        }
        if (ttmlStyle.b()) {
            spannableStringBuilder.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (ttmlStyle.c()) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (ttmlStyle.f()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ttmlStyle.e()), i, i2, 33);
        }
        if (ttmlStyle.h()) {
            spannableStringBuilder.setSpan(new BackgroundColorSpan(ttmlStyle.g()), i, i2, 33);
        }
        if (ttmlStyle.d() != null) {
            spannableStringBuilder.setSpan(new TypefaceSpan(ttmlStyle.d()), i, i2, 33);
        }
        if (ttmlStyle.j() != null) {
            spannableStringBuilder.setSpan(new AlignmentSpan.Standard(ttmlStyle.j()), i, i2, 33);
        }
        int iK = ttmlStyle.k();
        if (iK == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) ttmlStyle.l(), true);
        } else if (iK == 2) {
            absoluteSizeSpan = new RelativeSizeSpan(ttmlStyle.l());
        } else if (iK != 3) {
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(ttmlStyle.l() / 100.0f);
        }
        spannableStringBuilder.setSpan(absoluteSizeSpan, i, i2, 33);
    }
}
