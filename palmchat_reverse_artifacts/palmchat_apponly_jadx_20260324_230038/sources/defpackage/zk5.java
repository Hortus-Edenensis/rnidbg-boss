package defpackage;

import android.widget.EditText;
import android.widget.TextView;
import com.zenmen.palmchat.c;
import com.zenmen.square.comment.widget.RichEditText;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zk5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DecimalFormat f22441a = new DecimalFormat("$#.###");
    public static DecimalFormat b = new DecimalFormat("#.#");
    public static DecimalFormat c = new DecimalFormat("#.##");

    public static final String a(float f) {
        return c.format(f);
    }

    public static String b(int i) {
        return c.b().getResources().getString(i);
    }

    public static int c(String str) {
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

    public static boolean d(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static boolean e(String str, String str2) {
        return str == null ? str2 == null : str.equalsIgnoreCase(str2);
    }

    public static String f(long j) {
        if (j < 10000) {
            return String.valueOf(j);
        }
        if (j < 100000000) {
            return b.format(j / 10000.0f) + "W";
        }
        return b.format((j * 1.0f) / 1.0E8f) + "亿";
    }

    public static int g(EditText editText, CharSequence charSequence, int i, TextView textView, boolean z) {
        WeakReference weakReference = new WeakReference(editText);
        if (weakReference.get() == null) {
            return 0;
        }
        int iC = charSequence != null ? c(charSequence.toString().trim()) : 0;
        rl1 rl1Var = new rl1();
        if (iC > i) {
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
        if (weakReference2.get() != null && iC <= i) {
            if (z) {
                ((TextView) weakReference2.get()).setText(((int) Math.floor(i - iC)) + "");
            } else {
                ((TextView) weakReference2.get()).setText(((int) Math.floor(((double) (i - iC)) * 0.5d)) + "");
            }
        }
        return iC;
    }

    public static int h(RichEditText richEditText, CharSequence charSequence, int i, TextView textView, boolean z) {
        WeakReference weakReference = new WeakReference(richEditText);
        if (weakReference.get() == null) {
            return 0;
        }
        int iC = charSequence != null ? c(charSequence.toString()) : 0;
        rl1 rl1Var = new rl1();
        if (iC > i) {
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
            ((RichEditText) weakReference.get()).setEmojiText(sb.toString());
            ((RichEditText) weakReference.get()).setSelection(((RichEditText) weakReference.get()).getText().length());
        }
        WeakReference weakReference2 = new WeakReference(textView);
        if (weakReference2.get() != null && iC <= i) {
            if (z) {
                ((TextView) weakReference2.get()).setText(((int) Math.floor(i - iC)) + "");
            } else {
                ((TextView) weakReference2.get()).setText(((int) Math.floor(((double) (i - iC)) * 0.5d)) + "");
            }
        }
        return iC;
    }
}
