package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.cordovaNew.PermissionDialogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class r75 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicInteger f20410a = new AtomicInteger(-1);
    public static AtomicInteger b = new AtomicInteger(-1);

    public static void a(Context context) {
        j(context).edit().clear().apply();
    }

    public static boolean b(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences("wifi_social_appstatus", 4).getBoolean(str, z);
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    public static boolean c(Context context, String str) {
        return d(context, str, false);
    }

    public static boolean d(Context context, String str, boolean z) {
        SharedPreferences sharedPreferencesJ = j(context);
        return sharedPreferencesJ != null ? sharedPreferencesJ.getBoolean(str, z) : z;
    }

    public static int e(Context context, String str) {
        SharedPreferences sharedPreferencesJ = j(context);
        if (sharedPreferencesJ != null) {
            return sharedPreferencesJ.getInt(str, 2);
        }
        return 2;
    }

    public static int f(Context context, String str) {
        SharedPreferences sharedPreferencesJ = j(context);
        if (sharedPreferencesJ != null) {
            return sharedPreferencesJ.getInt(str, 0);
        }
        return 0;
    }

    public static int g(Context context, String str, int i) {
        SharedPreferences sharedPreferencesJ = j(context);
        return sharedPreferencesJ != null ? sharedPreferencesJ.getInt(str, i) : i;
    }

    public static long h(Context context, String str) {
        SharedPreferences sharedPreferencesJ = j(context);
        if (sharedPreferencesJ != null) {
            return sharedPreferencesJ.getLong(str, 0L);
        }
        return 0L;
    }

    public static String i(Context context, String str) {
        SharedPreferences sharedPreferencesJ = j(context);
        return sharedPreferencesJ != null ? sharedPreferencesJ.getString(str, "") : "";
    }

    public static SharedPreferences j(Context context) {
        try {
            return context.getSharedPreferences(PermissionDialogUtil.SP_NAME, 4);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean k() {
        boolean zB;
        if (f20410a.get() == -1) {
            try {
                zB = b(c.b(), "isAppExit", false);
            } catch (Exception e) {
                e.printStackTrace();
                zB = 0;
            }
            f20410a.set(!zB);
        }
        return f20410a.get() == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.concurrent.atomic.AtomicInteger] */
    public static boolean l() {
        ?? C;
        if (b.get() == -1) {
            try {
                C = c(c.b(), "sp_privacy_agree");
            } catch (Exception e) {
                e.printStackTrace();
                C = 0;
            }
            b.set(C);
        }
        return b.get() == 1;
    }

    public static void m(Context context) {
        for (Map.Entry<String, ?> entry : j(context).getAll().entrySet()) {
            LogUtil.i("SP", "printAll key=" + entry.getKey() + " value=" + entry.getValue());
        }
    }

    public static void n(Context context, String str, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("wifi_social_appstatus", 4).edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void o(Context context, String str, boolean z) {
        SharedPreferences sharedPreferencesJ = j(context);
        if (sharedPreferencesJ != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesJ.edit();
            editorEdit.putBoolean(str, z);
            editorEdit.apply();
        }
    }

    public static void p(Context context, String str, int i) {
        SharedPreferences sharedPreferencesJ = j(context);
        if (sharedPreferencesJ != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesJ.edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        }
    }

    public static void q(Context context, String str, long j) {
        SharedPreferences sharedPreferencesJ = j(context);
        if (sharedPreferencesJ != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesJ.edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
        }
    }

    public static void r(Context context, String str, String str2) {
        SharedPreferences sharedPreferencesJ = j(context);
        if (sharedPreferencesJ != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesJ.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        }
    }

    public static void s(boolean z) {
        try {
            n(c.b(), "isAppExit", z);
        } catch (Exception e) {
            e.printStackTrace();
        }
        f20410a.set(!z ? 1 : 0);
    }

    public static void t() {
        try {
            o(c.b(), "sp_privacy_agree", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        b.set(1);
    }
}
