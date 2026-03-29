package defpackage;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.wifi.ad.core.config.EventParams;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ff7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f17524a;

    public static synchronized String a(ru6 ru6Var, Context context, String str, String str2) {
        String strA;
        try {
            String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
            strA = TextUtils.isEmpty(string) ? null : ta7.a(b(context), string, str);
            if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(strA)) {
                xt6.g(ru6Var, EventParams.KEY_PARAM_CP, "TriDesEncryptError", String.format("%s,%s", str, string));
            }
        } catch (Exception e) {
            w97.d(e);
        }
        return strA;
    }

    public static String b(Context context) {
        String packageName;
        if (TextUtils.isEmpty(f17524a)) {
            try {
                packageName = context.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                w97.d(th);
                packageName = "";
            }
            f17524a = (packageName + "0000000000000000000000000000").substring(0, 24);
        }
        return f17524a;
    }

    public static synchronized void c(ru6 ru6Var, Context context, String str, String str2) {
        try {
            String strC = ta7.c(b(context), str2, str);
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(strC)) {
                xt6.g(ru6Var, EventParams.KEY_PARAM_CP, "TriDesDecryptError", String.format("%s,%s", str, str2));
            }
            PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, strC).apply();
        } catch (Throwable th) {
            w97.d(th);
        }
    }
}
