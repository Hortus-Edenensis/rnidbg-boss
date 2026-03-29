package com.zenmen.palmchat.utils.urlspan;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Patterns;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.net.MailTo;
import com.zenmen.palmchat.utils.urlspan.MyUrlSpan;
import defpackage.cw;
import defpackage.g33;
import defpackage.ir5;
import defpackage.vl1;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f15776a = {"http://", "https://", "rtsp://"};
    public static final e b = new C1126a();
    public static final e c = new b();
    public static final f d = new c();
    public static final Pattern e = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp|ftp|Ftp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9]([a-zA-Z0-9\\-\\_]{0,61}[a-zA-Z0-9]){0,1}\\.)+[a-zA-Z]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)((?:\\/(?:(?:[a-zA-Z0-9 \\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))+[\\.\\=\\?\\/\\+\\)][a-zA-Z0-9:\\%\\#\\&\\-\\_\\.\\~]*)|(?:\\/(?:(?:[a-zA-Z0-9\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*))?(?:\\b|$|(?=[ -\ud7ff豈-﷏ﷰ-\uffef]))");
    public static final Pattern f = Pattern.compile("(\\([0-9]+\\)[\\- \\.]*)?([0-9][0-9\\- \\.]+[0-9]{5,})");

    /* JADX INFO: renamed from: com.zenmen.palmchat.utils.urlspan.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1126a implements e {
        @Override // com.zenmen.palmchat.utils.urlspan.a.e
        public final boolean a(CharSequence charSequence, int i, int i2) {
            return i == 0 || charSequence.charAt(i - 1) != '@';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements e {
        @Override // com.zenmen.palmchat.utils.urlspan.a.e
        public final boolean a(CharSequence charSequence, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                if (Character.isDigit(charSequence.charAt(i)) && (i3 = i3 + 1) >= 5) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements f {
        @Override // com.zenmen.palmchat.utils.urlspan.a.f
        public final String a(Matcher matcher, String str) {
            return Patterns.digitsAndPlusOnly(matcher);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Comparator<g33> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final int compare(g33 g33Var, g33 g33Var2) {
            int i;
            int i2;
            int i3 = g33Var.b;
            int i4 = g33Var2.b;
            if (i3 < i4) {
                return -1;
            }
            if (i3 <= i4 && (i = g33Var.c) >= (i2 = g33Var2.c)) {
                return i > i2 ? -1 : 0;
            }
            return 1;
        }

        @Override // java.util.Comparator
        public final boolean equals(Object obj) {
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        boolean a(CharSequence charSequence, int i, int i2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface f {
        String a(Matcher matcher, String str);
    }

    public static final void a(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        if ((movementMethod == null || !(movementMethod instanceof LinkMovementMethod)) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static final boolean b(Spannable spannable, int i, MyUrlSpan.a aVar, boolean z) {
        if (i == 0) {
            return false;
        }
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = uRLSpanArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(uRLSpanArr[length]);
        }
        ArrayList<g33> arrayList = new ArrayList();
        if ((i & 1) != 0) {
            e(arrayList, spannable, e, f15776a, b, null);
        }
        if ((i & 2) != 0) {
            e(arrayList, spannable, Patterns.EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, null, null);
        }
        if ((i & 4) != 0) {
            e(arrayList, spannable, f, new String[]{"tel:"}, null, null);
        }
        if ((i & 8) != 0) {
            f(arrayList, spannable);
        }
        h(arrayList);
        if (arrayList.size() == 0) {
            return false;
        }
        for (g33 g33Var : arrayList) {
            d(g33Var.f17643a, g33Var.b, g33Var.c, spannable, aVar, z);
        }
        return true;
    }

    public static final boolean c(TextView textView, int i, MyUrlSpan.a aVar, boolean z) {
        long jB;
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            if (!b((Spannable) text, i, aVar, z)) {
                return false;
            }
            a(textView);
            return true;
        }
        SpannableString spannableStringC = cw.b().c(text);
        if (TextUtils.isEmpty(spannableStringC)) {
            jB = ir5.b();
            spannableStringC = SpannableString.valueOf(text);
        } else {
            jB = 0;
        }
        if (!b(spannableStringC, i, aVar, z)) {
            return false;
        }
        a(textView);
        if (jB != 0 && ir5.e(jB) > vl1.l) {
            cw.b().e(text, spannableStringC);
        }
        textView.setText(spannableStringC);
        return true;
    }

    public static final void d(String str, int i, int i2, Spannable spannable, MyUrlSpan.a aVar, boolean z) {
        spannable.setSpan(new MyUrlSpan(str, aVar, z), i, i2, 33);
        spannable.setSpan(new UnderlineSpan(), i, i2, 33);
    }

    public static final void e(ArrayList<g33> arrayList, Spannable spannable, Pattern pattern, String[] strArr, e eVar, f fVar) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (eVar == null || eVar.a(spannable, iStart, iEnd)) {
                g33 g33Var = new g33();
                g33Var.f17643a = g(matcher.group(0), strArr, matcher, fVar);
                g33Var.b = iStart;
                g33Var.c = iEnd;
                arrayList.add(g33Var);
            }
        }
    }

    public static final void f(ArrayList<g33> arrayList, Spannable spannable) {
        int iIndexOf;
        String string = spannable.toString();
        int i = 0;
        while (true) {
            try {
                String strFindAddress = WebView.findAddress(string);
                if (strFindAddress != null && (iIndexOf = string.indexOf(strFindAddress)) >= 0) {
                    g33 g33Var = new g33();
                    int length = strFindAddress.length() + iIndexOf;
                    g33Var.b = iIndexOf + i;
                    i += length;
                    g33Var.c = i;
                    string = string.substring(length);
                    try {
                        g33Var.f17643a = "geo:0,0?q=" + URLEncoder.encode(strFindAddress, "UTF-8");
                        arrayList.add(g33Var);
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                return;
            } catch (UnsupportedOperationException | Exception | UnsatisfiedLinkError unused2) {
                return;
            }
        }
    }

    public static final String g(String str, String[] strArr, Matcher matcher, f fVar) {
        boolean z;
        if (fVar != null) {
            str = fVar.a(matcher, str);
        }
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                z = false;
                break;
            }
            String str2 = strArr[i];
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                String str3 = strArr[i];
                z = true;
                if (!str.regionMatches(false, 0, str3, 0, str3.length())) {
                    str = strArr[i] + str.substring(strArr[i].length());
                }
            } else {
                i++;
            }
        }
        if (z) {
            return str;
        }
        return strArr[0] + str;
    }

    public static final void h(ArrayList<g33> arrayList) {
        int i;
        Collections.sort(arrayList, new d());
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size - 1) {
            g33 g33Var = arrayList.get(i2);
            int i3 = i2 + 1;
            g33 g33Var2 = arrayList.get(i3);
            int i4 = g33Var.b;
            int i5 = g33Var2.b;
            if (i4 <= i5 && (i = g33Var.c) > i5) {
                int i6 = g33Var2.c;
                int i7 = (i6 > i && i - i4 <= i6 - i5) ? i - i4 < i6 - i5 ? i2 : -1 : i3;
                if (i7 != -1) {
                    arrayList.remove(i7);
                    size--;
                }
            }
            i2 = i3;
        }
    }
}
