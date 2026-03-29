package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class m1 {
    public static String a(Context context) {
        String str;
        String string;
        String str2 = "null_";
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        } catch (Throwable th) {
            try {
                str = "null_" + th.getMessage();
            } catch (Throwable unused) {
            }
        }
        if (!TextUtils.isEmpty(string)) {
            if (string.contains("/")) {
                str = string.split("/")[0];
            } else {
                str2 = string;
            }
            str2 = str;
        }
        StringBuilder sb = new StringBuilder(str2);
        try {
            Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                String str3 = context.getPackageManager().getApplicationInfo(packageName, 0).sourceDir;
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]");
                    sb.append(str3);
                }
            }
        } catch (Throwable unused2) {
        }
        return sb.toString();
    }

    public static String b(Context context) {
        String str;
        String string;
        String str2 = "null_";
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        } catch (Throwable th) {
            try {
                str = "null_" + th.getMessage();
            } catch (Throwable unused) {
            }
        }
        if (!TextUtils.isEmpty(string)) {
            if (string.contains("/")) {
                str = string.split("/")[0];
            } else {
                str2 = string;
            }
            str2 = str;
        }
        StringBuilder sb = new StringBuilder(str2);
        try {
            Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]");
                    sb.append(packageName);
                }
            }
        } catch (Throwable unused2) {
        }
        return sb.toString();
    }
}
