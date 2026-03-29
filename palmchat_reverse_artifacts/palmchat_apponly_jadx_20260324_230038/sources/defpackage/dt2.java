package defpackage;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class dt2 {
    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int b(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int iCodePointAt = Character.codePointAt(str, i2);
            i = (iCodePointAt < 0 || iCodePointAt > 255) ? i + 2 : i + 1;
        }
        return i;
    }

    public static boolean c(String str, CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        return Pattern.matches(str, charSequence);
    }

    public static int d(EditText editText, CharSequence charSequence, int i) {
        return e(editText, charSequence, i, null, false);
    }

    public static int e(EditText editText, CharSequence charSequence, int i, TextView textView, boolean z) {
        WeakReference weakReference = new WeakReference(editText);
        if (weakReference.get() == null) {
            return 0;
        }
        int iB = charSequence != null ? b(charSequence.toString()) : 0;
        rl1 rl1Var = new rl1();
        if (iB > i) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= charSequence.length()) {
                    break;
                }
                int iCodePointAt = Character.codePointAt(charSequence, i2);
                i3 = (iCodePointAt < 0 || iCodePointAt > 255) ? i3 + 2 : i3 + 1;
                if (i3 <= i) {
                    sb.append(charSequence.charAt(i2));
                    i2++;
                } else {
                    int i4 = i2 - 1;
                    if (rl1Var.d(String.valueOf(new char[]{charSequence.charAt(i4), charSequence.charAt(i2)}))) {
                        sb.deleteCharAt(i4);
                    }
                }
            }
            ((EditText) weakReference.get()).setText(sb.toString());
            ((EditText) weakReference.get()).setSelection(((EditText) weakReference.get()).getText().length());
        }
        WeakReference weakReference2 = new WeakReference(textView);
        if (weakReference2.get() != null && iB <= i) {
            if (z) {
                ((TextView) weakReference2.get()).setText(((int) Math.floor(i - iB)) + "");
            } else {
                ((TextView) weakReference2.get()).setText(((int) Math.floor(((double) (i - iB)) * 0.5d)) + "");
            }
        }
        return iB;
    }
}
