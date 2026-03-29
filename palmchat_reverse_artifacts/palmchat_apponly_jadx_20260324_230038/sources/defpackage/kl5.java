package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.c;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class kl5 {
    public static String a(int i) {
        return i > 0 ? c.b().getResources().getString(i) : "";
    }

    public static String b(int i, Object... objArr) {
        return i > 0 ? String.format(Locale.getDefault(), c.b().getResources().getString(i), objArr) : "";
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str);
    }
}
