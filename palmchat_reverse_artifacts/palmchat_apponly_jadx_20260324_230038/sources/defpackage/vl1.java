package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ReplacementSpan;
import android.util.Log;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class vl1 {
    public static int c = me1.b(c.b(), 15);
    public static int d = me1.b(c.b(), 16);
    public static int e = me1.b(c.b(), 20);
    public static int f = me1.b(c.b(), 18);
    public static int g = me1.b(c.b(), 30);
    public static int h = me1.b(c.b(), 14);
    public static int i = me1.b(c.b(), 15);
    public static int j = me1.b(c.b(), 14);
    public static int k = 10;
    public static int l = 3;
    public static int m = 300;
    public static String n = "[emoji_delete]";
    public static vl1 o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMap<String, String> f21473a = new LinkedHashMap<>();
    public LinkedHashMap<String, String> b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends ReplacementSpan {
        public static final int c = me1.b(c.b(), 1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable f21474a;
        public final int b;

        public a(Drawable drawable, int i) {
            this.f21474a = drawable;
            this.b = i;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            canvas.save();
            int i6 = this.b;
            if (i6 == 0) {
                i4 = i5;
            } else if (100 == i6) {
                i4 = i5 - ((i5 - i4) / 2);
            }
            canvas.translate(f + c, i4 - this.f21474a.getBounds().bottom);
            this.f21474a.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
            Rect bounds = this.f21474a.getBounds();
            if (fontMetricsInt != null) {
                int i3 = -bounds.bottom;
                fontMetricsInt.ascent = i3;
                fontMetricsInt.descent = 0;
                fontMetricsInt.top = i3;
                fontMetricsInt.bottom = 0;
            }
            return bounds.right + (c * 2);
        }
    }

    public vl1() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        this.b = linkedHashMap;
        k(this.f21473a, linkedHashMap, "smile_recognizer.txt");
    }

    public static boolean a(String str) {
        return g().b(str);
    }

    public static SpannableString c(CharSequence charSequence, Context context, int i2) {
        return g().d(charSequence, context, i2);
    }

    public static LinkedHashMap<String, String> e() {
        return g().b;
    }

    public static LinkedHashMap<String, String> f() {
        return g().f21473a;
    }

    public static vl1 g() {
        if (o == null) {
            synchronized (vl1.class) {
                if (o == null) {
                    o = new vl1();
                }
            }
        }
        return o;
    }

    public static int h(String str) {
        return g().i(str);
    }

    public final boolean b(String str) {
        Iterator<Map.Entry<String, String>> it = e().entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final SpannableString d(CharSequence charSequence, Context context, int i2) {
        int iH;
        if (charSequence == null) {
            return null;
        }
        if (e().size() <= 0) {
            return new SpannableString(charSequence);
        }
        String str = ((Object) charSequence) + String.valueOf(i2);
        SpannableString spannableStringA = bw.b().a(str);
        if (!TextUtils.isEmpty(spannableStringA)) {
            return spannableStringA;
        }
        SpannableString spannableString = new SpannableString(charSequence);
        String string = charSequence.toString();
        long jB = ir5.b();
        int i3 = m;
        int i4 = 0;
        while (i4 < string.length()) {
            int iIndexOf = string.indexOf("[", i4);
            int iIndexOf2 = string.indexOf("]", iIndexOf + 1);
            if (iIndexOf == -1 || iIndexOf2 == -1) {
                break;
            }
            int i5 = iIndexOf2 + 1;
            String strSubstring = string.substring(iIndexOf, i5);
            int iLastIndexOf = strSubstring.lastIndexOf("[");
            if (iLastIndexOf > 0) {
                iIndexOf += iLastIndexOf;
                strSubstring = strSubstring.substring(iLastIndexOf);
            }
            String str2 = e().get(strSubstring);
            if (str2 != null && (iH = h(str2)) > 0 && i3 > 0) {
                try {
                    Drawable drawable = context.getResources().getDrawable(iH);
                    if (drawable != null) {
                        drawable.setBounds(0, 0, i2, i2);
                        spannableString.setSpan(new a(drawable, 100), iIndexOf, i5, 33);
                    }
                    i3--;
                } catch (OutOfMemoryError unused) {
                }
            }
            i4 = iIndexOf2;
        }
        if (ir5.e(jB) > k) {
            bw.b().c(str, spannableString);
        }
        return spannableString;
    }

    public final int i(String str) {
        try {
            return c.b().getResources().getIdentifier(str, "drawable", c.b().getPackageName());
        } catch (Exception unused) {
            LogUtil.d("EmojiHandler", "faild to get resource ID !");
            return 0;
        }
    }

    public final void j(String str, LinkedHashMap<String, String> linkedHashMap) {
        String[] strArrSplit = Pattern.compile("[,]+").split(str);
        if (strArrSplit.length < 2) {
            return;
        }
        for (String str2 : strArrSplit) {
            String[] strArrSplit2 = Pattern.compile("[:]+").split(str2);
            String str3 = strArrSplit2[1];
            linkedHashMap.put("[" + strArrSplit2[0] + "]", str3.substring(1, str3.length() - 1));
        }
        Log.i("EmojiHandler", linkedHashMap.toString());
    }

    public final void k(LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, String str) {
        try {
            InputStream inputStreamOpen = c.b().getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    stringBuffer.append(line);
                }
            }
            String[] strArrSplit = stringBuffer.toString().split("---");
            if (Locale.getDefault().getLanguage().contains("en")) {
                j(strArrSplit[1], linkedHashMap);
            } else {
                j(strArrSplit[0], linkedHashMap);
            }
            j(strArrSplit[0] + strArrSplit[1], linkedHashMap2);
            bufferedReader.close();
            inputStreamOpen.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
